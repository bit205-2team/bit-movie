import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MovieSchedule_theater_Time extends JPanel{
   
   ImageIcon jojo = new ImageIcon("img/sun.png");
   ImageIcon night = new ImageIcon("img/moon.png");
   JLabel jojoLbl = new JLabel(jojo);
   JLabel nightLbl = new JLabel(night);
   
   JPanel theaPane = new JPanel();
      JLabel theaterLbl;
   JPanel timeseatPane = new JPanel();
      JButton timeBtn;
      JLabel seat;
   JPanel total = new JPanel();
   
   String[] movietime = {"09:30","13:30","24:10"};//10시이전 조조 /11시이후 심야
   String[] seatStr = {"20석","3석","10석"};
   
   public MovieSchedule_theater_Time() {
      
   }
   public MovieSchedule_theater_Time(String theater) {
      total.setLayout(new BoxLayout(total,BoxLayout.Y_AXIS));
      
      theaPane.add(new JLabel(theater));
      
      for(int i=0;i<movietime.length;i++) {
         timeseatPane.add(new JButton(movietime[i]));
         timeseatPane.add(new JLabel(seatStr[i]));
      }
      total.add(theaPane);
      total.add(timeseatPane);
      
//      add(total);      
//      setSize(600,500);
//      setVisible(true);
//      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
   }

//   public static void main(String[] args) {
//      new MovieSchedule_theater_Time("2관 3층");
//
//   }

}