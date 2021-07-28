    
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
    
    
	public class QuickReservation extends JPanel{
    
	
		
   //selectmovie
   JPanel moviePane = new JPanel(new BorderLayout());
   JPanel titlePane = new JPanel();
      JLabel movLbl;
   JPanel ranksortPane = new JPanel();   
      JComboBox<String> sortBox = new JComboBox<String>();
   JPanel movlistPane = new JPanel(new GridLayout(6,2));
      JLabel movListLbl;
      String[] movielist = {"블랙위도우","크루엘라","미션임파서블",
                     "인더하이츠","괴기맨숀","발신제한"};
   JScrollPane movScrollPane = new JScrollPane(movlistPane);
   
   //selectdate
   JPanel datePane = new JPanel(new BorderLayout());
   JPanel dateTitlePane = new JPanel();
      JLabel dateTitleLbl;
   JPanel yearMonthPane = new JPanel();
      JLabel yearMonthLbl;
   JPanel dateListPane = new JPanel(new GridLayout(7,1));
      JLabel dateLbl;
      String[] dateStr = new String[7];
   JScrollPane dateScrollPane = new JScrollPane(dateListPane);
   
   //selecttime
   JPanel timePane = new JPanel(new BorderLayout());
   JPanel timeTitlePane = new JPanel();
      JLabel timetitleLbl;
   JPanel movieTitlePane = new JPanel(new GridLayout(1,2));
      JLabel ageLbl;
      JLabel movieTitleLbl;
   
      
   public QuickReservation() {
      setLayout(new BorderLayout());
      
      selectMovie();
      selectDate();
      selectTime();
   
   }
   
   public void selectTime() {  
      timetitleLbl = new JLabel("시간");
      timeTitlePane.add(timetitleLbl);
      timePane.add(BorderLayout.NORTH,timeTitlePane);
      
      add(BorderLayout.EAST,timePane);
   }
   
   public void selectDate() {
      //날짜패널을 
      dateTitleLbl = new JLabel("날짜");
      dateTitlePane.add(dateTitleLbl);
      dateTitlePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
      datePane.add(BorderLayout.NORTH,dateTitlePane);
      
      //년월 패널 센터에 답음
      Calendar now = Calendar.getInstance();  
      SimpleDateFormat yearMonth = new SimpleDateFormat("YYYY MM");
      String month = yearMonth.format(now.getTime());
      yearMonthLbl = new JLabel(month);
      yearMonthPane.add(yearMonthLbl);
      datePane.add(BorderLayout.CENTER,yearMonthPane);
      
       SimpleDateFormat dateFormat = new SimpleDateFormat("E dd");
        for(int i=0;i<7;i++) {
           if(i>0) {
               now.add(Calendar.DAY_OF_WEEK, 1);               
           }
            dateStr[i] = dateFormat.format(now.getTime());
            dateLbl = new JLabel(dateStr[i]);            
            dateListPane.add(dateLbl);
         }
        datePane.add(BorderLayout.SOUTH,dateListPane);
   
      //datePane center에 담아줌
      add(BorderLayout.CENTER,datePane);
   }
   
   public void selectMovie() {      
      //제목패널(titlePane)을 moviePane NORTH에 추가
      movLbl = new JLabel("영화");
      titlePane.add(movLbl);
      titlePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
      moviePane.add(BorderLayout.NORTH,titlePane);
      
      //콤보박스 moviePane.CENTER에 추가
      sortBox.addItem("예매율순");
      sortBox.addItem("관람객순");      
      ranksortPane.add(sortBox);
      moviePane.add(BorderLayout.CENTER,ranksortPane);
      
      //영화 리스트 moviePane.SOUTH에 추가
      for(int i=0;i<movielist.length;i++) {
         movListLbl = new JLabel(movielist[i]);
         movlistPane.add(movListLbl);
      }
      moviePane.add(BorderLayout.SOUTH, movScrollPane);
      
      //전체패널의 서쪽에 추가
      add(BorderLayout.WEST,moviePane);
   }
   
}
   