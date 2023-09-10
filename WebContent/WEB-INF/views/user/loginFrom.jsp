<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%String result = request.getParameter("result");%>

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

		<!-- header -->
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>

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
					<h3>로그인</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>회원</li>
							<li class="last">로그인</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				 <!-- //content-head -->
	
				<div id="user">
					<div id="loginForm">
						<form action="./user" method="get">
	
							<!-- 아이디 -->
							<div class="form-group">
								<label class="form-text" for="input-uid">아이디</label> 
								<input type="text" id="input-uid" name="id" value="" placeholder="아이디를 입력하세요">
							</div>
	
							<!-- 비밀번호 -->
							<div class="form-group">
								<label class="form-text" for="input-pass">비밀번호</label> 
								<input type="text" id="input-pass" name="pw" value="" placeholder="비밀번호를 입력하세요"	>
							</div>
							
							<% if ("fail".equals(result)) {%>
							<p>로그인에 실패 했습니다.</p> <br>
							<%}%>
							
							<input type="text" name="action" value="login">
							
							<!-- 버튼영역 -->
							<div class="button-area">
								<button type="submit" id="btn-submit">로그인</button>
							</div>
							
						</form>
					</div>
					<!-- //loginForm -->
				</div>
				<!-- //user -->
			</div>
			<!-- //content  -->
			
		</div>
		<!-- //container  -->

		<!-- //footer -->
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>	

	</div>
	<!-- //wrap -->

</body>

</html>