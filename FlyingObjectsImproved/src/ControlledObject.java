import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JPanel;


//This should control the object
public class ControlledObject extends SpaceObjectDecorator {
	static int a,b;
	Polygon object;
	public ControlledObject(SpaceObject decoratedObject) {
		super(decoratedObject);

	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	public void move() {
		super.move(a,b);
	}
	
	@Override
	public void collide(SpaceObject obj) {

	}
	
	public static void keyReleased(KeyEvent e) {
    	if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
    		System.out.println("Right was Pressed");
    		a += 1;
    	}
    	if(e.getKeyCode() == KeyEvent.VK_LEFT) {
    		System.out.println("Left was Pressed");
    		a -= 1;
    	}
    }
	
    public static  void keyPressed(KeyEvent e) {
    	if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
    		System.out.println("Right Released");
    	}
    	if(e.getKeyCode() == KeyEvent.VK_LEFT) {
    		System.out.println("Left Released");
    	}
    }


	@Override
	public Polygon getPoly() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
