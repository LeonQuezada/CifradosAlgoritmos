'''
Created on 21/02/2017

@author: warhe
'''

class FuerzaBruta(object):
    '''
    classdocs
    '''
    
    numero = 0

        
    def fbPrimalidad(self, n):
        contadorPasos = 0
        contadorDivisiones = 0
        numero = n
        tamano = n
        while(tamano > 0):
            contadorPasos = contadorPasos + 1
            if numero % tamano == 0:
                contadorDivisiones = contadorDivisiones + 1
            
            tamano = tamano - 1
        
        return ['Numero de Pasos:' + str(contadorPasos), 'Numero de divisiones posibles:' + str(contadorDivisiones)] 
            
    print fbPrimalidad(object, 1980)
            
    
