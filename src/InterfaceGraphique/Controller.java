package InterfaceGraphique;

import Patafix.Images;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

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

public class Controller extends AnchorPane implements Observer{

	@FXML
	Button b1;
	@FXML
	Label label1, label2;
	@FXML
	CheckBox cb1, cb2, cb3, cb4;
	@FXML
	Tab galerie, vue;
	@FXML
	ChoiceBox<String> chb1; /*liste de choix des couleurs*/
	@FXML
	ChoiceBox<String> chb2; /*liste de choix des villes*/
	@FXML
	TextField brech; /*barre de recherche*/
	@FXML
	ImageView imgview1, imgview2, imgview3, imgview4, imgview5, imgview6, imgview7, imgview8, imgview9, imgview10, imgview11, imgview12, imgview13, imgview14, imgview15;

	Object rech[] = {"",new ArrayList<String>()};


	ArrayList<ImageView> imageview;
	ArrayList<Images> images;


	public void initialize(){

		ObservableList<String> couleurs = FXCollections.observableArrayList("...","Noir","Bleu","Cyan","Gris", "Vert", "Magenta","Orange","Rose","Rouge","Blanc","Jaune");/*Ajout des elements dans la liste de choix des couleurs*/
		chb1.setItems(couleurs);
		chb1.getSelectionModel().selectFirst();/*Selectionne par défaut le premier element de la liste*/

		ObservableList<String> villes = FXCollections.observableArrayList("...","Paris","New-York", "Madrid","Berlin","Rome","Chicago","Sydney");/*Ajout des elements dans la liste de choix des villes(ï¿½ modifier, liste test)*/
		chb2.setItems(villes);

		chb2.getSelectionModel().selectFirst();/*Selectionne par défaut le premier element de la liste*/

		chb2.getSelectionModel().selectFirst();/*Selectionne par défaut le premier element de la liste*/

		//this.genereimages();

	}
	public void selectedimage(ActionEvent event){/*Créer la fonction qui ouvre une nouvelle image dans un nouvel onglet*/
		if(vue.isSelected()){
		}
	}

	/*public void genereimages(){
        final URL imageURL = getClass().getResource(System.getProperty("user.home")+"/Bureau/JAVA/projetjava/Photos/louvre.jpg");
        final Image image = new Image(imageURL.toExternalForm());
        final ImageView imageView = new ImageView(image);

		File file = new File("Photos/louvres.jpg");
		System.out.println(System.getProperty("user.home"));

		System.out.println(file.exists());
    }*/

	public void buttonaction(ActionEvent event){		/*Fonction qui agit sur le bouton ajouter filtres, on recupere les filtres choisis*/
		ArrayList<String> filtres = new ArrayList<>();
		//if(b1.onMouseClickedProperty() != null){
			if(cb1.isSelected()){
				filtres.add(cb1.getText());
			}
			if(cb2.isSelected()){
				filtres.add(cb2.getText());
			}
			if(cb3.isSelected()){
				filtres.add(cb3.getText());
			}
			if(cb4.isSelected()){
				filtres.add(cb4.getText());
			}
			if(chb1.getValue()!="..."){
				filtres.add(chb1.getValue());
			}
			if(chb2.getValue()!="..."){
				filtres.add(chb2.getValue());
			}
			if(!brech.getText().isEmpty()){
				this.rech[0]=brech.getText();
			}
			this.rech[1]=filtres;
			System.out.println("Recherche : "+this.rech[0]);
			System.out.println("Filtres : "+this.rech[1]);
		//}
	}

	/*public void toImageView(){
		for(Images image : this.images){
			this.imageview.add(new ImageView().setImage(image)s);
		}

	}*/

	public void barrerecherche(ActionEvent event){ /*Fonction qui permet de recuperer les valeurs rentrés dans la barre de recherche*/
		//System.out.print(brech.getText());/*probleme réncontré, les elements restent en memorie a chaque recherche effectué*/
		if(brech.getText().isEmpty()){
			System.out.println("Recherche vide");
		}
		else{
			this.rech[0]=brech.getText();
			System.out.println("Recherche : "+this.rech[0]);
			System.out.println("Filtres : "+this.rech[1]);
		}
	}
	@Override
	public void update(Observable obs, Object obj) {
		//this.images = ((ArrayList<Images> obj);
	}

}


