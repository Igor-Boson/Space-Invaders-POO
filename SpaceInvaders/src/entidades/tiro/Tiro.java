/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.tiro;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;
import entidades.EntidadeMovel;

/**
 *  Tiro
 * 
 * O Tiro é uma classe abstrata que serve de molde para o TiroCanhao e o TiroAlienForte
 * 
 * Os tiros possuem uma variável boolean util, que é false ao instanciar a classe
 * Assim, ao atirar, não é necessário instanciar um Tiro, e sim, é feito com que o util
 * do tiro seja setado = true.
 * 
 * Quando util = true, o Tiro possui a capacidade de causar dano, é tickado e renderizado
 * Quando util = false, nada disso acontece, é como se ele não existisse, ele só fica armazenado
 * 
 * @author Igor
 */
public class Tiro extends EntidadeMovel{
    
    protected boolean util;       
    protected int width = 16;
    protected int height = 16;
    
    public Tiro(int x, int y, int w, int h,Handler handler) {
        super(x, y, w, h, handler);
        util = false;
    }
    
    public boolean isUtil(){
        return util;
    }
    
    public void setUtil(boolean value){
        util = value;
    }
    
    @Override
    public void update() {
        
    }

    @Override
    public void render(GraphicsContext gc) {     
    }
    
}
