
package States;



import ButtonClasses.StartButton;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

public class StartScreen extends BasicGameState {
    Input in;
    StartButton start;
    Image img;
    Image startimg;
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        in = gc.getInput();
        startimg = new Image("src/Images/start.png");
        start = new StartButton(in, startimg);
        img = new Image("src/Images/rome.jpg");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        int mx = in.getMouseX();
        int my = in.getMouseY();
        if (start.function(mx, my)) {
            sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
        
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       img.draw(0, 0);
       start.draw(g);
    }
    
    public int getID() {
       return 0;  //this id will be different for each screen
    }

    
}