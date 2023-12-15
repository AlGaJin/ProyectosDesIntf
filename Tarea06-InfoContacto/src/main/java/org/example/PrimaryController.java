package org.example;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

public class PrimaryController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTlf;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ListView listView;
    @FXML
    private Button guardarBtn;
    @FXML
    private Button cancelarBtn;

    @FXML
    public void initialize(){
        listView.getItems().addAll("Deportes","Música","Viajes","Libros");

        datePicker.setConverter(new StringConverter<LocalDate>() {

            final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate date){
                if (date != null)
                    return dateFormatter.format(date);

                return "";
            }

            @Override
            public LocalDate fromString(String string) {
                if(string != null && !string.isEmpty())
                    return LocalDate.parse(string, dateFormatter);

                return null;
            }
        });
    }

    public void guardar(){
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter("contactos.csv", true))) {
            Contacto contacto = new Contacto(txtNombre.getText(), txtEmail.getText(), txtTlf.getText(), datePicker.getValue(), listView.getSelectionModel().getSelectedItem().toString());

            String[] datos = {contacto.getNombre(), contacto.getEmail(), contacto.getTelefono(),
                    contacto.getFechaNacimiento().toString(), contacto.getInteres()};
            csvWriter.writeNext(datos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        limpiarControles();
    }

    private void limpiarControles(){
        txtNombre.clear();
        txtEmail.clear();
        txtTlf.clear();
        datePicker.setValue(null);
        listView.getSelectionModel().clearSelection();
    }

    public void cancelar(){
        Platform.exit();
    }
}
