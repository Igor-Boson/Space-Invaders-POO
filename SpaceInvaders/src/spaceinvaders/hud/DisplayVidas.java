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
 *  DisplayVidas
 * 
 * O DisplayVidas mostra na tela a quantidade de vidas que o jogador ainda tem, 
 * através do valor da variável (int vida) do canhao
 * 
 * @author Igor
 */
public class DisplayVidas {
    
    public static final int POS_X_DISPLAYVIDAS = EIXO_X - 300;
    public static final int POS_Y_DISPLAYVIDAS = EIXO_Y - 25;
    
    private Handler handler;
    
    public DisplayVidas(Handler handler){
        this.handler = handler;
        handler.setDisplayVidas(this);
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        g.setColor(Color.white);
        g.setFont(Assets.joystix);
        g.drawString("VIDAS ", POS_X_DISPLAYVIDAS, POS_Y_DISPLAYVIDAS);
        
        if(handler.getCanhao().getVivo())
            for(int i = 0; i < handler.getCanhao().getVida(); i++)
                g.drawImage(Assets.canhao, POS_X_DISPLAYVIDAS + 100 + i*50, POS_Y_DISPLAYVIDAS - 16, null);
        
    }
    
}
