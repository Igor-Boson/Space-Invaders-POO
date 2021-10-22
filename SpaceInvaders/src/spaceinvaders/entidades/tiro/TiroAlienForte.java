/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entidades.tiro;

import java.awt.Graphics;
import spaceinvaders.Handler;
import static spaceinvaders.Tutorial2D.EIXO_Y;
import static spaceinvaders.entidades.arrays.ArrayBarricadas.TAM_ARRAYBARRICADAS;
import spaceinvaders.gfx.Assets;

/**
 *  TiroAlienForte
 * 
 * O TiroAlienForte é o tiro atirado pelo alien forte.
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
public class TiroAlienForte extends Tiro{
    
    public static final int SPEED_TIROALIENFORTE = 4;
    
    public TiroAlienForte(Handler handler, float x, float y) {
        super(handler, x, y);
        yMove = SPEED_TIROALIENFORTE;
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
    
    public void matarCanhao(){
        if(util){
            if(getBounds().intersects(handler.getCanhao().getBounds())){
                    handler.getCanhao().levarDano();
                    util = false;
                }
        }
    }
    
    @Override
    public void tick(){
        if(y > EIXO_Y)
            util = false;      
        if(util){
            move();
            matarBarricada();
            matarCanhao();
        }
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(Assets.vermelho, (int)x, (int)y, (int)width, (int)height, null);
    }
}
