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
	이름 : <input type="text" value="${std.stdName}"> <br>
	나이 : <input type="text" value="${std.stdAge}"> <br>
	성별 : 

	<input type="radio" name="gender">남 
	<input type="radio" name="gender">여
	
	<br>

	성적 : ${std.stdScore}
	<select name="score" id="stdScore">
	  <option value="A">A</option>
	  <option value="B">B</option>
	  <option value="C">C</option>
	  <option value="D">D</option>
	  <option value="F">F</option>
	</select>
  </form>
  
  <script>
    const gender = document.querySelectorAll("[name=gender]");
		
	if("${std.stdGender}" == "M") {
		gender[0].checked = true;
	} else {
		gender[1].checked = true;
	}

	const score = document.querySelector("#stdScore");
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