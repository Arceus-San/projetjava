package InterfaceGraphique;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import com.sun.javafx.geom.Rectangle;

import Patafix.Images;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Callback;

public class Controller extends AnchorPane implements Observer{

	@FXML
	private Button B1;
	@FXML
	private TextField brech; /*barre de recherche*/
	@FXML
	private TabPane TabPane;
	@FXML
	private Tab TabGalerie;
	@FXML
	private SplitPane SplitPaneGalerie;
	@FXML
	private AnchorPane AnchorPaneFiltres;
	@FXML
	private CheckBox cb1;
	@FXML
	private CheckBox cb2;
	@FXML
	private CheckBox cb3;
	@FXML
	private CheckBox cb4;
	@FXML
	private ChoiceBox<String> chb1; /*liste de choix des couleurs*/
	@FXML
	private ChoiceBox<String> chb2; /*liste de choix des villes*/
	@FXML
	private TextField GalerieTextPersonne;
	@FXML
	private TextField GalerieTextTag;
	@FXML
	private Button B2;
	@FXML
	private ScrollPane ScrollPaneGalerie;
	@FXML
	private TilePane TilePaneGalerie;
	@FXML
	private Tab TabImage;
	@FXML
	private SplitPane SplitPaneImage;
	@FXML
	private AnchorPane AnchorPaneImageDetails;
	@FXML
	private TextField ImageNom;
	@FXML
	private TextField ImageCoul;
	@FXML
	private TextField ImageRes;
	@FXML
	private TextArea ImagePers;
	@FXML
	private TextArea ImageVille;
	@FXML
	private TextArea ImageTag;
	@FXML
	private AnchorPane AnchorPaneImageGrande;



	Object rech[] = {"",new ArrayList<String>()};


	ArrayList<ImageView> imageview=new ArrayList();
	ArrayList<Images> images;



	public void initialize() throws IOException{


		ObservableList<String> couleurs = FXCollections.observableArrayList("...","Noir","Bleu","Cyan","Gris", "Vert", "Magenta","Orange","Rose","Rouge","Blanc","Jaune");/*Ajout des elements dans la liste de choix des couleurs*/
		chb1.setItems(couleurs);
		chb1.getSelectionModel().selectFirst();/*Selectionne par dï¿½faut le premier element de la liste*/

		ObservableList<String> villes = FXCollections.observableArrayList("...","Paris","New-York", "Madrid","Berlin","Rome","Chicago","Sydney");/*Ajout des elements dans la liste de choix des villes(ï¿½ modifier, liste test)*/
		chb2.setItems(villes);
		chb2.getSelectionModel().selectFirst();/*Selectionne par dï¿½faut le premier element de la liste*/
		//genereimages();
	}


	public void OuvrirImage(ActionEvent event){
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
		    alert.setTitle("Affichage de l'image");
		    alert.setHeaderText(null);
		    alert.setContentText("Veuillez sélectionner une image avant de l'ouvrir");
		    alert.showAndWait();
	}

		//File file = new File("C:/Users/Mofid Krim/Desktop/L2/Java_Project/projetjava/Photos/louvre.jpg");

		//System.out.println(System.getProperty("user.home"));

		//System.out.println(file.exists());


	public void NouvelleRecherche(ActionEvent event){		/*Fonction qui agit sur le bouton ajouter filtres, on recupere les filtres choisis*/
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
			if(!GalerieTextPersonne.getText().isEmpty()){
				filtres.add(GalerieTextPersonne.getText());
			}
			if(!GalerieTextTag.getText().isEmpty()){
				filtres.add(GalerieTextTag.getText());
			}
			if(!brech.getText().isEmpty()){
				this.rech[0]=brech.getText();
			}
			this.rech[1]=filtres;
			System.out.println("Recherche : "+this.rech[0]);
			System.out.println("Filtres : "+this.rech[1]);
		//}
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


