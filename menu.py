#! /usr/bin/python
# -*- coding: latin-1 -*-

def main():
	cadena = raw_input("Introduce una cadena de texto para que sea cifrada:")
	print " "
	print "La cadena que ingreso es:",cadena
	print " "
	print "Selecione el tipo de cifrado:"
	print " "
	print "1.-cesar"
	print "2.-vigenere "
	print "3.-hill"


	num = int(raw_input("Introduce el numero del cifrado deseado:"))

	if num==1:
		desp = int(raw_input("Introduce el numero para el desplazamiento:"))
		x = cesar(cadena.upper(),desp)
		print x
		print "Mensaje descifrado"
		print descifradorcesar(x,desp)
		raw_input()
		
	if num == 2:
		llave = raw_input("Introduzca una llave: ")
		print vigenere(cadena.upper(), llave.upper())

def cesar(cadena,Px):
	letras=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
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
	letras=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
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
	print llaveIntermedia
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
	
	
if __name__ == "__main__":
    main()
