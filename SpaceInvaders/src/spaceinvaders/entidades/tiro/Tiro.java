/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entidades.tiro;

import java.awt.Graphics;
import spaceinvaders.Handler;
import spaceinvaders.entidades.EntidadeMovel;

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

public abstract class Tiro extends EntidadeMovel{
    
    
    protected boolean util;       
    protected int width = 16;
    protected int height = 16;
    
    public Tiro(Handler handler, float x, float y) {
        super(handler, x, y);
        util = false;
    }
        
    
    public boolean getUtil(){
        return util;
    }
    
    public void setUtilTrue(){
        util = true;
    }
    
    public void tick() {
        
    }

    public void render(Graphics g) {     
    }
    
}
