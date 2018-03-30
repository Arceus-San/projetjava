import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Modele_Binaire extends Modele{
	
	public Modele_Binaire(){}
	
	public void chargerDonnées(String dir) {
		
		File fichier =  new File("images.dat") ;
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(fichier));
			this.images = (ArrayList<Images>)ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			//Fallback
			super.chargerDonnées(dir);
		} catch (IOException | ClassNotFoundException e2) {
			throw new RuntimeException("Lecture des données impossible ou données corrompues");
		}
		
	}

	public void enregistrement() {
		
		File fichier =  new File("images.dat") ;
		try {
			FileOutputStream fos = new FileOutputStream(fichier);
			ObjectOutputStream oos =  new ObjectOutputStream(fos);
			oos.writeObject(this.images);
			oos.close();
			fos.close();
		} catch (IOException e1) {
			throw new RuntimeException("Impossible d'écrire les données");
		}
		
	}

}
