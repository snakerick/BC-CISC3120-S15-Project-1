import java.awt.*;
import java.util.Random;

//Should this class create x amount of random objects?

public class FallingObject extends SpaceObjectDecorator implements SpaceObject{

	/**
	 * Simple space objects can be represented by a single polygon.
	 */
	protected Polygon shape;
	protected int MAX_SPEED = 5;
	
	/**
	 * The only constructor, hooks up with Polygon constructor
	 * @param inShape an array of Points specifying the shape of the Polygon (see Polygon docs)
	 * @param inOffset initial position of the Polygon in space
	 * @param inRotation initial rotation of the Polygon
	 */
	
	
	public FallingObject(SpaceObject decoratedObject) {
		super(decoratedObject);
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	@Override
	public void collide(SpaceObject obj) {
		// you may need to fill this in...
	}

	//Should Falling Objects Move be random? How should it affect as teh game progress?
	//The random seems ot be flickering? How come?
	/*public void move() {
		Random rand = new Random();
		int randx = rand.nextInt(MAX_SPEED);
		int randy = rand.nextInt(MAX_SPEED);
		super.move(randx,randy);
	}*/
	
	//Should the speed increase as time goes on? How?
	@Override
	public void move(int x, int y) {
		super.move(x, y);
	}

	@Override
	public void rotate(double r) {
		super.rotate(r);
	}

}
