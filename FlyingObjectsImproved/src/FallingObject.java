import java.awt.*;
import java.util.Random;

//Should this class create x amount of random objects?

public class FallingObject extends SpaceObjectDecorator {
	/**
	 * Simple space objects can be represented by a single polygon.
	 */
	
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
		super.collide(obj);
		
	}

	@Override
	public void move(int x, int y ) {
		Random randNum = new Random();
		int randY = randNum.nextInt(y);
		int randX = randNum.nextInt(x);
		super.move(randX, randY);
		//System.out.println("Falling Object");
	}

	@Override
	public Polygon getPoly() {
		// TODO Auto-generated method stub
		return decoratedObject.getPoly();
	}	
}
