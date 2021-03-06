
package UnitClasses;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;


public class Catapult extends Unit {
    public Catapult(String n, int r) throws SlickException  {
        super(r,n);
        x =0;
        y=0;
        m1 = 2;
        m2 = 1;
        m3 = -1;
        m1rule = health >= (maxhealth*0.66);  
        m2rule = health < (maxhealth*0.66) && health > (maxhealth*0.33);
        m3rule = health <= (maxhealth*0.33);
        type = "Ranged";
        image = new Image("src\\Images\\Catapult.PNG");
        hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
                
    
    
    }
    public Catapult(String n, int r , int xpos, int ypos) throws SlickException  {
        super(r,n, xpos,ypos);
        m1 = 3;
        m2 = 1;
        m3 = -3;
        m1rule = health >= (maxhealth*0.66);  
        m2rule = health < (maxhealth*0.66) && health > (maxhealth*0.33);
        m3rule = health <= (maxhealth*0.33);
        type = "Ranged";
        image = new Image("src\\Images\\Catapult.PNG");
        hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
   
    
    
    }

    @Override
    public void rank1() {
        health = 40;
        maxhealth = 40;
        armour = 0;
        atkdamage  = 20;
        upgradecost = 100;
        cost = 5;}
        
    
    

    @Override
    public void rank2() {
        maxhealth = 60;
        health = maxhealth;
        armour = 0;
        atkdamage  = 23;
        upgradecost = 150;
        cost = 6;
    }

    @Override
    public void rank3() {
        maxhealth = 70;
        health = maxhealth;
        armour = 0;
        atkdamage  = 28;
        upgradecost = 200;
        cost = 7;       
    }

    @Override
    public void rank4() {
        maxhealth = 80;
        health = maxhealth;
        armour = 0;
        atkdamage  = 32;
        upgradecost = 250;
        cost = 8;       
    }

    @Override
    public void rank5() {
        maxhealth = 115;
        health = maxhealth;
        armour = 0;
        atkdamage  = 35;
        upgradecost = 300;
        cost = 10;        
    }
    
}
