package scr.visita;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CrudEncomiendas extends Application {
    @Override
    public void start(Stage stage) {
        ObservableList<Cliente> clientes = ControladorCentral.clientes;
        ObservableList<Vuelo> vuelos = ControladorCentral.vuelos;
        ObservableList<Encomienda> encomiendas = ControladorCentral.encomiendas;

        TableView<Encomienda> tableView = new TableView<>();
        TableColumn<Encomienda, String> colCliente = new TableColumn<>("Cliente");
        colCliente.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCliente().getNombre()));

        TableColumn<Encomienda, String> colVuelo = new TableColumn<>("Vuelo");
        colVuelo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getVuelo().getDestino()));

        TableColumn<Encomienda, Double> colPeso = new TableColumn<>("Peso");
        colPeso.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPeso()).asObject());

        tableView.getColumns().addAll(colCliente, colVuelo, colPeso);
        tableView.setItems(encomiendas);

        ComboBox<Cliente> cbCliente = new ComboBox<>(clientes);
        cbCliente.setPromptText("Seleccionar Cliente");

        ComboBox<Vuelo> cbVuelo = new ComboBox<>(vuelos);
        cbVuelo.setPromptText("Seleccionar Vuelo");

        TextField txtPeso = new TextField();
        txtPeso.setPromptText("Peso (kg)");

        Button btnAgregar = new Button("Agregar");
        btnAgregar.setOnAction(e -> {
            Cliente cliente = cbCliente.getSelectionModel().getSelectedItem();
            Vuelo vuelo = cbVuelo.getSelectionModel().getSelectedItem();
            double peso = Double.parseDouble(txtPeso.getText());

            if (cliente != null && vuelo != null && peso > 0) {
                encomiendas.add(new Encomienda(cliente, vuelo, peso));
                cbCliente.getSelectionModel().clearSelection();
                cbVuelo.getSelectionModel().clearSelection();
                txtPeso.clear();
            }
        });

        VBox layout = new VBox(10, tableView, cbCliente, cbVuelo, txtPeso, btnAgregar);
        layout.setPadding(new Insets(10));
        Scene scene = new Scene(layout, 600, 400);
        stage.setScene(scene);
        stage.setTitle("CRUD de Encomiendas");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
