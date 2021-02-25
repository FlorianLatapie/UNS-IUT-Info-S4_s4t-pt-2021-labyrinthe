package app.ihm;


import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class InterfacePrincipale extends Application {
	private StackPane root = new StackPane();
	private Node currentTopNode = null;
	private ScreenControl sControl = null;
	private Scene scene = new Scene(root);
	private static Core core;

	@Override
	public void start(Stage primaryStage) throws Exception {

		//primaryStage.getIcons().add(new Image(DataControl.ICONE));
		sControl = new ScreenControl(this, core);
		int largeur = 1920;
		int hauteur = 1080;

		primaryStage.setTitle("Maze Solver");

		primaryStage.setMaxWidth(largeur);
		primaryStage.setMaxHeight(hauteur);
		primaryStage.setMinWidth(largeur - 20.0);
		primaryStage.setMinHeight(hauteur - 50.0);

		//primaryStage.setFullScreen(false);


		AccueilPane accueilPane = new AccueilPane(sControl, core);

		

		//scene.getStylesheets().add(DataControl.CSS);
		

		root.getChildren().add(accueilPane);

		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void lancement(String[] args, Core c) {
		core = c;
		InterfacePrincipale.launch(args);
	}
	
	public void setOnTop(Node n) {
		if (currentTopNode != null)
			currentTopNode.setVisible(false);
		n.setVisible(true);
		currentTopNode = n;
	}

	public Scene getScene() {
		return scene;
	}
}
