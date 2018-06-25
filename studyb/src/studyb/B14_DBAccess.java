package studyb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * LESSON B-14
 * 「DATABASE」
 * DBにアクセスするメッソドのクラス
 * DBメッソドのリスト
 * ------------------------------------------------------
 * 接続、切断、コミット、ロールバック、更新(INSERT,UPDATE,DELETE)、表示
 * ------------------------------------------------------
 * B14_execで実行
 *
 * @author jin.junho(ジンジュンホ、800189)
 * @since 1.8
 */

public class B14_DBAccess{
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	/**
	 * Connect.
	 * DBに接続、トランザクション開始
	 */
	
	public void connect() {
		try { // ドライバーをローディングしました。
			String jdbcDriver = "com.mysql.jdbc.Driver";	
			Class.forName(jdbcDriver);
			System.out.println("ドライバーローディンぐしました。");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try { // DB接続
			String dburl = "jdbc:mysql://localhost/kadaidb?useSSL=false&useUnicode=yes&characterEncoding=UTF-8";
			String username = "root";
			String password = "901214";
			
			conn = DriverManager.getConnection(dburl,username,password);
			System.out.println("DBに接続しました。");
			conn.setAutoCommit(false);	// オートコミットを消す。 
			System.out.println("AutoCommit OFF");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Disconnect.
	 * DBから切断、トランザクション終了
	 */
	public void disconnect() {
		try {
			if( conn != null ) {
				conn.close();
			}
			if( rs != null ) {
				rs.close();
			}
			if( pstmt != null ) {
				pstmt.close();
			}
			System.out.println("DB EXIT");
		}catch (SQLException e) {
			System.out.println("データベースからの切断エラー" + e);
		}
	}
	
	/**
	 * Commit.
	 * データを保存
	 */
	public void commit() {	
		try{
			conn.commit();
			System.out.println("データーをコミットしました。");
		}catch (SQLException e) {
			System.out.println("commitエラー" + e);
		}
	}

	public void rollback() {
		try{
			conn.rollback();
			System.out.println("データーをロールバックしました。");
		}catch (SQLException e) {
			System.out.println("rollbackエラー" + e);
		}
	}
	/**
	 * updateExec.
	 *　
	 *　INSERT 、UPDATE、DELETEを実行
	 * @param sql(SQL QUERYが入る引数)
	 * @return res(実行の判断をする戻り値）
	 */
	
	public int updateExec(String sql){
		int res = -1;
		try {
			pstmt = conn.prepareStatement(sql); 	
			res = pstmt.executeUpdate();
			System.out.println("testtable1が更新されました。");
			}
			// SQL文が間違ったとき例外処理
			catch(MySQLSyntaxErrorException e) { 
				System.out.println("### SQL QUERY エラー : SQL文を確認して入力してください。");
			}
			// PRIMARY KEYが重複した時の例外処理
			catch(MySQLIntegrityConstraintViolationException e) {
				System.out.println("### INSERT エラー : PRIMARY　KEYが重複しています、データーを確認してください。");
			}
			catch(SQLException e) {
				System.out.println("データー更新エラー" + e);
			}
		return res;
	}

	/**
	 * selectExec.
	 *
	 *　Select文を実行 取得した値を戻す
	 * @param sql(SQL QUERYが入る引数)
	 * @return the string[][] 戻り値 取得した値（二次元配列)
	 */
	
	public String[][] selectExec(String sql){
		
		try {
			int rowcnt = 0; // TABLE(ROW(行))の大きさを入れる変数
			int colcnt = 0; // TABLE(COL(列))の大きさを入れる変数
			pstmt = conn.prepareStatement(sql);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();

			// COLの大きさ
		    ResultSetMetaData rsmd = rs.getMetaData();
		    colcnt = rsmd.getColumnCount(); // COLの値を入れる
		    
		    // ROWのおおきさ
			rs.last();   //　ROWのカーソルを最後に
			rowcnt = rs.getRow(); // ROWの値を入れる
			
			String[][] res = new String[rowcnt][colcnt]; // String[行][列]		
			rs.beforeFirst(); // ROWのカーソルを最初に
			
			// TABLE[0からrowcnt][0]にTESTNOの全てのレコードの値を、
			// TABLE[0からrowcnt][1]にNAMEの全てのレコードの値を、
			// TABLE[0からrowcnt][2]にKANAの全てのレコードの値を、入れます。
			int count = 0;
			while(rs.next()) {
				if (colcnt >= 1) {
					String testnum = rs.getString(1);
					res[count][0] = testnum;
				}
				if (colcnt >= 2) {
					String name = rs.getString(2);
					res[count][1] = name;
				}
				if (colcnt >= 3) {
					String kana = rs.getString(3);
					res[count][2] = kana;
				}
				count++;
				if (count == rowcnt) {
					break;
				}
			}
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
				return null;
		}
	}
	
	/**
	 * selectExec
	 *
	 *　Select文を実行 取得した値を戻す
	 * @param sql(SQL QUERYが入る引数)
	 * @param fromIdx SELECTの範囲(fromIdxから探す）
	 * @return the string[][] 戻り値 取得した値（二次元配列)
	 */
	public String[][] selectExec(String sql, int fromIdx){

		try {
			int rowcnt = 0; // TABLE(ROW(行))の大きさを入れる変数
			int colcnt = 0; // TABLE(COL(列))の大きさを入れる変数
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fromIdx);
			rs = pstmt.executeQuery();

			// COLの大きさ
		    ResultSetMetaData rsmd = rs.getMetaData();
		    colcnt = rsmd.getColumnCount(); // COLの値を入れる
		    
		    // ROWのおおきさ
			rs.last();   //　ROWのカーソルを最後に
			rowcnt = rs.getRow(); // ROWの値を入れる
			
			String[][] res = new String[rowcnt][colcnt]; // String[行][列]		
			rs.beforeFirst(); // ROWのカーソルを最初に
			
			System.out.print("TESTNO\t\tNAME\t\tKANA");
			
			// TABLE[0からrowcnt][0]にTESTNOの全てのレコードの値を、
			// TABLE[0からrowcnt][1]にNAMEの全てのレコードの値を、
			// TABLE[0からrowcnt][2]にKANAの全てのレコードの値を、入れます。
			for( int i = 0;i < rowcnt;i++ ) {
				if( rs.next() ) {
					String testnum = rs.getString("TESTNO");
					String name = rs.getString("NAME");
					String kana = rs.getString("KANA");
					
					res[i][0] = testnum;
					res[i][1] = name;
					res[i][2] = kana;
				}
			}
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
				return null;
		}
	}

	/**
	 * selectExec.
	 *
	 * @param sql(SQL QUERYが入る引数)
	 * @param toIdx SELECTが始まりの値(toIdxから探す）
	 * @param fromIdx SELECT出力する個数
	 * @return the string[][] 戻り値 取得した値（二次元配列)
	 */
	public String[][] selectExec(String sql, int toIdx, int fromIdx){

		try {
			int rowcnt = 0; // TABLE(ROW(行))の大きさを入れる変数
			int colcnt = 0; // TABLE(COL(列))の大きさを入れる変数
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, toIdx);
			pstmt.setInt(2, fromIdx);
			rs = pstmt.executeQuery();

			// COLの大きさ
		    ResultSetMetaData rsmd = rs.getMetaData();
		    colcnt = rsmd.getColumnCount(); // COLの値を入れる
		    
		    // ROWのおおきさ
			rs.last();   //　ROWのカーソルを最後に
			rowcnt = rs.getRow(); // ROWの値を入れる
			
			String[][] res = new String[rowcnt][colcnt]; // String[行][列]		
			rs.beforeFirst(); // ROWのカーソルを最初に
			
			System.out.print("TESTNO\t\tNAME\t\tKANA");
			
			// TABLE[0からrowcnt][0]にTESTNOの全てのレコードの値を、
			// TABLE[0からrowcnt][1]にNAMEの全てのレコードの値を、
			// TABLE[0からrowcnt][2]にKANAの全てのレコードの値を、入れます。
			for( int i = 0;i < rowcnt;i++ ) {
				if( rs.next() ) {
					String testnum = rs.getString("TESTNO");
					String name = rs.getString("NAME");
					String kana = rs.getString("KANA");
					
					res[i][0] = testnum;
					res[i][1] = name;
					res[i][2] = kana;
				}
			}
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
				return null;
		}
	}
}