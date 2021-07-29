import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyDefaultTableCellRenderer extends DefaultTableCellRenderer{

	public MyDefaultTableCellRenderer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component comp = null;
		if(column==6) {
			comp = new JButton("예매취소");
		}
		
		return comp;
	}

}
