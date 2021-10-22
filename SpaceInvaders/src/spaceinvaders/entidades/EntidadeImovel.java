/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entidades;

import java.awt.Rectangle;
import spaceinvaders.Handler;

/**
 * EntidadeImovel
 * 
 * A EntidadeImovel é praticamente a mesma que a Entidade, mas decidi fazer uma 
 * classe específica para ela pois achei que ficaria mais organizado
 * 
 * @author Igor
 */
public abstract class EntidadeImovel extends Entidade {

    public EntidadeImovel(Handler handler, float x, float y) {
        super(handler, x, y);
    }
    
    public Rectangle getBoundsImovel(){
        return bounds;
    }
    

}
