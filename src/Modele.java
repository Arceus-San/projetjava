import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import javax.imageio.ImageIO;

public abstract class Modele extends Observable{
	
	public ArrayList<Images> images;
	
	int indexImageSelectionnée=0;
	
	public Modele() {}
	
	public void chargerDonnées(String dir) {
		
		File repImages = new File(dir);
		File[] imagesListe = repImages.listFiles();
		this.images = new ArrayList<>();
		for (File file : imagesListe) {
			try {
				Image img = ImageIO.read(file);
				this.images.add(new Images(img));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
	
	
	
	public abstract void enregistrement();
	

}
