
package Classes;

import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

abstract public class Unit {
    static int units;
    protected String enemytype;
    protected int health, maxhealth, armour, atkdamage, rank, upgradecost, cost, x, y;
    protected int  m1,m2,m3;
    protected boolean m1rule, m2rule, m3rule;
    protected String name, type;
    protected Rectangle hitbox;
    protected Image image;
    public Unit(int r, String n,int xpos, int ypos) throws SlickException {
        name = n;
        x= xpos;
        y = ypos;
        setrank(r);
        hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
        
        
     }
    public Unit(int r, String n) throws SlickException {
        name = n;
        setrank(r);
        hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
        
     }
    
    
    abstract public void rank1();
    abstract public void rank2();
    abstract public void rank3();
    abstract public void rank4();
    abstract public void rank5();
    public void uprank(){
        rank++;
        if(rank ==1)rank1();
        if(rank ==2)rank2();
        if(rank ==3)rank3();
        if(rank ==4)rank4();
        if(rank ==5)rank5();
        
        
    }
    public void setrank(int r){
        rank = r;
        if(rank ==1)rank1();
        if(rank ==2)rank2();
        if(rank ==3)rank3();
        if(rank ==4)rank4();
        if(rank ==5)rank5();
        
        
    }
     /* Rank Methods
    *   ^
        |
    */  
    
    
    
    
    
    public void takedamage(int ed){
        health -=(ed-armour);
    }
    public void setx(int xpos){
        x = xpos;
        hitbox.setX(x);
    }
    public void sety(int ypos){
        y = ypos;
        hitbox.setY(y);
    }
    public int dodamage(int ed, String etype){
        int damage;
        enemytype = etype;
        damage = atkdamage;
        if (m1rule) {
            damage += m1;
        }
        if (m1rule) {
            damage += m2;
        }
        if (m1rule) {
            damage += m3;
        }
        return damage;
        
    }
    public void draw(){
        image.draw(x,y);}
    public int defensedamage(int ed, String etype){
        int damage;
        enemytype = etype;
        damage = atkdamage;
        if (m1rule) {
            damage += m1;
        }
        if (m1rule) {
            damage += m2;
        }
        if (m1rule) {
            damage += m3;
        }
        return Math.round(damage/2);
        
    }
     /* Damage   Methods
    *   ^
        |
    */  
   
    
    
   
    final public int gethealth(){
        return health;
    }
    final public int getx(){
        return x;
    }
    final public int gety(){
        return y;
    }
    final public int getarmour(){
        return armour;
    }
    final public int getrank(){
        return rank;
    }
    final public int getupgradecost(){
        return upgradecost;
    }
    final public int getcost(){
        return cost;
    }
    final public String getname(){
        return name;
    }
    final public String gettype(){
        return type;
    }
     /* Getter Methods
    *   ^
        |
    */  
    
    
        
    
    
}
