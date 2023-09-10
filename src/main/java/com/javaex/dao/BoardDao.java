package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.BoardVo;

public class BoardDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";

	public BoardDao() {
	}

	// 메소드 일반
	private void getConnect() {

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	
	
	// 게시판 리스트 수정중
	public List<BoardVo> boardSelect(String keyword) {

		List<BoardVo> boardList = new ArrayList<BoardVo>();

		this.getConnect();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " select  num ";
			query += "         ,title ";
			query += "         ,id ";
			query += "         ,content ";
			query += "         ,views ";
			query += "         ,reg_date ";
			query += " from boardbook ";
			/**********************************************************************/
			if(!keyword.equals("")) { //keyword가 ""가 아니면 ==> keyword가 있으면 검색
				query += " where name like ? ";
			}
			
			pstmt = conn.prepareStatement(query);

			// 바인딩**********************************************************************
			if(!keyword.equals("")) { //keyword가 ""가 아니면 ==> keyword가 있으면 검색
				pstmt.setString(1, "%"+keyword+"%");
			}

			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {

				int num = rs.getInt(1);
				String title = rs.getString(2);
				String id = rs.getString(3);
				String content = rs.getString(4);
				int views = rs.getInt(5);
				String regDate = rs.getString(6);

				BoardVo boardVo = new BoardVo(num, title, id, content, views, regDate);

				boardList.add(boardVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return boardList;

	}
	
	
	
}
