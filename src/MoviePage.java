import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import DBconnection.MovieVO;

public class MoviePage extends JPanel implements ActionListener{
	JPanel movieBasePane= new JPanel(new BorderLayout());;//기본 패널
		JPanel topPane;
		JButton topBtn[] = {new JButton("현재상영중"),new JButton("상영예정작")};
			CardLayout card = new CardLayout();
			JPanel cardPane = new JPanel(card);	//카드 레이아웃판넬
			
			int selectNum = 1;
			JPanel nowPane;	//상영작 포스터 판넬
			JScrollPane nowSp;

			JPanel laterPane;	//예정작 포스터 판넬
			JScrollPane laterSp;
			

			JButton nowMovieBtn[];	//현재상영작 영화 포스터 버튼
			JButton tickettingBtn[];
			JButton laterMovieBtn[];	//상영예정작 영화 포스터 버튼

	int btnNum = 0;
//	List<ImageIcon> nowImgIcon = new ArrayList<ImageIcon>();
//	List<ImageIcon> laterImgIcon = new ArrayList<ImageIcon>();
	
	
	public MoviePage() {
		movieBase();
	}
	
	
	public void movieBase() {
		setLayout(new BorderLayout());
		 TitledBorder btn1 = new TitledBorder(new TitledBorder(new LineBorder(Color.black,1)));
		 TitledBorder btn2 = new TitledBorder(new TitledBorder(new LineBorder(Color.black,1)));
		topPane = new JPanel();
		topPane.add(topBtn[0]);
		topPane.add(topBtn[1]);
		topBtn[0].setBorder(btn1);
		topBtn[1].setBorder(btn2);
		topPane.setBackground(Color.white);
		movieBasePane.add(BorderLayout.NORTH, topPane);// 현재&예정작 버튼 세팅

		movieCard();
		add(movieBasePane);		
	}
	
	public void movieCard() {
		topBtn[0].addActionListener(this);
		topBtn[1].addActionListener(this);
		nowPoster();
		laterPoster();
		cardPane.add(nowSp,"현재상영중");
		cardPane.add(laterSp,"상영예정작");
		
		movieBasePane.add(BorderLayout.CENTER,cardPane);
	}
	
	
	
	public ImageIcon imgConvertor(String imgName, int select) {//이미지 사이즈 조절
		int x = 250;
		int y = 300;
		if(select == 2) {
			x = 650;
			y = 850;
		}
		ImageIcon imgIcon = new ImageIcon("./img/"+imgName+"");
		Image img = imgIcon.getImage();
		Image imgSS = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);//사이즈 조절
		ImageIcon scImgIcon = new ImageIcon(imgSS);
		return scImgIcon;
	}
	
	
	public void nowPoster() {//상영중
		selectNum = 1;
		List<MovieVO> list = new ArrayList<MovieVO>();
		MovieDAO dao = new MovieDAO();
		
		list = dao.moviePoster(selectNum);
		
		nowPane = new JPanel(new GridLayout(0, 4, 5, 50));
		nowPane.setBackground(Color.white);
		
		nowMovieBtn = new JButton[list.size()]; // 수량 수정해야함
		tickettingBtn = new JButton[list.size()];// 수량 수정해야함
		
		for(int i=0; i<list.size(); i++) {
			MovieVO vo = list.get(i);
			JPanel pane = new JPanel(new BorderLayout());
			pane.setBackground(Color.white);
				nowMovieBtn[i] = new JButton(imgConvertor(vo.getImg_addr(), 1));
				nowMovieBtn[i].setBorderPainted(false);
				nowMovieBtn[i].setContentAreaFilled(false);
				TitledBorder setScreenpanLine = new TitledBorder(new TitledBorder(new LineBorder(Color.black,3)));
				tickettingBtn[i] = new JButton("예매하기");
				tickettingBtn[i].setBackground(Color.white);
				tickettingBtn[i].setBorder(setScreenpanLine);
				tickettingBtn[i].setPreferredSize(new Dimension(10,30));
				JLabel lbl = new JLabel("예매순위 "+vo.getMvp()+"위 평점"+vo.getGrade()+"점", JLabel.CENTER);
				int j=i;
				nowMovieBtn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						describde(vo.getImg_addr(),vo.getSummary());
					}
				});
				
			pane.add(BorderLayout.NORTH,nowMovieBtn[i]);
			pane.add(tickettingBtn[i]);
			pane.add(BorderLayout.SOUTH,lbl);
			nowPane.add(pane);
		}
		nowSp = new JScrollPane(nowPane);
	}
//	m.getComponent(0)).getText(
	public void laterPoster() {//상영예정작
		selectNum = 2;
		List<MovieVO> list = new ArrayList<MovieVO>();
		MovieDAO dao = new MovieDAO();
		list = dao.moviePoster(selectNum);
		
		laterPane = new JPanel(new GridLayout(0, 4, 5, 50));
		laterMovieBtn = new JButton[list.size()]; // 수량 수정해야함
		tickettingBtn = new JButton[list.size()];// 수량 수정해야함
		
		for(int i=0; i<list.size(); i++) {
			MovieVO vo = list.get(i);
			vo.getSummary();
			
			JPanel pane = new JPanel(new BorderLayout());
				laterMovieBtn[i] = new JButton(imgConvertor(vo.getImg_addr(), 1));
				laterMovieBtn[i].setBorderPainted(false);
				laterMovieBtn[i].setContentAreaFilled(false);
				tickettingBtn[i] = new JButton("예매하기");
				tickettingBtn[i].setPreferredSize(new Dimension(10,30));
				JLabel lbl = new JLabel("예매순위 "+vo.getMvp()+"위 평점"+vo.getGrade()+"점", JLabel.CENTER);
				int j=i;
				laterMovieBtn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String movieName ="";
						movieName="블랙위도우";
						describde(vo.getImg_addr(),vo.getSummary());
					}
				});
			pane.add(BorderLayout.NORTH,laterMovieBtn[i]);
			pane.add(tickettingBtn[i]);
			pane.add(BorderLayout.SOUTH,lbl);
			laterPane.add(pane);
		}
		laterSp = new JScrollPane(laterPane);
	}
	
	public void describde(String imgName, String summary) {
		imgConvertor(imgName, selectNum);
		JLabel lbl = new JLabel(imgConvertor(imgName, selectNum));
		JFrame frame = new JFrame();
		frame.setBounds(100,100,1300,900);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel pane = new JPanel(new BorderLayout());
		JTextArea ta = new JTextArea();
		ta.setEditable(false);
		
		try {
			File f = new File("./txt/"+summary);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				String txt = br.readLine();
				if(txt==null)break;
				ta.append(txt+"\n");
			}
			br.close();
			fr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		pane.add(BorderLayout.WEST,lbl);
		pane.add(ta);
		frame.add(pane);
		frame.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getActionCommand();
		for(int i=0;i<btnNum;i++) {
			if(event == nowMovieBtn[i]) {
				
				System.out.println("무저"+i);
			}
		}
		if(event.equals("현재상영중")) {
			card.show(cardPane, "현재상영중");
			System.out.println("상영중?>?");
		}else if(event.equals("상영예정작")) {
			card.show(cardPane, "상영예정작");
			System.out.println("d예정작");
		}else if(event.equals("번호 0")) {
			System.out.println("안녕 번호 0번이야");
		}
	}
	
	

}
