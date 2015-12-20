import socket               # Import socket module
#import netifaces
import os
import subprocess

s = socket.socket()         # Create a socket object
#host=netifaces.ifaddresses('wlan0')[netifaces.AF_INET][0]['addr']
host = os.system("hostname -I")
#host = socket.gethostname() # Get local machine name
port = 12345                # Reserve a port for your service.
s.bind((host, port))        # Bind to the port

s.listen(5)                 # Now wait for client connection.
while True:
   c, addr = s.accept()
   data=c.recv(2)
   print data  
   if(data=="01"):
   	subprocess.call(["xte", "key space"])
   #c.send('Thank you for connecting')
   elif(data=="02"):
   	subprocess.call(["xte","keydown Shift_R"])
   	subprocess.call(["xte","keydown Right"])
   	subprocess.call(["xte","keyup Shift_R"])
   	subprocess.call(["xte","keyup Right"])
   elif(data=="03"):
   	subprocess.call(["xte","keydown Control_R"])
   	subprocess.call(["xte","keydown Right"])
   	subprocess.call(["xte","keyup Control_R"])
   	subprocess.call(["xte","keyup Right"])
   elif(data=="04"):
   	subprocess.call(["xte","keydown Control_R"])
   	subprocess.call(["xte","keydown Left"])
   	subprocess.call(["xte","keyup Control_R"])
   	subprocess.call(["xte","keyup Left"])
   elif(data=="05"):
   	subprocess.call(["xte","keydown Shift_R"])
   	subprocess.call(["xte","keydown Left"])
   	subprocess.call(["xte","keyup Shift_R"])
   	subprocess.call(["xte","keyup Left"])
   elif(data=="06"):
   	subprocess.call(["xte","keydown Control_R"])
   	subprocess.call(["xte","keydown Up"])
   	subprocess.call(["xte","keyup Control_R"])
   	subprocess.call(["xte","keyup Up"])
   elif(data=="07"):
   	subprocess.call(["xte","keydown Control_R"])
   	subprocess.call(["xte","keydown Down"])
   	subprocess.call(["xte","keyup Control_R"])
   	subprocess.call(["xte","keyup Down"])
   elif(data=="08"):
   	subprocess.call(["xte", "key f"])
   elif(data=="09"):
   	subprocess.call(["xte","key t"])
   elif(data=="10"):
   	subprocess.call(["xte","key Up"])
   elif(data=="11"):
   	subprocess.call(["xte","key Down"])
   elif(data=="12"):
   	subprocess.call(["xte","key Left"])
   elif(data=="13"):
   	subprocess.call(["xte","key Right"])
   elif(data=="14"):
   	subprocess.call(["xte","key Return"])
   elif(data=="15"):
   	subprocess.call(["xte","keydown Alt_L"])
   	subprocess.call(["xte","key F4"])
   	subprocess.call(["xte","keyup Alt_L"])
   elif(data=="16"):
   	subprocess.call(["xte","key BackSpace"])
   elif(data=="17"):
   	subprocess.call(["xte","keydown Alt_L"])
   	subprocess.call(["xte","key Tab"])
   elif(data=="18"):
   	subprocess.call(["xte","keydown Alt_L"])
   	subprocess.call(["xte","keydown Shift_L"])
   	subprocess.call(["xte","key Tab"])
   	subprocess.call(["xte","keyup Shift_L"])
   elif(data=="19"):
   	subprocess.call(["xte","keyup Alt_L"])
   c.close()      
