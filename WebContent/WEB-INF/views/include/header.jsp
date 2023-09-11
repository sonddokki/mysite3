<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="header" class="clearfix">
	<h1>
		<a href="./main">MySite</a>
	</h1>

	<c:if test="${!(empty authUser)}">
	<ul>
		<li>${authUser.name}님 안녕하세요^^</li>
		<li><a href="./user?action=logout" class="btn_s">로그아웃</a></li>
		<li><a href="./user?action=modifyForm" class="btn_s">회원정보수정</a></li>
	</ul>
	</c:if>

	<c:if test="${empty authUser}">
	<ul>
		<li><a href="./user?action=loginFrom" class="btn_s">로그인</a></li>
		<li><a href="./user?action=joinFrom" class="btn_s">회원가입</a></li>
	</ul>
	</c:if>
	
</div>

<!-- //nav -->

<div id="nav">
			<ul class="clearfix">
				<li><a href="">입사지원서</a></li>
				<li><a href="./brc?action=list">게시판</a></li>
				<li><a href="">갤러리</a></li>
				<li><a href="./gbc?action=addList">방명록</a></li>
			</ul>
		</div>