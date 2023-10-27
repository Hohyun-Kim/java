<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
		<h2>상품 정보 목록</h2>
		<table>
			<tr>
				<td>고유번호</td>
				<td>${dto.code}</td>
			</tr>
			<tr>
				<td>모델명</td>
				<td>${dto.model}</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>${dto.price}</td>
			</tr>
			<tr>
				<td>등록자명</td>
				<td>${dto.id}</td>
			</tr>
		</table>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>