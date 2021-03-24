package raspberry.algo;

import java.util.Random;

import raspberry.reseau.StaticProtocolMessages;

public class AlgoDePledge implements AlgoStrategy {

	private static int arrive=0;
	
	
	private static int x = 1;
	private static int y = 10;
	private static int direction =2; //haut=0 ; gauche = 1 ; bas = 2 ; droite = 3

	
    @Override
    public String executer(String capteur) {
         
         
         

        if (capteur.equals(101)) {
        	if (direction == 0 || direction ==2){
        		TraceAlgoArrive.grille[x][y+1]=1;
        		TraceAlgoArrive.grille[x][y-1]=1;
        	}else if (direction == 1 || direction == 3) {
        		TraceAlgoArrive.grille[x+1][y]=1;
        		TraceAlgoArrive.grille[x-1][y]=1;
        	}
        	arrive = 0;
            return StaticProtocolMessages.AVANCER;
        }
        
        else if (capteur.equals("111")) {
        	if (direction == 0){
        		TraceAlgoArrive.grille[x][y+1]=1;
        		TraceAlgoArrive.grille[x][y-1]=1;
        		TraceAlgoArrive.grille[x-1][y]=1;
        	}else if (direction == 1) {
        		TraceAlgoArrive.grille[x+1][y]=1;
        		TraceAlgoArrive.grille[x-1][y]=1;
        		TraceAlgoArrive.grille[x][y-1]=1;
        	}else if (direction == 2) {
        		TraceAlgoArrive.grille[x][y+1]=1;
        		TraceAlgoArrive.grille[x][y-1]=1;
        		TraceAlgoArrive.grille[x+1][y]=1;
        	}else if (direction == 3) {
        		TraceAlgoArrive.grille[x+1][y]=1;
        		TraceAlgoArrive.grille[x-1][y]=1;
        		TraceAlgoArrive.grille[x][y+1]=1;
        	}
        	arrive = 0;
        	direction = direction +2;
        	if (direction >= 4) {direction = direction -4;}
            return StaticProtocolMessages.GAUCHE+StaticProtocolMessages.GAUCHE;
        }
        
         else if (capteur.equals("011")) {
        	 if (direction == 0){
         		TraceAlgoArrive.grille[x][y+1]=1;
         		TraceAlgoArrive.grille[x-1][y]=1;
         	}else if (direction == 1) {
         		TraceAlgoArrive.grille[x-1][y]=1;
         		TraceAlgoArrive.grille[x][y-1]=1;
         	}else if (direction == 2) {
         		TraceAlgoArrive.grille[x][y-1]=1;
         		TraceAlgoArrive.grille[x+1][y]=1;
         	}else if (direction == 3) {
         		TraceAlgoArrive.grille[x+1][y]=1;
         		TraceAlgoArrive.grille[x][y+1]=1;
         	}
        	arrive = 0;
    		direction++;
        	if (direction >= 4) {direction = direction -4;}
            return StaticProtocolMessages.GAUCHE+StaticProtocolMessages.AVANCER;

        } 
        
        else if (capteur.equals("110")) {
        	if (direction == 0){
         		TraceAlgoArrive.grille[x][y-1]=1;
         		TraceAlgoArrive.grille[x-1][y]=1;
         	}else if (direction == 1) {
         		TraceAlgoArrive.grille[x+1][y]=1;
         		TraceAlgoArrive.grille[x][y-1]=1;
         	}else if (direction == 2) {
         		TraceAlgoArrive.grille[x][y+1]=1;
         		TraceAlgoArrive.grille[x+1][y]=1;
         	}else if (direction == 3) {
         		TraceAlgoArrive.grille[x-1][y]=1;
         		TraceAlgoArrive.grille[x][y+1]=1;
         	}
        	arrive = 0;
    		direction++;
        	if (direction >= 4) {direction = direction -4;}

            return StaticProtocolMessages.DROITE+StaticProtocolMessages.AVANCER;

        }
        
        else if (capteur.equals("100")) {
        	if (direction == 0){
         		TraceAlgoArrive.grille[x][y-1]=1;
         	}else if (direction == 1) {
         		TraceAlgoArrive.grille[x+1][y]=1;
         	}else if (direction == 2) {
         		TraceAlgoArrive.grille[x][y+1]=1;
         	}else if (direction == 3) {
         		TraceAlgoArrive.grille[x-1][y]=1;
         	}
        	arrive = 0;
        	Random r = new Random();
        	int rand =r.nextInt(2);
        	if (rand== 0) {
                return StaticProtocolMessages.DROITE+StaticProtocolMessages.AVANCER;
        	}else {
        		return StaticProtocolMessages.AVANCER;
        	}
        		
        }
        
        else if (capteur.equals("001")) {
        	if (direction == 0){
         		TraceAlgoArrive.grille[x][y+1]=1;
         	}else if (direction == 1) {
         		TraceAlgoArrive.grille[x-1][y]=1;
         	}else if (direction == 2) {
         		TraceAlgoArrive.grille[x][y-1]=1;
         	}else if (direction == 3) {
         		TraceAlgoArrive.grille[x+1][y]=1;
         	}
        	arrive = 0;
        	
        }
        
        else if (capteur.equals("010")) {
        	if (direction == 0){
         		TraceAlgoArrive.grille[x-1][y]=1;
         	}else if (direction == 1) {
         		TraceAlgoArrive.grille[x][y-1]=1;
         	}else if (direction == 2) {
         		TraceAlgoArrive.grille[x+1][y]=1;
         	}else if (direction == 3) {
         		TraceAlgoArrive.grille[x][y+1]=1;
         	}
        	arrive = 0;
        }
        
        else if (capteur.equals("000")) {
        	
                if (arrive == 1) {
                    capteur = null;
                } else {
                    arrive = 1;
                    return StaticProtocolMessages.DROITE+StaticProtocolMessages.AVANCER;

                }
        }
        return null;
    }

}
