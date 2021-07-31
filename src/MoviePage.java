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
	JPanel movieBasePane;//기본 패널
		JPanel topPane;
		JButton topBtn[] = {new JButton("현재상영중"),new JButton("상영예쩡작")};
			CardLayout card = new CardLayout();
			JPanel cardPane = new JPanel(card);	//카드 레이아웃판넬
			
			JPanel nowPane;	//상영작 포스터 판넬
			JScrollPane nowSp;

			JPanel laterPane;	//예정작 포스터 판넬
			JScrollPane laterSp;
			

			JButton nowMovieBtn[];	//현재상영작 영화 포스터 버튼
			JButton laterMovieBtn[];	//상영예정작 영화 포스터 버튼

	public MoviePage() {
		movieBase();
	}
	
	public void movieBase() {
		movieBasePane = new JPanel(new BorderLayout());
		topPane = new JPanel();
		topPane.add(topBtn[0]);
		topPane.add(topBtn[1]);
		movieBasePane.add(BorderLayout.NORTH, topPane);// 현재&예정작 버튼 세팅
		movieCard();
		add(movieBasePane);
	}
	
	public void movieCard() {
		cardPane.add(nowPane,"현재상영");
		cardPane.add(laterPane,"상영예정");
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
