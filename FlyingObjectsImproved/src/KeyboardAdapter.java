import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class KeyboardAdapter extends KeyAdapter {
	public void keyReleased(KeyEvent e) {
    	ControlledObject.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
    	ControlledObject.keyPressed(e);
    }

}