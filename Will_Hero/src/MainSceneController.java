
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    RotateTransition ro, ro2, ro3;
    TranslateTransition tr, tr1, tr2, tr3;
    FadeTransition ft, ft2;
    ScaleTransition sc, sc2, sc3;
    @FXML
    private ImageView tnt;
    @FXML
    private ImageView c1;
    @FXML
    private ImageView c2;
    @FXML
    private ImageView c3;
    @FXML
    private ImageView will;
    double x, y;
    @FXML
    private ImageView gOrc;
    @FXML
    private ImageView treasure;
    @FXML
    private ImageView star;
    @FXML
    private ImageView isl1;
    @FXML
    private ImageView isl2;

    int flag = 0;
    Image smashedWill = new Image(getClass().getResourceAsStream("pic/Smashed_Will.png"));
    Image Will = new Image(getClass().getResourceAsStream("pic/Will.png"));
    Image openChest = new Image(getClass().getResourceAsStream("pic/Open_Chest.png"));
    Image stars = new Image(getClass().getResourceAsStream("pic/stars.png"));
    Image blasted_tnt = new Image(getClass().getResourceAsStream("pic/blasted_tnt.png"));

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tr = CAnimations.translate(will, 'y', -100.0, 400.0, 1, 1);
        sc = CAnimations.scale(will, 'y', -0.2, 400, 0, 1);
        CAnimations.translate(gOrc, 'y', -145.0, 500.0, 1, 1);
        tr1 = CAnimations.translate(treasure, 'y', -30, 600.0, 1, 1);
        tr3 = CAnimations.translate(tnt, 'y', -30, 700.0, 1, 1);
    }

    @FXML
    void moveFrwd(MouseEvent event) {
        Timeline t = new Timeline(
                new KeyFrame(
                        javafx.util.Duration.millis(1),
                        ae -> {
                            x = will.getLayoutX();
                            y = gOrc.getLayoutY();
                            will.setLayoutX(x += 100);
                            if (detectCollision(will, gOrc)) {

                                star.setLayoutX(will.getLayoutX());
                                star.setLayoutY(will.getLayoutY() - 20);
                                changeImage(star, stars);
                                CAnimations.rotate(star, 'y', 360.0, 500.0, 0);
                                will.setLayoutY(isl2.getLayoutY() - 25);
                                tr.stop();
                                sc.stop();
                                changeImage(will, smashedWill);

                            }
                            if (detectCollision(will, treasure)) {
                                changeImage(treasure, openChest);
                                tr1.stop();
                                treasure.setLayoutY(isl2.getLayoutY() - 20);
                            }
                            if (detectCollision(will, c1)) {

                                tr2 = CAnimations.translate(c1, 'y', -100.0, 900.0, 0, 0);
                                ro = CAnimations.rotate(c1, 'z', -360.0, 900.0, 1);
                                ParallelTransition p1 = new ParallelTransition(tr2, ro);
                                ft = CAnimations.fade(c1, 1, 0, 100.0, 0, 0);

                                new SequentialTransition(p1, ft).play();

                            }
                            if (detectCollision(will, c2)) {
                                tr2 = CAnimations.translate(c2, 'y', -100.0, 400.0, 0, 0);
                                ro2 = CAnimations.rotate(c2, 'z', -360.0, 900.0, 1);
                                ParallelTransition p2 = new ParallelTransition(tr2, ro2);
                                ft = CAnimations.fade(c2, 1, 0, 100.0, 0, 0);
                                new SequentialTransition(p2, ft).play();
                            }
                            if (detectCollision(will, c3)) {
                                tr2 = CAnimations.translate(c3, 'y', -100.0, 400.0, 0, 0);
                                ro3 = CAnimations.rotate(c3, 'z', -360.0, 900.0, 1);
                                ParallelTransition p3 = new ParallelTransition(tr2, ro3);
                                ft = CAnimations.fade(c3, 1, 0, 100.0, 0, 0);
                                new SequentialTransition(p3, ft).play();
                            }
                            if (detectCollision(will, tnt) && flag == 0) {
                                // ft2=CAnimations.fade(tnt,0.3,1,400.0,9,0);
                                // ft2.play();
                                changeImage(tnt, blasted_tnt);
                                tr3.stop();
                                sc2 = CAnimations.scale(tnt, 'y', 3, 500.0, 1, 0);
                                sc3 = CAnimations.scale(tnt, 'x', 3, 500.0, 1, 0);
                                ParallelTransition p = new ParallelTransition(sc2, sc3);
                                tr.stop();
                                sc.stop();
                                p.play();
                                changeImage(will, smashedWill);

                                flag = 1;
                            }
                        }
                )
        );
        t.play();
    }


    public Boolean detectCollision(ImageView first, ImageView second) {
        try {
            if (first.getBoundsInParent().intersects(second.getBoundsInParent())) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void changeImage(ImageView first, Image second) {
        first.setImage(second);
    }

}