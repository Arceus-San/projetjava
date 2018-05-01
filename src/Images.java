import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Images implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public String nomimg;
	public Color couleur;
	public String resolution;
	public ArrayList<String> personnes = new ArrayList<String>();
	public String ville;
	public ArrayList<String> tags = new ArrayList<String>();
	
	public Images(Image i){
		
	}
	
	public Image recupimg(){
		String nom = this.nomimg+".jpg";
		File fichier = new File("Photos/"+nom);
		try {
			Image img = ImageIO.read(fichier);
			return img;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void complete(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.recupimg().getWidth(null));
		sb.append("x");
		sb.append(this.recupimg().getHeight(null));
		this.resolution=sb.toString();
	}
	
	public void addPersonne(String p, Dico dico){
		this.personnes.add(p);
		if(dico.containsKey(p)){
			dico.get(p).add(this);
		}
		else{
			ArrayList<Images> nouv = new ArrayList<Images>();
			nouv.add(this);
			dico.put(p, nouv);
		}
	}
	
	public void addTag(String p, Dico dico){
		this.tags.add(p);
		if(dico.containsKey(p)){
			dico.get(p).add(this);
		}
		else{
			ArrayList<Images> nouv = new ArrayList<Images>();
			nouv.add(this);
			dico.put(p, nouv);
		}
	}
	
	public void addVille(String v, Dico dico){
		this.ville=v;
		if(dico.containsKey(v)){
			dico.get(v).add(this);
		}
		else{
			ArrayList<Images> nouv = new ArrayList<Images>();
			nouv.add(this);
			dico.put(v, nouv);
		}
	}
	
	public void addResolution(String r){
		this.resolution=r;
	}
	
	public java.lang.Integer calculPixel(){
		if(this.resolution!=null){
			int index=0;
			while(this.resolution.charAt(index)!='x'){
				index = index+1;
			}
			int longueur=Integer.parseInt(this.resolution.substring(0, index));
			int largeur=Integer.parseInt(this.resolution.substring(index+1, this.resolution.length()));
			return longueur*largeur;
			}
		else{
			return null;
		}
		}
	
	
	
}

