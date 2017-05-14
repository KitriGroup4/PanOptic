package com.kitri.admin.database.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.kitri.admin.database.dto.ComDto;

public class ComDao extends Dao {
//    private Dao dao;
    
    public ComDao() {
	
    }
    
    public ArrayList<ComDto> selectAll(){
	ArrayList<ComDto> dtos = new ArrayList<>();
	
	try {
	    con = getConnection();
	    stmt = con.createStatement();
	    rs = stmt.executeQuery("select * from com");
	    
	    ComDto dto;
	    while(rs.next()){
		dto = new ComDto();
		dto.setComNum(rs.getInt("com_num"));
		dto.setUserNum(rs.getInt("user_num"));
		dto.setIsUse(rs.getInt("is_use"));
		dto.setIsBooking(rs.getInt("is_booking"));
		
		dtos.add(dto);
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    resetStmt();
	}
	
	return dtos;
    }
    
    public boolean insert(int comNum, int userNum) {
	int result = 0;
	
	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("insert into com(com_num, user_num) values(?,?)");
	    preStmt.setInt(1, comNum);
	    preStmt.setInt(2, userNum);
	    
	    result = preStmt.executeUpdate();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    resetPreStmt();
	}
	
	return result == 0 ? false : true;
    }
    
    public static void main(String[] args) {
	ComDao dao = new ComDao();
	
//	System.out.println(Arrays.toString(dao.selectAllCom().toArray()));	
////	dao.insertCom(4, 4);
//	System.out.println(Arrays.toString(dao.selectAllCom().toArray()));
    }
}
