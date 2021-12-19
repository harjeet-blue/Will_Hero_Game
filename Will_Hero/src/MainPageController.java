import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class MainPageController implements Initializable {

    @FXML
    private ImageView willHero;

    @FXML
    private ImageView gameName;

    @FXML
    private ImageView pickChest;

    @FXML
    private ImageView rocket;

    @FXML
    private ImageView PlayButton;

    @FXML
    private AnchorPane mainPageAnchorePane;

    @FXML
    private ImageView settings;

    @FXML
    private ImageView axe;

    @FXML
    private ImageView leadersBoard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Animmations.trasnlate(willHero, 'y', -130, 1100, 0, true);
        Animmations.trasnlate(pickChest, 'y', -60, 700, 0, true);
        Animmations.trasnlate(PlayButton, 'x', 800, 2000, 5, false);
        Animmations.trasnlate(settings, 'x', 800, 2000, 5, false);
        Animmations.trasnlate(leadersBoard, 'x', 800, 2000, 5, false);
        Animmations.trasnlate(axe, 'x', 1000, 1450, 5, false);


        Animmations.fadein(gameName, 1.0, 2.0, 4.0);
        Animmations.fadein(PlayButton, 1.0, 2.0, 4.0);
        Animmations.fadein(settings, 1, 2, 4);

        Animmations.flyup(rocket);

        Animmations.scale(willHero, 'y', 0.2, 1100, 0);
        Animmations.scale(gameName, 'x', 0.2, 500, 0);
        Animmations.scale(PlayButton, 'x', 0.2, 500, 1000);
        Animmations.scale(settings, 'x', 0.2, 500, 1000);
        Animmations.scale(leadersBoard, 'x', 0.2, 500, 1000);

        Animmations.rotate(axe, 360);

        ImageView  image = new ImageView("pic/Islands1.png");
        image.setX(20);
        image.setY(20);
        image.setFitHeight(50);
        image.setFitWidth(50);
        //image.setPreserveRatio(true);
        mainPageAnchorePane.getChildren().add(image);
        Animmations.scale(image, 'x', 0.2, 500, 0);
        Animmations.trasnlate(image, 'x', +100, 1000, 0, true);


        while(true){

            System.out.println( image.getLayoutX() +" "+ image.getLayoutY());
            try { 

                TimeUnit.MILLISECONDS.sleep(500);

            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        }

    }

}
