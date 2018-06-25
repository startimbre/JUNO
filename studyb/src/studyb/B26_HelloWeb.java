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
 * LESSON B-26
 * 「WEB」
 * JAVAサブレットをHTMLに変換して、動的WEBへ表示、
 *　テキストボックス（INPUT TYPE=text）とボタンを置き、
 *　submitすると下に追記できるように表示(何個でも)、
 *　ブラウザを２個起動した場合は、独立して動く事。
 *
 * @author jin.junho(ジンジュンホ、800189)
 * @since 1.8
 */

@WebServlet("/B26_HelloWeb")
public class B26_HelloWeb extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public B26_HelloWeb() {
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
		out.println("<meta charset=\"UTF-8\">"	);
		out.println("<title>B-26_HelloWeb</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method=\"post\" action=\"B26_HelloWeb\">");
		out.println("<p><input type=\"text\" name=\"message\">");
		out.println("<input type=\"submit\" value=\"クエリ送信\"><br>");
		
		if(message == null) {}
		else {
			textlist.add(message);
			for(int i = 0;i < textlist.size();i++) {
				out.println(textlist.get(i) + "<br>");
			}
		}
		
		out.println("</p></form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		}	
	}