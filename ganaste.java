/* ..............................
 * CREATED BY: Diego V.         .
 * NAME GAME: "adivinar numero"  .
 * VERSION: 1.0 (JAVA EDITION)  .
 * COUNTRY: "EC"                . 
 * CITY: "DURAN"                . 
 * ..............................                             
*/
import javax.swing.*;
import java.util.Scanner;

public class ganaste extends JFrame {
    private JLabel label1;

    // interfaz de mensaje por si el usuario gana varias rondas
    public ganaste() {
        setLayout(null);
        label1 = new JLabel("haz ganado varias rondas!!");
        label1.setBounds(5, 0, 300, 25);
        add(label1);
    }

    public static class perdiste extends JFrame {
        private JLabel label2;

        // interfaz de mensaje por si usuario no gana ninguna ronda (pierde)
        public perdiste() {
            setLayout(null);
            label2 = new JLabel("no haz ganado ni una ronda:(");
            label2.setBounds(5, 0, 300, 25);
            add(label2);
        }
    }

    public static class error extends JFrame {
        private JLabel label3;

        // interfaz de mensaje por si usuario ingresa mal la dificultad
        public error() {
            setLayout(null);
            label3 = new JLabel("Dificultad invalida!!");
            label3.setBounds(5, 0, 300, 25);
            add(label3);
        }
    }

    public static class error2 extends JFrame {
        private JLabel label4;

        // segundo mensaje de error (actua en cadena con el primer error) (al darse este
        // error el usuario automaticamente pierde el juego)
        public error2() {
            setLayout(null);
            label4 = new JLabel("Juego finalizado con errores");
            label4.setBounds(5, 0, 300, 25);
            add(label4);
        }
    }

    public static class ganaste2 extends JFrame {
        private JLabel label5;

        // interfaz de mensaje para indicar que el usuario solo gano una ronda
        public ganaste2() {
            setLayout(null);
            label5 = new JLabel("solo ganaste una ronda!");
            label5.setBounds(5, 0, 300, 25);
            add(label5);
        }
    }

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String h = "a";
        // inicio
        while (h.equals("a")) {
            int rg = 0;
            // el usuario decide cuantas rondas jugar
            System.out.println("ingrese numero de rondas a jugar");
            int nr = scan.nextInt();
            System.out.println("");
            // se pide ingreso de dificultad (usuario debe ingresar la dificultad en
            // palabras NO NUMEROS)
            System.out.println(
                    "ingrese dificultad, por ejemplo si ingresa (facil) tendra 4 intentos, continuemos\n(1 intento \"extremo\")\n(2 intentos \"dificil\")\n(3 intentos \"normal\")\n(4 intentos \"facil\") \n(intentos aleatorios (1/4)\"aleatorio\")");
            String difi = scan.next();
            // en esta version ahora existe una dificultad aleatoria
            difi = difi.toLowerCase();
            // se identifica que dificultad eligio el usuario
            int dif = 0;
            if (difi.equals("facil")) {
                dif = 4;
            } else if (difi.equals("normal")) {
                dif = 3;
            } else if (difi.equals("dificil")) {
                dif = 2;
            } else if (difi.equals("extremo")) {
                dif = 1;
            } else if (difi.equals("aleatorio")) {
                dif = (int) (Math.random() * 4) + 1;
            } else {
                // se muestra primer error
                error error1 = new error();
                error1.setBounds(0, 0, 200, 200);
                error1.setVisible(true);
                error1.setLocationRelativeTo(null);
            }
            // condificion de dificultad
            if (dif == 1 || dif == 2 || dif == 3 || dif == 4) {
                int r = 0;
                int ro = 1;
                while (r != nr) {
                    r = r + 1;
                    int b = 0;
                    // se genera un numero aleatorio entre el 1 al 11 (excluyendo al 11 quedando un
                    // rango de 1-10)
                    int a = (int) (Math.random() * 10) + 1;
                    System.out.println("<<<<<ronda numero: " + ro + ">>>>>");
                    // indica numero de ronda
                    System.out.println("");
                    ro = ro + 1;
                    while (b < dif) {
                        // se ejecuta un numero de intento segun la dificultad que ingreso el usuario
                        System.out.println("ingrese un numero");
                        int c = scan.nextInt();
                        if (c == a) {
                            // esto se cumple si el usuario ingresa el mismo numero que el numero generado
                            // por el programa
                            System.out.println("<<<Felicidades, ganaste esta ronda:)>>>>>>");
                            System.out.println("");
                            b = b + 9;
                            rg = rg + 1;
                        } else {
                            // esto se da si el usuario ingresa otro numero que no es el generado por el
                            // programa
                            System.out.println("<Numero equivocado>");
                            System.out.println("");
                            b = b + 1;
                        }
                    }

                }
            } else {
                // ejecuta segundo mensaje de error
                System.out.println("");
                error2 error3 = new error2();
                error3.setBounds(0, 0, 200, 200);
                error3.setVisible(true);
                error3.setLocationRelativeTo(null);
            }
            // se da cuando se terminan las rondas
            System.out.println("<<<FIN DEL JUEGO>>>>>");
            System.out.println("");
            if (rg == 0) {
                // primera opcion dependiendo del rendimiento del juegador en el juego
                perdiste perdiste1 = new perdiste();
                perdiste1.setBounds(0, 0, 200, 200);
                perdiste1.setVisible(true);
                perdiste1.setLocationRelativeTo(null);
            } else if (rg == 1) {
                // segunda opcion dependiendo del rendimiento del jugador en el juego
                ganaste2 ganaste3 = new ganaste2();
                ganaste3.setBounds(0, 0, 200, 200);
                ganaste3.setVisible(true);
                ganaste3.setLocationRelativeTo(null);
            } else {
                // tercera opcion dependiendo del rendimiento del jugador en el juego
                ganaste ganaste1 = new ganaste();
                ganaste1.setBounds(0, 0, 200, 200);
                ganaste1.setVisible(true);
                ganaste1.setLocationRelativeTo(null);
            }
            System.out.println("");
            // se pide al usuario si quiere salir o volver a jugar
            System.out.println("ingrese (x) para salir y (a) para quedarte");
            String res = scan.next();
            if (res.equals("x")) {
                // se verifica el ingreso
                h = "f";
            } else {
                // se verifica el ingreso
                h = "a";
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

        }

    }
}
/*
 * .......................................
 * DOCUMENTED BY: DIEGO V. .
 * CREATED IN: 13/11/2023 .
 * NEW FEATURES: "DIFICULTAD ALEATORIA" .
 * Version 1.0 (JAVA EDITION) .
 * .......................................
 */
