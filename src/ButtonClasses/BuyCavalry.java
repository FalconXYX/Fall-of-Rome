
package ButtonClasses;


import UnitClasses.Cavalry;
import UnitClasses.Unit;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.Input;
public class BuyCavalry extends Button{
    Input i;
    public BuyCavalry(Input in, Image img){
        super(img,"BuySword",540, 250);
        i = in;
    
    
    }
    

    

    
    public boolean function(int mx, int my, int gold, int s, ArrayList<Unit> list) throws SlickException {
        Cavalry temp = new Cavalry("Bob", 1);
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