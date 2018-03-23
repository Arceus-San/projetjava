import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

public class Images {
	
	public Image image;
	public Color couleur;
	public String resolution;
	public ArrayList<String> personnes = new ArrayList<String>();
	public String ville;
	public ArrayList<String> tags = new ArrayList<String>();

	
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
	
	public void addTag(String p){
		this.tags.add(p);
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
	
	public boolean estPresent(String s){
		if(this.personnes.contains(s)){ //Si la chaîne de caractères est présente telle quelle dans la liste
			return true;
		}
		else{//Sinon
			if(s.contains(" ")){//Si s contient un espace --> nom + prénom 
				//On sépare les deux mots
				String s1="";
				String s2="";
				int index=0;
				while(s.charAt(index)!=' '){
					index=index+1;
				}
				s1=s.substring(0, index);
				s2=s.substring(index+1, s.length());
				if(s.contains(s1) || s.contains(s2)){//Si s contient s1 ou s2
					return true;
				}
				else{
					return false;
				}
			}
			else{//s ne contient pas d'espace
				for(int i=0;i<this.personnes.size();i++){//On vérifie chaque string dans la liste personnes 
					if(this.personnes.get(i).contains(s)){//Si une des chaînes de caractères contient s
						return true;
					}
				}
				return false;
			}
			
		}
	}
	
	public boolean estPresentVille(String s){
		if(s.equals(this.ville) || this.ville.contains(s)){
			return true;
		}
		return false;
	}
	
}
