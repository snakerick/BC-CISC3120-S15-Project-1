
public class SpinningObject extends SpaceObjectDecorator{

	public SpinningObject(SpaceObject decoratedObject) {
		super(decoratedObject);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void rotate(double d) {
		super.rotate(d);
		System.out.println("Spinning Object Rottating");
	}

	@Override
	public Polygon getPoly() {
		// TODO Auto-generated method stub
		return null;
	}

}
