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
	
	
	
	//���� ���� �ǳ� �׷�
		
		JPanel topPane = new JPanel();
		JPanel infoBoxPane = new JPanel(new BorderLayout());
			JPanel namePane = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
			String name = "ȫ�浿";//db���� ���� �ʿ�
			JLabel nameLbl = new JLabel(name+"��");
			JButton infoBtn = new JButton("������������");;
 
			JPanel infoBottomPane = new JPanel();
			String rank = "gold";//db���� ���� �ʿ�
			int point = 5300;//db���� ���� �ʿ�
			int ticket = 0;//db���� ���� �ʿ�
			JLabel infoLbl = new JLabel("������"+rank+"���     "+"��� ���� ����Ʈ:"+point+"��      "+"������:"+ticket+"��", JLabel.CENTER);
			
	//�޴� �ǳ� �׷�
	JPanel menuPane = new JPanel(new GridLayout(0, 1, 0, 5));
		String[] menuText = {"���� ���ų���","���ų��� ��ȸ/���","���� �� ��ȭ","","����Ʈ/������","����Ʈ ����/��볻��","�����ǵ��","","��޾ȳ�","","ȸ��Ż��"};
		JButton menuBtn[] = new JButton[12];
		
	//ī�巹�̾ƿ�
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
	
	//���� �� ��ȭ
	JPanel moviesIsawPane = new JPanel(new BorderLayout());
		JLabel sawLbl;
		JPanel movieListPane = new JPanel(new GridLayout(0,1));
		JPanel moviePane = new JPanel(new BorderLayout());
		ImageIcon movIcon;
		Image movImg;
		Image scImg;
		ImageIcon scIcon;
		
		JLabel imgLbl, imgLbl2;
	//��Ʈ ����
	Font ft = new Font("����",Font.BOLD,20);
		
	public MyPage() {
		info();//����� ���� ����
		menu();//�޴��� ����
		cardLayout();
		moviesIsaw();
		
		//������
		setSize(1200,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void info() {//���� ����
		//���� ���� ǥ��ڽ� ����
		infoBoxPane.setBorder(new LineBorder(Color.BLACK,5));
		infoBoxPane.setBackground(Color.WHITE);
		infoBoxPane.setPreferredSize(new Dimension(650,100));
		//�����̸�&��������
		nameLbl.setFont(ft);//�����̸� ��Ʈ
		namePane.add(nameLbl);//�����̸�
		 
		infoBtn.addActionListener(this);
		namePane.add(infoBtn);//ȸ���������� ��ư
		namePane.setBackground(Color.WHITE);
		infoBoxPane.add(BorderLayout.NORTH,namePane);//�����̸�&��ư ��ġ
		
		//��������
		infoLbl.setFont(ft);
		infoBoxPane.add(infoLbl);
		
		//�ǳ� ����
		topPane.setBackground(Color.WHITE);
		topPane.add(infoBoxPane);
		add(BorderLayout.NORTH,topPane);
		
	}
	public void menu() {//�޴���ư ����
		for(int i=0; i<menuText.length; i++) {//�޴���&��ư ���� �ݺ���
			if(menuText[i].equals("���� ���ų���") || menuText[i].equals("����Ʈ/������") || menuText[i].equals("")) {
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
		//ī�巹�̾ƿ�
		cardPane.setLayout(card);
		moviesIsaw();
		
	}
	
	public void moviesIsaw() {//���� ����ȭ
		moviesIsawPane.setBackground(Color.red);
		sawLbl = new JLabel("���� �� ��ȭ",JLabel.LEFT);
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
		if(event.equals("������������")) {
			System.out.println("1");
		}else if(event.equals("���ų��� ��ȸ/���")) {
			System.out.println("1");
		}else if(event.equals("���� �� ��ȭ")) {
			System.out.println("��������ȭ");
		}else if(event.equals("����Ʈ ����/��볻��")) {
			System.out.println("1");
		}else if(event.equals("�����ǵ��")) {
			System.out.println("1");
		}else if(event.equals("��޾ȳ�")) {
			System.out.println("1");
		}else if(event.equals("ȸ��Ż��")) {
			System.out.println("1");
		}
	}
	
	public static void main(String[] args) {
		new MyPage();
	}



}
