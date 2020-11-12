
package UnitClasses;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;


public class Cavalry extends Unit {
        public Cavalry(String n, int r) throws SlickException  {
        super(r,n);
        x =0;
        y=0;
        m1 = 3;
        m2 = 0;
        m3 = 0;
        m1rule = false;//enemytype.equals("Ranged"); 
        m2rule = false;
        m3rule = false;
        type = "Cavalry";
        image = new Image("src\\Images\\Cavalry.PNG");
        hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
                
    
    
    }
    public Cavalry(String n, int r , int xpos, int ypos) throws SlickException  {
        super(r,n, xpos,ypos);
        m1 = 3;
        m2 = 0;
        m3 = 0;
        m1rule = false;//enemytype.equals("Ranged");
        m2rule = false;
        m3rule = false;
        type = "Cavalry";
        image = new Image("src\\Images\\Horseman.PNG");
        hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
   
    
    
    }

    @Override
    public void rank1() {
        health = 130;
        maxhealth = 130;
        armour = 5;
        atkdamage  = 15;
        upgradecost = 120;
        cost = 10;}
        
    
    

    @Override
    public void rank2() {
        maxhealth = 155;
        health = maxhealth;
        armour = 8;
        atkdamage  = 20;
        upgradecost = 170;
        cost = 12;
    }

    @Override
    public void rank3() {
        maxhealth = 175;
        armour = 10;
        atkdamage  = 23;
        upgradecost = 210;
        cost = 14;       
    }

    @Override
    public void rank4() {
        maxhealth = 200;
        armour = 13;
        atkdamage  = 28;
        upgradecost = 260;
        cost = 16;       
    }

    @Override
    public void rank5() {
        maxhealth = 225;
        armour = 16;
        atkdamage  = 35;
        upgradecost = 310;
        cost = 20;        
    }
    
}
