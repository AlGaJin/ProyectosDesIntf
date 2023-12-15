package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PeliculaListCellController {
    @FXML
    private Label datosPeliculaLabel;
    @FXML
    private ImageView imageView;

    public void setDatosPelicula(String url, String datosPelicula){

        if(!url.isEmpty()){
            imageView.setImage(new Image(url));
            imageView.setFitHeight(100);
            imageView.setPreserveRatio(true);
        }

        datosPeliculaLabel.setText(datosPelicula);
    }

}
