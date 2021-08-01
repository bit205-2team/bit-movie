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
		String menuBtnStr[] = {"영화","예매","극장","마이페이지"};
		JButton menuBtn[]= new JButton[4];
	JPanel viewPane = new JPanel();
	
		Font homeFnt = new Font("굴림",Font.BOLD, 100);
		Font menuFnt = new Font("굴림",Font.BOLD, 40);
		JPanel testPanel = new JPanel();
	
	// 메인 메뉴 카드레이아웃 구성
	JPanel fCardPane;
	CardLayout fCard = new CardLayout();
	
	public BaseFrame() {
		super("BIT CINEMA");
		
		baseTop();
		fCardLayout();
//		System.out.println(sss.getClass()); 객체 클래스 확인할떄 쓴다!
		
		
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
		
		//BIT CIEMA 라벨
		//클릭시 초기화면으로 복귀 기능 추가 필요?
		JLabel homeLbl = new JLabel("BIT CINEMA", JLabel.CENTER);
		homeLbl.setFont(homeFnt);
		titlePane.add(homeLbl);
		
		
		//버튼으로 구성함 나중에 생각해보자....
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
	public void fCardLayout() {//viewPane 영역에 표기할 카트레이아웃
		fCardPane = new JPanel(fCard);
		
		MovieClass mc = new MovieClass();
		MyPage mp = new MyPage();
		SignUp sss = new SignUp();
//		QuickReservation qq = new QuickReservation();
		MoviePage mpp = new MoviePage();
		
		
		fCardPane.add(mc,"영화");
		fCardPane.add(mp,"마이페이지");
		fCardPane.add(mpp,"예매");
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getActionCommand();
		
		if(event.equals("영화")) {
			fCard.show(fCardPane, "영화");
			
			System.out.println("클릭 영화"); 
			
		}else if(event.equals("예매")) {
			fCard.show(fCardPane, "예매");
			
		}else if(event.equals("극장")) {
			System.out.println("클릭 영화");
			
		}else if(event.equals("마이페이지")) {
			fCard.show(fCardPane, "마이페이지");
			System.out.println("클릭 마이페이지");
			
		}else if(event.equals("로그인")) {
			System.out.println("클릭 영화");
			
		}else if(event.equals("회원가입")) {
			
		}
		
	}

	

}
