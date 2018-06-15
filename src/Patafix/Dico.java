package Patafix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Dico extends HashMap<String , ArrayList<Images>> implements Serializable {


	public Dico(){
		super();
	}
	
	public ArrayList<Images> recherche_set(Object[] tab, int v){
		Set<String> clés = this.keySet();
		if(v==0) {
			System.out.println("OU");
			ArrayList<String> param = (ArrayList<String>) tab[1];
			if(param.isEmpty()) {
				String[] rech = ((String) tab[0]).split("\\s+");
				ArrayList<Images> resultat = new ArrayList<Images>();
				for(int i=0;i<rech.length;i++) {
					System.out.println("Le dico contient la clé "+rech[i]+" : "+clés.contains(rech[i]));
					if(clés.contains(rech[i])) {
						System.out.println("Liste correspondant à "+rech[i]+" "+this.get(rech[i]));
						ArrayList<Images> temp = this.get(rech[i]);
						for(int j=0;j<temp.size();j++) {
							if(!resultat.contains(temp.get(j))) {
								resultat.add(temp.get(j));
							}
						}
					}
				}
				return resultat;
			}
			else {
				System.out.println("Filtres existants");
				String[] rech = ((String) tab[0]).split("\\s+");
				for(int k=0;k<rech.length;k++) {
					param.add((String) rech[k]);
				}
				ArrayList<Images> resultat = new ArrayList<>();
				for(int i=0;i<param.size();i++) {
					System.out.println("Paramètre : "+param.get(i));
					System.out.println(param.get(i)+" est une clé du dico ? "+clés.contains(param.get(i)));
					if(clés.contains(param.get(i))) {
						ArrayList<Images> temp = this.get(param.get(i));
						for(int j=0;j<temp.size();j++) {
							if(!resultat.contains(temp.get(j))) {
								resultat.add(temp.get(j));
							}
						}
					}
				}
				return resultat;
			}
		}
		else {
			System.out.println("ET");
			ArrayList<String> param = (ArrayList<String>) tab[1];
			if(param.isEmpty()) {
				System.out.println("Pas de filtres");
				String[] rech = ((String) tab[0]).split("\\s+");
				if(rech.length==1) {
					System.out.println("Un seul mot tapé");
					System.out.println(rech[0]+" est dans les clés ? "+clés.contains(rech[0]));
					if(clés.contains(rech[0])) {
						return this.get(rech[0]);
					}
					else {
						System.out.println(rech[0]+" n'est pas dans les clés");
						return new ArrayList<Images>();
					}
				}
				System.out.println("Plusieurs mots tapés");
				System.out.println("Premier mot : "+rech[0]);
				System.out.println("Liste correspondant à "+rech[0]+" "+this.get(rech[0]));
				Set<Images> resultat = new HashSet<Images>(this.get(rech[0]));
				for(int i=1;i<rech.length;i++) {
					System.out.println("Le dico contient la clé "+rech[i]+" : "+clés.contains(rech[i]));
					System.out.println("Liste correspondant à "+rech[i]+" "+this.get(rech[i]));
					Set<Images> temp = new HashSet<Images>(this.get(rech[i]));
					resultat.retainAll(temp);
					if(resultat.isEmpty()) {
						System.out.println("résultat est vide");
						return new ArrayList<Images>();
					}
				}
				ArrayList<Images> result = new ArrayList<Images>(resultat);
				return result;
					
				}
			else {
				System.out.println("Filtres existants");
				if(!((String) tab[0]).isEmpty()) {
					String[] rech = ((String) tab[0]).split("\\s+");
					for(int k=0;k<rech.length;k++) {
						param.add((String) rech[k]);
					}
				}
				System.out.println("Filtre 1 : "+param.get(0));
				System.out.println("Liste correspondant à "+param.get(0)+" "+this.get(param.get(0)));
				Set<Images> resultat = new HashSet<>(this.get(param.get(0)));
				for(int i=1;i<param.size();i++) {
					System.out.println("Le dico contient la clé "+param.get(i)+" : "+clés.contains(param.get(i)));
					System.out.println("Liste correspondant à "+param.get(i)+" "+this.get(param.get(i)));
						Set<Images> temp = new HashSet<Images>(this.get(param.get(i)));
						resultat.retainAll(temp);
						if(resultat.isEmpty()) {
							System.out.println("résultat est vide");
							return new ArrayList<Images>();
						}
				}
				ArrayList<Images> result = new ArrayList<Images>(resultat);
				return result;
			}
				
		}
	}


}