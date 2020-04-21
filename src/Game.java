import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.List;

public class Game extends Canvas implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH=1000,HEIGHT=523;
	public static final String TITLE="Wizzard";
	private Thread thread;
	public  static Handler handler;
	private boolean isRunning=false;
	private BufferedImage  sprite_sheet=null;
	private BufferedImage wizzard_sheet=null;
	private BufferedImage ground=null;
	private SpriteSheet ss=null;
	private static Camera camera;
	public int ammo=100;
	public Game() {
		new Window(this);
		this.start();
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput(handler,camera,this));
		BufferedUmageLoader loader=new BufferedUmageLoader();
		sprite_sheet=loader.loadImage("field1.png");
		wizzard_sheet=loader.loadImage("down_hit.png");
		ground=loader.loadImage("ground.png");
		ss=new SpriteSheet(wizzard_sheet);
		this.loadLevel(sprite_sheet);
		
	}
	
	public static void main(String[] args) {
		handler= new Handler();
		camera= new Camera(0,0,handler);
		new Game();
				
	}
	
	public synchronized void start() {
		
		
		thread=new Thread(this);
			
		thread.start();
		isRunning=true;
	}
	
		
	
	public synchronized void stop() {
		
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isRunning=false;
	}
	
	public void tick() {
		camera.tick();
		handler.tick();
		
	}
	
	public void render() {
		BufferStrategy bs= this.getBufferStrategy();
		
		if(bs==null) {
			this.createBufferStrategy(3);
			this.requestFocus();
			return;
		}
		
		Graphics g= bs.getDrawGraphics();
		Graphics2D g2d=(Graphics2D)g;
		
		
		
		
		g2d.translate(-camera.getX(),- camera.getY());
		
		for(int xx=0;xx<30*72; xx+=32) {
			for(int yy=0; yy<30*72; yy+=32) {
				g.drawImage(ground, xx, yy, null);
			}
		}
		
			
		
		handler.render(g);
		g2d.translate(camera.getX(), camera.getY());
		g.setColor(Color.white);
		g.drawString("Ammo:"+this.ammo, 10, 50);
		g.dispose();
		bs.show();
		
	}
	
	private void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();

		for(int xx =0; xx<w; xx++){
		for(int yy = 0; yy<h; yy++){
		int pixel = image.getRGB(xx,yy);
		int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
		int blue = (pixel ) & 0xff;

		if(red == 255)
			handler.addObject(new Block(xx*32, yy*32));
		if(blue == 255 && green==0)
			handler.addObject(new Wizard(xx*16, yy*16, handler,ss));
		
		if(green==255 &&blue==0)
			handler.addObject(new Enemy(xx*32, yy*32, handler));
		
		if(green==255 && blue==255 && red==128)
			handler.addObject(new Crate(xx*32, yy*32, handler));
		}
		
		}
	}
	
	@Override
	public void run() {
	long lastTime=System.nanoTime();
	double amountOfTickes=60.0;
	double ns= 1000000000/amountOfTickes;
	double delta=0;
	long timer=System.currentTimeMillis();
	int frames=0;
	
	while(isRunning) {
		long now=System.nanoTime();
		delta+=(now-lastTime)/ns;
		lastTime=now;
			while(delta>=1) {
				tick();
				delta--;
			}
		if(isRunning) {
			render();
			frames++;
		}
		
		if(System.currentTimeMillis()-timer>1000) {
			timer+=1000;
			System.out.println("FPS: "+frames);
			frames=0;
		}
		
	}
	this.stop();
}

}
