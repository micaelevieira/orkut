#!/usr/bin/env python
#-*-coding: utf-8-*-
# Enviar senha por email
import email.mime.application
import smtplib, email, mimetypes
import sys
from email.mime.text import MIMEText
import os
import time

while (os.system("ping 8.8.8.8 -c 1 ") != 0):
	time.sleep(1)
	pass



# Primeiro parâmetro: Nome completo do usuário
# Segundo parâmetro: Email de destino
# Terceiro parâmetro: Nova senha 

# Variável mensagem contem o email que será enviado, em html 
mensagem = """<html>
<head></head>
<body>
<center><img src="http://bit.do/orkutmicaele" align="bottom"> </center>
<h2>Olá, %s.</h2>
Você solicitou uma nova senha para entrar no Orkut.
<br>
Sua nova senha é <b>%s</b>
<br>
É recomendado que você altere sua senha na próxima vez que entrar no sistema.
<br>
Atenciosamente,<br><br>
Orkut.
<br>
<center>
<pre><div style="border: 1px solid rgb(0, 0, 0); padding: 5px; overflow: auto; background-color: rgb(247, 248, 249);"> © 2016 Orkut
</div></pre>
<center>
</body>
</html>
""" % (sys.argv[1].split(" ")[0].replace('"', ""), sys.argv[3])


texto = MIMEText(mensagem, 'html')
msg = email.mime.Multipart.MIMEMultipart()
msg['Subject'] = 'Recuperar Senha | Orkut'
msg['From'] = 'orkutqx@gmail.com'
msg['To'] = sys.argv[1]
msg.attach(texto)

s = smtplib.SMTP('smtp.gmail.com:587')
s.starttls()
s.login('orkutqx@gmail.com',"encryptedpassword")
s.sendmail('orkutqx@gmail.com',[sys.argv[2]], msg.as_string())
s.quit()
