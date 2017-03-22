import math
import sys


def main():
	x = int(sys.argv[1])
	print raizPrimo(x)
	print fbPrimalidad(x)
	#print fermat_test(x)

def raizPrimo(x):
	salida=False
	num= int(math.sqrt(x))
	for n in range(2,num):
		if mod(n)==True:
			salida = True
	return salida

def mod(x):
	if x%2==0:
		return True
	else:
		return False

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

	def fermat_test(n,k=100):

		for i in range (0,k):

			a=random.randint(1,n-1)

			if modex(a,n-1,n) != 1:

				return False

		return True
     

if __name__ == '__main__':
	main()