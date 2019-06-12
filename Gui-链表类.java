package M;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

class Carriage { /// 车厢
	int size = 0;// 表示当前车厢已经装了几个活物
	char a[] = new char[4];/// a用来装货物
	Carriage next;/// 连接下一个
}
public class A {

	private static int FLAG = -1;
	private final static int WIDTH = 800;
	private final static int HEIGHT = 400;
	private static Container container;
	private static JPanel UpPanel;
	private static JPanel bottomPanel;
	private static JButton Input0;
	private static JButton Input1;
	private static JButton Input2;
	private static JTextArea viewArea;
	private static JScrollPane jspane1;
	private static JSplitPane jsp;
	static int size = 5;/// 最初的5个车厢
	static Carriage Head = new Carriage();/// 最开始的都头结点

	public static void init() {
		// TODO Auto-generated constructor stub
		Carriage p = Head;
		for (int i = 0; i < 5; i++) {
			Carriage r = new Carriage();
			p.next = r;//// 连接
			p = r;
		}
	}

	public static void main(String[] args) {
		init();
		InitFrame();

	}

	public static void Logic(int a, char car, int num) {
		if (a == 0) {
			//System.out.println("准备打印链表状态");
			viewArea.append("准备打印链表状态\n");
			for (int i = 0; i < size; i++) {
				PrintCarUp();
				//System.out.print("    ");
				viewArea.append("    ");
			}
			//System.out.println();
			viewArea.append("\n");
			Carriage p = Head.next;
			while (p != null) {
				//System.out.print("*");
				viewArea.append("*");
				for (int i = 0; i < 4; i++) {
					if (p.a[i] == 0)
						//System.out.print(" ");
						viewArea.append(" ");
					else
						//System.out.print(p.a[i]);
						viewArea.append(String.valueOf(p.a[i]));
				}
				//System.out.print("*");
				viewArea.append("*");
				showNext();
				p = p.next;
			}
			//System.out.println();
			viewArea.append("\n");
			for (int i = 0; i < size; i++) {
				PrintCarUp();
				//System.out.print("    ");
				viewArea.append("    ");
			}
			//System.out.println();
			viewArea.append("\n");
		} else if (a == 1) {
			//System.out.println("请输入两个数，第一个为字母，第二个数字，例如 A 2");
			viewArea.append("请输入两个数，第一个为字母，第二个数字，例如 A 2");
			while (num != 0) {
				Carriage p = Head;
				while (p.next != null) {
					if (p.next.size == 4)
						p = p.next;
					for (int i = 0; i < 4; i++) {
						if (p.next.a[i] == 0) {
							p.next.a[i] = car;
							p.next.size++;
							num--;
						}
						if (num == 0)
							break;
					}
					if (num == 0)
						break;
					p = p.next;
				}
				while (num != 0) {
					Carriage r = new Carriage();
					p.next = r;
					p = r;
					for (int i = 0; i < 4 && num != 0; i++) {
						r.a[i] = car;
						num--;
					}
				}
			}
		} else {
			//System.out.println("请输入一个字母，例如 A");
			viewArea.append("请输入一个字母，例如 A");
			Carriage p = Head;
			int num1 = 0;
			while (p.next != null) {
				for (int i = 0; i < 4; i++) {
					if (p.next.a[i] == car) {
						p.next.a[i] = 0;
						num1++;
					}
				}
				if (num1 == 4) {
					Carriage r = p.next;
					p.next = r.next;
					r.next = null;/// 回收利用
					size--;
				} else {
					p = p.next;
				}
				num1 = 0;
			}
		}
	}

	private static void InitFrame() {
		JFrame Main = new JFrame("Carriage");
		container = Main.getContentPane();
		container.setLayout(new BorderLayout());
		Main.setSize(WIDTH, HEIGHT);
		Main.setLocationRelativeTo(null);
		Main.setLayout(new BorderLayout());
		Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Input0 = new JButton("打印链表状态0");
		Input1 = new JButton("装货1");
		Input2 = new JButton("卸货2");
		UpPanel = new JPanel(new FlowLayout());
		bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		viewArea = new JTextArea("选择按钮 0,1,2，输入-1退出");
		viewArea.setLineWrap(true);
		viewArea.setFont(new Font("黑体", Font.BOLD, 15));
		jspane1 = new JScrollPane(viewArea) {
			private static final long serialVersionUID = 1L;

			@Override
			public Dimension getPreferredSize() {
				return new Dimension(780, 280);
			}

			@Override
			public Font getFont() {
				return new Font("黑体", Font.BOLD, 12);
			}
		};

		UpPanel.setSize(WIDTH, 150);
		bottomPanel.setSize(WIDTH, 250);

		UpPanel.add(Input0);
		UpPanel.add(Input1);
		UpPanel.add(Input2);

		bottomPanel.add(jspane1);

		jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, UpPanel, bottomPanel);
		jsp.setDividerLocation(70); // 设置拆分窗格分频器初始位置
		jsp.setDividerSize(1); // 设置分频器大小
		container.add(jsp);
		// button lisenner
		Input0.addActionListener(e -> {
			FLAG=0;
			Logic(FLAG, '0', 0);
		});
		Input1.addActionListener(e -> {
			String inputValue = JOptionPane.showInputDialog("请输入两个数，第一个为字母，第二个数字，例如 A 2(注意空格)");
			// System.out.println("请输入两个数，第一个为字母，第二个数字，例如 A 2");
			if (inputValue.equals(" ") || inputValue == null) {

			} else {
				char car = inputValue.charAt(0);
				int num = inputValue.charAt(2) - '0';
				FLAG=1;
				Logic(FLAG, car, num);
				// System.out.println(car+" "+num);
			}
		});
		Input2.addActionListener(e -> {
			String inputValue = JOptionPane.showInputDialog("请输入一个字母，例如 A");
			if (inputValue.equals(" ") || inputValue == null) {

			} else {
				char car = inputValue.charAt(0);
				FLAG=2;
				Logic(FLAG, car, 0);
				// System.out.println(car+" "+num);
			}

		});

		Main.setVisible(true);
	}

	private static void PrintCarUp() {
		//System.out.print("******");
		viewArea.append("******");
	}

	private static void PrintCarleft() {
		//System.out.print("*");
		viewArea.append("*");
	}

	private static void PrintCarright() {
		//System.out.print("*");
		viewArea.append("*");
	}

	private static void PrintCardown() {
		//System.out.print("******");
		viewArea.append("******");
	}

	private static void showNext() {
		//System.out.print("--->");
		viewArea.append("--->");
	}

	private static void print() {
		//System.out.println("请输入0 1 2 或者-1退出");
		viewArea.append("请输入0 1 2 或者-1退出");
		show();
	}
	public static void show() {
        //System.out.println("0-打印链表状态");
        //System.out.println("1-装货");
        //System.out.println("2-卸货");
        viewArea.append("0-打印链表状态");
        viewArea.append("1-装货");
        viewArea.append("2-卸货");
	}
}
