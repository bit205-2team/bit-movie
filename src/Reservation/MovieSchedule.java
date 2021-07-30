package Reservation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MovieSchedule extends JPanel{
	
	JPanel datePane = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30)); //날짜 들어갈 pane	 
		String[] dateStr = new String[7];
		JButton dateBtn; //날짜라벨
		JLabel myLbl; //년월라벨
		String month;//월

	String[] theater = {"2D 1관 1층","2D 2관 1층","2D 4관 4층"}; 	
	Font detailMenuFnt = new Font("굴림",Font.BOLD,25);
	 
	//movieTimetable
	JScrollPane timeScrollPane;//timetablePane 들어갈 scroll
	JPanel timetablePane = new JPanel();	 	 
	JPanel ageTitlePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ImageIcon ageTwelve = new ImageIcon("Img/12.jpg");
	 	JLabel ageLbl = new JLabel(ageTwelve);
		JLabel movieTitle = new JLabel("블랙위도우");

	 
	Dimension size = new Dimension(900,100);
	
	public MovieSchedule() {
		setLayout(new BorderLayout());
		
		setDate();
		movieTimetable();
		
//		setSize(800,500);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE)
	}
	//datepane
 	public void setDate() {
 		datePane.setBackground(Color.WHITE);
 		datePane.setBorder(new TitledBorder(new LineBorder(Color.GRAY)));
 		add(BorderLayout.NORTH,datePane);		
 		
 		//<- 버튼
 		ImageIcon icon = new ImageIcon("img/back.png");
 		Image img = icon.getImage();
 		Image img2 = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
 		ImageIcon icon2 = new ImageIcon(img2);
 		
 		//-> 버튼
 		ImageIcon icon3 = new ImageIcon("img/after.png");
 		Image img3 = icon3.getImage();
 		Image img4 = img3.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
 		ImageIcon icon4 = new ImageIcon(img4);
 		
 		JButton backLbl = new JButton(icon2);		
 		JButton afterLbl = new JButton(icon4);
 		
 		
 		backLbl.setFont(detailMenuFnt);
 		afterLbl.setFont(detailMenuFnt);
 		datePane.add(backLbl);
 		
 		//datePane에 날짜 넣어준 메소드 호출		
 		setScheduleDate();
 		
 		datePane.add(afterLbl);
		
 	}
   
	//상영스케쥴 날짜 세팅
	public void setScheduleDate() {
		  Calendar now = Calendar.getInstance();   
		  //년월라벨
		  SimpleDateFormat yearMonth = new SimpleDateFormat("YYYY MM");      
   
		  month = yearMonth.format(now.getTime());
		  myLbl = new JLabel(month);
		  myLbl.setFont(detailMenuFnt);
		  datePane.add(myLbl);
		  
		  //날짜버튼
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
	    	  dateBtn.setBorderPainted(false);
	    	  dateBtn.setContentAreaFilled(false);
	    	  dateBtn.setFont(detailMenuFnt);
	    	  datePane.add(dateBtn);
	      }
	      		
	}

	//상영시간
	public void movieTimetable() {		
		timetablePane.setLayout(new GridLayout(0,1));

		add(new MovieSchedule_Title_TIme_Seat());
		timetablePane.setBorder(new TitledBorder(new LineBorder(Color.GRAY)));
	}
	
//	public static void main(String[] args) {
//		new MovieSchedule();
//	}
//	
	

}
