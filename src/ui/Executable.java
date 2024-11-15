package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    private Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {
        flag = false;

        while (!flag) {
            System.out.println("\n\nBienvenido al menu:\n");
            System.out.println("Opciones:\n" + 
                               "1. Imprimir tablero \n" + 
                               "2. Jugada de la máquina \n" +
                               "3. Jugada de humano \n" + 
                               "4. Verificar ganador \n" + 
                               "5. Salir del programa \n");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    flag = true;
                    System.exit(0);
                    break;
                default:
                    System.out.print("Por favor ingrese una opcion valida");
                    continue;
            }
        }
    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La máquina ha realizado su jugada.");
        imprimirTablero();
    }

    private void jugadaHumano() {
        System.out.println("NOTA: Recuerda que al ser un juego dentro de una matriz 3x3 el primer elemento va desde 0 y esta hasta 2");
        System.out.println("Por favor indique la coordenada i de su jugada : ");
        int c = reader.nextInt();
        while (c > 2 || c < 0) {
            System.out.println("Digite un número válido");
            c = reader.nextInt();
        }
        System.out.println("Por favor indique la segunda coordenada de su jugada:");
        int i = reader.nextInt();
        while (i > 2 || i < 0) {
            System.out.println("Digite un número válido");
            i = reader.nextInt();
        }
  
        cont.jugadaUsuario(c, i);
        imprimirTablero();
    }

    private void validarGanador() {
        String resultado = cont.validarGanar();
        if (resultado.equals("")) {
            System.out.println("No hay ganador aún.");
        } else {
            System.out.println(resultado);
        }
    }
}
