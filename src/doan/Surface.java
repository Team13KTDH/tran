package doan;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Random;

import javax.swing.JPanel;

public class Surface extends JPanel {
	public int a;
	public int b;
	public int c;
	public int d;
	public int e;
	public int x1;
	public int y;
	public int k;
	public int index;

	Random generator = new Random();
	int value = generator.nextInt((300 - 50) + 1) + 50;

	// Cac he so
	int f = 14;

	public int tiLeX = 50;
	public int tiLeY = 50;

	Point vienDan = new Point(175, 500);
	Point vemaybay1 = new Point(1100, value);
	Point vemaybay2 = new Point(700, value);
	Point vemaybay3 = new Point(900, value);

	Point nguoi1 = new Point(500, 500);
	Point nguoi2 = new Point(500, 550);
	// 3d
	float[] dash1 = { 2f, 0f, 2f };
	BasicStroke bs1 = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);

	//
	Object3D object1 = new Object3D();
	Transformation tm = new Transformation();

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		this.setBounds(300, 0, 750, 750);
		Graphics2D g2d = (Graphics2D) g;
		doDrawing(g2d);
	}

	// ham ve thi ve vao day
	public Surface() {
		this.index = -1;
	}

	public void doDrawing(Graphics2D g2d) {
		if (index == 1) {
			Axis(g2d);
			int f = 7 * 5;
			XeTang(g2d);
			Banhrang(g2d, a + 3 * 5, d + 10 * 5, 8 * 5, 2 * 5);
			ve4banh(g2d, a - f, b + 7 * 5, 2 * 5);
			veDan(g2d, vienDan);
			duongbang(g2d);
			g2d.setColor(Color.PINK);
			MayBay1(g2d, vemaybay1);
			g2d.setColor(Color.CYAN);
			MayBay1(g2d, vemaybay2);
			g2d.setColor(Color.GRAY);
			MayBay1(g2d, vemaybay3);
			veNguoi(g2d);
		}

		if (index == 2) {
			Axis3D(g2d);
			object1.plot(1, 1, 1, 1, g2d, 1);
			int x = converX3Dto2D(50, 30);
			int z = converZ3Dto2D(30);
			drawCone3D(x, z, 100, 200, g2d);
		}
	}

	public void Axis(Graphics2D g2d) {
		g2d.setColor(Color.GRAY);
		g2d.setStroke(new BasicStroke(1));
		for (int i = 0; i <= 160; i++) {
			g2d.drawLine(5 * i, 0, 5 * i, 750);
			g2d.drawLine(0, 5 * i, 750, 5 * i);
		}
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(Color.BLACK);
	}

	public void veDan(Graphics2D g2d, Point i) {
		g2d.setColor(Color.red);
		g2d.fillOval(i.x, i.y, tiLeX, tiLeY);
	}

	public void veHinhChuNhat(Graphics2D g2d, Point i) {
		g2d.setColor(Color.red);
		g2d.fillOval(i.x, i.y, 10, 10);
		Point temp1 = tm.translation(i.x, i.y, 50, 0);
		g2d.fillOval(temp1.x, temp1.y, 10, 10);
		Point temp2 = tm.translation(temp1.x, temp1.y, 0, 50);
		g2d.fillOval(temp2.x, temp2.y, 10, 10);
		Point temp3 = tm.translation(temp2.x, temp2.y, 50, 50);
		g2d.fillOval(temp3.x, temp3.y, 10, 10);
	}

	//////////////////// 3DDDDD
	public void Axis3D(Graphics2D g2d) {

		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.BLACK);
		// ox
		g2d.drawLine(300, 290, 600, 290);
		g2d.drawString("Ox", 550, 280);
		// dau mui ten
		g2d.drawLine(580, 290, 570, 285);
		g2d.drawLine(580, 290, 570, 295);
		// oy
		g2d.drawLine(300, 290, 300, 0);
		g2d.drawString("Oy", 275, 15);
		g2d.drawLine(300, 2, 295, 10);
		g2d.drawLine(300, 2, 305, 10);
		// oz
		g2d.drawLine(0, 580, 300, 290);
		g2d.drawString("Oz", 5, 550);
		g2d.drawLine(2, 580, 2, 570);
		g2d.drawLine(4, 578, 12, 578);
		// to mau
		g2d.setColor(Color.GRAY);
		g2d.setStroke(new BasicStroke(1));
		for (int i = 1; i <= 140; i++) {
			g2d.drawLine(300 + i * 5, 290, 0 + i * 5, 580);

		}
		for (float i = 1; i <= 58; i++) {
			g2d.drawLine((int) (300 - (i * 5.0 * (float) 30 / 29)), (int) (290 + (i * 5)), 600, (int) (290 + (i * 5)));
		}
	}

	public void drawCone3D(int ox, int oy, int r, int h, Graphics2D g2d) {
		g2d.setColor(Color.BLUE);

		int a = r, b = a / 2;

		// ve hinh eclip
		Object3D eclip = new Object3D();
		eclip.eclipMidpoint(ox, oy, a, b, g2d);
		// two line can visible
		g2d.drawLine(ox, oy - h, ox - a - 2, oy);
		g2d.drawLine(ox, oy - h, ox + a, oy);
		// line index unvisible
		g2d.setStroke(bs1);
		g2d.drawLine(ox, oy - h, ox, oy);
		// g2d.dispose();
		g2d.drawLine(ox, oy, ox + a, oy);
		// ve cai ten
		// tam O
		g2d.setFont(new Font("Arial", Font.BOLD, 15));
		g2d.drawString("O", ox - 25, oy);
		g2d.drawString("A", ox, oy - h - 10);
		g2d.drawString("r", (ox + a / 2), oy - 10);
		g2d.drawString("h", ox + 10, oy - (h / 2));

	}

	public int converX3Dto2D(int x, int z) {
		return (int) (x * 5 - z * 5 * 0.7189 + 300); // 0.7189 = sin(30/29)
	}

	public int converZ3Dto2D(int z) {
		return (int) (z * 5 * 0.6950 + 290); // 0.6950 = cos(30/29)
	}

	public void veNguoi(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		g2d.fillOval(Math.round(nguoi1.x), Math.round(nguoi1.y), 3, 3);
		g2d.fillOval(Math.round(nguoi2.x), Math.round(nguoi2.y), 3, 3);
		duongthang(g2d, nguoi1.x, nguoi1.y, nguoi2.x, nguoi2.y);
		tm.gocquay = 30;
		Point temp = tm.Quay(nguoi1, nguoi2);
		duongthang(g2d, temp.x, temp.y, nguoi1.x, nguoi1.y);
		tm.gocquay = -30;
		Point temp2 = tm.Quay(nguoi1, nguoi2);
		duongthang(g2d, nguoi1.x, nguoi1.y, temp2.x, temp2.y);

	}

	public void XeTang(Graphics2D g2d) {
		// ve than xe tang
		int x = 2 * 5;
		duongthang((Graphics2D) g2d, a, b, c, b);
		duongthang((Graphics2D) g2d, a, b, a, d);
		duongthang((Graphics2D) g2d, c, d, a, d);
		duongthang((Graphics2D) g2d, c, d, c, b);
		duongthang((Graphics2D) g2d, a - x, b, a, b);
		duongthang((Graphics2D) g2d, a, d, a - x, b);
		duongthang((Graphics2D) g2d, c, b, c + x, b);
		duongthang((Graphics2D) g2d, c, d, c + x, b);
		duongthang((Graphics2D) g2d, a, b, c, d);
		duongthang((Graphics2D) g2d, a, d, c, b);

		duongthang((Graphics2D) g2d, a - 5 * 5, b, c + 6 * 5, b);
		duongthang((Graphics2D) g2d, a - 5 * 5, b, a - 5 * 5, b + 5 * 5);
		duongthang((Graphics2D) g2d, c + 6 * 5, b, c + 6 * 5, b + 5 * 5);
		duongthang((Graphics2D) g2d, a - 10 * 5, b + 5 * 5, c + 10 * 5, b + 5 * 5);
		duongthang((Graphics2D) g2d, a - 5 * 5, b, a - 10 * 5, b + 5 * 5);
		duongthang((Graphics2D) g2d, c + 6 * 5, b, c + 10 * 5, b + 5 * 5);
		duongthang((Graphics2D) g2d, a - 5 * 5, b + 5 * 5, a - 5 * 5, b + 9 * 5);
		duongthang((Graphics2D) g2d, a - 10 * 5, b + 5 * 5, a - 5 * 5, b + 9 * 5);
		duongthang((Graphics2D) g2d, c + 6 * 5, b + 9 * 5, c + 10 * 5, b + 5 * 5);
		duongthang((Graphics2D) g2d, c + 6 * 5, b + 5 * 5, c + 6 * 5, b + 9 * 5);
		duongthang((Graphics2D) g2d, a - 5 * 5, b + 9 * 5, c + 6 * 5, b + 9 * 5);

		// ve nong sung cua tank
		duongthang((Graphics2D) g2d, c, d, c + 15 * 5, d);
		duongthang((Graphics2D) g2d, c, d + 1 * 5, c + 15 * 5, d + 1 * 5);

		// ve dau nong
		g2d.setColor(Color.blue);
		tomau(g2d, a - 5 * 5, b + 5 * 5, c + 6 * 5, d + 3 * 5);
		duongthang((Graphics2D) g2d, c + 15 * 5, d, c + 16 * 5, d - 1 * 5);
		duongthang((Graphics2D) g2d, c + 15 * 5, d + 1 * 5, c + 16 * 5, d + 2 * 5);
		duongthang((Graphics2D) g2d, c + 16 * 5, d - 1 * 5, c + 20 * 5, d - 1 * 5);
		duongthang((Graphics2D) g2d, c + 16 * 5, d + 2 * 5, c + 20 * 5, d + 2 * 5);
		duongthang((Graphics2D) g2d, c + 20 * 5, d - 1 * 5, c + 20 * 5, d + 2 * 5);
		duongthang((Graphics2D) g2d, c + 15 * 5, d, c + 15 * 5, d + 1 * 5);
		duongthang((Graphics2D) g2d, c + 16 * 5, d - 1 * 5, c + 16 * 5, d + 2 * 5);
		duongthang((Graphics2D) g2d, c + 17 * 5, d - 1 * 5, c + 17 * 5, d + 2 * 5);
		duongthang((Graphics2D) g2d, c + 19 * 5, d - 1 * 5, c + 19 * 5, d + 2 * 5);
		g2d.setColor(Color.green);
		tomau(g2d, a, b, c, d);

	}

	public void tomau(Graphics2D g2d, int x0, int y0, int x1, int y1) {
		// to mau
		int dy = Math.abs(y1 - y0);
		int dx = Math.abs(x1 - x0);
		int x, y;
		if (x0 >= x1)
			x = x1;
		else
			x = x0;
		if (y0 >= y1)
			y = y1;
		else
			y = y0;
		g2d.fillRect(x, y, dx, dy);
	}

	void put8pixel(Graphics2D g2d, int xc, int yc, int x, int y) {
		g2d.setColor(Color.WHITE);
		g2d.fillOval(x + xc, y + yc, 3, 3);
		g2d.fillOval(-x + xc, y + yc, 3, 3);
		g2d.fillOval(x + xc, -y + yc, 3, 3);
		g2d.fillOval(-x + xc, -y + yc, 3, 3);
		g2d.fillOval(y + xc, x + yc, 3, 3);
		g2d.fillOval(-y + xc, x + yc, 3, 3);
		g2d.fillOval(y + xc, -x + yc, 3, 3);
		g2d.fillOval(-y + xc, -x + yc, 3, 3);
	}

	void banhxe(Graphics2D g2d, int xc, int yc, int r) {
		int x = 0;
		int y = r;
		int f = 1 - r;
		put8pixel(g2d, xc, yc, x, y);
		while (x < y) {
			if (f < 0)
				f += (x << 1) + 3;
			else {
				y--;
				f += ((x - y) << 1) + 5;
			}
			x++;
			put8pixel(g2d, xc, yc, x, y);
		}
	}

	void ve4banh(Graphics2D g2d, int xc, int yc, int r) {
		int kc = 0;
		for (int i = 0; i < 4; i++) {
			kc += 4 * 5;
			banhxe(g2d, (xc + kc), yc, r);
		}
	}

	public void Banhrang(Graphics2D g2d, int x_center, int y_center, int a, int b) {
		float p, a2, b2;
		int x, y;
		int check1 = 1;
		int check2 = 1;
		a2 = a * a;
		b2 = b * b;
		x = 0;
		y = b;
		p = 2 * ((float) b2 / a2) - (2 * b) + 1;

		// Ve net dut
		// ve nhanh thu 1(tren trai)
		while (((float) b2 / a2) * x <= y) {
			if (check1 % 2 != 0) {
				for (int i = 0; i < 5; i++) {
					putnetdut(g2d, x_center, y_center, x, y);
					if (p < 0) {
						p = p + 2 * ((float) b2 / a2) * (2 * x + 3);
					} else {
						p = p - 4 * y + 2 * ((float) b2 / a2) * (2 * x + 3);
						y--;
					}
					x++;
				}
			} else {
				for (int i = 0; i < 5; i++) {
					if (p < 0) {
						p = p + 2 * ((float) b2 / a2) * (2 * x + 3);
					} else {
						p = p - 4 * y + 2 * ((float) b2 / a2) * (2 * x + 3);
						y--;
					}
					x++;
				}
			}
			check1++;
		}

		// ve nhanh thu 2(phia tren ben phai)
		y = 0;
		x = a;
		p = 2 * ((float) a2 / b2) - 2 * a + 1;
		while (((float) a2 / b2) * y <= x) {
			if (check2 % 2 != 0) {
				for (int i = 0; i < 5; i++) {
					putnetdut(g2d, x_center, y_center, x, y);
					if (p < 0) {
						p = p + 2 * ((float) a2 / b2) * (2 * y + 3);
					} else {
						p = p - 4 * x + 2 * ((float) a2 / b2) * (2 * y + 3);
						x--;
					}
					y++;
				}
			} else {
				for (int i = 0; i < 5; i++) {
					if (p < 0) {
						p = p + 2 * ((float) a2 / b2) * (2 * y + 3);
					} else {
						p = p - 4 * x + 2 * ((float) a2 / b2) * (2 * y + 3);
						x--;
					}
					y++;

				}
			}
			check2++;
		}

		// ve net lien
		x = 0;
		y = b;
		p = 2 * ((float) b2 / a2) - (2 * b) + 1;
		// ve nhanh thu 3(phia duoi ben phai)
		while (((float) b2 / a2) * x <= y) {
			putnetdut(g2d, x_center, y_center, x, y);
			if (p < 0) {
				p = p + 2 * ((float) b2 / a2) * (2 * x + 3);
			} else {
				p = p - 4 * y + 2 * ((float) b2 / a2) * (2 * x + 3);
				y--;
			}
			x++;
		}

		// ve nhanh thu 4(phia duoi ben trai)
		y = 0;
		x = a;
		p = 2 * ((float) a2 / b2) - 2 * a + 1;
		while (((float) a2 / b2) * y <= x) {
			putnetdut(g2d, x_center, y_center, x, y);
			if (p < 0) {
				p = p + 2 * ((float) a2 / b2) * (2 * y + 3);
			} else {
				p = p - 4 * x + 2 * ((float) a2 / b2) * (2 * y + 3);
				x--;
			}
			y++;
		}
	}

	void putnetdut(Graphics g2d, int xc, int yc, int x, int y) {
		g2d.setColor(Color.red);
		g2d.fillOval(xc - x, yc - y, 3, 3);// trên trái
		g2d.fillOval(xc + x, yc - y, 3, 3);// trên phải
		g2d.fillOval(xc + x, yc + y, 3, 3);
		g2d.fillOval(xc - x, yc + y, 3, 3);

	}

	void putnetlien(Graphics g2d, int xc, int yc, int x, int y) {
		g2d.setColor(Color.red);
		g2d.fillOval(xc + x, yc + y, 5, 5); // dưới phải
		g2d.fillOval(xc - x, yc + y, 5, 5); // dưới trái

	}

	public void duongthang(Graphics2D g2d, int x1, int y1, int x2, int y2) {
		int dx, dy;
		int xet = 1;
		float Xinc, Yinc, x, y, steps;
		int tamx, tamy;
		// MidpointLine(g2d,c,d,c-45,d+30);

		if (x1 > x2 || y1 > y2) {
			tamx = x1;
			x1 = x2;
			x2 = tamx;
			tamy = y1;
			y1 = y2;
			y2 = tamy;
		}

		dy = y2 - y1;
		dx = x2 - x1;

		if (dy > dx) {
			steps = Math.abs(dy);
		} else {
			steps = Math.abs(dx);
		}
		x = x1;
		y = y1;
		Yinc = dy / steps;
		Xinc = dx / steps;

		while (steps != 0) {
			if (xet % 2 != 0) {
				// net gach
				for (int i = 0; i < 5; i++) {
					steps--;
					x = x + Xinc;
					y = y + Yinc;
					g2d.setColor(Color.WHITE);
					g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
				}
			}
			xet++;
		}
	}

	public void MayBay1(Graphics2D g2d, Point i) {

		x1 = i.x;
		y = i.y;
		// Than
		g2d.setColor(Color.GRAY);
		DrawElip(g2d, x1, y, 14 * 5, 3 * 5);
		// Canh tren
		duongthang(g2d, x1 - 3 * 5, y - 3 * 5, x1, y - 9 * 5);
		duongthang(g2d, x1, y - 9 * 5, x1 + 3 * 5, y - 10 * 5);
		duongthang(g2d, x1 + 3 * 5, y - 10 * 5, x1 + 5, y - 3 * 5);
		// Canh duoi
		duongthang(g2d, x1 - 3 * 5, y + 5, x1, y + 8 * 5);
		duongthang(g2d, x1, y + 8 * 5, x1 + 3 * 5, y + 9 * 5);
		duongthang(g2d, x1 + 3 * 5, y + 9 * 5, x1 + 5, y + 5);
		// Duoi
		duongthang(g2d, x1 + 9 * 5, y, x1 + 13 * 5, y - 5 * 5);
		duongthang(g2d, x1 + 13 * 5, y - 5 * 5, x1 + 17 * 5, y - 5 * 5);
		duongthang(g2d, x1 + 17 * 5, y - 5 * 5, x1 + 14 * 5, y);
	}

	public void duongbang(Graphics2D g2d) {
		duongthang((Graphics2D) g2d, 22 * 5, d + 11 * 5, 200 * 5, d + 11 * 5);
		duongthang((Graphics2D) g2d, 0, d + 25 * 5, 200 * 5, d + 25 * 5);
		duongthang((Graphics2D) g2d, 0 * 5, d + 11 * 5, 3 * 5, d + 11 * 5);

		tomau(g2d, 6 * 5, d + 17 * 5, 15 * 5, d + 18 * 5);

		int a1 = 6;
		int b1 = 15;

		for (int i = 0; i < 10; i++) {
			a1 = a1 + f;
			b1 = b1 + f;

			g2d.setColor(Color.white);
			tomau(g2d, a1 * 5, d + 17 * 5, b1 * 5, d + 18 * 5);

		}
	}

	public void DrawElip(Graphics2D g2d, int x_center, int y_center, int a, int b) {
		float p, a2, b2;
		int x, y;
		int check1 = 1;
		int check2 = 1;
		a2 = a * a;
		b2 = b * b;
		x = 0;
		y = b;
		p = 2 * ((float) b2 / a2) - (2 * b) + 1;

		// Ve net dut
		// ve nhanh thu 1(tren trai)
		while (((float) b2 / a2) * x <= y) {
			if (check1 % 2 != 0) {
				for (int i = 0; i < 15; i++) {
					putnetdut(g2d, x_center, y_center, x, y);
					if (p < 0) {
						p = p + 2 * ((float) b2 / a2) * (2 * x + 3);
					} else {
						p = p - 4 * y + 2 * ((float) b2 / a2) * (2 * x + 3);
						y--;
					}
					x++;
				}
			} else {
				for (int i = 0; i < 15; i++) {
					if (p < 0) {
						p = p + 2 * ((float) b2 / a2) * (2 * x + 3);
					} else {
						p = p - 4 * y + 2 * ((float) b2 / a2) * (2 * x + 3);
						y--;
					}
					x++;
				}
			}
			check1++;
		}
		// ve net lien
		x = 0;
		y = b;
		p = 2 * ((float) b2 / a2) - (2 * b) + 1;
		// ve nhanh thu 3(phia duoi ben phai)
		while (((float) b2 / a2) * x <= y) {
			putnetdut(g2d, x_center, y_center, x, y);
			if (p < 0) {
				p = p + 2 * ((float) b2 / a2) * (2 * x + 3);
			} else {
				p = p - 4 * y + 2 * ((float) b2 / a2) * (2 * x + 3);
				y--;
			}
			x++;
		}

		// ve nhanh thu 4(phia duoi ben trai)
		y = 0;
		x = a;
		p = 2 * ((float) a2 / b2) - 2 * a + 1;
		while (((float) a2 / b2) * y <= x) {
			putnetdut(g2d, x_center, y_center, x, y);
			if (p < 0) {
				p = p + 2 * ((float) a2 / b2) * (2 * y + 3);
			} else {
				p = p - 4 * x + 2 * ((float) a2 / b2) * (2 * y + 3);
				x--;
			}
			y++;
		}
	}
}
