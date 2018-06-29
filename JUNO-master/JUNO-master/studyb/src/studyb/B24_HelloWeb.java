package studyb;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LESSON B-24
 * 「WEB」
 * JAVAサブレットをHTMLに変換して、動的WEBへ表示、
 *　TABLEタグを使用して 3×3のマスを作成、
 *　中には、左上が 0-0 右下の 2-2の表示を入れる、
 *　手で書く量を減らすように工夫。
 *
 * @author jin.junho(ジンジュンホ、800189)
 * @since 1.8
 */

@WebServlet("/B24_HelloWeb")
public class B24_HelloWeb extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public B24_HelloWeb() { // コンストラクタ
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
		out.println("B24_HelloWeb");
		out.println("</title");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"1\">");
			for(int i = 0;i < 10; i++) {
				out.println("<tr>");
				for(int j = 0;j < 10; j++) {
					out.println("<td>"+i+"-"+j+"</td>");
				}
				out.println("</tr>");
			}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
