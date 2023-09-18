<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.board.model.BoardDto, com.ssafy.board.dao.BoardDaoImpl"%>
<%
request.setCharacterEncoding("utf-8");
//	1. 작성자아이디, 글제목, 글내용을 얻으세요. 
BoardDto boardDto = new BoardDto();
boardDto.setUserId(request.getParameter("userid"));
boardDto.setSubject(request.getParameter("subject"));
boardDto.setContent(request.getParameter("content"));

int cnt = BoardDaoImpl.getBoardDao().writeArticle(boardDto);

if (cnt != 0) {
	response.sendRedirect("/board/board/result_success.jsp");
} else {
	response.sendRedirect("/board/board/result_fail.jsp");
}
%>
