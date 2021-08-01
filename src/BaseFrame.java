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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Reservation.MovieSchedule;
import Reservation.QuickReservation;
import Reservation.ReservationMovieYs;
import Reservation.SeatReservation;

// 수정파일
public class BaseFrame extends JFrame implements ActionListener{
	SignIn signin = new SignIn();
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
		setResizable(false);
		setSize(1200,800);
		
		setVisible(true);  //<--
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public BaseFrame(String id) {
		
		super("BIT CINEMA");
		baseTopLogin();
		fCardLayout();
//		System.out.println(sss.getClass()); 객체 클래스 확인할떄 쓴다!
		
		
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
		JButton signIn = new JButton("Login");
		signIn.addActionListener(this);
		JButton signUp = new JButton("회원가입");
		signUp.addActionListener(this);
		signIn.setFont(new Font("굴림",Font.BOLD, 20));
		signUp.setFont(new Font("굴림",Font.BOLD, 20));
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
		
		//BIT CIEMA 라벨
		//클릭시 초기화면으로 복귀 기능 추가 필요?
		JLabel homeLbl = new JLabel("BIT CINEMA", JLabel.LEFT);
		homeLbl.setFont(homeFnt);
		
		home.add(homeLbl);

		titlePane.add(Box.createHorizontalStrut(300));
		titlePane.add(home);
		titlePane.add(Box.createHorizontalStrut(65));
		titlePane.add(home1);
		
		//버튼으로 구성함 나중에 생각해보자....
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
	
	public void baseTopLogin() {
		
		this.setVisible(false);
		
		JPanel titlePane = new JPanel();
		JPanel menuPane = new JPanel();
		JLabel signIn = new JLabel(BitCinemaMain.userid);

		signIn.setFont(new Font("굴림",Font.BOLD, 20));
		signIn.setBackground(Color.orange);
		titlePane.setLayout(new FlowLayout(FlowLayout.LEFT,0,15));
		
		Box sign = Box.createHorizontalBox();
		Box home = Box.createHorizontalBox();
		Box home1 = Box.createVerticalBox();
		
		sign.add(signIn);
		home1.add(Box.createVerticalStrut(45));
		home1.add(sign);

		TitledBorder setScreenpanLine = new TitledBorder(new TitledBorder(new LineBorder(Color.black,4)));
		menuPane.setLayout(new FlowLayout(FlowLayout.CENTER, 100,1));
		menuPane.setBorder(setScreenpanLine);
		menuPane.setBackground(Color.orange);
		titlePane.setBackground(Color.orange);
		
		//BIT CIEMA 라벨
		//클릭시 초기화면으로 복귀 기능 추가 필요?
		JLabel homeLbl = new JLabel("BIT CINEMA", JLabel.LEFT);
		homeLbl.setFont(homeFnt);
		
		home.add(homeLbl);

		titlePane.add(Box.createHorizontalStrut(300));
		titlePane.add(home);
		titlePane.add(Box.createHorizontalStrut(65));
		titlePane.add(home1);
		
		//버튼으로 구성함 나중에 생각해보자....
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
	public void fCardLayout() {//viewPane 영역에 표기할 카트레이아웃
		fCardPane = new JPanel(fCard);
		
		MyPage mp = new MyPage();
		SignUp signup = new SignUp();
		QuickReservation qq = new QuickReservation();
		SeatReservation seat = new SeatReservation();
		MovieSchedule Schedule = new MovieSchedule();
		QuickReservation Quick = new QuickReservation();
		ReservationMovieYs Ys = new ReservationMovieYs();
		MoviePage movp = new MoviePage();
		
		fCardPane.add(movp,"영화");
		fCardPane.add(mp,"마이페이지");
		fCardPane.add(Ys,"예매");
		fCardPane.add(signin,"Login");
		fCardPane.add(signup,"회원가입");
		
		signin.btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getActionCommand();
		
		JButton button = (JButton)ae.getSource();
		String btn = button.getText();
	
		if(event.equals("영화")) {
			fCard.show(fCardPane, "영화");
			System.out.println("클릭 영화"); 
			
		}else if(event.equals("예매")) {
			if(BitCinemaMain.userid==null) {
				JOptionPane.showMessageDialog(null,"로그인이 필요한 서비스 입니다.");
			}else {
			fCard.show(fCardPane, "예매");
			System.out.println("클릭 영화");
			
			}
		}else if(event.equals("극장")) {
			System.out.println("클릭 영화");
			
		}else if(event.equals("마이페이지")) {
			if(BitCinemaMain.userid==null) {
				JOptionPane.showMessageDialog(null,"로그인이 필요한 서비스 입니다.");
			}else {
			fCard.show(fCardPane, "마이페이지");
			System.out.println("클릭 마이페이지");
			}
		}else if(event.equals("Login")) {
			fCard.show(fCardPane,"Login");
			System.out.println("클릭 로그인");

		}else if(event.equals("회원가입")) {
			fCard.show(fCardPane,"회원가입");
			System.out.println("회원가입 클릭");
		}else if(event.equals("로그인")) {
			dispose();
		}
	}

}
