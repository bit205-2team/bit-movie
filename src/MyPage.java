
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class MyPage extends JPanel implements ActionListener{

	
	//���� ���� �ǳ� �׷�
		
		JPanel topPane = new JPanel();
		JPanel infoBoxPane = new JPanel(new BorderLayout());
			JPanel namePane = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
			String name = "ȫ�浿";//db���� ���� �ʿ�
			JLabel nameLbl = new JLabel(name+"��");
			JButton infoBtn = new JButton("������������");;
 
			JPanel infoBottomPane = new JPanel();
			String rank = "gold";//db���� ���� �ʿ�
			int point = 5300;//db���� ���� �ʿ�
			int ticket = 0;//db���� ���� �ʿ�
			JLabel infoLbl = new JLabel("������"+rank+"���     "+"��� ���� ����Ʈ:"+point+"��      "+"������:"+ticket+"��", JLabel.CENTER);
			
	//�޴� �ǳ� �׷�
	JPanel menuPane = new JPanel(new GridLayout(0, 1, 0, 5));
		String[] menuText = {"���� ���ų���","���ų��� Ȯ��/���","���� �� ��ȭ","","����Ʈ/������","����Ʈ ����/��볻��","�����ǵ��","","��޾ȳ�","","ȸ��Ż��"};
		JButton menuBtn[] = new JButton[12];
		
	//ī�巹�̾ƿ� //
	JPanel cardPane;
	CardLayout card = new CardLayout();
	
	//���� �� ��ȭ//////////////////////////////////////��������
	JPanel moviesIsawPane = new JPanel(new BorderLayout());
		JLabel sawLbl;
		JPanel movieListPane = new JPanel(new GridLayout(0,1));
		JPanel moviePane = new JPanel(new BorderLayout());
		ImageIcon movIcon;
		Image movImg;
		Image scImg;
		ImageIcon scIcon;
		
		JLabel imgLbl, imgLbl2;
		
	//���ų���	��ȸ ��� reservation ticket  = rt
	JPanel rtBasePane;
		JScrollPane rtSp; 
			JPanel rtPane;
			JTable rtTable;
			DefaultTableModel rtModel;
	
	String rtTitle[] = {"Ƽ�Ϲ�ȣ","������", "��ȭ����", "�󿵳�¥", "�󿵰�", "�ڸ�", "�ο���"};
	//�̰� MODEL��...���� ��ü�ؾ���
	Object[][] rtData= {{"0002","2021-07-23","��������","2021-07-25","1�󿵰�","A-10","1"},
							 {"0001","2021-07-20","���� ����","2021-07-21","3�󿵰�","A-20","3"}
							};
	JLabel rtLbl;
	JButton rtDelBtn;//���� ��� ��ư
	String rtNum="";
	
	
	
	//ȸ��Ż��/////////////////////////////////////////////
	JPanel dropBasePane;
	JPanel dropPane;
		JLabel dropLbl1;
		JLabel dropLbl2;
		JTextField dropTf;
	
	
	//��Ʈ ����
	Font ft = new Font("����",Font.BOLD,20);
	
	public MyPage() {//������
		setLayout(new BorderLayout());
		info();//����� ���� ����
		menu();//�޴��� ����
		cardLayout();
		moviesIsaw();
	}
	
	public void info() {//���� ����
		//���� ���� ǥ��ڽ� ����
		infoBoxPane.setBorder(new LineBorder(Color.BLACK,5));
		infoBoxPane.setBackground(Color.WHITE);
		infoBoxPane.setPreferredSize(new Dimension(650,100));
		
		//�����̸�&��������
		nameLbl.setFont(ft);//�����̸� ��Ʈ
		namePane.add(nameLbl);//�����̸�
		 
		infoBtn.addActionListener(this);
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
	public void menu() {//�޴���ư ����
		for(int i=0; i<menuText.length; i++) {//�޴���&��ư ���� �ݺ���
			if(menuText[i].equals("���� ���ų���") || menuText[i].equals("����Ʈ/������") || menuText[i].equals("")) {
				JLabel lbl = new JLabel(menuText[i],JLabel.CENTER);
				lbl.setFont(ft);
				menuPane.add(lbl);
			}else {
				menuBtn[i] = new JButton(menuText[i]);
				menuPane.add(menuBtn[i]);
				menuBtn[i].addActionListener(this);
			}
		}
		menuPane.setBackground(Color.WHITE);
		add(BorderLayout.WEST, menuPane);
	}
	public void cardLayout() {//ī�巹�̾ƿ�
		cardPane = new JPanel();
		cardPane.setBackground(Color.WHITE);
		//ī�巹�̾ƿ�
		reservationTicket();
		moviesIsaw();
		dropUser();
		cardPane.setLayout(card);
		cardPane.add(rtBasePane, "���ų��� Ȯ��/���");
		cardPane.add(dropBasePane, "ȸ��Ż��");
		cardPane.add(moviesIsawPane, "���� �� ��ȭ");
		
		add(cardPane);
		
	}
	public void moviesIsaw() {//���� ����ȭ
		moviesIsawPane.setBackground(Color.WHITE);
		sawLbl = new JLabel("     ���� �� ��ȭ",JLabel.LEFT);
		sawLbl.setFont(ft);
		
		moviesIsawPane.add(BorderLayout.NORTH,sawLbl);
		moviesIsawPane.add(BorderLayout.CENTER,movieListPane);
		
		String movName = "beautifullove.jfif";
		movIcon = new ImageIcon("./img/"+movName);
		movImg = movIcon.getImage();
		scImg = movImg.getScaledInstance(200, 280, Image.SCALE_SMOOTH);
		scIcon = new ImageIcon(scImg);
		imgLbl = new JLabel();
		imgLbl.setIcon(scIcon);
		imgLbl2 = new JLabel();
		imgLbl2.setIcon(scIcon);
		moviePane.add(BorderLayout.WEST, imgLbl);
		moviePane.add(BorderLayout.CENTER, imgLbl2);
		
		movieListPane.add(moviePane);
		movieListPane.add(moviePane);
		movieListPane.add(moviePane);
		movieListPane.add(moviePane);
	}
	public void dropUser() {//ȸ��Ż��
		dropBasePane = new JPanel();
		dropBasePane.setBackground(Color.WHITE);
		dropPane = new JPanel(new BorderLayout());
		dropLbl1 = new JLabel("ȸ��Ż��");
		dropLbl2 = new JLabel("Ż������� �Է��Ͽ� �ּ���.");
		dropTf = new JTextField(30);
		
		dropPane.setBorder(new LineBorder(Color.BLACK,5));
		dropPane.setBackground(Color.WHITE);
		dropPane.setPreferredSize(new Dimension(300,100));
		
		dropPane.add(BorderLayout.NORTH, dropLbl1);
		dropPane.add(BorderLayout.CENTER, dropLbl2);
		dropBasePane.add(dropPane);
		
	}
	
	public void reservationTicket() {//���ų��� ��ȸ ���
		rtBasePane = new JPanel();
		rtPane = new JPanel(new BorderLayout());
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
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getActionCommand();
		if(event.equals("������������")) {
			System.out.println("������������");
			
		}else if(event.equals("���ų��� Ȯ��/���")) {card.show(cardPane,"���ų��� Ȯ��/���");
		
		}else if(event.equals("���� �� ��ȭ")) {card.show(cardPane, "���� �� ��ȭ");
		
		}else if(event.equals("����Ʈ ����/��볻��")) {
			System.out.println("����Ʈ ���� ��볻��");
			
		}else if(event.equals("�����ǵ��")) {
			System.out.println("�����ǵ��");
			
		}else if(event.equals("��޾ȳ�")) {
			System.out.println("��޾ȳ�");
			
		}else if(event.equals("ȸ��Ż��")) { card.show(cardPane, "ȸ��Ż��");
		
		}else if(event.equals("�������")) {
			System.out.println("�������!!!");
		}
	}
}
