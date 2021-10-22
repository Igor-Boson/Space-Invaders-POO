/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entidades.tiro;

import java.awt.Graphics;
import spaceinvaders.Handler;
import static spaceinvaders.entidades.tiro.TiroCanhao.TIROCANHAO_FIRERATE;

/**
 *  ArrayTirosCanhao
 
   O ArrayTirosCanhao é a classe que instancia TAM_ARRAYTIROSCANHAO ao ser inicializado
 * 
 * Caso a barra de espaço esteja pressionada, a cada (int delayAtirarCanhao) ticks, 
 * o ArrayTirosCanhao proximo tiro não util como util, e passa para ele a posição do canhao,
 * e seta o tiro como util.
 * 
 * O ArrayTirosCanhao também é responsável por tickar e renderizar todos os TirosCanhao
 * 
 * @author Igor
 */
public class ArrayTirosCanhao {
    
    private Handler handler;
    
    public static final int TAM_ARRAYTIROSCANHAO = 15;    
   
    public static TiroCanhao[] tiros;
    private int delayAtirarCanhao = 0;
    private int id = 0;
    private int i = 0;
    
    public ArrayTirosCanhao(Handler handler){
        this.handler = handler;     
        tiros = new TiroCanhao[TAM_ARRAYTIROSCANHAO];
        for(i=0; i<TAM_ARRAYTIROSCANHAO; i++){
            tiros[i] = new TiroCanhao(handler, 0, 0);
        }
    }
    
    public void atirar(){ 
        if(delayAtirarCanhao > TIROCANHAO_FIRERATE){
            if(tiros[id].getUtil() == false){
                tiros[id].setX(handler.getCanhao().getX()+handler.getCanhao().getWidth()/4);
                tiros[id].setY(handler.getCanhao().getY()+handler.getCanhao().getHeight()/4);
                tiros[id].setUtilTrue();
                delayAtirarCanhao = 0;
            }
            else{
                id++;
                if(id == TAM_ARRAYTIROSCANHAO)
                    id = 0;
            }
        }
    }

    
    public void tick(){
        if(handler.getGame().getKeyManager().shoot)
            delayAtirarCanhao++;
        atirar();
        for(i = 0; i<TAM_ARRAYTIROSCANHAO; i++ ){        
                    tiros[i].tick();
        }
    }
    
    public void render(Graphics g){
        for(i = 0; i<TAM_ARRAYTIROSCANHAO; i++ ){
                if(tiros[i]!=null)
                    tiros[i].render(g);
        }
    }
}
