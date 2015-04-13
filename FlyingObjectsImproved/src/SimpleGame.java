import java.awt.Color;
import java.awt.Graphics;

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
	FallingObject test;


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

		Point[] shipShape = { new Point(210, 100), new Point(190, 90),
				new Point(200, 100), new Point(190, 110) };

		ship = new SimpleSpaceObject(shipShape, new Point(200, 650), -90);
		
		//Test to see if we can make a random point.
		//Should FallingObjects spawn in random location?
		//Should FallingObjects move at random location?
		//How many side should the falling objects have?
		Point[] testObj = { new Point(), new Point(), new Point(), new Point() };
		test = new FallingObject(testObj, new Point(100,200), -90);
	}

	/**
	 * Draw the ship in white.
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		ship.paint(g);
		test.paint(g);
		test.move();
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
