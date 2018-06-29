package studyb;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * LESSON B-29
 * 「WEB」
 * DBに接続しブラウザ上に検索結果がすべて表示される画面を作りなさい。
 *　（画面が表示されると同時に検索結果が出力されても良いし、
 * 検索ボタン押下後に出力されても良い。）
 * 
 * @author jin.junho(ジンジュンホ、800189)
 * @since 1.8
 */

@WebServlet("/B29_SELECT_Servlet")
public class B29_SELECT_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private String selectSql = "select * from testtable1;";
       
    public B29_SELECT_Servlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // POSTが渡す値のENCODING
		response.setContentType("text/html; charset=UTF-8"); // このページのENCODING
		
		HttpSession session = request.getSession();
		
		B14_DBAccess dbAccess = new B14_DBAccess();
		
		dbAccess.connect();
		
		// SELECT文を実行して、resultに入ります。
		String result[][] = dbAccess.selectExec(selectSql);
		
	    session.setAttribute("searchResult", result);
	    
		RequestDispatcher dispatcher = request.getRequestDispatcher("B29_SELECT.jsp"); // 戻り値を受けるページ
		dispatcher.forward(request, response);
	}
}
