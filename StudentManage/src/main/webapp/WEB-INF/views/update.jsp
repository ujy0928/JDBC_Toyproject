<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 수정</title>
</head>
<body>
  학생 데이터 수정
  
  <form action="/std/update" method="post" id="updateForm">
	이름 : <input type="text" name="stdName" value="${std.stdName}"> <br>
	나이 : <input type="text" name="stdAge" value="${std.stdAge}"> <br>
	성별 : 

	<input type="radio" name="stdGender" value="M">남 
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
	<button>수정</button>
	<input type="hidden" name="stdNo" value="${std.stdNo}">
  </form>

  <c:if test="${not empty sessionScope.message}">
  	<script>
  	  alert("${message}");
  	</script>
  	
  	<c:remove var="message" scope="session" />
  </c:if>
  
  <script>
    const stdGender = document.querySelectorAll("[name=stdGender]");
		
	if("${std.stdGender}" == "M") {
		stdGender[0].checked = true;
	} else {
		stdGender[1].checked = true;
	}

	const score = document.querySelector("#score");
	if("${std.stdScore}" == "A") {
		score.value = "A";
	} else if("${std.stdScore}" == "B") {
		score.value = "B";
	} else if("${std.stdScore}" == "C") {
		score.value = "C";
	} else if("${std.stdScore}" == "D") {
		score.value = "D";
	} else if("${std.stdScore}" == "F") {
		score.value = "F";
	}
    
		
  </script>
</body>
</html>