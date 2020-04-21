import java.awt.Graphics;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Handler {
	private boolean up=false,down=false,left=false,right=false,mouse=false;
	private String direction="down";
	
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}
	
	public String direction() {
		return this.direction;
	}
	public void setDirection(String t) {
		this.direction=t;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}
	private List<GameObject> objects=new  CopyOnWriteArrayList<>();
	
	public void addObject(GameObject o) {
		objects.add(o);
		
	}
	
	public void deleteObject(GameObject o) {
		objects.remove(o);
	}
	
	public void clearList() {
		objects.clear();
	}
	
	public void tick() {
		for(GameObject obj : objects) {
			obj.tick();
		}
	}
	
	public void render(Graphics g) {
		for(GameObject obj:objects) {
			obj.render(g);
		}
	}
	public List<GameObject> getList(){
		return this.objects;		
	}
	public boolean mouseIsPressed() {
		return mouse;
	}
	
	public void setMouse(boolean m) {
		this.mouse=m;
	}
}
