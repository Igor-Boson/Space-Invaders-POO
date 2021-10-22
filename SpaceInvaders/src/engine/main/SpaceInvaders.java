 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import gfx.assets.Assets;
import gfx.hud.Musica;
import engine.input.Keyboard;
import engine.state.GameState;
import engine.handler.Handler;

/**
 *
 * @author igor_
 */
public class SpaceInvaders extends Application {
    
    public static final int EIXO_X = 1200;
    public static final int EIXO_Y = 675;
    
    private Handler handler;
    private GameState gameState;
    private Assets assets;
    private Keyboard keyboard;
    private Musica musica;
    
    @Override
    public void init(){
        
    }
    
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        
        Scene scene = new Scene(root, EIXO_X, EIXO_Y);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.setTitle("Space Invaders Java Edition, now in JavaFX!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Canvas canvas = new Canvas(EIXO_X, EIXO_Y);
        root.getChildren().add(canvas);   
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        handler = new Handler(root, gc, scene);
        gameState = new GameState(handler);
        assets = new Assets(handler);
        keyboard = new Keyboard(handler);
        musica = new Musica(handler);
        
        final long startNanoTime = System.nanoTime();
        
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime){
                update();
                render(gc);
            }
        };
        timer.start();  
        
    }

    //dá update em tudo do jogo
    private void update(){
        keyboard.update();
        gameState.update();
        musica.update();
    }
         
    //limpa a tela e renderiza tudo do jogo
    private void render(GraphicsContext gc){
        gc.clearRect(0, 0, EIXO_X, EIXO_Y);
        gameState.render(gc);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
