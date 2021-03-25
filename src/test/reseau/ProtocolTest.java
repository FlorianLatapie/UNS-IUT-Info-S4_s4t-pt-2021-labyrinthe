package reseau;

import org.junit.jupiter.api.Test;
import raspberry.reseau.MultiServer;
import raspberry.reseau.Protocol;
import raspberry.reseau.StaticProtocolMessages;

import static org.junit.jupiter.api.Assertions.*;

class ProtocolTest {

    Protocol pv = new Protocol(new MultiServer(), true);


    @Test
    void processInfoTestSilence() {


        Protocol p = new Protocol(new MultiServer());
        // check null param error
        assertEquals(p.processInfo(null), ("client input is null : " + null));
        assertEquals(p.processInfo(""), ("client input is null : "));

        // check values for verbose prefix
        assertTrue(p.getVerbose());
        p.processInfo(StaticProtocolMessages.ENTETE_VERBOSE + 0);
        assertFalse(p.getVerbose());
        p.processInfo(StaticProtocolMessages.ENTETE_VERBOSE + "false");
        assertFalse(p.getVerbose());

        p.processInfo(StaticProtocolMessages.ENTETE_VERBOSE + 1);
        assertTrue(p.getVerbose());
        p.setVerbose(false);
        p.processInfo(StaticProtocolMessages.ENTETE_VERBOSE + "true");
        assertTrue(p.getVerbose());

        p.processInfo(StaticProtocolMessages.ENTETE_VERBOSE);
        assertEquals(p.processInfo(StaticProtocolMessages.ENTETE_VERBOSE), "");
        assertEquals(p.processInfo(StaticProtocolMessages.ENTETE_VERBOSE + "x"), "");

        //Check value for test prefix
        assertEquals(p.processInfo(StaticProtocolMessages.TEST), StaticProtocolMessages.TEST + " : le protocol existe");

        //Check value for Help prefix
        assertEquals(p.processInfo(StaticProtocolMessages.HELP), StaticProtocolMessages.HELP + " : "
                + StaticProtocolMessages.ENTETE_BROADCAST + "<msg> pour envoyer un message à tout le monde");

        //Check value for broadcast prefix
        assertEquals(p.processInfo(StaticProtocolMessages.ENTETE_BROADCAST), "");

        //Check value for sensor prefix
        String message = StaticProtocolMessages.ENTETE_CAPTEUR+"1";
        assertEquals(p.processInfo(message), "");

        //Check unknown values
        assertEquals(p.processInfo("random"), "commande inconnue");
        assertEquals(p.processInfo("x"), "commande inconnue");


    }


}