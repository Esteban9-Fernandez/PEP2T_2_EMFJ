package PROG2T.PEP2T_2;

import java.util.Scanner;
import java.math.BigInteger;

class DigiIban
{
    private String IBAN;

    public void calcular()
    {
        System.out.println("\nCalculando IBAN:");
        System.out.println("===================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca los 4 primeros digitos bancarios: ");
        String banco = scanner.next();

        System.out.print("Introduzca los 4 segundos digitos bancarios: ");
        String sucursal = scanner.next();

        System.out.print("Introduzca los digitos de control bancarios: ");
        String dc = scanner.next();

        System.out.print("Introduzca los 10 ultimos digitos bancarios: ");
        String cuenta = scanner.next();

        String cuentaCompleta = banco + sucursal + dc + cuenta + "1428" + "00";
        BigInteger completa = new BigInteger(cuentaCompleta);

        BigInteger resto = completa.mod(BigInteger.valueOf(97));
        BigInteger resta = BigInteger.valueOf(98).subtract(resto);

        if (resta.compareTo(BigInteger.valueOf(9)) <= 0) {
            IBAN = "0" + resta;
        } else {
            IBAN = resta.toString();
        }

        System.out.println("IBAN: ES" + IBAN + "\n");
    }

    public void validar()
    {
        System.out.println("\nValidando IBAN:");
        System.out.println("==================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca los 4 primeros digitos bancarios: ");
        String banco = scanner.next();

        System.out.print("Introduzca los 4 segundos digitos bancarios: ");
        String sucursal = scanner.next();

        System.out.print("Introduzca los digitos de control bancarios: ");
        String digitos = scanner.next();

        System.out.print("Introduzca los 10 ultimos digitos bancarios: ");
        String cuenta = scanner.next();

        System.out.print("Introduzca los digitos de su IBAN: ");
        String digits = scanner.next();

        System.out.println("\nNumero de cuenta a validar: "+ "ES" + IBAN + " " + banco + " " + sucursal + " " + digitos + " " + cuenta);

        if (digits.equals(IBAN))
        {
            System.out.print("Dígitos calculados: "+ "ES" + IBAN);
            System.out.print("\t\tVerificación: Correcta\n\n");
        }
        else
        {
            System.out.print("Dígitos calculados: "+ "ES" + IBAN);
            System.out.print("\t\tVerificación: Incorrecta\n\n");
        }
    }
}

