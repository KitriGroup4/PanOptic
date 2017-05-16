package com.kitri.admin.main.controlPanel.BlockedSites;

import java.sql.*;
import java.util.Vector;

public class BSDb {

	public String query;

	public Connection conn = null;
	public Statement stmt = null;
	public ResultSet rs = null;

	Vector<String> rowData;// = new Vector<String>();
	Vector<Vector> rows = new Vector<Vector>();

	public BSDb() {
		//rowData = new Vector<String>();
		
		rows = new Vector<Vector>();
		
		query = "SELECT * FROM blockedsites order by blocked_site_num";
		
		try {
			// 드라이버를 로딩한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// 데이터베이스의 연결을 설정한다.
			conn = DriverManager.getConnection(
					BSConstant.DB_URL, BSConstant.DB_USER, BSConstant.DB_PASSWORD);

			// Statement를 가져온다.
			stmt = conn.createStatement();

			// SQL문을 실행한다.
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				// String blockedSiteNum = dao.dto.rs.getString(1);
				// String blockedSiteUrl = dao.dto.rs.getString(2);
				// blockedSiteName = dao.dto.rs.getString(3);
				rowData = new Vector<String>();
				rowData.add(rs.getString(1));
				rowData.add(rs.getString(2));
				rowData.add(rs.getString(3));
				rows.add(rowData);
				System.out.println(rowData);
				System.out.println(rows);
				System.out.println();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// ResultSet를 닫는다.
				rs.close();
				// Statement를 닫는다.
				stmt.close();
				// Connection를 닫는다.
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
