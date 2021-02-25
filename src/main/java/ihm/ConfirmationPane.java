package ihm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ConfirmationPane {
	static boolean reponse;
	private static int tailleFenetreL = 500;
	private static int tailleFenetreH = 190;
	private static String nomPolice = "Segoe UI";
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
	public static boolean afficher(String titre, String message) {
		Stage window = new Stage();
		//window.getIcons().add(new Image(DataControl.ICONE));
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(titre);

		window.setMaxWidth(tailleFenetreL);
		window.setMaxHeight(tailleFenetreH);
		window.setWidth(tailleFenetreL);
		window.setHeight(tailleFenetreH);
		window.setMinWidth(tailleFenetreL);
		window.setMinHeight(tailleFenetreH);

		// titre
		Label labelL1 = new Label();
		labelL1.setText(message);
		labelL1.setStyle("-fx-text-fill: #DDDDDD");
		labelL1.setFont(Font.font(nomPolice, FontWeight.BOLD, 20));
		labelL1.setPadding(new Insets(10, 10, 0, 10));

		// boutons
		boutonOui = new Button("Quitter");
		boutonOui.setPrefSize(200, 50);
		boutonOui.setStyle("-fx-background-color: #ff0000; -fx-background-radius: 5px; -fx-text-fill: #ffffff");
		boutonOui.setFont(police);

		boutonNon = new Button("Annuler");
		boutonNon.setPrefSize(200, 50);
		boutonNon.setStyle("-fx-background-color: #A9A9A9; -fx-background-radius: 5px; -fx-text-fill: #ffffff");
		boutonNon.setFont(police);

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
		boutonHbox.setPadding(new Insets(10));

		VBox layout = new VBox(10);
		layout.setAlignment(Pos.TOP_CENTER);
		layout.getChildren().addAll(labelL1, boutonHbox);
		layout.setStyle(" -fx-background-color: #1F1F1F;");
		Scene scene = new Scene(layout);

		window.setScene(scene);
		window.showAndWait();

		return reponse;
	}
}