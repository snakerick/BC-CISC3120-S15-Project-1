import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * A very simple example of how to use the Game base class.
 * 
 * Here, we provide a constructor for our game, override the JPanel
 * paintComponent() method, and write a simple main() method that creates and
 * starts the game.
 * 
 * @author sdexter72
 *
 */
public class SimpleGame extends Game {

	/**
	 * The lone 'object' in our simple game.
	 */
	SimpleSpaceObject ship;
	FallingObject test4;
	ControlledObject controlShip;
	SpaceObject dec, obj, object;
	
	//Used to create more then one object at once
	protected static FallingObject []  fObjects;
	
	//Max amount of Objects and Level
	protected static int MAX_OBJECTS = 10;
	protected static int LEVELS = 15;
	
	//The max length of X
	protected static int MAX_X = 400;
	protected Random randNum = new Random();


	/**
	 * This constructor invokes the super constructor, then creates a ship
	 * object (which doesn't do very much)
	 * 
	 * @param name
	 * @param inWidth
	 * @param inHeight
	 */

	public SimpleGame(String name, int inWidth, int inHeight) {
		super(name, inWidth, inHeight);
		setBackground(Color.BLACK);
		addKeyListener(new KeyboardAdapter() );
		Point[] shipShape = { new Point(210, 100), new Point(190, 90),
				new Point(200, 100), new Point(190, 110) };
		ship = new SimpleSpaceObject(shipShape, new Point(200, 800), -90);
		controlShip = new ControlledObject(ship);
		Point[] testObj = { new Point(), new Point(), new Point(), new Point(), new Point() };
		object = new SimpleSpaceObject(testObj,new Point(50,50),-90);
		test4 = new FallingObject(object);
	}

	/**
	 * Draw the ship in white.
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		controlShip.paint(g);
		controlShip.move();
		test4.paint(g);
		test4.move(0, 1);
		ship.collide(object);
	}

	public void createGameObjects() {
		createFallingObjects(MAX_OBJECTS);
	}
	
	
	public void createFallingObjects(int objSize) {
		fObjects = new FallingObject[objSize];
		int randX;
		for(int i = 0 ; i < objSize ; i++) {
			randX = randNum.nextInt(MAX_X);
			Point[] testObj = { new Point(), new Point(), new Point(), new Point(), new Point(), new Point() };
			object = new SimpleSpaceObject(testObj,new Point(randX,50),-90);
			fObjects[i] = new FallingObject(object);
		}
		//Increase the level
		LEVELS = LEVELS + 1;
	}

	/**
	 * In main, we create a new SimpleGame, make sure it has the keyboard focus
	 * (which it will need when we implement code to control game action with
	 * keyboard), and start the game.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		SimpleGame game = new SimpleGame("Simple Game", 400, 900);
		game.requestFocus();
		game.startGame();
	}

}
