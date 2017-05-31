import java.sql.Connection;
import java.sql.DriverManager;

class ConnectDb {
  static Connection getConnection() throws Exception{
    Connection con = null;
    
    //# 接続
    con = DriverManager.getConnection("jdbc:postgresql://10.136.3.189:5432/jsd_development", "jsd", "pass");
    return con;
  }
}
