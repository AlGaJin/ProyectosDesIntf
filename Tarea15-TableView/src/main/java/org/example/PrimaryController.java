package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {
    @FXML
    private TableView<Producto> tableView;
    @FXML
    private TextField txtField;
    private ObservableList<Producto> productos;

    public void initialize() {
        Producto producto1 = new Producto("Laptop", 999.99, 20, 2.5, new Date(), "Gris", "Plástico", "ABC123");
        Producto producto2 = new Producto("Smartphone", 599.99, 50, 0.3, new Date(), "Negro", "Metal", "XYZ789");
        Producto producto3 = new Producto("Televisor", 799.99, 15, 12.0, new Date(), "Negro", "Plástico", "DEF456");
        Producto producto4 = new Producto("Zapatillas", 49.99, 100, 0.5, new Date(), "Blanco", "Tela", "123GHI");
        Producto producto5 = new Producto("Refrigerador", 799.99, 10, 50.0, new Date(), "Plateado", "Metal", "456JKL");
        Producto producto6 = new Producto("Cámara Digital", 299.99, 30, 0.2, new Date(), "Rojo", "Plástico", "MNO789");
        Producto producto7 = new Producto("Reloj", 199.99, 25, 0.1, new Date(), "Oro", "Metal", "PQR012");
        Producto producto8 = new Producto("Bicicleta", 349.99, 5, 12.0, new Date(), "Azul", "Metal", "STU345");
        Producto producto9 = new Producto("Libro", 19.99, 200, 0.5, new Date(), "N/A", "Papel", "VWX678");
        Producto producto10 = new Producto("Impresora", 149.99, 12, 10.0, new Date(), "Blanco", "Plástico", "YZA901");
        Producto producto11 = new Producto("Auriculares", 39.99, 30, 0.2, new Date(), "Negro", "Plástico", "BCD234");
        Producto producto12 = new Producto("Teclado inalámbrico", 29.99, 25, 0.5, new Date(), "Blanco", "Plástico", "EFG567");
        Producto producto13 = new Producto("Silla de oficina", 79.99, 15, 10.0, new Date(), "Negro", "Cuero", "HIJ890");
        Producto producto14 = new Producto("Cafetera", 49.99, 20, 3.0, new Date(), "Plateado", "Metal", "KLM123");
        Producto producto15 = new Producto("Horno de microondas", 69.99, 10, 15.0, new Date(), "Blanco", "Metal", "NOP456");
        Producto producto16 = new Producto("Pelota de fútbol", 19.99, 50, 0.7, new Date(), "Blanco y negro", "Piel sintética", "QRS789");
        Producto producto17 = new Producto("Gafas de sol", 59.99, 40, 0.1, new Date(), "Negro", "Plástico", "TUV012");
        Producto producto18 = new Producto("Mesa de comedor", 149.99, 8, 20.0, new Date(), "Marrón", "Madera", "WXY345");
        Producto producto19 = new Producto("Batería recargable", 29.99, 60, 0.3, new Date(), "Verde", "Metal", "YZB678");
        Producto producto20 = new Producto("Cepillo de dientes", 4.99, 100, 0.05, new Date(), "Azul", "Plástico", "CDE901");

        productos = FXCollections.observableArrayList();
        productos.addAll(producto1, producto2, producto3, producto4, producto5, producto6, producto7, producto8, producto9, producto10, producto11, producto12, producto13, producto14, producto15, producto16, producto17, producto18, producto19, producto20);

        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Producto, Double> colPrecio = new TableColumn<>("Precio");
        TableColumn<Producto, Integer> colStock = new TableColumn<>("Stock");
        TableColumn<Producto, Double> colPeso = new TableColumn<>("Peso");
        TableColumn<Producto, Date> colFechaVenc = new TableColumn<>("Fecha de Vencimiento");
        TableColumn<Producto, String> colColor = new TableColumn<>("Color");
        TableColumn<Producto, String> colMaterial = new TableColumn<>("Material");
        TableColumn<Producto, String> colNumModelo = new TableColumn<>("Número de Modelo");

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colFechaVenc.setCellValueFactory(new PropertyValueFactory<>("fechaVencimiento"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        colMaterial.setCellValueFactory(new PropertyValueFactory<>("material"));
        colNumModelo.setCellValueFactory(new PropertyValueFactory<>("numModelo"));

        tableView.setPlaceholder(new Label("No se han encontrado productos"));

        tableView.getColumns().addAll(colNombre, colPrecio, colStock, colPeso, colFechaVenc, colColor, colMaterial, colNumModelo);
        tableView.setItems(productos);
    }

    @FXML
    public void buscar(){
        String filtro = txtField.getText();
        ObservableList<Producto> listaFiltrada = productos.filtered(producto -> producto.contieneTexto(filtro));
        tableView.setItems(listaFiltrada);
    }
}
