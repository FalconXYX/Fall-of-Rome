
package ButtonClasses;


import org.newdawn.slick.*;
import org.newdawn.slick.Input;
public class StartButton extends Button{
    Input i;
    public StartButton(Input in, Image img){
        super(img,"Start",500, 450);
        i = in;
    
    
    }
    

    

    
    public boolean function(int mx, int my) {
        if (super.hit(mx, my,i)) {
            return true;
        }
        return false;
    }
    
}
