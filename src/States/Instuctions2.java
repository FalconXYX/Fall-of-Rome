
package States;



import ButtonClasses.NextButton;
import ButtonClasses.StartButton;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

public class Instuctions2 extends BasicGameState {
    Input in;
    NextButton next;
    Image img;
    Image nextimg;
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        in = gc.getInput();
        nextimg = new Image("src/Images/Next.png");
        next = new NextButton(in, nextimg);
        img = new Image("src/Images/Instuctions.jpg");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        int mx = in.getMouseX();
        int my = in.getMouseY();
        if (next.function(mx, my)) {
            sbg.enterState(4, new FadeOutTransition(), new FadeInTransition());
        }
        
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       img.draw(0, 0);
       next.draw(g);
    }
    
    public int getID() {
       return 1;  //this id will be different for each screen
    }

    
}