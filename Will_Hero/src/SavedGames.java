import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;


public class SavedGames implements Initializable{
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private AnchorPane savedGameAp;

    @FXML
    private ImageView play;

    @FXML
    private ImageView newGame;

    @FXML
    private ImageView chest;

    @FXML 
    private ImageView will;

    @FXML
    private ImageView coin1;

    @FXML
    private ImageView coin2;

    @FXML
    private ImageView coin3;


    @FXML
    void resume(MouseEvent event) throws ClassNotFoundException, IOException{
        
        App.deserialize();

        App.db = App.dList.getDatabase(App.currentUser);
        System.out.println(App.dList.getSize());

        root = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
        AnchorPane rootanchor = ((AnchorPane) root);
        rootanchor.setStyle(App.db.getTheme());
        
        scene = new Scene(root, 1100, 600);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void generateNewGameButton(MouseEvent event) throws Exception{

        App.serialize();

        root = FXMLLoader.load(getClass().getResource("Mainpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1100, 600);
        stage.setScene(scene);
        stage.show();

        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        Animmations.trasnlate(will, 'y', -130, 1100, 0, true);
        Animmations.trasnlate(chest, 'y', -80, 700, 0, true);
        Animmations.rotate(coin1, 360);
        Animmations.rotate(coin2, 360);
        Animmations.rotate(coin3, 360);

        Animmations.trasnlate(play, 'x', +509, 1500, 2, false);
        Animmations.trasnlate(newGame, 'x', -530, 1500, 2, false);

        Animmations.rotateTimes(play, +360, 1, 4, 1000);
        Animmations.rotateTimes(newGame, +360, 1, 4, 1000);

        Animmations.rotateTimes(play, -360, 1, 5.2, 1000);
        Animmations.rotateTimes(newGame, -360, 1, 5.2, 1000);


    }
    

}

