/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entidades.arrays;

import java.util.Random;
import spaceinvaders.Handler;
import static spaceinvaders.entidades.Canhao.CANHAO_LIMITE_DIREITA;
import static spaceinvaders.entidades.Canhao.CANHAO_LIMITE_ESQUERDA;
import spaceinvaders.entidades.aliens.AlienForte;
import static spaceinvaders.entidades.arrays.MatrizAlien.MATRIZALIEN_DISTY;

/**
 *  ArrayAlienForte
 * 
 * O ArrayAlienForte é a classe que armazenada todos os AlienForte
 * Quando ela é instanciada, ela instancia (int TAM_ARRAYALIENFORTE) aliens fortes e 
 * os armazena no ArrayAlien fornecido pelo handler. Esses aliens começam como "mortos" (vivo==false)
 * 
 * O ArrayAlienForte utiliza o Math.random() e o java.util.Random para gerar aleatoriamente
 * A cada (int (DELAY_CRIARALIENFORTE + até MAX_DELAY_CRIARALIENFORTE)) ticks, a função
 * criarAlien() pega um AlienForte que não está sendo usado (está morto) e seta ele como vivo,
 * e o dá valores X, Y, XMove, YMove novos aleatórios, 
 * 
 * 
 * @author Igor
 */
public class ArrayAlienForte {
    
    public static final int TAM_ARRAYALIENFORTE = 8;
    
    public static final int DELAY_CRIARALIENFORTE = 300;
    public static final int MAX_DELAY_CRIARALIENFORTE = 50;
    public static final int MIN_X = CANHAO_LIMITE_ESQUERDA;
    public static final int MAX_X = CANHAO_LIMITE_DIREITA;
    public static final int MIN_Y = MATRIZALIEN_DISTY;
    public static final int MAX_Y = MATRIZALIEN_DISTY + 20;
    public static final int MIN_XMOVE = 2;
    public static final int MAX_XMOVE = 4;
    public static final int MIN_YMOVE = 1;
    public static final int MAX_YMOVE = 2;
               
    private Random random;
    private Handler handler;
    private AlienForte[] arrayAlienForte;
    private int contCriarAlien = 0;
    private int contId = 0;
    
    public ArrayAlienForte(Handler handler){
        this.handler = handler;
        arrayAlienForte = new AlienForte[TAM_ARRAYALIENFORTE];
        random = new Random();
        handler.setArrayAlienForte(arrayAlienForte);
        for(int i = 0; i < TAM_ARRAYALIENFORTE; i++){
            arrayAlienForte[i] = new AlienForte(handler, 50, 0);
            arrayAlienForte[i].setVivoFalse();
            arrayAlienForte[i].setId(handler.getArrayAliens().getSize() + 1);
            arrayAlienForte[i].setIdAlienForte(i);
            
            handler.getArrayAliens().addAlien(arrayAlienForte[i]);
        }
    }
    
    public void criarAlien(){
        if(contCriarAlien >= DELAY_CRIARALIENFORTE + Math.random() * (MAX_DELAY_CRIARALIENFORTE - 0 + 1) + 0){
            if(!arrayAlienForte[contId].getVivo()){
                
                arrayAlienForte[contId].setVivoTrue();
               
                float tempXMove = (float)Math.random() * (MAX_XMOVE - MIN_XMOVE + 1) + MIN_XMOVE;
                if(random.nextBoolean())
                    tempXMove = -tempXMove;

                arrayAlienForte[contId].setX((float)Math.random() * (MAX_X - MIN_X + 1) + MIN_X);
                arrayAlienForte[contId].setY((float)Math.random() * (MAX_Y - MIN_Y + 1) + MIN_Y);
                arrayAlienForte[contId].setXMove(tempXMove);
                arrayAlienForte[contId].setYMove((float)Math.random() * (MAX_YMOVE - MIN_YMOVE + 1) + MIN_YMOVE);
                
                contCriarAlien = 0;
                contId = 0;
            }                
            else{
                contId++;
            }
        }
        contCriarAlien++;
    }
    
    public void tick(){
        criarAlien();
    }
    
}
