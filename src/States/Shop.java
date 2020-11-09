
package States;



import ButtonClasses.*;
import ButtonClasses.StartButton;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

public class Shop extends BasicGameState {
    Input in;
    Button sword, archer, spear, catapult, cavalry;
    Image swordimg, archerimg,spearimg;
    Image startimg;
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        in = gc.getInput();
        swordimg = new Image("src/Images/start.png");
        sword = new BuySwordsman(in, swordimg);
        
        archerimg = new Image("src/Images/start.png");
        archer = new BuyArcher(in, archerimg);
        
        spearimg = new Image("src/Images/start.png");
        spear = new BuySpearman(in, spearimg);
        
        swordimg = new Image("src/Images/start.png");
        sword = new BuySwordsman(in, startimg);
        
        swordimg = new Image("src/Images/start.png");
        sword = new BuySwordsman(in, startimg);

        
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
       return 2;  //this id will be different for each screen
    }

    
}