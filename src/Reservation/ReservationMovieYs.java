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

public class ReservationMovieYs extends JPanel{//�ѱ涧 JPane���� �ٲٱ� implements ActionListener
	JPanel detailMenuPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 30));//��������/�󿵽ð�ǥ north
	JPanel viewCenterPane = new JPanel();//��¥�� �ð�ǥ �� ū pane center
	JScrollPane centerScroll; //��ũ�Ѿȿ� �󿵽ð�ǥ �־���

	
	Font detailMenuFnt = new Font("����",Font.BOLD,25);
	
	
	//��üâ(default ��)
	public ReservationMovieYs() {
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH,detailMenuPane);
		JButton quickReserveLbl = new JButton("���� ����");
		JLabel boundaryLbl = new JLabel("|",JLabel.CENTER);
		JButton movTableLbl = new JButton("�󿵽ð�ǥ");
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
