
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SwingEX11 extends JFrame implements ActionListener{

	JScrollPane scrollPane;
	JButton jb,jb2;
	ImageIcon img;
	JPanel jp;
	int num = 0;
	public SwingEX11() {
		backImage();
		setSize(1500,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
 public void backImage() {
	String [] ss = {"blackwidow.jfif","bossbaby.jfif","cruella.jfif"};
	jb = new JButton("버튼1");
	jb2 = new JButton("버튼2");
	jp = new JPanel(new BorderLayout()) {
		public void paintComponent(Graphics g) {
				img = new ImageIcon(".\\src\\img\\"+ss[num]);// = new ImageIcon("./src/img/"+ss);
				 Image img1 = img.getImage();
				 Image im2 = img1.getScaledInstance(1500, 800, Image.SCALE_SMOOTH);
				 ImageIcon img2 = new ImageIcon(im2);

				 g.drawImage(img2.getImage(),0,0,null);
				 setOpaque(false);
				 super.paintComponent(g);
		}
	 };
	 jp.add(BorderLayout.WEST,jb);
	 jp.add(BorderLayout.EAST,jb2);
	 add(jp);
	 System.out.println("버튼11ㄴ");
	 jb.addActionListener(this);
	 System.out.println("버튼111111ㄴ");
	 jb2.addActionListener(this);
	 }
 
 public static void main(String [] args) {
	 new SwingEX11();
 
 }


public void actionPerformed(ActionEvent e) {
	Object event = e.getSource();
	if( event == jb) {
		System.out.println("버튼1");
			if(num==0) {
				num=2;
				jp.setVisible(false);
				jp.setVisible(true);
			}else {
				num--; 
				jp.setVisible(false);
				jp.setVisible(true);
		}
	}else if(event == jb2) {
		if(num==2) {
			num=0; 
			jp.setVisible(false);
			jp.setVisible(true);
			
			
		}else  {
			num++;
			jp.setVisible(false);
			jp.setVisible(true);
		}
	
	}
	
}
}

