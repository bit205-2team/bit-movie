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
    JPanel datePane = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30)); //��¥ �� pane
    
    String[] dateStr = new String[7];
    JLabel dateLbl; //��¥��
    JLabel myLbl; //�����
    String month;//��
    
    
   ImageIcon jojo = new ImageIcon("img/sun.png");
      ImageIcon night = new ImageIcon("img/moon.png");
      JLabel jojoLbl = new JLabel(jojo);
      JLabel nightLbl = new JLabel(night);
   String[] seatStr = {"20��","3��","10��"};
   String[] theater = {"2D 1�� 1��","2D 2�� 1��","2D 4�� 4��"}; //"2D 3�� 4��"
   String[] movietime = {"09:30","13:30","24:10"};//10������ ���� /11������ �ɾ�
   Box timeBox = Box.createVerticalBox();
    
   
    Font detailMenuFnt = new Font("����",Font.BOLD,25);
    
    //movieTimetable
    JPanel timetablePane = new JPanel();    
   // BoxLayout boxLayout = new BoxLayout(this,BoxLayout.Y_AXIS);
    
//    JPanel timetablePane = new JPanel(new GridLayout(0,1));
//    JPanel timetablePane = new JPanel();
    
    JPanel ageTitlePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
       ImageIcon ageTwelve = new ImageIcon("Img/12.jpg");
       JLabel ageLbl = new JLabel(ageTwelve);
      JLabel movieTitle = new JLabel("��������");
    JPanel theaterPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
       JLabel theaterLbl = new JLabel("2D");
      JLabel theaterFloorLbl = new JLabel("1�� 3��");
    JPanel timePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JButton time1 = new JButton("<html><body style='text-align:center;'>10:30<br />20/40</body></html>\",JLabel.CENTER");
      JButton time2 = new JButton("<html><body style='text-align:center;'>10:30<br />20/40</body></html>\",JLabel.CENTER");
   JPanel theaterPane1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JLabel theaterLbl1 = new JLabel("2D");
      JLabel theaterFloorLbl1 = new JLabel("3�� 5��");
   JPanel timePane1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JButton time3 = new JButton("<html><body style='text-align:center;'>10:30<br />20/40</body></html>\",JLabel.CENTER");
      JButton time4 = new JButton("<html><body style='text-align:center;'>10:30<br />20/40</body></html>\",JLabel.CENTER");
      
   JScrollPane scrollPane = new JScrollPane();
   Dimension size = new Dimension(900,500);
   
   public MovieSchedule() {
      setLayout(new BorderLayout());
      
      setDate();
      movieTimetable();
      
//      setSize(800,500);
//      setVisible(true);
//      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   }
    //datepane
    public void setDate() {
       datePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
       add(BorderLayout.NORTH,datePane);      
       
       //<- ��ư
       ImageIcon icon = new ImageIcon("img/back.png");
       Image img = icon.getImage();
       Image img2 = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
       ImageIcon icon2 = new ImageIcon(img2);
       
       //-> ��ư
       ImageIcon icon3 = new ImageIcon("img/after.png");
       Image img3 = icon3.getImage();
       Image img4 = img3.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
       ImageIcon icon4 = new ImageIcon(img4);
       
       JLabel backLbl = new JLabel(icon2);      
       JLabel afterLbl = new JLabel(icon4);
       
       
       backLbl.setFont(detailMenuFnt);
       afterLbl.setFont(detailMenuFnt);
       datePane.add(backLbl);
       
       //datePane�� ��¥ �־��� �޼ҵ� ȣ��      
       setScheduleDate();
       
       datePane.add(afterLbl);
      
    }
   
   //�󿵽����� ��¥ ����
   public void setScheduleDate() {
        Calendar now = Calendar.getInstance();   
        //�����
        SimpleDateFormat yearMonth = new SimpleDateFormat("YYYY MM");      
   
        String month = yearMonth.format(now.getTime());
        myLbl = new JLabel(month);
        myLbl.setFont(detailMenuFnt);

        datePane.add(myLbl);
        
        //date��
         SimpleDateFormat dateFormat = new SimpleDateFormat("E dd");
         for(int i=0;i<7;i++) {
            if(i>0) {
               now.add(Calendar.DAY_OF_WEEK, 1);               
            }
            dateStr[i] = dateFormat.format(now.getTime());
            dateLbl = new JLabel(dateStr[i]);
            dateLbl.setFont(detailMenuFnt);
            datePane.add(dateLbl);

         }
               
   }
   //�󿵽ð�
   public void movieTimetable() {
      timetablePane.setLayout(new BoxLayout(timetablePane,BoxLayout.Y_AXIS));
      ageTitlePane.add(ageLbl);
      ageTitlePane.add(movieTitle);
      timetablePane.add(ageTitlePane);
      
      for(int i=0;i<theater.length;i++) {      
         JPanel total = new MovieSchedule_theater_Time(theater[i]);
         timetablePane.add(total);
      }
      timetablePane.setPreferredSize(size);
      scrollPane.setViewportView(timetablePane);
      add(BorderLayout.CENTER,timetablePane);
//      timetablePane.setLayout(boxLayout);
   //   Box mainBox = Box.createVerticalBox();
   //   mainBox.add(time1);
   //   timetablePane.add(mainBox);
   //   add(timetablePane);
      
      timetablePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
      
//      
//   
//      
//      theaterPane.add(theaterLbl);
//      theaterPane.add(theaterFloorLbl);
//      timetablePane.add(theaterPane);
//      
//      timePane.add(time1);
//      timePane.add(time2);
//      timetablePane.add(timePane);
//      
//      theaterPane1.add(theaterLbl1);
//      theaterPane1.add(theaterFloorLbl1);
//      timetablePane.add(theaterPane1);
//      
//      timePane1.add(time3);
//      timePane1.add(time4);
//      timetablePane.add(timePane1);
      
      
      
//      timetablePane.setLayout(new BoxLayout(thixLayout.Y_AXIS));
//      Box tim = Box.createHorizontalBox();
//      Box tim1 = Box.createHorizontalBox();
      
//      tim.add(time1);
//      tim1.add(time2);
//      timetablePane.add(tim);
//      timetablePane.add(tim1);
//      add(timetablePane);
      
//      timetablePane.add(time1);
//      timetablePane.add(time2);
//      add(BorderLayout.CENTER,timetablePane);
//      
      
      
   }
   
//   public static void main(String[] args) {
//      new MovieSchedule();
//   }
//   
   

}