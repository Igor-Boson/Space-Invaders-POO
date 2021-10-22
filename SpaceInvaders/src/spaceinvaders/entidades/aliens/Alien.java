/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.entidades.aliens;

import java.awt.Graphics;
import spaceinvaders.Handler;
import spaceinvaders.entidades.EntidadeMovel;
import static spaceinvaders.entidades.arrays.ArrayBarricadas.POS_Y_INICIAL_BARRICADA;

/**
 * Alien
 * 
 * A classe abstrata Alien é o molde para as classes de alien existentes(até entao, 
 * o AlienForte e o AlienNormal)
 * 
 * Cada um desses tipos possuem rotinas de funcionamento bem distintas, mas ambos funcionam
 * com uma variavel int vida, e uma variavel boolean vivo
 * 
 * E quando qualquer um desses chegam até a posição y onde as barricadas são criadas, o 
 * jogador perde o jogo (GameOver). Eles fazem isso usando o método atingiuBarricadas(),
 * que compara constantemente a posição y deles com a posição y em que as barricadas 
 * são criadas
 * 
 * @author Igor
 */

public abstract class Alien extends EntidadeMovel{

    
    protected int widthAlien = 24;
    protected int heightAlien = 24;
    protected int vida;
    protected boolean vivo;     
    protected int id;
    
    public Alien(Handler handler, float x, float y) {
        super(handler, x, y);
        vivo = true;
    }

    
    public void levarDano(){
        vida -= 1;
    }
    
    public void isDead(){
        if(vida == 0)
            vivo = false;
    }
    
    public void atingiuBarricadas(){
        if(y+height >= POS_Y_INICIAL_BARRICADA)
            handler.getGameOver().setGameOverTrue();
    }
    
    public boolean getVivo(){
        return vivo;
    }
    
    public void setVivoFalse(){
        vivo = false;
    }
    
    public void setVivoTrue(){
        vivo = true;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        
    }
    
}
