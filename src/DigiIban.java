import java.math.BigInteger;

public class DigiIban {

    static String cuentaIBAN(String c_banco,String c_sucursal,String n_control, String n_cuenta){

        String conjunto = c_banco + c_sucursal + n_control + n_cuenta + "1428" + "00";
        BigInteger conjuntonuevo = new BigInteger(conjunto);
        BigInteger valor = new BigInteger(String.valueOf(97));
        BigInteger valordivision = conjuntonuevo.mod(valor);
        int resultado = 98 - valordivision.intValue();

        String numIban;

        if(resultado >= 0 && resultado <=9) {
            numIban = "0" + String.valueOf(resultado);
        } else {
            numIban = String.valueOf(resultado);
        }
        return "ES" + numIban;
    }

    static void validacionIBAN(String c_banco,String c_sucursal,String n_control, String n_cuenta, String n_iban){

        String validacion;
        String numeroiban = cuentaIBAN(c_banco, c_sucursal, n_control ,n_cuenta);

        if(numeroiban.equals(n_iban)){
            System.out.println("IBAN calculado: " + numeroiban + "\t");
            validacion = "Correcta";
        } else {
            validacion = "Incorrecta";
        }

        System.out.println("\nNúmero de cuenta a validar: " + numeroiban + " " + c_banco + " " + c_sucursal + " " + n_control + " " + n_cuenta);
        System.out.print("IBAN calculado: " + numeroiban + "\t\t");
        System.out.println("Verificación: " + validacion);
    }
}