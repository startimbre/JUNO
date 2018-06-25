package studyb;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * LESSON B-27
 * 「WEB」
 * JAVAサブレットをHTMLに変換して、動的WEBへ表示、
 *　送信時にテキストボックスが空の場合”空です”のアラートボックスが
 *　表示され送信が中断されるようにしなさい。
 *
 * @author jin.junho(ジンジュンホ、800189)
 * @since 1.8
 */

@WebServlet("/B27_HelloWeb")
public class B27_HelloWeb extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public B27_HelloWeb() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // POSTが渡す値のENCODING
		response.setContentType("text/html; charset=UTF-8"); // このページのENCODING
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		ArrayList<String> textlist = (ArrayList<String>) session.getAttribute("message");
			if(textlist == null) {
				textlist = new ArrayList<String>();
				session.setAttribute("message", textlist);
			}
		// messageに入力した値を受けます。
		String message = request.getParameter("message");
		
		out.println("<html>");
		out.println("<head>");
		
		out.println("<script type='text/javascript'>");
		out.println("function textcheck() {");
		out.println("var text = document.getElementById('id').value;"); // text（変数）にtextboxのid(id)の値を受けます
		out.println("if(text.trim() == '' || text.trim() == null) {"); // text(変数)が空とかnullなら
		out.println("alert('空です')");
		out.println("return false"); // falseをreturnするなら、中断されます
		out.println("}else{");
		out.println("return true}}"); // trueをreturnするなら、値が送ります。
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<meta charset=\"UTF-8\">"	);
		out.println("<title>B-27_HelloWeb</title>");
		out.println("<form method=\"post\" action=\"B27_HelloWeb\">");
		out.println("<input type=\"text\" name=\"message\" id =\"id\">");
		// clickしたら、textcheck functionを実行
		out.println("<input type=\"submit\" value=\"クエリ送信\" onclick='return textcheck()'><br>"); 

		if(message == null) {}
		else {
			textlist.add(message);
			for(int i = 0;i < textlist.size();i++) {
				out.println(textlist.get(i) + "<br>");
			}
		}
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		}	
	}