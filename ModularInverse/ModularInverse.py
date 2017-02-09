'''
Created on 09/02/2017

@author: warhe
'''
from getpass import _raw_input

def egcd(a, b):
    if a == 0:
        return (b, 0, 1)
    else:
        g, y, x = egcd(b % a, a)
        return (g, x - (b // a) * y, y)

def modinv(a, m):
    g, x, y = egcd(a, m)
    if g != 1:
        raise Exception('modular inverse does not exist')
    else:
        return x % m
    
a = _raw_input("a:");
m = _raw_input("m:");
print modinv(int(a), int(m))