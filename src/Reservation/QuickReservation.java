package Reservation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import DBconnection.MovieVO;
import DBconnection.ReservationDAO;

public class QuickReservation extends JPanel implements ActionListener{
	
	Font menuFnt = new Font("����",Font.BOLD, 35);
	Font sortFnt = new Font("����",Font.BOLD, 20);//������Ʈ
	String movieName;
	String movieDate;
	String movieTime;
	String scheduleCode;
	JPanel fCardPane;
	CardLayout fCard = new CardLayout();
	
	JPanel total = new JPanel();

	//selectmovie
	JPanel moviePane = new JPanel(new BorderLayout());	
	JPanel titlePane = new JPanel();
		JLabel movLbl;
	JPanel ranksortPane = new JPanel(new FlowLayout(FlowLayout.LEFT));	
		JComboBox<String> sortBox = new JComboBox<String>();
	JScrollPane movieScrollPane = new JScrollPane();		
	MovieSchedule_Title movietitlePane;
	MovieSchedule_theater_Time theaterTimePane;
	//Object movieName;
	
	//selectdate
	JPanel datePane = new JPanel(new BorderLayout());
	JPanel dateTitlePane = new JPanel();
		JLabel dateTitleLbl;
	JPanel yearMonthPane = new JPanel();
		JLabel yearMonthLbl;
	JPanel dateListPane = new JPanel(new GridLayout(0,1));
		JButton dateBtn;
		String[] dateStr = new String[7];
	JScrollPane dateScrollPane;
	
	//selecttime
	JPanel timePane = new JPanel(new BorderLayout());
	JPanel timeTitlePane = new JPanel();//�ð�
		JLabel timetitleLbl;
	JPanel timetablePane = new JPanel(new GridLayout(0,1));	
	JScrollPane timeScrollPane;	

	JPanel reservationPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton reservationBtn = new JButton("�¼� ����");

	Dimension dim = new Dimension(500,400);//��ȭ/�ð� ��ü�г� ������
	Dimension dim1 = new Dimension(200,400);//��¥ ��ü�г� ������
	Dimension dim2 = new Dimension(500,45);//���г��� title�г� ������
	Dimension dim3 = new Dimension(500,360);//�� �г��� SOUTH�г� ������
	Dimension dim4 = new Dimension(600,350);
	ReservationDAO dao = new ReservationDAO();
	
	public QuickReservation() {
		total.setLayout(new BorderLayout());
		selectTime();
		selectMovie();
		selectDate();
		fCardLayout();
		
 	
	}	
	public void actionPerformed(ActionEvent ae) {
		String event = ae.getActionCommand();
	}
	
