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
	ControlledObject controlShip;
	SpaceObject object;
	SpaceObject[] gameObjects;

	// Variables needed for game to keep track of game
	protected static int MAX_OBJECTS = 4;
	protected static int LEVELS = 5;
	protected static int SCORE = 0;
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
		addKeyListener(new KeyboardAdapter());
		Point[] shipShape = { new Point(210, 100), new Point(190, 90),
				new Point(200, 100), new Point(190, 110) };
		ship = new SimpleSpaceObject(shipShape, new Point(200, 300), -90);
		controlShip = new ControlledObject(ship);
		createObjects(MAX_OBJECTS);
	}

	/**
	 * Draw the ship in white.
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawString("SCORE: ", 25, 25);
		g.drawString(Integer.toString(SCORE), 80, 25);
		controlShip.paint(g);

		// !! the ship and objects should animate themselves in their paint()
		// methods; they shoudln't have to be told what to do! at most, what you
		// should right here is tell everything you want painted to paint
		// themselves, then ask the ship if it's still 'alive'

		controlShip.move();
		for (int i = 0; i < gameObjects.length; i++) {
			gameObjects[i].paint(g);
			gameObjects[i].move(LEVELS, LEVELS);
			gameObjects[i].rotate(LEVELS);
			ship.collide(gameObjects[i]);

			// !! this is particularly hard to read -- why does this mean the
			// game should be over?

			if (ship.getPoly().findArea() == 0) {
				g.drawString("Game Over", 150, 200);
			} else {
				SCORE++;
				g.drawString(Integer.toString(SCORE), 80, 25);
			}
		}
	}

	public void createObjects(int objSize) {
		gameObjects = new SpaceObject[objSize];
		for (int i = 0; i < gameObjects.length; i++) {
			int randX = randNum.nextInt(MAX_X);
			Point[] testObj = { new Point(), new Point(), new Point(),
					new Point(), new Point() };
			object = new SimpleSpaceObject(testObj, new Point(randX, 50), -90);
			gameObjects[i] = new FallingObject(new SpinningObject(object));
		}
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
