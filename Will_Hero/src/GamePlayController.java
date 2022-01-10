import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GamePlayController implements Initializable{

    TranslateTransition tr;
    @FXML
    private AnchorPane playGameAp;
    
    private ArrayList<ImageView> list;
    private ArrayList<ImageView> Coin;
    private ArrayList<ImageView> chests;
    
    private ImageView img;
    private ImageView will,rocket;
    private ArrayList<ImageView> Rocket;
    private Objectfactory factory;
    double x, y;
    private MyTimer mytime;
    private MyTimer2 mytime2;
    private MyTimer3 mytime3;
    private MyTimer4 mytime4;
    private MyTimer5 mytime5;
    private Timeline t;
    private ImageView c;
    private int a2=0;
    private int a3=0;
    private int flag=0;
    // private RandomGenerator rgen;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        factory = new Objectfactory();
        // rgen = new RandomGenerator();
        list = new ArrayList<ImageView>();   
        Coin = new ArrayList<ImageView>();

        int x = 0;
        
        
        for(int i = 0 ; i<5 ; i++, x+=300){

            img = factory.getImgage(70+x, 390);
            if(i>1)setCoins(img);
            // c1=rgen.getImage(img.getX(), img.getY(), img.getFitHeight()/2, img.getFitWidth()/2);
            list.add(img);
            // playGameAp.getChildren().add(c1);
            playGameAp.getChildren().add(img);

        }
        will=factory.createImage(177,156,68,57,"pic/Will.png");
        
        playGameAp.getChildren().add(will);
        mytime= new MyTimer();
        mytime2 = new MyTimer2();
        mytime3 = new MyTimer3();
        mytime4 = new MyTimer4();
        mytime5 = new MyTimer5();
        mytime2.start();
        Rocket=new ArrayList<ImageView>();
        a2=1;
    }

    void setCoins(ImageView check){

        int random = (int)Math.floor(Math.random()*(6-1+1)+1);
        if(random<3 && random>4)return;

        int[] arr = {-100,-50,50,100};

        int number  = (int)Math.floor(Math.random()*(3-2+1)+2);
        int x_corr = (int)Math.floor(Math.random()*(3-0+1)+0);

        for(int i =0, j=0 ; i<number ; i++,j+=50){

            Coin.add(factory.getCoin(check.getX()+arr[x_corr]+j, check.getY()+150));
            playGameAp.getChildren().add(Coin.get(Coin.size()-1));

        }

    }

    void setChest(ImageView check){

        int random = (int)Math.floor(Math.random()*(5-1+1)+1);
        if(random<3 && random>4)return;
        
        chests.add(factory.getChest(check.getX()+50, check.getY()));
        playGameAp.getChildren().add(chests.get(chests.size()-1));

    }

    @FXML
    void moveFrwd(MouseEvent event) {
        flag=0;
        t = new Timeline(
                new KeyFrame(
                        javafx.util.Duration.millis(1),
                        ae -> {
                            if(a2==1){
                                mytime2.stop();
                            }
                            if(a3==1){
                                mytime3.stop();
                            }
                            mytime.start();
                            mytime4.start();
                        }
                )
        );
        t.play();
    }
    // first.getLayoutX()+first.getFitWidth()>second.getLayoutX() && first.getLayoutX()<second.getLayoutX()+second.getFitWidth() &&
    public Boolean detectCollision2(ImageView first, ImageView second) {
        try{
            if ( first.getY()<second.getY()+second.getFitHeight() && first.getX()+first.getFitWidth()>second.getX() && first.getX()<second.getX()+second.getFitWidth() ) {
                return true;
            }
        else{
            return false;
        }
        }
        catch(Exception e){
            return false;
        }
    }
    private class MyTimer2 extends AnimationTimer{
        private long prevTime2 = 0;
        @Override
        public void handle(long now) {
            long diff2 = now - prevTime2;
            if(diff2>1e2){
                prevTime2 = now ;
                will.setY(will.getY()+5);
            }
            for(int i=0;i<4;i++)
            {
                if(detectCollision2(list.get(i),will)){
                    
                    // will.setY(will.getY()-150);
                    mytime2.stop();
                    a2=0;
                    a3=1;
                    mytime3.start();
                }
        }
        }
    }
    private class MyTimer3 extends AnimationTimer{
        private long prevTime3 = 0;
        @Override
        public void handle(long now) {
            long diff2 = now - prevTime3;
            if(diff2>1e2){
                prevTime3 = now ;
                will.setY(will.getY()-5);
            }
            if(will.getY()<=100){
                mytime3.stop();
                a3=0;
                a2=1;
                mytime2.start();
            }
        }
    }
    private class MyTimer extends AnimationTimer{
        private long prevTime = 0;
        @Override
        public void handle(long now) {
            long diff = now - prevTime;
            if(diff>1e2){
                
            for(int i = 0 ; i<5 ; i++){
                c = list.get(i);
                // c1=rgen.getImage(c.getX(), c.getY(), c.getFitHeight()/2, c.getFitWidth()/2);
                // playGameAp.getChildren().add(c1);
                    c.setX(c.getX()-100);
                    // c1.setX(c.getX());
            }
            ImageView img=  list.get(0);
            if(img.getX()+img.getFitWidth()-50<0){
                // c.setX(c.getX()+1300);
                // c1.setX(c.getX());
                playGameAp.getChildren().remove(img);
                list.remove(0);
                img = list.get(list.size()-1);
                int x= (int)img.getX()+(int)img.getFitWidth()+100;
                list.add(factory.getImgage(x, 390));
                playGameAp.getChildren().add(img);
            }
        }
            mytime.stop();
            if(a2==1){
                mytime2.start();
            }
            else if(a3==1){
                mytime3.start();
            }
        }
        }

        private class MyTimer5 extends AnimationTimer{
            private long prevTime5 = 0;

            @Override
            public void handle(long now) {
                long diff2 = now - prevTime5;
        
                if(diff2>1e2){
                    prevTime5 = now ;
                    Rocket.get(Rocket.size()-1).setX(Rocket.get(Rocket.size()-1).getX()+5);
                }
                
            }
        }

        private class MyTimer4 extends AnimationTimer{
            private long prevTime4 = 0;
            @Override 
            public void handle(long now) {
                long diff4 = now - prevTime4;
            if(diff4>1e2){
                prevTime4 = now ;
                rocket=factory.createImage((int)will.getX(),(int)will.getY(),50,75,"pic/Rocket_with_flare.png");
                Rocket.add(rocket);
                playGameAp.getChildren().add(rocket);
                flag=1;
            }
            if(flag==1)
            {
                mytime4.stop();
                mytime5.start();
            }
            }
        }
    }
    
  
    

