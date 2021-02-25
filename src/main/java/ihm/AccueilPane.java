package ihm;


import ihm.DataControl.ApplicationPane;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class AccueilPane extends VBox{
	private ScreenControl sControl = null;
	private Core core = InterfacePrincipale.getCore();
	private final ApplicationPane paneName = ApplicationPane.ACCUEIL;

	private int hBouton = 100;
	private int lBouton = 200;
	private int marge = 24;
	private Insets margeBoutons = new Insets(marge, marge, marge, marge);

	private String nomPolice = core.getNomPolice();
	private Font policeBouton = Font.font(nomPolice, FontWeight.BOLD, 33);

	private CornerRadii coin = new CornerRadii(15.0);

	private String styleBoutons = core.getStyleBouton();
	private String styleBoutonsSouris = core.getStyleBoutonSouris();

	private GaussianBlur flou = new GaussianBlur(30);

	VBox centreMenu;
	Label titre1;
	Label titre2;
	Button bLancer;
	Button bQuitter;

	public AccueilPane(ScreenControl sc) {
		sControl = sc;

		titre1 = new Label("Maze Solver");
		titre1.setFont(Font.font(nomPolice, FontWeight.BOLD, 25));
		titre1.setTextFill(Color.BLACK);


		VBox titre = new VBox(titre1);
		titre.setAlignment(Pos.CENTER);
		titre.setBackground(new Background(new BackgroundFill(Color.BLUE, coin, null)));
		
		bLancer = new Button("LANCER");
		bLancer.setPrefSize(lBouton, hBouton);
		bLancer.setMinSize(lBouton, hBouton);
		bLancer.setFont(policeBouton);
		bLancer.setStyle(styleBoutons);

		bLancer.setOnMouseEntered(event -> bLancer.setStyle(styleBoutonsSouris));
		bLancer.setOnMouseExited(event -> bLancer.setStyle(styleBoutons));
		
		
		bQuitter = new Button("QUITTER");
		bQuitter.setPrefSize(lBouton, hBouton);
		bQuitter.setMinSize(lBouton, hBouton);
		bQuitter.setFont(policeBouton);
		bQuitter.setStyle(styleBoutons);

		bQuitter.setOnMouseEntered(event -> bQuitter.setStyle(styleBoutonsSouris));
		bQuitter.setOnMouseExited(event -> bQuitter.setStyle(styleBoutons));
		bQuitter.setOnAction(event -> {
			boolean resultat = ConfirmationPane.afficher("quitter l'main.java.app","etes vous surs de quitter ?");
			if (resultat) {
				Platform.exit();
				System.exit(0);
			}
		});

		// image fond
		//ImageView imgFond = new ImageView(DataControl.FOND);

		// boite du fond qui contient l'image et les autres boites
		HBox fond = new HBox();
		fond.setAlignment(Pos.CENTER);
		fond.setPrefWidth(100);
		fond.setPrefHeight(100);
		fond.setEffect(flou);
		//fond.getChildren().add(imgFond);

		this.getChildren().addAll(/*imgFond,*/fond, titre, bLancer,bQuitter);
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));

		sControl.registerNode(paneName, this);
		sControl.setPaneOnTop(paneName);

	}
}
