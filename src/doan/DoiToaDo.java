package doan;

import java.awt.Point;

public class DoiToaDo {

	public DoiToaDo() {
    }

	public int round(double tdn) {
		int tdx;
		double sodu = tdn % 5;
		if (sodu != 0) {
			if (sodu >= 3)
				tdx = (int) (tdn + 5 - sodu);
			else
				tdx = (int) (tdn - sodu);
		} else
			tdx = (int) tdn;
		if (tdx > 400)
			tdx = 400;
		return tdx;
	}

	public Point toado1(int x, int y)// lon ra nho
	{
		return (new Point(x / 5 - 40, 40 - y / 5));// voi x va y deu chia het cho 5
	}

	public Point toado2(int x, int y)// nho ra lon
	{

		return (new Point(x * 5 + 200, 200 - 5 * y));
	}

	public Point toado2(double x, double y)// nho ra lon
	{

		return (new Point(round(x * 5 + 200), round(200 - 5 * y)));
	}
}