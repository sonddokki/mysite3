package com.javaex.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.util.WebUtil;

@WebServlet("/gbc")
public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("gbc");

		String action = request.getParameter("action");

		if ("list".equals(action)) {
			System.out.println("modifyFrom");
			
			WebUtil.forword(request, response, "/WEB-INF/views/board/list.jsp");
		
		} else if ("modifyFrom".equals(action)) {
			System.out.println("modifyFrom");
			
			

		} else if ("writeFrom".equals(action)) {
			System.out.println("writeFrom");

		} else {
			System.out.println("나머지");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
