
package doan;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask.*;
import java.util.TimerTask;
import java.util.Timer.*;

import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener, Runnable {

	Surface sf = new Surface();
	Transformation tm = new Transformation();
	xeTangThread xtt = new xeTangThread();
	
	JLabel label4 = new JLabel();
	JButton bt4 = new JButton();
	JButton bt1 = new JButton();

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
				
					try {
						
						for(int i = 0; i<9 ; i++) {
							veXe();
							Thread.sleep(100);
							sf.vienDan = tm.translation(sf.vienDan.x, sf.vienDan.y, 50, 0);
							sf.tiLeX *= 1.1;
							sf.tiLeY *= 1.1;
							sf.vienDan.y += -5;
							
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					
				}	
			}
		});

		bt1.setText("Hinh Non");
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

		// add labels
		this.add(label4);

		// add buttons
		this.add(bt4);
		bt4.setActionCommand("Play");
		this.add(bt1);
		bt1.setActionCommand("Hinh Non");
		this.add(sf);
		bt4.addActionListener(this);
		
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
		
		System.out.println(sf.a);
		System.out.println(sf.b);
		System.out.println(sf.c);
		System.out.println(sf.d);
		sf.repaint();
	}

	public void veHinhNon() {
		sf.repaint();
	}

	Point d1 = new Point(sf.vienDan.x + 20, sf.vienDan.y + 20);
	Point d2 = new Point(sf.vienDan.x + 50, sf.vienDan.y);
	Point tamO = new Point(0, 0);
	int k = 0;

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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}