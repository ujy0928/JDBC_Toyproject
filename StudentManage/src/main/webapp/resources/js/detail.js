const stdNo = new URLSearchParams(location.search).get("stdNo"); // 할 일 번호

// 메인 페이지로 이동
const goToList = document.querySelector("#goToList");

goToList.addEventListener("click", () => {

  location.href = "/";

});

// 학생정보 수정 페이지로 이동
const updateBtn = document.querySelector("#updateBtn");

updateBtn.addEventListener("click", () => {
  
  location.href = "/std/update?stdNo=" + stdNo;

});

// 삭제 컨트롤러로 이동
const deleteBtn = document.querySelector("#deleteBtn");

deleteBtn.addEventListener("click", () => {
  if(confirm("정말 삭제하시겠습니까?")) {
    location.href = "/std/delete?stdNo=" + stdNo;
  }

});

