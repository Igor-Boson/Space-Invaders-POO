/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.alien;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;
import static engine.main.SpaceInvaders.EIXO_X;
import static entidades.arrays.ArrayBarricadas.POS_Y_INICIAL_BARRICADA;
import static entidades.arrays.MatrizAlienNormal.MATRIZALIEN_DISTX;
import static entidades.arrays.MatrizAlienNormal.MATRIZALIEN_DISTY;
import static entidades.arrays.MatrizAlienNormal.MATRIZALIEN_POSINICIALX;

/**
 *  AlienNormal
 * 
 * O AlienNormal é o Alien que é criada na MatrizAlien, e vai descendo até as barricadas
 * O movimento dele é feito da seguinte forma, na função moveAlien():
 * 
 * A cada (int delayMove) ticks, o alien faz o seu movimento na horizontal.
 * Depois de fazer esse movimento (int movsAteBarricada) vezes, o alien faz um movimento 
 * na vertical(ele desce) e inverte a direção do movimento na horizontal.
 * A cada vez que ele que ele faz o movimento na vertical, o delayMove é diminuído em 
 * deltaDelayMove ticks. Assim, o movimento do alien fica cada vez mais rápido
 * 
 * Ao ser criado na MatrizAlien, o alien é atribuído um int tipo, conforme a linha 
 * em que ele foi criado. Isso é usado para renderizar um sprite diferente em cada linha.
 * 
 * Para deixar mais interessante, os aliens da terceira linha, os azuis, possuem 2 de vida
 * inves de 1.
 * 
 * 
 * @author Igor
 */
public class AlienNormal extends Alien{
    
    public static final int ALIEN_NORMAL_WIDTH = 40;
    public static final int ALIEN_NORMAL_HEIGHT = 40;
    public static final int ALIENNORMAL_SCORE = 100; 
    
    //movimento
    private int alienXSpeed = MATRIZALIEN_DISTX;
    private int alienYSpeed;
    private int direcao = 1;
    private int contadorTicks = 0;
    private int delayMove = 90;
    private int deltaDelayMove = 10;
    private int delayMoveMin = 15;
    private int movsAteParede;
    private int movsAteBarricada;
    private int contAteParede = 0;
    private int contAteBarricada = 0;
    
    
    private int tipo = 1;
    
    public AlienNormal(int x, int y, Handler handler, int tipo) {
        super(x, y, ALIEN_NORMAL_WIDTH, ALIEN_NORMAL_HEIGHT, handler);
        vivo = true;
        this.tipo = tipo;
        vida = 1;
        if(tipo == 3)
            vida = 3;
        if(tipo == 2 || tipo == 4)
            vida = 2;
        else
            vida = 1;
        movsAteParede = (int)(EIXO_X - MATRIZALIEN_POSINICIALX)
                        /(ALIEN_WIDTH+MATRIZALIEN_DISTX);
        movsAteBarricada = (POS_Y_INICIAL_BARRICADA - ALIEN_HEIGHT)
                        /(ALIEN_HEIGHT+MATRIZALIEN_DISTY);
        contAteBarricada = movsAteBarricada;
        alienYSpeed = (POS_Y_INICIAL_BARRICADA - ALIEN_HEIGHT)/movsAteBarricada;
    }
    
    public void moveAlien(){
        xMove = 0;
        yMove = 0;
        contadorTicks++;
        if(contadorTicks == delayMove){
            if(contAteParede == movsAteParede){
                contAteParede = 0;
                contAteBarricada --;
                contadorTicks = 0;
                xMove = 0 ;
                yMove = 50;
                direcao *= -1;
                if(delayMove > delayMoveMin)
                    delayMove -= deltaDelayMove;
                move();
            }
            else{
                contadorTicks = 0;
                contAteParede++;
                xMove = alienXSpeed * direcao;
                yMove = 0;
                move();
            }
        }
    }
    
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
    
    @Override
    public void verificarMorto(){
        if(vida == 0){
            vivo = false;
            handler.getScore().addScore(ALIENNORMAL_SCORE);
            vida = -1;
        }
    }
    @Override
    public void update() {
        verificarMorto();
        if(vivo){
            moveAlien();
            atingiuBarricadas();
        }
    }
    
    @Override
    public void render(GraphicsContext gc){
        if(vivo){
            if(tipo == 1 || tipo == 5)
                gc.drawImage(handler.getAssets().alien3, this.getX(), this.getY());
            if(tipo == 2 || tipo == 4)
                gc.drawImage(handler.getAssets().alien1, this.getX(), this.getY());
            if(tipo == 3)
                gc.drawImage(handler.getAssets().alien2, this.getX(), this.getY());
        }
    }
    
}
