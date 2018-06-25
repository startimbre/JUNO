package studyb;

/**
 * LESSON B-14
 * 「DATABASE」
 * データベースの接続、コミット、ロールバック、データの表示、更新、削除を実行するクラス
 * B14_DBAccessクラスを使用して実行.
 *
 * @author jin.junho(ジンジュンホ、800189)
 * @since 1.8
 */

class B14_exec {
	
	public static void main(String[] args){
		
		// 5行までのSELECT QUERY
		String selectSql1 = "select * from testtable1 LIMIT ?";
		// 6行から10行までのSELECT QUERY
		String selectSql2 = "select * from testtable1 LIMIT ?,?";
		//　全てを出力するSELECT QUERY
		String selectSql3 = "select * from testtable1;";
		String deleteSql = "delete from testtable1;"; // DELETEのQUERY
		String updateSql = "INSERT INTO testtable1 values(1,'陳','ジン'),(2,'準','ジュン'), (3,'昊','ホ'),"
				+ "(4,'新','シン'),(5,'原木','バラキ'),(6,'中山','ナカヤマ'),(7,'千葉','チバ'),"
				+ "(8,'東京','トウキョウ'), (9,'市川','イチカワ'), (10,'人形町','ニンギョウチョウ')";
		
		B14_DBAccess dbAccess = new B14_DBAccess(); // B14_DBAccessクラスのインスタンス
		
		dbAccess.connect();							// connectメソッド(接続)実行
			System.out.println("=========================================");
		dbAccess.updateExec(updateSql);				// UPDATE query メソッド実行
													// １０行データーをインサート
			System.out.println("=========================================");
		dbAccess.commit();							//　コミット
		
			System.out.println("=========================================");
		
		    System.out.println("５行目までを取得して表示");
		    
		String result[][] = dbAccess.selectExec(selectSql1, 5); // SELECT SQLのQUERYを実行
															 // 配列に結果(5行目まで)を入れる

		// 二次元配列を５行目まで出力
			for ( int i = 0; i < result.length; i++ ) { 
				System.out.println();
				for ( int j = 0; j < result[i].length; j++ ) {
					System.out.print(result[i][j] + "\t\t");
				}
			}
			
			System.out.println("\n=========================================");
		    System.out.println("６行目から１０行目までを取得して表示");
			
		String result2[][] = dbAccess.selectExec(selectSql2, 5, 5); // SELECT SQLのQUERYを実行
																  // 配列に結果(6行目から10行目まで)を入れる
		// 二次元配列を６行目から１０行目まで出力
		for ( int i = 0; i < result2.length; i++ ) { 
			System.out.println();
			for ( int j = 0; j < result2[i].length; j++ ) {
				System.out.print(result2[i][j] + "\t\t");
			}
		}

			System.out.println("\n========================================="); // 改行
			dbAccess.updateExec(deleteSql);	// 全ての行を削除
			System.out.println("========================================="); // 改行
			System.out.println("全ての行を取得して表示");
			
			
		String result3[][] = dbAccess.selectExec(selectSql3); // SELECT SQLのQUERYを実行
														 // 配列に結果を入れる
		
			// 二次元配列を全て出力
		    for ( int i = 0; i < result3.length; i++ ) { 
		        System.out.println();
		        for ( int j = 0; j < result3[i].length; j++ ) {
		          System.out.print(result3[i][j] + "\t\t");
		        }
		    }
		    
			System.out.println("\n=========================================");
		
		dbAccess.rollback();
		
			System.out.println("=========================================");
		
		System.out.println("全ての行を取得して表示");
		
		
		result3 = dbAccess.selectExec(selectSql3); // SELECT SQLのQUERYを実行
														 // 配列に結果を入れる
		
			// 二次元配列を全て出力
		    for ( int i = 0; i < result3.length; i++ ) { 
		        System.out.println();
		        for ( int j = 0; j < result3[i].length; j++ ) {
		          System.out.print(result3[i][j] + "\t\t");
		        }
		    }
	    
			System.out.println("\n=========================================");
			
		dbAccess.disconnect();
	}
}