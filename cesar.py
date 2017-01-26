#! /usr/bin/python
# -*- coding: utf-8 -*-
import sys

class cripton():

    print("La ñ la cambie por una n")

    def cifrar(cadena,Px):
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
        print(letra)

    def descifrar(cadena,Px):
        letras=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","n","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
        letra = ""
        longitud = len(cadena)
        for i in range(longitud):
            for j in range(27):
                if cadena[i] == " ":
                    letra = letra + " "
                else:
                    if cadena[i] == letras[j]:
                        if cadena[i] == "A":
                            l= letras[24];
                            letra = letra + l
                        elif cadena[i] == "B":
                            l= letras[25];
                            letra = letra + l
                        elif cadena[i] == "C":
                            l= letras[26];
                            letra = letra + l
                        else:
                            l= letras[j-Px];
                            letra = letra + l
        print(letra)

    if sys.argv[1] == "D":
        archivo = open(sys.argv[3], "r")
        Px = int(sys.argv[2])
        linea = archivo.readline()
        descifrar(linea,Px)
    else:
        archivo = open(sys.argv[2], "r")
        Px = int(sys.argv[1])
        linea = archivo.readline()
        cifrar(linea,Px)

