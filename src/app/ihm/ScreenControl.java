package app.ihm;

import app.ihm.DataControl.ApplicationPane;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;


public class ScreenControl implements EventHandler<MouseEvent> {
	
	//private final Core core;
	private InterfacePrincipale primary = null;
	private HashMap<ApplicationPane, Node> listNode = new HashMap<>();
	private boolean lock = false;


	public ScreenControl(InterfacePrincipale i, Core core) {
		//this.core = core;
		primary = i;
		primary.getScene().addEventFilter(MouseEvent.ANY, this);
	}

	/**
	 * Enregistre les noeuds (écrans/panneau) qui seront pilotés par le jeu.controleur
	 * de dialogue
	 *
	 * @param s : le nom du noeud, c'est à dire de l'écran (en réalité panneau)
	 * @param n : une référence sur le noeud
	 */
	public void registerNode(ApplicationPane s, Node n) {
		listNode.put(s, n);

	}

	/**
	 * Affiche le conteneur (noeud/écran/panneau) en paramètre
	 *
	 * @param s : le nom du panneau (écran/noeud) que l'on souhaite afficher
	 */
	public void setPaneOnTop(ApplicationPane s) {
		if (listNode.containsKey(s)) {
			primary.setOnTop(listNode.get(s));
		}
		else {
			//TODO mettre une erreur au lieu d'un print 
			System.out.println("pane "+s.toString()+" introuvable");
		}

	}
	

	/**
	 * Consomme les évènement souris qui ont lieu durant une animation pour
	 * permettre à celle-ci d'avoir lieu sans problème.
	 *
	 * @param event :un evènement souris
	 */
	@Override
	public void handle(MouseEvent event) {
		if (lock) {
			event.consume();
		}
	}
}
