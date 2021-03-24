package ihm;

import raspberry.reseau.StaticProtocolMessages;

public class RobotVirtuel {
	public void méthodeExemple() {
		int tailleX = 5, tailleY = 5;
		int[] posDepart = {4,4};
		int[] posArrivee = {0,0};
		
		String[][] matriceRobot = creerMatriceRobot(tailleX, tailleY, posDepart, "H");
			/*{ 	{ null, null, null, null, null},
										{ null, null, null, null, null},
										{ null, null, "H" , null, null}, 
										{ null, null, null, null, null}, 
										{ null, null, null, null, null}};*/

		String[][] matriceLaby = creerMatriceLaby(tailleX, tailleY, posDepart, posArrivee);
			/*{	{ null, null, null, null, null }, 
									{ null, null, null, null, null },
									{ null, null, "CD", null, null }, 
									{ null, null, null, null, null }, 
									{ null, null, null, null, null }};*/
		
		
		
		//afficheMatrice(matriceRobot);
		affiche2Matrices(matriceRobot, matriceLaby);
		//System.out.println(Arrays.toString(getPosRobot(matriceRobot)));
		//System.out.println(getDirRobot(matriceRobot));
		
		/*gauche(matriceRobot);
		gauche(matriceRobot);
		gauche(matriceRobot);
		gauche(matriceRobot);*/
		
		/*droite(matriceRobot);
		droite(matriceRobot);
		avancer(matriceRobot);*/
		
		bouger("AG", 011, matriceRobot, matriceLaby);
		bouger("A", 101, matriceRobot, matriceLaby);
		bouger("AD", 110, matriceRobot, matriceLaby);
		bouger("A", 101, matriceRobot, matriceLaby);
		bouger("A", 101, matriceRobot, matriceLaby);
		bouger("AG", 011, matriceRobot, matriceLaby);
		bouger("A", 101, matriceRobot, matriceLaby);
		bouger("A", 101, matriceRobot, matriceLaby);
		
		affiche2Matrices(matriceRobot, matriceLaby);
		//afficheMatrice(matriceRobot);
	}

	private String[][] creerMatriceRobot(int tailleX, int tailleY, int[] posDepart, String dirRobot) {
		String[][] retour = new String[tailleX][tailleY];
		for (int i = 0; i < tailleX; i++) {
			for (int j = 0; j < tailleY; j++) {
				if (i == posDepart[0] && j == posDepart[1]) {
					retour[i][j] = dirRobot;
				} else {
					retour[i][j] = null;
				}
			}
		}
		return retour;
	}

	private String[][] creerMatriceLaby(int tailleX, int tailleY, int[] posDepart, int[] posArrivee) {
		String[][] retour = new String[tailleX][tailleY];
		for (int i = 0; i < tailleX; i++) {
			for (int j = 0; j < tailleY; j++) {
				if (i == posDepart[0] && j == posDepart[1]) {
					retour[i][j] = "CD";
				} else if (i == posArrivee[0] && j == posArrivee[1]) {
					retour[i][j] = "CA";
				} else {
					retour[i][j] = null;
				}
			}
		}
		return retour;
	}

	private void bouger(String mouvement, int valCapteur, String[][] mRobot, String[][] mLaby) {
		String[] tabMouvement = mouvement.split("");
		for (int i = 0; i < tabMouvement.length; i++) {
			bougerRobot(tabMouvement[i], mRobot);
			if (i == 0) {
				nouveauMur(valCapteur, mRobot, mLaby);
			}

		}

	}

	private void nouveauMur(int valCapteur, String[][] mRobot, String[][] mLaby) {
		int[] posRobot = getPosRobot(mRobot);

		String dirRobot = getDirRobot(mRobot);

		switch (valCapteur) {
		case 111:
			U(posRobot, dirRobot, mLaby);
			break;

		case 011:
			angleGauche(posRobot, dirRobot, mLaby);
			break;

		case 110:
			angleDroit(posRobot, dirRobot, mLaby);
			break;

		case 101:
			deuxLignes(posRobot, dirRobot, mLaby);
			break;

		default:
			System.out.println("val capteur impossible " + valCapteur);
			// throw new IllegalArgumentException("Unexpected value: " + key);
		}
	}

	private void deuxLignes(int[] posRobot, String dirRobot, String[][] mLaby) {
		switch (dirRobot) {
		case "H":
			mLaby[posRobot[0]][posRobot[1]] = "DLV";
			break;
		case "D":
			mLaby[posRobot[0]][posRobot[1]] = "DLH";
			break;
		case "B":
			mLaby[posRobot[0]][posRobot[1]] = "DLV";
			break;
		case "G":
			mLaby[posRobot[0]][posRobot[1]] = "DLH";
			break;
		default:
			System.out.println("DL impossible à placer " + dirRobot);
		}

	}

