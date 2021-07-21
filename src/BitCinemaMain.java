import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class BitCinemaMain extends JFrame{
	JSplitPane baseSp;
	JSplitPane menuSp;
	JPanel viewPane = new JPanel();
	
		
		
		Font homeFnt = new Font("±¼¸²",Font.BOLD, 100);
		Font menuFnt = new Font("±¼¸²",Font.BOLD, 40);
		
	public BitCinemaMain() {
		super("È¸¿øÁ¤º¸°ü¸®");
		baseSp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menuSp, viewPane);
		baseSp.setDividerSize(0);
		baseSp.setDividerLocation(200);
	

		add(baseSp);
		setSize(1000,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
