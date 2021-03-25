package app;

import ihm.Core;
import ihm.InterfacePrincipale;

public class App {
	public static void main(String[] args) {
		Core c = new Core();
		if (args.length != 1) {
			System.out.println("Aucune ip entrée, lancement sur localhost");
			c.setIP("locahost");
		} else {
			c.setIP(args[0]);
		}
		InterfacePrincipale.lancement(args, c);
	}
}