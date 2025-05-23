import java.util.Scanner;

public class Cuenta {
    long numeroCuentaCorriente;
    int saldoCuentaCorriente;

    public Cuenta(){}

    public Cuenta(long cuentaCorriente, int saldo) {
        this.numeroCuentaCorriente = cuentaCorriente;
        this.saldoCuentaCorriente = saldo;
    }

    public long getNumeroCuentaCorriente() {
        return numeroCuentaCorriente;
    }
    public void setNumeroCuentaCorriente(long numeroCuentaCorriente) {
        this.numeroCuentaCorriente = numeroCuentaCorriente;
    }
    public int getSaldoCuentaCorriente() {
        return saldoCuentaCorriente;
    }
    public void setSaldoCuentaCorriente(int saldoCuentaCorriente) {
        this.saldoCuentaCorriente = saldoCuentaCorriente;
    }

    public void depositar(String rut){
        if(Administracion.clienteRegistradoPorRut.containsKey(rut)) {
            Cliente clienteBuscado = (Cliente) Administracion.clienteRegistradoPorRut.get(rut);
            Cuenta cuentaBuscada = clienteBuscado.getCuenta();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingresa el monto que deseas depositar");
            int deposito = scanner.nextInt();
            if(deposito <=0){
                System.out.println("El valor ingresado es incorrecto");
            }else{
                cuentaBuscada.setSaldoCuentaCorriente(cuentaBuscada.getSaldoCuentaCorriente()+ deposito);
                System.out.println("Saldo actual: $" + cuentaBuscada.getSaldoCuentaCorriente() + " CLP");
            }
        }
    }

    public void girar(String rut){
        if(Administracion.clienteRegistradoPorRut.containsKey(rut)){
            Cliente clienteBuscado = (Cliente) Administracion.clienteRegistradoPorRut.get(rut);
            Cuenta cuentaBuscada = clienteBuscado.getCuenta();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingresa el monto que deseas retirar");
            int giro= scanner.nextInt();

            if(giro > clienteBuscado.getCuenta().getSaldoCuentaCorriente()){
                System.out.println("El monto ingresado excede tu saldo actual");
            } else if(giro<=0) {
                System.out.println("Valor ingresado invalido");
            }else{
                cuentaBuscada.setSaldoCuentaCorriente(cuentaBuscada.getSaldoCuentaCorriente() -giro);
                System.out.println("Dinero retirado con éxito");
                System.out.println("Saldo actual: $" + cuentaBuscada.getSaldoCuentaCorriente() + " CLP");
            }
        }else {
            System.out.println("Rut invalido");
        }
    }

    public void saldoCuenta(String rut){
        if(Administracion.clienteRegistradoPorRut.containsKey(rut)){
            System.out.println(Administracion.cuentaRegistadaPorRut.get(rut));
        }else{
            System.out.println("Rut invalido");
        }
    }

    public static long numeroAleatorioCuentaCorriente(){
        double numeroAleatorio = (Math.random()*10000000);
        numeroAleatorio = Math.round(numeroAleatorio);
        return (long) numeroAleatorio;
    }

    @Override
    public String toString() {
        return "-----------------------" + '\n' +
                "Numero Cuenta Corriente: " + getNumeroCuentaCorriente()+ '\n' +
                "Saldo: $" + getSaldoCuentaCorriente() + " CLP" + '\n' +
                "-----------------------";
    }
}

