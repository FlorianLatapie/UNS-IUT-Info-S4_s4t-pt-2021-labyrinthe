#!/usr/bin/env python
import grovepi
import socket

line_finder = 6
line_finder_gauche = 8
line_finder_droit = 4

grovepi.pinMode(line_finder, "INPUT")
grovepi.pinMode(line_finder_gauche,"INPUT")
grovepi.pinMode(line_finder_droit, "INPUT")

client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client_socket.connect(("localhost", 8888))

client_socket.send("CAPTEUR\n".encode())

retour = ""

while True:
        from_server = client_socket.recv(4096)
        print("fromserver : ",from_server.decode())
        if (from_server.decode().startswith("QUIT")):
            break
        if (from_server.decode().startswith("getCapteur")):
            
            retour = ""
            # Return HIGH when black line is detected, and LOW when white line is detected
            if grovepi.digitalRead(line_finder_gauche) == 1:
                #print ("lfc 0")
                retour += "0"
            else:
                #print ("lfc 1")
                retour += "1"

            if grovepi.digitalRead(line_finder) == 1:
                #print ("lfg 0")
                retour += "0"
            else:
                #print ("lfg 1")
                retour += "1"

            if grovepi.digitalRead(line_finder_droit) == 1:
                #print ("lfd 0")
                retour += "0"
            else:
                #print ("lfd 1")
                retour += "1"
            

            toServer = "VAL_CAPTEUR:"+retour+"\n"
            print("toServer : ",toServer)
            client_socket.send(toServer.encode())
            retour = ""


client_socket.close()