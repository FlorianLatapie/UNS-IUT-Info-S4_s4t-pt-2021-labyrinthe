import jpysocket
import socket

host='localhost' #Host Name
port=9000    #Port Number
s=socket.socket() #Create Socket
s.bind((host,port)) #Bind Port And Host
s.listen(5) #Socket is Listening
print("Socket Is Listening....")
connection,address=s.accept() #Accept the Connection
print("Connected To ",address)
while 1 :
    msgsend=jpysocket.jpyencode("MOVE LEFT") #Encript The Msg
    connection.send(msgsend) #Send Msg
    java_msg=connection.recv(1024) #Recieve msg
    java_msg=jpysocket.jpydecode(java_msg) #Decript msg
    print("From java: ",java_msg)
    if(java_msg == "Exit"):
        break
s.close() #Close connection
print("Connection Closed.")