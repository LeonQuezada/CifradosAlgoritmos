#! /usr/bin/python
# -*- coding: utf-8 -*-

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


	num = int(raw_input("Introduce el numero del cifrado deceado:"))

	if num==1:
		print cesar(cadena.upper(),2)


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

if __name__ == "__main__":
    main()
