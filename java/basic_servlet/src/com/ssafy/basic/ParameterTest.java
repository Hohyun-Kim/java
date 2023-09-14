package com.ssafy.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterTest
 */
@WebServlet("/param")
public class ParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. data get
		String userName = request.getParameter("username");
		String userPwd = request.getParameter("userpwd");;
		String[] fruits = request.getParameterValues("fruit");
//		2. logic >> 나중에 DB랑 ~ 하세요.
		
//		3. response page
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("		<h1>파라미터 테스트 결과</h1>");
		out.println("		<p>" + userName + "(" + userPwd + ")님이 좋아하는 과일은 " + Arrays.toString(fruits) + "입니다.</p>");
		out.println("	</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. data get
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("username");
		String userPwd = request.getParameter("userpwd");;
		String[] fruits = request.getParameterValues("fruit");
//		2. logic >> 나중에 DB랑 ~ 하세요.
		
//		3. response page
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("		<h1>파라미터 테스트 결과</h1>");
		out.println("		<p>" + userName + "(" + userPwd + ")님이 좋아하는 과일은 " + Arrays.toString(fruits) + "입니다.</p>");
		out.println("	</body>");
		out.println("</html>");
	}

}
