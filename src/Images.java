import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

public class Images implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public Image image;
	public Color couleur;
	public String resolution;
	public ArrayList<String> personnes = new ArrayList<String>();
	public String ville;
	public ArrayList<String> tags = new ArrayList<String>();
	
	public Images(Image i){
		this.image=i;
		this.complete();
	}
	
	public void complete(){
		this.couleur=this.averageColor();
		StringBuilder sb = new StringBuilder();
		sb.append(this.image.getWidth(null));
		sb.append("x");
		sb.append(this.image.getHeight(null));
		this.resolution=sb.toString();
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
	
	public BufferedImage toBufferedImage()
	{
	    if (this.image instanceof BufferedImage)
	    {
	        return (BufferedImage) this.image;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(this.image.getWidth(null), this.image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(this.image, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}
	
	public Color averageColor() {
		int x0=0;
		int y0=0;
		int w=this.image.getWidth(null);
		int h=this.image.getHeight(null);
	    int x1 = x0 + w;
	    int y1 = y0 + h;
	    long sumr = 0, sumg = 0, sumb = 0;
	    for (int x = x0; x < x1; x++) {
	        for (int y = y0; y < y1; y++) {
	            Color pixel = new Color((this.toBufferedImage().getRGB(x, y)));
	            sumr += pixel.getRed();
	            sumg += pixel.getGreen();
	            sumb += pixel.getBlue();
	        }
	    }
	    int num = w * h;
	    int r=(int) (sumr / num);
	    int g=(int) (sumg / num);
	    int b=(int) (sumb / num);
	    return new Color(r,g,b);
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
