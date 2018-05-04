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
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Callback;

public class Controller extends AnchorPane implements Observer{

	@FXML
	Button b1, b2;
	@FXML
	Label label1, label2;
	@FXML
	CheckBox cb1, cb2, cb3, cb4;
	@FXML
	Tab galerie, edit;
	@FXML
	ChoiceBox<String> chb1; /*liste de choix des couleurs*/
	@FXML
	ChoiceBox<String> chb2; /*liste de choix des villes*/
	@FXML
	TextField brech; /*barre de recherche*/
	@FXML
	ImageView imgview1, imgview2, imgview3, imgview4, imgview5, imgview6, imgview7, imgview8, imgview9, imgview10, imgview11, imgview12, imgview13, imgview14, imgview15;

	Object rech[] = {"",new ArrayList<String>()};

	ImageView[] im = {imgview1, imgview2, imgview3, imgview4, imgview5, imgview6, imgview7, imgview8, imgview9, imgview10, imgview11, imgview12, imgview13, imgview14, imgview15};


	ArrayList<ImageView> imageview=new ArrayList();
	ArrayList<Images> images;


	public void initialize() throws IOException{


		ObservableList<String> couleurs = FXCollections.observableArrayList("...","Noir","Bleu","Cyan","Gris", "Vert", "Magenta","Orange","Rose","Rouge","Blanc","Jaune");/*Ajout des elements dans la liste de choix des couleurs*/
		chb1.setItems(couleurs);
		chb1.getSelectionModel().selectFirst();/*Selectionne par défaut le premier element de la liste*/

		ObservableList<String> villes = FXCollections.observableArrayList("...","Paris","New-York", "Madrid","Berlin","Rome","Chicago","Sydney");/*Ajout des elements dans la liste de choix des villes(ï¿½ modifier, liste test)*/
		chb2.setItems(villes);

		chb2.getSelectionModel().selectFirst();/*Selectionne par défaut le premier element de la liste*/

		chb2.getSelectionModel().selectFirst();/*Selectionne par défaut le premier element de la liste*/

		this.genereimages();
		//this.aleat();

	}

	public void aleat() throws IOException{
		File source = new File("C:/Users/Mofid Krim/Desktop/L2/Java_Project/projetjava/Photos");
		// de quoi descendre dans les sous répertoires et ainsi tester le no
		File[] content = source.listFiles();
		for(int i=0;i<content.length;i++){
			String localUrl = content[(int) (Math.random()*(content.length-0))].toURI().toURL().toString();
			Image image = new Image(localUrl);
			im[i].setImage(image);
		}
	}
	public void editimage(ActionEvent event){
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
		    alert.setTitle("Editeur d'images");
		    alert.setHeaderText(null);
		    alert.setContentText("Veuillez sélectionner une image");
		    alert.showAndWait();
	}

	public void genereimages(){
        Image image = new Image("file:Photos/albi.jpg");
        imgview1.setImage(image);
        Image image1 = new Image("file:Photos/castres.jpg");
        imgview2.setImage(image1);
        Image image2 = new Image("file:Photos/cathedrale.jpg");
        imgview3.setImage(image2);
        Image image3 = new Image("file:Photos/kyoto.jpg");
        imgview4.setImage(image3);
        Image image4 = new Image("file:Photos/londres.jpg");
        imgview5.setImage(image4);
        Image image5 = new Image("file:Photos/los-angeles.jpg");
        imgview6.setImage(image5);
        Image image6 = new Image("file:Photos/louvre.jpg");
        imgview7.setImage(image6);
        Image image7 = new Image("file:Photos/marseille.jpg");
        imgview8.setImage(image7);
        Image image8 = new Image("file:Photos/moscou.jpg");
        imgview9.setImage(image8);
        Image image9 = new Image("file:Photos/new-york.jpg");
        imgview10.setImage(image9);
        Image image10 = new Image("file:Photos/ratatouille.jpg");
        imgview11.setImage(image10);
        Image image11 = new Image("file:Photos/stade.jpg");
        imgview12.setImage(image11);
        Image image12 = new Image("file:Photos/theatre.jpg");
        imgview13.setImage(image12);
        Image image13 = new Image("file:Photos/tokyo.jpg");
        imgview14.setImage(image13);
        Image image14 = new Image("file:Photos/tour.jpg");
        imgview15.setImage(image14);

		//File file = new File("C:/Users/Mofid Krim/Desktop/L2/Java_Project/projetjava/Photos/louvre.jpg");

		//System.out.println(System.getProperty("user.home"));

		//System.out.println(file.exists());
    }

	public void buttonaction(ActionEvent event){		/*Fonction qui agit sur le bouton ajouter filtres, on recupere les filtres choisis*/
		ArrayList<String> filtres = new ArrayList<>();
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

	public void toImageView(){
		/*for(int i=0; i<this.images.size();i++){
			this.imageview.add(imgview1);
			this.imageview[i].setImage(images[i]);
		}*/

	}

	public void barrerecherche(ActionEvent event){ /*Fonction qui permet de recuperer les valeurs rentrï¿½s dans la barre de recherche*/
		//System.out.print(brech.getText());
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
		ArrayList img= new ArrayList();
		img.add(this.images);

	}

}


