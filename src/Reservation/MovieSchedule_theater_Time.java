package Reservation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

	String[] movietime = {"09:30","13:30","24:10"};//10시이전 조조 /11시이후 심야
	String[] seatStr = {"20석","3석","10석"};
	
	public MovieSchedule_theater_Time() {
		
	}
	
	public MovieSchedule_theater_Time(String theater) {

		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		theaterLbl = new JLabel(theater);
		theaPane.add(theaterLbl);//상영관
		
		for(int i=0;i<movietime.length;i++) {
			timeBtn = new JButton(movietime[i]);
			timeseatPane.add(timeBtn);//상영시간
			timeseatPane.add(new JLabel(seatStr[i]));//남은 좌석
			timeBtn.setBackground(new Color(224, 224, 224));
//			timeBtn.setBorderPainted(false);
		}
		theaPane.setBackground(Color.WHITE);
		timeseatPane.setBackground(Color.WHITE);
		add(theaPane);
		add(timeseatPane);
			
//		setSize(600,500);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}


//	public static void main(String[] args) {
//		new MovieSchedule_theater_Time("2관 3층");
//
//	}

}
