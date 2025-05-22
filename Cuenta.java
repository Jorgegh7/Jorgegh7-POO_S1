import java.util.Scanner;

public class Cuenta {
    static long numeroCuentaCorriente;
    static int saldoCuentaCorriente;

    public Cuenta(){}

    public Cuenta(long cuentaCorriente, int saldo) {
        this.numeroCuentaCorriente = cuentaCorriente;
        this.saldoCuentaCorriente = saldo;
    }

    public static void depositar(){
        if(Administracion.listaCliente.size()==0){
            System.out.println("Primero debes ser cliente de Bank Boston");
        }else{
            System.out.println("Ingresa el valor que deseas depositar");
            Scanner scanner = new Scanner(System.in);
            int deposito = scanner.nextInt();


            if(deposito <= 0){
                System.out.println("Deposito invalido");
            }else{
                saldoCuentaCorriente = saldoCuentaCorriente + deposito;
                System.out.println("¡Depósito realizado de manera exitosa!");
                System.out.println("Tu nuevo saldo es:");
                System.out.println("$" + saldoCuentaCorriente + " CLP");
            }

        }
    }

    public static void giro() {
        if (Administracion.listaCliente.size() == 0) {
            System.out.println("Primero debes ser cliente de Bank Boston");
        }else{
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingresa el valor que deseas girar");
            int giro= scanner.nextInt();

            if(saldoCuentaCorriente==0){
                System.out.println("No puedes realizar un Giro, no posees dinero en tu cuenta");
            } else if (giro> saldoCuentaCorriente) {
                System.out.println("El Giro que deseas realizar excede tu saldo actual");
            }else if(giro <=0) {
                System.out.println("Acciòn invalida");
            }else{
                System.out.println("Ingresa el valor que deseas Girar");
                saldoCuentaCorriente = saldoCuentaCorriente - giro;
                System.out.println("Tu nuevo saldo es:");
                System.out.println("$" + saldoCuentaCorriente + " CLP");
            }
        }
    }

    public static void  saldo(){
        if(Administracion.listaCliente.size()==0){
            System.out.println("Primero debes ser cliente de Bank Boston");
        }else {
            System.out.println("Saldo actual: $" + saldoCuentaCorriente + " CLP");
        }
    }

    public static long numeroAleatorioCuentaCorriente(){
        double numeroAleatorio = (Math.random()*10000000);
        numeroAleatorio = Math.round(numeroAleatorio);
        return (long) numeroAleatorio;
    }

    public static void creacionCuentaCorriente(){
        saldoCuentaCorriente=0;
        numeroCuentaCorriente = numeroAleatorioCuentaCorriente() +110000000;

        System.out.println("-------------------------");
        System.out.println("Cuenta Corriente Creada");
        System.out.println("Cuenta Corriente Nª: " + numeroCuentaCorriente);
        System.out.println("Tu saldo actual es de: " + "$" + saldoCuentaCorriente + " CLP");
        System.out.println("-------------------------");

    }

    @Override
    public String toString() {
        return "-----------------------" + '\n' +
                "Numero Cuenta Corriente: " + numeroCuentaCorriente+ '\n' +
                "Saldo: $" + saldoCuentaCorriente + "CLP" + '\n' +
                "-----------------------";
    }
}

