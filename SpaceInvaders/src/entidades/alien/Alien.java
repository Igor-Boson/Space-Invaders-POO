/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.alien;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;
import entidades.EntidadeMovel;
import static entidades.arrays.ArrayBarricadas.POS_Y_INICIAL_BARRICADA;


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
public class Alien extends EntidadeMovel{
    
    public static final int ALIEN_WIDTH = 50;
    public static final int ALIEN_HEIGHT = 50;
    protected int vida;
    protected boolean vivo;     
    protected int idNum;
    
    public Alien(int x, int y, Handler handler) {
        super(x, y, ALIEN_WIDTH, ALIEN_HEIGHT, handler);
    }

    public Alien(int x, int y, int w, int h,  Handler handler) {
        super(x, y, w, h, handler);
    }

    
    public void levarDano(){
        vida -= 1;
    }
    
    public void verificarMorto(){
        if(vida == 0)
            vivo = false;
    }
    
    public void atingiuBarricadas(){
        if(getY() + ALIEN_HEIGHT >= POS_Y_INICIAL_BARRICADA){
            handler.getGameOver().setGameOver(true);
        }
    }
    
    public boolean isVivo(){
        return vivo;
    }
    
    public void setVivo(boolean value){
        vivo = value;
    }
    
    public void setIdNum(int idNum){
        this.idNum = idNum;
    }
    
    public int getIdNum(){
        return idNum;
    }
    
    @Override
    public void update() {

    }

    @Override
    public void render(GraphicsContext gc) {
        
    }
    
}
