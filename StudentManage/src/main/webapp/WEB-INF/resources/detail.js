const stdNo = new URLSearchParams(location.search).get("stdNo"); // 할 일 번호

const goToList = document.querySelector("#goToList");

goToList.addEventListener("click", () => {

  location.href = "/";

});


const updateBtn = document.querySelector("#updateBtn");

updateBtn.addEventListener("click", () => {

  //location.href = "/std/update?stdNo=" + stdNo;

});

const deleteBtn = document.querySelector("#deleteBtn");

deleteBtn.addEventListener("click", () => {

  //location.href = "/std/update?stdNo=" + stdNo;

});