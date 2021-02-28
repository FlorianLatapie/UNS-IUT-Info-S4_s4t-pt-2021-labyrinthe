package ihm;

import com.sun.prism.paint.Color;

public class Core {
	private final int maxLargeur = 1920;
	private final int minLargeur = 1920;
	private final int maxHauteur = 1080;
	private final int minHauteur = 1080;
	
	private final String APBouton = "-fx-background-color:#5234eb;";
	private final String APBoutonSouris = "-fx-background-color:#34c6eb;";
	private final String styleBouton = APBouton+"-fx-background-radius: 15px; -fx-text-fill: #ffffff";
	private final String styleBoutonSouris = APBoutonSouris+"-fx-text-fill:#ffffff; -fx-background-radius: 15px;";
	
	private final String couleurFond = "-fx-background-color:#FFFFFF;";
	private final String couleurPolice = "-fx-text-fill: #000000";
	private final Color couleurPoliceColor = Color.BLACK;
	
	public Color getCouleurPoliceColor() {
		return couleurPoliceColor;
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

	public int getMaxLargeur() {
		return maxLargeur;
	}

	public int getMinLargeur() {
		return minLargeur;
	}

	public int getMaxHauteur() {
		return maxHauteur;
	}

	public int getMinHauteur() {
		return minHauteur;
	}
	
	

	

	
	
	
}
