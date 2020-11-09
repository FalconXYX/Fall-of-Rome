
package ButtonClasses;


import UnitClasses.Spearman;
import UnitClasses.Unit;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.Input;
public class BuySpearman extends Button{
    Input i;
    public BuySpearman(Input in, Image img){
        super(img,"BuySword",540, 250);
        i = in;
    
    
    }
    

    

    
    public boolean function(int mx, int my, int gold, int s, ArrayList<Unit> list) throws SlickException {
        Spearman temp = new Spearman("Bob", 1);
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
