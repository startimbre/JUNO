<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>B29_SELECT</title>
</head>
<body>
<H1>検索画面</H1>
<form name="search" method="post" action="B29_SELECT_Servlet">
<input type=submit style="WIDTH:80pt;" value="表示">
</form>
	<%
	String[][] resultArr = (String[][])session.getAttribute("searchResult"); // sessionの値を受けます。

	if(resultArr != null){	// 二次元配列を出力
	    for ( int i = 0; i < resultArr.length; i++ ) { 
	    	out.println("<br>");
	        for ( int j = 0; j < resultArr[i].length; j++ ) {
	        	out.println(resultArr[i][j]);
	        }
	    }
	}
	%>
</body>
</html>