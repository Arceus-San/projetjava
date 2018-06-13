package InterfaceGraphique;

import Patafix.Modele;
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
	public void start(Stage primaryStage) throws Exception {
		
		//Liaison
		Modele modele= new Modele();
		FXMLLoader root = FXMLLoader.load(getClass().getResource("Interface.fxml"));
		root.setController(new Controller(modele));
		
		//Scene
		Parent firstUI = root.load();
		Scene scene = new Scene(firstUI,1920,1080);
		
		primaryStage.setTitle("PicsFinder");
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();


	}

}
