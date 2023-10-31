package org.example;

import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileTreeItem extends TreeItem<String> {
    private File f;
    public FileTreeItem(File f){
        super(f.getName());
        this.f = f;
        if(f.isDirectory()){
            this.setGraphic(crearImg("./src/main/resources/img/folder.png"));
        } else {
            this.setGraphic(crearImg("./src/main/resources/img/file.png"));
        }
    }

    public ImageView crearImg(String path){
        try {
            Image img = new Image(new FileInputStream(path));
            ImageView imgV = new ImageView();
            imgV.setImage(img);
            imgV.setFitWidth(20);
            imgV.setPreserveRatio(true);

            return imgV;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public File getFile(){
        return f;
    }
}
