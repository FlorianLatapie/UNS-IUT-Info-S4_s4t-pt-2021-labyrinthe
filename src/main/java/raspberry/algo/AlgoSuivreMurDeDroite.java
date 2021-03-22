package raspberry.algo;

public class AlgoSuivreMurDeDroite implements AlgoStrategy {

    @Override
    public String[] executer(Integer capteur) {
        int arrive = 0;

        if ((capteur.equals(101)) || (capteur.equals(001))) {
            String[] retour = { "A" };
            return retour;
        }

        else if (capteur.equals(100) || (capteur.equals(110)) || (capteur.equals(010)) || capteur.equals(000)) {
            String[] retour = { "D", "A" };
            return retour;
        }

        else if (capteur.equals(011)) {
            String[] retour = { "G", "A" };
            return retour;

        } else if (capteur.equals(111)) {
            String[] retour = { "G", "G" };
            return retour;
        }

        else if (capteur.equals(000)) {
            if (arrive == 1) {
                capteur = null;
            } else {
                arrive = 1;
                String[] retour = { "ARR" };
                return retour;

            }
        }
        String[] retour = { "ERR" };
        return retour;
    }
}
