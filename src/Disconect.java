import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Disconect {
	Color oddColor = new Color(0x25, 0x25, 0x25);
	Color evenColor = new Color(0x1a, 0x1a, 0x1a);
	Color titleColor = new Color(255, 255, 255);
	Font titleFont = new Font("Arial", Font.ROMAN_BASELINE, 16); 
	public Disconect() {
		// TODO Auto-generated constructor stub
	
		
	final JFrame disconect = new JFrame();
	//properties.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	disconect.setSize(200, 55); 
	disconect.setUndecorated(true); 
	//disconect.setOpacity(0.85f); 
	//float rre = 0.85f;  
	
	disconect.setLocationRelativeTo(null); 
	
	disconect.setBackground(new Color(120,100,122));
	JPanel panel = new JPanel();
	panel.setBackground(titleColor);
	disconect.getContentPane().add(panel);
	JLabel name = new JLabel("Проверьте подключение");
	name.setBackground(titleColor);
	JButton buttonClose = new JButton("Закрыть");
	

	panel.add(name);
	panel.add(buttonClose);
	MouseAdapter button = new MouseAdapter() {
		
		public void mouseReleased(MouseEvent event) {
			disconect.dispose();
			/*titleLabel.setCursor(Cursor
					.getPredefinedCursor(Cursor.MOVE_CURSOR));*/
		}
		
		};
		buttonClose.addMouseListener(button);
		buttonClose.addMouseMotionListener(button);
	// Меняем форму окна на прямоугольник с закругленными углами
	disconect.addComponentListener(new ComponentAdapter() {
				public void componentResized(ComponentEvent e) {
					disconect.setShape(new RoundRectangle2D.Double(0, 0, 
							disconect.getWidth(), disconect.getHeight(), 20, 20));
				}
			}
	);

			// Открываем окно в графическом потоке
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					disconect.setVisible(true);
					
				}
			});
	}
}
