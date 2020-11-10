
package ButtonClasses;


import States.Launcher;
import UnitClasses.Archer;

import UnitClasses.Unit;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.Input;
public class BuyArcher extends Button{
    Input i;
    public BuyArcher(Input in, Image img){
        super(img,"BuyArcher",110, 250);
        i = in;
    
    
    }
    

    

    
    public boolean function(int mx, int my, int s) throws SlickException {
        Archer temp = new Archer("Bob", 1, 0, 0);
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
