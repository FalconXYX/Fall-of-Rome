package States;

import ButtonClasses.*;
import UnitClasses.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
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

public class Level2 extends BasicGameState {

    Input in;
    Unit enemyarcher, enemyswordsman, enemyspearman;
    ArrayList<Unit> enemyunits;
    Image goldimg, back;
    int timer;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        timer = 0;
        Launcher.isinstuctions = true;
        back = new Image("src/Images/HillsWithVila.png");
        goldimg = new Image("src/Images/Money.png");
        
        enemyunits = new ArrayList<Unit>();
        enemyunits.add(new Spearman("n", 1));
        enemyunits.add(new Spearman("n", 1));
        enemyunits.add(new Archer("n", 2));
        enemyunits.add(new Spearman("n", 1));
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
                
                
                Unit targeted = enemyunits.get(u.gettarget());
                if (targeted != null) {

                    targeted.takedamage(u.dodamage(targeted));
                    u.takedamage(targeted.defensedamage(u));

                }

            }
        }
        for (Unit u : enemyunits) {
            if (u != null) {
                
                Unit targeted = Launcher.units.get(u.gettarget());
                if (targeted != null) {

                    targeted.takedamage(u.dodamage(targeted));
                    u.takedamage(targeted.defensedamage(u));

                }

            }

        }
        
        for (Unit u : Launcher.units) {
            if (u != null) {
            if (u.gethealth() <= 0) {
                    Launcher.units.set(Launcher.units.indexOf(u), null);
                }}
            
        }
        for (Unit u : enemyunits) {
            if (u != null) {
            if (u.gethealth() <= 0) {
                    enemyunits.set(enemyunits.indexOf(u), null);
                    Launcher.gold+=50;
                }}
            
        }
    }
    public void move(Input in) {
       if (in.isKeyDown(Input.KEY_M) ) {
           int countclicked = 0;
           ArrayList<Integer> thing;
           thing = new ArrayList();
                   
                   
                   
           boolean hit[] = new boolean[5];
           for (int i = 0; i < 5; i++) {
               hit[i] = false;
           }
           if (in.isKeyDown(Input.KEY_1)) {
               hit[0] = true;
               countclicked++;
           }
           if (in.isKeyDown(Input.KEY_2)) {
               hit[1] = true;
               countclicked++;
           }
           if (in.isKeyDown(Input.KEY_3)) {
               hit[2] = true;
               countclicked++;
           }
           if (in.isKeyDown(Input.KEY_4)) {
               hit[3] = true;
               countclicked++;
           }
           if (in.isKeyDown(Input.KEY_5)) {
               hit[4] = true;
               countclicked++;
           }
           if(countclicked == 2){
               for (int i = 0; i < 5; i++) {
                   if (hit[i]) {
                       thing.add(i);
                       
                   }
                   
               }
               if (thing.get(0) != thing.get(1)) {
                   
                   swap(Launcher.units.get(thing.get(0)),thing.get(0),thing.get(1),Launcher.units.get(thing.get(1)));
                   return;
               }
                
           }

    }}
    public void swap(Unit u,int a, int b, Unit c){
        Unit temp1 = u;
        Unit temp2 = c;
        Launcher.units.set(b, u);
        Launcher.units.set(a, c);
        
        
    
    
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
            int original = current.gettarget();
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
            if(current.gettarget() <0 || current.gettarget() >4){   
                current.settarget(original);
                
                return;}
        }
        if (in.isKeyDown(Input.KEY_2) && Launcher.units.get(1) != null) {

            current = Launcher.units.get(1);
            int original = current.gettarget();
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
            if(current.gettarget() <0 || current.gettarget() >4){   
                current.settarget(original);
                
                return;}
        }
        if (in.isKeyDown(Input.KEY_3) && Launcher.units.get(2) != null) {
            current = Launcher.units.get(2);
            int original = current.gettarget();
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
            if(current.gettarget() <0 || current.gettarget() >4){   
                current.settarget(original);
                
                return;}
        }
        if (in.isKeyDown(Input.KEY_4) && Launcher.units.get(3) != null) {
            current = Launcher.units.get(3);
            int original = current.gettarget();
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
            if(current.gettarget() <0 || current.gettarget() >4){   
                current.settarget(original);
                
                return;}
        }
        if (in.isKeyDown(Input.KEY_5) && Launcher.units.get(4) != null) {
            current = Launcher.units.get(4);
            int original = current.gettarget();
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
            if(current.gettarget() <0 || current.gettarget() >4){   
                current.settarget(original);
                
                return;}
        }

    }
    public void death(StateBasedGame sbg){
        int dead = 0;
        //if you have lost all units go to death screen
        for (Unit u:Launcher.units) {
            if (u==null) {dead++;
                
            }
        }
        if (dead==5) {
             sbg.enterState(10, new FadeOutTransition(), new FadeInTransition());
        }
         //if you have killed all units go to next screen
        dead = 0;
        for (Unit u:enemyunits) {
            if (u==null) {dead++;
                
            }
        }
       
        if (dead==5) {
            Launcher.level++;
            Launcher.gold+=150;
            for (Unit u:Launcher.units) {
                if(u != null){
                u.heal();
            }else{
                    Launcher.units.remove(u);
                    break;
                
                
                }
            
            }
             sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
        }
    
    }
    

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        timer++;
        
        if (timer == 5) {
            for (Unit u:Launcher.units) {
                if(u != null){
                    System.out.println("Healed");
                u.heal();
            }}
        }
        
        Input in = gc.getInput();
        int mx = in.getMouseX();
        int my = in.getMouseY();
        TargetUpgrade(in);
        death(sbg);
        if (timer % 20 == 0) {
             move(in);

        }
        
        if (timer % 200 == 0) {

            attacks();

        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        for (Unit u : Launcher.units) {
            if (u != null) {
                u.setrankimg();                
            }
        }
        for (Unit u : enemyunits) {
            if (u != null) {
                u.setrankimg();                
            }
        }
        back.draw(0, 1);
        goldimg.draw(80, 13);
        g.setColor(Color.white);
        g.drawString("" + Launcher.gold, 35, 13);
        for (int i = 0; i < Launcher.units.size(); i++) {
            Unit u = Launcher.units.get(i);
            if (u != null) {
                u.setx((i * 200) + 120);
                u.sety(430);
                u.draw(g);
                g.setColor(Color.white);
                
            }

        }
        for (int i = 0; i < 5; i++) {
            Unit u = enemyunits.get(i);
            if (u != null) {
                g.setColor(Color.white);
                
                u.setx((i * 200) + 120);
                u.sety(190);
                u.draw(g);
            }

        }
        for (Unit u : enemyunits) {
            if (u != null) {
               
                u.calc();
            
            }}
        for (Unit u : Launcher.units) {
            if (u != null) {
                u.calc();
            
            }}
    }

    public int getID() {
        return 5;  //this id will be different for each screen
    }

}
