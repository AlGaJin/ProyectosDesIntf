package org.example;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.example.apimodels.AnimeData;
import org.example.apimodels.Datum;

import java.io.IOException;

public class PrimaryController {

    public ListView<Datum> listView;

    public void initialize() {

        KitsuAPIClient client = new KitsuAPIClient();
        try {
            AnimeData animes = client.getAnimes(10, 10);
            listView.setItems(FXCollections.observableList(animes.data));

            listView.setCellFactory(new Callback<>() {
                @Override
                public ListCell<Datum> call(ListView<Datum> datumListView) {
                    return new ListCell<>() {
                        @Override
                        protected void updateItem(Datum datum, boolean empty) {
                            super.updateItem(datum, empty);

                            if (datum == null || empty) {
                                setText(null);
                                setGraphic(null);
                            } else {
                                String title = datum.attributes.canonicalTitle;
                                String posterImage = datum.attributes.posterImage.medium;
                                String synopsis = datum.attributes.synopsis;
                                String startDate = datum.attributes.startDate;
                                String ageRating = datum.attributes.ageRating;
                                int episodeCount = datum.attributes.episodeCount;
                                String showType = datum.attributes.showType;

                                try {
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("animelistcell.fxml"));
                                    Parent root = loader.load();
                                    AnimeListCellController controller = loader.getController();
                                    controller.setDatosAnime(title, posterImage, synopsis, startDate, ageRating, episodeCount, showType);
                                    setGraphic(root);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    };
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
