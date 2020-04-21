import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class GameObject {
	protected int x,y;
	protected double velX,velY;
	protected ID id;
	protected BufferedImage imagup=null;
	protected BufferedImage[] imagleft=null;
	protected BufferedImage[] imagright=null;
	protected BufferedImage[] imagdown=null;
	protected BufferedImage[] imagdownhit=null;
	public GameObject(int x,int y, ID id) {
		this.x=x;
		this.y=y;
		this.id=id;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y=y;
	}

	public int getY() {
		return this.y;
	}
	
	public void setVelX(int velX) {
		this.velX=velX;
	}
	
	public double getVelX() {
		return this.velX;
	}
	
	public void setVelY(int velY) {
		this.velY=velY;		
	}
	
	public double getVelY() {
		return this.velY;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
}
