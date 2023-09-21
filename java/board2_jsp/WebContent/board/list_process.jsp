<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.ssafy.board.model.BoardDto,com.ssafy.board.dao.BoardDaoImpl,java.util.*" %>
<%
List<BoardDto> list = BoardDaoImpl.getBoardDao().listArticle();
request.setAttribute("articles", list);
RequestDispatcher disp = request.getRequestDispatcher("/board/list.jsp");
disp.forward(request, response);
%>
