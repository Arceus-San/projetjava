
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
		this.dico = new Dico();
		System.out.println("Charger données Modele");
		for (File file : imagesListe) {
			if(file.getName().contains(".jpg") || file.getName().contains(".png") || file.getName().contains(".jpeg")){
			try {
				Image img = ImageIO.read(file);
				Images img_att=new Images(img);
				this.images.add(img_att);


				String nom = file.getName();
				int index=0;
				while(nom.charAt(index)!='.'){
					index+=1;
				}
				String nom2 = nom.substring(0,index);
				img_att.nomimg = nom2;
				if (!this.dico.containsKey(nom2))
					this.dico.put(nom2.toString(), new ArrayList<Images>());
				this.dico.get(nom2).add(img_att);

				img_att.complete();

				String dimension = img_att.resolution;
				if (!this.dico.containsKey(dimension))
					this.dico.put(dimension, new ArrayList<Images>());
				this.dico.get(dimension).add(img_att);


			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		}
	}


	public Images recupimg(String s) throws ExceptionImgNotExist{
		for(int i=0;i<this.images.size();i++){
			if(this.images.get(i).nomimg.contains(s)){
				return this.images.get(i);
			}
		}throw new ExceptionImgNotExist();
	}


	public abstract void enregistrement();


}
