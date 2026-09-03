package com.example.registroproductos.controller;

import com.example.registroproductos.model.Producto;
import com.example.registroproductos.repository.ProductoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.LocalDate;
import java.util.Locale;

public class ProductoController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtPrecio;

    @FXML
    private DatePicker dtpFecha;

    @FXML
    private ImageView imgProducto;

    @FXML
    private TableView<Producto> tblProductos;

    @FXML
    private TableColumn<Producto, Integer> colId;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, String> colCategoria;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, LocalDate> colFecha;

    private final ObservableList<Producto> productos = FXCollections.observableArrayList();
    private final ProductoRepository productoRepository = new ProductoRepository();
    private String selectedImagePath;


    @FXML
    public void initialize(){
        configureTable();
        configureDataPicker();
        loadInitialData();
    }

    private void configureTable() {
        colId.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("Precio"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("Fecha de registro"));

        tblProductos.setItems(productos);
    }

    private void configureDataPicker() {
        dtpFecha.setValue(LocalDate.now());
    }

    private void loadInitialData() {
        productos.addAll(productoRepository.findAll());
    }

    private void configureTableSelection(){
        tblProductos.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        loadProductoIntoForm(newValue);
                    }
                });
    }

    private void loadProductoIntoForm(Producto producto) {
        txtNombre.setText(producto.getNombre());
        txtCategoria.setText(producto.getCategoria());
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        dtpFecha.setValue(producto.getFechaRegistro());
        showImage(selectedImagePath);
    }

    private void showImage(String imagePath){
        if(imagePath == null || imagePath.isEmpty()){
            imgProducto.setImage(null);
            return;
        }

        Image image = new Image(imagePath, 180, 150, true, true);
        imgProducto.setImage(image);

    }

    private boolean validateForm() {
        String nombre = txtNombre.getText().trim();
        String categoria = txtCategoria.getText().trim();
        String precioText = txtPrecio.getText().trim();
        LocalDate fecha = dtpFecha.getValue();

        if(nombre.isBlank() || categoria.isBlank() || precioText.isBlank() || fecha == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error de validación");
            alert.setHeaderText(null);
            alert.setContentText("Todos los campos son obligatorios.");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    @FXML
    private void clearForm(){
        txtNombre.clear();
        txtCategoria.clear();
        txtPrecio.clear();
        dtpFecha.setValue(LocalDate.now());
        selectedImagePath = null;
        tblProductos.getSelectionModel().clearSelection();
        txtNombre.requestFocus();
    }

    private void addProducto() {
        if (!validateForm()) {
            return;
        }else {
            Producto producto = new Producto(
                    productos.size() + 1,
                    txtNombre.getText().trim(), // trim: eliminar espacios de inicio y final de una cadena
                    txtCategoria.getText().trim(),
                    Double.parseDouble(txtPrecio.getText().trim()),
                    dtpFecha.getValue(),
                    selectedImagePath
            );
        }
    }
}







