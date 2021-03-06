
package States;

import UnitClasses.HealthBar;
import UnitClasses.Unit;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class Launcher extends StateBasedGame {
    
    public static int gold=500;
    public static boolean isinstuctions=false;
    public static ArrayList<Unit> units = new ArrayList();
    public static ArrayList<HealthBar> heath = new ArrayList();
    public static int level = 1;

    public Launcher(String title) {
        super(title);
    }
    
    public void initStatesList(GameContainer gc) throws SlickException {
        this.addState(new StartScreen());
        this.addState(new Instuctions());
        this.addState(new Shop());
        this.addState(new Instuctions2());
        this.addState(new Level1());
        this.addState(new Level2());
        this.addState(new Level3());
         this.addState(new Level4());
        this.addState(new LoserState());
        this.addState(new Youwon());
        
       
    }

    public static void main(String args[]) throws SlickException {
        Launcher game = new Launcher("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(1240, 720, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}
