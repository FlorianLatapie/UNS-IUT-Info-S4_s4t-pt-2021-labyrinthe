package ihm;


public class Core {
	private final int maxLargeur = 1920;
	private final int minLargeur = 500;
	private final int maxHauteur = 1080;
	private final int minHauteur = 500;
	private String styleBouton = " -fx-background-color:#000000; -fx-background-radius: 15px; -fx-text-fill: #ffffff";
	private String styleBoutonSouris = "-fx-background-color:#ff0000;  -fx-text-fill:#000000; -fx-background-radius: 15px;";
	private String nomPolice = "Segoe UI";
	
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
