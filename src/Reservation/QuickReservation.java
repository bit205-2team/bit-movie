package Reservation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

public class QuickReservation extends JPanel{
	
	Font menuFnt = new Font("굴림",Font.BOLD, 35);
	Font sortFnt = new Font("굴림",Font.BOLD, 20);//정렬폰트

	
	//selectmovie
	JPanel moviePane = new JPanel(new BorderLayout());	
	JPanel titlePane = new JPanel();
		JLabel movLbl;
	JPanel ranksortPane = new JPanel(new FlowLayout(FlowLayout.LEFT));	
		JComboBox<String> sortBox = new JComboBox<String>();
	JScrollPane movieScrollPane =  new JScrollPane();		
	String[] movieList = {"블랙위도우","크루엘라","미션임파서블"};
	String[] theater = {"2D 1관 1층","2D 2관 1층","2D 4관 4층"}; 
	String[] movietime = {"09:30","13:30","24:10"};
	String[] seatStr = {"20석","3석","10석"};
	
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
	JScrollPane timeScrollPane = new JScrollPane();	

	JPanel reservationPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton reservationBtn = new JButton("좌석 선택");

	Dimension dim = new Dimension(500,400);//영화/시간 전체패널 사이즈
	Dimension dim1 = new Dimension(200,400);//날짜 전체패널 사이즈
	Dimension dim2 = new Dimension(500,45);//각패널의 title패널 사이즈
	Dimension dim3 = new Dimension(500,360);//각 패널의 SOUTH패널 사이즈
	Dimension dim4 = new Dimension(500,350);
	public QuickReservation() {
		setLayout(new BorderLayout());
		
		selectMovie();
		selectDate();
		selectTime();
		
//		setSize(1200,750);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	}

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
		for(int i=0;i<movieList.length;i++) {
			southPane.add(new MovieSchedule_Title(movieList[i]));
		}
		southPane.setPreferredSize(dim3);
		movieScrollPane.setViewportView(southPane);
		moviePane.add(BorderLayout.SOUTH,movieScrollPane);
		
		//전체패널의 서쪽에 추가
		add(BorderLayout.WEST,moviePane);
		
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
			if(dow==1) {
	    		dateBtn = new JButton(dateStr[i]);
	    		dateBtn.setForeground(Color.RED);
	    	}else if(dow==7){
	    		dateBtn = new JButton(dateStr[i]);
	    		dateBtn.setForeground(Color.BLUE);
	    	}
			
			dateBtn.setFont(sortFnt);
			dateListPane.add(dateBtn);
			dateBtn.setBorderPainted(false);
	    	dateBtn.setContentAreaFilled(false);
		}
		datePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
		datePane.add(BorderLayout.SOUTH,dateListPane);
		
		datePane.setPreferredSize(dim1);
		dateTitlePane.setPreferredSize(dim2);
		dateListPane.setPreferredSize(dim3);
	     
	    //datePane center에 담아줌
		add(BorderLayout.CENTER,datePane);
	}
	
	 
	
	public void selectTime() {  
		
		//title north에 추가
		timetitleLbl = new JLabel("시간");
		timetitleLbl.setFont(menuFnt);
		timeTitlePane.add(timetitleLbl);		
		timeTitlePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
		timePane.add(BorderLayout.NORTH,timeTitlePane);		
		
		//center timebtn 추가
		for(int i=0;i<theater.length;i++) {
			timetablePane.add(new MovieSchedule_theater_Time(theater[i]));
		}
		timetablePane.setPreferredSize(dim4);
		timeScrollPane.setViewportView(timetablePane);
		timePane.add(BorderLayout.CENTER,timeScrollPane);
		//btn south 추가
		reservationPane.add(reservationBtn);
		timePane.add(BorderLayout.SOUTH,reservationPane);
	
		timePane.setPreferredSize(dim);
		timeTitlePane.setPreferredSize(dim2);
		add(BorderLayout.EAST,timePane);
	}
	

	
	

}
	