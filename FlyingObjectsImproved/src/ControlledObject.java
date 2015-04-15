import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JPanel;


//This should control the object
public class ControlledObject extends JPanel implements SpaceObject {
	static int a,b;
	Polygon object;
	public ControlledObject(Point[] inShape, Point inOffset, double inRotation) {
		object = new Polygon(inShape, inOffset, inRotation);

	}
	@Override
	public void paint(Graphics g) {
		object.paint(g);
	}

	@Override
	public void rotate(double r) {
		// TODO Auto-generated method stub

	}

	public void move() {
		object.move(a,b);
	}
	
	@Override
	public void collide(SpaceObject obj) {
		// TODO Auto-generated method stub

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

    public static void keyPressed(KeyEvent e) {
    	/*if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
    		System.out.println("Right Released");
    	}
    	if(e.getKeyCode() == KeyEvent.VK_LEFT) {
    		System.out.println("Left Released");
    	} */
    }
}
