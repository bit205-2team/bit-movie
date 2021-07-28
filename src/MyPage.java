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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;


public class MyPage extends JFrame implements ActionListener{
	
	
	
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
		String[] menuText = {"나의 예매내역","예매내역 조회/취소","내가 본 영화","","포인트/관람권","포인트 적립/사용내역","관람권등록","","등급안내","","회원탈퇴"};
		JButton menuBtn[] = new JButton[12];
		
	//카드레이아웃
	JPanel cardPane = new JPanel();
	JScrollPane sp = new JScrollPane(cardPane);
	CardLayout card = new CardLayout();
	JTextArea ta = new JTextArea();
	
	/*
	ImageIcon image2 = new ImageIcon(".\\src\\img\\blackwidow.jfif");
    Image img = image2.getImage();
    Image im2 = img.getScaledInstance(650, 850, Image.SCALE_SMOOTH);
    ImageIcon img2 = new ImageIcon(im2);
    */
	
	//내가 본 영화
	JPanel moviesIsawPane = new JPanel(new BorderLayout());
		JLabel sawLbl;
		JPanel movieListPane = new JPanel(new GridLayout(0,1));
		JPanel moviePane = new JPanel(new BorderLayout());
		ImageIcon movIcon;
		Image movImg;
		Image scImg;
		ImageIcon scIcon;
		
		JLabel imgLbl, imgLbl2;
	//폰트 설정
	Font ft = new Font("굴림",Font.BOLD,20);
		
	public MyPage() {
		info();//사용자 정보 선언
		menu();//메뉴판 선언
		cardLayout();
		moviesIsaw();
		
		//삭재대기
		setSize(1200,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
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
	
	public void cardLayout() {
		//카드레이아웃
		cardPane.setLayout(card);
		moviesIsaw();
		
	}
	
	public void moviesIsaw() {//내가 본영화
		moviesIsawPane.setBackground(Color.red);
		sawLbl = new JLabel("내가 본 영화",JLabel.LEFT);
		sawLbl.setFont(ft);
		
		moviesIsawPane.add(BorderLayout.NORTH,sawLbl);
		moviesIsawPane.add(BorderLayout.CENTER,movieListPane);
		
		movIcon = new ImageIcon("./img/beautifullove.jfif");
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

		
		add(moviesIsawPane);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getActionCommand();
		if(event.equals("개인정보변경")) {
			System.out.println("1");
		}else if(event.equals("예매내역 조회/취소")) {
			System.out.println("1");
		}else if(event.equals("내가 본 영화")) {
			System.out.println("내가본영화");
		}else if(event.equals("포인트 적립/사용내역")) {
			System.out.println("1");
		}else if(event.equals("관람권등록")) {
			System.out.println("1");
		}else if(event.equals("등급안내")) {
			System.out.println("1");
		}else if(event.equals("회원탈퇴")) {
			System.out.println("1");
		}
	}
	
	public static void main(String[] args) {
		new MyPage();
	}



}
