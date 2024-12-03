package scr.visita;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CrudVuelos extends Application {
    @Override
    public void start(Stage stage) {
        ObservableList<Vuelo> vuelos = ControladorCentral.vuelos;
        ObservableList<Avion> aviones = FXCollections.observableArrayList(
            new Avion("Cessna 310", 5, 910),
            new Avion("Cessna 208", 9, 1315),
            new Avion("LET 410", 19, 1800)
        );

        TableView<Vuelo> tableView = new TableView<>();
        TableColumn<Vuelo, String> colDestino = new TableColumn<>("Destino");
        colDestino.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDestino()));

        TableColumn<Vuelo, Double> colPrecioP = new TableColumn<>("Precio Pasaje");
        colPrecioP.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrecioP()).asObject());

        TableColumn<Vuelo, Double> colPrecioE = new TableColumn<>("Precio Encomienda");
        colPrecioE.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrecioE()).asObject());

        TableColumn<Vuelo, String> colAvionAsig = new TableColumn<>("Avión Asignado");
        colAvionAsig.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAvionAsig().getModelo()));

        tableView.getColumns().addAll(colDestino, colPrecioP, colPrecioE, colAvionAsig);
        tableView.setItems(vuelos);

        TextField txtDestino = new TextField();
        txtDestino.setPromptText("Destino");

        TextField txtPrecioP = new TextField();
        txtPrecioP.setPromptText("Precio Pasaje");

        TextField txtPrecioE = new TextField();
        txtPrecioE.setPromptText("Precio Encomienda");

        ComboBox<Avion> cbAvionAsig = new ComboBox<>(aviones);
        cbAvionAsig.setPromptText("Seleccionar Avión");

        Button btnAgregar = new Button("Agregar");
        btnAgregar.setOnAction(e -> {
            String destino = txtDestino.getText();
            double precioP = Double.parseDouble(txtPrecioP.getText());
            double precioE = Double.parseDouble(txtPrecioE.getText());
            Avion avionAsig = cbAvionAsig.getSelectionModel().getSelectedItem();

            if (avionAsig != null) {
                vuelos.add(new Vuelo(destino, precioP, precioE, avionAsig));
                txtDestino.clear();
                txtPrecioP.clear();
                txtPrecioE.clear();
                cbAvionAsig.getSelectionModel().clearSelection();
            }
        });

        VBox layout = new VBox(10, tableView, txtDestino, txtPrecioP, txtPrecioE, cbAvionAsig, btnAgregar);
        layout.setPadding(new Insets(10));
        Scene scene = new Scene(layout, 600, 400);
        stage.setScene(scene);
        stage.setTitle("CRUD de Vuelos");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
