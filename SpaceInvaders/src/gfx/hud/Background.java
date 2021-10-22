/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx.hud;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import engine.handler.Handler;

/**
 *  Background
 * 
 * O background é simplesmente a tela preta, com a parte cinza, que fica no fundo do jogo
 * Para ela ficar no fundo, essa classe é renderizada antes de tudo, e o resto é renderizado
 * por cima dela.
 * 
 * @author Igor
 */
public class Background {
    private Handler handler;
    private Image background;
    
    public Background(Handler handler){
        this.handler = handler;
    }
    
    public void render(GraphicsContext gc){
        gc.drawImage(handler.getAssets().background, 0, 0);
    }
}
