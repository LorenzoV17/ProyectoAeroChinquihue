package scr.visita;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CrudClientes extends Application {
    @Override
    public void start(Stage stage) {
        ObservableList<Cliente> clientes = ControladorCentral.clientes;

        TableView<Cliente> tableView = new TableView<>();
        TableColumn<Cliente, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));

        TableColumn<Cliente, Integer> colNumV = new TableColumn<>("N° Vuelos");
        colNumV.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getNumV()).asObject());

        TableColumn<Cliente, Boolean> colEsClienteF = new TableColumn<>("Frecuente");
        colEsClienteF.setCellValueFactory(data -> new SimpleBooleanProperty(data.getValue().isEsClienteF()).asObject());

        tableView.getColumns().addAll(colNombre, colNumV, colEsClienteF);
        tableView.setItems(clientes);

        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");

        TextField txtNumV = new TextField();
        txtNumV.setPromptText("N° Vuelos");

        Button btnAgregar = new Button("Agregar");
        btnAgregar.setOnAction(e -> {
            String nombre = txtNombre.getText();
            int numV = Integer.parseInt(txtNumV.getText());
            clientes.add(new Cliente(nombre, numV));
            txtNombre.clear();
            txtNumV.clear();
        });

        Button btnEliminar = new Button("Eliminar");
        btnEliminar.setOnAction(e -> {
            Cliente clienteSeleccionado = tableView.getSelectionModel().getSelectedItem();
            if (clienteSeleccionado != null) {
                clientes.remove(clienteSeleccionado);
            }
        });

        VBox layout = new VBox(10, tableView, new HBox(10, txtNombre, txtNumV, btnAgregar), btnEliminar);
        layout.setPadding(new Insets(10));
        Scene scene = new Scene(layout, 600, 400);
        stage.setScene(scene);
        stage.setTitle("CRUD de Clientes");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
