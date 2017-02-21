

def main():
    x = int(raw_input("Introduce el nuemero:"))
    ex = int(raw_input("Introduce el Exponente:"))
    mod = int(raw_input("Introduce el Modulo:"))

    print "Respuesta: "+str((pow(x,ex)%mod))

def pow(x,n):
    cont = 0
    cont = cont + 1
    r = 1
    y = x
    while n > 1:
        cont = cont + 1
        if n%2:
            r = r * y
        n = int(n/2)
        y = y * y
    r = r*y
    print "Pasos Realizados",cont
    return r

if __name__ == "__main__":
    main()
