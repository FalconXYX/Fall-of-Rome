
package States;




import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Youwon extends BasicGameState {
    
    Image img;
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
       
        img = new Image("src/Images/lost.png");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
       
        
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       img.draw(0, 0);
       
    }
    
    public int getID() {
       return 9;  //this id will be different for each screen
    }

    
}