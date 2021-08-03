package Reservation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DBconnection.MovieVO;

public class MovieSchedule_Title extends JPanel{
	JButton titleBtn;
	
	public MovieSchedule_Title(String movieList) {
//		JPanel ageTitlePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		ImageIcon ageTwelve = new ImageIcon("Img/12.jpg");
		JLabel ageLbl = new JLabel(ageTwelve);
		
		//add(ageLbl);
		titleBtn = new JButton(movieList);
		setBackground(Color.WHITE);
		add(titleBtn);
		titleBtn.setBorderPainted(false);
		titleBtn.setContentAreaFilled(false);
		
	}


}

//package Reservation;
//
//import java.awt.Color;
//import java.awt.FlowLayout;
//import java.util.List;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//import DBconnection.MovieVO;
//
//public class MovieSchedule_Title extends JPanel{
//
//	
//	public MovieSchedule_Title(String movieList) {
////		JPanel ageTitlePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		setLayout(new FlowLayout(FlowLayout.LEFT));
//		title(movieList);
//	}
//	public JButton title(String movieList) {
//		ImageIcon ageTwelve = new ImageIcon("Img/12.jpg");
//		JLabel ageLbl = new JLabel(ageTwelve);
//		JButton movieTitle;
//		
//		add(ageLbl);
//		movieTitle = new JButton(movieList);
//		setBackground(Color.WHITE);
//		add(movieTitle);
//		
//		return movieTitle;
//	}
//
//}
