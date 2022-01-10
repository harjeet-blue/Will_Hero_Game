import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ThemeController implements Initializable{

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
        scene = new Scene(root, 1100, 600);

        AnchorPane rootanchor =((AnchorPane) root);
        rootanchor.setStyle(theme);

        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Clouds.setStyle("-fx-border-style: solid; -fx-border-color: red; -fx-border-width: 5px;");
        
    }

}
