package lego;

import lejos.hardware.Button;

public class LegoMain {

	public static void main(String[] args) {
		System.out.println("Appuyez sur retour pour quitter");
		MouvementController mc = new MouvementController();
		mc.methodeExemple();
		while(Button.waitForAnyPress()!=Button.ID_ESCAPE) {}
	}

}
