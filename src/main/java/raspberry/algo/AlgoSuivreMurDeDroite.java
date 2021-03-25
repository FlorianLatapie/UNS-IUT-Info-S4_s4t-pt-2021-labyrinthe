package raspberry.algo;

import raspberry.reseau.StaticProtocolMessages;

public class AlgoSuivreMurDeDroite implements AlgoStrategy {

    @Override
    public String executer(String capteur) {
        int arrive = 0;
        System.out.println(capteur);

        if ((capteur.equals("101")) || (capteur.equals("001"))) {
            return StaticProtocolMessages.AVANCER;
        }

        else if (capteur.equals("100") || (capteur.equals("110")) || (capteur.equals("010")) || capteur.equals("000")) {
            return StaticProtocolMessages.DROITE+StaticProtocolMessages.AVANCER;
        }

        else if (capteur.equals("011")) {
        	System.out.println("je retourne "+StaticProtocolMessages.GAUCHE+StaticProtocolMessages.AVANCER);
            return StaticProtocolMessages.GAUCHE+StaticProtocolMessages.AVANCER;

        } else if (capteur.equals("111")) {
            return StaticProtocolMessages.GAUCHE+StaticProtocolMessages.GAUCHE;
        }

        else if (capteur.equals("000")) {
            if (arrive == 1) {
                capteur = null;
            } else {
                arrive = 1;
                return StaticProtocolMessages.ARRIVE;

            }
        }
        return null;
    }
}
