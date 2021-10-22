/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entidades;

import spaceinvaders.Handler;

/**
 * EntidadeMovel
 * 
 * A EntidadeMovel é uma classe abstrata que estende a Classe Entidade
 * Nessa classe, é introduzida as variaveis xMove (movimento no eixo x)
 * e o yMove(movimento no eixo y), e o método move(), que altera as variaveis
 * x e y, baseadas no xMove e yMove
 * 
 * 
 * @author Igor
 */
public abstract class EntidadeMovel extends Entidade {
    
    protected float xMove, yMove;
    
    public EntidadeMovel(Handler handler, float x, float y) {
        super(handler, x, y);
        xMove = 0;
        yMove = 0;
    }
    
    public void move(){
        moveX();
        moveY();
    }
    
    public void moveX(){
        x += xMove;
    }
    
    public void moveY(){
        y += yMove;
    }
   
    //Getters e setters
    public float getXMove(){
        return xMove;
    }
    
    public float getYMove(){
        return yMove;
    }
    
    public void setXMove(float xMove){
        this.xMove = xMove;
    }
    
    public void setYMove(float yMove){
        this.yMove = yMove;
    }
}
