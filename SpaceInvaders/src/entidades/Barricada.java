/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;

/**
 * Barricada
 * 
 * As barricadas são os objetos que são criadas entre o canhao e os aliens quando o jogo 
 * começa
 * 
 * Elas possuem uma vida VIDA_BARRICADA. Conforme elas vão perdendo vida, elas mudam o seu 
 * Sprite, e quando elas chegam em 0 de vida, elas somem de vez
 * 
 * @author Igor
 */
public class Barricada extends Entidade{
    public static final int BARRICADA_WIDTH = 50;
    public static final int BARRICADA_HEIGHT = 20;
    public static final int OFFSET_BARRICADA_X = 8;
    public static final int OFFSET_BARRICADA_y = 8;
    public static final int VIDA_BARRICADA = 4;
    
    private int id;
    private int vida;
    private boolean vivo;

    public Barricada(int x, int y, Handler handler) {
        super(x, y, BARRICADA_WIDTH, BARRICADA_HEIGHT, handler);
        vivo = true;
        vida = VIDA_BARRICADA;
    }
    

    public void levarDano(){
        vida--;
        if(vida == 0)
            vivo = false;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    private void verificarVivo(){
        if(vida == 0)
            vivo = false;
    }
    
    public boolean isVivo(){
        return vivo;
    }
    
    @Override
    public void update() {
        verificarVivo();
    }
    
    @Override
    public void render(GraphicsContext gc){
        if(vivo){
            if(vida == 4)
                gc.drawImage(handler.getAssets().barricada4, this.getX(), this.getY());
            if(vida == 3)
                gc.drawImage(handler.getAssets().barricada3, this.getX(), this.getY());
            if(vida == 2)
                gc.drawImage(handler.getAssets().barricada2, this.getX(), this.getY());
            if(vida == 1)
                gc.drawImage(handler.getAssets().barricada1, this.getX(), this.getY());
        }
    }
}
