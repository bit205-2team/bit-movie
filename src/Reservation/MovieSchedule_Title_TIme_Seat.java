package Reservation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MovieSchedule_Title_TIme_Seat extends JPanel{
	String[] theater = {"2D 1�� 1��","2D 2�� 1��","2D 4�� 4��"}; 
	String[] movielist = {"��������","ũ�翤��","�̼����ļ���"};
//	JPanel jj = new JPanel(new GridLayout(0,1));
//	JScrollPane ttscrollPane;		 
	
	public MovieSchedule_Title_TIme_Seat() {
	
		titleTimeTotalPane();//
		setLayout(new GridLayout(0,1));	
//		setSize(900,500);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public void titleTimeTotalPane() {//��ȭ����/�󿵰�/�ð� ���� �г�
		
		//setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		//	setBorder(new TitledBorder(new LineBorder(Color.GRAY)));
		
		for(int i=0;i<movielist.length;i++) {
			add(new MovieSchedule_Title(movielist[i]));
			
			for(int j=0;j<theater.length;j++) {
				add(new MovieSchedule_theater_Time(theater[j]));
			}
		}
				
//		ttscrollPane = new JScrollPane(jj);
//		add(ttscrollPane);
		
	}
	
//	public void setMovie(String movieList) {
//		JPanel ageTitlePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		ImageIcon ageTwelve = new ImageIcon("Img/12.jpg");
//		JLabel ageLbl = new JLabel(ageTwelve);
//		JLabel movieTitle;
//	 	
//		ageTitlePane.add(ageLbl);
//		movieTitle = new JLabel(movieList);
//		ageTitlePane.setBackground(Color.WHITE);
//		ageTitlePane.add(movieTitle);
//		add(ageTitlePane);
//	//	add(BorderLayout.NORTageTitlePane);
//	}
//	public static void main(String[] args) {
//		
//		new MovieSchedule_Title_TIme_Seat();
//	}

}