	private void angleDroit(int[] posRobot, String dirRobot, String[][] mLaby) {
		switch (dirRobot) {
		case "H":
			mLaby[posRobot[0]][posRobot[1]] = "AHG";
			break;
		case "D":
			mLaby[posRobot[0]][posRobot[1]] = "AHD";
			break;
		case "B":
			mLaby[posRobot[0]][posRobot[1]] = "ABD";
			break;
		case "G":
			mLaby[posRobot[0]][posRobot[1]] = "ABG";
			break;
		default:
			System.out.println("DL impossible à placer " + dirRobot);
		}

	}

	private void angleGauche(int[] posRobot, String dirRobot, String[][] mLaby) {
		switch (dirRobot) {
		case "H":
			mLaby[posRobot[0]][posRobot[1]] = "AHD";
			break;
		case "D":
			mLaby[posRobot[0]][posRobot[1]] = "ABD";
			break;
		case "B":
			mLaby[posRobot[0]][posRobot[1]] = "ABG";
			break;
		case "G":
			mLaby[posRobot[0]][posRobot[1]] = "AHG";
			break;
		default:
			System.out.println("DL impossible à placer " + dirRobot);
		}

	}

	private void U(int[] posRobot, String dirRobot, String[][] mLaby) {
		switch (dirRobot) {
		case "H":
			mLaby[posRobot[0]][posRobot[1]] = "UH";
			break;
		case "D":
			mLaby[posRobot[0]][posRobot[1]] = "UD";
			break;
		case "B":
			mLaby[posRobot[0]][posRobot[1]] = "UB";
			break;
		case "G":
			mLaby[posRobot[0]][posRobot[1]] = "UG";
			break;
		default:
			System.out.println("U impossible à placer " + dirRobot);
		}

	}

	private void bougerRobot(String mouvement, String[][] mRobot) {
		switch (mouvement) {
		case StaticProtocolMessages.AVANCER:
			avancer(mRobot);
			break;

		case StaticProtocolMessages.GAUCHE:
			gauche(mRobot);
			break;

		case StaticProtocolMessages.DROITE:
			droite(mRobot);
			break;
		default:
			System.out.println(mouvement + " inconnu");
		}

	}

	private void avancer(String[][] mRobot) {
		int posX = getPosRobot(mRobot)[0];
		int posY = getPosRobot(mRobot)[1];
		switch (getDirRobot(mRobot)) {
		case "H":
			mRobot[posX - 1][posY] = "H";
			mRobot[posX][posY] = null;
			break;
		case "D":
			mRobot[posX][posY + 1] = "D";
			mRobot[posX][posY] = null;
			break;
		case "B":
			mRobot[posX + 1][posY] = "B";
			mRobot[posX][posY] = null;
			break;
		case "G":
			mRobot[posX][posY - 1] = "G";
			mRobot[posX][posY] = null;
			break;
		default:
			System.out.println("impossible d'avancer");
		}

	}

	private void droite(String[][] mRobot) {
		switch (getDirRobot(mRobot)) {
		case "H":
			mRobot[getPosRobot(mRobot)[0]][getPosRobot(mRobot)[1]] = "D";
			break;
		case "D":
			mRobot[getPosRobot(mRobot)[0]][getPosRobot(mRobot)[1]] = "B";
			break;
		case "B":
			mRobot[getPosRobot(mRobot)[0]][getPosRobot(mRobot)[1]] = "G";
			break;
		case "G":
			mRobot[getPosRobot(mRobot)[0]][getPosRobot(mRobot)[1]] = "H";
			break;
		default:
			System.out.println("impossible d'aller a doite");
		}

	}

	private void gauche(String[][] mRobot) {
		switch (getDirRobot(mRobot)) {
		case "H":
			mRobot[getPosRobot(mRobot)[0]][getPosRobot(mRobot)[1]] = "G";
			break;
		case "D":
			mRobot[getPosRobot(mRobot)[0]][getPosRobot(mRobot)[1]] = "H";
			break;
		case "B":
			mRobot[getPosRobot(mRobot)[0]][getPosRobot(mRobot)[1]] = "D";
			break;
		case "G":
			mRobot[getPosRobot(mRobot)[0]][getPosRobot(mRobot)[1]] = "B";
			break;
		default:
			System.out.println("impossible d'aller a gauche");
		}

	}

	private String getDirRobot(String[][] mRobot) {
		return mRobot[getPosRobot(mRobot)[0]][getPosRobot(mRobot)[1]];
	}

	private int[] getPosRobot(String[][] mRobot) {
		for (int i = 0; i < mRobot.length; i++) {
			for (int j = 0; j < mRobot[0].length; j++) {
				if (mRobot[i][j] != null) {
					int[] retour = { i, j };
					return retour;
				}
			}
		}
		System.out.println("pas de pos robot");
		return null;
	}

	public void affiche2Matrices(String[][] matrice, String[][] matrice2) {
		afficheMatrice(matrice);
		System.out.println("\n");
		afficheMatrice(matrice2);
	}

	public void afficheMatrice(String[][] matrice) {
		for (int i = 0; i < matrice[0].length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				System.out.print(matrice[i][j] + "\t");
			}
			System.out.println("");
		}

	}
}