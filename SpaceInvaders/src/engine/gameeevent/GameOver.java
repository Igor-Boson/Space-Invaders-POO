/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.gameeevent;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import engine.handler.Handler;
import static engine.main.SpaceInvaders.EIXO_X;
import static engine.main.SpaceInvaders.EIXO_Y;
import gfx.assets.Assets;

/**
 *  GameOver
 * 
 * A classe GameOver cuida do event de GameOver do jogo. Ela checa se o canhão está vivo, e
 * dentro das classes de alien, caso eles atinjam as barricadas, é feito com que GameOver = true,
 * e aí renderiza na tela o GameOver
 * 
 * Dentro da classe GameState, eu aprofundo como funciona para acabar o jogo
 * 
 * @author Igor
 */
public class GameOver {
    private Handler handler;
    private boolean gameOver = false;
    

    public GameOver(Handler handler){
        this.handler = handler;
        handler.setGameOver(this);
    }
        
    public boolean isGameOver() {
        return gameOver;
    }

    public void checkCanhaoVivo(){
        if(!handler.getCanhao().isVivo())
            gameOver = true;
    }
    
    public void setGameOver(boolean value) {
        gameOver = value;
    }
    
    public void update(){
        checkCanhaoVivo();
    }
    
    public void render(GraphicsContext gc){
        if(gameOver){
            //gc.setFont(Assets.joystix.deriveFont(40f));
            gc.setStroke(Color.BLACK);
            gc.strokeText("GAME OVER", EIXO_X/2 - 100, EIXO_Y/2 - 100);
        }       
    }
}
