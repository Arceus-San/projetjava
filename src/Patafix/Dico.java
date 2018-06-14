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

	public ArrayList<Images> recherche(String rech){
		Set<String> clés = this.keySet();

		//Version "ou"
		if(rech.contains(" ")){
			String[] param = rech.split("\\s+");
			ArrayList<Images> resultat = new ArrayList<Images>();
			String[] clétab = clés.toArray(new String[clés.size()]);
			for(int i=0;i<param.length;i++){
				if(clés.contains(param[i])){
					for(int j=0;j<clétab.length;j++){
						if(param[i].equals(clétab[j])){
							ArrayList<Images> temp = this.get(clétab[j]);
							for(int k=0;k<temp.size();k++){
								if(!resultat.contains(temp.get(k))){
									resultat.add(temp.get(k));
								}
							}
						}
					}
				}
			}
			return resultat;
		}

		//Version "et"
		/*if(s.contains(" ")){
			String[] param = s.split("\\s+");
			String[] clÃ©tab = clÃ©s.toArray(new String[clÃ©s.size()]);
			ArrayList<Images> resultat = new ArrayList<Images>();
			ArrayList<String> paramexist = new ArrayList<String>();
			for(int i=0;i<param.length;i++){
				if(clÃ©s.contains(param[i])){
					paramexist.add(param[i]);
				}
			}

			if(paramexist.isEmpty()){
				return new ArrayList<Images>();
			}
			if(paramexist.size()==1){
				return this.get(paramexist.get(0));
			}
			else{
				resultat = this.get(paramexist.get(0));
				for(int i=1;i<paramexist.size();i++){
					for(int j=0;j<this.get(paramexist.get(i)).size();j++){
						if(!this.get(paramexist.get(i)).contains(resultat.get(j))){
							resultat.remove(resultat.get(j));
						}
						if(resultat.isEmpty()){
							return new ArrayList<Images>();
						}
					}
				}

			}

		}*/

		else{
			if(clés.contains(rech)){
				return this.get(rech);
			}
			else{
				/*String[] clÃ©tab = clÃ©s.toArray(new String[clÃ©s.size()]);
				ArrayList<Images> resultat = new ArrayList<Images>();
				for(int i=0;i<clÃ©s.size();i++){
					String clÃ© = clÃ©tab[i];
					if(clÃ©.contains(s)){
						ArrayList<Images> temp = this.get(clÃ©);
						for(int j=0;j<temp.size();j++){
							if(!resultat.contains(temp.get(j))){
								resultat.add(temp.get(j));
							}
						}
					}
				}*/
				return new ArrayList<Images>();
			}

		}
	}
	
	public ArrayList<Images> recherche_set(Object[] tab, int v){
		Set<String> clés = this.keySet();
		if(v==0) {
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
				param.add((String) tab[0]);
				ArrayList<Images> resultat = new ArrayList<>();
				for(int i=0;i<param.size();i++) {
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
			return new ArrayList<Images>();
		}
	}


}