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
	
	Font menuFnt = new Font("굴림",Font.BOLD, 35);
	Font sortFnt = new Font("굴림",Font.BOLD, 20);//정렬폰트
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
	JPanel timeTitlePane = new JPanel();//시간
		JLabel timetitleLbl;
	JPanel timetablePane = new JPanel(new GridLayout(0,1));	
	JScrollPane timeScrollPane;	

	JPanel reservationPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton reservationBtn = new JButton("좌석 선택");

	Dimension dim = new Dimension(500,400);//영화/시간 전체패널 사이즈
	Dimension dim1 = new Dimension(200,400);//날짜 전체패널 사이즈
	Dimension dim2 = new Dimension(500,45);//각패널의 title패널 사이즈
	Dimension dim3 = new Dimension(500,360);//각 패널의 SOUTH패널 사이즈
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

			if(movieName != null && movieDate != null) {//영화제목이랑 날짜가 클릭됐을때 상영시간표를 출력한다.
				
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
	//WEST 영화선택 패널
	public void selectMovie() {		
		
		moviePane.setPreferredSize(dim);
		titlePane.setPreferredSize(dim2);
		
		//제목패널(titlePane)을 moviePane NORTH에 추가
		movLbl = new JLabel("영화");
		movLbl.setFont(menuFnt);
		titlePane.add(movLbl);
		titlePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));		
		moviePane.add(BorderLayout.NORTH,titlePane);
		
		//콤보박스 moviePane.CENTER에 추가
		sortBox.addItem("예매율순");
		sortBox.addItem("관람객순");		
		sortBox.setFont(sortFnt);
		ranksortPane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
		ranksortPane.add(sortBox);
		moviePane.add(BorderLayout.CENTER,ranksortPane);
		
		//영화 리스트 moviePane.SOUTH에 추가
		JPanel southPane = new JPanel(new GridLayout(0,1));
		
		List<MovieVO> movieList = dao.selectMovie();
		for(int i=0;i<movieList.size();i++) {
			MovieVO vo = movieList.get(i);
			movietitlePane = new MovieSchedule_Title(vo.getMname());
			southPane.add(movietitlePane);
			
			  movietitlePane.titleBtn.addActionListener(new ActionListener() { //영화이름
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
		
		//전체패널의 서쪽에 추가
		total.add(BorderLayout.WEST,moviePane);		
	}
	public void selectDate() {
		
		//날짜 제목 north에 넣음
		dateTitleLbl = new JLabel("날짜");
		dateTitleLbl.setFont(menuFnt);
		dateTitlePane.add(dateTitleLbl);		
		dateTitlePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));				
		datePane.add(BorderLayout.NORTH,dateTitlePane);
		
		//년월 패널 센터에 담음
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
	     
	    //datePane center에 담아줌
		total.add(BorderLayout.CENTER,datePane);
	}
	public void selectTime() {  	
		//title north에 추가
		timetitleLbl = new JLabel("시간");
		timetitleLbl.setFont(menuFnt);
		timeTitlePane.add(timetitleLbl);		
		timeTitlePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
		timePane.add(BorderLayout.NORTH,timeTitlePane);		
		
		timePane.add(BorderLayout.CENTER,timetablePane);
		//btn south 추가
		reservationPane.add(reservationBtn);
		reservationBtn.addActionListener(new ActionListener()  {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("좌석선택 버튼 ㅅ클릭");
		         if(movieTime != null) {
		        	 scheduleCode = dao.thrwoScheuleCode(movieName, movieDate, movieTime);
		        	 System.out.println("좌석선택 버튼 ㅅ클릭 카드 가기전");
		        	 fCard.show(fCardPane,"좌석선택");
		         }
			}
		});
		timePane.add(BorderLayout.SOUTH,reservationPane);
	
		timeTitlePane.setPreferredSize(dim2);
		total.add(BorderLayout.EAST,timePane);
		
	}
	
	public void fCardLayout() {//viewPane 영역에 표기할 카트레이아웃
		fCardPane = new JPanel(fCard);		
		SeatReservation res = new SeatReservation(scheduleCode);		
		fCardPane.add(total,"빠른예매");
		fCardPane.add(res,"좌석선택");
		add(fCardPane);
		
	}	
	


}
	