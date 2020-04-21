import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	private Handler handler;
	public KeyInput(Handler h) {
		this.handler=h;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		for(GameObject obj : handler.getList()) {
			if(obj.id.equals(ID.Player)) {
				
				if(key==KeyEvent.VK_W) {
					handler.setUp(true);
					handler.setDirection("up");
				}
				if(key==KeyEvent.VK_S) { 
					handler.setDown(true);
					handler.setDirection("down");
				}
				if(key==KeyEvent.VK_A) {
					handler.setLeft(true);
					handler.setDirection("left");
				}
				if(key==KeyEvent.VK_D) {
					handler.setRight(true);
					handler.setDirection("right");
				}
			}
			
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		for(GameObject obj : handler.getList()) {
			int key=e.getKeyCode();
			if(obj.id.equals(ID.Player)) {
				
				if(key==KeyEvent.VK_W) handler.setUp(false);
				if(key==KeyEvent.VK_S) handler.setDown(false);
				if(key==KeyEvent.VK_A) handler.setLeft(false);
				if(key==KeyEvent.VK_D) handler.setRight(false);
			}
			
		}
	}
}
