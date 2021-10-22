/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.entidades.arrays;

import java.awt.Graphics;
import spaceinvaders.Handler;
import static spaceinvaders.entidades.Entidade.DEFAULT_ENTIDADE_HEIGHT;
import static spaceinvaders.entidades.Entidade.DEFAULT_ENTIDADE_WIDTH;
import spaceinvaders.entidades.aliens.AlienNormal;

/**
 *  MatrizAlien
 * 
 * A MatrizAlien é a classe responsável por inicilizar todos os AlienNormal.
 * A posição inicial da matriz é definida por (int MATRIZALIEN_POSINICIALX) 
 * e (int MATRIZALIEN_POSINICIALY).
 * 
 * O espaçamento entre os aliens é definido por (int MATRIZALIEN_DISTX) e
 * (int MATRIZALIEN_DISTY).
 * 
 * 
 * @author Igor
 */

public class MatrizAlien {
    
    public static final int MATRIZALIEN_DISTX = 30;
    public static final int MATRIZALIEN_DISTY = 30;
    public static final int MATRIZALIEN_POSINICIALX = 30;
    public static final int MATRIZALIEN_POSINICIALY = 30;
    public static final int MATRIZALIEN_NUM_COLUNAS = 11;
    public static final int MATRIZALIEN_NUM_LINHAS = 5;
    
    private Handler handler;
    public AlienNormal matrizAlien[][];                      //array que contem TODOS os aliens
       
    private int width = DEFAULT_ENTIDADE_WIDTH;
    private int height = DEFAULT_ENTIDADE_HEIGHT;
    private int contadorId;
    
    
    public MatrizAlien(Handler handler){
        this.handler = handler;
        matrizAlien = new AlienNormal[MATRIZALIEN_NUM_COLUNAS][MATRIZALIEN_NUM_LINHAS]; 
        handler.setMatrizAlien(this);
        
        contadorId = 0;
        for(int i = 0; i< MATRIZALIEN_NUM_COLUNAS; i++){
            for(int j = 0; j < MATRIZALIEN_NUM_LINHAS; j++){
                matrizAlien[i][j] = new AlienNormal(handler,
                                             (float)(MATRIZALIEN_POSINICIALX + MATRIZALIEN_DISTX*i), 
                                             (float)(MATRIZALIEN_POSINICIALY + MATRIZALIEN_DISTY*j)
                                             ,MATRIZALIEN_NUM_LINHAS - j);
                handler.getArrayAliens().addAlien(matrizAlien[i][j]);
                matrizAlien[i][j].setId(contadorId);
                contadorId++;
            }
        }
    }
            
    public MatrizAlien getMatrizAlien(){
        return this;
    }
    
    public int getContadorId(){
        return contadorId;
    }    
    
    public void tick(){
        for(int i = 0; i< MATRIZALIEN_NUM_COLUNAS  ; i++){
            for(int j = 0; j < MATRIZALIEN_NUM_LINHAS ; j++){
                matrizAlien[i][j].tick();
            }
        }
    }

    public void render(Graphics g){
        for(int i = 0; i< MATRIZALIEN_NUM_COLUNAS  ; i++){
            for(int j = 0; j < MATRIZALIEN_NUM_LINHAS ; j++){
                matrizAlien[i][j].render(g);
            }
        }
    }
}
