package org.example;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class PrimaryController {

    @FXML
    private ListView<Pelicula> listView;

    @FXML
    public void initialize(){
        listView.getItems().add(new Pelicula("Forrest Gump", "Robert Zemeckis", 1994, ""));
        listView.getItems().add(new Pelicula("Pulp Fiction", "Quentin Tarantino", 1994, "https://media.tenor.com/fVnGciRcpXoAAAAC/calamardo.gif"));
        listView.getItems().add(new Pelicula("El Señor de los Anillos: La Comunidad del Anillo", "Peter Jackson", 2001, "https://play-lh.googleusercontent.com/imeAs3_Nb9fyoj56LgLzSRBs3UXTZTH_TLg2xMkg6J90ZPzxscAXPvtsR9Q9azxe-WCy5A"));
        listView.getItems().add(new Pelicula("Matrix", "Lana Wachowski, Lilly Wachowski", 1999, ""));
        listView.getItems().add(new Pelicula("Star Wars: Episodio IV - Una Nueva Esperanza", "George Lucas", 1977, "https://ladarsenacm.com/wp-content/uploads/2018/08/10agosto-cine-star-wars-4-manzanares-el-real.png"));
        listView.getItems().add(new Pelicula("Jurassic Park", "Steven Spielberg", 1993, ""));
        listView.getItems().add(new Pelicula("Gladiador", "Ridley Scott", 2000, "https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/p24674_p_v8_ae.jpg"));

        listView.setCellFactory(peliculaListView -> new ListCellPersonalizado());
    }
}
