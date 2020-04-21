import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Crate extends GameObject
{
	private Handler handler;
	private BufferedImage image;
	public Crate(int x, int y,Handler handler) {
		super(x, y, ID.Crate);
		this.handler=handler;
		image=BufferedUmageLoader.loadImage("hospital.png");
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, x,y,100,100,null);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,100,100);
	}

}
