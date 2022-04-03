import java.util.Scanner;

public class PilotDigits {
    private static Scanner teclado = new Scanner(System.in);
    private static boolean comprueba = true;
    private static String c_banco;
    private static String c_sucursal;
    private static String n_cuenta;
    private static String n_control;
    private static String n_iban;
    public static void main(String[] args){
        while (comprueba){
            System.out.println("\n\t\t\t\t\033[1mMenú de Opciones\033[0m");
            System.out.println("\t\t\t\t\033[1m================\033[0m\n");
            System.out.println("\t\t1) Generar Dígitos de control");
            System.out.println("\t\t2) Validar Dígitos de control");
            System.out.println("\t\t3) Generar IBAN");
            System.out.println("\t\t4) Validar IBAN");
            System.out.println("\t\t5) Salir");
            System.out.print("\n\t\t\tOpción: ");
            int casos = Integer.parseInt(teclado.nextLine());
            switch(casos) {
                case 1:
                    System.out.print("Introduce el código del banco:");
                    c_banco = teclado.nextLine();
                    System.out.print("Introduce el código de la sucursal:");
                    c_sucursal = teclado.nextLine();
                    System.out.print("Introduce el número de la cuenta:");
                    n_cuenta = teclado.nextLine();
                    System.out.println("\n" + c_banco + " " + c_sucursal + " DC1DC2 " + n_cuenta + "  =>  " + c_banco + " " + c_sucursal + " " + DigiControl.DigitoControl(c_banco, c_sucursal, n_cuenta) + " " + n_cuenta);
                    break;
                case 2:
                    System.out.print("\nNúmero de Banco: ");
                    c_banco = teclado.nextLine();
                    System.out.print("Número de Sucursal: ");
                    c_sucursal = teclado.nextLine();
                    System.out.print("Número de Control: ");
                    n_control = teclado.nextLine();
                    System.out.print("Número de Cuenta: ");
                    n_cuenta = teclado.nextLine();
                    DigiControl.validacion(c_banco, c_sucursal, n_control, n_cuenta);
                    break;
                case 3:
                    System.out.print("\nNúmero de Banco: ");
                    c_banco = teclado.nextLine();
                    System.out.print("Número de Sucursal: ");
                    c_sucursal = teclado.nextLine();
                    System.out.print("Número de Control: ");
                    n_control = teclado.nextLine();
                    System.out.print("Número de Cuenta: ");
                    n_cuenta = teclado.nextLine();

                    System.out.print("\nGenerando IBAN: ");
                    System.out.println(DigiIban.cuentaIBAN(c_banco, c_sucursal, n_control, n_cuenta) + " " +
                            c_banco + " " + c_sucursal + " " + n_control + " " + n_cuenta);
                    break;

                case 4:
                    System.out.print("\nIBAN: ");
                    n_iban = teclado.nextLine();
                    System.out.print("Número de Banco: ");
                    c_banco = teclado.nextLine();
                    System.out.print("Número de Sucursal: ");
                    c_sucursal = teclado.nextLine();
                    System.out.print("Número de Control: ");
                    n_control = teclado.nextLine();
                    System.out.print("Número de Cuenta: ");
                    n_cuenta = teclado.nextLine();

                    DigiIban.validacionIBAN(c_banco, c_sucursal, n_control, n_cuenta, n_iban);
                    break;

                case 5:
                    comprueba = false;
                    break;
            }
        }
    }
}