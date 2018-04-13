import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import javax.imageio.ImageIO;

public abstract class Modele extends Observable{
	
	public ArrayList<Images> images;
	public Dico dico;
	
	int indexImageSelectionnée=0;
	
	public Modele() {}
	
	public void chargerDonnées(String dir) {
		
		File repImages = new File(dir);
		File[] imagesListe = repImages.listFiles();
		this.images = new ArrayList<>();
		for (File file : imagesListe) {
			try {
				Image img = ImageIO.read(file);
				Images img_att=new Images(img);
				this.images.add(img_att);
				
				String dimension = img_att.resolution;
				if (!this.dico.containsKey(dimension))
					this.dico.put(dimension, new ArrayList<Images>());
				this.dico.get(dimension).add(img_att);
				
				Color coulmoy = img_att.couleur;
				if (!this.dico.containsKey(coulmoy))
					this.dico.put(coulmoy.toString(), new ArrayList<Images>());
				this.dico.get(coulmoy).add(img_att);
				
				String nom = file.getName();
				int index=0;
				while(nom.charAt(index)!='.'){
					index+=1;
				}
				String nom2 = nom.substring(0,index);
				if (!this.dico.containsKey(nom2))
					this.dico.put(nom2.toString(), new ArrayList<Images>());
				this.dico.get(nom2).add(img_att);
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
	
	
	
	public abstract void enregistrement();
	

}
