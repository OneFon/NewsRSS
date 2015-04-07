import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;

import org.omg.CORBA.PUBLIC_MEMBER;

public class PopupMenu implements ActionListener {
	static int labelNumber; //номер строки
	static JLabel titleLabel = new JLabel("NEWs");
	static RssFeedTableModel dm;
	static JTable table = new JTable(dm);
	JPopupMenu popup = new JPopupMenu();
	JPopupMenu popupTable = new JPopupMenu();
	
	DefaultTable defTable;
	final static JFrame frame = new JFrame();
	JMenu submenu = new JMenu("Выбор новостей");

	//JMenuItem[] array;
	String[] href = { 
			"https://www.ukr.net/news/main.html",
			"https://www.ukr.net/news/politika.html",
			"https://www.ukr.net/news/jekonomika.html",
			"https://www.ukr.net/news/proisshestvija.html",
			"https://www.ukr.net/news/society.html",
			"https://www.ukr.net/news/kiev.html",
			"https://www.ukr.net/news/tehnologii.html",
			"https://www.ukr.net/news/avto.html",
			"https://www.ukr.net/news/sport.html",
			"https://www.ukr.net/news/zdorove.html",
			"https://www.ukr.net/news/show_biznes.html",
			"https://www.ukr.net/news/za_rubezhom.html",
			"https://www.ukr.net/news/kurezy.html",
			"https://www.ukr.net/news/fotoreportazh.html",
			"https://www.ukr.net/news/video.html"};
	String[] ar = { "Главное", "Политика", "Экономика", "Происшествия",
			"Общество", "Киевские Новости", "Технологии", "Авто", "Спорт",
			"Здоровье", "Шоу-бизнес", "За рубежом", "Курьезы", "Фоторепортаж",
			"Видео" };
	Map<String, JMenuItem> name;
	Map<String, String> reference;

	Color oddColor = new Color(0x25, 0x25, 0x25);
	Color evenColor = new Color(0x1a, 0x1a, 0x1a);
	Color titleColor = new Color(0x3a, 0xa2, 0xd7);

	public void style(String urlAddress, JMenuItem number) {

		JsoupParse parse = new JsoupParse();
		List<FeedMessage> list = new ArrayList<>();
		list = parse.getlist(urlAddress);
		dm.updateData(list);

		//int i;
		for (JMenuItem item : name.values()) {
			item.setForeground(titleColor);
			

		}
		
		number.setForeground(oddColor);
	}

