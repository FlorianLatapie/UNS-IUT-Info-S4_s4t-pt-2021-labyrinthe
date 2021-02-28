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


public class RobotPane extends StackPane{
	private ScreenControl sControl = null;
	private Core core = InterfacePrincipale.getCore();
	private final ApplicationPane paneName = ApplicationPane.ROBOT;
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


	VBox vbCentreG;
	HBox hbBottom;
	Label titre;
	BorderPane bpG;
	BorderPane bpD;
	Button bQuitter;
    
	public RobotPane(ScreenControl sc) {
		sControl = sc;

		titre = new Label("Le labyrinthe");
		titre.setTranslateY(-480);
		titre.setFont(Font.font(nomPolice, FontWeight.BOLD, 45));
		titre.setTextFill(Color.BLACK);
		
		bpG = new BorderPane();
		bpG.setMinSize(960, 1080);
		bpG.setMaxSize(960, 1080);
		bpG.setPrefSize(960, 1080);
		bpG.setTranslateX(-480);
		bpG.setPadding(new Insets(50));
		
		
		vbCentreG = new VBox();
		vbCentreG.setAlignment(Pos.CENTER);
		vbCentreG.setSpacing(50);
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
		
		Line line = new Line(960, 270, 960, 1150);
		
		bpD = new BorderPane();
		bpD.setMinSize(960, 1080);
		bpD.setMaxSize(960, 1080);
		bpD.setPrefSize(960, 1080);
		bpD.setTranslateX(480);
		bpD.setPadding(new Insets(50));
		

		this.getChildren().addAll(titre, bpG, line, bpD);

		sControl.registerNode(paneName, this);
		sControl.setPaneOnTop(paneName);

	}
}
