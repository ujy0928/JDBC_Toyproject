const addForm = document.querySelector("#addForm");
// 학생 정보 입력 체크를 위한 submit 이벤트

addForm.addEventListener("submit", (e) => {

/*  if(!document.querySelector("[name=stdNo]").value) {
	alert("학번을 입력하세요");
	e.preventDefault(); // 학생 정보 미입력시 submit 중단을 위함
	return;
  }*/
    
  if(!document.querySelector("[name=stdName]").value) {
  	alert("이름을 입력하세요");
	e.preventDefault();
  	return;
  }
  
  if(!document.querySelector("[name=stdAge]").value) {
    alert("나이를 입력하세요");
	e.preventDefault();
    return;
  }
  
  // 학생 성별 체크 
  const gender = document.querySelectorAll("[name=stdGender]");
  let flag = false;
  for(let i=0; i<gender.length; i++) {
  	if(gender[i].checked) {
      flag = true;
    }
  }
  
  // 성별 미입력시 alert창 띄우고 종료
  if(!flag) {
  	alert("성별을 입력하세요");
  	e.preventDefault();
  	return;
  }
  
  if(!document.querySelector("[name=stdScore]").value) {
    alert("성적을 입력하세요");
	e.preventDefault();
    return;
  }
});
