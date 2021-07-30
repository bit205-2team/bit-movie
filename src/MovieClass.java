
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JSplitPane;
import javax.swing.JTextArea;


public class MovieClass extends JPanel implements ActionListener{
	JSplitPane baseSp;
	JSplitPane menuSp;
	JScrollPane scrollPane;
	//JPanel viewPane = new JPanel(new BorderLayout());
	
	JButton btn [];
	JButton jb;
	
	List<ImageIcon> testList = new ArrayList<ImageIcon>();
	 
	ImageIcon image1 = new ImageIcon(".\\img\\blackwidow.jfif");
	ImageIcon image2 = new ImageIcon(".\\img\\bossbaby.jfif");
	ImageIcon image3 = new ImageIcon(".\\img\\cruella.jfif");
	ImageIcon image4 = new ImageIcon(".\\img\\mogadishu.jfif");
	ImageIcon image5 = new ImageIcon(".\\img\\escaperoom.jfif");
	ImageIcon image6 = new ImageIcon(".\\img\\innerSenses.jfif");
	ImageIcon image7 = new ImageIcon(".\\img\\ophelia.jfif");
	ImageIcon image8 = new ImageIcon(".\\img\\phoenix.jfif");
	ImageIcon image9 = new ImageIcon(".\\img\\beautifullove.jfif");
	ImageIcon image10 = new ImageIcon(".\\img\\theMedium.jfif");
	Font homeFnt = new Font("굴림",Font.BOLD, 100);
	Font menuFnt = new Font("굴림",Font.BOLD, 40);
		
		
	public MovieClass() {
		setLayout(new BorderLayout());
		movie();
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = (JButton)e.getSource();

		if(event == btn[0]) {
			blackWidow();	
		}else if(event == btn[1]){
			
			}else if(event == btn[2]) {
				
			}else if(event == btn[3]) {
				
			}else if(event == btn[4]) {
				
			}else if(event == btn[5]) {
				
			}else if(event == btn[6]) {
				
			}else if(event == btn[7]) {
				
			}else if(event == btn[8]) {
				
			}else if(event == btn[9]) {
				
			
				
			}else if(event == jb) {
				blackWidow();
			}
		
		}
		
	
	public void blackWidow() {//영화 설명창 열기
		//이미지 크기변환
		ImageIcon image2 = new ImageIcon("./img/blackwidow.jfif");
		Image img = image2.getImage();
		Image im2 = img.getScaledInstance(650, 850, Image.SCALE_SMOOTH);
		ImageIcon img2 = new ImageIcon(im2);
		
		//영화포스터,영화소개
		JFrame frame = new JFrame();
		JPanel jp1 = new JPanel();//영화텍스트 패널
		JTextArea ta = new JTextArea();//영화 텍스트
		ta.setEditable(false);//텍스트 고정
		JSplitPane jsp = new JSplitPane();
		frame.setBounds(100, 100, 1300, 900);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();//영화포스터 패널
        JLabel button = new JLabel(img2);//영화 이미지라벨
        JLabel button2 = new JLabel();
      
	try {
		String movieIm = "blackwidow.txt";
		File f = new File("./txt/"+movieIm);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			String txt = br.readLine();
			if(txt==null)break;
			ta.append(txt+"\n");
		//	jb1.setText(txt+"/n");
		//라벨은 setText
		//에어리어는 append
		
		}
		br.close();
		fr.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	jp1.add(BorderLayout.CENTER,ta);
	  panel.add(button);      
      frame.add(panel);
      jsp.setLeftComponent(panel);
      jsp.setRightComponent(ta);
      frame.getContentPane().add(jsp);
      frame.setVisible(true);
}


	public void movie() {
			
		
		 Image img = image1.getImage();
		 Image im = img.getScaledInstance(250, 300, Image.SCALE_SMOOTH);//사이즈 조절가능
		 ImageIcon img00 = new ImageIcon(im);
		 
		 Image img1 = image2.getImage();
		 Image im1 = img1.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
		 ImageIcon img11 = new ImageIcon(im1);
		 
		 Image img2 = image3.getImage();
		 Image im2 = img2.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
		 ImageIcon img22 = new ImageIcon(im2);
		 
		 Image img3 = image4.getImage();
		 Image im3 = img3.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
		 ImageIcon img33 = new ImageIcon(im3);
		 
		 Image img4 = image5.getImage();
		 Image im4 = img4.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
		 ImageIcon img44 = new ImageIcon(im4);
		 
		 Image img5 = image6.getImage();
		 Image im5 = img5.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
		 ImageIcon img55 = new ImageIcon(im5);
		 
		 Image img6 = image7.getImage();
		 Image im6 = img6.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
		 ImageIcon img66 = new ImageIcon(im6);
		 
		 Image img7 = image8.getImage();
		 Image im7 = img7.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
		 ImageIcon img77 = new ImageIcon(im7);
		 
		 Image img8 = image9.getImage();
		 Image im8 = img8.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
		 ImageIcon img88 = new ImageIcon(im8);
		 
		 Image img9 = image10.getImage();
		 Image im9 = img9.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
		 ImageIcon img99 = new ImageIcon(im9);
		 
		 
		 testList.add(img00);
		 testList.add(img11);
		 testList.add(img22);
		 testList.add(img33);
		 testList.add(img44);
		 testList.add(img55);
		 testList.add(img66);
		 testList.add(img77);
		 testList.add(img88);
		 testList.add(img99);
		 
		JPanel jp = new JPanel();// 영화 리스트
		JPanel jp2 = new JPanel();//현재,예정 상영
		
		JScrollPane jsp = new JScrollPane(jp);
		btn = new JButton[testList.size()];
		JButton jj = new JButton("현재상영중");
		JButton jj2 = new JButton("상영예정작");
		
		jp2.add(jj);
		jp2.add(jj2);
		
		jp.setLayout(new GridLayout(0,5,25,50));
		jp.setBackground(Color.white);
		jp2.setBackground(Color.white);
		
		setBackground(Color.WHITE);
		add(BorderLayout.NORTH,jp2);
		
		
		String ml = " 1위";
		String mvs = " 9.8 "; 		
		
		for(int z=0; z<testList.size(); z++) {
			btn[z] = new JButton(testList.get(z));
			btn[z].setBorderPainted(false);
			btn[z].setContentAreaFilled(false);
			//Font ftt = new Font("굴림",0,50);
			JPanel jp3 = new JPanel(new BorderLayout());
			jb = new JButton("예매하기");
			JLabel jl = new JLabel("                         예매순위" + ml + mvs+ "평점 ");
			jp3.add(jb);
			jp3.add(jl);
			//jb.setFont(ftt);
			jp3.setBackground(Color.WHITE);
			jb.setBorderPainted(false);
			jb.setContentAreaFilled(false);
			jb.setPreferredSize(new Dimension(10, 30));
			jp.add(btn[z]);
			jp3.add(btn[z]);
			jp3.add(BorderLayout.NORTH, jb);
			jp3.add(BorderLayout.SOUTH, jl);
			jp.add(jp3);
			
			btn[z].addActionListener(this);
			jb.addActionListener(this);
		}
		add(jsp);
	}
	
}
