/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx.hud;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;

/**
 *
 * @author igor_
 */
public class TitleScreen {
    private Handler handler;
    private boolean titleScreenOn = false; 
    
    public TitleScreen(Handler handler){
        this.handler = handler;
    }
    
    public boolean isTitleScreenOn(){
        return titleScreenOn;
    }
    
    public void setTitleScreenOn(boolean value){
        titleScreenOn = value;
    }
    
    public void update(){
        if(handler.getKeyboard().isGameStarted())
            titleScreenOn = true;
    }
    
    public void render(GraphicsContext gc){
        gc.drawImage(handler.getAssets().titleScreen, 0, 0);
    }
    
}
