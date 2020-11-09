
package ButtonClasses;


import UnitClasses.Archer;

import UnitClasses.Unit;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.Input;
public class BuyArcher extends Button{
    Input i;
    public BuyArcher(Input in, Image img){
        super(img,"BuySword",540, 250);
        i = in;
    
    
    }
    

    

    
    public boolean function(int mx, int my, int gold, int s, ArrayList<Unit> list) throws SlickException {
        Archer temp = new Archer("Bob", 1);
        if (super.hit(mx, my,i)) {
            if(s <= 5 && gold >= temp.getupgradecost()){
                list.add(temp);
                return true;
                
                
        
        }
            else{return false;}
        }
        else{return false;}
        
    }
    
}
