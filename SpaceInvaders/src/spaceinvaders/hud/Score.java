/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.hud;

import java.awt.Color;
import java.awt.Graphics;
import spaceinvaders.Handler;
import static spaceinvaders.Tutorial2D.EIXO_X;
import static spaceinvaders.Tutorial2D.EIXO_Y;
import spaceinvaders.gfx.Assets;

/**
 *  Score
 * 
 * O score é a pontuação do jogador no jogo. Ela é feita simplesmente adicionando um
 * valor à um contador quando um Alien morre, e esse valor é mostrado na tela.
 * 
 * 
 * @author Igor
 */
public class Score {
    
    public static final int SCORE_ALIENKILL = 100;
    public static final int POS_X_SCORE = 75;
    public static final int POS_Y_SCORE = EIXO_Y - 25;
    
    private Handler handler;
    
    private int totalScore = 0;
    
    public Score(Handler handler){
        this.handler = handler;
        handler.setScore(this);
    }
    
    public void addScore(int addScore){
        totalScore += addScore;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        g.setColor(Color.white);
        
        if(handler.getGameOver().isGameOver() || handler.getYouWin().isYouWin()){
            g.setFont(Assets.joystix.deriveFont(40f));
            g.drawString("Score: " + totalScore, EIXO_X/3 - 50, EIXO_Y/3 + 100);
        }
        
        else{
            g.setFont(Assets.joystix);
            g.drawString("Score: " + totalScore, POS_X_SCORE, POS_Y_SCORE);
        }
    }
}
