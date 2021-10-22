/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
import spaceinvaders.Handler;

/**
 *  Entidade
 * 
 * A Entidade é uma classe abstrata que serve de molde para todas as entidades do jogo.
 * Ela fornece uma posição x e y que serve para representar a posição da entidade na tela
 * e uma width(largura) e height(altura), que serve para renderizar a entidade na tela, 
 * e também para ser usada com o Rectangle bounds(limites), que é utilizado para realizar
 * a detecção de colisão
 *
 * É importante comentar que todas as entidades são inicializadas quando o jogo começa,
 * contudo, algumas são inicializas como "mortas" (vivo == false) e algumas, os tiros, 
 * são inicializadas como "inúteis" (util == false)
 * Assim, elas não são renderizadas nem tickadas (tick()) até que elas sejam necessárias
 * 
 * @author Igor
 */
public abstract class Entidade {
    public static final int DEFAULT_ENTIDADE_WIDTH = 32;
    public static final int DEFAULT_ENTIDADE_HEIGHT = 32;
    
    
    protected float x, y;
    protected int width = DEFAULT_ENTIDADE_WIDTH;
    protected int height = DEFAULT_ENTIDADE_HEIGHT;
    protected Rectangle bounds;
    
    protected Handler handler;
    
    public Entidade(Handler handler, float x, float y){
        this.handler = handler;
        this.x = x;
        this.y = y;

    }
       
    public Rectangle getBounds(){
        return (new Rectangle((int)x, (int)y, width, height));
    }
    
    //SETTERS E GETTERS
    public float getX(){
        return x;
    }
    
    public float getY(){
        return y;
    }
    
    public void setX(float x){
        this.x = x;
    }
    
    public void setY(float y){
        this.y = y;
    }
    
    public float getWidth(){
        return width;
    }
    
    public float getHeight(){
        return height;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
}
