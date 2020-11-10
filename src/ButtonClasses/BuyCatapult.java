
package ButtonClasses;


import States.Launcher;
import UnitClasses.Catapult;

import UnitClasses.Unit;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.Input;
public class BuyCatapult extends Button{
    Input i;
    public BuyCatapult(Input in, Image img){
        super(img,"BuyCatapult",540, 250);
        i = in;
    
    
    }
    

    

    
    public boolean function(int mx, int my, int s) throws SlickException {
        Catapult temp = new Catapult("Bob", 1,0,0);
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
