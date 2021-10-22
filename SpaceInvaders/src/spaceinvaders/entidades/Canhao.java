/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entidades;

import java.awt.Graphics;
import spaceinvaders.Handler;
import static spaceinvaders.Tutorial2D.EIXO_X;
import static spaceinvaders.Tutorial2D.EIXO_Y;
import spaceinvaders.gfx.Assets;

/**
 * Canhao
 * 
 * O Canhao é a entidade que o jogador controla
 * 
 * O canhao se mexe através dos comandos do teclado (ver spaceinvaders.input.KeyManager),
 * alterando os valores de xMove e yMove. O tiro em si é feito na classe ArrayTirosCanhao
 * 
 * O canhao possui uma vida VIDA_CANHAO, e quando ele leva um tiro do AlienForte, ele 
 * perde 1 de vida e dá uma travadinha (ainda preciso trabalhar nas animações)
 * 
 * Quando o canhao chega a 0 de vida, voce perde o jogo (GameOver)
 * 
 * 
 * @author Igor
 */
public class Canhao extends EntidadeMovel{
    
    public static final float CANHAO_POS_X_INICIAL = 150;
    public static final float CANHAO_POS_Y_INICIAL = EIXO_Y - 80;
    public static final float CANHAO_X_SPEED = 3;
    public static final float CANHAO_Y_SPEED = 0;
    public static final int CANHAO_LIMITE_ESQUERDA = 50;
    public static final int CANHAO_LIMITE_DIREITA = EIXO_X - 50 - 32; //32 eh a width do canhao
    public static final int VIDA_CANHAO = 3;
    
    public static final int delayAoLevarDano = 40;
    
    private int vida = VIDA_CANHAO;
    private boolean vivo = true;
    private boolean danificado = false;
    private int contDelayLevouDano = 0;
    
    public Canhao(Handler handler, float x, float y) {
        super(handler, x, y);
        handler.setCanhao(this);
    }
    
    public void levarDano(){
        vida--;
        contDelayLevouDano = delayAoLevarDano;
    }
    
    public void delayLevouDano(){
        if(contDelayLevouDano > 0){
            contDelayLevouDano--;
            danificado = true;
        }
        if(contDelayLevouDano == 0)
            danificado = false;
    }
    
    public void moveCanhao(){
        if(!danificado)
            move();
    }
    
    public void isDead(){
        if(vida == 0)
            vivo = false;
    }
    
    public boolean getVivo(){
        return vivo;
    }
    
    public int getVida(){
        return vida;
    }
    
    public void limitesLaterais(){
        if(x < CANHAO_LIMITE_ESQUERDA && xMove < 0)
            xMove = 0;
        if(x > CANHAO_LIMITE_DIREITA && xMove > 0)
            xMove = 0;
    }
    
    public void getInput(){
        xMove = 0;
        yMove = 0;
        
        if(handler.getGame().getKeyManager().left)
            xMove -= CANHAO_X_SPEED;
        if(handler.getGame().getKeyManager().right)
            xMove += CANHAO_X_SPEED;
        if(handler.getGame().getKeyManager().up)
            yMove -= CANHAO_Y_SPEED;
        if(handler.getGame().getKeyManager().down)
            yMove += CANHAO_Y_SPEED;
    }
    
    @Override
    public void tick() {
        isDead();
        getInput();
        delayLevouDano();
        limitesLaterais();
        moveCanhao();
    }

    
    @Override
    public void render(Graphics g) {
        if(!danificado)     
            g.drawImage(Assets.canhao, (int)x, (int)y, null);
        if(danificado)
            g.drawImage(Assets.vermelho, (int)x, (int)y, null);
        if(!vivo)
            g.drawImage(Assets.laranja, (int)x, (int)y, null);
    }
    
}