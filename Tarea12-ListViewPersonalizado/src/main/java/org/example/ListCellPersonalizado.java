package org.example;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;

public class ListCellPersonalizado extends ListCell<Pelicula> {
    @Override
    protected void updateItem(Pelicula pelicula, boolean empty){
        super.updateItem(pelicula, empty);

        if(empty || pelicula == null){
            setText(null);
            setGraphic(null);
        }else{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("peliculalistcell.fxml"));
                Parent root = loader.load();
                PeliculaListCellController controller = loader.getController();
                String datosPeli = pelicula.getTitulo() + "(" + pelicula.getAnio() + ") - Dirigida por " + pelicula.getAutor();
                controller.setDatosPelicula(pelicula.getUrl(), datosPeli);
                setGraphic(root);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}