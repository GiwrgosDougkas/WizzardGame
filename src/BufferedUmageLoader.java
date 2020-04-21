import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedUmageLoader {
	private static BufferedImage image;
	
	public static BufferedImage loadImage(String x) {
		try {
			image= ImageIO.read(new File(x));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
}
