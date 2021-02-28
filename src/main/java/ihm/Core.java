package ihm;


public class Core {
	private final int maxLargeur = 1920;
	private final int minLargeur = 1920;
	private final int maxHauteur = 1080;
	private final int minHauteur = 1080;
	private String styleBouton = " -fx-background-color:#5234eb; -fx-background-radius: 15px; -fx-text-fill: #ffffff";
	private String styleBoutonSouris = "-fx-background-color:#34c6eb;  -fx-text-fill:#ffffff; -fx-background-radius: 15px;";
	
	public String getStyleBouton() {
		return styleBouton;
	}

	public void setStyleBouton(String styleBouton) {
		this.styleBouton = styleBouton;
	}

	public String getStyleBoutonSouris() {
		return styleBoutonSouris;
	}

	public void setStyleBoutonSouris(String styleBoutonSouris) {
		this.styleBoutonSouris = styleBoutonSouris;
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
