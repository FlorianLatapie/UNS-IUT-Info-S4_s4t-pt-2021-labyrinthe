package ihm;

import com.sun.prism.paint.Color;

public class Core {
	private final int largeur = 1920;
	private final int hauteur = 1080;
	
	private final String couleurFond = "-fx-background-color:#DDDDDD;";
	private final String couleurPolice = "-fx-text-fill: #000000";
	private final String couleurPoliceSecondaire = "-fx-text-fill: #ffffff;";
	
	private final String APBouton = "-fx-background-color:#5234eb;";
	private final String APBoutonSecondaire = "-fx-background-color:#34c6eb;";
	private final String APBoutonSouris = "-fx-background-color:#1c1c1c;";
	private final String styleBouton = APBouton + "-fx-background-radius: 15px;"+couleurPoliceSecondaire;
	private final String styleBoutonSecondaire = APBoutonSecondaire
			+ "-fx-background-radius: 15px;"+couleurPoliceSecondaire;
	private final String styleBoutonSouris = APBoutonSouris + couleurPoliceSecondaire + "-fx-background-radius: 15px;";

	private final int lBouton = 200;
	private final int hBouton = 75;

	private final String styleTitre = APBouton + "-fx-background-radius: 7px;";
	private final String couleurPoliceTitre = couleurPoliceSecondaire;

	private final int largeurTitre = 425;
	private final int hauteurTitre = 95;
	
	private final int valeurBlur = 20;

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

	public void setStyleBouton(String styleBouton) {
		styleBouton = styleBouton;
	}

	public String getStyleBoutonSouris() {
		return styleBoutonSouris;
	}

	public void setStyleBoutonSouris(String styleBoutonSouris) {
		styleBoutonSouris = styleBoutonSouris;
	}

	private String nomPolice = "Segoe UI";

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

}
