#! /usr/bin/python
# -*- coding: latin-1 -*-
import sys

def main():
	archivo = open(sys.argv[1])
	n = 0
	linea = []
	linea.append(archivo.readline().strip().upper())
	while linea[n] != "":
		linea.append(archivo.readline().strip().upper())
		n = n + 1
	#for linea in archivo.readlines():
		#print ""
	linea.pop()
	cadena = linea
	print " "
	print "La cadena que ingreso es:",linea
	print " "
	print "Selecione el tipo de cifrado:"
	print " "
	print "1.-cesar"
	print "2.-vigenere "
	print "3.-Alberti"


	num = int(raw_input("Introduce el numero del cifrado deseado:"))

	if num==1:
		desp = int(raw_input("Introduce el numero para el desplazamiento:"))
		creartxt()
		for n in range(len(cadena)):
			x = cesar(cadena[n],desp)
			grabartxt(x)
		print "Terminado"
		#x = cesar(cadena,desp)
		#print cesar(cadena,desp)
		#print "Mensaje descifrado"
		#print descifradorcesar(x,desp)
		
		#creartxt()
		#grabartxt(cesar(cadena,desp))
		
	if num == 2:
		creartxt()
		llave = raw_input("Introduzca una llave: ")
		for n in range(len(cadena)):
			grabartxt(vigenere(cadena[n],llave.upper()))
		print "Terminado"
		#m1 = vigenere(cadena, llave)
		#print "Mensaje cifrado: ",m1
		#print "descifrado: ",descifradoVigenere(m1,llave)


	if num == 3:
		desp = int(raw_input("Introduce el numero para el desplazamiento:"))
		creartxt()
		for n in range(len(cadena)):
			grabartxt(cifradoAlberti(cadena[n],desp))
		print "Terminado"
		#print cifradoAlberti(cadena,desp)
		#print "Mensaje descifrado"
		#x = cifradoAlberti(cadena,desp)
		#print descifradoAlberti(x,desp)

		#creartxt()
		#grabartxt(x)

def cesar(cadena,Px):
	letras=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","n","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
	letras = letras + letras + letras
	letra = ""
	longitud = len(cadena)
	for i in range(longitud):
		if cadena[i] == " ":
			letra = letra + " "
		for j in range(27):
			if cadena[i] == letras[j]:
				letra =letra + letras[j+Px]

	return letra 

def descifradorcesar(cadena,Px):
	letras=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","n","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
	letras = letras + letras + letras
	letra = ""
	longitud = len(cadena)
	for i in range(longitud):
		if cadena[i] == " ":
			letra = letra + " "
		for j in range(27):
			if cadena[i] == letras[j]:
				letra =letra + letras[j-Px]

	return letra 

def buscarI(letra):
	recta = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
	count = 1
	for i in range(len(recta)):
		if letra == recta[i]:
			return count
		else:
			count = count + 1

def vigenere (mensaje, llave):
	recta = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
	
	llaveIntermedia = ""
	count = 0
	for i in range(len(mensaje)):
		if mensaje[i] == " ":
			llaveIntermedia = llaveIntermedia + " "
			count = count - 1
		else:
			llaveIntermedia = llaveIntermedia + llave[count]
		count = (count + 1)
		if (count == len(llave)):
			count = 0
	C1 = ""
	numero = 26
	for i in range(len(mensaje)):
		if mensaje[i] == " ":
			C1 = C1 + " "
			i = i - 1
		elif buscarI(mensaje[i])+buscarI(llaveIntermedia[i]) >= len(mensaje): 
			pos = buscarI(mensaje[i]) + buscarI(llaveIntermedia[i]) - numero
			C1 = C1 + recta[pos-1]
		else :
			pos = buscarI(mensaje[i]) + buscarI(llaveIntermedia[i])
			C1 = C1 + recta[pos-1]
		
	return C1
	
def descifradoVigenere(cifrado, llave):
	recta = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
	cifrado = cifrado.upper()
	llave = llave.upper()
	mensaje = ""
	
	llaveIntermedia = ""
	count = 0
	for i in range(len(cifrado)):
		if cifrado[i] == " ":
			llaveIntermedia = llaveIntermedia + " "
			count = count - 1
		else:
			llaveIntermedia = llaveIntermedia + llave[count]
		count = (count + 1)
		if (count == len(llave)):
			count = 0
	
	for i in range(len(cifrado)):
		if cifrado[i] == " ":
			mensaje = mensaje + " "
		else:	
			i1 = buscarI(cifrado[i])
			i2 = buscarI(llaveIntermedia[i])
			indice =  i1 - i2
			if indice > 26:
				indice = indice - 26
			elif indice < -26:
				indice = indice + 26
			mensaje = mensaje + recta[indice-1]
		
	return mensaje

def desplazamientoAlberti(num):
	a2="gklnprtuz&xysomqihfdbace"
	a3= a2 + a2 + a2
	a1len = len(a2)
	salida = ""
	for i in range(a1len):
		salida =  salida + a3[i+num]

	return salida

def cifradoAlberti(cadena,num):
	a1="ABCDEFGILMNOPQRSTVXZ1234"
	a2=desplazamientoAlberti(num)
	a1len = len(a1)
	cadenalen= len(cadena)
	salida = ""
	for i in range(cadenalen):
		if cadena[i] == " ":
			salida = salida + " "
		for j in range(a1len):
			if cadena[i] == a1[j]:
				salida = salida + a2[j]
	return salida

def descifradoAlberti(cadena,num):
	a2="ABCDEFGILMNOPQRSTVXZ1234"
	a1=desplazamientoAlberti(num)
	a1len = len(a1)
	cadenalen= len(cadena)
	salida = ""
	for i in range(cadenalen):
		if cadena[i] == " ":
			salida = salida + " "
		for j in range(a1len):
			if cadena[i] == a1[j]:
				salida = salida + a2[j]
	return salida




def creartxt():
    archi=open('salida.txt','w')
    archi.close()

def grabartxt(x):
    archi=open('salida.txt','a')
    archi.write(x+"\n")
    archi.close()
	
if __name__ == "__main__":
    main()
