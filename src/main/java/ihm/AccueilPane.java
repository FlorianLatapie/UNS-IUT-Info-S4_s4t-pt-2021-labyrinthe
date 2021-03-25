package ihm;

import javafx.scene.control.TextField;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import raspberry.reseau.StaticProtocolMessages;
import raspberry.reseaupc.ClientPC;

public class AccueilPane extends StackPane implements IAccueilPane{
	private ScreenControl sControl = null;
	private Core c = InterfacePrincipale.getCore();
	private static final ApplicationPane paneName = ApplicationPane.ACCUEIL;
	private int largeurTitre = c.getLargeurTitre();
	private int hauteurTitre = c.getHauteurTitre();
	private int hauteurTF = 50;
	private int hBouton = c.gethBouton();
	private int lBouton = c.getlBouton();
	private String nomPolice = c.getNomPolice();
	private double tailleSousTitre = 45;
	private Font policeBouton = Font.font(nomPolice, FontWeight.BOLD, 33);
	private String styleBoutons = c.getStyleBouton();
	private String styleBoutonsSouris = c.getStyleBoutonSouris();
	private GaussianBlur flou = new GaussianBlur(c.getValeurBlur());
	private String algoSelected = "";

	VBox vbTitre;
	VBox vbCentre;
	VBox radioAlignment;
	HBox hbBottom;
	Label titre;
	
	Label choixAlgo;
	Label vitesse;
	Label reglageRobot;
	
	TextField reglageAvancer;
	TextField reglageTourner;
	TextField reglageGauche;
	TextField reglageDroit;
	
	Label titreRAvancer;
	Label titreRTourner;
	Label titreRGauche;
	Label titreRDroit;
	
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

		titre = new Label(DataControl.TITRE);
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
		vbCentre.setSpacing(10);

		
		// choix algo 
		
		choixAlgo = new Label("Choisir un algorithme");
		choixAlgo.setFont(Font.font(nomPolice, FontWeight.BOLD, tailleSousTitre));
		choixAlgo.setStyle(c.getCouleurPolice());

		final ToggleGroup group = new ToggleGroup();

		radioAlignment = new VBox();
		radioAlignment.setAlignment(Pos.CENTER_LEFT);
		radioAlignment.setTranslateX(800);
		radioAlignment.setSpacing(20);

		button1 = new RadioButton("Mur de droite");
		button1.setToggleGroup(group);
		button1.setSelected(true);
		button1.setStyle(c.getCouleurPolice());
		radioAlignment.getChildren().add(button1);

		button2 = new RadioButton("Treaux");
		button2.setToggleGroup(group);
		button2.setStyle(c.getCouleurPolice());
		radioAlignment.getChildren().add(button2);

		button3 = new RadioButton("Mur de gauche");
	//	button3.setToggleGroup(group);
		button3.setStyle(c.getCouleurPolice());
	//	radioAlignment.getChildren().add(button3);

		
		// choix de la vitesse 
		
		vitesse = new Label("Choix de la vitesse");
		vitesse.setFont(Font.font(nomPolice, FontWeight.BOLD, tailleSousTitre));
		vitesse.setStyle(c.getCouleurPolice());

		Slider slider = new Slider(1, 3, 1);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(1);
		slider.setBlockIncrement(1);
		slider.setValue(2);
		slider.setMaxWidth(500);
		slider.setStyle(c.getCouleurPolice());
		
		// réglage robot 
		
		reglageRobot = new Label("Réglages du Robot");
		reglageRobot.setFont(Font.font(nomPolice, FontWeight.BOLD, tailleSousTitre));
		reglageRobot.setStyle(c.getCouleurPolice());
		
		reglageAvancer = new TextField();
		reglageAvancer.setMinHeight(hauteurTF);
		reglageTourner = new TextField();
		reglageTourner.setMinHeight(hauteurTF);
		reglageGauche = new TextField();
		reglageGauche.setMinHeight(hauteurTF);
		reglageDroit = new TextField();
		reglageDroit.setMinHeight(hauteurTF);
		
		titreRAvancer = new Label("Distance avancer/reculer");
		titreRAvancer.setStyle(c.getCouleurPolice());
		titreRAvancer.setFont(Font.font(nomPolice, 30));
		
		titreRTourner = new Label("Angle gauche/droite");
		titreRTourner.setStyle(c.getCouleurPolice());
		titreRTourner.setFont(Font.font(nomPolice, 30));
		
		titreRGauche = new Label("Trim gauche");
		titreRGauche.setStyle(c.getCouleurPolice());
		titreRGauche.setFont(Font.font(nomPolice, 30));
		titreRGauche.setPadding(new Insets(30,0,0,0));
		
		titreRDroit = new Label("Trim droit");
		titreRDroit.setStyle(c.getCouleurPolice());
		titreRDroit.setFont(Font.font(nomPolice, 30));
		titreRDroit.setPadding(new Insets(30,0,0,0));

		
		
		GridPane gpReglages = new GridPane();
		gpReglages.setAlignment(Pos.CENTER);
		gpReglages.setHgap(10);
		gpReglages.setVgap(10);
		
		gpReglages.add(titreRAvancer, 0, 0);
		gpReglages.add(titreRTourner, 1, 0);
		gpReglages.add(reglageAvancer, 0, 1);
		gpReglages.add(reglageTourner, 1, 1);
		gpReglages.add(titreRGauche, 0, 2);
		gpReglages.add(titreRDroit, 1, 2);
		gpReglages.add(reglageGauche, 0, 3);
		gpReglages.add(reglageDroit, 1, 3);
		

		vbCentre.getChildren().addAll(choixAlgo, radioAlignment, vitesse, slider, reglageRobot,gpReglages);

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
			public void handle(ActionEvent event) {
				sc.setPaneOnTop(ApplicationPane.ROBOT);
				algoSelected = getAlgoSelected(group.getSelectedToggle().toString());
				
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
		BorderPane.setAlignment(vbTitre, Pos.CENTER);
		bp.setTop(vbTitre);
		bp.setCenter(vbCentre);
		bp.setBottom(hbBottom);
		
		ImageView imgFond = new ImageView(DataControl.FOND);
		imgFond.setEffect(flou);

		this.getChildren().addAll(imgFond,bp);

		sControl.registerNode(paneName, this);
		sControl.setPaneOnTop(paneName);

	}
	
	
	public String getAlgoSelected(String input) {
		switch(input.split("'")[1]) {
		case "Mur de droite":
			return StaticProtocolMessages.ALGO_MUR_DROIT;
		case "Tremaux":
			return StaticProtocolMessages.ALGO_TREMAUX;
		default:
			return StaticProtocolMessages.ALGO_MUR_DROIT;
		}
	}
	
	@Override
	public String getAttAlgoSelected() {
		return StaticProtocolMessages.ENTETE_ALGO+this.algoSelected;
	}
}

