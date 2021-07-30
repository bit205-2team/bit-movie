package Reservation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
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

public class ReservationMovie extends JFrame{//넘길때 JPane으로 바꾸기
	JPanel setViewPane = new JPanel(new BorderLayout());//baseframe에서 viewpane안에 들어갈 pane
	JPanel detailMenuPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 30));//빠른예매/상영시간표
	JPanel viewCenterPane = new JPanel(new BorderLayout());//날짜랑 시간표 들어갈 큰 pane
	JPanel datePane = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30)); //날짜 들어갈 pane
	JPanel timeTablePane = new JPanel();//상영시간표 들어갈 pane
	JScrollPane movTablesp = new JScrollPane(timeTablePane); //스크롤안에 상영시간표 넣어줌
	
	Font detailMenuFnt = new Font("굴림",Font.BOLD,25);
	
	 String[] dateStr = new String[7];
	 JLabel dateLbl;
	 JLabel myLbl;
	 String month;
	
	
	//전체창(default 값)
	public ReservationMovie() {
		setViewPane.add(BorderLayout.NORTH,detailMenuPane);
		JLabel quickReserveLbl = new JLabel("빠른 예매");
		JLabel boundaryLbl = new JLabel("|",JLabel.CENTER);
		JLabel movTableLbl = new JLabel("상영시간표");
		quickReserveLbl.setFont(detailMenuFnt);
		boundaryLbl.setFont(detailMenuFnt);
		movTableLbl.setFont(detailMenuFnt);
		
		quickReserveLbl.setBackground(Color.WHITE);
		movTableLbl.setBackground(Color.WHITE);
		
		detailMenuPane.add(quickReserveLbl);
		detailMenuPane.add(boundaryLbl);
		detailMenuPane.add(movTableLbl);
		
		setViewPane.add(viewCenterPane);
		
		//dbtest
		MovieDAO dao = new MovieDAO();
		List list = dao.allRecord();
		
		
		//빠른예매 메소드
	//	quickReservation();
		
		//이메소드 나중에 이벤트처리 메소드로 옮기기
		movieSchedule();
		
		
		//test용 / 넘길때 빼기
		add(setViewPane);
		setSize(1000,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	}
	
	//빠른예매(defaultmenu)
	public void quickReservation(){
		
	}

	
	//상영시간표 페이지 패널
	public void movieSchedule() {
		viewCenterPane.add(BorderLayout.NORTH,datePane);
		viewCenterPane.add(movTablesp);
		
		//<- 버튼
		ImageIcon icon = new ImageIcon("img/img1.png");
		Image img = icon.getImage();
		Image img2 = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(img2);
		
		//-> 버튼
		ImageIcon icon3 = new ImageIcon("img/img2.jpg");
		Image img3 = icon3.getImage();
		Image img4 = img3.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon icon4 = new ImageIcon(img4);
		
		JLabel backLbl = new JLabel(icon2);		
		JLabel afterLbl = new JLabel(icon4);
		
		
		backLbl.setFont(detailMenuFnt);
		afterLbl.setFont(detailMenuFnt);
		datePane.add(backLbl);
		
		//datePane에 날짜 넣어준 메소드 호출		
		setScheduleDate();
		
		datePane.add(afterLbl);
		
		
		//box로 시간표구현하기
		Box title = Box.createHorizontalBox();
		Box cinemaInfo = Box.createHorizontalBox();
		Box time = Box.createHorizontalBox();
		
//		do {
//			for(int i=0;i<2;i++) {
//				
//			}
//		}
		
		
		
		
		
		
		
	//	timeTablePane.setLayout(new BoxLayout(timeTablePane,BoxLayout.Y_AXIS));
//		
//		JPanel titlePane = new JPanel(new BoxLayout(titlePane,BoxLayout.X_AXIS));
//			JLabel titleLbl = new JLabel();
//		titlePane.add(titleLbl);
//		timeTablePane.add(titlePane);
//		
//		JPanel cinemaPane = new JPanel(new BoxLayout(titlePane,BoxLayout.X_AXIS));
//			JLabel kindLbl = new JLabel();
//			JLabel floorLbl = new JLabel();
//			cinemaPane.add(kindLbl);
//			cinemaPane.add(floorLbl);
//		timeTablePane.add(cinemaPane);
		
		//박스는 박스레이아웃에만 담길수있는지 확인하기
//		Box title = Box.createHorizontalBox();
//		Box cinemaInfo = Box.createHorizontalBox();
//		Box time = Box.createHorizontalBox();
//		
//		for(int i=0;i<상영관수배열.length;i++) {
//			JLabel floor = new JLabel(상영관수배열[i]);
//			cinemaInfo.add(fioor);
//			
//			do {
//				title.add(상영영화배열[]);
//				
//				while(상영시간배열크기만큼) {
//					for(int j=0;j<상영시간배열.length;j++) {				
//						JLabel movietime = new JLabel(상영시간배열[j]);
//						time.add(movietime);
//						
//						//timeTablePane의 넓이를 벗어나면 줄바꾸기
//						int panew = timeTablePane.getWidth();
//						if(추가된라벨의width가 panew의 값보다크면) {
//							//줄바꾸기
//						}
//					}
//					
//				}
//			while(상영영화배열크기만큼)	
//			
//		}
//		
//			
//		for(int i=0;i<;i++) {
//			JLabel lbl = new JLabel();
//		}
//		
		
		
	}
	

	//상영스케쥴 날짜 세팅
	public void setScheduleDate() {
		  Calendar now = Calendar.getInstance();   
		  //년월라벨
		  SimpleDateFormat yearMonth = new SimpleDateFormat("YYYY MM");      
		  if(dateStr[6] == "31") {
			  now.add(Calendar.MONTH, 1);
			  month = yearMonth.format(now.getTime());
			  myLbl = new JLabel(month);
		  }else {      
			  String month = yearMonth.format(now.getTime());
			  myLbl = new JLabel(month);
		  }
		  datePane.add(myLbl);
		  
		  //date라벨
	      SimpleDateFormat dateFormat = new SimpleDateFormat("E dd");
	      for(int i=0;i<7;i++) {
	    	  if(i>0) {
	    		  now.add(Calendar.DAY_OF_WEEK, 1);	    		  
	    	  }
	         dateStr[i] = dateFormat.format(now.getTime());
	         dateLbl = new JLabel(dateStr[i]);
	         datePane.add(dateLbl);

	      }
	      		
	}
	

	public static void main(String[] args) {
		new ReservationMovie();
	}

}
