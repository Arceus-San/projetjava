package InterfaceGraphique;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.javafx.geom.Rectangle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Callback;

public class controller extends AnchorPane{

	@FXML
	Button b1, b2;
	@FXML
	Label label1, label2;
	@FXML
	CheckBox cb1, cb2, cb3,  cb4;
	@FXML
	Tab tab1;
	@FXML
	ChoiceBox<String> chb1; /*liste de choix des couleurs*/
	@FXML
	ChoiceBox<String> chb2; /*liste de choix des villes*/
	@FXML
	TextField brech; /*barre de recherche*/

public void initialize(){

	ObservableList<String> couleurs = FXCollections.observableArrayList("...","Noir","Bleu","Cyan","Gris", "Vert", "Magenta","Orange","Rose","Rouge","Blanc","Jaune");/*Ajout des elements dans la liste de choix des couleurs*/
	chb1.setItems(couleurs);
	chb1.getSelectionModel().selectFirst();/*Selectionne par défaut le premier element de la liste*/

	ObservableList<String> villes = FXCollections.observableArrayList("...","Paris","New York", "Madrid","Berlin","Rome","Chicago","Sydney");/*Ajout des elements dans la liste de choix des villes(à modifier, liste test)*/
	chb2.setItems(villes);
	chb2.getSelectionModel().selectFirst();/*Selectionne par défaut le premier element de la liste*/

}



public void buttonaction(ActionEvent event){		/*Fonction qui agit sur le bouton ajouter filtres*/
	if(b1.onMouseClickedProperty() != null){
		System.out.println("Recherche en cours..."); /*il faudra lier aussi cette nouvelle recherche aux fonctions situés dans la selection de filtres*/
	}
}

public void ajoutonglet(ActionEvent event){		/*Fonction qui agit sur le bouton ajouter un nouvel onglet "+"*/
	if(b2.onMouseClickedProperty() != null){	/*il faudra surement faire appel a une fonction qui permet d'ouvrir un nouvel onglet sans récopier les valeurs de l'onglet principal*/

	}
}

public void selecresolution(ActionEvent event){ /*Fonction qui récupere le choix de la résolution*/
	ArrayList<String> str = null; /*pour l'instant ça marche pas*/
	if (cb1.onMouseClickedProperty() != null){
		str.add(cb1.getOnMouseClicked().toString());
	}
	else if (cb2.onMouseClickedProperty() != null){
		str.add(cb2.getOnMouseClicked().toString());
		}
	else if (cb3.onMouseClickedProperty() != null){
		str.add(cb3.getOnMouseClicked().toString());
		}
	else if (cb4.onMouseClickedProperty() != null){
		str.add(cb4.getOnMouseClicked().toString());
		}
	System.out.print(str);
}
public void listecouleurs(ActionEvent event){/*fonction qui permettra de récuperer lacouleur selectionné */
	System.out.println(chb1.getItems());/*A revoir vu que les fonctions ne sont pas liés dans le scnene builder (manque de l'option on action, a tester avec onClickedMouse)*/
}
public void listevilles(ActionEvent event){/*fonction qui permettra de récuperer la ville selectionné */
	System.out.println(chb2.getItems());/*A revoir vu que les fonctions ne sont pas liés dans le scnene builder (manque de l'option on action, a tester avec onClickedMouse)*/
}

public void barrerecherche(ActionEvent event){ /*Fonction qui permet de recuperer les valeurs rentrés dans la barre de recherche*/
	System.out.print(brech.getText());/*probleme réncontré, les elements restent en memorie a chaque recherche effectué*/
}

/** Fonction pour créer les images, a modifier en fonction du code principal
File folder = new File("Images");
File[] listOfFiles = folder.listFiles();


for (final File file : listOfFiles) {
        ImageView imageView;
	imageView = createImageView(file.toString());
}

private ImageView createImageView(String nom) {
		ImageView imageView = null;
		final Image img = new Image(nom);
		Image temp = new Image("file:"+img.nom);
		imageView = new ImageView(temp);
		imageView.getStyleClass().add("image");
		return imageView;
	}**/

}
