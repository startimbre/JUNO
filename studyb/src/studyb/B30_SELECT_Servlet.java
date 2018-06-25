package studyb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * LESSON B-30
 * 「WEB」
 * チェックボックスを置き、表示列の指定を可能にしなさい
 *　テキストボックスを置き、列名NAMEの前方一致検索条件としなさい
 * （空白の場合は全件検索）
 * コンボを置き、ソート対象列＋（昇順or降順）を指定可能にしなさい。
 * 検索後も検索条件入力欄は表示し、検索したときの状態を保持する事。
 * また、B-28と同様に表示と処理をJSPとサーブレットにわけること。
 * 
 * @author jin.junho(ジンジュンホ、800189)
 * @since 1.8
 */


@WebServlet("/B30_SELECT_Servlet")
public class B30_SELECT_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public B30_SELECT_Servlet() {
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
		
		String[] checkResult = request.getParameterValues("checkinput"); // checkboxそれぞれの値を配列で受けます。	
		String radioorder = request.getParameter("radioorder"); // radiobuttonの値
		String sort = request.getParameter("sort"); // selectbox(ソート)の値
		PrintWriter out = response.getWriter();
		String query = ""; // query文
		
		if(checkResult == null) { // CHECKしていることが場合
			out.println("CHECKBOXを選択してください"); 
			out.close();
		}
		
		else {
			for(int i = 0; i < checkResult.length; i++) { // query文を書くfor文
				if(checkResult[i] != null) {
					query += checkResult[i];	// checkboxそれぞれの値(testno, name, kana)を受けます。
					checkResult[i] += "Checked"; // それぞれのcheckboxのcheck表示です。
				}
				if(i < checkResult.length-1) {
					query += ",";	// 最後の前(length-1)まで,を付きます。
				}
				else {
					break;
				}
			}
		}
		if(radioorder == null) { // CHECKが１個もない場合
			out.println("RADIOBUTTONを選択してください"); 
			out.close();
		}

		HttpSession session = request.getSession();
		
		B14_DBAccess dbAccess = new B14_DBAccess();
		dbAccess.connect();

		String searchresult = request.getParameter("searchCursor"); // 名前前方一致の条件(SQL文に書きます)
		
		if(searchresult == null) {
			searchresult = "";
		}
		
		String selectSql = "select " + query + " from testtable1 where name like " + "'" + searchresult + "%'" + "order by " + sort + " " + radioorder +";";
		
		// SELECT文を実行して、resultに入れます。
		String[][] result = dbAccess.selectExec(selectSql);
		
		// resultと、formの結果をsessionに入ります。
	    session.setAttribute("searchResult", result);
	    session.setAttribute("checkBox", checkResult);
	    session.setAttribute("sort", sort);
	    session.setAttribute("radioBtn", radioorder);
	    
		RequestDispatcher dispatcher = request.getRequestDispatcher("B30_SELECT.jsp"); // 戻り値を受けるページ
		dispatcher.forward(request, response);	
	}
}
