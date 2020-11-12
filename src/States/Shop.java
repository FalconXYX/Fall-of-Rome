
package States;



import ButtonClasses.*;
import ButtonClasses.NextButton;
import UnitClasses.Unit;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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

public class Shop extends BasicGameState {
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
        shopback = new Image("src/Images/shop.png");
        swordimg = new Image("src/Images/swordbuy.png");
        sword = new BuySwordsman(in, swordimg);
        
        archerimg = new Image("src/Images/archerbuy.png");
        archer = new BuyArcher(in, archerimg);
        
        spearimg = new Image("src/Images/spearbuy.png");
        spear = new BuySpearman(in, spearimg);
        
        cavalryimg = new Image("src/Images/cavalrybuy.png");
        cavalry = new BuyCavalry(in, cavalryimg);
        
        catapultimg = new Image("src/Images/catapultbuy.png");
        catapult = new BuyCatapult(in, catapultimg);

        nextimg = new Image("src/Images/Next.png");
        next = new NextButton(in, nextimg);
        
        goldimg =  new Image("src/Images/Money.png");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        int mx = in.getMouseX();
        int my = in.getMouseY();
        for (Unit u:Launcher.units) {
            
           
            if(u == null){
                    Launcher.units.remove(u);
                    break;
                
                
                }
            
            }
        if (sword.function(mx, my, Launcher.units.size())) {
            try {
                TimeUnit.MILLISECONDS.sleep(150);
                
            } catch (InterruptedException ex) {
                //
            }
        }
        if (spear.function(mx, my, Launcher.units.size())) {
            try {
                
                TimeUnit.MILLISECONDS.sleep(150);
                
            } catch (InterruptedException ex) {
                //
            }
        }
        if (archer.function(mx, my, Launcher.units.size())) {
            try {
                TimeUnit.MILLISECONDS.sleep(150);
                
            } catch (InterruptedException ex) {
                //
            }
        }
        
        if (cavalry.function(mx, my, Launcher.units.size())) {
            try {
                TimeUnit.MILLISECONDS.sleep(150);
                
                
            } catch (InterruptedException ex) {
                //
            }
        }
        if (catapult.function(mx, my, Launcher.units.size())) {
            try {
               TimeUnit.MILLISECONDS.sleep(150);
               
               
            } catch (InterruptedException ex) {
                //
            }
        }
        
        if (next.function(mx, my)) {
            if (Launcher.units.size()  == 0) {
                JOptionPane.showMessageDialog(null, "Please Buy at Least one unit");
                return;
            }
            if(Launcher.units.size()  != 5){
                while(Launcher.units.size()  != 5){
                Launcher.units.add(Launcher.units.size(), null);
                }   
            }
            if (Launcher.isinstuctions==false) {
                sbg.enterState(3, new FadeOutTransition(), new FadeInTransition());
            }
            else{sbg.enterState(3+Launcher.level, new FadeOutTransition(), new FadeInTransition());}
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
       g.drawString("90 Gold", 165, 250);
       g.drawString("120 Gold", 365, 250);
       g.drawString("100 Gold", 565, 250);
       g.drawString("100 Gold", 765, 250);
       g.drawString("80 Gold", 965, 250);
       
    }
    
    public int getID() {
       return 2;  //this id will be different for each screen
    }

    
}