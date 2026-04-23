package org.example.practica;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Array;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

public class HelloController {

    private Connection conection = main.conexion();

    @FXML
    private TableView<Estudiante> tableViewPersonas;

    @FXML
    private TableColumn<Estudiante, Integer> viewColumNIA;

    @FXML
    private TableColumn<Estudiante, String> viewColumNombre;

    @FXML
    private TableColumn<Estudiante, LocalDate> viewColumFecha;

    @FXML
    private TextField textNIA, textNombre;

    @FXML
    private DatePicker textFecha;

    @FXML
    private Button edtitarButton, eliminarButton, insertarButton, guardarButton;

    @FXML
    private Label welcomeText;

    @FXML
    public void initialize(){
        viewColumNIA.setCellValueFactory(datos -> new SimpleIntegerProperty(datos.getValue().getNia()).asObject());
        viewColumNombre.setCellValueFactory(datos -> new SimpleStringProperty(datos.getValue().getNombre()));
        viewColumFecha.setCellValueFactory(datos ->
                new ReadOnlyObjectWrapper<>(datos.getValue().getFecha_nacimiento()));

        ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

        listaEstudiantes = main.consulta_a_lista();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void onEdtitarButton() {
    }

    @FXML
    public void onEliminarButton() {
    }

    @FXML
    public void onInsertarButton() {
        Integer nia = Integer.parseInt(textNIA.getText());
        String nombre = textNombre.getText();
        LocalDate fecha = textFecha.getValue();

        Estudiante estudiante = new Estudiante(nia, nombre, fecha);

        System.out.println("Estudiante creado: NIA: " + nia + " Nombre: " + nombre + " Fecha " + fecha );

        main.insertar(conection, estudiante);

        textNIA.clear();
        textNombre.clear();

    }

    @FXML
    public void onGuardarButton() {
    }
}
