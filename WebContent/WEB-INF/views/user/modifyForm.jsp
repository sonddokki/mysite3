<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.javaex.vo.UserVo" %>
<%@ page import="com.javaex.dao.UserDao" %>

<!--세션값을 가져온다-->
<%  UserVo authUser = (UserVo)session.getAttribute("authUser");
	
	UserDao userDao = new UserDao();
	UserVo modifyUser = userDao.userUpdateSelect(authUser);
	System.out.println(modifyUser);	
	System.out.println(modifyUser.getGender());	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="./assets/css/user.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

		<div id="wrap">

		<!-- header -->
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>

		<div id="nav">
			<ul class="clearfix">
				<li><a href="">입사지원서</a></li>
				<li><a href="./gbc?action=list">게시판</a></li>
				<li><a href="">갤러리</a></li>
				<li><a href="./guestbook?action=addList">방명록</a></li>
			</ul>
		</div>
		<!-- //nav -->

		<div id="container" class="clearfix">
			<div id="aside">
				<h2>회원</h2>
				<ul>
					<li>회원정보</li>
					<li>로그인</li>
					<li>회원가입</li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>회원정보</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>회원</li>
							<li class="last">회원정보</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->

				<div id="user">
					<div id="modifyForm">
						<form action="user" method="get">
						<input type="hidden"  name="action" value="modify" >
						<input type="hidden"  name="id" value="<%=modifyUser.getId()%>" >
							<!-- 아이디 -->
							<div class="form-group">
								<label class="form-text" for="input-uid">아이디</label> <span class="text-large bold"><%=modifyUser.getId()%></span>
							</div>

							<!-- 비밀번호 -->
							<div class="form-group">
								<label class="form-text" for="input-pass">패스워드</label> <input type="text" id="input-pass" name="pw" value="<%=modifyUser.getPassword()%>" placeholder="비밀번호를 입력하세요">
							</div>

							<!-- 이메일 -->
							<div class="form-group">
								<label class="form-text" for="input-name">이름</label> <input type="text" id="input-name" name="name" value="<%=modifyUser.getName()%>" placeholder="이름을 입력하세요">
							</div>

							<!-- //나이 -->
							<div class="form-group">
								<span class="form-text">성별</span>
								<label for="rdo-male">남</label> <input type="radio" id="rdo-male" name="gender" value="male"
								<% if ("male".equals(modifyUser.getGender())) {%>
								checked
								<%}%>
								>
								<label for="rdo-female">여</label> <input type="radio" id="rdo-female" name="gender" value="female"
								<% if ("female".equals(modifyUser.getGender())) {%>
								checked
								<%}%>
								>

							</div>

							<!-- 버튼영역 -->
							<div class="button-area">
								<button type="submit" id="btn-submit">회원정보수정</button>
							</div>

						</form>


					</div>
					<!-- //modifyForm -->
				</div>
				<!-- //user -->
			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->

		<div id="footer">Copyright ⓒ 2020 황일영. All right reserved</div>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>