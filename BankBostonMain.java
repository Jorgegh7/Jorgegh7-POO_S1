import java.util.Scanner;

public class BankBostonMain {
    public static void main(String[] args) {
        
        Cliente cliente = new Cliente();
        Cuenta cuenta = new Cuenta();
        Scanner scanner= new Scanner(System.in);
        int opcionMenu;
        
        Administracion.Bienvenida();

        do {
            Administracion.Menu();
            opcionMenu= scanner.nextInt();

            switch (opcionMenu){
                case 1:
                    Cliente.registroCliente(cliente);

                    System.out.println("-------------------------");
                    System.out.println("Cuenta Corriente Creada");
                    System.out.println("Cuenta Corriente Nª: " + cliente.getCuenta().getNumeroCuentaCorriente());
                    System.out.println("Tu saldo actual es de: " + "$" + cliente.getCuenta().getSaldoCuentaCorriente() + " CLP");
                    System.out.println("-------------------------");



                    break;
                case 2:
                    Cliente.impresionDatosCliente(cliente, cuenta);
                    break;
                case 3:
                    Scanner scannerDepositar = new Scanner(System.in);
                    if (Administracion.listaCliente.size() == 0) {
                        System.out.println("Primero debes ser cliente de Bank Boston");
                    }else {
                        System.out.println("Ingresa tu rut");
                        String rut = scannerDepositar.nextLine();
                        cuenta.depositar(rut);
                    }
                    break;
                case 4:
                    Scanner scannerGiro=new Scanner(System.in);

                    if (Administracion.listaCliente.size() == 0) {
                        System.out.println("Primero debes ser cliente de Bank Boston");
                    }else {
                        System.out.println("Ingresa tu rut");
                        String rut = scannerGiro.nextLine();
                        cuenta.girar(rut);
                    }
                    break;
                case 5:
                    Scanner scannerSaldo = new Scanner(System.in);
                    if(Administracion.listaCliente.size()==0){
                        System.out.println("Primero debes ser cliente de Bank Boston");
                    }else {
                        System.out.println("Ingresa tu rut");
                        String rut = scannerSaldo.nextLine();
                        cuenta.saldoCuenta(rut);
                    }
                    break;


            }

        }while(opcionMenu<6 && opcionMenu !=0);

        System.out.println("Gracias por preferir Bank Boston");
        System.out.println("Hasta la proxima!");


    }
}
