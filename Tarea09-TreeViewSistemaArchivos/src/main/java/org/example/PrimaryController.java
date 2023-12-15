package org.example;

import java.io.File;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;


public class PrimaryController {
    @FXML
    private TreeView<String> treeView;

    @FXML
    private TextArea textArea;

    @FXML
    public void initialize(){
        File f = new File(System.getProperty("user.dir"));
        treeView.setRoot(generarTreeView(f));

        treeView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldV, newV) ->{
            File ficheroSelec = ((FileTreeItem) newV).getFile();
            if(ficheroSelec.isFile()){
                try{
                    Scanner sc = new Scanner(ficheroSelec);
                    while(sc.hasNext()){
                        textArea.appendText(sc.nextLine() + "\n");
                    }
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
    public void escribirFile(){
        TreeItem<String> selected = treeView.getSelectionModel().getSelectedItem();
        if(selected != null){
            textArea.setText(selected.getValue());
        }
    }
}
