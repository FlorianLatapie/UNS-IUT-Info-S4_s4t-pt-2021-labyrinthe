#!/usr/bin/env python
import grovepi
import socket

ip = "localhost"
port = 8888
print("Client lecteur capteur demarré, \nrecherche d'un serveur sur l'IP :",ip,"et port :",port)
line_finder = 6
line_finder_gauche = 8
line_finder_droit = 4

grovepi.pinMode(line_finder, "INPUT")
grovepi.pinMode(line_finder_gauche,"INPUT")
grovepi.pinMode(line_finder_droit, "INPUT")

client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client_socket.connect(("localhost", 8888))

client_socket.send("CAPTEUR\n".encode())
print ("Client lecteur capteur connecté")
retour = ""

while True:
        from_server = client_socket.recv(4096)
        print("fromserver : ",from_server.decode())
        if (from_server.decode().startswith("QUIT")):
            break
        if (from_server.decode().startswith("getCapteur")):
            
            retour = ""
            # Retourne 1 quand la ligne détectée est noir et 0 si une ligne blanche est détectée
            if grovepi.digitalRead(line_finder_gauche) == 1: # Capteur de gauche
                retour += "0"
            else:
                retour += "1"

            if grovepi.digitalRead(line_finder) == 1: #Capteur du milieu
                retour += "0"
            else:
                retour += "1"

            if grovepi.digitalRead(line_finder_droit) == 1: #Capteur de droite
                retour += "0"
            else:
                retour += "1"
            toServer = "VAL_CAPTEUR:"+retour+"\n"
            print("toServer : ",toServer)
            client_socket.send(toServer.encode())
            retour = ""


client_socket.close()