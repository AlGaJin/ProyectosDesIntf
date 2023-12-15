package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimeListCellController {
    @FXML
    Label tituloLabel, sinopsisLabel, fechaLabel, ageRatingLabel, totalEpisodiosLabel, showTypeLabel;
    @FXML
    ImageView portadaView;

    public void setDatosAnime(String titulo, String urlImagen, String sinopsis, String fechaInicio, String ageRating, int totalEpisodios, String showType){
        if(!urlImagen.isEmpty()){
            portadaView.setImage(new Image(urlImagen));
            portadaView.setFitHeight(250);
            portadaView.setPreserveRatio(true);
        }

        tituloLabel.setText(titulo);
        sinopsisLabel.setText(sinopsis);
        fechaLabel.setText("Fecha de inicio: " + fechaInicio);
        ageRatingLabel.setText("Age Rating: " + ageRating);
        totalEpisodiosLabel.setText("Total episodios: " + String.valueOf(totalEpisodios));
        showTypeLabel.setText("Tipo de show: " + showType);
    }
}
