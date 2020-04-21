
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {
	 
	 private BufferedImage[] images;
	 private int interval, index,index1;
	 private long timer, now, lastTime;
	 private Handler handler;
	 public Animation(BufferedImage[] images, int interval, Handler handler) {
	  this.images = images;
	  this.interval = interval;
	  this.handler=handler;
	  index = 0;
	  index1=0;
	  timer = 0;
	  now = 0;
	  lastTime = System.currentTimeMillis();
	 }
	 public void tick(){
	  now = System.currentTimeMillis();
	  timer += now - lastTime;
	  lastTime = now;
	  
	  if(timer >= interval){
	   index++;
	   index1++;
	   timer = 0;
	   
	   
	   if(index >= images.length)
	    index = 0;
	   
	  }
	  if(index1>=6) {
			 handler.setMouse(false);
			 index1=0;
		 }
	  
	 }
	 public void render(Graphics g, int x, int y, int width, int height){
		 
		 g.drawImage(images[index], x, y, width, height, null);
		 
	 }
	}