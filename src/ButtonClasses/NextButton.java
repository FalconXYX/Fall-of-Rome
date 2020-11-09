
package ButtonClasses;


import org.newdawn.slick.*;
import org.newdawn.slick.Input;
public class NextButton extends Button{
    Input i;
    public NextButton(Input in, Image img){
        super(img,"Next",900, 600);
        i = in;
    
    
    }
    

    

    
    public boolean function(int mx, int my) {
        if (super.hit(mx, my,i)) {
            return true;
        }
        return false;
    }
    
}
