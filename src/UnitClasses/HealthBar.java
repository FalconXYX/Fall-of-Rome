
package UnitClasses;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.*;


public class HealthBar {
    private int health, maxhealth,x,y,wgreen,wred,h, w;
    private double percent;
    Rectangle green, red, black;
    Unit temp;
    public HealthBar(Unit u, int xpos, int ypos){
        temp = u;
        x= xpos;
        y=ypos;
        h=15;
        w = 150;
        wgreen = 150;
        wred = 150;
        black = new Rectangle(x,y,w,h);
        green = new Rectangle(x+1,y+1,wgreen,h-2);
        red = new Rectangle(x+1,y+1,wred,h-2);
}
    public void setx(int xpos){
        x=xpos;
    }
     public void sety(int ypos){
        y=ypos;
    }
     public void setwgreen(int width){
        wgreen = width;
    }
     public void setwred(int width){
        wred = width;
    }
     public double calc(){
         health = temp.gethealth();
         maxhealth = temp.getmaxhealth();
         percent = health/maxhealth;
         wgreen *=percent;
         return percent;
         
     
     }
     public int getx(){
     return x;
     }
     public int gety(){
     return y;
     }
     public int geth(){
     return h;
     }
     public int getwgreen(){
     return wgreen;
     }
     public void draw(Graphics g){
         g.setColor(Color.black);
         g.draw(black);
         g.setColor(Color.red);
         g.draw(red);
         g.setColor(Color.green);
         g.draw(green);
         
     
     
     
     }
}
