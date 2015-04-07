import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableCellRenderer;

import java.awt.Component;
import java.security.PublicKey;

import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;


public class Properties extends JFrame{
	static JRadioButton day = new JRadioButton("День");
	static JRadioButton night = new JRadioButton("Ночь");
public static boolean getdayB (){
	boolean  dayB = day.isSelected();
	return dayB;
	}
public static boolean getnightB (){
	boolean nightB = night.isSelected();
	return nightB;
	}

	//boolean dayB = day.isSelected();
	//boolean nightB = night.isSelected();
	float sizeSlider;
	float sizeSliderFloat;
	float siz = 100;
	//float v = sizeSlider/siz;
	JTable table;
	Color oddColor = new Color(0x25, 0x25, 0x25);
	Color evenColor = new Color(0x1a, 0x1a, 0x1a);
	Color titleColor = new Color(0x3a, 0xa2, 0xd7);
	Font titleFont = new Font("Arial", Font.ROMAN_BASELINE, 16); 
	Font titleFontnew = new Font("Arial", Font.ROMAN_BASELINE, 14); 
	Font titleFontname = new Font ("Arial", Font.ROMAN_BASELINE, 12);
	public Properties(final JTable table){
		this.table = table;
	
	final JFrame properties = new JFrame();
	//properties.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	properties.setSize(400, 250); 
	properties.setUndecorated(true); 
	properties.setOpacity(0.85f); 
	//float rre = 0.85f;  
	
	properties.setLocationRelativeTo(null); 
	
	properties.setBackground(new Color(120,100,122));

	final JLabel titleLabel = new JLabel("Настройки"); 
	
	titleLabel.setFont(titleFont); 
	
	titleLabel.setHorizontalAlignment(SwingConstants.CENTER); 
	titleLabel.setOpaque(true);
	titleLabel.setForeground(titleColor); 
	titleLabel.setBackground(evenColor);
	titleLabel.setPreferredSize(new Dimension(0, 40));

	properties.getContentPane().add(titleLabel, BorderLayout.NORTH); 
	properties.getContentPane().setBackground(new Color(120,100,122));
	
	properties.addComponentListener(new ComponentAdapter() {
		public void componentResized(ComponentEvent e) {
			properties.setShape(new RoundRectangle2D.Double(0, 0, properties
					.getWidth(), properties.getHeight(), 20, 20));
		}
	});
//JPanel panelT = new JPanel();
//properties.add(panelT);
	JLabel transparent = new JLabel("Прозрачность");
	transparent.setFont(titleFontnew);
	transparent.setForeground(Color.LIGHT_GRAY);
	final JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL,
	                                      0, 100, 100);
	framesPerSecond.setPaintTicks(true);
	framesPerSecond.setPaintLabels(true);
	framesPerSecond.setMajorTickSpacing(10);
	framesPerSecond.setMinorTickSpacing(5);
	framesPerSecond.setBounds(10, 10, 200, 32);
	framesPerSecond.setBackground(oddColor);
	framesPerSecond.setForeground(Color.WHITE);
	framesPerSecond.setFont(titleFontname);
	
	JPanel panel = new JPanel();
	properties.getContentPane().add(panel);
	
	
	final JRadioButton min = new JRadioButton("Маленький");
	//JCheckBox min = new JCheckBox("Маленький");
	min.setAlignmentX(Component.CENTER_ALIGNMENT);
	min.setBackground(oddColor);
	min.setForeground(Color.WHITE);
	min.setFont(titleFontname);
	
    ImageIcon icon3 = new ImageIcon("C:\\2.png");
    final ImageIcon icon4 = new ImageIcon("C:\\3.png");

	    final JLabel lab = new JLabel(icon3);
    
	
	
	
	panel.setLayout(new MigLayout("", "[399.00px]", "[14px][37px][][23px][28.00][23px][29px]"));
	//buttonClose.setBackground(oddColor);
	
	panel.add(transparent, "cell 0 0");
	
	/*1JLabel program = new JLabel("New label");
	panel.add(program, "cell 2 0,alignx center");*/
	panel.add(framesPerSecond, "cell 0 1,alignx center,aligny center");
	
	/*2JLabel version = new JLabel("New label");
	panel.add(version, "cell 2 1,alignx center");*/
	
	JLabel sizeButton = new JLabel("Размер");
	sizeButton.setFont(titleFontnew);
	sizeButton.setForeground(Color.LIGHT_GRAY);
	panel.add(sizeButton, "cell 0 2");
	
	
	ImageIcon info = new ImageIcon("C:\\info.png");
	
