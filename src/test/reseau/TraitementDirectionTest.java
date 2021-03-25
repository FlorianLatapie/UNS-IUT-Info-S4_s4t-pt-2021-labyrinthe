package reseau;

import ihm.TraitementDirection;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TraitementDirectionTest {

    @Test
    void getdCoordByDeplacement() {
        int[] coordRobot = {1, 2, 3};
        String rotationRobot = "H";
        String[] deplacement = {"G", "A"};

        int[] res = TraitementDirection.getdCoordByDeplacement(coordRobot, rotationRobot, deplacement);
        assertEquals(res[0], 1);
        assertEquals(res[1], 1);
        assertEquals(res[2],0);

        rotationRobot="G";
        this.assignValues(deplacement,"A","");
        res = TraitementDirection.getdCoordByDeplacement(coordRobot,rotationRobot,deplacement);
        assertEquals(res[0], 1);
        assertEquals(res[1], 1);
        assertEquals(res[2],0);

        rotationRobot = "B";
        this.assignValues(deplacement,"D","A");
        assertEquals(res[0], 1);
        assertEquals(res[1], 1);
        assertEquals(res[2],0);

        ////////////////////////////////////////////////////////////

        rotationRobot="H";
        this.assignValues(deplacement,"A","");
        res = TraitementDirection.getdCoordByDeplacement(coordRobot,rotationRobot,deplacement);
        assertEquals(res[0], 0);
        assertEquals(res[1], 2);
        assertEquals(res[2],1);

        rotationRobot = "G";
        this.assignValues(deplacement,"D","A");
        res = TraitementDirection.getdCoordByDeplacement(coordRobot,rotationRobot,deplacement);
        assertEquals(res[0], 0);
        assertEquals(res[1], 2);
        assertEquals(res[2],1);

        rotationRobot = "D";
        this.assignValues(deplacement,"G","A");
        res = TraitementDirection.getdCoordByDeplacement(coordRobot,rotationRobot,deplacement);
        assertEquals(res[0], 0);
        assertEquals(res[1], 2);
        assertEquals(res[2],1);

        ////////////////////////////////////////////////////////////

        rotationRobot = "H";
        this.assignValues(deplacement,"D","A");
        res = TraitementDirection.getdCoordByDeplacement(coordRobot,rotationRobot,deplacement);
        assertEquals(res[0], 1);
        assertEquals(res[1], 3);
        assertEquals(res[2],2);

        rotationRobot = "D";
        this.assignValues(deplacement,"A","");
        res = TraitementDirection.getdCoordByDeplacement(coordRobot,rotationRobot,deplacement);
        assertEquals(res[0], 1);
        assertEquals(res[1], 3);
        assertEquals(res[2],2);

        rotationRobot = "B";
        this.assignValues(deplacement,"G","A");
        res = TraitementDirection.getdCoordByDeplacement(coordRobot,rotationRobot,deplacement);
        assertEquals(res[0], 1);
        assertEquals(res[1], 3);
        assertEquals(res[2],2);

        ////////////////////////////////////////////////////////////

        rotationRobot = "G";
        this.assignValues(deplacement,"G","A");
        res = TraitementDirection.getdCoordByDeplacement(coordRobot,rotationRobot,deplacement);
        assertEquals(res[0], 2);
        assertEquals(res[1], 2);
        assertEquals(res[2],3);

        rotationRobot = "D";
        this.assignValues(deplacement,"D","A");
        res = TraitementDirection.getdCoordByDeplacement(coordRobot,rotationRobot,deplacement);
        assertEquals(res[0], 2);
        assertEquals(res[1], 2);
        assertEquals(res[2],3);

        rotationRobot = "B";
        this.assignValues(deplacement,"A","");
        res = TraitementDirection.getdCoordByDeplacement(coordRobot,rotationRobot,deplacement);
        assertEquals(res[0], 2);
        assertEquals(res[1], 2);
        assertEquals(res[2],3);

        ////////////////////////////////////////////////////////////

        rotationRobot = "H";
        this.assignValues(deplacement,"A","");
        res = TraitementDirection.getdCoordByDeplacement(coordRobot,rotationRobot,deplacement);
        assertEquals(Arrays.toString(res), "[0, 2, 1]"); // 0,2 correspond aux nouvelles coordonnées du robot dans la matrice et 1 son orientation opposé (dans ce cas "1", soit bas car notre direction est vers le haut)

        rotationRobot = "G";
        this.assignValues(deplacement,"x","");
        res = TraitementDirection.getdCoordByDeplacement(coordRobot,rotationRobot,deplacement);
        assertEquals(Arrays.toString(res), "[1, 2, 2]");
    }

    void assignValues(String[] tab, String d1, String d2){
        tab[0] = d1;
        tab[1] = d2;

    }
    @Test
    void getOppositeIdRotationTest() {
        assertEquals(TraitementDirection.getOppositeIdRotation("H"), 3);
        assertEquals(TraitementDirection.getOppositeIdRotation("B"), 1);
        assertEquals(TraitementDirection.getOppositeIdRotation("G"), 2);
        assertEquals(TraitementDirection.getOppositeIdRotation("D"), 0);
        assertEquals(TraitementDirection.getOppositeIdRotation(""), 1);
        assertEquals(TraitementDirection.getOppositeIdRotation("x"), 1);
        assertEquals(TraitementDirection.getOppositeIdRotation("aazaz"), 1);

    }


}