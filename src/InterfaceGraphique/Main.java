package InterfaceGraphique;

import Patafix.Modele;
import Patafix.Modele_Binaire;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		Modele_Binaire modele = new Modele_Binaire();
		modele.chargerDonnées("Photos/");

		FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("Interface.fxml"));
		firstLoader.setController(new Controller(modele));

		//Création de la SCENE
		Parent firstUI = firstLoader.load();
		Scene scene = new Scene(firstUI,1920,1080);

		//CSS
		//scene.getStylesheets().add(getClass().getResource("interface.css").toExternalForm());
		
		//Paramètres du STAGE
		stage.setTitle("Pics Finder");
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();

		//stage.setOnHiding(event -> modele.enregistrement());

	

	}
}