package test;

import org.junit.Test;
import raspberry.algo.AlgoSuivreMurDeDroite;
import raspberry.reseau.StaticProtocolMessages;

import static org.junit.Assert.assertEquals;

class AlgoSuivreMurDeDroiteTest {

    @Test
    void executerTest(){

        AlgoSuivreMurDeDroite algo = new AlgoSuivreMurDeDroite();

        //Move forward
        assertEquals(algo.executer("101"),StaticProtocolMessages.AVANCER);
        assertEquals(algo.executer("001"),StaticProtocolMessages.AVANCER);

        //Turn left + forward
        assertEquals(algo.executer("011"),StaticProtocolMessages.GAUCHE+StaticProtocolMessages.AVANCER);

        //Turn around
        assertEquals(algo.executer("111"),StaticProtocolMessages.GAUCHE+StaticProtocolMessages.GAUCHE);

        //Turn right + forward
        assertEquals(algo.executer("100"),StaticProtocolMessages.DROITE+StaticProtocolMessages.AVANCER);
        assertEquals(algo.executer("110"),StaticProtocolMessages.DROITE+StaticProtocolMessages.AVANCER);
        assertEquals(algo.executer("010"),StaticProtocolMessages.DROITE+StaticProtocolMessages.AVANCER);
        assertEquals(algo.executer("000"),StaticProtocolMessages.DROITE+StaticProtocolMessages.AVANCER);

        //End of maze
        assertEquals(algo.executer("000"),StaticProtocolMessages.ARRIVE);





    }

}