import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Theater extends JPanel {
	JPanel panNorth, centerPane, southPane;
	JLabel northlabel, imgLabel,imgLable1;
	TitledBorder line = new TitledBorder(new TitledBorder(new LineBorder(Color.black,2)));
	public Theater() {
		
		panNorth = new JPanel();
		panNorth.setBackground(Color.white);
		centerPane = new JPanel();
		centerPane.setBackground(Color.white);
		southPane = new JPanel();
		southPane.setBackground(Color.white);
		northlabel = new JLabel("극장소개");
		northlabel.setFont(new Font("굴림",Font.BOLD,25));
		panNorth.add(northlabel);
		
		
	   ImageIcon img1 = new ImageIcon(".\\img\\13.jpg.jfif");
	   Image img = img1.getImage();
	   Image im2 = img.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
	   ImageIcon img2 = new ImageIcon(im2);
	   imgLabel = new JLabel(img2);
	   
	   ImageIcon imgc1 = new ImageIcon(".\\img\\BITCINEMA.jpg");
	   Image imgc = imgc1.getImage();
	   Image imc2 = imgc.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
	   ImageIcon imgc2 = new ImageIcon(imc2);
	   imgLable1 = new JLabel(imgc2);
	   
	   
	   
	   centerPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	   centerPane.setBorder(line);
	   southPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	   southPane.setBorder(line);
	   southPane.add(imgLable1);
	   centerPane.add(imgLabel);
	   String[] aa = {"서울특별시 마포구 신수동 000-00","5관/550석","0000-0000"};
	   Box box = Box.createVerticalBox();

	   
	   for(int i =0; i < aa.length; i++) {
		  JLabel label = new JLabel(aa[i]);
		  label.setFont(new Font("굴림",Font.BOLD,20));
		  box.add(label);
		  box.add(Box.createVerticalStrut(5));
	  }
	   
	   String[] aa1 = {"지하철","-신촌역 6번 출구","서강대역 0번 출구","버스","-604,7044,909"};
	   Box box1 = Box.createVerticalBox();
	   JLabel lb = new JLabel("오시는길");
	   lb.setFont(new Font("굴림",Font.BOLD,25));
	 
	   box1.add(lb);
	   box1.add(Box.createVerticalStrut(30));

	   for(int i =0; i < aa1.length; i++) {
		  JLabel label = new JLabel(aa1[i]);
		  label.setFont(new Font("굴림",Font.BOLD,20));
		  
		  if(i==3) {box1.add(Box.createVerticalStrut(15));}
		  
		  box1.add(label);
		  box1.add(Box.createVerticalStrut(5));
		 
	  }
	  
	   setLayout(new BorderLayout());
	   centerPane.add(Box.createHorizontalStrut(80));
	   centerPane.add(box);
	  
	   add(BorderLayout.NORTH,panNorth);
	   add(BorderLayout.CENTER,centerPane);
	   
	   add(BorderLayout.SOUTH,southPane);
	   southPane.add(Box.createHorizontalStrut(80));
	   southPane.add(box1);
	}

	
	
}
