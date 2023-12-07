from tkinter import messagebox
import os
h=str("s")
while h!="x":
    rg=int(0)
    ron=int(input("ingrese el numero de rondas que le gustaria jugar "))
    print("")
    dif=str(input("ingrese dificultad, por ejemplo si ingresa (facil) tendra 4 intentos, continuemos\n(1 intento \"extremo\")\n(2 intentos \"dificil\")\n(3 intentos \"normal\")\n(4 intentos \"facil\") \n"))
    dif=dif.lower()
    if dif=="extremo":
        dif=int(1)
    elif dif=="dificil":
        dif=int(2)
    elif dif=="normal":
        dif=int(3)
    elif dif=="facil":
        dif=int(4)
    else:
        messagebox.showwarning(message="Mal ingreso de dificultad", title="Error #1")
    if dif==1 or dif==2 or dif==3 or dif==4:
        r=int(0)
        ro=int(1)
        while r!=ron:
            r=int(r+1)
            import random
            b=int(0)
            n=["1","2","3","4","5","6","7","8","9","10"]
            a= random.choice(n)
            print("<<<< RONDA: ",ro,">>>>")
            print("")
            ro=ro+1
            while b<dif:
                n1=input("ingrese el numero ")
                print("")
                if n1==a:
                    print("<< felicidades, ganaste esta ronda :) >>")
                    print("")
                    b=int(b+9)
                    rg=int(rg+1)
                else:
                    print("<equivocado>")
                    print("")
                    b=int(b+1)
    else:
        print("")
        messagebox.showwarning(message="Juego finalizado con errores", title="Error #2 ")
        print("xD")

    print("\t\t\t\t\t\t<<<<< FIN >>>>>")
    print("")
    if rg==0:
        print("\t\t\t\t\t<<< NO GANASTE NI UNA RONDA :( >>>")
    elif rg==1:
        print(messagebox.showinfo(message="Solo ganaste una ronda:/ 1 Ronda", title="ganaste, pero a que costo?"))
    else:
        message = "Felicidades, ganaste {} Rondas".format(rg)
        print(messagebox.showinfo(title="Ganaste:)", message=message))

    print("")
    ab=str(input("<<ingrese (x) si desea salir, o cualquier otra tecla para volver a jugar :)>> "))
    ab=ab.lower()
    if ab=="x":
        h="x"
    else:
        h="s"
    os.system("cls")
