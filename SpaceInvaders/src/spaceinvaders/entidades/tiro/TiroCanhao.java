/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entidades.tiro;

import java.awt.Graphics;
import spaceinvaders.Handler;
import static spaceinvaders.hud.Score.SCORE_ALIENKILL;
import static spaceinvaders.entidades.arrays.ArrayBarricadas.TAM_ARRAYBARRICADAS;
import spaceinvaders.gfx.Assets;

/**
 *  TiroCanhao
 * 
 * O TiroCanhao é o tiro atirado pelo canhao.
 * 
 * Ao ser atirado, ele começa o seu movimento para cima com um yMove = -SPEED_TIROCANHAO
 * 
 * A cada tick, ele verifica se fez colisão com uma barricada ou um alien, e assim, infligir
 * dano a ele.
 * 
 * Ao executar a função tick(), caso o Tiro esteja numa posição inferior a -50 (fora da tela),
 * ele é setado como inutil (util = false)
 * 
 * @author Igor
 */
public class TiroCanhao extends Tiro{
       
    public static final int TIROCANHAO_FIRERATE = 20;  
    public static final int SPEED_TIROCANHAO = 6;
    
    public TiroCanhao(Handler handler, float x, float y) {
        super(handler, x, y);
        yMove = -SPEED_TIROCANHAO;
    }
    
    public void matarAlien(){
        for(int i = 0; i < handler.getArrayAliens().getSize(); i++){
            if(handler.getArrayAliens().getAlien(i).getVivo() && util)
                if(getBounds().intersects(handler.getArrayAliens().getAlien(i).getBounds())){
                    handler.getArrayAliens().getAlien(i).levarDano();
                    util = false;
                    handler.getScore().addScore(SCORE_ALIENKILL);
                }
        }
    }
    
    public void matarBarricada(){
        for(int i = 0; i < TAM_ARRAYBARRICADAS; i++){
            if(handler.getArrayBarricadas()[i].getVivo() && util)
                if(getBounds().intersects(handler.getArrayBarricadas()[i].getBoundsImovel())){
                    handler.getArrayBarricadas()[i].levarDano();
                    util = false;
                }
        }
    }
    
    @Override
    public void tick() {
        if(y < -50)
            util = false;      
        if(util){
            move();
            matarAlien();
            matarBarricada();
        }       
    }
    
    @Override
    public void render(Graphics g) {
        if(util)
            g.drawImage(Assets.tiro, (int)x, (int)y, (int)width, (int)height, null);      
    }
    
}
