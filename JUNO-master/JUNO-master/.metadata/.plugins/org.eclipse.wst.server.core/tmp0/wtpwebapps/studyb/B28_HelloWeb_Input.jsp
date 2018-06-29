<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <script type='text/javascript'>
	function textcheck() {		
		// text（変数）にtextboxのid(id)の値を受けます
		var text = document.getElementById('id').value;	
		// text(変数)が空とかnullなら
		if(text.trim() == '' || text.trim() == null) {
			alert('空です');
			return false;  // falseをreturnするなら、中断されます
		}else{
			return true; // trueをreturnするなら、値が送ります。
		}
	}
	</script>
    
	<H1 align = "center">入力画面</H1>
	<form method="post" action="B28_HelloWeb_Servlet" target="_top">
		<input type="text" name="message" id="id">
		<input type="submit" value="クエリ送信" onclick='return textcheck()'>		
	</form>