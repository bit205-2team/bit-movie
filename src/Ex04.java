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
        // ���� ���� ������ ���� 10���� �����մϴ�.
        card = new CardLayout(10, 10);
        c.setLayout(card);
         
        // ���, ��, �ٳ��� ��ư�� ��Ĩ�ϴ�.
        // ����� Ŭ���ϸ� �谡 ������, 
        // �踦 Ŭ���ϸ� �ٳ����� ��µǴ� ���̾ƿ��Դϴ�.
        btn1 = new JButton("���");
        btn2 = new JButton("��");
        btn3 = new JButton("�ٳ���");
         
        // ��ư�� Ŭ������ �� �׼��� �����մϴ�.
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        // ������ �̸��� �����մϴ�.
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
    // ����ڰ� ��ư�� Ŭ������ �� 
    // ���� ȭ������ ��ȯ��ŵ�ϴ�.
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        // ��� ��ư�� �������� �� �޽���
        if(str.equals("���")) {
            System.out.println("����Դϴ�.");
        // �� ��ư�� �������� �� �޽���
        }else if(str.equals("��")) {
            System.out.println("���Դϴ�.");
        }else {
        // �ٳ��� ��ư�� �������� �� �޽���
            System.out.println("�ٳ����Դϴ�.");
        }
        card.next(c);       
    }
}