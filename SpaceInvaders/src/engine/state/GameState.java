/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.state;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;
import entidades.Canhao;
import static entidades.Canhao.CANHAO_POS_X_INICIAL;
import static entidades.Canhao.CANHAO_POS_Y_INICIAL;
import entidades.arrays.ArrayAlien;
import entidades.arrays.ArrayAlienForte;
import entidades.arrays.ArrayBarricadas;
import entidades.arrays.ArrayTiroCanhao;
import entidades.arrays.MatrizAlienNormal;
import entidades.arrays.MatrizTiroAlien;
import engine.gameeevent.GameOver;
import engine.gameeevent.YouWin;
import gfx.hud.Background;
import gfx.hud.DisplayVidas;
import gfx.hud.Score;
import gfx.hud.TitleScreen;
import engine.state.State;

/**
 *
 * @author igor_
 */
public class GameState extends State{
    
    private Handler handler;
    
    private int gameTime = 0;
    private int speedInc = 0;
    public static final int SPEED_INC_DELAY = 400;
    
    //gameevent
    private GameOver gameOver;
    private YouWin youWin;
    
    //hud
    private DisplayVidas displayVidas;
    private Score score;
    private Background background;
    private TitleScreen titleScreen;
    
    //entidades
    private Canhao canhao;
    private ArrayBarricadas arrayBarricadas;
    private ArrayTiroCanhao arrayTiroCanhao;
    private MatrizAlienNormal matrizAlienNormal;
    private ArrayAlien arrayAlien;
    private ArrayAlienForte arrayAlienForte;
    private MatrizTiroAlien matrizTiroAlien;
    
    public GameState(Handler handler){
        this.handler = handler;
        
        handler.setSpeedInc(speedInc);
        
        canhao = new Canhao(CANHAO_POS_X_INICIAL, CANHAO_POS_Y_INICIAL, handler);
        arrayBarricadas = new ArrayBarricadas(handler);
        arrayTiroCanhao = new ArrayTiroCanhao(handler);
        arrayAlien = new ArrayAlien(handler);
        matrizAlienNormal = new MatrizAlienNormal(handler);
        arrayAlienForte = new ArrayAlienForte(handler);
        matrizTiroAlien = new MatrizTiroAlien(handler);
        
        displayVidas = new DisplayVidas(handler);
        score = new Score(handler);
        background = new Background(handler);
        titleScreen = new TitleScreen(handler);
        
        gameOver = new GameOver(handler);
        youWin = new YouWin(handler);
    }
    
    @Override
    public void update(){
        
        titleScreen.update();
        
        if(titleScreen.isTitleScreenOn()){
            gameTime++;

            if(gameTime > SPEED_INC_DELAY*(speedInc + 1)){
                speedInc++;
                handler.setSpeedInc(speedInc);
            }
            //gameeevent
            gameOver.update();
            youWin.update();

            if(!handler.getGameOver().isGameOver() && !handler.getYouWin().isYouWin()){
                canhao.update();
                arrayBarricadas.update();
                arrayTiroCanhao.update();
                arrayAlien.update();
                arrayAlienForte.update();
                matrizTiroAlien.update();
            }
        }
    }
    
    public void render(GraphicsContext gc){
        if(titleScreen.isTitleScreenOn()){
            background.render(gc);

            canhao.render(gc);
            arrayBarricadas.render(gc);
            arrayTiroCanhao.render(gc);
            arrayAlien.render(gc);
            matrizTiroAlien.render(gc);

            displayVidas.render(gc);
            score.render(gc);

            gameOver.render(gc);
            youWin.render(gc);
        }
        else
            titleScreen.render(gc);
        
    }
    
}
