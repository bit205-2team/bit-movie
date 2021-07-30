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

public class ReservationMovie extends JFrame{//�ѱ涧 JPane���� �ٲٱ�
	JPanel setViewPane = new JPanel(new BorderLayout());//baseframe���� viewpane�ȿ� �� pane
	JPanel detailMenuPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 30));//��������/�󿵽ð�ǥ
	JPanel viewCenterPane = new JPanel(new BorderLayout());//��¥�� �ð�ǥ �� ū pane
	JPanel datePane = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30)); //��¥ �� pane
	JPanel timeTablePane = new JPanel();//�󿵽ð�ǥ �� pane
	JScrollPane movTablesp = new JScrollPane(timeTablePane); //��ũ�Ѿȿ� �󿵽ð�ǥ �־���
	
	Font detailMenuFnt = new Font("����",Font.BOLD,25);
	
	 String[] dateStr = new String[7];
	 JLabel dateLbl;
	 JLabel myLbl;
	 String month;
	
	
	//��üâ(default ��)
	public ReservationMovie() {
		setViewPane.add(BorderLayout.NORTH,detailMenuPane);
		JLabel quickReserveLbl = new JLabel("���� ����");
		JLabel boundaryLbl = new JLabel("|",JLabel.CENTER);
		JLabel movTableLbl = new JLabel("�󿵽ð�ǥ");
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
		
		
		//�������� �޼ҵ�
	//	quickReservation();
		
		//�̸޼ҵ� ���߿� �̺�Ʈó�� �޼ҵ�� �ű��
		movieSchedule();
		
		
		//test�� / �ѱ涧 ����
		add(setViewPane);
		setSize(1000,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	}
	
	//��������(defaultmenu)
	public void quickReservation(){
		
	}

	
	//�󿵽ð�ǥ ������ �г�
	public void movieSchedule() {
		viewCenterPane.add(BorderLayout.NORTH,datePane);
		viewCenterPane.add(movTablesp);
		
		//<- ��ư
		ImageIcon icon = new ImageIcon("img/img1.png");
		Image img = icon.getImage();
		Image img2 = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(img2);
		
		//-> ��ư
		ImageIcon icon3 = new ImageIcon("img/img2.jpg");
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
		
		
		//box�� �ð�ǥ�����ϱ�
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
		
		//�ڽ��� �ڽ����̾ƿ����� �����ִ��� Ȯ���ϱ�
//		Box title = Box.createHorizontalBox();
//		Box cinemaInfo = Box.createHorizontalBox();
//		Box time = Box.createHorizontalBox();
//		
//		for(int i=0;i<�󿵰����迭.length;i++) {
//			JLabel floor = new JLabel(�󿵰����迭[i]);
//			cinemaInfo.add(fioor);
//			
//			do {
//				title.add(�󿵿�ȭ�迭[]);
//				
//				while(�󿵽ð��迭ũ�⸸ŭ) {
//					for(int j=0;j<�󿵽ð��迭.length;j++) {				
//						JLabel movietime = new JLabel(�󿵽ð��迭[j]);
//						time.add(movietime);
//						
//						//timeTablePane�� ���̸� ����� �ٹٲٱ�
//						int panew = timeTablePane.getWidth();
//						if(�߰��ȶ���width�� panew�� ������ũ��) {
//							//�ٹٲٱ�
//						}
//					}
//					
//				}
//			while(�󿵿�ȭ�迭ũ�⸸ŭ)	
//			
//		}
//		
//			
//		for(int i=0;i<;i++) {
//			JLabel lbl = new JLabel();
//		}
//		
		
		
	}
	

	//�󿵽����� ��¥ ����
	public void setScheduleDate() {
		  Calendar now = Calendar.getInstance();   
		  //�����
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
		  
		  //date��
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
