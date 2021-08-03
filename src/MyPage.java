
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DBconnection.MovieVO;



public class MyPage extends JPanel implements ActionListener{

	
	//���� ���� �ǳ� �׷�
		
		JPanel topPane = new JPanel();
		JPanel infoBoxPane = new JPanel(new BorderLayout());
			JPanel namePane = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
			String name = "ȫ�浿";//db���� ���� �ʿ� //���� �Ϸ�
			JButton infoBtn = new JButton("������������");;
 
			JPanel infoBottomPane = new JPanel();
			String rank = "gold";//db���� ���� �ʿ� // ���� �Ϸ�
			int point = 5300;//db���� ���� �ʿ� // ���� �Ϸ�
			int ticket = 0;//db���� ���� �ʿ� // ���� �Ϸ� 
			
	//�޴� �ǳ� �׷�
	JPanel menuPane = new JPanel(new GridLayout(0, 1, 0, 5));
		String[] menuText = {"���� ���ų���","���ų��� Ȯ��/���","���� �� ��ȭ","","����Ʈ/������","����Ʈ ����/��볻��","�����ǵ��","","��޾ȳ�","","ȸ��Ż��"};
		JButton menuBtn[] = new JButton[12];
		
	//ī�巹�̾ƿ� //
	JPanel myCardPane;
	CardLayout myCard = new CardLayout();
	
	//���� �� ��ȭ//////////////////////////////////////��������
	//JPanel moviesIsawPane = new JPanel(new BorderLayout());
	//	JLabel sawLbl;
	//	JPanel movieListPane = new JPanel(new GridLayout(0,1));
	//	JPanel moviePane = new JPanel(new BorderLayout());
	//	ImageIcon movIcon;
	//	Image movImg;
	//	Image scImg;
	//	ImageIcon scIcon;
		
	// JLabel imgLbl, imgLbl2;
		
	//���ų���	��ȸ ��� reservation ticket  = rt
	JPanel rtBasePane;
		JScrollPane rtSp; 
			JPanel rtPane;
			JTable rtTable;
			DefaultTableModel rtModel;
	
	String rtTitle[] = {"Ƽ�Ϲ�ȣ","������", "��ȭ����", "�󿵳�¥", "�󿵰�", "�ڸ�", "�ο���"};
	
	//���� �� ��ȭ 
	JPanel myBasePane;
		JScrollPane myJP;
			JPanel myPane;
			JTable myTable;
			DefaultTableModel myModel;
		
	String myTitle[] = {"Ƽ�Ϲ�ȣ","������","��ȭ����","�󿵳�¥","�󿵰�","�ڸ�","�ο���"};	
	JLabel myLbl;
	
	
	//�̰� MODEL��...���� ��ü�ؾ���
//	Object[][] rtData= {{"0002","2021-07-23","��������","2021-07-25","1�󿵰�","A-10","1"},
//							 {"0001","2021-07-20","���� ����","2021-07-21","3�󿵰�","A-20","3"}
//							};
	JLabel rtLbl;
	JButton rtDelBtn;//���� ��� ��ư
	String rtNum="";
	
	
	
	//ȸ��Ż��/////////////////////////////////////////////
	JPanel dropBasePane;
	JPanel dropPwdPane;
	JPanel dropPane;
		JLabel dropLbl1;
		JLabel dropLbl2;
		JTextField dropTf;
	
	//��ũ��
	JPanel rankpan,toppan,centerpane,botpane;
	
	
	
	//��Ʈ ����
	Font ft = new Font("����",Font.BOLD,20);
	
