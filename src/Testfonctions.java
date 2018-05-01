public class Testfonctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Modele_Binaire modele = new Modele_Binaire();
		modele.chargerDonnées("Photos/");
		System.out.println(modele.dico.get("ratatouille"));
		
		/*Images rata = modele.recupimg("rata");
		rata.addTag("paris", modele.dico);*/
		
		System.out.println(modele.dico.get("paris"));
		System.out.println(modele.dico.get("1920x1080"));
		System.out.println(modele.dico.get("1280x720"));
		modele.enregistrement();
		
	}
		

}
