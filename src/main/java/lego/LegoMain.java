package lego;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;
import lejos.hardware.Button;

public class LegoMain {

	public static void main(String[] args) {
		System.out.println("Appuyez sur retour pour quitter");
		
		while(Button.waitForAnyPress()!=Button.ID_ESCAPE) {
			if (Button.waitForAnyPress()==Button.ID_UP) {
				Motor.A.forward();
				Delay.msDelay(1000);
				Motor.A.stop();
			}
		}
	}

}
