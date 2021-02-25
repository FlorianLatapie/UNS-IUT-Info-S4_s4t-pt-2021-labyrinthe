package app;

import ihm.Core;
import ihm.InterfacePrincipale;

public class App {
	public static void main(String[] args) {
		Core c = new Core();
		InterfacePrincipale.lancement(args,c);
		System.out.println("hello world");
	}
}