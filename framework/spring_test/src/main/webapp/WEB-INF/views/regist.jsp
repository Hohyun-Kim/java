<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	  <h2>상품 정보 등록</h2>
	  <form id="registForm" method="post" action="${root}/regist">
	    <div class="form-group">
	      <label for="productCode">고유번호</label>
	      <input type="text" class="form-control" name="code" id="productCode" placeholder="고유번호 입력">
	    </div>
	    <div class="form-group">
	      <label for="model">모델명</label>
	      <input type="text" class="form-control" name="model" id="model" placeholder="모델명 입력">
	    </div>
	    <div class="form-group">
	      <label for="price">가격</label>
	      <input type="number" class="form-control" name="price" id="price" placeholder="가격 입력" >
	    </div>
	<div class="form-group">
	      <label for="userId">등록자명</label>
	      <input type="text" class="form-control" name="id" id="userId">
	    </div>

	    <button type="submit" class="btn btn-primary" id="regist">등록</button>
	    <a class="btn btn-secondary" href="#" >취소</a>
	  </form>
	
	
	</div>
	<%-- --%>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>