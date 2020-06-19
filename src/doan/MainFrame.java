
package doan;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {

	int a = 10 * 5;
	int b = 103 * 5;
	int c = 15 * 5;
	int d = 100 * 5;
	
	Surface sf = new Surface();
	Transformation tm = new Transformation();
	JLabel label4 = new JLabel();
	JButton bt4 = new JButton();
	JButton bt1 = new JButton();

	// ham khoi tao
	public MainFrame() {
		// ham khoi tao cac gia tri do hoa
		initUI();
	}

	public void initUI() {
		this.setSize(1520, 820);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("KTDH - NHOM 13");

		bt4.setText("Ve hinh");
		bt4.setBounds(70, 580, 150, 40);
		bt4.setBorder(BorderFactory.createBevelBorder(1));
		bt4.setFocusable(false);
		bt4.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 16));
		
		bt1.setText("Tinh tien");
		bt1.setBounds(70, 400, 150, 40);
		bt1.setBorder(BorderFactory.createBevelBorder(1));
		bt1.setFocusable(false);
		bt1.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 16));

		//add labels
		this.add(label4);

		// add buttons
		this.add(bt4);
		bt4.setActionCommand("Ve hinh");
		this.add(bt1);
		bt1.setActionCommand("Tinh tien");
		this.add(sf);
		bt4.addActionListener(this);
	}

	public void veXe() {
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
	
	Point d1 = new Point(sf.vienDan.x+20, sf.vienDan.y+20);
	Point d2 = new Point(sf.vienDan.x +20, sf.vienDan.y);
	Point tamO = new Point(0,0);
	public void actionPerformed(ActionEvent e) {
		if ("Ve hinh".equals(e.getActionCommand())) {
			sf.index = 1;
			Timer timer = new Timer(500, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	veXe();		
	            	sf.vienDan = tm.translation(sf.vienDan.x, sf.vienDan.y, 10, 0);
	            	//sf.vienDan = tm.doixung(sf.vienDan, d2);
	            	//sf.vienDan = tm.Quay(temp, d2);
	            	
	            }
	        });
	        timer.setRepeats(true);
	        timer.start();
		}
		
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