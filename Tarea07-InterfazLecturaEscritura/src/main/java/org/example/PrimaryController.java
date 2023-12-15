package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PrimaryController {
    @FXML
    private BorderPane borderPane;
    @FXML
    private TextArea txtArea;
    @FXML
    public File seleccionarArchivo(){
        FileChooser fChoo = new FileChooser();
        fChoo.setTitle("Selecciona un archivo");

        return fChoo.showOpenDialog(borderPane.getScene().getWindow());
    }
    @FXML
    public void leer(){
        try(Scanner sc = new Scanner(seleccionarArchivo())){
            while(sc.hasNext())
                txtArea.appendText(sc.nextLine() + "\n");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public void guardar(){
        try(Scanner sc = new Scanner(txtArea.getText())){
            BufferedWriter bW = new BufferedWriter(new FileWriter(seleccionarArchivo()));

            while(sc.hasNext())
                bW.write(sc.nextLine() + "\n");

            bW.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public void limpiar(){
        txtArea.clear();
    }
}
