import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class CustomWill implements Initializable {

    @FXML
    private ImageView will1;

    @FXML
    private ImageView will2;

    @FXML
    private ImageView will3;

    @FXML
    private ImageView will4;

    @FXML
    private ImageView will5;

    @FXML
    private ImageView will6;

    @FXML
    private ImageView will7;

    @FXML
    private ImageView will8;

    @FXML
    private AnchorPane AvatarAp;

    @FXML
    private ImageView avatar;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Animmations.trasnlate(will1, 'x', 281, 1200, 1, false);
        Animmations.trasnlate(will2, 'y', 318, 1200, 1, false);
        Animmations.trasnlate(will3, 'y', 281, 1200, 1, false);
        Animmations.trasnlate(will4, 'x', -288, 1200, 1, false);
        Animmations.trasnlate(will5, 'x', 256, 1200, 1, false);
        Animmations.trasnlate(will6, 'y', -220, 1200, 1, false);
        Animmations.trasnlate(will7, 'y', -217, 1200, 1, false);
        Animmations.trasnlate(will8, 'x', -304, 1200, 1, false);

        Animmations.scale(avatar, 'x', 0.2, 1100, 0);

    }



}
