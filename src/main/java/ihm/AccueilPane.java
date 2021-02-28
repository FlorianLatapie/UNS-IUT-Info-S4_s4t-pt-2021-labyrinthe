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


public class AccueilPane extends StackPane{
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

	VBox vbTitre;
	VBox vbCentre;
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

	public AccueilPane(ScreenControl sc) {
		sControl = sc;

		bp = new BorderPane();
		bp.setPadding(new Insets(50));
		
		vbTitre = new VBox();
		vbTitre.setAlignment(Pos.CENTER);
	
		titre = new Label("Le labyrinthe");
		titre.setFont(Font.font(nomPolice, FontWeight.BOLD, 45));
		titre.setTextFill(Color.BLACK);
		
		vbTitre.getChildren().add(titre);
		
		vbCentre = new VBox();
		vbCentre.setAlignment(Pos.CENTER);
		vbCentre.setSpacing(50);
		
		choixAlgo = new Label("Choisir un algorithme");
		choixAlgo.setFont(Font.font(nomPolice, FontWeight.BOLD, 45));
		choixAlgo.setTextFill(Color.BLACK);
		
		ToggleGroup group = new ToggleGroup();
		
		button1 = new RadioButton("Aléatoire");
		button1.setToggleGroup(group);
		button1.setSelected(true);
		
		button2 = new RadioButton("Mur de gauche");
		button2.setToggleGroup(group);
		
		button3 = new RadioButton("Mur de droite");
		button3.setToggleGroup(group);
		
		vitesse = new Label("Choix de la vitesse");
		vitesse.setFont(Font.font(nomPolice, FontWeight.BOLD, 45));
		vitesse.setTextFill(Color.BLACK);
		
		Slider slider = new Slider(1, 3, 1);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(1);
		slider.setBlockIncrement(1);
		slider.setValue(2);
		vbCentre.getChildren().addAll(choixAlgo, button1, button2, button3, vitesse, slider);
		
		hbBottom = new HBox();
		hbBottom.setAlignment(Pos.CENTER);
		hbBottom.setSpacing(300);

		
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
			boolean resultat = ConfirmationPane.afficher();
			if (resultat) {
				Platform.exit();
				System.exit(0);
			}
		});
		
		hbBottom.getChildren().addAll(bQuitter, bLancer);

		bp.setTop(vbTitre);
		bp.setCenter(vbCentre);
		bp.setBottom(hbBottom);
		
		Line line = new Line(960, 50, 960, 1030);
		

		this.getChildren().addAll(bp);

		sControl.registerNode(paneName, this);
		sControl.setPaneOnTop(paneName);

	}
}
