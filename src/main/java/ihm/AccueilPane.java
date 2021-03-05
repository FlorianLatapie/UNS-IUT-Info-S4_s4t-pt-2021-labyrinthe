package ihm;

import ihm.DataControl.ApplicationPane;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

public class AccueilPane extends StackPane {
	private ScreenControl sControl = null;
	private Core c = InterfacePrincipale.getCore();
	private final ApplicationPane paneName = ApplicationPane.ACCUEIL;
	private int largeurTitre = c.getLargeurTitre();
	private int hauteurTitre = c.getHauteurTitre();
	private int hBouton = c.gethBouton();
	private int lBouton = c.getlBouton();
	private int marge = 24;
	private Insets margeBoutons = new Insets(marge, marge, marge, marge);
	private String nomPolice = c.getNomPolice();
	private Font policeBouton = Font.font(nomPolice, FontWeight.BOLD, 33);
	private CornerRadii coin = new CornerRadii(c.getValeurCoin());
	private String styleBoutons = c.getStyleBouton();
	private String styleBoutonsSouris = c.getStyleBoutonSouris();
	private GaussianBlur flou = new GaussianBlur(c.getValeurBlur());

	VBox vbTitre;
	VBox vbCentre;
	VBox radioAlignment;
	HBox hbBottom;
	Label titre;
	Label choixAlgo;
	Label vitesse;
	BorderPane bp;
	Button bLancer;
	Button bQuitter;
	RadioButton button1;
	RadioButton button2;
	RadioButton button3;

	public AccueilPane(final ScreenControl sc) {
		sControl = sc;

		bp = new BorderPane();
		bp.setPadding(new Insets(50));

		vbTitre = new VBox();
		vbTitre.setAlignment(Pos.CENTER);

		titre = new Label("Le labyrinthe");
		titre.setFont(Font.font(nomPolice, FontWeight.BOLD, 60));
		titre.setStyle(c.getCouleurPoliceTitre());

		vbTitre.getChildren().add(titre);
		vbTitre.setStyle(c.getStyleTitre());
		
		vbTitre.setPrefWidth(largeurTitre);
		vbTitre.setPrefHeight(hauteurTitre);
		vbTitre.setMinWidth(largeurTitre);
		vbTitre.setMinHeight(hauteurTitre);
		vbTitre.setMaxWidth(largeurTitre);
		vbTitre.setMaxHeight(hauteurTitre);

		vbCentre = new VBox();
		vbCentre.setAlignment(Pos.CENTER);
		vbCentre.setSpacing(50);

		choixAlgo = new Label("Choisir un algorithme");
		choixAlgo.setFont(Font.font(nomPolice, FontWeight.BOLD, 45));
		choixAlgo.setStyle(c.getCouleurPolice());

		ToggleGroup group = new ToggleGroup();

		radioAlignment = new VBox();
		radioAlignment.setAlignment(Pos.CENTER_LEFT);
		radioAlignment.setTranslateX(800);
		radioAlignment.setSpacing(20);

		button1 = new RadioButton("Aléatoire");
		button1.setToggleGroup(group);
		button1.setSelected(true);
		button1.setStyle(c.getCouleurPolice());
		radioAlignment.getChildren().add(button1);

		button2 = new RadioButton("Mur de gauche");
		button2.setToggleGroup(group);
		button2.setStyle(c.getCouleurPolice());
		radioAlignment.getChildren().add(button2);

		button3 = new RadioButton("Mur de droite");
		button3.setToggleGroup(group);
		button3.setStyle(c.getCouleurPolice());
		radioAlignment.getChildren().add(button3);

		vitesse = new Label("Choix de la vitesse");
		vitesse.setFont(Font.font(nomPolice, FontWeight.BOLD, 45));
		vitesse.setStyle(c.getCouleurPolice());

		Slider slider = new Slider(1, 3, 1);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(1);
		slider.setBlockIncrement(1);
		slider.setValue(2);
		slider.setMaxWidth(500);
		slider.setStyle(c.getCouleurPolice());

		vbCentre.getChildren().addAll(choixAlgo, radioAlignment, vitesse, slider);

		hbBottom = new HBox();
		hbBottom.setAlignment(Pos.CENTER);
		hbBottom.setSpacing(300);

		bLancer = new Button("LANCER");
		bLancer.setPrefSize(lBouton, hBouton);
		bLancer.setMinSize(lBouton, hBouton);
		bLancer.setFont(policeBouton);
		bLancer.setStyle(styleBoutons);
		bLancer.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				bLancer.setStyle(styleBoutonsSouris);
			}
		});
		bLancer.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				bLancer.setStyle(styleBoutons);
			}
		});
		bLancer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent EventHandler) {
				sc.setPaneOnTop(ApplicationPane.ROBOT);
			}
		});

		bQuitter = new Button("QUITTER");
		bQuitter.setPrefSize(lBouton, hBouton);
		bQuitter.setMinSize(lBouton, hBouton);
		bQuitter.setFont(policeBouton);
		bQuitter.setStyle(styleBoutons);
		bQuitter.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				bQuitter.setStyle(styleBoutonsSouris);
			}
		});
		bQuitter.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				bQuitter.setStyle(styleBoutons);
			}
		});
		bQuitter.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				boolean resultat = ConfirmationPane.afficher();
				if (resultat) {
					Platform.exit();
					System.exit(0);
				}
			}
		});

		hbBottom.getChildren().addAll(bQuitter, bLancer);
		bp.setAlignment(vbTitre, Pos.CENTER);
		bp.setTop(vbTitre);
		bp.setCenter(vbCentre);
		bp.setBottom(hbBottom);
		
		ImageView imgFond = new ImageView(DataControl.FOND);
		imgFond.setEffect(flou);

		this.getChildren().addAll(imgFond,bp);

		sControl.registerNode(paneName, this);
		sControl.setPaneOnTop(paneName);

	}
}

