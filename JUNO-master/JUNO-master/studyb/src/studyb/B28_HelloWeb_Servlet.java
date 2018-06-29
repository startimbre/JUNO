package studyb;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * LESSON B-28
 * 「WEB」
 * B-27の機能を表示をJSPで、処理をサーブレットで行うようにしなさい。
 *　入力画面と出力画面をフレームで分けること。
 *
 * @author jin.junho(ジンジュンホ、800189)
 * @since 1.8
 */

@WebServlet("/B28_HelloWeb_Servlet")
public class B28_HelloWeb_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public B28_HelloWeb_Servlet() {
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
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		ArrayList<String> textlist = (ArrayList<String>) session.getAttribute("message");
			if(textlist == null) {
				textlist = new ArrayList<String>();
				session.setAttribute("message", textlist);
			}
		// messageに入力した値を受けます。
		String message = request.getParameter("message");

		textlist.add(request.getParameter("message"));
		
		System.out.println(textlist);
		
		// listをsessionに入れます
		session.setAttribute("textlist",textlist);	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("B28_HelloWeb_main.jsp"); // 受けるページ
		dispatcher.forward(request, response);
	}
}