	public PopupMenu() {

		init();
		initTable();
		// Вызываем контекстное меню

		// boolean factenB;

		// final RssFeedTableModel dm;

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(550, 300); // Устанавливаем размер окна
		frame.setUndecorated(true); // Убираем обрамление
		// frame.setOpacity(0.85f); // Делаем окно полупрозрачным
		frame.setLocationRelativeTo(null); // Окно по центру
		//frame.setBackground(Color.BLACK);

		// Создаем текстовую метку, Шрифт и размер текста
		titleLabel = new JLabel("NEWs"); 
		Font titleFont = new Font("Arial", Font.ROMAN_BASELINE, 20);
		
																		
																	
		titleLabel.setFont(titleFont); // Добавляем оформление
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // По центру
																	
																	
		//titleLabel.setForeground(Color.BLACK); // Цвет текста
		titleLabel.setPreferredSize(new Dimension(0, 40)); // Высота метки
		titleLabel.setForeground(titleColor);
		titleLabel.setOpaque(true);
		titleLabel.setBackground(evenColor);
		frame.getContentPane().add(titleLabel, BorderLayout.NORTH); // Добавляем на форму

		submenu.setForeground(titleColor);
		for (JMenuItem item : name.values()) {
			submenu.add(item);
			item.setForeground(titleColor);
			// type type = (type) iterator.next();

		}
		final JMenuItem webOpen = new JMenuItem("Открыть в браузере");
		webOpen.setForeground(titleColor);
		popupTable.add(webOpen);
		final JMenuItem webOpen2 = new JMenuItem("Открыть в приложении");
		webOpen2.setForeground(titleColor);
		popupTable.add(webOpen2);
		
		popup.add(submenu);
		popup.addSeparator(); // Разделитель
		final JMenuItem update = new JMenuItem("Обновить");
		update.setForeground(titleColor);
		popup.add(update);
		final JCheckBoxMenuItem facten = new JCheckBoxMenuItem("Закрепить");
		popup.add(facten);
		facten.setForeground(titleColor);
		final JMenuItem properties = new JMenuItem("Настройки");
		properties.setForeground(titleColor);
		popup.add(properties);
		popup.addSeparator();
		final JMenuItem info = new JMenuItem("О программе");
		info.setForeground(titleColor);
		popup.add(info);
		popup.addSeparator();
		final JMenuItem close = new JMenuItem("Закрыть");
		close.setForeground(titleColor);
		popup.add(close);
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				new Info();

			}
		});
		
		properties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				new Properties(table);

			}
		});

		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			
				
			}
		});
		
		/*
		 * update.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { table.updateUI(); } });
		 */

		titleLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (SwingUtilities.isRightMouseButton(event))
					popup.show(titleLabel, event.getX(), event.getY());
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e))
					{
					labelNumber = table.rowAtPoint(e.getPoint());
		                if(labelNumber == -1) return;
		                table.setRowSelectionInterval(labelNumber, labelNumber);
					popupTable.show(table, e.getX(), e.getY());
		                //System.out.println(labelNumber);
			}
				if(e.getClickCount()==2) {
					labelNumber = table.rowAtPoint(e.getPoint());
	                if(labelNumber == -1) return;
	                OpenBrowser.browser();
		        }
				
			}
		});
		webOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				//System.out.println(labelNumber);
				//new BrowserSample();
				//BrowserSample.BrowserSample();
			OpenBrowser.browser();
			
			}
		});
		webOpen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BrowserSample();
			
			}
		});

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

			// Перемещение только левой кнопкой мыши
			public void mouseDragged(MouseEvent e) {
				Point currCoords = e.getLocationOnScreen();
				boolean factenB = facten.isSelected();
				if (factenB == false) {

					if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
						frame.setLocation(currCoords.x - startX, currCoords.y
								- startY);
					}
				} else if (factenB == true) {

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
		update.addMouseListener(listener);

		// Меняем форму окна на прямоугольник с закругленными углами
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				frame.setShape(new RoundRectangle2D.Double(0, 0, frame
						.getWidth(), frame.getHeight(), 20, 20));
			}
		});

		// Открываем окно в графическом потоке
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.setVisible(true);
				
			}
		});

		JsoupParse parse = new JsoupParse();
		List<FeedMessage> list = new ArrayList<>();
		list = parse.getlist("https://www.ukr.net/news/za_rubezhom.html");
		dm.updateData(list);
	}

	private void initTable() {
		// TODO Auto-generated method stub
		dm = new RssFeedTableModel();
		table = new JTable(dm);
		table.setFillsViewportHeight(true);
		
		table.setSelectionMode(0);
		table.getSelectionModel().setSelectionInterval(0, 0);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		
		// Добавляем компонент прокрутки на главную панель окна
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		table.setShowGrid(false);
		table.setIntercellSpacing(new Dimension(0, 0)); // Убераем линию между
														// рядками
		table.setRowHeight(30); // Ширина рядков
		table.setTableHeader(null); // Название столбца

		// Оформление (цвет) таблицы
		
		defTable = new DefaultTable();
		table.setDefaultRenderer(String.class, defTable); 
			
		
		/*table.setDefaultRenderer(String.class, new DefaultTableCellRenderer() {
			
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected,
						hasFocus, row, column);
				setBackground(row % 2 == 0 ? oddColor : evenColor);
				setForeground(titleColor);
				setFont(new Font("Arial", Font.PLAIN, 14));

				// setHorizontalAlignment(CENTER); // Текс по центру столбца
				return this;
			}

		});*/

	}

	private void init() {
		// TODO Auto-generated method stub
		//JPopupMenu popup = new JPopupMenu();

		//JFrame frame = new JFrame();
		submenu = new JMenu("Выбор новостей");
		name = new LinkedHashMap <>();
		reference = new HashMap<>();

		for (int i = 0; i < ar.length; i++) {
			JMenuItem item = new JMenuItem(ar[i]);
			item.setActionCommand(ar[i]);
			item.addActionListener(this);
			name.put(ar[i], item);
			reference.put(ar[i], href[i]);

		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionC = e.getActionCommand();
		style(reference.get(actionC), name.get(actionC));

	}

	/*public static void setOpacity(float f) {
		frame.setOpacity(f);
		
	}*/

}
