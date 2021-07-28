    
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
      String[] movielist = {"��������","ũ�翤��","�̼����ļ���",
                     "�δ�������","����Ǽ�","�߽�����"};
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
      timetitleLbl = new JLabel("�ð�");
      timeTitlePane.add(timetitleLbl);
      timePane.add(BorderLayout.NORTH,timeTitlePane);
      
      add(BorderLayout.EAST,timePane);
   }
   
   public void selectDate() {
      //��¥�г��� 
      dateTitleLbl = new JLabel("��¥");
      dateTitlePane.add(dateTitleLbl);
      dateTitlePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
      datePane.add(BorderLayout.NORTH,dateTitlePane);
      
      //��� �г� ���Ϳ� ����
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
   
      //datePane center�� �����
      add(BorderLayout.CENTER,datePane);
   }
   
   public void selectMovie() {      
      //�����г�(titlePane)�� moviePane NORTH�� �߰�
      movLbl = new JLabel("��ȭ");
      titlePane.add(movLbl);
      titlePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
      moviePane.add(BorderLayout.NORTH,titlePane);
      
      //�޺��ڽ� moviePane.CENTER�� �߰�
      sortBox.addItem("��������");
      sortBox.addItem("��������");      
      ranksortPane.add(sortBox);
      moviePane.add(BorderLayout.CENTER,ranksortPane);
      
      //��ȭ ����Ʈ moviePane.SOUTH�� �߰�
      for(int i=0;i<movielist.length;i++) {
         movListLbl = new JLabel(movielist[i]);
         movlistPane.add(movListLbl);
      }
      moviePane.add(BorderLayout.SOUTH, movScrollPane);
      
      //��ü�г��� ���ʿ� �߰�
      add(BorderLayout.WEST,moviePane);
   }
   
}
   