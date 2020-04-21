import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Window(Game game) {
		
		this.add(game);
		this.setVisible(true);
		this.setResizable(false);
		this.setPreferredSize(new Dimension(Game.WIDTH,Game.HEIGHT));
		this.setMaximumSize(new Dimension(Game.WIDTH,Game.HEIGHT));
		this.setMinimumSize(new Dimension(Game.WIDTH,Game.HEIGHT));
		this.setLocationRelativeTo(null);
		this.setTitle(Game.TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
