/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import engine.handler.Handler;

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
public abstract class Entidade extends Rectangle{
    
    public static final int DEFAULT_ENTIDADE_W = 64;
    public static final int DEFAULT_ENTIDADE_H = 64;
    
    protected Handler handler;
    protected boolean vivo = false;
    
    public Entidade(int x, int y, int w, int h, Handler handler){
        super(w, h, Color.RED);
        this.handler = handler;
        setX(x);
        setY(y);
    }
    
    public Entidade(int x, int y, Handler handler){
        super(DEFAULT_ENTIDADE_W, DEFAULT_ENTIDADE_H, Color.RED);
        this.handler = handler;
        setX(x);
        setY(y);
    }
    
    public void update(){};
    public void render(GraphicsContext gc){};
    
}
