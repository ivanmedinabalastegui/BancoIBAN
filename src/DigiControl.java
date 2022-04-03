public class DigiControl {
    private static String D1;
    private static String D2;
    private static int DG1;
    private static int DG2;
    private static int[] multiplica ={1,2,4,8,5,10,9,7,3,6};

    private static String CuentaDigitos(String digitos) {
        int cont = 0;
        for(int cont1=0; cont1 < digitos.toCharArray().length; cont1++){
            int i = Character.getNumericValue(digitos.toCharArray()[cont1]);
            int multiplicacion = i * multiplica[cont1];
            cont += multiplicacion;
        }
        int total = cont%11;
        total = 11 - total;
        int total1;
        if(total>=0 && total<=9){
            total1 = total;
        } else if (total==10) {
            total1 = 1;
        } else {
            total1 = 0;
        }
        return String.valueOf(total1);
    }
    static String DigitoControl(String c_banco, String c_sucursal, String n_cuenta){
        D1 = "00" + c_banco + c_sucursal;
        D2 = n_cuenta;
        DG1 = Integer.parseInt(CuentaDigitos(D1));
        DG2 = Integer.parseInt(CuentaDigitos(D2));
        return String.valueOf(DG1) + String.valueOf(DG2);
    }
    static void validacion(String c_banco, String c_sucursal,String n_control, String n_cuenta){
        String validar;
        String validar2 = DigitoControl(c_banco, c_sucursal, n_cuenta);
        if(n_control.equals(validar2)){
            validar = "correcta";
        } else {
            validar = "incorrecta";
        }
        String validacion2 = c_banco + " " + c_sucursal + " " + n_control + " " + n_cuenta;
        System.out.println("\nNúmero de cuenta a validar: " + validacion2);
        System.out.println("Dígitos calculados: " + validar2 + "\t Verificación: " + validar);
    }
}
