/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx.hud;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import engine.handler.Handler;
import static engine.main.SpaceInvaders.EIXO_X;
import static engine.main.SpaceInvaders.EIXO_Y;

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
    
    
    public static final int SCORE_DEFAULT_ALIENKILL = 100;
    public static final int POS_X_SCORE = 300;
    public static final int POS_Y_SCORE = 40;
    public static final int POS_X_SCORE_FINAL = EIXO_X/2 - 200;
    public static final int POS_Y_SCORE_FINAL = EIXO_Y/2 + 50 ;
   
    
    private Handler handler;
    
    private int totalScore = 0;
    
    public Score(Handler handler){
        this.handler = handler;
        handler.setScore(this);
    }
    
    public void addScore(int addScore){
        totalScore += addScore;
    }
    
    public void update(){
        
    }
    
    public void render(GraphicsContext gc){
            gc.setFill(Color.WHITE);
            gc.setStroke(Color.WHITE);
        if(!handler.getGameOver().isGameOver() && !handler.getYouWin().isYouWin()){
            gc.setFont(Font.font("Verdana", 50));
            gc.strokeText(""+totalScore, POS_X_SCORE, POS_Y_SCORE);
        }
        else{
            gc.setFont(Font.font("Verdana", 50));
            gc.strokeText(""+totalScore, POS_X_SCORE, POS_Y_SCORE);
            gc.setFont(Font.font("Verdana", 80));
                if(handler.getGameOver().isGameOver())
                    gc.strokeText("GAME OVER", POS_X_SCORE_FINAL, POS_Y_SCORE_FINAL - 50);
                if(handler.getYouWin().isYouWin())
                    gc.strokeText("YOU WIN!", POS_X_SCORE_FINAL, POS_Y_SCORE_FINAL - 100);
            gc.strokeText("SCORE: "+totalScore, POS_X_SCORE_FINAL, POS_Y_SCORE_FINAL);
            gc.strokeText("Obrigado por jogar :)", POS_X_SCORE_FINAL - 100, POS_Y_SCORE_FINAL + 100);
        }
    }
    
}
