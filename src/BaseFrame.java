import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Reservation.MovieSchedule;
import Reservation.QuickReservation;
import Reservation.SeatReservation;
import Sign.SignUp;

public class BaseFrame extends JFrame implements ActionListener{
	JSplitPane baseSp;
	JSplitPane menuSp;
		String menuBtnStr[] = {"��ȭ","����","����","����������"};
		JButton menuBtn[]= new JButton[4];
	JPanel viewPane = new JPanel();
	
		Font homeFnt = new Font("����",Font.BOLD, 100);
		Font menuFnt = new Font("����",Font.BOLD, 40);
		JPanel testPanel = new JPanel();
	
	// ���� �޴� ī�巹�̾ƿ� ����
	JPanel fCardPane;
	CardLayout fCard = new CardLayout();
	
	public BaseFrame() {
		super("BIT CINEMA");
		
		baseTop();
		fCardLayout();
//		System.out.println(sss.getClass()); ��ü Ŭ���� Ȯ���ҋ� ����!
		
		
		viewPane.add(BorderLayout.CENTER, new SignUp());
		baseSp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menuSp, fCardPane);
		baseSp.setDividerSize(0);
		baseSp.setDividerLocation(200);
		
		
		add(baseSp);
		setResizable(false);
		setSize(1200,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public void baseTop(){
		JPanel titlePane = new JPanel();
		JPanel menuPane = new JPanel();
		JButton signIn = new JButton("�α���");
		signIn.addActionListener(this);
		JButton signUp = new JButton("ȸ������");
		signUp.addActionListener(this);
		signIn.setFont(new Font("����",Font.BOLD, 20));
		signUp.setFont(new Font("����",Font.BOLD, 20));
		signIn.setBackground(Color.orange);
		signUp.setBackground(Color.orange);
		
		titlePane.setLayout(new FlowLayout(FlowLayout.LEFT,0,15));
		
		Box sign = Box.createHorizontalBox();
		Box home = Box.createHorizontalBox();
		Box home1 = Box.createVerticalBox();
		
		sign.add(signIn);
		sign.add(signUp);
		home1.add(Box.createVerticalStrut(45));
		home1.add(sign);

		TitledBorder setScreenpanLine = new TitledBorder(new TitledBorder(new LineBorder(Color.black,4)));
		menuPane.setLayout(new FlowLayout(FlowLayout.CENTER, 100,1));
		menuPane.setBorder(setScreenpanLine);
		menuPane.setBackground(Color.orange);
		titlePane.setBackground(Color.orange);
		
		//BIT CIEMA ��
		//Ŭ���� �ʱ�ȭ������ ���� ��� �߰� �ʿ�?
		JLabel homeLbl = new JLabel("BIT CINEMA", JLabel.LEFT);
		homeLbl.setFont(homeFnt);
		
		home.add(homeLbl);

		titlePane.add(Box.createHorizontalStrut(300));
		titlePane.add(home);
		titlePane.add(Box.createHorizontalStrut(65));
		titlePane.add(home1);
		
		//��ư���� ������ ���߿� �����غ���....
		for(int i=0; i<menuBtnStr.length; i++) {
			menuBtn[i] = new JButton(menuBtnStr[i]);
			menuBtn[i].setBackground(Color.orange);
			menuBtn[i].setFont(menuFnt);
			menuPane.add(menuBtn[i]);
			menuBtn[i].addActionListener(this);
		}
		
		menuSp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, titlePane,menuPane);
		menuSp.setDividerLocation(130);
		menuSp.setDividerSize(0);
		
		
	}
	
	//Frame CENTER
	public void fCardLayout() {//viewPane ������ ǥ���� īƮ���̾ƿ�
		fCardPane = new JPanel(fCard);
		
		MovieClass mc = new MovieClass();
		MyPage mp = new MyPage();
		SignUp sss = new SignUp();
		QuickReservation qq = new QuickReservation();
		SeatReservation seat = new SeatReservation();
		MovieSchedule Schedule = new MovieSchedule();
		QuickReservation Quick = new QuickReservation();
		
		fCardPane.add(mc,"��ȭ");
		fCardPane.add(mp,"����������");
		fCardPane.add(seat,"����");
		fCardPane.add(sss,"�α���");
		fCardPane.add(sss,"ȸ������");
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getActionCommand();
		
		if(event.equals("��ȭ")) {
			fCard.show(fCardPane, "��ȭ");
			System.out.println("Ŭ�� ��ȭ"); 
			
		}else if(event.equals("����")) {
			fCard.show(fCardPane, "����");
			System.out.println("Ŭ�� ��ȭ");
			
			
		}else if(event.equals("����")) {
			System.out.println("Ŭ�� ��ȭ");
			
		}else if(event.equals("����������")) {
			fCard.show(fCardPane, "����������");
			System.out.println("Ŭ�� ����������");
			
		}else if(event.equals("�α���")) {
//			fCard.show(fCardPane,"�α���");
//			System.out.println("Ŭ�� �α���");
			
		}else if(event.equals("ȸ������")) {
			fCard.show(fCardPane,"ȸ������");
			System.out.println("ȸ������ Ŭ��");
		}
		
	}

	public static void main(String[] args) {
		new BaseFrame();
	}

}
