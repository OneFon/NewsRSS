import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class DefaultTable extends DefaultTableCellRenderer{
	Color oddColor = new Color(0x25, 0x25, 0x25);
	Color evenColor = new Color(0x1a, 0x1a, 0x1a);
	Color titleColor = new Color(0x3a, 0xa2, 0xd7);
	Color oddColorDay = new Color(255, 255, 255);
	Color evenColorDay = new Color(190, 190, 190);
	Color titleColorDay = new Color(0, 0, 0);
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		
		super.getTableCellRendererComponent(table, value, isSelected,
				hasFocus, row, column);
				boolean d = Properties.getdayB(); 
				boolean n = Properties.getnightB(); 
				setBackground(row % 2 == 0 ? oddColor : evenColor);
				setForeground(titleColor);
				table.setFont(new Font("Arial", Font.PLAIN, 14));	
				
		if (d == true){
			
		setBackground(row % 2 == 0 ? oddColorDay : evenColorDay);
		setForeground(titleColorDay);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		PopupMenu.titleLabel.setForeground(titleColorDay);
		PopupMenu.titleLabel.setBackground(evenColorDay);
		}
		else if (n == true){
			setBackground(row % 2 == 0 ? oddColor : evenColor);
			setForeground(titleColor);
			table.setFont(new Font("Arial", Font.PLAIN, 14));
			PopupMenu.titleLabel.setForeground(titleColor);
			PopupMenu.titleLabel.setBackground(evenColor);
		}
		// setHorizontalAlignment(CENTER); // Текс по центру столбца
		return this;
	}
	
	 

}
