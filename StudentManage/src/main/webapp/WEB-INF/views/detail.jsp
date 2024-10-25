<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 세부정보 조회</title>
<link rel="stylesheet" href="/resources/css/detail.css">
</head>
<body>
  
  학번 : ${std.stdNo} <br>
  이름 : ${std.stdName} <br>
  나이 : ${std.stdAge} <br>
  성별 : <c:if test="${std.stdGender eq 'M'}">남</c:if>
    	 <c:if test="${std.stdGender eq 'F'}">여</c:if> <br>
  성적 : ${std.stdScore} <br>
  
  <button id="goToList">목록</button>	
  <button id="updateBtn">수정</button>	
  <button id="deleteBtn">삭제</button>	
  
  <!-- session scope에 메시지 있을시 alert으로 띄움 -->
  <c:if test="${not empty sessionScope.message}">
  	<script>
  	  alert("${message}");
  	</script>
  	
  	<c:remove var="message" scope="session" />
  </c:if>
  
  <script src="/resources/js/detail.js"></script>
</body>
</html>