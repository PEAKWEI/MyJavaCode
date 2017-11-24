package cards.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import card.entiy.Card;

/**
 * @author DGW-PC
 * @data   2017年11月24日
 * UTF-8
 */
public class MainView {

	private JFrame frame;
	private JTextField numbersField;
	private JTextField cardField;
	private JTextField nameField;
	private JTextField intervalField;
	private CardTabelModel model;
	private JTable mydatatable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		UIManager.put("JPanel.font",new Font("宋体",Font.PLAIN,20));
		UIManager.put("Label.font",new Font("宋体",Font.PLAIN,20));
		UIManager.put("Viewport.font",new Font("宋体",Font.PLAIN,20));
		UIManager.put("TitledBorder.font",new Font("宋体",Font.PLAIN,20));
		/*
		 * 测试数据 具体你操作表格 按照我定义的数据结构来.
		 */
		ArrayList<Card> list = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			Card card = new Card(String.valueOf(i+1), "uID"+i, "status"+i);
			list.add(card);
		}
		model = new CardTabelModel(list);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("卡系统");
		frame.setBounds(100, 100, 1172, 748);
		//居中
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel permaterPanel = new JPanel();
		permaterPanel.setBounds(36, 34, 341, 584);
		frame.getContentPane().add(permaterPanel);
		TitledBorder titledBorder = BorderFactory.createTitledBorder("参数设置");
		permaterPanel.setBorder(titledBorder);
		permaterPanel.setLayout(null);
		
		JLabel numberLabel = new JLabel("数量");
		numberLabel.setBounds(29, 54, 54, 21);
		permaterPanel.add(numberLabel);
		
		JLabel lblNewLabel = new JLabel("卡种");
		lblNewLabel.setBounds(29, 114, 54, 24);
		permaterPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(29, 166, 54, 18);
		permaterPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("每卡间隔");
		lblNewLabel_2.setBounds(14, 227, 84, 28);
		permaterPanel.add(lblNewLabel_2);
		
		JButton startButton = new JButton("启动");
		startButton.setBounds(39, 353, 106, 36);
		permaterPanel.add(startButton);
		
		JButton stopButton = new JButton("停止");
		stopButton.setBounds(181, 353, 96, 36);
		permaterPanel.add(stopButton);
		
		JButton finishButton = new JButton("完成提交");
		finishButton.setBounds(61, 430, 195, 58);
		permaterPanel.add(finishButton);
		
		numbersField = new JTextField();
		numbersField.setBounds(108, 54, 169, 28);
		permaterPanel.add(numbersField);
		numbersField.setColumns(10);
		
		cardField = new JTextField();
		cardField.setBounds(108, 114, 169, 28);
		permaterPanel.add(cardField);
		cardField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setBounds(108, 166, 169, 28);
		permaterPanel.add(nameField);
		nameField.setColumns(10);
		
		intervalField = new JTextField();
		intervalField.setBounds(108, 228, 169, 28);
		permaterPanel.add(intervalField);
		intervalField.setColumns(10);
		
	
		
		//------------------------------------------------------------------------
		JPanel dataPanel = new JPanel();
		dataPanel.setBounds(426, 46, 696, 542);
		frame.getContentPane().add(dataPanel);
		TitledBorder dataBorder = BorderFactory.createTitledBorder("标签数据");
		dataPanel.setBorder(dataBorder);
		dataPanel.setLayout(null);
		//
		mydatatable = new JTable();
		mydatatable.setBorder(new LineBorder(new Color(0, 0, 0)));
		mydatatable.setPreferredScrollableViewportSize(new Dimension(400, 500));
		mydatatable.setModel(model);
		
		//
		JScrollPane scrollPane = new JScrollPane(mydatatable);
		scrollPane.setBounds(10, 35, 667, 497);
		dataPanel.add(scrollPane);
	}
}
