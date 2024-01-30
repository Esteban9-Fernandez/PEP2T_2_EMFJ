package PROG2T.PEP2T_2;

import java.util.Scanner;

public class DigiControl
{
    private int dc1;
    private int dc2;

    public void calcular()
    {
        System.out.println("\nCalculando digitos:");
        System.out.println("===================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca los 4 primeros digitos bancarios: ");
        String banco = scanner.next();

        System.out.print("Introduzca los 4 segundos digitos bancarios: ");
        String sucursal = scanner.next();

        System.out.print("Introduzca los 10 ultimos digitos bancarios: ");
        String cuenta = scanner.next();

        int[] valoresConstantes = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};
        int acumulado = 0;

        for (int i = 0; i < cuenta.length(); i++) {
            int digito = Character.getNumericValue(cuenta.charAt(i));
            acumulado += digito * valoresConstantes[i % 10];
        }

        int resto = acumulado % 11;

        switch (resto) {
            case 10:
                dc1 = 1;
                dc2 = 1;
                break;
            case 11:
                dc1 = 0;
                dc2 = 0;
                break;
            default:
                dc1 = 11 - resto;
                dc2 = 11 - resto;
        }

        System.out.print("\nDígito de control 1: " + dc1);
        System.out.print("\t\tDígito de control 2: " + dc2 + "\n\n");
    }

    public void validar()
    {
        System.out.println("\nValidando digitos:");
        System.out.println("==================\n");

        Scanner scanner = new Scanner(System.in);

        String dc = String.valueOf(dc1) + String.valueOf(dc2);

        System.out.print("Introduzca los 4 primeros digitos bancarios: ");
        String banco = scanner.next();

        System.out.print("Introduzca los 4 segundos digitos bancarios: ");
        String sucursal = scanner.next();

        System.out.print("Introduzca los digitos de control bancarios: ");
        String digitos = scanner.next();

        System.out.print("Introduzca los 10 ultimos digitos bancarios: ");
        String cuenta = scanner.next();

        System.out.println("\nNumero de cuenta a validar: "+ " " + banco + " " + sucursal + " " + digitos + " " + cuenta);

        if (digitos.equals(dc))
        {
            System.out.print("Dígitos calculados: "+ dc);
            System.out.print("\t\tVerificación: Correcta\n\n");
        }
        else
        {
            System.out.print("Dígitos calculados: "+ dc);
            System.out.print("\t\tVerificación: Incorrecta\n\n");
        }
    }
}