	public void actionTest() {

			if(movieName != null && movieDate != null) {//��ȭ�����̶� ��¥�� Ŭ�������� �󿵽ð�ǥ�� ����Ѵ�.
				
				List<MovieVO> theaterList = dao.setMovieTheater(movieName,movieDate);
				List<MovieVO> timeList = dao.setMovieTime(movieName,movieDate);
				timetablePane.add(new MovieSchedule_theater_Time(theaterList,timeList));							 				
				timePane.add(BorderLayout.CENTER,timetablePane);
				updateUI();
				theaterTimePane.timeBtn.addActionListener(new ActionListener()  {
					@Override
					public void actionPerformed(ActionEvent e) {
						movieTime = e.getActionCommand();
					}
				});
			}
	}	
	//WEST ��ȭ���� �г�
	public void selectMovie() {		
		
		moviePane.setPreferredSize(dim);
		titlePane.setPreferredSize(dim2);
		
		//�����г�(titlePane)�� moviePane NORTH�� �߰�
		movLbl = new JLabel("��ȭ");
		movLbl.setFont(menuFnt);
		titlePane.add(movLbl);
		titlePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));		
		moviePane.add(BorderLayout.NORTH,titlePane);
		
		//�޺��ڽ� moviePane.CENTER�� �߰�
		sortBox.addItem("��������");
		sortBox.addItem("��������");		
		sortBox.setFont(sortFnt);
		ranksortPane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
		ranksortPane.add(sortBox);
		moviePane.add(BorderLayout.CENTER,ranksortPane);
		
		//��ȭ ����Ʈ moviePane.SOUTH�� �߰�
		JPanel southPane = new JPanel(new GridLayout(0,1));
		
		List<MovieVO> movieList = dao.selectMovie();
		for(int i=0;i<movieList.size();i++) {
			MovieVO vo = movieList.get(i);
			movietitlePane = new MovieSchedule_Title(vo.getMname());
			southPane.add(movietitlePane);
			
			  movietitlePane.titleBtn.addActionListener(new ActionListener() { //��ȭ�̸�
		            @Override
		            public void actionPerformed(ActionEvent ae) {
		               movieName = ae.getActionCommand();
		               actionTest();
		            }
		      });  
		}
		southPane.setPreferredSize(dim3);
		movieScrollPane.setViewportView(southPane);
		moviePane.add(BorderLayout.SOUTH,movieScrollPane);
		
		//��ü�г��� ���ʿ� �߰�
		total.add(BorderLayout.WEST,moviePane);		
	}
	public void selectDate() {
		
		//��¥ ���� north�� ����
		dateTitleLbl = new JLabel("��¥");
		dateTitleLbl.setFont(menuFnt);
		dateTitlePane.add(dateTitleLbl);		
		dateTitlePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));				
		datePane.add(BorderLayout.NORTH,dateTitlePane);
		
		//��� �г� ���Ϳ� ����
		Calendar now = Calendar.getInstance();  
		SimpleDateFormat yearMonth = new SimpleDateFormat("YYYY MM");
		String month = yearMonth.format(now.getTime());
		yearMonthLbl = new JLabel(month);
		yearMonthLbl.setFont(sortFnt);
		yearMonthPane.add(yearMonthLbl);
		yearMonthPane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
		datePane.add(BorderLayout.CENTER,yearMonthPane);		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("E dd");
		for(int i=0;i<7;i++) {
			if(i>0) {
				now.add(Calendar.DAY_OF_WEEK, 1);	    		  
			}
			dateStr[i] = dateFormat.format(now.getTime());
			dateBtn = new JButton(dateStr[i]);	
			int dow = now.get(Calendar.DAY_OF_WEEK);

			
			dateBtn.setFont(sortFnt);
			dateListPane.add(dateBtn);
			dateBtn.setBorderPainted(false);
	    	dateBtn.setContentAreaFilled(false);
	    	dateBtn.addActionListener(this);
	    	
	    	dateBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {		
					movieDate = ae.getActionCommand().split(" ")[1];//03
					actionTest();
	             }
	         });
	    	
		}
		datePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
		datePane.add(BorderLayout.SOUTH,dateListPane);
		
		datePane.setPreferredSize(dim1);
		dateTitlePane.setPreferredSize(dim2);
		dateListPane.setPreferredSize(dim3);
	     
	    //datePane center�� �����
		total.add(BorderLayout.CENTER,datePane);
	}
	public void selectTime() {  	
		//title north�� �߰�
		timetitleLbl = new JLabel("�ð�");
		timetitleLbl.setFont(menuFnt);
		timeTitlePane.add(timetitleLbl);		
		timeTitlePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
		timePane.add(BorderLayout.NORTH,timeTitlePane);		
		
		timePane.add(BorderLayout.CENTER,timetablePane);
		//btn south �߰�
		reservationPane.add(reservationBtn);
		reservationBtn.addActionListener(new ActionListener()  {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�¼����� ��ư ��Ŭ��");
		         if(movieTime != null) {
		        	 scheduleCode = dao.thrwoScheuleCode(movieName, movieDate, movieTime);
		        	 System.out.println("�¼����� ��ư ��Ŭ�� ī�� ������");
		        	 fCard.show(fCardPane,"�¼�����");
		         }
			}
		});
		timePane.add(BorderLayout.SOUTH,reservationPane);
	
		timeTitlePane.setPreferredSize(dim2);
		total.add(BorderLayout.EAST,timePane);
		
	}
	
	public void fCardLayout() {//viewPane ������ ǥ���� īƮ���̾ƿ�
		fCardPane = new JPanel(fCard);		
		SeatReservation res = new SeatReservation(scheduleCode);		
		fCardPane.add(total,"��������");
		fCardPane.add(res,"�¼�����");
		add(fCardPane);
		
	}	
	


}
	