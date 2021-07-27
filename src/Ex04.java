import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame; 
 
 
public class Ex04 extends JFrame implements ActionListener{
    Container c;
    CardLayout card;
    JButton btn1, btn2, btn3;
    Ex04() {
        c = getContentPane();
        // 가로 세로 여백을 각각 10으로 설정합니다.
        card = new CardLayout(10, 10);
        c.setLayout(card);
         
        // 사과, 배, 바나나 버튼을 겹칩니다.
        // 사과를 클릭하면 배가 나오고, 
        // 배를 클릭하면 바나나가 출력되는 레이아웃입니다.
        btn1 = new JButton("사과");
        btn2 = new JButton("배");
        btn3 = new JButton("바나나");
         
        // 버튼을 클릭했을 때 액션을 설정합니다.
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        // 임의의 이름을 지정합니다.
        c.add("a", btn1);
        c.add("b", btn2);
        c.add("c", btn3);
         
         
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
         
    }
    public static void main(String[] args) {         
        Ex04 c = new Ex04();
        c.setSize(400, 400);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setVisible(true);
    } 
    // 사용자가 버튼을 클릭했을 때 
    // 다음 화면으로 전환시킵니다.
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        // 사과 버튼을 선택했을 때 메시지
        if(str.equals("사과")) {
            System.out.println("사과입니다.");
        // 배 버튼을 선택했을 때 메시지
        }else if(str.equals("배")) {
            System.out.println("배입니다.");
        }else {
        // 바나나 버튼을 선택했을 때 메시지
            System.out.println("바나나입니다.");
        }
        card.next(c);       
    }
}