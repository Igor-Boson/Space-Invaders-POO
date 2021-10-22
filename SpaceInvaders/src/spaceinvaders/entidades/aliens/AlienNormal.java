/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entidades.aliens;

import java.awt.Graphics;
import spaceinvaders.Handler;
import static spaceinvaders.Tutorial2D.EIXO_X;
import static spaceinvaders.entidades.arrays.ArrayBarricadas.POS_Y_INICIAL_BARRICADA;
import static spaceinvaders.entidades.arrays.MatrizAlien.MATRIZALIEN_DISTX;
import static spaceinvaders.entidades.arrays.MatrizAlien.MATRIZALIEN_DISTY;
import static spaceinvaders.entidades.arrays.MatrizAlien.MATRIZALIEN_POSINICIALX;
import spaceinvaders.gfx.Assets;

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
    
    //movimento
    private int alienXSpeed = MATRIZALIEN_DISTX;
    private int alienYSpeed;
    private int direcao = 1;
    private int contadorTicks = 0;
    private int delayMove = 40;
    private int deltaDelayMove = 4;
    private int delayMoveMin = 15;
    private int movsAteParede;
    private int movsAteBarricada;
    private int contAteParede = 0;
    private int contAteBarricada = 0;
    
    private int tipo = 1;
    private int widthAlien = 24;
    private int heightAlien = 24;
    
    public AlienNormal(Handler handler, float x, float y, int tipo) {
        super(handler, x, y);
        this.tipo = tipo;
        
        if(tipo == 3)
            vida = 2;
        else
            vida = 1;
        
        width = widthAlien;
        height = heightAlien;
        movsAteParede = (int)(EIXO_X - MATRIZALIEN_POSINICIALX)
                        /(widthAlien+MATRIZALIEN_DISTX);
        movsAteBarricada = (int)(POS_Y_INICIAL_BARRICADA - y - height)
                        /(heightAlien+MATRIZALIEN_DISTY);
        contAteBarricada = movsAteBarricada;
        alienYSpeed = (int)(POS_Y_INICIAL_BARRICADA - y - height)/movsAteBarricada;
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
    public void tick() {
        isDead();
        if(vivo){
            moveAlien();
            atingiuBarricadas();
        }
    }
    
    @Override
    public void render(Graphics g) {
        if(vivo){
            if(tipo == 1)
                g.drawImage(Assets.alien1, (int)x, (int)y, (int)widthAlien, (int)heightAlien, null);
            if(tipo == 2)
                g.drawImage(Assets.alien2, (int)x, (int)y, (int)widthAlien, (int)heightAlien, null);
            if(tipo == 3)
                g.drawImage(Assets.alien5, (int)x, (int)y, (int)widthAlien, (int)heightAlien, null);
            if(tipo == 4)
                g.drawImage(Assets.alien1, (int)x, (int)y, (int)widthAlien, (int)heightAlien, null);
            if(tipo == 5)
                g.drawImage(Assets.alien3, (int)x, (int)y, (int)widthAlien, (int)heightAlien, null);
        }
    }
    
}
