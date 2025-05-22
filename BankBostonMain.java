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
                    break;
                case 2:
                    Cliente.impresionDatosCliente(cliente, cuenta);
                    break;
                case 3:
                    Cuenta.depositar();
                    break;
                case 4:
                    Cuenta.giro();
                    break;
                case 5:
                    Cuenta.saldo();
                    break;
            }

        }while(opcionMenu<6 && opcionMenu !=0);

        System.out.println("Gracias por preferir Bank Boston");
        System.out.println("Hasta la proxima!");


    }
}