	public MyPage() {//������
		setLayout(new BorderLayout());
		info();//����� ���� ����
		menu();//�޴��� ����
		myCardLayout();
		moviesIsaw();
	}
	//Panel NORTH
	public void info() {//���� ����
		//���� ���� ǥ��ڽ� ����
		
		MovieDAO dao = new MovieDAO();
		List<String> list = new  ArrayList<String>();
		
		list = dao.memberinformation(BitCinemaMain.userid); // DB����
		
		name = list.get(0);
		rank = list.get(1);
		point = Integer.parseInt(list.get(2));
		ticket = Integer.parseInt(list.get(3));
		
		JLabel infoLbl = new JLabel("������"+rank+"���     "+"��� ���� ����Ʈ:"+point+"��      "+"������:"+ticket+"��", JLabel.CENTER);
		JLabel nameLbl = new JLabel(name+"��");
		infoBoxPane.setBorder(new LineBorder(Color.BLACK,5));
		infoBoxPane.setBackground(Color.WHITE);
		infoBoxPane.setPreferredSize(new Dimension(650,100));
		
		//�����̸�&��������
		nameLbl.setFont(ft);//�����̸� ��Ʈ
		namePane.add(nameLbl);//�����̸�

		infoBtn.addActionListener(this);
		infoBtn.setBackground(Color.cyan);
		namePane.add(infoBtn);//ȸ���������� ��ư
		namePane.setBackground(Color.WHITE);
		infoBoxPane.add(BorderLayout.NORTH,namePane);//�����̸�&��ư ��ġ
		
		//��������
		infoLbl.setFont(ft);
		infoBoxPane.add(infoLbl);
		
		//�ǳ� ����
		topPane.setBackground(Color.WHITE);
		topPane.add(infoBoxPane);
		add(BorderLayout.NORTH,topPane);
		
	}
	//Panel WEST
	public void menu() {//�޴���ư ����
		for(int i=0; i<menuText.length; i++) {//�޴���&��ư ���� �ݺ���
			if(menuText[i].equals("���� ���ų���") || menuText[i].equals("����Ʈ/������") || menuText[i].equals("")) {
				JLabel lbl = new JLabel(menuText[i],JLabel.CENTER);
				lbl.setFont(ft);
				menuPane.add(lbl);
			}else {
				menuBtn[i] = new JButton(menuText[i]);
				menuBtn[i].setBackground(Color.white);
				menuPane.add(menuBtn[i]);
				menuBtn[i].addActionListener(this);
			}
		}
		menuPane.setBackground(Color.WHITE);
		add(BorderLayout.WEST, menuPane);
	}
	
	//Panel CENTER
	public void myCardLayout() {//ī�巹�̾ƿ�
		//ī�巹�̾ƿ�
		myCardPane = new JPanel();
		myCardPane.setBackground(Color.WHITE);
		myCardPane.setLayout(myCard);

		reservationTicket();
		moviesIsaw();
		dropUser();
		rank();
		
		myCardPane.add(rtBasePane, "���ų��� Ȯ��/���");
		myCardPane.add(dropBasePane, "ȸ��Ż��");
		myCardPane.add(myBasePane, "���� �� ��ȭ");
		myCardPane.add(rankpan, "��޾ȳ�");
		add(myCardPane);
		
	}
	
	//�Ʒ������� Card Layout���� ������ pane ����
	
	public void moviesIsaw() {//���� ����ȭ
		myBasePane = new JPanel();
		myPane = new JPanel(new BorderLayout());
		
		MovieDAO dao = new MovieDAO();
		
		List<String> list = new ArrayList<String>();
		String id = BitCinemaMain.userid;
		list = dao.reservation(id);
		
		int a = list.size();
		int b = a/7;
		int z = 0;
		Object[][] myData = new Object[b][7];
		
		for(int i = 0; i < list.size(); i++) {
			
			if(z==7)z=0;
			int c = i/7;
			myData[c][z] = list.get(i);
			
			z++;
	}
		myModel = new DefaultTableModel(myData, myTitle) {
			public boolean isCellEditable(int row, int column) {//�� ����Ŭ�� ���� �Ұ���
				return false;
			}
		};
		myTable = new JTable(myModel);
		myJP = new JScrollPane(myTable);
		myLbl = new JLabel("���� �� ��ȭ");
		myLbl.setFont(ft);
		
		//�ǳڼ���
		myTable.setBackground(Color.WHITE);
		myBasePane.setBackground(Color.WHITE);
		myJP.setBackground(Color.WHITE);
		myPane.setBackground(Color.WHITE);
		myPane.setPreferredSize(new Dimension(800,440));
		
		//�ǳ� ����
		myPane.add(BorderLayout.NORTH,myLbl);
		myPane.add(myJP);
		myBasePane.add(BorderLayout.CENTER, myPane);
		
		myTable.addMouseListener(new MyEvent());
		
	}
	
