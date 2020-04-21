import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Box extends GameObject {

	public Box(int x, int y) {
		super(x, y, ID.Block);
		
	}

	@Override
	public void tick() {
		x+=1;
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 230, 230);
		
	}

	@Override
	public Rectangle getBounds() {
		
		return null;
	}

}
