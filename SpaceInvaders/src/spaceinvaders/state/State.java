/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.state;

import java.awt.Graphics;
import spaceinvaders.Game;
import spaceinvaders.Handler;

/**
 *
 * @author Igor
 */
public abstract class State {
    
    protected Handler handler;
    
    public State(Handler handler){
        this.handler = handler;
    }
            
    public abstract void tick();
    public abstract void render(Graphics g);
}
