package InterfaceGraphique;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import com.sun.javafx.geom.Rectangle;

import Patafix.Dico;
import Patafix.Images;
import Patafix.Modele;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Callback;

public class Controller {

	@FXML
	private RadioButton radiobuttonET;
	@FXML
	private RadioButton radiobuttonOU;
	@FXML
	private Button B1;
	@FXML
	private TextField brech; /* barre de recherche */
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
	private ChoiceBox<String> chb1; /* liste de choix des couleurs */
	@FXML
	private ChoiceBox<String> chb2; /* liste de choix des villes */
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
	private TextField ImagePers;
	@FXML
	private TextField ImageVille;
	@FXML
	private TextField ImageTag;
	@FXML
	private AnchorPane AnchorPaneImageGrande;
	@FXML
	public Modele modele;
	@FXML
	public String RecupEvt;
	@FXML
	public Images image_act;

	Object rech[] = { "", new ArrayList<String>() };

	public Controller(Modele modele) {
		this.modele = modele;
	}

	public void initialize() throws IOException {

		ObservableList<String> couleurs = FXCollections.observableArrayList("...", "Noir", "Bleu", "Cyan", "Gris",
				"Vert", "Magenta", "Orange", "Rose", "Rouge", "Blanc",
				"Jaune");/*
							 * Ajout des elements dans la liste de choix des
							 * couleurs
							 */
		chb1.setItems(couleurs);
		chb1.getSelectionModel().selectFirst();/*
												 * Selectionne par dï¿½faut le
												 * premier element de la liste
												 */

		ObservableList<String> villes = FXCollections.observableArrayList("...", "Paris", "New-York", "Madrid",
				"Berlin", "Rome", "Chicago",
				"Sydney");/*
							 * Ajout des elements dans la liste de choix des
							 * villes(ï¿½ modifier, liste test)
							 */
		chb2.setItems(villes);
		chb2.getSelectionModel().selectFirst();/*
												 * Selectionne par dï¿½faut le
												 * premier element de la liste
												 */
		final ToggleGroup group = new ToggleGroup();
		radiobuttonOU.setToggleGroup(group);
		radiobuttonOU.setSelected(true);
		radiobuttonET.setToggleGroup(group);

		GenereImages(this.modele.images);

	}

	// File file = new File("C:/Users/Mofid
	// Krim/Desktop/L2/Java_Project/projetjava/Photos/louvre.jpg");

	// System.out.println(System.getProperty("user.home"));

	// System.out.println(file.exists());

	public void NouvelleRecherche(
			ActionEvent event) { /*
									 * Fonction qui agit sur le bouton ajouter
									 * filtres, on recupere les filtres choisis
									 */
		ArrayList<String> filtres = new ArrayList<>();
		// if(b1.onMouseClickedProperty() != null){
		if (cb1.isSelected()) {
			filtres.add(cb1.getText());
		}
		if (cb2.isSelected()) {
			filtres.add(cb2.getText());
		}
		if (chb1.getValue() != "...") {
			filtres.add(chb1.getValue());
		}
		if (chb2.getValue() != "...") {
			filtres.add(chb2.getValue());
		}
		if (!brech.getText().isEmpty()) {
			this.rech[0] = brech.getText();
		}
		this.rech[1] = filtres;
		this.rech[0] = brech.getText();

		resultrech();
		// }
	}

	public void resultrech() {
		System.out.println("Recherche : " + this.rech[0]);
		System.out.println("Filtres : " + this.rech[1]);
		try {
			ArrayList<String> filtr = (ArrayList<String>) this.rech[1];
			if (filtr.isEmpty() && brech.getText().isEmpty()) {
				System.out.println("Pas de recherche ni de filtre");
				for (int i = 0; i < this.modele.images.size(); i++) {
					ImageView imageView;
					imageView = createImageView(this.modele.images.get(i));
					imageView.setId(String.valueOf(i));
				}
				TilePaneGalerie.getChildren().clear();
				GenereImages(this.modele.images);
			} else {
				int log = 0;
				if (radiobuttonET.isSelected()) {
					log = 1;
				} else {
					log = 0;
				}

				ArrayList<Images> result = this.modele.dico.recherche_set(this.rech, log);
				for (int i = 0; i < result.size(); i++) {
					ImageView imageView;
					imageView = createImageView(result.get(i));
					imageView.setId(String.valueOf(i));
				}
				TilePaneGalerie.getChildren().clear();
				GenereImages(result);
			}

			// File file = new
			// File("C:/Users/Mofid/Krim/Desktop/L2/Java_Project/projetjava/Photos/louvre.jpg");

			// System.out.println(System.getProperty("user.home"));

		} catch (NullPointerException npe) {

		}

	}

