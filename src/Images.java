import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

public class Images {
	
	public Image image;
	public Color couleur;
	public String resolution;
	public ArrayList<String> personnes;
	public String ville;
	public ArrayList<String> tags;
	
	public Images(Image i){
		this.image=i;
	}
	
	public Images(Image i,Color c, String r, String v){
		this.image=i;
		this.couleur=c;
		this.resolution=r;
		this.ville=v;
	}
	
	public void addPersonne(String p){
		this.personnes.add(p);
	}
	
	public void addVille(String v){
		this.ville=v;
	}
	
	public void addResolution(String r){
		this.resolution=r;
	}
	
	public void addCouleur(Color c){
		this.couleur=c;
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
