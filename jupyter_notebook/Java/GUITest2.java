
import java.awt.*;
import java.awt.event.*;

class PrefFrame extends Frame {
  public PrefFrame(String title) {
    setTitle(title);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}

public class GUITest2 {
  public static void main(String args[]){
    PrefFrame frm = new PrefFrame("都道府県マスター");
    frm.setLocation(300, 200);
    frm.setSize(250, 350);
    frm.setBackground(Color.LIGHT_GRAY);
    frm.setVisible(true);
    
    //# 二つ目のWindow
    PrefFrame frm2 = new PrefFrame("都道府県マスター2");
    frm2.setLocation(500, 200);
    frm2.setSize(350, 450);
    frm2.setBackground(new Color(255, 200, 0));
    frm2.setVisible(true);
  }
}