	public void addCouleur(String coul) {
		if (this.image_act.couleur.toString().equals("")) {
			if (this.modele.dico.containsKey(coul)) {
				this.modele.dico.get(coul).add(this.modele.dico.get(coul).size(), this.image_act);
			} else {
				ArrayList<Images> newarray = new ArrayList();
				newarray.add(this.image_act);
				this.modele.dico.put(coul, newarray);
			}
		} else {
			int i = this.modele.dico.get(this.image_act.couleur.toString()).indexOf(this.image_act);
			this.modele.dico.get(this.image_act.couleur.toString()).remove(i);
			if (this.modele.dico.containsKey(coul)) {
				this.modele.dico.get(coul).add(this.image_act);
			} else {
				ArrayList<Images> newarray2 = new ArrayList();
				newarray2.add(this.image_act);
				this.modele.dico.put(coul, newarray2);
			}
		}
		for (int i = 0; i < this.modele.images.size(); i++) {
			if (this.modele.images.get(i).toString() == this.image_act.toString()) {
				this.modele.images.remove(i);
				this.image_act.couleur = coul;
				this.modele.images.add(image_act);
			}
		}
	}

	// generation des images dans la galerie d'images

	public void GenereImages(ArrayList<Images> Liste) {

		TilePaneGalerie.setPadding(new Insets(30, 20, 20, 20));
		TilePaneGalerie.setHgap(50);
		TilePaneGalerie.setVgap(50);

		for (int i = 0; i < Liste.size(); i++) {
			ImageView imageView;
			imageView = createImageView(Liste.get(i));
			imageView.setId(String.valueOf(i));
			imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

				public void handle(MouseEvent event) { // on affiche l'image
														// dans l'onglet Image
					if (event.getButton().equals(MouseButton.PRIMARY)) {
						if (event.getClickCount() == 2) {
							TabPane.getSelectionModel().selectNext();
							String mouseEvt = event.getPickResult().getIntersectedNode().getId();
							RecupEvt = mouseEvt;
							ImageView cadre = new ImageView();

							final Images img = Liste.get(Integer.parseInt(mouseEvt));

							image_act=img;

							Image IMAGE = img.recupimg();

							BorderPane borderPane = new BorderPane();
							cadre.setImage(IMAGE);
							cadre.setFitHeight(AnchorPaneImageGrande.getHeight());
							cadre.setPreserveRatio(true);
							cadre.setSmooth(true);
							cadre.setCache(true);
							borderPane.setCenter(cadre);
							AnchorPaneImageGrande.getChildren().add(borderPane);
							AnchorPaneImageGrande.getChildren().clear();
							AnchorPaneImageGrande.getChildren().add(cadre);

							ImageNom.textProperty().setValue(img.nomimg);
							try {
								ImageTag.textProperty().setValue(img.tags.toString());
							}
							catch(NullPointerException e) {
								ImageTag.textProperty().setValue("Pas de tags");

							}
							ImageVille.textProperty().setValue(img.ville);
							ImageRes.textProperty().setValue(img.resolution);
							try {
								ImagePers.textProperty().setValue(img.personnes.toString());
							}
							catch(NullPointerException e) {
								ImagePers.textProperty().setValue("Pas de personnes");
							}
							//ImagePers.textProperty().setValue(img.personnes.toString());
							try {
								ImageCoul.textProperty().setValue(img.couleur.toString());
							}
							catch(NullPointerException e) {
								ImageCoul.textProperty().setValue("Pas de couleur");
							}
							//ImageCoul.textProperty().setValue(img.couleur.toString());
							SplitPaneImage.setDividerPositions(0.2f);

						}
					}

				}
			});



