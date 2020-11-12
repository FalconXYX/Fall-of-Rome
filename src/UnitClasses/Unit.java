
package UnitClasses;

import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

abstract public class Unit {
    static int units;
    protected String enemytype;
    protected double percent;
    protected int health, maxhealth, armour, atkdamage, rank, upgradecost, cost, x, y, target, wgreen;
    protected int  m1,m2,m3;
    protected boolean m1rule, m2rule, m3rule;
    protected String name, type;
    protected Rectangle hitbox, blackrect, redrect, greenrect;
    protected Image image;
    protected Color color;
    protected HealthBar h;
    
    public Unit(int r, String n,int xpos, int ypos) throws SlickException {
        name = n;
        x= xpos;
        y = ypos;
        setrank(r);
        color = Color.black;
       wgreen = 98;
        
        
     }
    public Unit(int r, String n) throws SlickException {
        name = n;
        setrank(r);
        x=0;
        y=0;
        wgreen = 98;
       
        color = Color.black;
        
        
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
    public void heal(){
        health = maxhealth;
    }
    public void setwgreen(int width){
        wgreen = width;
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
    
    
    
    
    final public void settarget(int t){
        target = t;
    }
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
    public int dodamage(Unit enemy){
        int damage;
        enemytype = enemy.gettype();
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
    public void draw(Graphics g){
        image.draw(x,y);
         blackrect = new Rectangle(x,y-15,100,15);
        greenrect = new Rectangle(x+1,y-14,wgreen,13);
        redrect = new Rectangle(x+1,y-14,98,13);
        g.setColor(Color.black);
         g.fill(blackrect);
         g.setColor(Color.red);
         g.fill(redrect);
         g.setColor(Color.green);
         g.fill(greenrect);
        
        g.setColor(color);
        //g.draw(hitbox);
        
        }
    public void setcolor(Color g){   
        color = g;
 
        
        }
    public int defensedamage( Unit enemy){
        int damage;
        enemytype = enemy.gettype();
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
        if (enemytype.equals("ranged")) {
            damage = 0;
        }
        return Math.round(damage/2);
        
    }
     /* Damage   Methods
    *   ^
        |
    */  
    public double calc(){
         
         percent = (double)health/(double)maxhealth;
        
         wgreen =(int) (98*percent);
         return percent;
    }
    public int getwgreen(){
     return wgreen;
     }
   
    final public int gethealth(){
        return health;
    }
    final public int gettarget(){
        return target;
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
    final public int getmaxhealth(){
        return maxhealth;
    }
     /* Getter Methods
    *   ^
        |
    */  
    
    
        
    
    
}
