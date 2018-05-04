package InterfaceGraphique;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
<<<<<<< HEAD
	
	public void initialize(){
=======

	ImageView[] im = {imgview1, imgview2, imgview3, imgview4, imgview5, imgview6, imgview7, imgview8, imgview9, imgview10, imgview11, imgview12, imgview13, imgview14, imgview15};


	ArrayList<ImageView> imageview=new ArrayList();
	ArrayList<Images> images;


	public void initialize() throws IOException{
>>>>>>> branch1


		ObservableList<String> couleurs = FXCollections.observableArrayList("...","Noir","Bleu","Cyan","Gris", "Vert", "Magenta","Orange","Rose","Rouge","Blanc","Jaune");/*Ajout des elements dans la liste de choix des couleurs*/
		chb1.setItems(couleurs);
		chb1.getSelectionModel().selectFirst();/*Selectionne par d�faut le premier element de la liste*/

		ObservableList<String> villes = FXCollections.observableArrayList("...","Paris","New-York", "Madrid","Berlin","Rome","Chicago","Sydney");/*Ajout des elements dans la liste de choix des villes(� modifier, liste test)*/
		chb2.setItems(villes);
		chb2.getSelectionModel().selectFirst();/*Selectionne par d�faut le premier element de la liste*/
	}
	public void selectedimage(ActionEvent event){/*Cr�er la fonction qui ouvre une nouvelle image dans un nouvel onglet*/
		if(vue.isSelected()){
		}
	}

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


	public void barrerecherche(ActionEvent event){ /*Fonction qui permet de recuperer les valeurs rentr�s dans la barre de recherche*/
<<<<<<< HEAD
		//System.out.print(brech.getText());/*probleme r�ncontr�, les elements restent en memorie a chaque recherche effectu�*/
=======
		//System.out.print(brech.getText());
>>>>>>> branch1
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
<<<<<<< HEAD
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
=======
	public void update(Observable obs, Object obj) {
		ArrayList img= new ArrayList();
		img.add(this.images);

>>>>>>> branch1
	}

}


