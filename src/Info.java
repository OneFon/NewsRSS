import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;


public class Info {
	Color oddColor = new Color(0x25, 0x25, 0x25);
	Color evenColor = new Color(0x1a, 0x1a, 0x1a);
	Color titleColor = new Color(0x3a, 0xa2, 0xd7);
	Font titleFont = new Font("Arial", Font.ROMAN_BASELINE, 16); 
	public Info() {
		// TODO Auto-generated constructor stub
	
		
	final JFrame info = new JFrame();
	//properties.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	info.setSize(200, 250); 
	info.setUndecorated(true); 
	info.setOpacity(0.85f); 
	//float rre = 0.85f;  
	
	info.setLocationRelativeTo(null); 
	
	info.setBackground(new Color(120,100,122));
	JPanel panel = new JPanel();
	info.getContentPane().add(panel);
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


	JLabel name = new JLabel("Новостной виджет");


	panel.add(name);

	JLabel version = new JLabel("Версия 1.0");
	panel.add(version);
	
	JLabel email = new JLabel("startone@at.ua");
	panel.add(email);
	
	JLabel year = new JLabel("2015");
	panel.add(year);
	
	JLabel web = new JLabel("startone.at.ua");
	panel.add(web);
	
	
	
	final JLabel titleLabel = new JLabel("О программе"); 
	
	titleLabel.setFont(titleFont); 
	
	titleLabel.setHorizontalAlignment(SwingConstants.CENTER); 
	titleLabel.setOpaque(true);
	titleLabel.setForeground(titleColor); 
	titleLabel.setBackground(evenColor);
	titleLabel.setPreferredSize(new Dimension(0, 40));

	info.getContentPane().add(titleLabel, BorderLayout.NORTH); 
	info.getContentPane().setBackground(new Color(120,100,122));
	
	// Обработчик нажатий мыши
				MouseAdapter listener = new MouseAdapter() {
					int startX;
					int startY;

					// Начальное положение курсора
					public void mousePressed(MouseEvent e) {
						if ((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {
							startX = e.getX();
							startY = e.getY();
						}
					}
					
					//lab.addMouseListener(new MouseAdapter() {
						/*public void mouseClicked(MouseEvent event) {
							if (SwingUtilities.isRightMouseButton(event))
								//icon3.setImage(image);
								properties.dispose();
						}*/
					

					// Перемещение только левой кнопкой мыши
					public void mouseDragged(MouseEvent e) {
						Point currCoords = e.getLocationOnScreen();
						if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
							info.setLocation(currCoords.x - startX, currCoords.y
									- startY);
						}
					}

					
					
					// Изменяем курсор
					public void mouseEntered(MouseEvent event) {
						
						titleLabel.setCursor(Cursor
								.getPredefinedCursor(Cursor.MOVE_CURSOR));
					}

				};
				titleLabel.addMouseListener(listener);
				titleLabel.addMouseMotionListener(listener);
				//lab.addMouseListener(listener);
				//lab.addMouseMotionListener(listener);
		
		
	
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			info.setVisible(true);
		}
	});
}}
