<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="java.util.List,com.ssafy.board.model.BoardDto,com.ssafy.board.dao.BoardDaoImpl"%>
<%
//1. DB에서 글목록을 Dao의 listArticle()메소드를 이용하여 select하여 List로 얻어오세요.
List<BoardDto> list = BoardDaoImpl.getBoardDao().listArticle();

request.setAttribute("articles", list);
RequestDispatcher dispatcher = request.getRequestDispatcher("/board/list.jsp");
dispatcher.forward(request, response);
%>
 

