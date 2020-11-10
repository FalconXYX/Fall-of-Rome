
package ButtonClasses;


import States.Launcher;
import UnitClasses.Swordsman;

import org.newdawn.slick.*;
import org.newdawn.slick.Input;
public class BuySwordsman extends Button{
    Input i;
    public BuySwordsman(Input in, Image img){
        super(img,"BuySwordsman",740, 250);
        i = in;
    
    
    }
    

    

    
    public boolean function(int mx, int my, int s) throws SlickException {
        Swordsman temp = new Swordsman("Bob", 1,0,0);
        if (super.hit(mx, my,i)) {
            if(s <= 5 && Launcher.gold >= temp.getupgradecost()){
                Launcher.units.add(temp);
                Launcher.gold -= temp.getupgradecost();
                return true;
                
                
        
        }
            else{return false;}
        }
        else{return false;}
        
    }
    
}
