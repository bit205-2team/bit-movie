package Reservation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DBconnection.MovieVO;


public class MovieSchedule_theater_Time extends JPanel{
	
	ImageIcon jojo = new ImageIcon("img/sun.png");
	ImageIcon night = new ImageIcon("img/moon.png");
	JLabel jojoLbl = new JLabel(jojo);
	JLabel nightLbl = new JLabel(night);
	
	JPanel theaPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel theaterLbl;
	JPanel timeseatPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton timeBtn;
		JLabel seat;

	public MovieSchedule_theater_Time() {
		
	}
	
	public MovieSchedule_theater_Time(List<MovieVO> theaterList,List<MovieVO> timeList) {

		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));		
		try {	
			theaterLbl = new JLabel(theaterList.get(0).getTheater());	
			theaPane.add(theaterLbl);
			Iterator<MovieVO> time = timeList.iterator();
			while(time.hasNext()) {
				   MovieVO one = time.next();
				   timeBtn = new JButton(one.getStart_time());
				   timeseatPane.add(timeBtn);
			}
		theaPane.setBackground(Color.WHITE);
		timeseatPane.setBackground(Color.WHITE);
		add(theaPane);
		add(timeseatPane);
		updateUI();
		}catch(Exception e) {
			System.out.println("시간 판넬 오류!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
	}
}
