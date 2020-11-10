
package States;



import ButtonClasses.*;
import ButtonClasses.NextButton;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

public class Level1 extends BasicGameState {
    Input in;
    BuySwordsman sword; 
    BuyArcher archer;
    BuySpearman spear;
    BuyCavalry cavalry;
    BuyCatapult catapult; 
    NextButton next;
    Image swordimg, archerimg,spearimg, cavalryimg, catapultimg, nextimg, goldimg, shopback;
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        in = gc.getInput();
        
        
        goldimg =  new Image("src/Images/Money.png");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        int mx = in.getMouseX();
        int my = in.getMouseY();
        
        if (sword.function(mx, my, Launcher.units.size())) {
            try {
                TimeUnit.MILLISECONDS.sleep(120);
            } catch (InterruptedException ex) {
                //
            }
        }
        if (spear.function(mx, my, Launcher.units.size())) {
            try {
                
                TimeUnit.MILLISECONDS.sleep(120);
            } catch (InterruptedException ex) {
                //
            }
        }
        if (archer.function(mx, my, Launcher.units.size())) {
            try {
                TimeUnit.MILLISECONDS.sleep(120);
            } catch (InterruptedException ex) {
                //
            }
        }
        if (cavalry.function(mx, my, Launcher.units.size())) {
            try {
                TimeUnit.MILLISECONDS.sleep(120);
            } catch (InterruptedException ex) {
                //
            }
        }
        if (catapult.function(mx, my, Launcher.units.size())) {
            try {
               TimeUnit.MILLISECONDS.sleep(120);
            } catch (InterruptedException ex) {
                //
            }
        }
        
        if (next.function(mx, my)) {
            sbg.enterState(Launcher.level+2, new FadeOutTransition(), new FadeInTransition());
        }
        
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        shopback.draw(0, 0);
       next.draw(g);
       archer.draw(g);
       catapult.draw(g);
       spear.draw(g);
       sword.draw(g);
       next.draw(g);
       cavalry.draw(g);
       goldimg.draw(50,0);
       g.setColor(Color.white);
       g.drawString(""+Launcher.gold, 13, 13);
       
       
    }
    
    public int getID() {
       return 2;  //this id will be different for each screen
    }

    
}