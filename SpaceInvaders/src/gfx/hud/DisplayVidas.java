/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx.hud;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;
import static engine.main.SpaceInvaders.EIXO_X;
import static engine.main.SpaceInvaders.EIXO_Y;

/**
 *  DisplayVidas
 * 
 * O DisplayVidas mostra na tela a quantidade de vidas que o jogador ainda tem, 
 * através do valor da variável (int vida) do canhao
 * 
 * @author Igor
 */
public class DisplayVidas {
    
    public static final int POS_X_DISPLAYVIDAS = EIXO_X - 300;
    public static final int POS_Y_DISPLAYVIDAS = 0;
    
    private Handler handler;
    
    public DisplayVidas(Handler handler){
        this.handler = handler;
        handler.setDisplayVidas(this);
    }
    
    public void update(){
        
    }
    
    public void render(GraphicsContext gc){
        for(int i = 0; i < handler.getCanhao().getVida(); i++){
            gc.drawImage(handler.getAssets().spaceship,
                        POS_X_DISPLAYVIDAS + i*handler.getCanhao().getWidth(),
                        POS_Y_DISPLAYVIDAS);
        }
    }
    
}
