/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
import spaceinvaders.Handler;
import spaceinvaders.gfx.Assets;

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

public class Barricada extends EntidadeImovel{

    public static final int WIDTH_BARRICADA = 50;
    public static final int HEIGHT_BARRICADA = 20;
    public static final int OFFSET_BARRICADA_X = 8;
    public static final int OFFSET_BARRICADA_y = 8;
    public static final int VIDA_BARRICADA = 4;
    
    private int id;
    private int vida;
    private boolean vivo;
    
    public Barricada(Handler handler, float x, float y) {
        super(handler, x, y);
        width = WIDTH_BARRICADA;
        height = HEIGHT_BARRICADA;
        vida = VIDA_BARRICADA;
        vivo = true;
        
        bounds = new Rectangle((int)x + OFFSET_BARRICADA_X,
                                (int)y + OFFSET_BARRICADA_y,
                                width-OFFSET_BARRICADA_X, height-OFFSET_BARRICADA_y);
    }

    @Override
    public void tick() {
        
    }

    public void levarDano(){
        vida--;
        if(vida == 0)
            vivo = false;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public boolean getVivo(){
        return vivo;
    }
    
    @Override
    public void render(Graphics g) {
        if(vida >= 3)
            g.drawImage(Assets.laranja, (int)x, (int)y, width, height, null);
        if(vida == 2)
            g.drawImage(Assets.azul, (int)x, (int)y, width, height, null);
        if(vida == 1)
            g.drawImage(Assets.vermelho, (int)x, (int)y, width, height, null);          
    }
    
}
