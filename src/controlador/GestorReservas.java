package controlador;

import modelo.Cliente;
import modelo.Reserva;
import modelo.Vuelo;

import java.util.ArrayList;
import java.util.List;

public class GestorReservas {
    private List<Vuelo> vuelos;
    private List<Cliente> clientes;
    private List<Reserva> reservas;

    public GestorReservas() {
        this.vuelos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    //Metodos para gestionar vuelos
    public void agregarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
    }

    public List<Vuelo> obtenerVuelos() {
        return vuelos;
    }

    //Metodos para gestionar clientes
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarClientePorRut(String rut) {
        for (Cliente cliente : clientes) {
            if (cliente.getRut().equals(rut)) {
                return cliente;
            }
        }
        return null;
    }

    //Metodos para gestionar reservas
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> obtenerReservas() {
        return reservas;
    }

    public Reserva buscarReservaPorCodigo(String codigoReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigoReserva().equals(codigoReserva)) {
                return reserva;
            }
        }
        return null;
    }
}
