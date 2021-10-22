/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.tiro;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;
import static entidades.arrays.ArrayBarricadas.TAM_ARRAYBARRICADAS;

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
    
    public static final int TIROCANHAO_WIDTH = 20;
    public static final int TIROCANHAO_HEIGHT = 20;
    public static final int TIROCANHAO_FIRERATE = 60;  
    public static final int SPEED_TIROCANHAO = -4;
    
    public TiroCanhao(int x, int y, Handler handler) {
        super(x, y, TIROCANHAO_WIDTH, TIROCANHAO_HEIGHT, handler);
    }
    
    public void matarAlien(){
        for(int i = 0; i < handler.getArrayAlien().getSize(); i++){
            if(handler.getArrayAlien().getAlien(i).isVivo() && util)
                if(intersects(handler.getArrayAlien().getAlien(i).getBoundsInLocal())){
                    handler.getArrayAlien().getAlien(i).levarDano();
                    util = false;
                    //handler.getScore().addScore(SCORE_ALIENKILL);
                }
        }
    }
    
    public void matarBarricada(){
        for(int i = 0; i < TAM_ARRAYBARRICADAS; i++){
            if(handler.getArrayBarricadas().getArray()[i].isVivo() && util)
                if(intersects(handler.getArrayBarricadas().getArray()[i].getBoundsInLocal())){
                    handler.getArrayBarricadas().getArray()[i].levarDano();
                    util = false;
                }
        }
    }
    
    @Override
    public void update() {
        if(getY() < -50)
            util = false;      
        if(util){
            setYMove(SPEED_TIROCANHAO - handler.getSpeedInc()/2);
            move();
            matarAlien();
            matarBarricada();
        }       
    }
    
    @Override
    public void render(GraphicsContext gc) {
        if(util)
            gc.drawImage(handler.getAssets().tiroCanhao, this.getX(), this.getY());
    }
}
