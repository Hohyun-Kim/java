<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <% String root=request.getContextPath(); %>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
      <meta charset="UTF-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />
      <link href="<%= root %>/assets/css/app.css" rel="stylesheet" />
      <title>SSAFY</title>
    </head>

    <body>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-8 col-md-10 col-sm-12">
            <h2 class="my-3 py-3 shadow-sm bg-light text-center">
              <mark class="orange">회원가입</mark>
            </h2>
          </div>
          <div class="col-lg-8 col-md-10 col-sm-12">
            <form id="form-join" method="POST" action="">
              <input type="hidden" name="action" value="join">
              <div class="mb-3">
                <label for="username" class="form-label">이름 : </label>
                <input type="text" class="form-control" id="username" name="username" placeholder="이름..." />
              </div>
              <div class="mb-3">
                <label for="userid" class="form-label">아이디 : </label>
                <input type="text" class="form-control" id="userid" name="userid" placeholder="아이디..." />
              </div>
              <div id="id-result" class="mb-3"></div>
              <div class="mb-3">
                <label for="userpwd" class="form-label">비밀번호 : </label>
                <input type="text" class="form-control" id="userpwd" name="userpwd" placeholder="비밀번호..." />
              </div>
              <div class="mb-3">
                <label for="pwdcheck" class="form-label">비밀번호확인 : </label>
                <input type="text" class="form-control" id="pwdcheck" placeholder="비밀번호확인..." />
              </div>
              <div class="mb-3">
                <label for="emailid" class="form-label">이메일 : </label>
                <div class="input-group">
                  <input type="text" class="form-control" id="emailid" name="emailid" placeholder="이메일아이디" />
                  <span class="input-group-text">@</span>
                  <select class="form-select" id="emaildomain" name="emaildomain" aria-label="이메일 도메인 선택">
                    <option selected>선택</option>
                    <option value="ssafy.com">싸피</option>
                    <option value="google.com">구글</option>
                    <option value="naver.com">네이버</option>
                    <option value="kakao.com">카카오</option>
                  </select>
                </div>
              </div>
              <!-- 
            <div class="mb-3">
              <label for="sido" class="form-label">지역 : </label>
              <div class="input-group">
                <select class="form-select me-1" id="sido" aria-label="시도">
                  <option selected>시도선택</option>
                  <option value="1100000000">서울특별시</option>
                  <option value="2200000000">경기도</option>
                  <option value="3300000000">강원도</option>
                  <option value="4400000000">충청도</option>
                </select>
                <select class="form-select" id="gugun" aria-label="구군">
                  <option selected>구군선택</option>
                  <option value="1111000000">종로구</option>
                  <option value="1112000000">중구</option>
                  <option value="1113000000">서초구</option>
                  <option value="1114000000">강남구</option>
                </select>
              </div>
            </div>
             -->
              <div class="col-auto text-center">
                <button type="button" id="btn-join" class="btn btn-outline-primary mb-3">
                  회원가입
                </button>
                <button type="button" class="btn btn-outline-success mb-3">초기화</button>
              </div>
            </form>
          </div>
        </div>
      </div>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
      <script>
        // 아이디 중복 검사.
        let isUseId = true;
        let input = document.querySelector("#userid");
        let resultDiv = document.querySelector("#id-result");
        input.addEventListener("keyup", () => {
          let userid = input.value;
          let len = userid.length;
          if (len < 4 || len > 16) {
            resultDiv.setAttribute("class", "mb-3 text-dark");
            resultDiv.innerHTML = "아이디는 4자이상 16자 이하입니다."
            isUseId = true;
          } else { // 서버에서 현재 아이디의 사용가능 여부 체크 (0 : 사용가능, 1 : 사용불가능)
            let url = "<%= root %>/user?action=idcheck&checkid=" + userid;
            fetch(url)
              .then(response => response.json())
              .then(data => resultView(data));
          }
        });

        function resultView(data) {
          let id = data.id;
          let cnt = data.cnt;
          let idDiv = document.createElement("span");
          idDiv.setAttribute("class", "fw-bold");
          idDiv.innerHTML = id;
          resultDiv.innerHTML = "";
          resultDiv.appendChild(idDiv);
          if (cnt == 0) {
            resultDiv.setAttribute("class", "mb-3 text-success");
            resultDiv.innerHTML += "는 사용가능합니다."
            isUseId = false;
          } else {
            resultDiv.setAttribute("class", "mb-3 text-danger");
            resultDiv.innerHTML += "는 사용중입니다. 다른 아이디를 사용해주세요.";
            isUseId = true;
          }
        }

        // 회원가입
        document.querySelector("#btn-join").addEventListener("click", function () {
          if (!document.querySelector("#username").value) {
            alert("이름 입력!!");
            return;
          } else if (!document.querySelector("#userid").value) {
            alert("아이디 입력!!");
            return;
          } else if (isUseId) {
            alert("아이디 중복 검사 확인!!");
            return;
          } else if (!document.querySelector("#userpwd").value) {
            alert("비밀번호 입력!!");
            return;
          } else if (document.querySelector("#userpwd").value != document.querySelector("#pwdcheck").value) {
            alert("비밀번호 확인!!");
            return;
          } else {
            let form = document.querySelector("#form-join");
            form.setAttribute("action", "<%= root %>/user");
            form.submit();
          }
        });
      </script>
    </body>

    </html>