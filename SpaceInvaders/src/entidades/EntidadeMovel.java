/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;

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
public class EntidadeMovel extends Entidade{
    
    protected int xMove;
    protected int yMove;

    public EntidadeMovel(int x, int y, int w, int h, Handler handler) {
        super(x, y, w, h, handler);
        xMove = 0;
        yMove = 0;
    }
    
    public EntidadeMovel(int x, int y, Handler handler) {
        super(x, y, handler);
        xMove = 0;
        yMove = 0;
    }
    
    @Override
    public void update(){
        move();
    }
    
    @Override
    public void render(GraphicsContext gc){
        gc.drawImage(handler.getAssets().teste, this.getX(), this.getY());
    }
    
    public void move(){
        setX(getX() + xMove);
        setY(getY() + yMove);
    }
    
    public int getXMove() {
        return xMove;
    }

    public void setXMove(int xMove) {
        this.xMove = xMove;
    }

    public int getYMove() {
        return yMove;
    }

    public void setYMove(int yMove) {
        this.yMove = yMove;
    }
    
}