	public void reservationTicket() {//���ų��� ��ȸ ���
		rtBasePane = new JPanel();
		rtPane = new JPanel(new BorderLayout());
		
		MovieDAO dao = new MovieDAO();
		
		List<String> list = new ArrayList<String>();
		String id = BitCinemaMain.userid;
		list = dao.reservation(id);
		
		int a = list.size();
		int b = a/7;
		int z = 0;
		Object[][] rtData = new Object[b][7];
		
		for(int i = 0; i < list.size(); i++) {
			
			if(z==7)z=0;
			int c = i/7;
			rtData[c][z] = list.get(i);
			
			z++;
		}
		
// 		Object[][] rtData= {{"0002","2021-07-23","��������","2021-07-25","1�󿵰�","A-10","1"},
//				 {"0001","2021-07-20","���� ����","2021-07-21","3�󿵰�","A-20","3"}
//				};

		
		rtModel = new DefaultTableModel(rtData, rtTitle) {
			public boolean isCellEditable(int row, int column) {//�� ����Ŭ�� ���� �Ұ���
				return false;
			}
		};
		rtTable = new JTable(rtModel);
		rtSp = new JScrollPane(rtTable);
		rtLbl = new JLabel("���� ���ų���");
		rtLbl.setFont(ft);
		rtDelBtn = new JButton("�������");
		
		//�ǳ� ����
		rtTable.setBackground(Color.WHITE);
		rtBasePane.setBackground(Color.WHITE);
		rtSp.setBackground(Color.white);
		rtPane.setBackground(Color.WHITE);
		rtPane.setPreferredSize(new Dimension(800,440));
		
		//�ǳ� ����....
		rtPane.add(BorderLayout.NORTH,rtLbl); //�󺧵��
		rtPane.add(rtSp);//���̺� ���
		rtPane.add(BorderLayout.SOUTH,rtDelBtn);//������� ��ư ���
		rtBasePane.add(BorderLayout.CENTER, rtPane);
		
		rtTable.addMouseListener(new MyEvent());
		
		//��ư ����
		rtDelBtn.addActionListener(this);
	}

	public class MyEvent extends MouseAdapter{//���̺� �� Ŭ���� �����ȣ �Ѱ��ֱ�
		public void mouseClicked(MouseEvent me) {
			int eventBtn = me.getButton();
			if(eventBtn == 1 ) {
				rtNum="";
				int row = rtTable.getSelectedRow();//������ ���ȣ ������
				Object data = rtTable.getValueAt(row, 0);
				rtNum += data;
				//��ұ�� �߰� �ʿ�****************************************************************
				System.out.println(rtNum+"Ŭ��Ŭ��");
			}
		}
	}
	
	public void dropUser() {//ȸ��Ż��
		dropBasePane = new JPanel();
		dropBasePane.setBackground(Color.WHITE);
			dropPwdPane = new JPanel(new BorderLayout());
			dropPwdPane.setBackground(Color.WHITE);
				JLabel lbl1 = new JLabel("��й�ȣ Ȯ��");
					JPanel pane = new JPanel(new GridLayout(2,2));
						pane.setPreferredSize(new Dimension(300,50));
						pane.setBackground(Color.WHITE);
					JLabel lbl2 = new JLabel("���̵�");
					JLabel lbl3 = new JLabel("��й�ȣ");
					JLabel lbl4 = new JLabel(BitCinemaMain.userid);
					JTextField tf1 = new JTextField(30);
				JButton btn = new JButton("Ȯ��");
				btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(tf1.getText() != "" || tf1.getText() !=null) {
							MovieDAO dao = new MovieDAO();
							if(dao.login(BitCinemaMain.userid, tf1.getText())) {
								dao.deleteId(BitCinemaMain.userid);
								JOptionPane.showMessageDialog(null,"���̵� ������ �Ϸ�Ǿ����ϴ�.");
								new Logout();
								
							}else {
								JOptionPane.showMessageDialog(null,"��й�ȣ�� Ʋ�Ƚ��ϴ�.");
							}
						}
					}
				});
		
		dropPwdPane.add(BorderLayout.NORTH, lbl1);
			pane.add(lbl2);
			pane.add(lbl4);
			pane.add(lbl3);
			pane.add(tf1);
		dropPwdPane.add(pane);
		dropPwdPane.add(BorderLayout.SOUTH, btn);
		dropBasePane.add(dropPwdPane);
				
