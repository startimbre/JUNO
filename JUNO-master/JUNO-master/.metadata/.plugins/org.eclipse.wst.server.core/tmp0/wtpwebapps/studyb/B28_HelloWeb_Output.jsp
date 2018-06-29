<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<H1 align = "center">出力画面</H1>
    <%@ page import="java.util.ArrayList"%>
	<%@ page import="java.util.List"%>
	
	<!-- inputlist(ArrayList)にsessionの値(Servletファイルの64行)を受けて入れる。 -->
	<%
		
		ArrayList<String> inputlist = new ArrayList<String>();
	
		inputlist = (ArrayList<String>)session.getAttribute("textlist");
	
		if (inputlist != null) {
			for(int i = 0;i < inputlist.size();i++) {
			out.println(inputlist.get(i) + "<br>");
			} 
		}
	%>