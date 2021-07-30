
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

	
	//유저 정볼 판넬 그룹
		
		JPanel topPane = new JPanel();
		JPanel infoBoxPane = new JPanel(new BorderLayout());
			JPanel namePane = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
			String name = "홍길동";//db정보 연동 필요
			JLabel nameLbl = new JLabel(name+"님");
			JButton infoBtn = new JButton("개인정보변경");;
 
			JPanel infoBottomPane = new JPanel();
			String rank = "gold";//db정보 연동 필요
			int point = 5300;//db정보 연동 필요
			int ticket = 0;//db정보 연동 필요
			JLabel infoLbl = new JLabel("고객님은"+rank+"등급     "+"사용 가능 포인트:"+point+"점      "+"관람권:"+ticket+"장", JLabel.CENTER);
			
	//메뉴 판넬 그룹
	JPanel menuPane = new JPanel(new GridLayout(0, 1, 0, 5));
		String[] menuText = {"나의 예매내역","예매내역 확인/취소","내가 본 영화","","포인트/관람권","포인트 적립/사용내역","관람권등록","","등급안내","","회원탈퇴"};
		JButton menuBtn[] = new JButton[12];
		
	//카드레이아웃 //
	JPanel myCardPane;
	CardLayout myCard = new CardLayout();
	
	//내가 본 영화//////////////////////////////////////아직못함
	JPanel moviesIsawPane = new JPanel(new BorderLayout());
		JLabel sawLbl;
		JPanel movieListPane = new JPanel(new GridLayout(0,1));
		JPanel moviePane = new JPanel(new BorderLayout());
		ImageIcon movIcon;
		Image movImg;
		Image scImg;
		ImageIcon scIcon;
		
		JLabel imgLbl, imgLbl2;
		
	//예매내역	조회 취소 reservation ticket  = rt
	JPanel rtBasePane;
		JScrollPane rtSp; 
			JPanel rtPane;
			JTable rtTable;
			DefaultTableModel rtModel;
	
	String rtTitle[] = {"티켓번호","결제일", "영화제목", "상영날짜", "상영관", "자리", "인원수"};
	//이건 MODEL을...만들어서 대체해야함
	Object[][] rtData= {{"0002","2021-07-23","블랙위도우","2021-07-25","1상영관","A-10","1"},
							 {"0001","2021-07-20","뭔지 몰라","2021-07-21","3상영관","A-20","3"}
							};
	JLabel rtLbl;
	JButton rtDelBtn;//예약 취소 버튼
	String rtNum="";
	
	
	
	//회원탈퇴/////////////////////////////////////////////
	JPanel dropBasePane;
	JPanel dropPwdPane;
	JPanel dropPane;
		JLabel dropLbl1;
		JLabel dropLbl2;
		JTextField dropTf;
		
	
	
	//폰트 설정
	Font ft = new Font("굴림",Font.BOLD,20);
	
	public MyPage() {//생성자
		setLayout(new BorderLayout());
		info();//사용자 정보 선언
		menu();//메뉴판 선언
		myCardLayout();
		moviesIsaw();
	}
	//Panel NORTH
	public void info() {//유저 정보
		//유저 정보 표기박스 설정
		infoBoxPane.setBorder(new LineBorder(Color.BLACK,5));
		infoBoxPane.setBackground(Color.WHITE);
		infoBoxPane.setPreferredSize(new Dimension(650,100));
		
		//유저이름&정보변경
		nameLbl.setFont(ft);//유저이름 폰트
		namePane.add(nameLbl);//유저이름
		 
		infoBtn.addActionListener(this);
		namePane.add(infoBtn);//회원정보수정 버튼
		namePane.setBackground(Color.WHITE);
		infoBoxPane.add(BorderLayout.NORTH,namePane);//유저이름&버튼 배치
		
		//유저정보
		infoLbl.setFont(ft);
		infoBoxPane.add(infoLbl);
		
		//판넬 세팅
		topPane.setBackground(Color.WHITE);
		topPane.add(infoBoxPane);
		add(BorderLayout.NORTH,topPane);
		
	}
	//Panel WEST
	public void menu() {//메뉴버튼 모음
		for(int i=0; i<menuText.length; i++) {//메뉴라벨&버튼 생성 반복문
			if(menuText[i].equals("나의 예매내역") || menuText[i].equals("포인트/관람권") || menuText[i].equals("")) {
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
	
	//Panel CENTER
	public void myCardLayout() {//카드레이아웃
		//카드레이아웃
		myCardPane = new JPanel();
		myCardPane.setBackground(Color.WHITE);
		myCardPane.setLayout(myCard);

		reservationTicket();
		moviesIsaw();
		dropUser();
		myCardPane.add(rtBasePane, "예매내역 확인/취소");
		myCardPane.add(dropBasePane, "회원탈퇴");
		myCardPane.add(moviesIsawPane, "내가 본 영화");
		
		add(myCardPane);
		
	}
	
	//아래서부터 Card Layout으로 삽입할 pane 구성
	
	public void moviesIsaw() {//내가 본영화
		moviesIsawPane.setBackground(Color.WHITE);
		sawLbl = new JLabel("     내가 본 영화",JLabel.LEFT);
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

	
	public void reservationTicket() {//예매내역 조회 취소
		rtBasePane = new JPanel();
		rtPane = new JPanel(new BorderLayout());
		rtModel = new DefaultTableModel(rtData, rtTitle) {
			public boolean isCellEditable(int row, int column) {//셀 더블클릭 수정 불가능
				return false;
			}
		};
		rtTable = new JTable(rtModel);
		rtSp = new JScrollPane(rtTable);
		rtLbl = new JLabel("나의 예매내역");
		rtLbl.setFont(ft);
		rtDelBtn = new JButton("예매취소");
		
		//판넬 세팅
		rtTable.setBackground(Color.WHITE);
		rtBasePane.setBackground(Color.WHITE);
		rtSp.setBackground(Color.white);
		rtPane.setBackground(Color.WHITE);
		rtPane.setPreferredSize(new Dimension(800,440));
		
		//판넬 구성....
		rtPane.add(BorderLayout.NORTH,rtLbl); //라벨등록
		rtPane.add(rtSp);//테이블 등록
		rtPane.add(BorderLayout.SOUTH,rtDelBtn);//예매취소 버튼 등록
		rtBasePane.add(BorderLayout.CENTER, rtPane);
		
		rtTable.addMouseListener(new MyEvent());
		
		//버튼 삽입
		rtDelBtn.addActionListener(this);
	}

	public class MyEvent extends MouseAdapter{//테이블 셀 클릭시 예약번호 넘겨주기
		public void mouseClicked(MouseEvent me) {
			int eventBtn = me.getButton();
			if(eventBtn == 1 ) {
				rtNum="";
				int row = rtTable.getSelectedRow();//선택한 행번호 얻어오기
				Object data = rtTable.getValueAt(row, 0);
				rtNum += data;
				//취소기능 추가 필요****************************************************************
				System.out.println(rtNum+"클릭클릭");
			}
		}
	}
	
	public void dropUser() {//회원탈퇴
		dropBasePane = new JPanel();
		dropBasePane.setBackground(Color.WHITE);
			dropPwdPane = new JPanel(new BorderLayout());
			dropPwdPane.setBackground(Color.WHITE);
				JLabel lbl1 = new JLabel("본인인증");
					JPanel pane = new JPanel(new GridLayout(2,2));
						pane.setPreferredSize(new Dimension(300,150));
						pane.setBackground(Color.WHITE);
					JLabel lbl2 = new JLabel("아이디");
					JLabel lbl3 = new JLabel("비밀번호");
					JLabel lbl4 = new JLabel("idididididi");
					JTextField tf1 = new JTextField(30);
				JButton btn = new JButton("확인");
				btn.addActionListener(this);
		
		dropPwdPane.add(BorderLayout.NORTH, lbl1);
			pane.add(lbl2);
			pane.add(lbl3);
			pane.add(lbl4);
			pane.add(tf1);
		dropPwdPane.add(pane);
		dropPwdPane.add(BorderLayout.SOUTH, btn);
		dropBasePane.add(dropPwdPane);
				
		dropPane = new JPanel(new BorderLayout());
		dropLbl1 = new JLabel("회원탈퇴");
		dropLbl2 = new JLabel("탈퇴사유를 입력하여 주세요.");
		dropTf = new JTextField(30);
		
		dropPane.setBorder(new LineBorder(Color.BLACK,5));
		dropPane.setBackground(Color.WHITE);
		dropPane.setPreferredSize(new Dimension(300,100));
		
		dropPane.add(BorderLayout.NORTH, dropLbl1);
		dropPane.add(BorderLayout.CENTER, dropLbl2);
		dropBasePane.add(dropPane);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getActionCommand();
		if(event.equals("개인정보변경")) {
			System.out.println("개인정보변경");
			
		}else if(event.equals("예매내역 확인/취소")) {myCard.show(myCardPane,"예매내역 확인/취소");
		
		}else if(event.equals("내가 본 영화")) {myCard.show(myCardPane, "내가 본 영화");
		
		}else if(event.equals("포인트 적립/사용내역")) {
			System.out.println("포인트 적립 사용내역");
			
		}else if(event.equals("관람권등록")) {
			System.out.println("관람권등록");
			
		}else if(event.equals("등급안내")) {
			System.out.println("등급안내");
			
		}else if(event.equals("회원탈퇴")) { myCard.show(myCardPane, "회원탈퇴");
		
		}else if(event.equals("예매취소")) {
			System.out.println("예매취소!!!");
		}else if(event.equals("확인")) {
			System.out.println("아브라카타브라 본인인증");
		}
	}
}
