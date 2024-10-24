<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 관리 메인</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
  <h1> 학생 관리 프로그램 </h1>
  
  <table id="stdList" border="1">
  	<thead>
  	  <th>순번</th>
  	  <th>학번</th>
  	  <th>이름</th>
  	  <th>나이</th>
  	  <th>성별</th>
  	  <th>학점</th>
  	</thead>
  	<tbody>
  	  <c:forEach items="${stdList}" var="std" varStatus="vs">
  	    <tr>
  	      <th>${vs.count}</th>
  	      <td>${std.stdNo}</td>
  	      <td>
  	        <a href="/std/detail?stdNo=${std.stdNo}">${std.stdName}</a>
  	      </td>
  	      <td>${std.stdAge}</td>
  	      <td>${std.stdGender}</td>
  	      <td>${std.stdScore}</td>
  	    </tr>
  	  </c:forEach>
  	</tbody>
  </table>
  
  <br>
  <button id="addBtn">추가</button>

  <c:if test="${not empty sessionScope.message}">
  	<script>
  	  alert("${message}");
  	</script>
  	
  	<c:remove var="message" scope="session" />
  </c:if>
</body>
</html>