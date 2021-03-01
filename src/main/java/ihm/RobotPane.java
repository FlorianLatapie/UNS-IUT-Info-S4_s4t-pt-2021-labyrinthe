package ihm;

import ihm.DataControl.ApplicationPane;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RobotPane extends StackPane {
	private ScreenControl sControl = null;
	private Core c = InterfacePrincipale.getCore();
	private final ApplicationPane paneName = ApplicationPane.ROBOT;
	private int hBouton = c.gethBouton();
	private int lBouton = c.getlBouton();
	private int largeurTitre = c.getLargeurTitre();
	private int hauteurTitre = c.getHauteurTitre();
	private int marge = 50;
	private int margeDivider = (int) (marge*2.5);
	private String nomPolice = c.getNomPolice();
	private Font policeBouton = Font.font(nomPolice, FontWeight.BOLD, 33);
	private CornerRadii coin = new CornerRadii(15.0);
	private String styleBoutons = c.getStyleBouton();
	private String styleBoutonsSouris = c.getStyleBoutonSouris();
	private GaussianBlur flou = new GaussianBlur(c.getValeurBlur());

	VBox vbCentreG;
	VBox vbTitre;
	HBox hbBottom;
	Label titre;
	BorderPane bpG;
	BorderPane bpD;
	Button bQuitter;

	public RobotPane(ScreenControl sc) {
		sControl = sc;

		titre = new Label("Le labyrinthe");
		titre.setFont(Font.font(nomPolice, FontWeight.BOLD, 60));
		titre.setStyle(c.getCouleurPoliceTitre());
		titre.setAlignment(Pos.CENTER);

		vbTitre = new VBox();
		vbTitre.getChildren().add(titre);
		vbTitre.setTranslateY(-(c.getMaxLargeur()/4));
		vbTitre.setAlignment(Pos.CENTER);
		vbTitre.setStyle(c.getStyleTitre());
		
		vbTitre.setPrefWidth(largeurTitre);
		vbTitre.setPrefHeight(hauteurTitre);
		vbTitre.setMinWidth(largeurTitre);
		vbTitre.setMinHeight(hauteurTitre);
		vbTitre.setMaxWidth(largeurTitre);
		vbTitre.setMaxHeight(hauteurTitre);
		

		bpG = new BorderPane();
		bpG.setMinSize(c.getMinLargeur()/2, c.getMinHauteur());
		bpG.setMaxSize(c.getMaxLargeur()/2, c.getMinHauteur());
		bpG.setPrefSize(c.getMaxLargeur()/2, c.getMinHauteur());
		bpG.setTranslateX(-(c.getMaxLargeur()/4));
		bpG.setPadding(new Insets(marge));

		vbCentreG = new VBox();
		vbCentreG.setAlignment(Pos.CENTER);
		vbCentreG.setSpacing(marge);
		vbCentreG.getChildren().addAll();

		hbBottom = new HBox();
		hbBottom.setAlignment(Pos.CENTER);
		hbBottom.setSpacing(300);

		bQuitter = new Button("QUITTER");
		bQuitter.setPrefSize(lBouton, hBouton);
		bQuitter.setMinSize(lBouton, hBouton);
		bQuitter.setFont(policeBouton);
		bQuitter.setStyle(styleBoutons);
		bQuitter.setOnMouseEntered(event -> bQuitter.setStyle(styleBoutonsSouris));
		bQuitter.setOnMouseExited(event -> bQuitter.setStyle(styleBoutons));
		bQuitter.setOnAction(event -> {
			boolean resultat = ConfirmationPane.afficher();
			if (resultat) {
				Platform.exit();
				System.exit(0);
			}
		});

		hbBottom.getChildren().addAll(bQuitter);
		bpG.setCenter(vbCentreG);
		bpG.setBottom(hbBottom);

		Line line = new Line(c.getMaxLargeur()/2, margeDivider, c.getMaxLargeur()/2, c.getMaxHauteur()-margeDivider);
		line.setStrokeWidth(marge/10);

		bpD = new BorderPane();
		bpD.setMinSize(c.getMinLargeur()/2, c.getMinHauteur());
		bpD.setMaxSize(c.getMaxLargeur()/2, c.getMinHauteur());
		bpD.setPrefSize(c.getMaxLargeur()/2, c.getMinHauteur());
		bpD.setTranslateX((c.getMaxLargeur()/4));
		bpD.setPadding(new Insets(marge));
		
		
		
		ImageView imgFond = new ImageView(DataControl.FOND);
		imgFond.setEffect(flou);

		this.getChildren().addAll(imgFond,vbTitre, bpG, line, bpD);

		sControl.registerNode(paneName, this);
		sControl.setPaneOnTop(paneName);

	}
}
