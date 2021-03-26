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

	 @Test
    void creerMatriceLabyTest(){
        RobotVirtuel rv = new RobotVirtuel();
        int[] pos = {1,2};
        String[][] tab = rv.creerMatriceRobot(5,5,pos,"H");
        assertEquals(5,tab.length);
        assertEquals(5,tab[0].length);
        assertEquals("H",tab[1][2]);
        pos[0] = 3;
        pos[1] = 0;
        String[][] tab2 = rv.creerMatriceRobot(4,3,pos,"B");
        assertEquals(4,tab2.length);
        assertEquals(3,tab2[0].length);
        assertEquals("B",tab2[3][0]);


    }

    @Test
    void bougerTest(){
        RobotVirtuel rv = new RobotVirtuel();
        String[][] mLaby = {
                {null, null, null},
                {null, null, null},
                {null, null, null},
        };
        String[][] mRobot = {
                {null, null, null},
                {null, "H", null},
                {null, null, null},
        };
        rv.bouger(StaticProtocolMessages.AVANCER,"111",mRobot,mLaby);
        assertEquals(mLaby[0][1],"UH");
        assertEquals(mLaby[1][1],"UH");
        rv.bouger(StaticProtocolMessages.GAUCHE+""+StaticProtocolMessages.DROITE,"111",mRobot,mLaby);
        assertEquals(mLaby[0][1],"UH");
        assertEquals(mLaby[1][1],"UH");
        rv.bouger(StaticProtocolMessages.DROITE+""+StaticProtocolMessages.AVANCER,"111",mRobot,mLaby);
        assertEquals(mLaby[0][2],"UD");
    }

    @Test
    void nouveauMurTest(){
        RobotVirtuel rv = new RobotVirtuel();
        String[][] mLaby = {
                {null, null, null},
                {null, null, null},
                {null, null, null},
        };
        String[][] mRobot = {
                {null, null, null},
                {null, "H", null},
                {null, null, null},
        };
        int[] posRobot = {1, 1};
        rv.nouveauMur("111",mRobot,mLaby);
        assertEquals(mLaby[1][1],"UH");

        rv.nouveauMur("011",mRobot,mLaby);
        assertEquals(mLaby[1][1],"ABD");

        rv.nouveauMur("110",mRobot,mLaby);
        assertEquals(mLaby[1][1],"ABG");

        rv.nouveauMur("101",mRobot,mLaby);
        assertEquals(mLaby[1][1],"DLV");

    }

	 @Test
    void angleDroitTest() {
        RobotVirtuel rv = new RobotVirtuel();
        String[][] mLaby = {
                {null, null, null},
                {null, null, null},
                {null, null, null},
        };
        int[] posRobot = {1, 1};
        rv.angleDroit(posRobot, "H", mLaby);
        assertEquals(mLaby[1][1], "ABG");

        posRobot[0] = 0;
        rv.angleDroit(posRobot, "D", mLaby);
        assertEquals(mLaby[0][1], "AHG");

        posRobot[0] = 0;
        posRobot[1] = 2;
        rv.angleDroit(posRobot, "B", mLaby);
        assertEquals(mLaby[0][2], "AHD");

        rv.angleDroit(posRobot, "G", mLaby);
        assertEquals(mLaby[0][2], "ABD");
    }

    @Test
    void angleGaucheTest() {
        RobotVirtuel rv = new RobotVirtuel();
        String[][] mLaby = {
                {null, null, null},
                {null, null, null},
                {null, null, null},
        };
        int[] posRobot = {1, 1};
        rv.angleGauche(posRobot, "H", mLaby);
        assertEquals(mLaby[1][1], "ABD");

        posRobot[0] = 0;
        rv.angleGauche(posRobot, "D", mLaby);
        assertEquals(mLaby[0][1], "ABG");

        posRobot[0] = 0;
        posRobot[1] = 2;
        rv.angleGauche(posRobot, "B", mLaby);
        assertEquals(mLaby[0][2], "AHG");

        rv.angleGauche(posRobot, "G", mLaby);
        assertEquals(mLaby[0][2], "AHD");
    }

    @Test
    void UTest() {
        RobotVirtuel rv = new RobotVirtuel();
        String[][] mLaby = {
                {null, null, null},
                {null, null, null},
                {null, null, null},
        };
        int[] posRobot = {1, 1};
        rv.U(posRobot, "H", mLaby);
        assertEquals(mLaby[1][1], "UH");

        posRobot[0] = 0;
        rv.U(posRobot, "D", mLaby);
        assertEquals(mLaby[0][1], "UD");

        posRobot[0] = 0;
        posRobot[1] = 2;
        rv.U(posRobot, "B", mLaby);
        assertEquals(mLaby[0][2], "UB");

        rv.U(posRobot, "G", mLaby);
        assertEquals(mLaby[0][2], "UG");


    }

    @Test
    void bougerRobotTest() {
        RobotVirtuel rv = new RobotVirtuel();
        String[][] mRobot = {
                {null, null, null},
                {null, null, null},
                {"H", null, null},
        };
        rv.bougerRobot(StaticProtocolMessages.AVANCER, mRobot);
        assertEquals(mRobot[1][0], "H");
        assertEquals(mRobot[2][0], null);

        rv.bougerRobot(StaticProtocolMessages.DROITE, mRobot);
        assertEquals(mRobot[1][0], "D");

        rv.bougerRobot(StaticProtocolMessages.GAUCHE, mRobot);
        assertEquals(mRobot[1][0], "H");


    }

    @Test
    void avancerTest() {

        RobotVirtuel rv = new RobotVirtuel();
        String[][] mRobot = {
                {null, null, null},
                {null, null, null},
                {"H", "B", null},
        };
        rv.avancer(mRobot);
        assertEquals(null, mRobot[2][0]);
        assertEquals("H", mRobot[1][0]);

        mRobot[1][0] = "D";
        rv.avancer(mRobot);
        assertEquals(null, mRobot[1][0]);
        assertEquals("D", mRobot[1][1]);

        mRobot[1][0] = "B";
        rv.avancer(mRobot);
        assertEquals(null, mRobot[1][0]);
        assertEquals("B", mRobot[2][0]);

        String[][] mRobot2 = {
                {null, null, null},
                {null, null, null},
                {"H", "B", null},
        };
        mRobot2[0][1] = "G";
        rv.avancer(mRobot2);
        assertEquals(null, mRobot2[0][1]);
        assertEquals("G", mRobot2[0][0]);


    }

    @Test
    void droiteTest() {
        RobotVirtuel rv = new RobotVirtuel();
        String[][] mRobot = {
                {null, null, null},
                {null, null, null},
                {"H", "B", null},
        };
        rv.droite(mRobot);
        assertEquals(mRobot[2][0], "D");
        assertEquals(mRobot[2][1], "B");

        String[][] mRobotD = {
                {null, null, null},
                {"D", null, "H"},
                {null, null, null},
        };
        rv.droite(mRobotD);
        assertEquals(mRobotD[1][0], "B");
        assertEquals(mRobotD[1][1], null);

        String[][] mRobotB = {
                {"B", null, null},
                {null, null, null},
                {null, null, null},
        };
        rv.droite(mRobotB);
        assertEquals(mRobotB[0][0], "G");

        String[][] mRobotG = {
                {null, null, null},
                {null, "G", null},
                {null, null, null},
        };
        rv.droite(mRobotG);
        assertEquals(mRobotG[1][1], "H");
    }

    @Test
    void gaucheTest() {
        RobotVirtuel rv = new RobotVirtuel();
        String[][] mRobot = {
                {null, null, null},
                {null, null, null},
                {"H", "B", null},
        };
        rv.gauche(mRobot);
        assertEquals(mRobot[2][0], "G");
        assertEquals(mRobot[2][1], "B");

        String[][] mRobotD = {
                {null, null, null},
                {"D", null, "H"},
                {null, null, null},
        };
        rv.gauche(mRobotD);
        assertEquals(mRobotD[1][0], "H");
        assertEquals(mRobotD[1][1], null);

        String[][] mRobotB = {
                {"B", null, null},
                {null, null, null},
                {null, null, null},
        };
        rv.gauche(mRobotB);
        assertEquals(mRobotB[0][0], "D");

        String[][] mRobotG = {
                {null, null, null},
                {null, "G", null},
                {null, null, null},
        };
        rv.gauche(mRobotG);
        assertEquals(mRobotG[1][1], "B");

    }

    @Test
    void getDirRobotTest() {
        RobotVirtuel rv = new RobotVirtuel();
        String[][] mRobot = {
                {null, null, null},
                {null, null, null},
                {"H", "B", null},
        };

        String[][] mRobot2 = {
                {null, null, null},
                {null, null, null},
                {null, null, "B"},
        };
        assertEquals(rv.getDirRobot(mRobot), "H");
        assertEquals(rv.getDirRobot(mRobot2), "B");
        String[][] mRobot3 = {
                {null, null, null},
                {null, null, null},
                {null, null, null}
        };
    }

    @Test
    void getPosRobotTest() {
        RobotVirtuel rv = new RobotVirtuel();
        String[][] mRobot = {
                {null, null, null},
                {null, null, null},
                {"H", null},
        };
        int[] tab = rv.getPosRobot(mRobot);
        assertEquals(tab[0], 2);
        assertEquals(tab[1], 0);

        String[][] mRobot2 = {
                {null, null, null},
                {null, null, null},
                {null, null, null}
        };

        int[] tab2 = rv.getPosRobot(mRobot2);
        assertNull(tab2);
    }


}
