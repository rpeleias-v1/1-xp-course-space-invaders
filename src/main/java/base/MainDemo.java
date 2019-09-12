package base;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainDemo {
	
	public static void main(String[] args) throws IOException {
		Map<Character, BufferedImage> cacheBitmaps = new HashMap<Character, BufferedImage>();
		cacheBitmaps.put('1', ImageIO.read(new FileInputStream("i1.jpg")));
		cacheBitmaps.put('2', ImageIO.read(new FileInputStream("i2.jpg")));
		cacheBitmaps.put('3', ImageIO.read(new FileInputStream("i3.jpg")));
		LoopPrincipal loop = new LoopPrincipal(new JogoDemo(), cacheBitmaps);
		
		loop.start();
	}

}