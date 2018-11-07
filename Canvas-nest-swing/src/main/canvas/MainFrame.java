package main.canvas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -8808883923263763897L;
	private static volatile MainFrame instance;

	public MainFrame() {

		this.setTitle("Canvas Nest");
		this.setSize(new Dimension(660, 470));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2);
		this.setMinimumSize(new Dimension(400, 300));
		this.setResizable(true);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		/**
		 * 100����λ���뷽��ĳ�ʼ��
		 */
		R[] r = new R[100];
		M mousePoint = new M();//�������λ��
		for (int i = 0; i < r.length; i++) {
			r[i] = new R();
			r[i].x = (float) (Math.random() * 660);
			r[i].y = (float) (Math.random() * 470);
			r[i].xa = (float) (2 * Math.random() - 1);//����
			r[i].ya = (float) (2 * Math.random() - 1);//����
		}

		JPanel panel = new JPanel() {
			private static final long serialVersionUID = -7507627235240618009L;

			@Override
			public void paint(Graphics g1) {
				Graphics2D g_point = (Graphics2D) g1;//��
				Graphics2D g_line = (Graphics2D) g1;//��
				g_point.setColor(Color.blue);
				// ͨ����ֵ������Ⱦ�Ŀ����
				g_line.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g_point.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				super.paint(g_point);
				super.paint(g_line);
				
				for (int i = 0; i < r.length; i++) {
					for (int j = 0; j < r.length; j++) {
						// ���� ʵ���Ͽ���fillovalʵ��
						g_point.drawLine((int) r[i].x, (int) r[i].y, (int) r[i].x, (int) r[i].y);
						if (r[i] != r[j]) {
							// �õ�������ͬ������� ��������������ߵĳ���dist
							float x_dist = r[i].x - r[j].x;
							float y_dist = r[i].y - r[j].y;
							float dist = (float) (x_dist * x_dist + y_dist * y_dist);
							// ���ݾ������͸����
							float a = 0;
							if (dist > 0 && dist < 8100) {
								a = (1 - (dist / 8100)) * 100;
								g_line.setColor(new Color(0, 100, 150, (int) a));
								g_line.drawLine((int) r[i].x, (int) r[i].y, (int) r[j].x, (int) r[j].y);
							}
						}
					}
				}
			}
		};
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);

		/**
		 * ����¼��������
		 */
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				mousePoint.x = (float) e.getX();
				mousePoint.y = (float) e.getY();
			}
		});

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				mousePoint.x = null;
				mousePoint.y = null;
			}
		});

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						for (int i = 0; i < r.length; i++) {
							// �������Ϸ���ֵ
							r[i].x += r[i].xa;
							r[i].y += r[i].ya;
							/**
							 * ��ǰ���������ڿ���view�� ��ô
							 */
							r[i].xa *= r[i].x > 660 || r[i].x < 0 ? -1 : 1;
							r[i].ya *= r[i].y > 470 || r[i].y < 0 ? -1 : 1;
							// �ڴ��ڵĿ��Ӵ�С������
							if (mousePoint.x != null && mousePoint.y != null) {
								float x_dist = r[i].x - mousePoint.x;
								float y_dist = r[i].y - mousePoint.y;
								float dist = (float) (x_dist * x_dist + y_dist * y_dist);
								if (dist > 4900 && dist < 19600) {
									r[i].x -= 0.03 * x_dist;
									r[i].y -= 0.03 * y_dist;
								}
							}
						}
						/**
						 * 4.ÿ1/60����forѭ�����¼��������꣬�ػ滭��
						 * 5.����forѭ��Ƕ�ף��ж�ÿ������������ľ��룬
						 * ��С��90px����������ߣ������ߵ�rgba͸���ȸ��ݾ�����仯
						 */
						panel.repaint();
						Thread.sleep(1000 / 60);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}

	public static MainFrame getIstance() {
		if (instance == null) {
			synchronized (MainFrame.class) {
				if (instance == null) {
					instance = new MainFrame();
				}
			}
		}
		return instance;
	}

	private class R {

		float x;
		float y;
		float xa;
		float ya;

	}

	private class M {
		Float x;
		Float y;
	}

}