package lego;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class MouvementController {
	private int gearRatio = 24 / 8;
	private double rotation = 0.75;
	private double distance = 1.45;
	private boolean modeVerbeux = false;
	
	
	public MouvementController() {
		this.modeVerbeux = false;
	}
	
	public MouvementController(boolean modeVerbeux) {
		this.modeVerbeux = modeVerbeux;
	}
	
	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public void methodeExemple()  {
		if (modeVerbeux)System.out.println("méthode d'exemple");
		gauche();
		droite();
		avancer();
		reculer();
		if (modeVerbeux)System.out.println("fin de l'exemple");
	}

	public void gauche() {
		if (modeVerbeux)System.out.println("je vais a gauche");
		double correction = 0;

		int objectifA = (int) (-360 * (rotation+correction) * gearRatio);
		int objectifB = (int) (360 * (rotation+correction) * gearRatio);

		Motor.B.rotate(objectifB, true);
		Motor.A.rotate(objectifA, true);
		while (Motor.A.isMoving() || Motor.B.isMoving()) {
			Delay.msDelay(1);
		}
		if (modeVerbeux)System.out.println("fin gauche");
	}

	public void droite() {
		if (modeVerbeux)System.out.println("je vais � droite");

		double correction = 0.05;

		int objectifA = (int) (360 * (rotation+correction) * gearRatio);
		int objectifB = (int) (-360 * (rotation+correction) * gearRatio);

		Motor.B.rotate(objectifB, true);
		Motor.A.rotate(objectifA, true);
		while (Motor.A.isMoving() || Motor.B.isMoving()) {
			Delay.msDelay(1);
		}
		if (modeVerbeux)System.out.println("fin droite");
	}
	
	public void avancer() {
		if (modeVerbeux)System.out.println("j'avance");
		double correctionG = 0;
		double correctionD = 0;

		int objectifA = (int) (-360 * (distance+correctionD) * gearRatio);
		int objectifB = (int) (-360 * (distance+correctionG) * gearRatio);

		Motor.B.rotate(objectifB, true);
		Motor.A.rotate(objectifA, true);
		while (Motor.A.isMoving() || Motor.B.isMoving()) {
			Delay.msDelay(1);
		}
		if (modeVerbeux)System.out.println("stop");
	}
	
	public void reculer() {
		if (modeVerbeux)System.out.println("je recule");
		double correction = 0.15;

		int objectifA = (int) (360 * (distance+correction) * gearRatio);
		int objectifB = (int) (360 * (distance+correction) * gearRatio);

		Motor.B.rotate(objectifB, true);
		Motor.A.rotate(objectifA, true);
		while (Motor.A.isMoving() || Motor.B.isMoving()) {
			Delay.msDelay(1);
		}
		if (modeVerbeux)System.out.println("stop");
	}
	
	public void stop() {
		Motor.A.stop();
		Motor.B.stop();
	}
}
