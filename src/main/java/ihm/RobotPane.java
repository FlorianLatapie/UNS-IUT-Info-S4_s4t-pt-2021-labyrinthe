package ihm;

import java.util.ArrayList;

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

public class RobotPane extends StackPane {
	private ScreenControl sControl = null;
	private Core c = InterfacePrincipale.getCore();
	private final ApplicationPane paneName = ApplicationPane.ROBOT;
	private int hBouton = c.gethBouton();
	private int lBouton = c.getlBouton();
	private int largeurTitre = c.getLargeurTitre();
	private int hauteurTitre = c.getHauteurTitre();
	private int marge = 50;
	private int margeTitre = 150;
	private int margeDivider = (int) (marge*2.5);
	private String nomPolice = c.getNomPolice();
	private Font policeBouton = Font.font(nomPolice, FontWeight.BOLD, 33);
	private CornerRadii coin = new CornerRadii(c.getValeurCoin());
	private String styleBoutons = c.getStyleBouton();
	private String styleBoutonsSouris = c.getStyleBoutonSouris();
	private GaussianBlur flou = new GaussianBlur(c.getValeurBlur());
	private String[][] matriceLaby = {{ "C","DLH","DLH","DLH", "AHD"},
			   						  {null, null, null, null, "DLV"},
			   						  {null, null, null, null, "DLV"},
			   						  {null, null, null, null, "DLV"},
			   						  {null, null, null, null, "C" }};


	VBox vbCentreG;
	VBox vbTitre;
	VBox hbtitreD;
	VBox hbtitreG;
	HBox hbBottom;
	Label titre;
	Label titreD;
	Label titreG;
	BorderPane bpG;
	BorderPane bpD;
	Button bQuitter;
	GridPane gp;
	ImageView[][] matriceImg  = new ImageView[5][5];

	public RobotPane(ScreenControl sc) {
		sControl = sc;
		
	
		for(int i = 0; i< matriceImg.length; i++) {
			for(int j = 0; j < matriceImg.length; j++) {
				matriceImg[i][j] = new ImageView(buildMatrice(matriceLaby[i][j]));
			}
		}
		
		
		titre = new Label("Le labyrinthe");
		titre.setFont(Font.font(nomPolice, FontWeight.BOLD, 60));
		titre.setStyle(c.getCouleurPoliceTitre());
		titre.setAlignment(Pos.CENTER);

		vbTitre = new VBox();
		vbTitre.getChildren().add(titre);
		vbTitre.setTranslateY(-(c.getLargeur()/4));
		vbTitre.setAlignment(Pos.CENTER);
		vbTitre.setStyle(c.getStyleTitre());
		
		vbTitre.setPrefWidth(largeurTitre);
		vbTitre.setPrefHeight(hauteurTitre);
		vbTitre.setMinWidth(largeurTitre);
		vbTitre.setMinHeight(hauteurTitre);
		vbTitre.setMaxWidth(largeurTitre);
		vbTitre.setMaxHeight(hauteurTitre);

		titreG = new Label("Position du robot dans le labyrinthe");
		titreG.setFont(Font.font(nomPolice, FontWeight.BOLD, 30));
		titreG.setStyle(c.getCouleurPoliceTitre());
		titreG.setAlignment(Pos.CENTER);

		hbtitreG = new VBox();
		hbtitreG.getChildren().add(titreG);
		hbtitreG.setAlignment(Pos.CENTER);
		hbtitreG.setStyle(c.getStyleTitre());
		hbtitreG.setPadding(new Insets(10));

		bpG = new BorderPane();
		bpG.setMinSize(c.getLargeur()/2, c.getHauteur());
		bpG.setMaxSize(c.getLargeur()/2, c.getHauteur());
		bpG.setPrefSize(c.getLargeur()/2, c.getHauteur());
		bpG.setTranslateX(-(c.getLargeur()/4));
		bpG.setPadding(new Insets(margeTitre, margeTitre, marge, margeTitre));
		bpG.setTop(hbtitreG);
		bpG.setAlignment(hbtitreG,Pos.CENTER);
		
		
		gp = new GridPane();
		for(int i = 0; i<matriceImg.length; i++) {
			for(int j = 0; j<matriceImg.length; j++) {
				gp.setConstraints(matriceImg[i][j], j, i);
				gp.getChildren().add(matriceImg[i][j]);
			}
		}
		
		hbBottom = new HBox();
		hbBottom.setAlignment(Pos.CENTER);
		hbBottom.setSpacing(300);

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

		hbBottom.getChildren().addAll(bQuitter);
		bpG.setCenter(gp);
		bpG.setBottom(hbBottom);

		Line line = new Line(c.getLargeur()/2, margeDivider, c.getLargeur()/2, c.getHauteur()-margeDivider);
		line.setStrokeWidth(marge/10);

		titreD = new Label("Représentation du labyrinthe");
		titreD.setFont(Font.font(nomPolice, FontWeight.BOLD, 30));
		titreD.setStyle(c.getCouleurPoliceTitre());
		titreD.setAlignment(Pos.CENTER);

		hbtitreD = new VBox();
		hbtitreD.getChildren().add(titreD);
		hbtitreD.setAlignment(Pos.CENTER);
		hbtitreD.setStyle(c.getStyleTitre());
		hbtitreD.setPadding(new Insets(10));

		bpD = new BorderPane();
		bpD.setMinSize(c.getLargeur()/2, c.getHauteur());
		bpD.setMaxSize(c.getLargeur()/2, c.getHauteur());
		bpD.setPrefSize(c.getLargeur()/2, c.getHauteur());
		bpD.setTranslateX((c.getLargeur()/4));
		bpD.setPadding(new Insets(margeTitre));
		bpD.setTop(hbtitreD);
		bpD.setAlignment(hbtitreD, Pos.CENTER);
		
		ImageView imgFond = new ImageView(DataControl.FOND);
		imgFond.setEffect(flou);

		this.getChildren().addAll(imgFond,vbTitre, bpG, line, bpD);

		sControl.registerNode(paneName, this);
		sControl.setPaneOnTop(paneName);
	}
	
	public String buildMatrice(String val) {
		if(val != null){
			switch(val) {
				case "DLV": 
					return DataControl.DLIGNE_VERT;
				case "DLH": 
					return DataControl.DLIGNE_HOR;
				case "AHG": 
					return DataControl.ANGLE_HAUT_GAUCHE;
				case "AHD": 
					return DataControl.ANGLE_HAUT_DROITE;
				case "ABG": 
					return DataControl.ANGLE_BAS_GAUCHE;
				case "ABD": 
					return DataControl.ANGLE_BAS_DROITE;
				case "LH": 
					return DataControl.LIGNE_HAUT;
				case "LG": 
					return DataControl.LIGNE_GAUCHE;
				case "LD":
					return DataControl.LIGNE_DROITE;
				case "LB": 
					return DataControl.LIGNE_BAS;
				case "C": 
					return DataControl.CARRE;
				default:
					return DataControl.CARRE;			
			}
		}
		return DataControl.CARRE;
	}
	
}
