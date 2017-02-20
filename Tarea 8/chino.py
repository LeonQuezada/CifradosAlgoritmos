def main():
    n=3 #numero ecuaciones
    a=[2,1,4]#coeficientes
    m=[3,7,16]#modulos  
    print (teorema_chino_resto(n,a,m))

def teorema_chino_resto(n, a, m):
    if len(a) != len(m) or len(a)!=n or len(m)!=n:
        return "Error en los parametros dados"
    aux=m[:]
    for i in m:
        for j in m:
            if i!=j and euclides_extendido(i,j)[0]!=1:
                return "!= 1"
    x=a[0]
    k=m[0]
    for i in range(1, n):
        ant_x=x
        inv_k=inverso_modular(k, m[i])
        x=((a[i]-ant_x)*inv_k)%m[i]
        r=ant_x+k*x
    return r

def inverso_modular(a, b):
    t=euclides_extendido(a,b)
    if t[0]==1:
        return t[1]%b
    else:
        print("No existe el inverso")



def euclides_extendido(a, b):
    x=0
    y=1
    u=1
    v=0
    while a != 0:
        cociente=b//a
        resto=b%a
        m=x-u*cociente
        n=y-v*cociente

        b=a
        a=resto
        x=u
        y=v
        u=m
        v=n
    mcd = b
    return mcd, x, y

if __name__ == "__main__":
    main()
