package Patafix;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;

public class Modele_Binaire extends Modele{



	public Modele_Binaire(){}

	public void chargerDonnées(String dir) {

		System.out.println("Charger données Modele");

		File fichier =  new File("images.dat") ;
		File fichier2 = new File("dico.dat");
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.images = (ArrayList<Images>) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("Le fichier images existe");
			ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(fichier2));
			this.dico = (Dico)ois2.readObject();
			ois2.close();
			System.out.println("Le fichier dico existe");
		} catch (FileNotFoundException e) {
			//Fallback
			System.out.println("Les fichiers images et dico n'existent pas");
			super.chargerDonnées(dir);
		} catch (IOException | ClassNotFoundException e2) {
			//throw new RuntimeException("Lecture des donn�es impossible ou donn�es corrompues");
			e2.printStackTrace();
		}

	}

	public void enregistrement() {

		System.out.println("Enregistrer données Modele");

		File fichier =  new File("images.dat") ;
		File fichier2 =  new File("dico.dat") ;
		try {
			FileOutputStream fos = new FileOutputStream(fichier);
			ObjectOutputStream oos =  new ObjectOutputStream(fos);
			oos.writeObject(this.images);
			oos.close();
			fos.close();
			FileOutputStream fos2 = new FileOutputStream(fichier2);
			ObjectOutputStream oos2 =  new ObjectOutputStream(fos2);
			oos2.writeObject(this.dico);
			oos2.close();
			fos2.close();
		} catch (IOException e1) {
			//throw new RuntimeException("Impossible d'�crire les donn�es");
			e1.printStackTrace();
		}


	}


}
