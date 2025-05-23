import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Administracion {
    static ArrayList <Cliente> listaCliente = new ArrayList<>();
    static HashMap <String, Object> clienteRegistradoPorRut = new HashMap<>();
    static HashMap <String, Object> cuentaRegistadaPorRut = new HashMap<>();


    public static void Bienvenida(){
        System.out.println("=================");
        System.out.println("|  BANK BOSTON  |");
        System.out.println("=================");
        System.out.println();
        System.out.println("Bienvenido a Bank Boston!");


    }

    public static void Menu(){
        System.out.println();
        System.out.println("Escoge tu opciòn:");
        System.out.println("1. Registrar Cliente");
        System.out.println("2. Ver datos Cliente");
        System.out.println("3. Depositar");
        System.out.println("4. Girar");
        System.out.println("5. Consultar Saldo");
        System.out.println("6. Salir");

    }
}
