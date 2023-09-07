package com.javaex.controller;

import java.awt.Desktop.Action;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.UserDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.UserVo;


@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userC");
		
		// 업무구분용 파라미터 체크		
		String action = request.getParameter("action");
		
		if("joinFrom".equals(action)) {
			System.out.println("joinFrom");
		// 회원가입폼(action = joinForm) 포워드
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/joinFrom.jsp");
//		rd.forward(request, response);
		// 스태틱을 만들어서 포워드 메소드바로 사용
		WebUtil.forword(request, response, "/WEB-INF/views/user/joinFrom.jsp");
		
		} else if("join".equals(action)){
			System.out.println("join");
			// 회원가입(action = join)
			
			// 파라미터 꺼내기
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			
			// 1개로 묶기
			UserVo userVo = new UserVo(id ,password, name, gender);
			System.out.println(userVo);
			// 등록실행
			UserDao userDao = new UserDao();
			int count = userDao.userInsert(userVo);
			System.out.println(count);
			
			// 가입성공 페이지
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views//user/joinOk.jsp");
//			rd.forward(request, response);
			
			WebUtil.forword(request, response, "/WEB-INF/views//user/joinOk.jsp");
			
		} else {
			System.out.println("나머지");
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
