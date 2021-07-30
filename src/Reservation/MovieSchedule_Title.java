package Reservation;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MovieSchedule_Title extends JPanel{

	
	public MovieSchedule_Title(String movieList) {
//		JPanel ageTitlePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		ImageIcon ageTwelve = new ImageIcon("Img/12.jpg");
		JLabel ageLbl = new JLabel(ageTwelve);
		JButton movieTitle;
	 	
		add(ageLbl);
		movieTitle = new JButton(movieList);
		setBackground(Color.WHITE);
		add(movieTitle);
	}

}
