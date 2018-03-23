import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Testfonctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		    File pathToFile = new File("src/espace.jpg");
		    Image img = ImageIO.read(pathToFile);
		    Images image = new Images(img,Color.BLACK,"1920x1080","");
		    image.addPersonne("Maxime Gresse");
		    image.addPersonne("Léo");
		    System.out.println(image.personnes);
		    System.out.println(image.estPresent(""));
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}

}
