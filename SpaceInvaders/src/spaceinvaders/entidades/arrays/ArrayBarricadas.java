/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entidades.arrays;

import java.awt.Graphics;
import spaceinvaders.Handler;
import spaceinvaders.entidades.Barricada;
import static spaceinvaders.Tutorial2D.EIXO_X;
import static spaceinvaders.Tutorial2D.EIXO_Y;
import static spaceinvaders.entidades.Barricada.WIDTH_BARRICADA;

/**
 *  ArrayBarricadas
 * 
 * O ArrayBarricadas é a classe que armazena todas as barricadas, e cria todas elas quando começa
 * o jogo.
 * 
 * Ele é também responsável por renderizar todas as barricadas.
 * 
 * 
 * @author Igor
 */
public class ArrayBarricadas {
    private Handler handler;
    
    public static final int TAM_ARRAYBARRICADAS = 5;
    public static final float POS_X_INICIAL_BARRICADA = 100;
    public static final float POS_Y_INICIAL_BARRICADA = EIXO_Y - 150;
    
    private float distEntreBarricadas = (EIXO_X - 2*POS_X_INICIAL_BARRICADA - TAM_ARRAYBARRICADAS*WIDTH_BARRICADA)
                                        /(TAM_ARRAYBARRICADAS -1);
    
    public static Barricada[] barricadas;
    
    public ArrayBarricadas(Handler handler){
        this.handler = handler;        
        barricadas = new Barricada[TAM_ARRAYBARRICADAS];
        handler.setArrayBarricadas(barricadas);
        for(int i=0; i<TAM_ARRAYBARRICADAS; i++){
            barricadas[i] = new Barricada(handler, POS_X_INICIAL_BARRICADA + (distEntreBarricadas + WIDTH_BARRICADA)*i, POS_Y_INICIAL_BARRICADA);
            barricadas[i].setId(i);
        }        
    }
    
    public Barricada[] getArrayBarricadas(){
        return barricadas;
    }
    
    public int getTAM_ARRAYBARRICADAS(){
        return TAM_ARRAYBARRICADAS;
    }
    
    public void tick(){
        for(int i = 0; i < TAM_ARRAYBARRICADAS; i++){
            barricadas[i].tick();
        }
    }
    
    public void render(Graphics g){
        for(int i = 0; i < TAM_ARRAYBARRICADAS; i++){
            barricadas[i].render(g);
        }
    }
}
