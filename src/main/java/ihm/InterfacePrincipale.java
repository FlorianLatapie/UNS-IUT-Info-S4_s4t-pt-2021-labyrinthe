package ihm;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;
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
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				boolean resultat = ConfirmationPane.afficher();
				if (resultat)
					Platform.exit();
				else
					event.consume();
			}
		});
		sControl = new ScreenControl(this, core);

		primaryStage.setTitle("Maze Solver");

		primaryStage.setMaxWidth(core.getMaxLargeur());
		primaryStage.setMaxHeight(core.getMaxHauteur());
		primaryStage.setMinWidth(core.getMinLargeur());
		primaryStage.setMinHeight(core.getMinHauteur());

		AccueilPane accueilPane = new AccueilPane(sControl);

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
	
	public static Core getCore() {
		return core;
	}
}
