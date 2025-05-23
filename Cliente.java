import java.util.Scanner;

public class Cliente {
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    long telefono;
    private Cuenta cuenta;



    public Cliente() {

    }

    public Cliente(String rut, String nombre, String apellidoPaterno,
                   String apellidoMaterno, String domicilio, String comuna, long telefono, Cuenta cuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
    }

    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public String getComuna() {
        return comuna;
    }
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    public long getTelefono() {
        return telefono;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    public Cliente(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    public Cuenta getCuenta() {
        return cuenta;
    }
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public static void registroCliente(Cliente cliente){
        Scanner scanner= new Scanner(System.in);

        System.out.println("Ingresa tu rut con puntos y guion");
        String accesoRut= scanner.nextLine();

        if(Administracion.clienteRegistradoPorRut.containsKey(accesoRut)){
            System.out.println("Este cliente ya ha sido ingresado");

        }else{
            cliente.setRut(Cliente.rut(accesoRut));
            System.out.println("Ingresa tu Nombre");
            cliente.setNombre(scanner.nextLine());
            System.out.println("Ingresa tu Apellido Paterno");
            cliente.setApellidoPaterno(scanner.nextLine());
            System.out.println("Ingresa tu Apellido Materno");
            cliente.setApellidoMaterno(scanner.nextLine());
            System.out.println("Ingresa tu Domicilio");
            cliente.setDomicilio(scanner.nextLine());
            System.out.println("Ingresa tu Comuna");
            cliente.setComuna(scanner.nextLine());
            cliente.setTelefono(Cliente.telefono());

            System.out.println(cliente);
            Administracion.listaCliente.add(cliente);

            System.out.println();
            System.out.println("Cliente ingresado correctamente");
            System.out.println("Bienvenido a Bank Boston " + cliente.getNombre());
            System.out.println();

            long numeroCuentaCorriente = Cuenta.numeroAleatorioCuentaCorriente() +110000000;
            int saldoInicialCuentaCorriente = 0;

            Cuenta cuenta = new Cuenta(numeroCuentaCorriente, saldoInicialCuentaCorriente);
            cliente.setCuenta(cuenta);
            Administracion.clienteRegistradoPorRut.put(cliente.getRut(), cliente);
            Administracion.cuentaRegistadaPorRut.put(cliente.getRut(), cuenta);


        }
    }

    public static void impresionDatosCliente(Cliente cliente, Cuenta cuenta){
        Scanner scanner= new Scanner(System.in);

        if(Administracion.clienteRegistradoPorRut.isEmpty()){
            System.out.println("Es necesario registrarte como cliente");
        }else{
            System.out.println("Ingresa tu rut:");
            String rut = scanner.nextLine();

            if(Administracion.clienteRegistradoPorRut.containsKey(rut)){
                System.out.println(Administracion.clienteRegistradoPorRut.get(rut));
                System.out.println();
                System.out.println(Administracion.cuentaRegistadaPorRut.get(rut));


            }else{
                System.out.println("Rut ingresado incorrecto o no registrado");
            }
        }
    }

    public static long telefono(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa tu número de Telefono sin el codigo +569");
        long numero= scanner.nextLong();
        while(numero<10000000){
            System.out.println("Numero invalido");
            System.out.println("Ingresa un nuevo numero");
            numero=scanner.nextLong();
        }
        return numero;
    }

    public static String rut(String rut) {
        Scanner scanner= new Scanner(System.in);

        if (rut.length() < 11 | rut.length() > 12) {
            while (rut.length() < 11 | rut.length() > 12) {
                System.out.println("Rut ingresado invalido");
                System.out.println("Ingresa tu rut nuevamente");
                rut = scanner.next();
            }
        }
        return rut;
        }








    @Override
    public String toString() {
        return "Nuevo Cliente" + '\n' +
                "Rut: " + rut + '\n' +
                "Nombre: " + nombre + '\n' +
                "Apellido Paterno: " + apellidoPaterno + '\n' +
                "Apellido Materno: " + apellidoMaterno + '\n' +
                "Domicilio: " + domicilio + '\n' +
                "Comuna: " + comuna + '\n' +
                "Telefono: +569 " + telefono;
    }

}
