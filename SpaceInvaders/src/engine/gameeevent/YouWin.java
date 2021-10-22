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
 *  YouWin
 * 
 * A classe GameOver cuida do event de YouWin do jogo. Ela checa se não há mais aliens restantes
 * na tela, caso não haja mais, YouWin = true
 * e aí renderiza na tela o YouWin
 * 
 * Dentro da classe GameState, eu aprofundo como funciona para ganhar o jogo
 * 
 * @author Igor
 */
public class YouWin {
    
    
    public static final float POS_X_YOUWIN = EIXO_X/3;
    public static final float POS_Y_YOUWIN = EIXO_Y/3;
    
    private Handler handler;
    private boolean youWin = false;
    

    public YouWin(Handler handler){
        this.handler = handler;
        handler.setYouWin(this);
    }

    public void setYouWin(boolean value){
        youWin = value;
    }
    
    public boolean isYouWin() {
        return youWin;
    }

    
    public void verificarAliens(){
        int cont = 0;
        
        for(int i  = 0; i < handler.getArrayAlien().getSize(); i++){
            if(!handler.getArrayAlien().getAlien(i).isVivo())
                cont++;
        }
        if(cont == handler.getArrayAlien().getSize())
            youWin = true;
           
    }
    
    public void update(){
        verificarAliens();
    }
    
    public void render(GraphicsContext gc){
        if(youWin){
            //g.setFont(Assets.joystix.deriveFont(40f));
            gc.setStroke(Color.BLACK);
            gc.strokeText("You Win", EIXO_X/2 - 100, EIXO_Y/2 - 100);
        }
        
    }
}
