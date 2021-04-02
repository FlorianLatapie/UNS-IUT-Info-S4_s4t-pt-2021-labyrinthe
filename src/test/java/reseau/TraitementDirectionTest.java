package reseau;

import ihm.TraitementDirection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TraitementDirectionTest {
	TraitementDirection td;

	@BeforeEach
	void init() {
		td = new TraitementDirection();
	}

	@Test
	void getdCoordByDeplacement() {
		int[] coordRobot = { 1, 2, 3 };
		String rotationRobot = "H";
		String[] deplacement = { "G", "A" };

		int[] res = td.getdCoordByDeplacement(coordRobot, rotationRobot, deplacement);
		assertEquals(1, res[0]);
		assertEquals(1, res[1]);
		assertEquals(0, res[2]);

		rotationRobot = "G";
		this.assignValues(deplacement, "A", "");
		res = td.getdCoordByDeplacement(coordRobot, rotationRobot, deplacement);
		assertEquals(1, res[0]);
		assertEquals(1, res[1]);
		assertEquals(0, res[2]);

		rotationRobot = "B";
		this.assignValues(deplacement, "D", "A");
		assertEquals(1, res[0]);
		assertEquals(1, res[1]);
		assertEquals(0, res[2]);

		////////////////////////////////////////////////////////////

		rotationRobot = "H";
		this.assignValues(deplacement, "A", "");
		res = td.getdCoordByDeplacement(coordRobot, rotationRobot, deplacement);
		assertEquals(0, res[0]);
		assertEquals(2, res[1]);
		assertEquals(1, res[2]);

		rotationRobot = "G";
		this.assignValues(deplacement, "D", "A");
		res = td.getdCoordByDeplacement(coordRobot, rotationRobot, deplacement);
		assertEquals(0, res[0]);
		assertEquals(2, res[1]);
		assertEquals(1, res[2]);

		rotationRobot = "D";
		this.assignValues(deplacement, "G", "A");
		res = td.getdCoordByDeplacement(coordRobot, rotationRobot, deplacement);
		assertEquals(0, res[0]);
		assertEquals(2, res[1]);
		assertEquals(1, res[2]);

		////////////////////////////////////////////////////////////

		rotationRobot = "H";
		this.assignValues(deplacement, "D", "A");
		res = td.getdCoordByDeplacement(coordRobot, rotationRobot, deplacement);
		assertEquals(1, res[0]);
		assertEquals(3, res[1]);
		assertEquals(2, res[2]);

		rotationRobot = "D";
		this.assignValues(deplacement, "A", "");
		res = td.getdCoordByDeplacement(coordRobot, rotationRobot, deplacement);
		assertEquals(1, res[0]);
		assertEquals(3, res[1]);
		assertEquals(2, res[2]);

		rotationRobot = "B";
		this.assignValues(deplacement, "G", "A");
		res = td.getdCoordByDeplacement(coordRobot, rotationRobot, deplacement);
		assertEquals(1, res[0]);
		assertEquals(3, res[1]);
		assertEquals(2, res[2]);

		////////////////////////////////////////////////////////////

		rotationRobot = "G";
		this.assignValues(deplacement, "G", "A");
		res = td.getdCoordByDeplacement(coordRobot, rotationRobot, deplacement);
		assertEquals(2, res[0]);
		assertEquals(2, res[1]);
		assertEquals(3, res[2]);

		rotationRobot = "D";
		this.assignValues(deplacement, "D", "A");
		res = td.getdCoordByDeplacement(coordRobot, rotationRobot, deplacement);
		assertEquals(2, res[0]);
		assertEquals(2, res[1]);
		assertEquals(3, res[2]);

		rotationRobot = "B";
		this.assignValues(deplacement, "A", "");
		res = td.getdCoordByDeplacement(coordRobot, rotationRobot, deplacement);
		assertEquals(2, res[0]);
		assertEquals(2, res[1]);
		assertEquals(3, res[2]);

		////////////////////////////////////////////////////////////

		rotationRobot = "H";
		this.assignValues(deplacement, "A", "");
		res = td.getdCoordByDeplacement(coordRobot, rotationRobot, deplacement);
		assertEquals("[0, 2, 1]", Arrays.toString(res)); // 0,2 correspond aux nouvelles coordonnées du robot dans la
															// matrice et 1 son orientation opposé (dans ce cas "1",
															// soit bas car notre direction est vers le haut)

		rotationRobot = "G";
		this.assignValues(deplacement, "x", "");
		res = td.getdCoordByDeplacement(coordRobot, rotationRobot, deplacement);
		assertEquals("[1, 2, 2]", Arrays.toString(res));
	}

	void assignValues(String[] tab, String d1, String d2) {
		tab[0] = d1;
		tab[1] = d2;

	}

	@Test
	void getOppositeIdRotationTest() {
		assertEquals(3, td.getOppositeIdRotation("H"));
		assertEquals(1, td.getOppositeIdRotation("B"));
		assertEquals(2, td.getOppositeIdRotation("G"));
		assertEquals(0, td.getOppositeIdRotation("D"));
		assertEquals(1, td.getOppositeIdRotation(""));
		assertEquals(1, td.getOppositeIdRotation("x"));
		assertEquals(1, td.getOppositeIdRotation("aazaz"));

	}

}