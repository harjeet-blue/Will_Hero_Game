// package willHero;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));

            // File directory = new File("./");
            // System.out.println(directory.getAbsolutePath());
            Image icon = new Image("pic/Will.png");
          
            primaryStage.getIcons().add(icon);

            Scene scene = new Scene(root, 1100, 600);

            // ImageView  image = new ImageView("pic/Will.png");
            // image.setX(20);
            // image.setY(20);
            // image.setFitHeight(50);
            // image.setFitWidth(50);
            // image.setPreserveRatio(true);

            // AnchorPane rootanchor =((AnchorPane) root);
            // rootanchor.getChildren().add(image);
            //rootanchor.setStyle("-fx-background-image: url('pic/bg2.jpg');");

            primaryStage.setTitle("Will Hero");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
        
    }

}


