import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PeopleInsert {
  public static void main(String[] args) throws Exception{
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    if (args.length != 3) {
      System.out.println("usage: java -classpath .:/root/git_jupyter_notebook/Java/postgresql-42.1.1.jar PostgresInsert name age address");
      System.exit(1);
    }
    
    try{
      //# 接続
      connection = ConnectDb.getConnection();
      statement = connection.createStatement();
      
      //# SQL文発行
      String name = args[0];
      int age = Integer.parseInt(args[1]);
      String address = args[2];
      statement.executeUpdate("INSERT INTO people (name, age, address) VALUES ('" + name + "', " + age + ", '" + address + "')");

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
