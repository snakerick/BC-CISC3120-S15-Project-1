import java.awt.Graphics;

/**
 * The simplest way to make a "concrete" SpaceObject--using the Polygon class to provide most of the behavior
 * @author sdexter72
 *
 */

public class SimpleSpaceObject implements SpaceObject {
	
	/**
	 * Simple space objects can be represented by a single polygon.
	 */
	protected Polygon shape;
	private Point [] temp;
	protected Polygon tempShape;
	
	/**
	 * The only constructor, hooks up with Polygon constructor
	 * @param inShape an array of Points specifying the shape of the Polygon (see Polygon docs)
	 * @param inOffset initial position of the Polygon in space
	 * @param inRotation initial rotation of the Polygon
	 */
	public SimpleSpaceObject(Point[] inShape, Point inOffset, double inRotation) {
		shape = new Polygon(inShape, inOffset, inRotation);
	}
	
	@Override
	public void paint(Graphics g) {
		shape.paint(g);
	}

	@Override
	public void collide(SpaceObject obj) {
		tempShape = obj.getPoly();
		temp = tempShape.getPoints();
		for(int i = 0; i < temp.length ; i++ ) {
			if(shape.contains(temp[i])) {
				System.out.println("Object Collided");
				Point[] test = { new Point(0,0), new Point(0,0), new Point(0,0) };
				shape = new Polygon(test); 
			}
		}
	}
	

	@Override
	public void move(int x, int y) {
		shape.move(x,y);
	}

	@Override
	public void rotate(double r) {
		shape.rotate(r);
	}

	@Override
	public Polygon getPoly() {
		return shape;
	}

}
