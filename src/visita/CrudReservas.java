package scr.visita;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CrudReservas extends Application {
    @Override
    public void start(Stage stage) {
        ObservableList<Cliente> clientes = ControladorCentral.clientes;
        ObservableList<Vuelo> vuelos = ControladorCentral.vuelos;
        ObservableList<Reserva> reservas = ControladorCentral.reservas;

        TableView<Reserva> tableView = new TableView<>();
        TableColumn<Reserva, String> colCliente = new TableColumn<>("Cliente");
        colCliente.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCliente().getNombre()));

        TableColumn<Reserva, String> colVuelo = new TableColumn<>("Vuelo");
        colVuelo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getVuelo().getDestino()));

        TableColumn<Reserva, String> colFechaR = new TableColumn<>("Fecha Reserva");
        colFechaR.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFechaR()));

        tableView.getColumns().addAll(colCliente, colVuelo, colFechaR);
        tableView.setItems(reservas);

        ComboBox<Cliente> cbCliente = new ComboBox<>(clientes);
        cbCliente.setPromptText("Seleccionar Cliente");

        ComboBox<Vuelo> cbVuelo = new ComboBox<>(vuelos);
        cbVuelo.setPromptText("Seleccionar Vuelo");

        DatePicker dpFecha = new DatePicker();

        Button btnAgregar = new Button("Agregar");
        btnAgregar.setOnAction(e -> {
            Cliente cliente = cbCliente.getSelectionModel().getSelectedItem();
            Vuelo vuelo = cbVuelo.getSelectionModel().getSelectedItem();
            String fechaR = dpFecha.getValue().toString();

            if (cliente != null && vuelo != null && fechaR != null) {
                reservas.add(new Reserva(cliente, vuelo, fechaR));
                cbCliente.getSelectionModel().clearSelection();
                cbVuelo.getSelectionModel().clearSelection();
                dpFecha.setValue(null);
            }
        });

        VBox layout = new VBox(10, tableView, cbCliente, cbVuelo, dpFecha, btnAgregar);
        layout.setPadding(new Insets(10));
        Scene scene = new Scene(layout, 600, 400);
        stage.setScene(scene);
        stage.setTitle("CRUD de Reservas");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
