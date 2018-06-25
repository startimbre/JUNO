<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String[] checkBox = (String[])session.getAttribute("checkBox");%>
<%String sort = (String)session.getAttribute("sort");%>
<%String radioBtn = (String)session.getAttribute("radioBtn");%>
<%String tnChecked = "";%>
<%String nmChecked = "";%>
<%String knChecked = "";%>
<%String tnSelected = "";%>
<%String nmSelected = "";%>
<%String knSelected = "";%>
<%String ascChecked = "";%>
<%String descChecked = "";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>B30_SELECT</title>
</head>
<body>
<H1>検索画面</H1>
<form name="search" method="post" action="B30_SELECT_Servlet">
<table border="1">
	<tr>
		<td>表示内容</td>
		<td>
		
		<%
		if(checkBox != null){
			for(int i = 0;i < checkBox.length;i++){
				if(checkBox[i].equals("testnoChecked")){
					tnChecked = "checked";
				}
				if(checkBox[i].equals("nameChecked")){
					nmChecked = "checked";
				}
				if(checkBox[i].equals("kanaChecked")){
					knChecked = "checked";
				}
			}
		}
		%>
		
		<%
		if(sort != null){
			if(sort.equals("testno")){
				tnSelected = "selected";
			}
			if(sort.equals("name")){
				nmSelected = "selected";
			}
			if(sort.equals("kana")){
				knSelected = "selected";
			}
		}
		%>
		
		<%
		if(radioBtn != null){
			if(radioBtn.equals("asc")){
				ascChecked = "checked";
			}
			if(radioBtn.equals("desc")){
				descChecked = "checked";
			}
		}
		%>
		
		<input type="checkbox" name="checkinput" value="testno" <%out.println(tnChecked);%>/>TESTNO
		<input type="checkbox" name="checkinput" value="name" <%out.println(nmChecked);%>/>NAME
		<input type="checkbox" name="checkinput" value="kana" <%out.println(knChecked);%>/>KANA
		</td>
	</tr>
	<tr>
		<td>検索条件</td>
		<td>
		<input type="text" name="searchCursor" id="id" value="${param.searchCursor}">(NAME前方一致)
		</td>
	</tr>
	<tr>
		<td>ソート</td>
		<td>
		<select name='sort' size='1'>
	    <option value='testno' <%out.println(tnSelected);%>>TESTNO</option>
	    <option value='name' <%out.println(nmSelected);%>>NAME</option>
	    <option value='kana' <%out.println(knSelected);%>>KANA</option>
		</select>
		<input type="radio" name="radioorder" value="asc" <%out.println(ascChecked);%>>昇順
		<input type="radio" name="radioorder" value="desc" <%out.println(descChecked);%>>降順
		</td>
	</tr>
</table>
<br>
	<input type=submit style="WIDTH:80pt;" value="検索">
</form>
	<%
	String[][] resultArr = (String[][])session.getAttribute("searchResult");

	if(resultArr != null){
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