package algo;

import org.junit.jupiter.api.Test;
import raspberry.algo.AlgoSuivreMurDeDroite;
import raspberry.reseau.StaticProtocolMessages;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlgoSuivreMurDeDroiteTest {

    @Test
    void executerTest(){

        AlgoSuivreMurDeDroite algo = new AlgoSuivreMurDeDroite();

        //Move forward
        assertEquals(StaticProtocolMessages.AVANCER,algo.executer("101"));
        assertEquals(StaticProtocolMessages.AVANCER,algo.executer("001"));

        //Turn left + forward
        assertEquals(StaticProtocolMessages.GAUCHE+StaticProtocolMessages.AVANCER, algo.executer("011"));

        //Turn around
        assertEquals(StaticProtocolMessages.GAUCHE+StaticProtocolMessages.GAUCHE,algo.executer("111"));

        //Turn right + forward
        assertEquals(StaticProtocolMessages.DROITE+StaticProtocolMessages.AVANCER,algo.executer("100"));
        assertEquals(StaticProtocolMessages.DROITE+StaticProtocolMessages.AVANCER,algo.executer("110"));
        assertEquals(StaticProtocolMessages.DROITE+StaticProtocolMessages.AVANCER,algo.executer("010"));
        assertEquals(StaticProtocolMessages.DROITE+StaticProtocolMessages.AVANCER,algo.executer("000"));

        //End of maze
        assertEquals(StaticProtocolMessages.ARRIVE,algo.executer("000"));
    }

}