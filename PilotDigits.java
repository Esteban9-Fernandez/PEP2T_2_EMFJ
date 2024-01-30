package PROG2T.PEP2T_2;

import java.util.Scanner;

public class PilotDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DigiControl clase1 = new DigiControl();
        DigiIban clase2 = new DigiIban();

        while (true) {
            System.out.println("Menú");
            System.out.println("====\n");
            System.out.println("1) Generar dígitos de control");
            System.out.println("2) Validar dígitos de control");
            System.out.println("3) Generar IBAN");
            System.out.println("4) Validar IBAN");
            System.out.println("5) Salir");

            System.out.print("\nIngrese la opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    clase1.calcular();
                    break;
                case 2:
                    clase1.validar();
                    break;
                case 3:
                    clase2.calcular();
                    break;
                case 4:
                    clase2.validar();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}