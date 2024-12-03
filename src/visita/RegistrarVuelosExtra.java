package vista;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Reserva;

public class ResumenVentas extends Application {

    private ObservableList<Reserva> reservas = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        TableView<Reserva> tableView = new TableView<>();

        TableColumn<Reserva, String> colCliente = new TableColumn<>("Cliente");
        colCliente.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getCliente().getNombre()));

        TableColumn<Reserva, String> colVuelo = new TableColumn<>("Vuelo");
        colVuelo.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getVuelo().getDestino()));

        TableColumn<Reserva, String> colFecha = new TableColumn<>("Fecha");
        colFecha.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getCodigoReserva()));

        tableView.getColumns().addAll(colCliente, colVuelo, colFecha);
        tableView.setItems(reservas);

        // Resumen estadístico
        Label lblTotalVentas = new Label("Total Ventas: $0");
        Label lblTotalClientes = new Label("Total Clientes: 0");

        VBox layout = new VBox(10, tableView, lblTotalVentas, lblTotalClientes);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Resumen de Ventas");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}