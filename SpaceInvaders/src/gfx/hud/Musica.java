/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx.hud;

import engine.handler.Handler;

/**
 *
 * @author igor_
 */
public class Musica {
    
    private Handler handler;
    private boolean mute;
    
    public Musica(Handler handler){
        handler.setMusica(this);
    }
    
    public void update(){
        
    }
}