	/*3JLabel developer = new JLabel("New label");
	panel.add(developer, "cell 2 2,alignx center");*/
	
	panel.add(min, "flowx,cell 0 3,alignx left");
	
	/*4JLabel web = new JLabel("New label");
	panel.add(web, "cell 2 3,alignx center");*/
	
	
	JLabel color = new JLabel("Цвет");
	color.setFont(titleFontnew);
	color.setForeground(Color.LIGHT_GRAY);
	panel.add(color, "cell 0 4,aligny bottom");
	
	day = new JRadioButton("День");
	panel.add(day, "flowx,cell 0 5,alignx left");
	day.setBackground(oddColor);
	day.setForeground(Color.WHITE);
	day.setFont(titleFontname);
	//panel.add(buttonClose);
	//panel.add(buttonnew);
	panel.add(lab, "cell 0 6,alignx right");
	
	
	
	night = new JRadioButton("Ночь");
	night.setSelected(true);
	night.setBackground(oddColor);
	night.setForeground(Color.WHITE);
	night.setFont(titleFontname);
	panel.add(night, "cell 0 5");
	ButtonGroup groupTheme = new ButtonGroup();
	groupTheme.add(day);
	groupTheme.add(night);
	
	final JRadioButton ok = new JRadioButton("Средний");
	ok.setSelected(true);
	ok.setBackground(oddColor);
	ok.setForeground(Color.WHITE);
	ok.setFont(titleFontname);
	panel.add(ok, "cell 0 3,alignx center");
	
	final JRadioButton big = new JRadioButton("Большой");
	big.setBackground(oddColor);
	big.setForeground(Color.WHITE);
	big.setFont(titleFontname);
	panel.add(big, "cell 0 3,alignx left");
	
	panel.setBackground(oddColor);
	
	ButtonGroup group = new ButtonGroup();
	group.add(min);
	group.add(ok);
	group.add(big);
	//button3.setIcon(icon3);

	//button3.setPreferredSize(new Dimension(100,100));
	
	/*lab.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent event) {
			if (SwingUtilities.isRightMouseButton(event))
				properties.dispose();
		}
	});*/
			
	

		

	

			/*buttonnew.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	boolean mina = min.isFocusable();
					if (mina == true){
			PopupMenu.frame.setSize(200, 200);

		        }}
		   });*/
	//Запуск окна в новом потоке
	
	
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			properties.setVisible(true);
			
		}
	});
	MouseAdapter sizeB = new MouseAdapter() {
		public void mouseReleased(MouseEvent event) {
			boolean minB = min.isSelected();
			boolean okB = ok.isSelected();
			boolean bigB = big.isSelected();
			if (minB == true ){
				PopupMenu.frame.setSize(400, 200);
				PopupMenu.table.setRowHeight(20);
						}
			else if (okB == true ){
				PopupMenu.frame.setSize(550, 300);
				PopupMenu.table.setRowHeight(30);
			}
			else if (bigB == true ){
				PopupMenu.frame.setSize(400, 550);
				PopupMenu.table.setRowHeight(30);
			}
			
		}
	};
	min.addMouseListener(sizeB);
	ok.addMouseListener(sizeB);
	big.addMouseListener(sizeB);
	
	MouseAdapter slider = new MouseAdapter() {
		
		public void mouseReleased(MouseEvent event) {
			sizeSlider = framesPerSecond.getValue();
			float v = sizeSlider/siz;
			float b = 1f;
			//float g = (float) b;
			//String s=(String )object;
			float g = b*v;
			
			PopupMenu.frame.setOpacity(g);
			System.out.println(sizeSlider);
			System.out.println(String.valueOf(b));
			/*titleLabel.setCursor(Cursor
					.getPredefinedCursor(Cursor.MOVE_CURSOR));*/
		}};
		framesPerSecond.addMouseListener(slider);
	
	MouseAdapter button = new MouseAdapter() {
		public void mousePressed(MouseEvent event) {
			lab.setIcon(icon4);
			/*titleLabel.setCursor(Cursor
					.getPredefinedCursor(Cursor.MOVE_CURSOR));*/
		}
		public void mouseReleased(MouseEvent event) {
			properties.dispose();
			/*titleLabel.setCursor(Cursor
					.getPredefinedCursor(Cursor.MOVE_CURSOR));*/
		}
		
		};
		lab.addMouseListener(button);
		lab.addMouseMotionListener(button);
	
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
						properties.setLocation(currCoords.x - startX, currCoords.y
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
	
	}

}
