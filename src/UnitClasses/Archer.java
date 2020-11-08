
package UnitClasses;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;


public class Archer extends Unit{
    public Archer(String n, int r) throws SlickException  {
        super(r,n);
        x =0;
        y=0;
        m1 = 5;
        m2 = 3;
        m3 = 1;
        m3rule = armour <= 6;  
        m2rule = armour > 6  && armour < 16;  
        m1rule = armour > 16;
        type = "Ranged";
        image = new Image("src\\Images\\Archer.PNG");
        
                
    
    
    }
    public Archer(String n, int r , int xpos, int ypos) throws SlickException  {
        super(r,n, xpos,ypos);
        m1 = 5;
        m2 = 3;
        m3 = 1;
        m3rule = armour <= 6;  
        m2rule = armour > 6  && armour < 16;  
        m1rule = armour > 16;
        type = "Ranged";
        image = new Image("src\\Images\\Archer.PNG");
        hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
   
    
    
    }

    @Override
   public void rank1() {
        health = 70;
        armour = 0;
        atkdamage  = 15;
        upgradecost = 90;
        cost = 4;}
        
    
    

    @Override
    public void rank2() {
        health = 90;
        armour = 2;
        atkdamage  = 23;
        upgradecost = 130;
        cost = 5;
    }

    @Override
    public void rank3() {
        health = 110;
        armour = 4;
        atkdamage  = 28;
        upgradecost = 180;
        cost = 6;       
    }

    @Override
    public void rank4() {
        health = 130;
        armour = 6;
        atkdamage  = 30;
        upgradecost = 210;
        cost = 7;       
    }

    @Override
    public void rank5() {
        health = 150;
        armour = 8;
        atkdamage  = 33;
        upgradecost = 250;
        cost = 8;        
    }
    
}
