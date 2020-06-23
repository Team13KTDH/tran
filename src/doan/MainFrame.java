
package doan;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class MainFrame extends JFrame implements ActionListener {

	Surface sf = new Surface();
	Transformation tm = new Transformation();


	JLabel label4 = new JLabel();
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

	// Timer
	Timer timerTank = new Timer(100, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			veXe();
			sf.vienDan = tm.translation(sf.vienDan.x, sf.vienDan.y, 50, 0);
			sf.tiLeX *= 1.05;
			sf.tiLeY *= 1.05;
			sf.vienDan.y += -2.2;
			if (sf.vienDan.x >= 500)
				timerTank.stop();
		}
	});

	// ham khoi tao
	public MainFrame() {
		// ham khoi tao cac gia tri do hoa
		initUI();
	}

	public void initUI() {
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
				timerTank.start();
//				veXe();
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
		this.add(label4);

		// add buttons
		this.add(bt4);

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

		sf.repaint();
	}

	public void veHinhNon() {
		sf.repaint();
	}

//	Point d1 = new Point(xt.vienDan.x + 20, xt.vienDan.y + 20);
//	Point d2 = new Point(xt.vienDan.x + 50, xt.vienDan.y);
	Point tamO = new Point(0, 0);

	public void actionPerformed(ActionEvent e) {
//		if ("Play".equals(e.getActionCommand())) {
//			sf.index = 1;
//			try {
//				this.remove(sf);
//			} catch (Exception e1) {
//			} // clear window, maybe there is a method
//			this.add(sf);// the panel you want to show
//			
//			Timer timer = new Timer(200, new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					veXe();
//					sf.vienDan = tm.translation(sf.vienDan.x, sf.vienDan.y, 50, 0);
//					sf.tiLeX *= 1.1;
//					sf.tiLeY *= 1.1;
//					sf.vienDan.y += -5;
////	          
//// 				sf.vienDan = tm.doixung(sf.vienDan, d2);
////				tm.gocquay = 30;
////				sf.vienDan = tm.Quay(sf.vienDan, d2);
//					k += 2;
//				}
//			});
//			if (k == 10)
//				timer.stop();
//			timer.start();
//		}
//
//		if ("Hinh Non".equals(e.getActionCommand())) {
//			sf.index = 2;
//			try {
//				this.remove(sf);
//			} catch (Exception e1) {
//			} // clear window, maybe there is a method
//			this.add(sf);// the panel you want to show
//			veHinhNon();
//		}
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame mainframe = new MainFrame();
				mainframe.setVisible(true);
			}
		});
	}

}