			ImageVille.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent keyEvent) {
					if (keyEvent.getCode() == KeyCode.ENTER) {
						image_act.addv(ImageVille.getText());
						//addVille(ImageVille.getText());
						//ImageVille.clear();
					}
				}
			});
			ImageTag.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent keyEvent) {
					if (keyEvent.getCode() == KeyCode.ENTER) {
						image_act.addt(ImageTag.getText());
						//modifTags(ImageTag.getText());
						//ImageTag.backward();

					}
				}
			});
			ImageCoul.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent keyEvent) {
					if(keyEvent.getCode() == KeyCode.ENTER) {
						image_act.addc(ImageCoul.getText());
						//ImageCoul.clear();
					}
				}
			});
			ImagePers.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent keyEvent) {
					if (keyEvent.getCode() == KeyCode.ENTER) {
						image_act.addp(ImagePers.getText());
						//modifPers(ImagePers.getText());
					}
				}
			});

			VBox vbox = new VBox();

			vbox.setSpacing(10);
			vbox.getChildren().addAll(imageView);
			vbox.setAlignment(Pos.CENTER);
			TilePaneGalerie.getChildren().addAll(vbox);
		}

		ScrollPaneGalerie.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		ScrollPaneGalerie.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		ScrollPaneGalerie.setFitToWidth(true);
		ScrollPaneGalerie.setContent(TilePaneGalerie);

	}

	// Crï¿½ation d'une imageview
	private ImageView createImageView(Images img) {
		ImageView imageView = new ImageView(img.recupimg());
		imageView.setFitWidth(282);
		imageView.setFitHeight(185);
		imageView.getStyleClass().add("imageeffect");
		return imageView;
	}

	private void modifTags(String t) {
		Set<String> clés = this.modele.dico.keySet(); //Set des clés du dico
		int index_img = this.modele.images.indexOf(this.image_act); //On récupère l'indice de l'image actuelle pour pour pouvoir la supprimer et ajouter sa nouvelle version avec ses nouveaux tags à la fin de la fonction
		ArrayList<String> ancien_tags = this.image_act.tags; //Liste des anciens tags
		if(!ancien_tags.isEmpty()){ //Si il y avait déjà des tags
			for(int i=0;i<ancien_tags.size();i++) { //On parcours les anciens tags
				int indice = this.modele.dico.get(ancien_tags.get(i)).indexOf(this.image_act); // et on supprime l'image dans la liste correspondant à ce tag
				this.modele.dico.get(ancien_tags.get(i)).remove(indice);
			}
			String[] new_tags = t.split("\\s+"); //On récupère les tags rentrés par l'utilisateur
			ArrayList<String> new_tags2 = new ArrayList();
			for(int k=0;k<new_tags.length;k++) {
				new_tags2.add(k, new_tags[k]);
			}
			for(int j=0;j<new_tags2.size();j++) { //On parcours les tags
				if(clés.contains(new_tags2.get(j))) { //Si la clé existe déjà
					this.modele.dico.get(new_tags2.get(j)).add(this.modele.dico.get(new_tags2.get(j)).size(), this.image_act); //On ajoute l'image dans la liste correxpondant au tag
				}
				else{ //Si la clé n'existe pas
					ArrayList<Images> nouv = new ArrayList<Images>();
					nouv.add(0, this.image_act); //On créé une nouvelle liste avec l'image
					this.modele.dico.put(new_tags2.get(j), nouv); //Et on la met dans le dico à la clé correspondant au tag
				}
			}
			this.modele.images.remove(index_img); //On supprime l'ancienne "version" de l'image dans la liste de toutes les images
			this.modele.images.add(this.modele.images.size(), this.image_act); //Et on y ajoute sa nouvelle version
		}
		else{ //Si il n'y avait pas d'anciens tags
			String[] new_tags = t.split("\\s+"); //On récupère les tags rentrés par l'utilisateur
			ArrayList<String> new_tags2 = new ArrayList();
			for(int k=0;k<new_tags.length;k++) {
				new_tags2.add(k, new_tags[k]);
			}
			this.image_act.tags=new_tags2; //On défini les nouveaux tags de l'image
			for(int j=0;j<new_tags2.size();j++) { //On parcours les tags
				if(clés.contains(new_tags2.get(j))) { //Si la clé existe déjà
					this.modele.dico.get(new_tags2.get(j)).add(this.modele.dico.get(new_tags2.get(j)).size(), this.image_act); //On ajoute l'image dans la liste correxpondant au tag
				}
				else{ //Si la clé n'existe pas
					ArrayList<Images> nouv = new ArrayList<Images>();
					nouv.add(0, this.image_act); //On créé une nouvelle liste avec l'image
					this.modele.dico.put(new_tags2.get(j), nouv); //Et on la met dans le dico à la clé correspondant au tag
				}
			}
			this.modele.images.remove(index_img); //On supprime l'ancienne "version" de l'image dans la liste de toutes les images
			this.modele.images.add(this.modele.images.size(), this.image_act); //Et on y ajoute sa nouvelle version

		}
	}

	private void modifPers(String t) {
		System.out.println("Modification des personnes");
		Set<String> clés = this.modele.dico.keySet(); //Set des clés du dico
		int index_img = this.modele.images.indexOf(this.image_act); //On récupère l'indice de l'image actuelle pour pour pouvoir la supprimer et ajouter sa nouvelle version avec ses nouveaux tags à la fin de la fonction
		System.out.println(this.image_act.personnes.size());
		ArrayList<String> ancien_pers = this.image_act.personnes; //Liste des anciennes personnes
		if(!ancien_pers.isEmpty()){ //Si il y avait déjà des personnes
			System.out.println("Il y avait déjà des personnes");
			for(int i=0;i<ancien_pers.size();i++) { //On parcourt les anciennes personnes
				int indice = this.modele.dico.get(ancien_pers.get(i)).indexOf(this.image_act); // et on supprime l'image dans la liste correspondant à cette personne
				this.modele.dico.get(ancien_pers.get(i)).remove(indice);
			}
			String[] new_pers = t.split("\\s+"); //On récupère les personnes rentrés par l'utilisateur
			ArrayList<String> new_pers2 = new ArrayList();
			for(int k=0;k<new_pers.length;k++) {
				new_pers2.add(k, new_pers[k]);
			}
			for(int j=0;j<new_pers2.size();j++) { //On parcours les personnes
				if(clés.contains(new_pers2.get(j))) { //Si la clé existe déjà
					this.modele.dico.get(new_pers2.get(j)).add(this.modele.dico.get(new_pers2.get(j)).size(), this.image_act); //On ajoute l'image dans la liste correxpondant au tag
				}
				else{ //Si la clé n'existe pas
					ArrayList<Images> nouv = new ArrayList<Images>();
					nouv.add(0, this.image_act); //On créé une nouvelle liste avec l'image
					this.modele.dico.put(new_pers2.get(j), nouv); //Et on la met dans le dico à la clé correspondant a la personne
				}
			}
			this.modele.images.remove(index_img); //On supprime l'ancienne "version" de l'image dans la liste de toutes les images
			this.modele.images.add(this.modele.images.size(), this.image_act); //Et on y ajoute sa nouvelle version
		}
		else{ //Si il n'y avait pas d'anciennes personnes
			System.out.println("Il n'y avait pas de personnes");
			String[] new_pers = t.split("\\s+"); //On récupère les personnes rentrées par l'utilisateur
			ArrayList<String> new_pers2 = new ArrayList();
			for(int k=0;k<new_pers.length;k++) {
				new_pers2.add(k, new_pers[k]);
			}
			System.out.println(new_pers2);
			this.image_act.tags=new_pers2; //On défini les nouvelles personnes de l'image
			for(int j=0;j<new_pers2.size();j++) { //On parcours les personnes
				System.out.println("La clé "+new_pers2.get(j)+" est présente dans le dico ? "+clés.contains(new_pers2.get(j)));
				if(clés.contains(new_pers2.get(j))) { //Si la clé existe déjà
					this.modele.dico.get(new_pers2.get(j)).add(this.modele.dico.get(new_pers2.get(j)).size(), this.image_act); //On ajoute l'image dans la liste correxpondant a la personne
				}
				else{ //Si la clé n'existe pas
					ArrayList<Images> nouv = new ArrayList<Images>();
					nouv.add(0, this.image_act); //On créé une nouvelle liste avec l'image
					this.modele.dico.put(new_pers2.get(j), nouv); //Et on la met dans le dico à la clé correspondant a la personne
				}
			}
			this.modele.images.remove(index_img); //On supprime l'ancienne "version" de l'image dans la liste de toutes les images
			this.modele.images.add(this.modele.images.size(), this.image_act); //Et on y ajoute sa nouvelle version

		}
	}







	public void addVille(String ville) {
		if (this.image_act.couleur.toString().isEmpty()) {
			if (this.modele.dico.containsKey(ville)) {
				this.modele.dico.get(ville).add(this.image_act);
			} else {
				ArrayList<Images> newarray3 = new ArrayList();
				newarray3.add(this.image_act);
				this.modele.dico.put(ville, newarray3);
			}
		} else {
			int i = this.modele.dico.get(this.image_act.couleur.toString()).indexOf(this.image_act);
			this.modele.dico.remove(this.image_act.couleur.toString(), this.modele.dico.get(this.image_act.couleur.toString()).remove(i));
			if (this.modele.dico.containsKey(ville)) {
				this.modele.dico.get(ville).add(this.image_act);
			} else {
				ArrayList<Images> newarray4 = new ArrayList();
				newarray4.add(this.image_act);
				this.modele.dico.put(ville, newarray4);
			}
		}
	}

}
