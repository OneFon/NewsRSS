import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class RssFeedTableModel extends AbstractTableModel {
	private static List<FeedMessage> entries = new ArrayList<>();
	

	public void updateData(List<FeedMessage> entries) {
		this.entries = entries;
		fireTableDataChanged();

	}


	/*
	 * public int getSize(int width, int height) { return height = 1500;
	 * 
	 * }
	 */

	public int getRowCount() {
		return entries.size();
	}

	public int getColumnCount() {
		return 1;
	}

	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
			// case 1:
			// return Calendar.class;
		}
		return Object.class;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return entries.get(rowIndex).title;
			// case 1:
			// SimpleDateFormat sdf = new
			// SimpleDateFormat("yyyy MMM dd HH:mm:ss");
			// Calendar cal = entries.get(rowIndex).publicationDate;
			// return sdf.format(cal.getTime());
		}
		return null;
	}
}