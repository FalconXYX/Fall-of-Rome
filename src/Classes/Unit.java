
package Classes;

abstract public class Unit {
    static int units;
    protected int health, armour, atkdamage, rank, upgradecost, cost;
    protected int  m1,m2,m3;
    protected boolean m1rule, m2rule, m3rule;
    protected String name, type;
    public Unit(int r, String n){
        rank = r;
        name = n;
        
     }
    
    
    abstract void rank1();
    abstract void rank2();
    abstract void rank3();
    abstract void rank4();
    abstract void rank5();
    public void uprank(){
        rank++;
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
    public int dodamage(int ed, String etype){
        int damage;
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
    public int defensedamage(int ed, String etype){
        int damage;
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
     /* Damage   Methods
    *   ^
        |
    */  
    
    
   
    public int gethealth(){
        return health;
    }
    public int getarmour(){
        return armour;
    }
    public int getrank(){
        return rank;
    }
    public int getupgradecost(){
        return upgradecost;
    }
    public int getcost(){
        return cost;
    }
    public String getname(){
        return name;
    }
    public String gettype(){
        return type;
    }
     /* Getter Methods
    *   ^
        |
    */  
    
    
        
    
    
}
