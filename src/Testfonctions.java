import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Testfonctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		    File pathToFile = new File("Photos/lucane.jpg");
		    Image img = ImageIO.read(pathToFile);
		    Images image = new Images(img);
		    image.addPersonne("Maxime Gresse");
		    image.addPersonne("Léo");
		    System.out.println(image.personnes);
		    System.out.println(image.couleur);
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}

}
