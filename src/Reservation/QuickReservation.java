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
	
	Font menuFnt = new Font("����",Font.BOLD, 35);
	Font sortFnt = new Font("����",Font.BOLD, 20);//������Ʈ

	
	//selectmovie
	JPanel moviePane = new JPanel(new BorderLayout());	
	JPanel titlePane = new JPanel();
		JLabel movLbl;
	JPanel ranksortPane = new JPanel(new FlowLayout(FlowLayout.LEFT));	
		JComboBox<String> sortBox = new JComboBox<String>();
	JScrollPane movieScrollPane =  new JScrollPane();		
	String[] movieList = {"��������","ũ�翤��","�̼����ļ���"};
	String[] theater = {"2D 1�� 1��","2D 2�� 1��","2D 4�� 4��"}; 
	String[] movietime = {"09:30","13:30","24:10"};
	String[] seatStr = {"20��","3��","10��"};
	
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
	JScrollPane timeScrollPane = new JScrollPane();	

	JPanel reservationPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton reservationBtn = new JButton("�¼� ����");

	Dimension dim = new Dimension(500,400);//��ȭ/�ð� ��ü�г� ������
	Dimension dim1 = new Dimension(200,400);//��¥ ��ü�г� ������
	Dimension dim2 = new Dimension(500,45);//���г��� title�г� ������
	Dimension dim3 = new Dimension(500,360);//�� �г��� SOUTH�г� ������
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
		for(int i=0;i<movieList.length;i++) {
			southPane.add(new MovieSchedule_Title(movieList[i]));
		}
		southPane.setPreferredSize(dim3);
		movieScrollPane.setViewportView(southPane);
		moviePane.add(BorderLayout.SOUTH,movieScrollPane);
		
		//��ü�г��� ���ʿ� �߰�
		add(BorderLayout.WEST,moviePane);
		
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
	     
	    //datePane center�� �����
		add(BorderLayout.CENTER,datePane);
	}
	
	 
	
	public void selectTime() {  
		
		//title north�� �߰�
		timetitleLbl = new JLabel("�ð�");
		timetitleLbl.setFont(menuFnt);
		timeTitlePane.add(timetitleLbl);		
		timeTitlePane.setBorder(new TitledBorder(new LineBorder(Color.gray)));
		timePane.add(BorderLayout.NORTH,timeTitlePane);		
		
		//center timebtn �߰�
		for(int i=0;i<theater.length;i++) {
			timetablePane.add(new MovieSchedule_theater_Time(theater[i]));
		}
		timetablePane.setPreferredSize(dim4);
		timeScrollPane.setViewportView(timetablePane);
		timePane.add(BorderLayout.CENTER,timeScrollPane);
		//btn south �߰�
		reservationPane.add(reservationBtn);
		timePane.add(BorderLayout.SOUTH,reservationPane);
	
		timePane.setPreferredSize(dim);
		timeTitlePane.setPreferredSize(dim2);
		add(BorderLayout.EAST,timePane);
	}
	

	
	

}
	