package doan;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Object3D {
    //put pixel in eclip
    public void plot(int xc, int yc, int x, int y, Graphics2D g2d, int temp)
    {
        g2d.setStroke(new BasicStroke(3));
        if(temp==0 || temp==1 || temp==2) g2d.setColor(Color.BLUE);
        else g2d.setColor(Color.WHITE);
        g2d.drawLine(xc+x, yc-y,xc+x,yc-y);
        g2d.drawLine(xc-x, yc-y,xc-x,yc-y);
        g2d.setColor(Color.BLUE);
        g2d.drawLine(xc+x, yc+y,xc+x,yc+y);
        g2d.drawLine(xc-x, yc+y,xc-x,yc+y);
    }
    // draw eclip with midpoit althorithm
    public void eclipMidpoint(int xc,int yc,int a, int b, Graphics2D g2d)
    {
        int x, y, fx,fy,a2,b2,p, temp =0;
        x=0;
        y=b;
        a2=a*a;
        b2=b*b;
        fx=0;
        fy=2*a2*y;
        plot(xc, yc, x, y, g2d,temp);
        // chia lam 6 so 0,1,2,3,4,5
        if(temp<=5) temp++;
        else temp=0;
        p= (int)(b2-(a2*b)+(0.25*a2)); //p = b2-a2*b+a2/4
        while(fx<fy)
        {
            x++;
            fx += 2*b2;
        //Delay(50);
        if(p<0)
        {
            p += b2*(2*x + 3);//p=p + b2*(2x +3)
        }
        else
        {
            y--;
            p += b2*(2*x +3) + a2*(2- 2*y);//p=p +b2(2x +3) +a2(2-2y)
            fy -= 2*a2;
        }
        plot(xc, yc, x, y,g2d,temp);
        if(temp<=5) temp++;
        else temp=0;
        }
        p = (int)(b2*(x +0.5)*(x +0.5) + a2*(y-1)*(y-1) - a2*b2);
    //
    while(y>0)
    {
        y--;
        fy -= 2*a2;
        //delay(50);
        if(p >=0)
        {
            p += a2*(3-2*y); //p=p +a2(3-2y)
        }
        else
        {
            x++;
            fx += 2*b2;
            p += b2*(2*x +2) +a2*(3- 2*y);//p=p+ b2(2x +2) + a2(3-2y)
        }
        plot(xc, yc, x, y, g2d,temp);
        if(temp<=5) temp++;
        else temp=0;
    }
    }
    
}
