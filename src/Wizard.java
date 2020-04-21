import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

public class Wizard extends GameObject{
	private Handler handler;
	private BufferedImage image=null;
	private BufferedImage[] images=new BufferedImage[4];
	private BufferedImage[] imagesWalk=new BufferedImage[2];
	private BufferedImage[] images_left=new BufferedImage[4];
	private BufferedImage[] imagesWalk_left=new BufferedImage[2];
	private Animation anim, anim_left;
	private Animation animWalk, animWalk_left;	
	private SpriteSheet s;
	private int sec=1;
	public Wizard(int x, int y,Handler h, SpriteSheet s) {
		super(x, y, ID.Player);
		this.handler=h;
		this.s=s;
		
		images[0]=s.grabImage(4, 1, 100, 127);
		images[1]=s.grabImage(1, 1, 100, 127);
		images[2]=s.grabImage(2, 1, 100, 127);
		images[3]=s.grabImage(3, 1, 100, 127);
		
		imagesWalk[0]=s.grabImage(4, 1, 100, 127);
		imagesWalk[1]=s.grabImage(5, 1, 100, 127);
		
		images_left[0]=s.grabImage(4, 2, 100, 127);
		images_left[1]=s.grabImage(1, 2, 100, 127);
		images_left[2]=s.grabImage(2, 2, 100, 127);
		images_left[3]=s.grabImage(3, 2, 100, 127);
		
		imagesWalk_left[0]=s.grabImage(4, 2, 100, 127);
		imagesWalk_left[1]=s.grabImage(5, 2, 100, 127);
		
		anim=new Animation(images,200,handler);
		animWalk=new Animation(imagesWalk,200,handler);
		
		anim_left=new Animation(images_left,200,handler);
		animWalk_left=new Animation(imagesWalk_left,200,handler);
		
		
	}
	
	

	@Override
	public void tick() {
		
		x+=velX;
		y+=velY;
		
		collision();
		
		if(handler.isDown()) {
			this.setVelY(2);
			
			if(handler.mouseIsPressed()) {
				
				
			}
			
		}
		else if(!handler.isUp()) {
			this.setVelY(0);
			
		}
		
		if(handler.isUp()) {
			this.setVelY(-2);
			
		}
		else if(!handler.isDown()) {			
			this.setVelY(0);
			
		}
		
		if(handler.isRight()) {	
			this.setVelX(2);
			
		}
		else if(!handler.isLeft()) {
			this.setVelX(0);
			
			
		}
		
		if(handler.isLeft()) {
			this.setVelX(-2);
			
		}
		else if(!handler.isRight()) {
			this.setVelX(0);
			
		}
		
		animWalk.tick();

		anim.tick();
		
	}
	
	public void collision() {
		for(GameObject obj: handler.getList()) {
			if(obj.id.equals(ID.Block)) {
				if(obj.getBounds().intersects(this.getBounds())) {
					x+=-velX;
					y+=-velY;
				}
			}
		}
	}
	
	@Override
	public void render(Graphics g) {	
		
		if( velY==0 && handler.direction().equals("down") ) {
			g.drawImage(images[0], x, y, 50, 50, null);		
			
		}	
		if(handler.direction().equals("left") && velX==0 && velY==0) {
			g.drawImage(images_left[0], x, y, 50, 50, null);
		}
		if(handler.direction().equals("down") && velY>0) {
			animWalk.render(g, x, y, 50, 50);
		}
		
		 if(handler.direction().equals("left") &&velX<0) {
			animWalk_left.render(g, x, y, 50, 50);
		}
		
		if(handler.mouseIsPressed()) {
			if(handler.direction().equals("down")) {
				anim.render(g, x, y, 50, 50);
			
			}
			if(handler.direction().equals("left")) {
				anim_left.render(g, x, y, 50,50);
			}
		}
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,50,50);
	}

}
