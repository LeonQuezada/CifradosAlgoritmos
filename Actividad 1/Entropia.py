# -*- coding: latin-1 -*-
import sys
import math

def entropia (probabilidades):
	H = 0
	for i in range(len(probabilidades)):
		H = H + (probabilidades[i] * math.log(probabilidades[i],2))
	return H * -1
	
print entropia([0.83333,0.16666])