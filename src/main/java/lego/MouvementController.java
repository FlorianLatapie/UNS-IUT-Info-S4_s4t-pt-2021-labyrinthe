package lego;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class MouvementController {
	static int gearRatio = 24 / 8;
	static double rotation = 1.25;
	static double distance = 1.45;

	public static void methodeExemple()  {
		System.out.println("méthode d'exemple");
		gauche();
		droite();
		avancer();
		reculer();
		System.out.println("fin");
	}

	public static void gauche() {
		System.out.println("je vais a gauche");
		double correction = 0;

		int objectifA = (int) (-360 * (rotation+correction) * gearRatio);
		int objectifB = (int) (360 * (rotation+correction) * gearRatio);

		Motor.B.rotate(objectifB, true);
		Motor.A.rotate(objectifA, true);
		while (Motor.A.isMoving() || Motor.B.isMoving()) {
			Delay.msDelay(1);
		}
		System.out.println("fin gauche");
	}

	public static void droite() {
		System.out.println("je vais � droite");

		double correction = -0.15;

		int objectifA = (int) (360 * (rotation+correction) * gearRatio);
		int objectifB = (int) (-360 * (rotation+correction) * gearRatio);

		Motor.B.rotate(objectifB, true);
		Motor.A.rotate(objectifA, true);
		while (Motor.A.isMoving() || Motor.B.isMoving()) {
			Delay.msDelay(1);
		}
		System.out.println("fin droite");
	}
	
	public static void avancer() {
		System.out.println("j'avance");
		double correction = 0;

		int objectifA = (int) (-360 * (distance+correction) * gearRatio);
		int objectifB = (int) (-360 * (distance+correction) * gearRatio);

		Motor.B.rotate(objectifB, true);
		Motor.A.rotate(objectifA, true);
		while (Motor.A.isMoving() || Motor.B.isMoving()) {
			Delay.msDelay(1);
		}
		System.out.println("fin avancer");
	}
	
	public static void reculer() {
		System.out.println("je recule");
		double correction = 0.15;

		int objectifA = (int) (360 * (distance+correction) * gearRatio);
		int objectifB = (int) (360 * (distance+correction) * gearRatio);

		Motor.B.rotate(objectifB, true);
		Motor.A.rotate(objectifA, true);
		while (Motor.A.isMoving() || Motor.B.isMoving()) {
			Delay.msDelay(1);
		}
		System.out.println("fin reculer");
	}
}
