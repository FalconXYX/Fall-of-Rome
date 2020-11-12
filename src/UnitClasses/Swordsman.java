
package UnitClasses;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class Swordsman extends Unit {
    public Swordsman(String n, int r) throws SlickException  {
        super(r,n);
        x =0;
        y=0;
        m1 = 3;
        m2 = 1;
        m3 = -3;
        m1rule = health >= (maxhealth*0.66);  
        m2rule = health < (maxhealth*0.66) && health > (maxhealth*0.33);
        m3rule = health <= (maxhealth*0.33);
        type = "Melee";
        image = new Image("src\\Images\\Swordsman.PNG");
        hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
                
    
    
    }
    public Swordsman(String n, int r , int xpos, int ypos) throws SlickException  {
        super(r,n, xpos,ypos);
        m1 = 3;
        m2 = 1;
        m3 = -3;
        m1rule = health >= (maxhealth*0.66);  
        m2rule = health < (maxhealth*0.66) && health > (maxhealth*0.33);
        m3rule = health <= (maxhealth*0.33);
        type = "Melee";
        image = new Image("src\\Images\\Swordsman.PNG");
        hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
   
    
    
    }

    @Override
    public void rank1() {
        health = 100;
        maxhealth =100;
        armour = 3;
        atkdamage  = 15;
        upgradecost = 100;
        cost = 5;}
        
    
    

    @Override
    public void rank2() {
        maxhealth = 125;
        health = maxhealth;
        armour = 5;
        atkdamage  = 20;
        upgradecost = 150;
        cost = 6;
    }

    @Override
    public void rank3() {
        maxhealth = 140;
        health = maxhealth;
        armour = 7;
        atkdamage  = 23;
        upgradecost = 200;
        cost = 7;       
    }

    @Override
    public void rank4() {
        maxhealth = 170;
        health = maxhealth;
        armour = 10;
        atkdamage  = 28;
        upgradecost = 250;
        cost = 8;       
    }

    @Override
    public void rank5() {
        maxhealth = 200;
        health = maxhealth;
        armour = 14;
        atkdamage  = 35;
        upgradecost = 300;
        cost = 10;        
    }
        
    }

    