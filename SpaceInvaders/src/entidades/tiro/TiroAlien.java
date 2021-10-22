/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.tiro;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;
import static engine.main.SpaceInvaders.EIXO_Y;
import static entidades.arrays.ArrayBarricadas.TAM_ARRAYBARRICADAS;

/**
 *  TiroAlien
 * 
 * O TiroAlien é o tiro atirado pelo alien forte.
 * 
 * Ao ser atirado, ele começa o seu movimento para cima com um yMove = -SPEED_TIROALIENFORTE
 * 
 * A cada tick, ele verifica se fez colisão com uma barricada ou o canhao, e assim, infligir
 * dano a ele.
 * 
 * Ao executar a função tick(), caso o Tiro esteja numa posição superior a EIXO_Y (fora da tela),
 * ele é setado como inutil (util = false)
 * 
 * @author Igor
 */
public class TiroAlien extends Tiro{
    
    public static final int TIROALIEN_WIDTH = 20;
    public static final int TIROALIEN_HEIGHT = 20; 
    public static final int TIROALIEN_SPEED = 3;
    
    public TiroAlien(int x, int y, Handler handler) {
        super(x, y, TIROALIEN_WIDTH, TIROALIEN_HEIGHT, handler);
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
    
    public void matarCanhao(){
        if(util){
            if(intersects(handler.getCanhao().getBoundsInLocal())){
                    handler.getCanhao().levarDano();
                    util = false;
                }
        }
    }
    
    @Override
    public void update(){
        if(getY() > EIXO_Y)
            util = false;      
        if(util){
            setYMove(TIROALIEN_SPEED + handler.getSpeedInc()/2);
            move();
            matarBarricada();
            matarCanhao();
        }
    }
    
    @Override
    public void render(GraphicsContext gc){
        gc.drawImage(handler.getAssets().tiroAlien, this.getX(), this.getY());
    }
}
