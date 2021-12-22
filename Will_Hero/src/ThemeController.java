import java.io.IOException;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ThemeController{

    @FXML
    private ImageView Clouds;

    @FXML
    private ImageView beach;

    @FXML
    private ImageView clearSky;

    @FXML
    private ImageView evening;

    @FXML
    private ImageView nightMode;

    @FXML
    private ImageView sunSet;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private String theme;
    
    @FXML
    void changeThemetoClearsky(MouseEvent event) throws IOException  {

        theme = "-fx-background-image: url('pic/clouds.jpg'); -fx-background-size: cover;";
        Change(event, theme);
        
    }

    @FXML
    void changeThemetoBeach(MouseEvent event) throws IOException {

        theme = "-fx-background-image: url('pic/beach.jpg'); -fx-background-size: cover;";
        Change(event, theme);
    }

    @FXML
    void changeThemetoClouds(MouseEvent event) throws IOException {
        theme = "-fx-background-image: url('pic/bg2.jpg'); -fx-background-size: cover;";
        Change(event, theme);
    }

    @FXML
    void changeThemetoEvening(MouseEvent event) throws IOException {
        theme = "-fx-background-image: url('pic/evening.jpg'); -fx-background-size: cover;";
        Change(event, theme);
    }

    @FXML
    void changeThemetoNightmode(MouseEvent event) throws IOException {
        theme = "-fx-background-image: url('pic/nightmode.jpg'); -fx-background-size: cover;";
        Change(event, theme);
    }

    @FXML
    void changeThemetoSunset(MouseEvent event) throws IOException {
        theme = "-fx-background-image: url('pic/sunset.jpg'); -fx-background-size: cover;";
        Change(event, theme);
    }

    void Change(MouseEvent event, String theme) throws IOException{

        root = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // Image icon = new Image("pic/Will.png");
        // stage.getIcons().add(icon);
        scene = new Scene(root, 1100, 600);

        AnchorPane rootanchor =((AnchorPane) root);
        rootanchor.setStyle(theme);

        //stage.setTitle("Will Hero");
        stage.setScene(scene);
        //stage.setResizable(false);
        stage.show();

    }

}
