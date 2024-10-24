<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 관리 메인</title>
</head>
<body>
  <h1> 학생 관리 프로그램 </h1>
  
  <table border="1">
  	<thaed>
  	  <th>순번</th>
  	  <th>학번</th>
  	  <th>이름</th>
  	</thaed>
  	<tbody>
  	  <c:forEach items="${stdList}" var="std" varStatus="vs">
  	    <tr>
  	      <td>${vs.count}</td>
  	      <td>${std.stdNo}</td>
  	      <td>
  	        <a href="/std/detail?stdNo=${std.stdNo}">${std.stdName}</a>
  	      </td>
  	      <tr>
  	  </c:forEach>
  	</tbody>
  </table>

</body>
</html>