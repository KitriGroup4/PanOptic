package com.kitri.admin.main.controlPanel.BlockedSites;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import com.kitri.admin.database.dao.Dao;

public class BSDaoServiceImpl extends Dao implements BSDaoService {

	public BSDto dto;
	public BSListFrame bsListFrame;
//	Vector<BSDto> dtos = new Vector<BSDto>();
	Vector<String> rowData;
	Vector<Vector> rows = new Vector<Vector>(); 
	
	public BSDaoServiceImpl () {}

	public BSDaoServiceImpl (BSListFrame bsListFrame) {
		this.bsListFrame = bsListFrame;
	}
	
	public Vector<Vector> selectAll() {
		String query = "SELECT * FROM blockedsites order by blocked_site_num";

		try {
			// 데이터베이스의 연결을 설정한다.
			con = getConnection();
			// Statement를 가져온다.
			stmt = con.createStatement();
			// SQL문을 실행한다.
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				rowData = new Vector<String>();
				rowData.add(rs.getString(1));
				rowData.add(rs.getString(2));
				rowData.add(rs.getString(3));
				
//				dto = new BSDto();
//				dto.setBlockedsite_num(rs.getInt(1));
//				dto.setBlockedsite_url(rs.getString(2));
//				dto.setBlockedsite_name(rs.getString(3));

				rows.add(rowData);
//				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return rows;
//		return dtos;
	}

	public boolean insert(String url, String name) {
		int result = 0;
		String query = ("insert into blockedsites(blockedsite_num, blockedsite_url, blockedsite_name)"
				+ "values(blockedsites_seq.nextval, ?, ?)");
		try {
			con = getConnection();
			preStmt = con.prepareStatement(query);
			preStmt.setString(1, url);
			preStmt.setString(2, name);
			result = preStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resetPreStmt();
		}
		return result == 0 ? false : true;
	}

	public boolean update(BSDto dto) {
		boolean result = false;
		try {			
			con = getConnection();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			preStmt = con.prepareStatement("update blockedsites set blockedsite_num = blockedsites_seq.nextval, blockedsite_url =? , blockedsite_name = ?");
							
			preStmt.setString(1, dto.getBlockedsite_url());
			preStmt.setString(2, dto.getBlockedsite_name());
			
			int row = preStmt.executeUpdate();
			if (row > 0)
				result = true;

			con.commit(); // 문장 수행이 끝났으면 commit 시킨다.

		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			} // error가 발생하면 rollback 시킨다.
		} finally {
			try {
				con.setAutoCommit(true);
			} catch (Exception e) {
				e.printStackTrace();
			} // 다른 프로그램을 위해 auto commit을 true로 세팅
			resetStmt();
		}
		return result;
	}

	public boolean deleteBSDto (String name) {
		boolean result = false;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			rs = stmt.executeQuery("delete from blockedsites where blockedsite_name = ?");
			preStmt.setString(1, name);

			int row = preStmt.executeUpdate();
			if (row > 0)
				result = true;

			con.commit(); // 문장 수행이 끝났으면 commit 시킨다.
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			} // error가 발생하면 rollback 시킨다.
		} finally {
			try {
				con.setAutoCommit(true);
			} catch (Exception e) {
				e.printStackTrace();
			} // 다른 프로그램을 위해 auto commit을 true로 세팅
			resetStmt();
		}
		return result;
	}

	public BSDaoServiceImpl getBSDao (String name) {
		BSDaoServiceImpl dao=null;
		
		try {
			con = getConnection();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from blockedsites where blockedsite_name = ?");
			preStmt.setString(1, name);

			if (rs.next())
				dto = new BSDto (rs.getInt("num"), rs.getString("url"), rs.getString("name"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				try {
					con.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			resetStmt();
		}
		return dao;
	}
}