//		dropPane = new JPanel(new BorderLayout());
//		dropLbl1 = new JLabel("ȸ��Ż��");
//		dropLbl2 = new JLabel("Ż������� �Է��Ͽ� �ּ���.");
//		dropTf = new JTextField(30);
//		
//		dropPane.setBorder(new LineBorder(Color.BLACK,5));
//		dropPane.setBackground(Color.WHITE);
//		dropPane.setPreferredSize(new Dimension(300,100));
//		
//		dropPane.add(BorderLayout.NORTH, dropLbl1);
//		dropPane.add(BorderLayout.CENTER, dropLbl2);
//		dropBasePane.add(dropPane);
		
	}
	
	public void rank() {
		rankpan = new JPanel();
		toppan = new JPanel();
		toppan.setBackground(Color.white);
		centerpane = new JPanel();
		botpane = new JPanel();
		botpane.setBackground(Color.green);
		
		int vip = 10000;
		int vip1 = vip- point;
		
		TitledBorder setScreenpanLine = new TitledBorder(new TitledBorder(new LineBorder(Color.gray,3)));
		JLabel lb1 = new JLabel("   ������ ����� "+rank+" �Դϴ�    ",JLabel.CENTER);
		JLabel lb2 = new JLabel("   VIP���� "+vip1+"����Ʈ ���ҽ��ϴ�.    ",JLabel.CENTER);
		JLabel lb3 = new JLabel("                    ");
		JLabel lb4 = new JLabel("                    ");
		JLabel lb5 = new JLabel("                    ");
		
		lb1.setFont(ft);
		lb2.setFont(ft);
		lb3.setFont(new Font("����",Font.BOLD,5));
		
		String ranklb1[] = {"���","VIP","GOLD","SILVER","UNRANK"};
		String ranklbl1[] = {"����","10000","6000","2000","0"};
		
		Box topbox = Box.createHorizontalBox();
		Box lblbox = Box.createVerticalBox();
		Box centerbox = Box.createHorizontalBox();
		Box rank = Box.createVerticalBox();
		Box rank1 = Box.createVerticalBox();
		Box rank2 = Box.createVerticalBox();
		
		
		for(int i =0; i < ranklb1.length; i++) {
			TitledBorder title1 = new TitledBorder(new TitledBorder(new LineBorder(Color.gray,3)));
			JLabel rankfor = new JLabel("      "+ ranklb1[i] +"         ");
			JLabel rankfor1 = new JLabel("                    ");
			
			rankfor.setFont(ft);
			rankfor.setFont(ft);
			
			rank.setBorder(title1);
			rank.add(rankfor);
			rank.add(rankfor1);
		}
		
		for(int i =0; i < ranklbl1.length; i++) {
			TitledBorder title1 = new TitledBorder(new TitledBorder(new LineBorder(Color.gray,3)));
			JLabel rankfor = new JLabel("      "+ ranklbl1[i] +"      ");
			JLabel rankfor1 = new JLabel("                    ");
			
			rank1.setBorder(title1);
			rankfor.setFont(ft);
			rankfor.setFont(ft);
			rank1.add(rankfor);
			rank1.add(rankfor1);
		}
		
		JLabel ranklb6 = new JLabel("                  ");
		ranklb6.setFont(new Font("����",Font.BOLD,30));
		rank.add(ranklb6);
		
		JLabel ranklb66 = new JLabel("                 ");
		ranklb66.setFont(new Font("����",Font.BOLD,30));
		rank1.add(ranklb66);

		lblbox.setBorder(setScreenpanLine);
		
		lblbox.add(lb4);
		lblbox.add(lb1);
		lblbox.add(lb3);
		lblbox.add(lb2);
		lblbox.add(lb5);
		topbox.add(Box.createVerticalStrut(40));
		
		
		centerbox.add(Box.createVerticalStrut(20));
	
		toppan.add(topbox);
		toppan.add(lblbox);
		
//		centerpane.add(centerbox);
		centerpane.setBackground(Color.white);
		centerpane.add(rank);
		centerpane.add(rank1);
		
		rankpan.setLayout(new BorderLayout());	
		rankpan.add(toppan,new BorderLayout().NORTH);
		rankpan.add(centerpane,new BorderLayout().CENTER);
		
//		rankpan.add(botpane);
		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getActionCommand();
		if(event.equals("������������")) {
			System.out.println("������������");
			
		}else if(event.equals("���ų��� Ȯ��/���")) {myCard.show(myCardPane,"���ų��� Ȯ��/���");
		
		}else if(event.equals("���� �� ��ȭ")) {myCard.show(myCardPane, "���� �� ��ȭ");
		
		}else if(event.equals("����Ʈ ����/��볻��")) {
			System.out.println("����Ʈ ���� ��볻��");
			
		}else if(event.equals("�����ǵ��")) {
			System.out.println("�����ǵ��");
			
		}else if(event.equals("��޾ȳ�")) {
			myCard.show(myCardPane, "��޾ȳ�");
			System.out.println("��޾ȳ�");
			
		}else if(event.equals("ȸ��Ż��")) { myCard.show(myCardPane, "ȸ��Ż��");
		
		}else if(event.equals("�������")) {
			System.out.println("�������!!!");
		}else if(event.equals("Ȯ��")) {
			System.out.println("�ƺ��īŸ��� ��������");
		}
	}
}
