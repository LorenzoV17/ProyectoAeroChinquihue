import controlador.GestorReservas;
import modelo.Cliente;
import modelo.Reserva;
import modelo.Vuelo;

public class App {
    public static void main(String[] args) {
        //aqui se crea el controlador
        GestorReservas gestor = new GestorReservas();

        //Crear y almacenar los vuelos
        Vuelo vuelo1 = new Vuelo("V001", "Puerto Montt", "Santiago", "10:00", "12:00");
        Vuelo vuelo2 = new Vuelo("V002", "Santiago", "Arica", "14:00", "16:30");
        gestor.agregarVuelo(vuelo1);
        gestor.agregarVuelo(vuelo2);

        //Crear y agregar clientes
        Cliente cliente1 = new Cliente("12345678-9", "Juan Pérez", "juan.perez@gmail.com");
        Cliente cliente2 = new Cliente("98765432-1", "María Gómez", "maria.gomez@gmail.com");
        gestor.agregarCliente(cliente1);
        gestor.agregarCliente(cliente2);

        //crear y almacenar las reservas
        Reserva reserva1 = new Reserva("R001", cliente1, vuelo1);
        Reserva reserva2 = new Reserva("R002", cliente2, vuelo2);
        gestor.agregarReserva(reserva1);
        gestor.agregarReserva(reserva2);

        //Se muestran las reservas
        for (Reserva reserva : gestor.obtenerReservas()) {
            System.out.println(reserva);
        }
    }
}
