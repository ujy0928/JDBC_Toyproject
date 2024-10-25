<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 추가</title>
</head>
<body>
  <form action="/std/add" method="post" id="addForm">
  	<!-- 학번 : <input type="number" name="stdNo" style="width:60px"> <br> -->
  	이름 : <input type="text" name="stdName" size="10" maxLength="10"> <br>
  	나이 : <input type="number" name="stdAge" style="width:50px"> <br>
  	성별 : <input type="radio" name="stdGender" value="M">남
  	       <input type="radio" name="stdGender" value="F">여
  	       <br>
  	성적 : 
  	  <select name="stdScore" id="score">
	    <option value="A">A</option>
	    <option value="B">B</option>
	    <option value="C">C</option>
	    <option value="D">D</option>
	    <option value="F">F</option>
	  </select>
	  <br>
	<button id="addBtn">추가</button>
  </form> 
  
  <c:if test="${not empty sessionScope.message}">
  	<script>
  	  alert("${message}");
  	</script>
  	
  	<c:remove var="message" scope="session" />
  </c:if>
  
  <script src="/resources/js/add.js"></script>
</body>
</html>