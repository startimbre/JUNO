package studyb;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LESSON B-25
 * 「WEB」
 * JAVAサブレットをHTMLに変換して、動的WEBへ表示、
 *　テキストボックス（INPUT TYPE=text）とボタンを置き、
 *　submitすると下に表示。
 *
 * @author jin.junho(ジンジュンホ、800189)
 * @since 1.8
 */

@WebServlet("/B25_HelloWeb")
public class B25_HelloWeb extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public B25_HelloWeb() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	doPost(request,response);
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // POSTが渡す値のENCODING
		response.setContentType("text/html; charset=UTF-8"); // このページのENCODING
		String message = request.getParameter("message");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>B-25_HelloWeb</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method=\"post\" action=\"B25_HelloWeb\">");
		out.println("<p><input type=\"text\" name=\"message\">");
		out.println("<input type=\"submit\" value=\"クエリ送信\"></p>");
				
		if(message != null) {		
			out.println(message);
		}
		
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
