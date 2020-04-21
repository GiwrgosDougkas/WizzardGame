import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends GameObject{
	private Random random=new Random();
	private int choose=0;
	private int counter=0;
	private Handler handler;
	private BufferedImage tnt;
	public Enemy(int x, int y, Handler handler) {
		super(x, y, ID.Enemy);
		this.handler=handler;
		tnt=BufferedUmageLoader.loadImage("tnt.png");
	}

	@Override
	public void tick() {
		/*x+=velX;
		y+=velY;
		for(GameObject obj: handler.getList()) {
			if(obj.id.equals(ID.Block)) {
				if(obj.getBounds().intersects(this.getBounds())) {
					x+=velX*-1;
					y+=velY*-1;
				}
				
			}
			
		}
		choose=random.nextInt(10);
		if(choose==0) {
			velX=(random.nextInt(4- -4)+-4);
			velY=(random.nextInt(4- -4)+-4);
		}*/
		for(GameObject obj: handler.getList()) {
			if(obj.id.equals(ID.Bullet)) {
				if(obj.getBounds().intersects(this.getBounds())) {
					if(counter==1) {
					handler.deleteObject(this);
					}
					handler.deleteObject(obj);
					counter++;
				}
				
			}
			
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(tnt, x, y,50, 50,null);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,50,50);
	}

}
