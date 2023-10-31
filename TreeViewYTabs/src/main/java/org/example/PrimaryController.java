package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.*;


public class PrimaryController {
    @FXML
    private TreeView<String> treeView;

    @FXML
    private TabPane tabPane;
    private LinkedList<File> ficheros;

    @FXML
    public void initialize(){
        File f = new File(System.getProperty("user.dir"));
        treeView.setRoot(generarTreeView(f));

        treeView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldV, newV) ->{
            File ficheroSelec = ((FileTreeItem) newV).getFile();
            if(ficheroSelec.isFile()){
                FileTab tab = new FileTab(((FileTreeItem) newV).getFile());
                tabPane.getTabs().add(tab);
                tabPane.getSelectionModel().select(tabPane.getTabs().size()-1);

                try{
                    Scanner sc = new Scanner(ficheroSelec);
                    TextArea textArea = new TextArea();
                    while(sc.hasNext()){
                        textArea.appendText(sc.nextLine() + "\n");
                    }
                    tab.setContent(textArea);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } );
    }
    @FXML
    public FileTreeItem generarTreeView(File file){
        try{
            FileTreeItem item = new FileTreeItem(file);
            for (File f : file.listFiles()) {
                if(f.isDirectory()){
                    item.getChildren().add(generarTreeView(f));
                }else if(f.isFile()){
                    item.getChildren().add(new FileTreeItem(f));
                }
            }

            return item;
        }catch (Exception e){
            return null;
        }
    }
    @FXML
    public void guardar(){
        FileTab tab = (FileTab) tabPane.getSelectionModel().getSelectedItem();
        try(Scanner sc = new Scanner(((TextArea) tab.getContent()).getText())){
            BufferedWriter bW = new BufferedWriter(new FileWriter(tab.getFile()));

            while(sc.hasNext())
                bW.write(sc.nextLine() + "\n");

            bW.close();

            alerta("Aviso de guardado", "Se han guardado los cambios correctamente.");
        }catch (Exception e){
            alerta("Aviso de guardado", "Se ha producido un error guardando los cambios...");
        }
    }
    @FXML
    private void alerta(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
