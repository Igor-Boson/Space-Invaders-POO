/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.gameevent;

import java.awt.Color;
import java.awt.Graphics;
import spaceinvaders.Handler;
import static spaceinvaders.Tutorial2D.EIXO_X;
import static spaceinvaders.Tutorial2D.EIXO_Y;
import spaceinvaders.gfx.Assets;

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
        if(!handler.getCanhao().getVivo())
            gameOver = true;
    }
    
    public void setGameOverTrue() {
        gameOver = true;
    }
    
    public void tick(){
        checkCanhaoVivo();
    }
    
    public void render(Graphics g){
        if(gameOver){
            g.setFont(Assets.joystix.deriveFont(40f));
            g.setColor(Color.white);        
            g.drawString("GAME OVER!", EIXO_X/3, EIXO_Y/3);
        }       
    }
}
