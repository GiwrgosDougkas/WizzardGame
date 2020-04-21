import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	private Game game;
	private Handler handler;
	private Camera camera;
	public MouseInput(Handler handler,Camera camera,Game game) {
		this.handler=handler;
		this.camera=camera;
		this.game=game;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int mx= (int) (e.getX()+camera.getX());
		int my= (int) (e.getY()+camera.getY());
		handler.setMouse(true);
		for(GameObject object:handler.getList()) {
			if(object.id.equals(ID.Player)&& game.ammo>=1) {
				
				handler.addObject(new Bullet(object.getX()+16,object.getY()+24,handler,mx,my));
				game.ammo--;
			}
		}
	}
	
}
