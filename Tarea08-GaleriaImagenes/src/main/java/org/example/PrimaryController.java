package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class PrimaryController {
    @FXML
    private GridPane grid;
    @FXML
    private Button atrasBtn;
    @FXML
    private File userDir;

    @FXML
    public void initialize(){
        loadGrid(new File(System.getProperty("user.home")));
    }

    @FXML
    public void atras(){
        File f = userDir.getParentFile();
        if(f != null){
            loadGrid(f);
        }
    }

    @FXML
    public void loadGrid(File file){
        grid.getChildren().clear();
        userDir = file;
        int row = 0;
        int column = 0;

        for (File f : file.listFiles()){
            if(f.isDirectory()){
                Button b = new Button(f.getName());
                b.setOnAction(actionEvent -> {loadGrid(f);});
                grid.add(b, column, row);
            }else if(f.isFile() && (f.getName().contains(".jpeg") || f.getName().contains(".png") || f.getName().contains(".jpg"))){
                try{
                    Image img = new Image(new FileInputStream(f));
                    ImageView imgV = new ImageView();
                    imgV.setImage(img);
                    imgV.setFitWidth(150);
                    imgV.setPreserveRatio(true);
                    grid.add(imgV, column, row);
                }catch (Exception e){
                    System.out.println("Deam, how");
                }

            }else{
                grid.add(new Label(f.getName()), column, row);
            }

            if(column > 5){
                column = 0;
                row++;
            }else{
                column++;
            }
        }
    }
}
