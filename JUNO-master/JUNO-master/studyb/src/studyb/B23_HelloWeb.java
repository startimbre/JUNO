package studyb;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LESSON B-23
 * 「WEB」
 * JAVAサブレットをHTMLに変換して、動的WEBへ表示、
 * HelloServletを出力するクラス。(フォントは 20pt 文字の色は青で)
 * 
 * @author jin.junho(ジンジュンホ、800189)
 * @since 1.8
 */

@WebServlet("/B23_HelloWeb")
public class B23_HelloWeb extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public B23_HelloWeb() { // コンストラクタ
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("B23_HelloWeb");
		out.println("</title");
		out.println("</head>");
		out.println("<body>");
		out.println("<p style=\"font-size:20pt; color:blue;\"> HelloServlet </p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}