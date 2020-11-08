
package ButtonClasses;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.*;


abstract public class Button {
    protected Image image;
    protected Shape box;
    protected String name, type;
    protected Rectangle hitbox;
    protected Rectangle buttonshape;
    protected    int x, y;
    public Button(Image i, String name, int x, int y){
        image  =i;
        hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
        type = "Image";
    }
    public Button(Shape i, String name,String content,int x, int y, int l, int w){
        box = new Rectangle(x, y, w, l);
        hitbox = new Rectangle(x, y, w, l);
        type = "Shape";
       
    }
    abstract public void function();
        
    public void hit (int x, int y, Shape h, Input in)
    {if (h.contains(x,y) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {function();
            
        
    }}
    public void draw(){
        if(type.equals("Image")){
        image.draw(hitbox.getX(), hitbox.getY());}
        if(type.equals("Shape")){
        box.draw(hitbox.getX(), hitbox.getY());}}
    
    
}
