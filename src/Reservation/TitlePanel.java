package Reservation;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {

	   JLabel titleLabel = new JLabel("���� ����");
	   JLabel titleLabel2 = new JLabel(" | ");
	   JLabel titleLabel1 = new JLabel("�󿵽ð�ǥ");
	   
	   Font titleFont = new Font("����",Font.BOLD, 20);
	   
	public TitlePanel() {
	  
	  titleLabel.setFont(titleFont); 
	  titleLabel2.setFont(titleFont);
	  titleLabel1.setFont(titleFont);
	  add(titleLabel);
	  add(titleLabel2);
	  add(titleLabel1);
	  setBounds(10,10,1165,30);
	  //setBackground(Color.orange);
	}

}
