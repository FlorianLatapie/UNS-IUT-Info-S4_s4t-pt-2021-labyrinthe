package app;

import app.ihm.Core;
import app.ihm.InterfacePrincipale;

public class App {
	public static void main(String[] args) {
		Core c = new Core();
		InterfacePrincipale.lancement(args,c);
		System.out.println("hello world");
	}
}