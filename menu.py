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
	letra = ""
	longitud = len(cadena)
	for i in range(longitud):
	    for j in range(27):
	        if cadena[i] == " ":
	            letra = letra + " "
	        else:
	            if cadena[i] == letras[j]:
	                if cadena[i] == "Z":
	                    l= letras[Px-1];
	                    letra = letra + l
	                elif cadena[i] == "Y":
	                    l= letras[Px-2];
	                    letra = letra + l
	                elif cadena[i] == "X":
	                    l= letras[Px-3];
	                    letra = letra + l  
	                else:
	                    l= letras[j+Px];
	                    letra = letra + l
	return letra                    

if __name__ == "__main__":
    main()
