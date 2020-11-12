
package UnitClasses;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class error {
    private int timer;
    private Rectangle rect; 
    boolean thing;
    public error() throws SlickException{
        timer = 0;
        thing = false;
    }
    public void start(String str){
        
        timer++;
        
        if (timer<100 ) {
            thing = true;
        }
         
    
    }
    public void draw(Graphics g){
        if(thing){
        rect = new Rectangle(570,340,100,40);
            g.setColor(Color.black);
            g.fill(rect);
            g.setColor(Color.white);
            g.drawString("Invalid Move",580 , 350);
    }}
}
    
