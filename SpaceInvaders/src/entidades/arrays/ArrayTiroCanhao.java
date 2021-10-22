/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.arrays;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;
import entidades.tiro.TiroCanhao;
import static entidades.tiro.TiroCanhao.TIROCANHAO_FIRERATE;

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
public class ArrayTiroCanhao {
    private Handler handler;
    
    public static final int TAM_ARRAYTIROSCANHAO = 15;    
   
    public static TiroCanhao[] tiros;
    private int delayAtirarCanhao = TIROCANHAO_FIRERATE;
    private int id = 0;
    private int i = 0;
    
    public ArrayTiroCanhao(Handler handler){
        this.handler = handler;     
        tiros = new TiroCanhao[TAM_ARRAYTIROSCANHAO];
        for(i=0; i<TAM_ARRAYTIROSCANHAO; i++){
            tiros[i] = new TiroCanhao(0, 0, handler);
        }
    }
    
    public void atirar(){ 
        if(delayAtirarCanhao > TIROCANHAO_FIRERATE - handler.getSpeedInc()*6 && delayAtirarCanhao > 20){
            if(!tiros[id].isUtil()){
                tiros[id].setX(handler.getCanhao().getX()+handler.getCanhao().getWidth()/4);
                tiros[id].setY(handler.getCanhao().getY()+handler.getCanhao().getHeight()/4);
                tiros[id].setUtil(true);
                delayAtirarCanhao = 0;
            }
            else{
                id++;
                if(id == TAM_ARRAYTIROSCANHAO)
                    id = 0;
            }
        }
    }

    
    public void update(){
        if(handler.getKeyboard().isShoot())
            delayAtirarCanhao++;
        atirar();
        for(i = 0; i<TAM_ARRAYTIROSCANHAO; i++ ){        
                    tiros[i].update();
        }
    }
    
    public void render(GraphicsContext gc){
        for(i = 0; i<TAM_ARRAYTIROSCANHAO; i++ ){
                if(tiros[i]!=null)
                    tiros[i].render(gc);
        }
    }
}
