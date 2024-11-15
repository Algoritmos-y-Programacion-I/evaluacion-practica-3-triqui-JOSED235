package model;
import java.util.Random;

public class Controladora {

    private String[][] tableroTresEnRaya;

    public Controladora() {
        tableroTresEnRaya = new String[3][3];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTresEnRaya[i][j] = " ";
            }
        }
    }

    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tableroTresEnRaya[i][j]);
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("-----\n");
        }
        return sb.toString();
    }

    public void jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!tableroTresEnRaya[i][j].equals(" "));
        tableroTresEnRaya[i][j] = "X";
    }

    /**
     * Realiza una jugada del usuario en las coordenadas proporcionadas.
     * Si la casilla está ocupada, pide una nueva entrada.
     */
    public void jugadaUsuario(int c, int j) {
        while (!tableroTresEnRaya[c][j].equals(" ")) {
            System.out.println("¡Esa casilla ya está ocupada! Por favor elija otra.");
          
        }
        tableroTresEnRaya[c][j] = "O";
    }

    public String validarGanar() {
        String mensaje = "";

    
        for (int m = 0; m < 3; m++) {
            if (tableroTresEnRaya[m][0].equals(tableroTresEnRaya[m][1]) && tableroTresEnRaya[m][1].equals(tableroTresEnRaya[m][2]) && !tableroTresEnRaya[m][0].equals(" ")) {
                mensaje = "Ganador " + tableroTresEnRaya[m][0];
                return mensaje;
            }
        }

      
        for (int m = 0; m < 3; m++) {
            if (tableroTresEnRaya[0][m].equals(tableroTresEnRaya[1][m]) && tableroTresEnRaya[1][m].equals(tableroTresEnRaya[2][m]) && !tableroTresEnRaya[0][m].equals(" ")) {
                mensaje = "Ganador " + tableroTresEnRaya[0][m];
                return mensaje;
            }
        }

        if (tableroTresEnRaya[0][0].equals(tableroTresEnRaya[1][1]) && tableroTresEnRaya[1][1].equals(tableroTresEnRaya[2][2]) && !tableroTresEnRaya[0][0].equals(" ")) {
            mensaje = "Ganador " + tableroTresEnRaya[0][0];
            return mensaje;
        }

  
        if (tableroTresEnRaya[0][2].equals(tableroTresEnRaya[1][1]) && tableroTresEnRaya[1][1].equals(tableroTresEnRaya[2][0]) && !tableroTresEnRaya[0][2].equals(" ")) {
            mensaje = "Ganador " + tableroTresEnRaya[0][2];
            return mensaje;
        }

      
        boolean empate = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tableroTresEnRaya[i][j].equals(" ")) {
                    empate = false;
                    break;
                }
            }
        }
        if (empate) {
            mensaje = "Empate!";
        }

        return mensaje;
    }
}
