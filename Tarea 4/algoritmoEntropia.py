#! /usr/bin/python
# -*- coding: latin-1 -*-
import sys
from Entropia  import entropia

def main():
    archivo = open(sys.argv[1])
    n = 0
    linea = []
    lista=[]
    linea.append(archivo.readline().strip())
    while linea[n] != "":
        linea.append(archivo.readline().strip())
        n = n + 1

    linea.pop()
    cadena = linea
    for n in range(len(cadena)):
        lista.append(float(cadena[n]))

    print entropia(lista)






if __name__ == "__main__":
    main()
