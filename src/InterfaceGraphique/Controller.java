package InterfaceGraphique;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
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
	private CheckBox cb3;
	@FXML
	private CheckBox cb4;
	@FXML
	private ChoiceBox<String> chb1; /* liste de choix des couleurs */
	@FXML
	private ChoiceBox<String> chb2; /* liste de choix des villes */
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
	private TextField ImagePers;
	@FXML
	private TextField ImageVille;
	@FXML
	private TextField ImageTag;
	@FXML
	private Button B3;
	@FXML
	private AnchorPane AnchorPaneImageGrande;
	@FXML
	public Modele modele;
	@FXML
	public String RecupEvt;

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
												 * Selectionne par d�faut le
												 * premier element de la liste
												 */

		ObservableList<String> villes = FXCollections.observableArrayList("...", "Paris", "New-York", "Madrid",
				"Berlin", "Rome", "Chicago",
				"Sydney");/*
							 * Ajout des elements dans la liste de choix des
							 * villes(� modifier, liste test)
							 */
		chb2.setItems(villes);
		chb2.getSelectionModel().selectFirst();/*
												 * Selectionne par d�faut le
												 * premier element de la liste
												 */
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
		if (cb3.isSelected()) {
			filtres.add(cb3.getText());
		}
		if (cb4.isSelected()) {
			filtres.add(cb4.getText());
		}
		if (chb1.getValue() != "...") {
			filtres.add(chb1.getValue());
		}
		if (chb2.getValue() != "...") {
			filtres.add(chb2.getValue());
		}
		if (!GalerieTextPersonne.getText().isEmpty()) {
			filtres.add(GalerieTextPersonne.getText());
		}
		if (!GalerieTextTag.getText().isEmpty()) {
			filtres.add(GalerieTextTag.getText());
		}
		if (!brech.getText().isEmpty()) {
			this.rech[0] = brech.getText();
		}
		this.rech[1] = filtres;
		System.out.println("Recherche : " + this.rech[0]);
		System.out.println("Filtres : " + this.rech[1]);
		// }
	}

	public void barrerecherche(
			ActionEvent event) { /*
									 * Fonction qui permet de recuperer les
									 * valeurs rentr�s dans la barre de
									 * recherche
									 */
		// System.out.print(brech.getText());

		if (brech.getText().isEmpty()) {
			System.out.println("Recherche vide");
		} else {
			this.rech[0] = brech.getText();
			resultrech();
		}
	}

	public void resultrech() {
		System.out.println(" ");
		System.out.println("Recherche : " + this.rech[0]);
		System.out.println("Filtres : " + this.rech[1]);
		try {
			ArrayList<String> filtr = (ArrayList<String>) this.rech[1];
			if (filtr.isEmpty()) {
				System.out.println("Pas de filtres");
			}
			ArrayList<Images> result = this.modele.dico.recherche((String) this.rech[0]);
			for (int i = 0; i < result.size(); i++) {
				System.out.print(result.get(i).nomimg);
				System.out.print(" ");
				ImageView imageView;
				imageView = createImageView(result.get(i));
				imageView.setId(String.valueOf(i));
			}
			TilePaneGalerie.getChildren().clear();
			GenereImages(result);



		} catch (NullPointerException npe) {
			System.out.println("La liste correspondant à cette image est vide");
		}

	}

	// generation des images dans la galerie d'images

	private void GenereImages(ArrayList<Images> Liste) {

		TilePaneGalerie.setPadding(new Insets(30, 20, 20, 20));
		TilePaneGalerie.setHgap(50);
		TilePaneGalerie.setVgap(50);

		for (int i = 0; i < Liste.size(); i++) {
			ImageView imageView;
			imageView = createImageView(this.modele.images.get(i));
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
							ImageTag.textProperty().setValue(img.tags.toString());
							ImageVille.textProperty().setValue(img.ville);
							ImageRes.textProperty().setValue(img.resolution);
							ImagePers.textProperty().setValue(img.personnes.toString());
							ImageCoul.textProperty().setValue(img.couleur.toString());
							SplitPaneImage.setDividerPositions(0.2f);

							ImageNom.setEditable(false);
							ImageTag.setEditable(true);
							ImageVille.setEditable(false);
							ImageRes.setEditable(false);
							ImagePers.setEditable(false);
							ImageCoul.setEditable(false);
						}
					}

				}
			});

			ImageTag.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent keyEvent) {
					if (keyEvent.getCode() == KeyCode.ENTER) {
						ArrayList<String> before = new ArrayList<>();
						// before = Liste.get(Integer.parseInt(RecupEvt)).tags;
						String text = ImageTag.getText().trim().replaceAll("\n", "").replaceAll("\r", "")
								.replaceAll("\\s+", "");
						// Liste.get(Integer.parseInt(RecupEvt)).Set_Tags(text);
						ArrayList<String> after = new ArrayList<>();
						// after = Liste.get(Integer.parseInt(RecupEvt)).tags;
						DeleteTags(Integer.parseInt(RecupEvt), before, after, Liste);
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

	// Cr�ation d'une imageview
	private ImageView createImageView(Images img) {
		ImageView imageView = new ImageView(img.recupimg());
		imageView.setFitWidth(282);
		imageView.setFitHeight(185);
		System.out.println(img.recupimg());
		return imageView;
	}

	private void DeleteTags(int id, ArrayList<String> A, ArrayList<String> B, ArrayList<Images> Img) {
		for (int i = 1; i < A.size(); i++) {
			ArrayList<String> C = (modele.Tags.get(A.get(i)));
			if (!B.contains(A.get(i))) {
				C.remove(Img.get(id).recupimg());
			}
		}

		if (B.size() != A.size()) {
			Dico Aset = new Dico();
			Dico Bset = new Dico();
			Bset.remove(Aset);

			ArrayList<String> Dif = new ArrayList<String>();
			Dif.add(Bset.toString());
			for (int j = 0; j < Dif.size(); j++) {
				if (modele.Tags.containsKey(Dif.get(j))) {
					modele.Tags.get(Dif.get(j)).add(Img.get(id).recupimg().toString());
				} else {
					ArrayList<String> D = new ArrayList<String>();
					D.add(Img.get(id).recupimg().toString());
					modele.Tags.put(Dif.get(j), D);
				}
			}
		}

	}

}
