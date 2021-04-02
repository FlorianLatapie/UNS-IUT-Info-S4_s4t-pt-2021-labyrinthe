package ihm;

/**
 * 
 * @author florian, remy
 * classe permettant de modifier toutes les valeurs de l'interface graphique
 *
 */
public class Core {
	private String nomPolice = "Segoe UI";
	private String ip = "localhost";

	private final int largeur = 1920;
	private final int hauteur = 1080;

	private final int valeurBlur = 20;
	private final int valeurCoin = 12;
	private final int valeurCoinTitre = 20;

	private final String couleurFond = "-fx-background-color:#DDDDDD;";
	private final String couleurPolice = "-fx-text-fill: #000000";
	private final String couleurPoliceSecondaire = "-fx-text-fill: #ffffff;";

	private final String APBouton = "-fx-background-color:#0070FF;";
	private final String APBoutonSecondaire = "-fx-background-color:#34c6eb;";
	private final String APBoutonSouris = "-fx-background-color:#666666;";
	private final String styleBouton = APBouton + "-fx-background-radius: " + valeurCoin + "px;"
			+ couleurPoliceSecondaire;
	private final String styleBoutonSecondaire = APBoutonSecondaire + "-fx-background-radius: " + valeurCoin + "px;"
			+ couleurPoliceSecondaire;
	private final String styleBoutonSouris = APBoutonSouris + couleurPoliceSecondaire + "-fx-background-radius: "
			+ valeurCoin + "px;";

	private final int lBouton = 200;
	private final int hBouton = 75;

	private final String styleTitre = APBouton + "-fx-background-radius: " + valeurCoinTitre + "px;";
	private final String couleurPoliceTitre = couleurPoliceSecondaire;

	private final int largeurTitre = 425;
	private final int hauteurTitre = 95;

	public int getValeurCoin() {
		return valeurCoin;
	}

	public int getValeurBlur() {
		return valeurBlur;
	}

	public String getCouleurPoliceTitre() {
		return couleurPoliceTitre;
	}

	public String getStyleTitre() {
		return styleTitre;
	}

	public int getlBouton() {
		return lBouton;
	}

	public int gethBouton() {
		return hBouton;
	}

	public int getLargeurTitre() {
		return largeurTitre;
	}

	public int getHauteurTitre() {
		return hauteurTitre;
	}

	public String getStyleBoutonSecondaire() {
		return styleBoutonSecondaire;
	}

	public String getCouleurPolice() {
		return couleurPolice;
	}

	public String getCouleurFond() {
		return couleurFond;
	}

	public String getStyleBouton() {
		return styleBouton;
	}

	public String getStyleBoutonSouris() {
		return styleBoutonSouris;
	}

	public String getNomPolice() {
		return nomPolice;
	}

	public void setNomPolice(String nomPolice) {
		this.nomPolice = nomPolice;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setIP(String string) {
		this.ip = string;

	}

	public String getIP() {
		return this.ip;
	}

}
