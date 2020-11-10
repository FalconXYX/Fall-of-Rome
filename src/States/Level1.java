package States;

import ButtonClasses.*;
import UnitClasses.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.newdawn.slick.Color;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

public class Level1 extends BasicGameState {

    Input in;
    Unit enemyarcher, enemyswordsman, enemyspearman;
    ArrayList<Unit> enemyunits;
    Image goldimg;
    int timer;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        timer = 0;
        goldimg = new Image("src/Images/Money.png");
        //TEMP|
        Launcher.units.add(null);
        Launcher.units.add(new Swordsman("Name", 1));
        Launcher.units.add(new Archer("Name", 1));
        Launcher.units.add(new Spearman("Name", 1));
        Launcher.units.add(null);
        
        //TEMP^
        enemyunits = new ArrayList<Unit>();
        enemyunits.add(null);
        enemyunits.add(new Swordsman("Name", 1));
        enemyunits.add(new Archer("Name", 1));
        enemyunits.add(new Spearman("Name", 1));
        enemyunits.add(null);
        for (Unit u : enemyunits) {
            if (u != null) {
                u.settarget(enemyunits.indexOf(u));
            } 

        }
        for (Unit u : Launcher.units) {
            if (u != null) {
                u.settarget(Launcher.units.indexOf(u));
            } 

        }

    }

    public void attacks() {
        for (Unit u : Launcher.units) {
            
            if (u != null) {
                if (u.gethealth()<=0) {
                        Launcher.units.set(Launcher.units.indexOf(u),null);
                    }
                System.out.println(u.gettarget());
                Unit targeted = enemyunits.get(u.gettarget());
                if (targeted != null) {
                    
                    
                    targeted.takedamage(u.dodamage(targeted));
                    u.takedamage(targeted.defensedamage(u));
                    
                } else {
                    
                }

            } else {
                
            }

        }
        for (Unit u : enemyunits) {
            if (u != null) {
                if (u.gethealth()<=0) {
                        enemyunits.set(enemyunits.indexOf(u),null);                        
                    }
                Unit targeted = Launcher.units.get(u.gettarget());
                if (targeted != null) {
                    
                    
                    targeted.takedamage(u.dodamage(targeted));
                    u.takedamage(targeted.defensedamage(u));
                    
                } else {
                    
                }

            } else {
                
            }

        }
    }

    public void TargetUpgrade(Input in) {
        
       
        Unit current = null;
        if (in.isKeyDown(Input.KEY_1) && Launcher.units.get(0) != null) {
            
            current = Launcher.units.get(0);
            if (in.isKeyDown(Input.KEY_U)) {
                if (Launcher.gold >= current.getupgradecost()) {
                    Launcher.gold -= current.getupgradecost();
                    current.uprank();
                    
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                        return;
                    } catch (InterruptedException ex) {

                    }

                }
            }
            if (in.isKeyDown(Input.KEY_LEFT)) {
                try {
                    current.settarget(Launcher.units.indexOf(current) - 1);
                } catch (Exception e) {

                }
            }
            if (in.isKeyDown(Input.KEY_RIGHT)) {
                try {
                    current.settarget(Launcher.units.indexOf(current) + 1);
                } catch (Exception e) {
                }

            }
            if (in.isKeyDown(Input.KEY_UP)) {
                current.settarget(Launcher.units.indexOf(current));
            }
        }
        if (in.isKeyDown(Input.KEY_2) && Launcher.units.get(1) != null) {
           
            current = Launcher.units.get(1);
            if (in.isKeyDown(Input.KEY_U)) {
                if (Launcher.gold >= current.getupgradecost()) {
                    Launcher.gold -= current.getupgradecost();
                    current.uprank();
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                        return;
                    } catch (InterruptedException ex) {

                    }
                }
            }
            if (in.isKeyDown(Input.KEY_LEFT)) {
                try {
                    current.settarget(Launcher.units.indexOf(current) - 1);
                } catch (Exception e) {

                }
            }
            if (in.isKeyDown(Input.KEY_RIGHT)) {
                try {
                    current.settarget(Launcher.units.indexOf(current) + 1);
                } catch (Exception e) {
                }

            }
            if (in.isKeyDown(Input.KEY_UP)) {
                current.settarget(Launcher.units.indexOf(current));
            }
        }
        if (in.isKeyDown(Input.KEY_3) && Launcher.units.get(2) != null) {
            current = Launcher.units.get(2);
            if (in.isKeyDown(Input.KEY_U)) {
                if (Launcher.gold >= current.getupgradecost()) {
                    Launcher.gold -= current.getupgradecost();
                    current.uprank();
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                        return;
                    } catch (InterruptedException ex) {

                    }
                }
            }
            if (in.isKeyDown(Input.KEY_LEFT)) {
                try {
                    current.settarget(Launcher.units.indexOf(current) - 1);
                } catch (Exception e) {

                }
            }
            if (in.isKeyDown(Input.KEY_RIGHT)) {
                try {
                    current.settarget(Launcher.units.indexOf(current) + 1);
                } catch (Exception e) {
                }

            }
            if (in.isKeyDown(Input.KEY_UP)) {
                current.settarget(Launcher.units.indexOf(current));
            }
        }
        if (in.isKeyDown(Input.KEY_4) && Launcher.units.get(3) != null) {
            current = Launcher.units.get(3);
            if (in.isKeyDown(Input.KEY_U)) {
                if (Launcher.gold >= current.getupgradecost()) {
                    Launcher.gold -= current.getupgradecost();
                    current.uprank();
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                        return;
                    } catch (InterruptedException ex) {

                    }
                }
            }
            if (in.isKeyDown(Input.KEY_LEFT)) {
                try {
                    current.settarget(Launcher.units.indexOf(current) - 1);
                    return;
                } catch (Exception e) {

                }
            }
            if (in.isKeyDown(Input.KEY_RIGHT)) {
                try {
                    current.settarget(Launcher.units.indexOf(current) + 1);
                } catch (Exception e) {
                }

            }
            if (in.isKeyDown(Input.KEY_UP)) {
                current.settarget(Launcher.units.indexOf(current));
            }
        }
        if (in.isKeyDown(Input.KEY_5) && Launcher.units.get(4) != null) {
            current = Launcher.units.get(4);
            if (in.isKeyDown(Input.KEY_U)) {
                if (Launcher.gold >= current.getupgradecost()) {
                    Launcher.gold -= current.getupgradecost();
                    current.uprank();
                    try {
                        TimeUnit.MILLISECONDS.sleep(150);
                    } catch (InterruptedException ex) {

                    }
                }
            }
            if (in.isKeyDown(Input.KEY_LEFT)) {
                try {
                    current.settarget(Launcher.units.indexOf(current) - 1);
                } catch (Exception e) {

                }
            }
            if (in.isKeyDown(Input.KEY_RIGHT)) {
                try {
                    current.settarget(Launcher.units.indexOf(current) + 1);
                } catch (Exception e) {
                }

            }
            if (in.isKeyDown(Input.KEY_UP)) {
                current.settarget(Launcher.units.indexOf(current));
            }
        }

    }

    public void move() {
        //will do latter when not dead

    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        timer++;
        Input in = gc.getInput();
        int mx = in.getMouseX();
        int my = in.getMouseY();
        TargetUpgrade(in);
         
        
        if (timer % 200 == 0) {
            
            attacks();

        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.drawString(""+Launcher.gold, 35, 13);
        goldimg.draw(80, 13);
        for (int i = 0; i < 5; i++) {
            Unit u = Launcher.units.get(i);
            if (u != null) {
                u.setx((i*200)+120);
                u.sety(480);
                u.draw(g);
                g.setColor(Color.white);
                g.drawString(""+u.gethealth(), (i*200)+120, 700);
            }
            
        }
        for (int i = 0; i < 5; i++) {
            Unit u = enemyunits.get(i);
            if (u != null) {
                g.setColor(Color.white);
                g.drawString(""+u.gethealth(), (i*200)+120, 40);
                u.setx((i*200)+120);
                u.sety(160);
                u.draw(g);
            }
            
        }
    }

    public int getID() {
        return 3;  //this id will be different for each screen
    }

}
