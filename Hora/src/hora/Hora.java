package hora;

import java.util.Scanner;

public class Hora {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int H, M;

        Opera obj = new Opera();

        System.out.print("Ingrese Horas: ");
        H = teclado.nextInt();

        System.out.print("Ingrese Minutos: ");
        M = teclado.nextInt();

        System.out.print("Son las: " + obj.Hora(H) + obj.Minuto(M));
    }
}
