/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.arrays;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;
import static entidades.Canhao.CANHAO_LIMITE_ESQUERDA;
import entidades.alien.AlienNormal;
import static entidades.alien.AlienNormal.ALIEN_NORMAL_HEIGHT;
import static entidades.alien.AlienNormal.ALIEN_NORMAL_WIDTH;

/**
 *  MatrizAlienNormal
 * 
 * A MatrizAlienNormal é a classe responsável por inicilizar todos os AlienNormal.
 * A posição inicial da matriz é definida por (int MATRIZALIEN_POSINICIALX) 
 * e (int MATRIZALIEN_POSINICIALY).
 * 
 * O espaçamento entre os aliens é definido por (int MATRIZALIEN_DISTX) e
 * (int MATRIZALIEN_DISTY).
 * 
 * 
 * @author Igor
 */
public class MatrizAlienNormal {
    
    public static final int MATRIZALIEN_DISTX = ALIEN_NORMAL_WIDTH + 10;
    public static final int MATRIZALIEN_DISTY = ALIEN_NORMAL_HEIGHT + 2;
    public static final int MATRIZALIEN_POSINICIALX = CANHAO_LIMITE_ESQUERDA;
    public static final int MATRIZALIEN_POSINICIALY = 60;
    public static final int MATRIZALIEN_NUM_COLUNAS = 11;
    public static final int MATRIZALIEN_NUM_LINHAS = 5;
    
    private Handler handler;
    public AlienNormal matrizAlien[][];                      //array que contem TODOS os aliens
       
    private int contadorId;
    
    
    public MatrizAlienNormal(Handler handler){
        this.handler = handler;
        matrizAlien = new AlienNormal[MATRIZALIEN_NUM_COLUNAS][MATRIZALIEN_NUM_LINHAS]; 
        handler.setMatrizAlienNormal(this);
        
        contadorId = 0;
        for(int i = 0; i< MATRIZALIEN_NUM_COLUNAS; i++){
            for(int j = 0; j < MATRIZALIEN_NUM_LINHAS; j++){
                matrizAlien[i][j] = new AlienNormal(
                                                (MATRIZALIEN_POSINICIALX + MATRIZALIEN_DISTX*i), 
                                                (MATRIZALIEN_POSINICIALY + MATRIZALIEN_DISTY*j),
                                                handler,
                                                MATRIZALIEN_NUM_LINHAS - j);
                
                handler.getArrayAlien().addAlien(matrizAlien[i][j]);
                matrizAlien[i][j].setIdNum(contadorId);
                contadorId++;
            }
        }
    }
            
    public MatrizAlienNormal getMatrizAlien(){
        return this;
    }
    
    public int getContadorId(){
        return contadorId;
    }    
    
    public void update(){
        for(int i = 0; i< MATRIZALIEN_NUM_COLUNAS  ; i++){
            for(int j = 0; j < MATRIZALIEN_NUM_LINHAS ; j++){
                matrizAlien[i][j].update();
            }
        }
    }

    public void render(GraphicsContext gc){
        for(int i = 0; i< MATRIZALIEN_NUM_COLUNAS  ; i++){
            for(int j = 0; j < MATRIZALIEN_NUM_LINHAS ; j++){
                matrizAlien[i][j].render(gc);
            }
        }
    }
}
