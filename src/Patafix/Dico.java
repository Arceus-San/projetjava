package Patafix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Dico extends HashMap<String , ArrayList<Images>> implements Serializable {


	public Dico(){
		super();
	}

	public ArrayList<Images> recherche(String s){
		Set<String> clés = this.keySet();

		//Version "ou"
		if(s.contains(" ")){
			String[] param = s.split("\\s+");
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
			String[] clétab = clés.toArray(new String[clés.size()]);
			ArrayList<Images> resultat = new ArrayList<Images>();
			ArrayList<String> paramexist = new ArrayList<String>();
			for(int i=0;i<param.length;i++){
				if(clés.contains(param[i])){
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
			if(clés.contains(s)){
				return this.get(s);
			}
			else{
				/*String[] clétab = clés.toArray(new String[clés.size()]);
				ArrayList<Images> resultat = new ArrayList<Images>();
				for(int i=0;i<clés.size();i++){
					String clé = clétab[i];
					if(clé.contains(s)){
						ArrayList<Images> temp = this.get(clé);
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


}