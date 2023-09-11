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
			query += " select  bo.no, ";
			query += "         bo.title, ";
			query += "         bo.content, ";
			query += "         bo.hit, ";
			query += "         bo.reg_date, ";
			query += "         bo.user_no, ";
			query += "         us.name ";
			query += " FROM board bo, users us ";
			query += " where bo.user_no = us.no ";
			/**********************************************************************/
			if(!keyword.equals("")) { //keyword가 ""가 아니면 ==> keyword가 있으면 검색
				query += " and where name like ? ";
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

				int no = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				int hit = rs.getInt(4);
				String regDate = rs.getString(5);
				int user_no = rs.getInt(6);
				String name = rs.getString(7);

				BoardVo boardVo = new BoardVo(no, title, content, hit, regDate, user_no, name);

				boardList.add(boardVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return boardList;

	}
	
	
	
	
	
	
	
}
