import jpysocket
import socket
import time
import grovepi

line_finder_right = 2
line_finder_middle = 3
line_finder_left = 4

grovepi.pinMode(line_finder_right,"INPUT")
grovepi.pinMode(line_finder_middle,"INPUT")
grovepi.pinMode(line_finder_left,"INPUT")

host='localhost' #Host Name
port=8888    #Port Number
s=socket.socket() #Create Socket
s.bind((host,port)) #Bind Port And Host
s.listen(5) #Socket is Listening
print("Socket Is Listening....")
connection,address=s.accept() #Accept the Connection
print("Connected To ",address)
while 1 :
    toReturn = ""
    if grovepi.digitalRead(line_finder_right) == 1:
            toReturn += ("1")
    else:
            toReturn += ("0")
    if grovepi.digitalRead(line_finder_right) == 1:
            toReturn += ("1")
    else:
            toReturn += ("0")
    if grovepi.digitalRead(line_finder_right) == 1:
            toReturn += ("1")
    else:
            toReturn += ("0")
    msgsend=jpysocket.jpyencode("valCapteur "+toReturn) #Encript The Msg
    connection.send(msgsend) #Send Msg
    java_msg=connection.recv(1024) #Recieve msg
    java_msg=jpysocket.jpydecode(java_msg) #Decript msg
    print("From java: ",java_msg)
    if(java_msg == "Exit"):
        break
s.close() #Close connection
print("Connection Closed.")