
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
//#import java.util.ArrayList;
//#import java.util.List;

class PrefFrame extends Frame implements ActionListener {
    //# コンポーネントを定義。各クラスのメソッドが利用できるようにメソッド外で定義する
    Label lb1;
    TextArea txtar1;
    Button btn1, btn2, btn3;
    
    public PrefFrame(String title) {
        setTitle(title);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //# ラベル。BorderLayoutの頭にラベルを表示
        lb1 = new Label("ボタンをクリックしてください。",Label.CENTER);
        add(lb1, BorderLayout.NORTH);
        
        //# テキストエリア。BorderLayoutの中央にテキストエリアを表示
        txtar1 = new TextArea();
        add(txtar1, BorderLayout.CENTER);
        
        //# パネル。GridLayoutを指定
        Panel pn1 = new Panel();
        pn1.setLayout(new GridLayout(1, 3));
        
        //# ボタンの設定とパネルへ追加
        btn1 = new Button("表示");
        btn1.addActionListener(this);
        pn1.add(btn1);
        
        //# ボタンの設定とパネルへ追加
        btn2 = new Button("クリア");
        btn2.addActionListener(this);
        pn1.add(btn2);

        //# ボタンの設定とパネルへ追加
        btn3 = new Button("終了");
        btn3.addActionListener(this);
        pn1.add(btn3);
        
        //# パネル。BorderLayoutの下にパネルを表示
        add(pn1, BorderLayout.SOUTH);
    }
  
    //# イベントが発生すると呼び出されるイベントハンドラのactionPerfomed()メソッド
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == btn1) {
            prefDisplay();
        } else if (e.getSource() == btn2) {
            txtar1.setText("");
        } else {
            System.exit(0);
        }
    }
    
    //#private void prefDisplay () {
    private void prefDisplay () {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        
        try {
            //# DB接続
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://10.136.3.189:5432/jsd_development", "jsd", "pass");
            statement = connection.createStatement();
            
            //# SQL発行
            resultSet = statement.executeQuery("SELECT * FROM people");

            //# 値の取得
            StringBuffer temp = new StringBuffer();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                temp.append(id + " \n" + "    name: " + name + "\n    age: " + age + "\n    address: " + address + "\n\n");
            }

            txtar1.setText(temp.toString());

            //# DB切断
            statement.close();
            connection.close();
            connection.close();
            
        } catch(Exception e) {
            System.out.println("例外発生：" + e );
        }
    }
}

public class GUISql {
    public static void main(String args[]){
    
        PrefFrame frm = new PrefFrame("都道府県マスター");
        //# フレームの設定
        frm.setLocation(300,200);
        frm.setSize(250,350);
        frm.setBackground(Color.LIGHT_GRAY);
        frm.setVisible(true);
    }
}
