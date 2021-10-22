/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.arrays;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;
import static engine.main.SpaceInvaders.EIXO_X;
import static engine.main.SpaceInvaders.EIXO_Y;
import entidades.Barricada;
import static entidades.Barricada.BARRICADA_WIDTH;

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
    public static final int POS_X_INICIAL_BARRICADA = 100;
    public static final int POS_Y_INICIAL_BARRICADA = EIXO_Y - 150;
    
    private int distEntreBarricadas = (EIXO_X - 2*POS_X_INICIAL_BARRICADA - TAM_ARRAYBARRICADAS*BARRICADA_WIDTH)
                                        /(TAM_ARRAYBARRICADAS -1);
    
    public static Barricada[] barricadas;
    
    public ArrayBarricadas(Handler handler){
        this.handler = handler;        
        barricadas = new Barricada[TAM_ARRAYBARRICADAS];
        handler.setArrayBarricadas(this);
        for(int i=0; i<TAM_ARRAYBARRICADAS; i++){
            barricadas[i] = new Barricada(POS_X_INICIAL_BARRICADA + (distEntreBarricadas + BARRICADA_WIDTH)*i, POS_Y_INICIAL_BARRICADA, handler);
            barricadas[i].setId(i);
        }        
    }
    
    public int getTAM_ARRAYBARRICADAS(){
        return TAM_ARRAYBARRICADAS;
    }
    
    public Barricada[] getArray(){
        return barricadas;
    }
    
    public void update(){
        for(int i = 0; i < TAM_ARRAYBARRICADAS; i++){
            barricadas[i].update();
        }
    }
    
    public void render(GraphicsContext gc){
        for(int i = 0; i < TAM_ARRAYBARRICADAS; i++){
            barricadas[i].render(gc);
        }
    }
}
