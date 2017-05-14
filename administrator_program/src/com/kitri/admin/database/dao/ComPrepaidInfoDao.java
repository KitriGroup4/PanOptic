package com.kitri.admin.database.dao;

import java.util.ArrayList;

import com.kitri.admin.database.dto.ComPrepaidInfoDto;

public class ComPrepaidInfoDao extends Dao {
    
    public ArrayList<ComPrepaidInfoDto> selectAll() {
	ArrayList<ComPrepaidInfoDto> dtos = new ArrayList<>();

	try {
	    con = getConnection();
	    stmt = con.createStatement();
	    rs = stmt.executeQuery("select * from com_prepaid_info");

	    ComPrepaidInfoDto dto;
	    while (rs.next()) {
		dto = new ComPrepaidInfoDto();
		dto.setPrepaidNum(rs.getInt(1));
		dto.setPrepaidTime(rs.getFloat(2));
		dto.setPrepaidPrice(rs.getInt(3));
		
		dtos.add(dto);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    resetStmt();
	}

	return dtos;
    }
    
    public boolean insert(int num, float time, int price) {
   	int result = 0;

   	try {
   	    con = getConnection();
   	    preStmt = con.prepareStatement(
   		    "insert into com_prepaid_info values(?,?,?)");
   	    preStmt.setInt(1, num);
   	    preStmt.setFloat(2, time);
   	    preStmt.setInt(3, price);
   	    
   	    result = preStmt.executeUpdate();

   	} catch (Exception e) {
   	    e.printStackTrace();
   	} finally {
   	    resetPreStmt();
   	}

   	return result == 0 ? false : true;

       }
}
