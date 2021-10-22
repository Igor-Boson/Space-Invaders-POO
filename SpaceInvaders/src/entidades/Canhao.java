/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;
import static engine.main.SpaceInvaders.EIXO_X;
import static engine.main.SpaceInvaders.EIXO_Y;

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
    
    public static final int CANHAO_POS_X_INICIAL = 150;
    public static final int CANHAO_POS_Y_INICIAL = EIXO_Y - 80;
    public static final int CANHAO_X_SPEED_BASE = 3;
    public static final int CANHAO_Y_SPEED = 0;
    public static final int CANHAO_LIMITE_ESQUERDA = 50;
    public static final int CANHAO_LIMITE_DIREITA = EIXO_X - 50; //32 eh a width do canhao
    public static final int VIDA_CANHAO = 3;
    public static final int CANHAO_WIDTH = 50;
    public static final int CANHAO_HEIGHT = 50;
    public static final int CANHAO_DELAY_DANIFICADO = 40;
    
    private int contDelayDanificado = 0;
    private int vida = VIDA_CANHAO;
    private boolean vivo = true;
    private boolean danificado = false;
    private int contDelayLevouDano = 0;
    
    public Canhao(int x, int y, int w, int h, Handler handler) {
        super(x, y, w, h, handler);
        handler.setCanhao(this);
    }
    
    public Canhao(int x, int y, Handler handler) {
        super(x, y, handler);
        handler.setCanhao(this);
    }
    
    public boolean isVivo(){
        return vivo;
    }
    
    public void levarDano(){
        vida--;
        
        //danifica o canhao e faz ele voltar pra pos inicial, com delay
        setX(CANHAO_POS_X_INICIAL);
        setY(CANHAO_POS_Y_INICIAL);
        danificado = true;
        contDelayDanificado = CANHAO_DELAY_DANIFICADO;
    }

    public void whileDanificado(){
        if(contDelayDanificado > 0)
            contDelayDanificado--;
        else
            danificado = false;
    }
    
    public void verificarVivo(){
        if(vida == 0)
            vivo = false;
    }
    
    private void inputCanhao(){
        if (handler.getKeyboard().isLeft())
            xMove -= CANHAO_X_SPEED_BASE + handler.getSpeedInc()/2;
        if (handler.getKeyboard().isRight())
            xMove += CANHAO_X_SPEED_BASE + handler.getSpeedInc()/2;
    }
    
    public void limitesLaterais(){
        if(getX() < CANHAO_LIMITE_ESQUERDA && xMove < 0)
            xMove = 0;
        if(getX() + CANHAO_WIDTH > CANHAO_LIMITE_DIREITA && xMove > 0)
            xMove = 0;
    }
    
    public int getVida() {
        return vida;
    }
    
    @Override
    public void update(){
        verificarVivo();
        if(vivo){
            inputCanhao();
            limitesLaterais();
            if(danificado)
                whileDanificado();
            if(!danificado)
                move();
            xMove = 0;
        }
    }
    
    @Override
    public void render(GraphicsContext gc){
        gc.drawImage(handler.getAssets().spaceship, this.getX(), this.getY());
    }
    
}
