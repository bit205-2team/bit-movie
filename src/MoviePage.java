import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MoviePage extends JPanel implements ActionListener{
	JPanel movieBasePane;//�⺻ �г�
		JPanel topPane;
		JButton topBtn[] = {new JButton("�������"),new JButton("�󿵿�����")};
			CardLayout card = new CardLayout();
			JPanel cardPane = new JPanel(card);	//ī�� ���̾ƿ��ǳ�
			
			JPanel nowPane;	//���� ������ �ǳ�
			JScrollPane nowSp;

			JPanel laterPane;	//������ ������ �ǳ�
			JScrollPane laterSp;
			

			JButton nowMovieBtn[];	//������� ��ȭ ������ ��ư
			JButton laterMovieBtn[];	//�󿵿����� ��ȭ ������ ��ư

	public MoviePage() {
		movieBase();
	}
	
	public void movieBase() {
		movieBasePane = new JPanel(new BorderLayout());
		topPane = new JPanel();
		topPane.add(topBtn[0]);
		topPane.add(topBtn[1]);
		movieBasePane.add(BorderLayout.NORTH, topPane);// ����&������ ��ư ����
		movieCard();
		add(movieBasePane);
	}
	
	public void movieCard() {
		cardPane.add(nowPane,"�����");
		cardPane.add(laterPane,"�󿵿���");
		movieBasePane.add(cardPane);
	}
	
	public void poster() {
		nowPane = new JPanel(new GridLayout(0, 4, 25, 50));
		nowSp = new JScrollPane(nowPane);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
