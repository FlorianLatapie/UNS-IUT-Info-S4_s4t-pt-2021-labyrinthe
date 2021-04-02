package raspberry.algo;

public class RecommandationAlgo {
	/**
	 * Utilisation du pattern Strategy.
	 * Cette classe permet d'appeller un algorithme sans avoir besoin d'appeler directement l'algorithme en choisissant un algorithme.
	 */

	private AlgoStrategy algoStrategy = new AlgoSuivreMurDeDroite();

	public void changerStrategy(AlgoStrategy strategy) {
		this.algoStrategy = strategy;
	}

	public AlgoStrategy getAlgoStrategy() {
		return algoStrategy;
	}

	public void setAlgoStrategy(AlgoStrategy algoStrategy) {
		this.algoStrategy = algoStrategy;
	}

	public String executer(String capteur) {
		return algoStrategy.executer(capteur);
	}
}
