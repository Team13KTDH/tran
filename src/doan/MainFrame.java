
package doan;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.Timer;

public class MainFrame extends JFrame {

	Surface sf = new Surface();
	Transformation tm = new Transformation();

	// button restart
	JButton btRs = new JButton();

	// 2D
	JLabel lb4_viendan = new JLabel();
	JLabel lb4_maybay1 = new JLabel();
	JLabel lb4_maybay2 = new JLabel();
	JLabel lb4_maybay3 = new JLabel();
	JButton bt4 = new JButton();

	// 3D_1
	JButton bt1 = new JButton();
	JTextField tf1_1 = new JTextField();
	JTextField tf1_2 = new JTextField();
	JTextField tf1_3 = new JTextField();
	JLabel lb1_1 = new JLabel();
	JLabel lb1_2 = new JLabel();
	JLabel lb1_3 = new JLabel();
	// 3D_2
	JButton bt2 = new JButton();
	JTextField tf2_1 = new JTextField();
	JTextField tf2_2 = new JTextField();
	JTextField tf2_3 = new JTextField();
	JLabel lb2_1 = new JLabel();
	JLabel lb2_2 = new JLabel();
	JLabel lb2_3 = new JLabel();

	int k = 0;
	Thread ban = new Thread(new Runnable() {

		@Override
		public void run() {
			while (sf.vienDan.x < 450) {
				veXe();
				sf.vienDan = tm.translation(sf.vienDan.x, sf.vienDan.y, 50, 0);
				sf.tiLeX *= 1.02;
				sf.tiLeY *= 1.02;
				sf.vienDan.y += -3;
				lb4_viendan.setText("Vien dan: " + "(" + sf.vienDan.x + "," + sf.vienDan.y + ")");
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			sf.vienDan = tm.translation(sf.vienDan.x, sf.vienDan.y, 50, 0);
			tm.gocquay = 30;
			sf.diem1 = tm.Quay(sf.diem1, sf.diem2);
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sf.vienDan = tm.translation(sf.vienDan.x, sf.vienDan.y, 50, 0);
			tm.gocquay = 60;
			sf.diem1 = tm.Quay(sf.diem1, sf.diem2);
			tm.gocquay = 30;
			sf.diem3 = tm.Quay(sf.diem3, sf.diem4);
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sf.vienDan = tm.translation(sf.vienDan.x, sf.vienDan.y, 50, 0);
			tm.gocquay = 60;
			sf.diem3 = tm.Quay(sf.diem3, sf.diem4);
			tm.gocquay = 30;
			sf.diem5 = tm.Quay(sf.diem5, sf.diem6);
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sf.vienDan = tm.translation(sf.vienDan.x, sf.vienDan.y, 100, 0);
			tm.gocquay = 60;
			sf.diem5 = tm.Quay(sf.diem5, sf.diem6);
			tm.gocquay = 30;
			sf.diem7 = tm.Quay(sf.diem7, sf.diem8);
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sf.vienDan = tm.translation(sf.vienDan.x, sf.vienDan.y, 100, 0);
			tm.gocquay = 60;
			sf.diem7 = tm.Quay(sf.diem7, sf.diem8);
			ban.interrupt();
		}
	});

//	    Timer timer = new Timer(100, new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				while (true) {
//					Random vitri = new Random();
//					while (sf.vemaybay1.x > -100) {
//						int doCao = vitri.nextInt((50 - -50) + 1) + -50;
//						sf.vemaybay1 = tm.translation(sf.vemaybay1.x, sf.vemaybay1.y, -50, doCao);
//						lb4_maybay1.setText("May bay 1: " + "(" + sf.vemaybay1.x + "," + sf.vemaybay1.y + ")");
//						try {
//							Thread.sleep(700);
//						} catch (InterruptedException e1) {
//							e1.printStackTrace();
//						}
//					}
//					int valueX = vitri.nextInt((1100 - 700) + 1) + 700;
//					int valueY = vitri.nextInt((300 - 50) + 1) + 50;
//					sf.vemaybay1.x = valueX;
//					sf.vemaybay1.y = valueY;
//				}
//			}
//		});

	Thread bay1 = new Thread(new Runnable() {
		@Override
		public void run() {
			while (true) {
				Random vitri = new Random();
				while (sf.vemaybay1.x > -100) {
					int doCao = vitri.nextInt((50 - -50) + 1) + -50;
					sf.vemaybay1 = tm.translation(sf.vemaybay1.x, sf.vemaybay1.y, -50, doCao);
					lb4_maybay1.setText("May bay 1: " + "(" + sf.vemaybay1.x + "," + sf.vemaybay1.y + ")");
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				int valueX = vitri.nextInt((1100 - 700) + 1) + 700;
				int valueY = vitri.nextInt((300 - 50) + 1) + 50;
				sf.vemaybay1.x = valueX;
				sf.vemaybay1.y = valueY;
			}
		}

	});

	Thread bay2 = new Thread(new Runnable() {
		@Override
		public void run() {
			while (true) {
				Random vitri = new Random();
				while (sf.vemaybay2.x > -100) {
					int doCao = vitri.nextInt((50 - -50) + 1) + -50;
					sf.vemaybay2 = tm.translation(sf.vemaybay2.x, sf.vemaybay2.y, -50, doCao);
					lb4_maybay2.setText("May bay 2: " + "(" + sf.vemaybay2.x + "," + sf.vemaybay2.y + ")");
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				int valueX = vitri.nextInt((1100 - 700) + 1) + 700;
				int valueY = vitri.nextInt((300 - 50) + 1) + 50;
				sf.vemaybay2.x = valueX;
				sf.vemaybay2.y = valueY;
			}
		}

	});
	Thread bay3 = new Thread(new Runnable() {
		@Override
		public void run() {
			while (true) {
				Random vitri = new Random();
				while (sf.vemaybay3.x > -100) {
					int doCao = vitri.nextInt((50 - -50) + 1) + -50;
					sf.vemaybay3 = tm.translation(sf.vemaybay3.x, sf.vemaybay3.y, -50, doCao);
					lb4_maybay3.setText("May bay 3: " + "(" + sf.vemaybay3.x + "," + sf.vemaybay3.y + ")");
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				int valueX = vitri.nextInt((1100 - 700) + 1) + 700;
				int valueY = vitri.nextInt((300 - 50) + 1) + 50;
				sf.vemaybay3.x = valueX;
				sf.vemaybay3.y = valueY;
				SwingUtilities.invokeLater(null);

			}
		}

	});

	// ham khoi tao
	public MainFrame() {
		// ham khoi tao cac gia tri do hoa
		initUI();
	}

	public synchronized void initUI() {
		this.setSize(1350, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("KTDH - NHOM 13");

		bt4.setText("Play");
		bt4.setBounds(60, 30, 150, 40);
		bt4.setBorder(BorderFactory.createBevelBorder(1));
		bt4.setFocusable(false);
		bt4.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 16));

		bt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sf.index = 1;

				ban.start();
				bay1.start();
				bay2.start();
				bay3.start();

			}
		});

		// lb4_maybay.setText("May bay: " + "("+sf.vemaybay.x+","+sf.vemaybay.y+")");
		lb4_maybay1.setBounds(60, 150, 150, 40);
		lb4_maybay2.setBounds(60, 200, 150, 40);
		lb4_maybay3.setBounds(60, 250, 150, 40);
		lb4_viendan.setBounds(60, 370, 150, 40);

		btRs.setText("Restart");
		btRs.setBounds(60, 500, 150, 40);
		btRs.setBorder(BorderFactory.createBevelBorder(1));
		btRs.setFocusable(false);
		btRs.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 16));

		btRs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sf.index = 1;
				veXe();
				ban.resume();
				bay1.resume();
				bay2.resume();
				bay3.resume();
			}
		});

		// 3D_1
		bt1.setText("Ve Hinh Non");
		bt1.setBounds(1130, 30, 150, 40);
		bt1.setBorder(BorderFactory.createBevelBorder(1));
		bt1.setFocusable(false);
		bt1.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 16));

		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sf.index = 2;
				veHinhNon();
				bay1.suspend();
				bay2.suspend();
				bay3.suspend();
				ban.suspend();
			}
		});

		tf1_1.setText("");
		tf1_1.setBounds(1160, 100, 80, 30);
		tf1_2.setText("");
		tf1_2.setBounds(1160, 170, 80, 30);
		tf1_3.setText("");
		tf1_3.setBounds(1160, 240, 80, 30);

		lb1_1.setText("X:");
		lb1_1.setBounds(1140, 100, 40, 40);
		lb1_1.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 14));
		lb1_2.setText("Y:");
		lb1_2.setBounds(1140, 170, 40, 40);
		lb1_2.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 14));
		lb1_3.setText("Z:");
		lb1_3.setBounds(1140, 240, 40, 40);
		lb1_3.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 14));

		// 3D_2
		bt2.setText("Ve Elip");
		bt2.setBounds(1130, 370, 150, 40);
		bt2.setBorder(BorderFactory.createBevelBorder(1));
		bt2.setFocusable(false);
		bt2.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 16));

		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sf.index = 3;
				// veHinhNon();
			}
		});

		tf2_1.setText("");
		tf2_1.setBounds(1160, 440, 80, 30);
		tf2_2.setText("");
		tf2_2.setBounds(1160, 510, 80, 30);
		tf2_3.setText("");
		tf2_3.setBounds(1160, 580, 80, 30);

		lb2_1.setText("X:");
		lb2_1.setBounds(1140, 440, 40, 40);
		lb2_1.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 14));
		lb2_2.setText("Y:");
		lb2_2.setBounds(1140, 510, 40, 40);
		lb2_2.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 14));
		lb2_3.setText("Z:");
		lb2_3.setBounds(1140, 580, 40, 40);
		lb2_3.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 14));

		// add labels
		this.add(lb4_maybay1);
		this.add(lb4_maybay2);
		this.add(lb4_maybay3);

		this.add(lb4_viendan);
		// add buttons
		this.add(bt4);
		this.add(btRs);

		// Add 3D
		this.add(bt1);
		this.add(tf1_1);
		this.add(tf1_2);
		this.add(tf1_3);
		this.add(lb1_1);
		this.add(lb1_2);
		this.add(lb1_3);

		this.add(bt2);
		this.add(tf2_1);
		this.add(tf2_2);
		this.add(tf2_3);
		this.add(lb2_1);
		this.add(lb2_2);
		this.add(lb2_3);

		this.add(sf);

	}

	public void veXe() {
		int a = 10 * 5;
		int b = 103 * 5;
		int c = 15 * 5;
		int d = 100 * 5;

		sf.a = a;
		sf.b = b;
		sf.c = c;
		sf.d = d;

		repaint();
	}

	public void veHinhNon() {
		sf.repaint();
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame mainframe = new MainFrame();
				SwingUtilities.invokeLater(null);
				mainframe.setVisible(true);

			}
		});
	}

}