/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Igor
 */
package spaceinvaders.state;

import java.awt.Graphics;
import spaceinvaders.Handler;
import spaceinvaders.hud.Score;
import spaceinvaders.entidades.arrays.ArrayBarricadas;
import spaceinvaders.entidades.tiro.ArrayTirosCanhao;
import spaceinvaders.entidades.Canhao;
import static spaceinvaders.entidades.Canhao.CANHAO_POS_X_INICIAL;
import static spaceinvaders.entidades.Canhao.CANHAO_POS_Y_INICIAL;
import static spaceinvaders.entidades.Entidade.DEFAULT_ENTIDADE_HEIGHT;
import static spaceinvaders.entidades.Entidade.DEFAULT_ENTIDADE_WIDTH;
import spaceinvaders.entidades.arrays.ArrayAlien;
import spaceinvaders.entidades.arrays.ArrayAlienForte;
import spaceinvaders.entidades.arrays.MatrizAlien;
import spaceinvaders.entidades.tiro.MatrizTirosAlienForte;
import spaceinvaders.hud.Background;
import spaceinvaders.gameevent.GameOver;
import spaceinvaders.gameevent.YouWin;
import spaceinvaders.hud.DisplayVidas;


public class GameState extends State{
    
    private Canhao canhao;
    private ArrayAlien arrayAlien;
    private MatrizAlien matrizAlien;
    private ArrayAlienForte arrayAlienForte;
    private ArrayTirosCanhao arrayTirosCanhao;
    private ArrayBarricadas arrayBarricadas;
    private MatrizTirosAlienForte matrizTirosAlienForte;
    
    private Score score;
    private DisplayVidas displayVidas;
    private Background background;
    private GameOver gameOver;
    private YouWin youWin;
    
    private int width = DEFAULT_ENTIDADE_WIDTH;
    private int height = DEFAULT_ENTIDADE_HEIGHT;
    
    public GameState(Handler handler) {
        super(handler);
        canhao = new Canhao(handler, CANHAO_POS_X_INICIAL, CANHAO_POS_Y_INICIAL);
        arrayAlien = new ArrayAlien(handler);
        arrayAlienForte = new ArrayAlienForte(handler);
        matrizAlien = new MatrizAlien(handler);
        arrayBarricadas = new ArrayBarricadas(handler);
        matrizTirosAlienForte = new MatrizTirosAlienForte(handler);
        arrayTirosCanhao = new ArrayTirosCanhao(handler);
                
        score = new Score(handler);
        displayVidas = new DisplayVidas(handler);
        background = new Background(handler);
        gameOver = new GameOver(handler);
        youWin = new YouWin(handler);
        
    }
    
    public void tick(){
        background.tick();
        
        if(!handler.getGameOver().isGameOver() && !handler.getYouWin().isYouWin()){
            canhao.tick();
            arrayTirosCanhao.tick();
            matrizTirosAlienForte.tick();
            arrayAlien.tick();
            arrayBarricadas.tick();            
            arrayAlienForte.tick();
        }
        
        displayVidas.tick();
        score.tick();
        gameOver.tick();
        youWin.tick();
    }

    @Override
    public void render(Graphics g) {
        background.render(g);
        
        arrayTirosCanhao.render(g);
        matrizTirosAlienForte.render(g);
        canhao.render(g);
        arrayAlien.render(g);
        arrayBarricadas.render(g);
        
        score.render(g);
        displayVidas.render(g);
        gameOver.render(g);
        youWin.render(g);
    }
    
    //easter egg
}