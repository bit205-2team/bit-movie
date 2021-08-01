import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Reservation.QuickReservation;

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
		setSize(1200,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public void baseTop(){
		JPanel titlePane = new JPanel();
		JPanel menuPane = new JPanel();
		menuPane.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));
		menuPane.setBackground(Color.WHITE);
		titlePane.setBackground(Color.WHITE);
		
		//BIT CIEMA ��
		//Ŭ���� �ʱ�ȭ������ ���� ��� �߰� �ʿ�?
		JLabel homeLbl = new JLabel("BIT CINEMA", JLabel.CENTER);
		homeLbl.setFont(homeFnt);
		titlePane.add(homeLbl);
		
		
		//��ư���� ������ ���߿� �����غ���....
		for(int i=0; i<menuBtnStr.length; i++) {
			menuBtn[i] = new JButton(menuBtnStr[i]);
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
//		QuickReservation qq = new QuickReservation();
		MoviePage mpp = new MoviePage();
		
		
		fCardPane.add(mc,"��ȭ");
		fCardPane.add(mp,"����������");
		fCardPane.add(mpp,"����");
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getActionCommand();
		
		if(event.equals("��ȭ")) {
			fCard.show(fCardPane, "��ȭ");
			
			System.out.println("Ŭ�� ��ȭ"); 
			
		}else if(event.equals("����")) {
			fCard.show(fCardPane, "����");
			
		}else if(event.equals("����")) {
			System.out.println("Ŭ�� ��ȭ");
			
		}else if(event.equals("����������")) {
			fCard.show(fCardPane, "����������");
			System.out.println("Ŭ�� ����������");
			
		}else if(event.equals("�α���")) {
			System.out.println("Ŭ�� ��ȭ");
			
		}else if(event.equals("ȸ������")) {
			
		}
		
	}

	

}
