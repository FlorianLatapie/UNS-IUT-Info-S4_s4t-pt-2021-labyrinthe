package raspberry.algo;

import raspberry.reseau.StaticProtocolMessages;

public class AlgoSuivreMurDeDroite implements AlgoStrategy {
	static int arrive = 0;
    @Override
    public String executer(String capteur) {
        if ((capteur.equals("101")) || (capteur.equals("001"))) {
        	arrive = 0;
            return StaticProtocolMessages.AVANCER;
        }

        else if (capteur.equals("100") || (capteur.equals("110")) || (capteur.equals("010"))) {
        	arrive = 0;
            return StaticProtocolMessages.DROITE+StaticProtocolMessages.AVANCER;
        }

        else if (capteur.equals("011")) {
        	arrive = 0;
            return StaticProtocolMessages.GAUCHE+StaticProtocolMessages.AVANCER;

        } else if (capteur.equals("111")) {
        	arrive = 0;
            return StaticProtocolMessages.GAUCHE+StaticProtocolMessages.GAUCHE;
        }
        
        else if (capteur.equals("000")) {
            if (arrive == 1) {
            	return StaticProtocolMessages.ARRIVE;
            } else {
                arrive = 1;
                return StaticProtocolMessages.DROITE+StaticProtocolMessages.AVANCER;


            }
        }
        return null;
    }
}
