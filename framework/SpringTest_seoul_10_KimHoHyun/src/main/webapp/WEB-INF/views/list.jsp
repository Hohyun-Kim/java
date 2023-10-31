<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>SSAFY</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

th {
	background: gray;
}

th, td {
	border: 1px dotted black;
	text-align: center;
}

#selectedDel {
	text-align: right;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<form method="" action="">
		<table>
			<tr>
				<th>이슈번호</th>
				<th>학번</th>
				<th>교육생명</th>
				<th>반</th>
				<th>지역</th>
				<th>날짜</th>
				<th>사유</th>
				<th>삭제</th>
			</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
		</table>

		<input type="submit" value="선택항목삭제">
	</form>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>