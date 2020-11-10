package ButtonClasses;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.*;

abstract public class Button {

    protected Image image;
    protected Graphics g;
    protected Shape box;
    protected String name, type;
    public Rectangle hitbox;
    protected Rectangle buttonshape;
    protected int x, y, w, l;

    public Button(Image i, String name, int x, int y) {
        this.name = name;
        image = i;
        hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
        type = "Image";
    }

    public Button(String name, int x, int y, int length, int width) {
        this.name = name;
        hitbox = new Rectangle(x, y, w, l);
        type = "Shape";
        w = width;
        l = length;

    }

   

    public boolean hit(int x, int y, Input in) {
        if (hitbox.contains(x, y) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            
            return true;
        } else {
            return false;
        }

    }

    public void draw(Graphics g) {
        if (type.equals("Image")) {
            image.draw(hitbox.getX(), hitbox.getY());
        }
        if (type.equals("Shape")) {
            g.setColor(Color.red);
            g.fill(hitbox);
            g.setColor(Color.white);
            g.drawString(name, w + 10, l + 10);
        }

    }
}
