/**
 * 
 */
package robot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import ihm.RobotVirtuel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Remy
 *
 */
class RobotVirtuelTest {
	RobotVirtuel rb;
	String[][] matLaby = {{null, null, null,null, null,null},
			{null, null, null,null,null ,null},
			{null, null, null,null,null,null},
			{null, null, null,null,null,null},
		};
	
	@BeforeEach
	void init() {
		rb = new RobotVirtuel();
	}
	

	@Test
	void creerMatriceRobotTest() {
		String[][] stringTest1 = {
				{null, "H", null,null},
				{null, null, null,null},
				{null, null, null,null},
		};
		int[] posDepart1 = {0,1};
		String[][] stringATester1 = rb.creerMatriceRobot(3, 4, posDepart1, "H");
		for (int i = 0; i < stringTest1.length; i++) {
			for (int j = 0; j < stringTest1[0].length; j++) {
				assertEquals(stringTest1[i][j],stringATester1[i][j]);
			}
		}
		
		String[][] stringTest2 = {
				{null, null},
				{null, null},
				{"D", null},
		};
		int[] posDepart2 = {2,0};
		String[][] stringATester2 = rb.creerMatriceRobot(3, 2, posDepart2, "D");
		for (int i = 0; i < stringTest2.length; i++) {
			for (int j = 0; j < stringTest2[0].length; j++) {
				assertEquals(stringTest2[i][j],stringATester2[i][j]);
			}
		}
		
		String[][] stringTest3 = {
				{null, null, null,null, null,null},
				{null, null, null,null,"B",null},
				{null, null, null,null,null,null},
				{null, null, null,null,null,null},
		};
		int[] posDepart3 = {1,4};
		String[][] stringATester3 = rb.creerMatriceRobot(4, 6, posDepart3, "B");
		for (int i = 0; i < stringTest3.length; i++) {
			for (int j = 0; j < stringTest3[0].length; j++) {
				assertEquals(stringTest3[i][j],stringATester3[i][j]);
			}
		}
	}
	
	@Test
	void deuxLignesTest() {
		String[][] matTest = {{null, null, null,null, null,null},
				{null, null, null,null,null ,null},
				{null, null, null,null,null,null},
				{null, null, null,null,"DLV",null},
			};
		int[] pos = {3, 4};
		rb.deuxLignes(pos, "B", matLaby);
		for (int i = 0; i < matLaby.length; i++) {
			for (int j = 0; j < matLaby[0].length; j++) {
				assertEquals(matTest[i][j],matLaby[i][j]);
			}
		}
		
	}

}
