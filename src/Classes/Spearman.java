
package Classes;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class Spearman extends Unit {
    public Spearman(String n, int r) throws SlickException  {
        super(r,n);
        x =0;
        y=0;
        m1 = 4;
        m2 = -3;
        m3 = 0;
        m1rule = enemytype == "Cavalry";
        m2rule = enemytype == "Melee";
        m3rule = enemytype == "Melee";
        
       
        type = "Melee";
        image = new Image("src\\Images\\Spearman.PNG");
        
                
    
    
    }
    public Spearman(String n, int r , int xpos, int ypos) throws SlickException  {
        super(r,n, xpos,ypos);
        m1 = 4;
        m2 = -3;
        m3 = 0;
        m1rule = enemytype == "Cavalry";
        m2rule = enemytype == "Melee";
        type = "Melee";
        image = new Image("src\\Images\\Spearman.PNG");
        hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
   
    
    
    }

    @Override
    public void rank1() {
        health = 80;
        armour = 4;
        atkdamage  = 12;
        upgradecost = 80;
        cost = 4;}
        
    
    

    @Override
    public void rank2() {
        health = 90;
        armour = 6;
        atkdamage  = 18;
        upgradecost = 130;
        cost = 5;
    }

    @Override
    public void rank3() {
        health = 110;
        armour = 8;
        atkdamage  = 21;
        upgradecost = 180;
        cost = 6;       
    }

    @Override
    public void rank4() {
        health = 150;
        armour = 10;
        atkdamage  = 25;
        upgradecost = 210;
        cost = 7;       
    }

    @Override
    public void rank5() {
        health = 180;
        armour = 12;
        atkdamage  = 28;
        upgradecost = 250;
        cost = 8;        
    }
        
    }

    