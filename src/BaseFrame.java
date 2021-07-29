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

public class BaseFrame extends JFrame implements ActionListener{
	JSplitPane baseSp;
	JSplitPane menuSp;
	JPanel viewPane = new JPanel();
	
	SignUp sss = new SignUp();
	QuickReservation qq = new QuickReservation();
	MyPage mp = new MyPage();
		Font homeFnt = new Font("굴림",Font.BOLD, 100);
		Font menuFnt = new Font("굴림",Font.BOLD, 40);
		JPanel testPanel = new JPanel();
	
	// 메인 메뉴 카드레이아웃 구성
	JPanel cardPane;
	CardLayout card = new CardLayout();
	
	public BaseFrame() {
		super("BIT CINEMA");
//		setLocationRelativeTo(null);
		baseTop();
//		viewPane.add(BorderLayout.CENTER,sss);
//		System.out.println(sss.getClass());
		
		viewPane.add(BorderLayout.CENTER, new SignUp());
//		baseSp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menuSp, viewPane);
		baseSp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menuSp, mp);
		baseSp.setDividerSize(0);
		baseSp.setDividerLocation(200);
		
		
		add(baseSp);
		setSize(1200,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public void baseTop(){
		JPanel TopPane = new JPanel();
		JPanel BottomPane = new JPanel();
		BottomPane.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));
		BottomPane.setBackground(Color.WHITE);
		TopPane.setBackground(Color.WHITE);
		
		
		//BIT CIEMA 라벨
		//클릭시 초기화면으로 복귀 기능 추가 필요?
		JLabel lblHome = new JLabel("BIT CINEMA", JLabel.CENTER);
		lblHome.setFont(homeFnt);
		TopPane.add(lblHome);
		
		
		//메인 메뉴
		//라벨로 구성함, 라벨위로 올라갔을때 마우스버튼 이미지 변경 이벤트?, 클릭시 viewPane에 각 화면들 출력
//		JLabel lblMovie = new JLabel("영화", JLabel.CENTER);
//		JLabel lblTicketing = new JLabel("예매", JLabel.CENTER);
//		JLabel lblMovieHouse = new JLabel("극장", JLabel.CENTER);
//		JLabel lblMyPage = new JLabel("마이페이지", JLabel.CENTER);
//		lblMovie.setFont(menuFnt);
//		lblTicketing.setFont(menuFnt);
//		lblMovieHouse.setFont(menuFnt);
//		lblMyPage.setFont(menuFnt);
//		BottomPane.add(lblMovie);
//		BottomPane.add(lblTicketing);
//		BottomPane.add(lblMovieHouse);
//		BottomPane.add(lblMyPage);
		
		
		//버튼으로 구성함 나중에 생각해보자....
		JButton movBtn = new JButton("영화");
		JButton ticBtn = new JButton("예매");
		JButton movHBtn = new JButton("극장");
		JButton myPageBtn = new JButton("마이페이지");
		
		movBtn.setFont(menuFnt);
		ticBtn.setFont(menuFnt);
		movHBtn.setFont(menuFnt);
		myPageBtn.setFont(menuFnt);
		
		movBtn.setBackground(Color.WHITE);;
//		ticBtn.setFont(menuFnt);
//		movHBtn.setFont(menuFnt);
//		myPageBtn.setFont(menuFnt);
		
		BottomPane.add(movBtn);
		BottomPane.add(ticBtn);
		BottomPane.add(movHBtn);
		BottomPane.add(myPageBtn);
		
		
		menuSp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, TopPane,BottomPane);
		menuSp.setDividerLocation(130);
		menuSp.setDividerSize(0);
	}
	public void mainPanel() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
