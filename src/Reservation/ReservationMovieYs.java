package Reservation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ReservationMovieYs extends JPanel{//넘길때 JPane으로 바꾸기 implements ActionListener
	JPanel detailMenuPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 30));//빠른예매/상영시간표 north
	JPanel viewCenterPane = new JPanel();//날짜랑 시간표 들어갈 큰 pane center
	JScrollPane centerScroll; //스크롤안에 상영시간표 넣어줌

	
	Font detailMenuFnt = new Font("굴림",Font.BOLD,25);
	
	
	//전체창(default 값)
	public ReservationMovieYs() {
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH,detailMenuPane);
		JButton quickReserveLbl = new JButton("빠른 예매");
		JLabel boundaryLbl = new JLabel("|",JLabel.CENTER);
		JButton movTableLbl = new JButton("상영시간표");
		quickReserveLbl.setFont(detailMenuFnt);
		boundaryLbl.setFont(detailMenuFnt);
		movTableLbl.setFont(detailMenuFnt);
		
		quickReserveLbl.setBackground(Color.WHITE);
		movTableLbl.setBackground(Color.WHITE);
		
		detailMenuPane.add(quickReserveLbl);
		detailMenuPane.add(boundaryLbl);
		detailMenuPane.add(movTableLbl);

		QuickReservation qs = new QuickReservation();
		add(BorderLayout.CENTER,qs);
	}
}
