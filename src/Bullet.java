import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends GameObject{
	private Handler handler;
	private double length;
	private BufferedImage image;
	public Bullet(int x, int y,Handler h,int mx, int my) {
		super(x, y,ID.Bullet);
		this.handler=h;
		length=Math.sqrt((mx*mx) +(my*my));
		velX=(mx-x)/10;
		velY=(my-y)/10;
				
	}

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		
		for(GameObject object :handler.getList()) {
			if(object.id.equals(ID.Block)) {
				if(object.getBounds().intersects(this.getBounds())) {
					handler.deleteObject(this);
				}
				
			}
		}
		
		
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x, y, 8, 8);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,8,8);
	}

}
