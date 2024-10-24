<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 세부정보 조회</title>
</head>
<body>

  학번 : ${std.stdNo} <br>
  이름 : ${std.stdName} <br>
  나이 : ${std.stdAge} <br>
  성별 : ${std.stdGender} <br>
  성적 : ${std.stdScore} <br>
  
  <button id="goToList">목록</button>	
  <button id="updateBtn">수정</button>	
  <button id="deleteBtn">삭제</button>	
  
  <script src="/resources/js/detail.js"></script>
</body>
</html>