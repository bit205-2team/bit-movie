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
	JPanel movieBasePane= new JPanel(new BorderLayout());;//�⺻ �г�
		JPanel topPane;
		JButton topBtn[] = {new JButton("�������"),new JButton("�󿵿�����")};
			CardLayout card = new CardLayout();
			JPanel cardPane = new JPanel(card);	//ī�� ���̾ƿ��ǳ�
			
			int selectNum = 1;
			JPanel nowPane;	//���� ������ �ǳ�
			JScrollPane nowSp;

			JPanel laterPane;	//������ ������ �ǳ�
			JScrollPane laterSp;
			

			JButton nowMovieBtn[];	//������� ��ȭ ������ ��ư
			JButton tickettingBtn[];
			JButton laterMovieBtn[];	//�󿵿����� ��ȭ ������ ��ư

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
		movieBasePane.add(BorderLayout.NORTH, topPane);// ����&������ ��ư ����

		movieCard();
		add(movieBasePane);		
	}
	
	public void movieCard() {
		topBtn[0].addActionListener(this);
		topBtn[1].addActionListener(this);
		nowPoster();
		laterPoster();
		cardPane.add(nowSp,"�������");
		cardPane.add(laterSp,"�󿵿�����");
		
		movieBasePane.add(BorderLayout.CENTER,cardPane);
	}
	
	
	
	public ImageIcon imgConvertor(String imgName, int select) {//�̹��� ������ ����
		int x = 250;
		int y = 300;
		if(select == 2) {
			x = 650;
			y = 850;
		}
		ImageIcon imgIcon = new ImageIcon("./img/"+imgName+"");
		Image img = imgIcon.getImage();
		Image imgSS = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);//������ ����
		ImageIcon scImgIcon = new ImageIcon(imgSS);
		return scImgIcon;
	}
	
	
	public void nowPoster() {//����
		selectNum = 1;
		List<MovieVO> list = new ArrayList<MovieVO>();
		MovieDAO dao = new MovieDAO();
		
		list = dao.moviePoster(selectNum);
		
		nowPane = new JPanel(new GridLayout(0, 4, 5, 50));
		nowPane.setBackground(Color.white);
		
		nowMovieBtn = new JButton[list.size()]; // ���� �����ؾ���
		tickettingBtn = new JButton[list.size()];// ���� �����ؾ���
		
		for(int i=0; i<list.size(); i++) {
			MovieVO vo = list.get(i);
			JPanel pane = new JPanel(new BorderLayout());
			pane.setBackground(Color.white);
				nowMovieBtn[i] = new JButton(imgConvertor(vo.getImg_addr(), 1));
				nowMovieBtn[i].setBorderPainted(false);
				nowMovieBtn[i].setContentAreaFilled(false);
				TitledBorder setScreenpanLine = new TitledBorder(new TitledBorder(new LineBorder(Color.black,3)));
				tickettingBtn[i] = new JButton("�����ϱ�");
				tickettingBtn[i].setBackground(Color.white);
				tickettingBtn[i].setBorder(setScreenpanLine);
				tickettingBtn[i].setPreferredSize(new Dimension(10,30));
				JLabel lbl = new JLabel("���ż��� "+vo.getMvp()+"�� ����"+vo.getGrade()+"��", JLabel.CENTER);
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
	public void laterPoster() {//�󿵿�����
		selectNum = 2;
		List<MovieVO> list = new ArrayList<MovieVO>();
		MovieDAO dao = new MovieDAO();
		list = dao.moviePoster(selectNum);
		
		laterPane = new JPanel(new GridLayout(0, 4, 5, 50));
		laterMovieBtn = new JButton[list.size()]; // ���� �����ؾ���
		tickettingBtn = new JButton[list.size()];// ���� �����ؾ���
		
		for(int i=0; i<list.size(); i++) {
			MovieVO vo = list.get(i);
			vo.getSummary();
			
			JPanel pane = new JPanel(new BorderLayout());
				laterMovieBtn[i] = new JButton(imgConvertor(vo.getImg_addr(), 1));
				laterMovieBtn[i].setBorderPainted(false);
				laterMovieBtn[i].setContentAreaFilled(false);
				tickettingBtn[i] = new JButton("�����ϱ�");
				tickettingBtn[i].setPreferredSize(new Dimension(10,30));
				JLabel lbl = new JLabel("���ż��� "+vo.getMvp()+"�� ����"+vo.getGrade()+"��", JLabel.CENTER);
				int j=i;
				laterMovieBtn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String movieName ="";
						movieName="��������";
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
				
				System.out.println("����"+i);
			}
		}
		if(event.equals("�������")) {
			card.show(cardPane, "�������");
			System.out.println("����?>?");
		}else if(event.equals("�󿵿�����")) {
			card.show(cardPane, "�󿵿�����");
			System.out.println("d������");
		}else if(event.equals("��ȣ 0")) {
			System.out.println("�ȳ� ��ȣ 0���̾�");
		}
	}
	
	

}
