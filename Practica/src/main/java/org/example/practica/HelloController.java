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
    private Label textLabel;

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

        tableViewPersonas.setItems(main.consulta_a_lista(conection));

    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void onEdtitarButton() {
        Estudiante seleccionado = tableViewPersonas.getSelectionModel().getSelectedItem();

        if (seleccionado == null){
            textLabel.setText("No hay nada seleccionado");
        }else {
            insertarButton.setDisable(true);
            guardarButton.setDisable(false);
            textNIA.setText(seleccionado.getNia().toString());
            textNIA.setDisable(true);
            textNombre.setText(seleccionado.getNombre());
            textFecha.setValue(seleccionado.getFecha_nacimiento());

            textLabel.setText("Estudiante modificado");
        }

        tableViewPersonas.setItems(main.consulta_a_lista(conection));
    }

    @FXML
    public void onEliminarButton() {
        Estudiante estudiante = tableViewPersonas.getSelectionModel().getSelectedItem();

        if (estudiante == null){
            textLabel.setText("NO HAS SELECCIONADO");
        }else {
            main.borrar(conection,estudiante);
            textLabel.setText("Estudiante borrado");
        }

        tableViewPersonas.setItems(main.consulta_a_lista(conection));
    }

    @FXML
    public void onInsertarButton() {
        Integer nia = Integer.parseInt(textNIA.getText());
        String nombre = textNombre.getText();
        LocalDate fecha = textFecha.getValue();

        System.out.println("Estudiante creado: NIA: " + nia + " Nombre: " + nombre + " Fecha " + fecha );

        main.insertar(conection, new Estudiante(nia, nombre, fecha));

        textNIA.clear();
        textNombre.clear();
        textFecha.setValue(null);
        tableViewPersonas.setItems(main.consulta_a_lista(conection));
    }

    @FXML
    public void onGuardarButton() {
        Integer nia = Integer.parseInt(textNIA.getText());
        textNIA.setDisable(true);
        String nombre = textNombre.getText();
        LocalDate fecha = textFecha.getValue();

        main.modificar(conection,new Estudiante(nia,nombre,fecha));

        insertarButton.setDisable(false);
        guardarButton.setDisable(true);
        textNIA.clear();
        textNIA.setDisable(false);
        textNombre.clear();
        textFecha.setValue(null);

        tableViewPersonas.setItems(main.consulta_a_lista(conection));
    }

}
