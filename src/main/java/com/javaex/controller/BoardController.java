package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.BoardDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.BoardVo;


@WebServlet("/brc")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("brc");
		
		String action = request.getParameter("action");

		if ("list".equals(action)) {
			System.out.println("list");
			
			BoardDao boardDao = new BoardDao();
			List<BoardVo> guestList = boardDao.boardSelect("");

			// request data를 넣는다
			request.setAttribute("bList", guestList);
		
			WebUtil.forword(request, response, "/WEB-INF/views/board/list.jsp");

		} else if ("read".equals(action)) {
			System.out.println("read");
			
		} else if ("delete".equals(action)) {
			System.out.println("delete");
			
		
		} else {
			System.out.println("나머지");
		}

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
