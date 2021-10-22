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

    public void setYouWinTrue(){
        youWin = true;
    }
    
    public boolean isYouWin() {
        return youWin;
    }

    
    public void verificarAliens(){
        int cont = 0;
        
        for(int i  = 0; i < handler.getMatrizAlien().getContadorId(); i++){
            if(!handler.getArrayAliens().getAlien(i).getVivo())
                cont++;
        }
        if(cont == handler.getMatrizAlien().getContadorId())
            youWin = true;
           
    }
    
    public void tick(){
        verificarAliens();
    }
    
    public void render(Graphics g){
        if(youWin){
            g.setFont(Assets.joystix.deriveFont(40f));
            g.setColor(Color.white);        
            g.drawString("YOU WIN!", (int)POS_X_YOUWIN, (int)POS_Y_YOUWIN);
        }
        
    }
}
