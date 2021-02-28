package ihm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationPane {
	private static Core c = InterfacePrincipale.getCore();
	static boolean reponse;
	private static int tailleFenetreL = 480;
	private static int tailleFenetreH = 160;

	private static int hBouton = 50;
	private static int lBouton = 200;
	private static String styleBoutons = c.getStyleBouton();
	private static String styleBoutonsSouris = c.getStyleBoutonSouris();

	private static String nomPolice = c.getNomPolice();
	private static Font police = Font.font(nomPolice, FontWeight.BOLD, 27);

	static Button boutonOui;
	static Button boutonNon;

	/**
	 * affiche une fenêtre de confirmation avec un titre et un message personnalisé
	 * 
	 * @param titre   titre de la fenetre
	 * @param message message affiché dans la fenetre
	 * @return
	 */
	public static boolean afficher() {
		Stage window = new Stage();
		window.getIcons().add(new Image(DataControl.ICONE));
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Quitter l'application");

		window.setMaxWidth(tailleFenetreL);
		window.setMaxHeight(tailleFenetreH);
		window.setWidth(tailleFenetreL);
		window.setHeight(tailleFenetreH);
		window.setMinWidth(tailleFenetreL);
		window.setMinHeight(tailleFenetreH);

		// titre
		Label label = new Label();
		label.setText("Êtes-vous sûr de vouloir quitter l'application ?");
		label.setFont(Font.font(nomPolice, FontWeight.BOLD, 20));
		label.setPadding(new Insets(10));
		label.setStyle(c.getCouleurPolice());

		// boutons
		boutonOui = new Button("Quitter");
		boutonOui.setPrefSize(lBouton, hBouton);
		boutonOui.setStyle(c.getStyleBouton());
		// boutonOui.setStyle("-fx-background-color: #ff0000; -fx-background-radius:
		// 5px; -fx-text-fill: #ffffff");
		boutonOui.setFont(police);
		boutonOui.setOnMouseEntered(event -> boutonOui.setStyle(styleBoutonsSouris));
		boutonOui.setOnMouseExited(event -> boutonOui.setStyle(styleBoutons));

		boutonNon = new Button("Annuler");
		boutonNon.setPrefSize(lBouton, hBouton);
		boutonNon.setStyle(c.getStyleBouton());
		// boutonNon.setStyle("-fx-background-color: #A9A9A9; -fx-background-radius:
		// 5px; -fx-text-fill: #ffffff");
		boutonNon.setFont(police);
		boutonNon.setOnMouseEntered(event -> boutonNon.setStyle(styleBoutonsSouris));
		boutonNon.setOnMouseExited(event -> boutonNon.setStyle(styleBoutons));

		boutonOui.setOnAction(e -> {
			reponse = true;
			window.close();
		});

		boutonNon.setOnAction(e -> {
			reponse = false;
			window.close();
		});

		HBox boutonHbox = new HBox(10);
		boutonHbox.getChildren().addAll(boutonNon, boutonOui);
		boutonHbox.setAlignment(Pos.CENTER);

		VBox layout = new VBox(10);
		layout.setAlignment(Pos.TOP_CENTER);
		layout.getChildren().addAll(label, boutonHbox);
		layout.setStyle(c.getCouleurFond());
		Scene scene = new Scene(layout);

		window.setScene(scene);
		window.showAndWait();

		return reponse;
	}
}