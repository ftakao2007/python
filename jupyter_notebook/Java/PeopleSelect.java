import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PeopleSelect {
  public static void main(String[] args) throws Exception{
    Statement statement = null;
    ResultSet resultSet = null;
    Connection connection = null;
    
    try{
      //# 接続したオブジェクトをConnectDbから取得し、Statementオブジェクトを生成
      //# ここでConnection connectionとすろとfinallyでcannot find symbolのエラーになる
      //# https://stackoverflow.com/questions/15281640/cannot-find-symbol-when-trying-to-close-i-o-objects
      //# Connection connection = ConnectDb.getConnection();
      connection = ConnectDb.getConnection();
      statement = connection.createStatement();
      
      //# SQL文発行
      resultSet = statement.executeQuery("SELECT * FROM people");

      //# 値の取得
      List<String> fields = new ArrayList<String>();
      ResultSetMetaData rsmd = resultSet.getMetaData();
      for (int i = 1; i <= rsmd.getColumnCount(); i++) {
        fields.add(rsmd.getColumnName(i));
      }

      //# 結果の出力
      int rowCount = 0;
      while (resultSet.next()) {
        rowCount++;

        System.out.println("---------------------------------------------------");
        System.out.println("--- Rows:" + rowCount);
        System.out.println("---------------------------------------------------");

        //# 値は、「resultSet.getString(<フィールド名>)」で取得する。
        for (String field : fields) {
          System.out.println(field + ":" + resultSet.getString(field));
        }
      }
    } finally {
      //# 接続を切断する
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connection != null) {
        connection.close();
      }
    }
  }
}
