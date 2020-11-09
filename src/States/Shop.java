
package States;



import ButtonClasses.*;
import ButtonClasses.NextButton;
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
    BuySwordsman sword; 
    BuyArcher archer;
    BuySpearman spear;
    BuyCavalry cavalry;
    BuyCatapult catapult; 
    NextButton next;
    Image swordimg, archerimg,spearimg, cavalryimg, catapultimg, nextimg;
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        in = gc.getInput();
        swordimg = new Image("src/Images/start.png");
        sword = new BuySwordsman(in, swordimg);
        
        archerimg = new Image("src/Images/start.png");
        archer = new BuyArcher(in, archerimg);
        
        spearimg = new Image("src/Images/start.png");
        spear = new BuySpearman(in, spearimg);
        
        cavalryimg = new Image("src/Images/start.png");
        cavalry = new BuyCavalry(in, cavalryimg);
        
        catapultimg = new Image("src/Images/start.png");
        catapult = new BuyCatapult(in, catapultimg);

        nextimg = new Image("src/Images/Next.png");
        next = new NextButton(in, nextimg);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        int mx = in.getMouseX();
        int my = in.getMouseY();
        if (next.function(mx, my)) {
            sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
        
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       next.draw(g);
       archer.draw(g);
       catapult.draw(g);
       spear.draw(g);
       sword.draw(g);
       next.draw(g);
       cavalry.draw(g);
       
       
    }
    
    public int getID() {
       return 2;  //this id will be different for each screen
    }

    
}