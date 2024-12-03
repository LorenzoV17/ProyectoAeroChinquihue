package modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControladorCentral {
    public static ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    public static ObservableList<Vuelo> vuelos = FXCollections.observableArrayList();
    public static ObservableList<Reserva> reservas = FXCollections.observableArrayList();
    public static ObservableList<Encomienda> encomiendas = FXCollections.observableArrayList();
}
