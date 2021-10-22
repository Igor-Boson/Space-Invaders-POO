/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.alien;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;
import static entidades.Canhao.CANHAO_LIMITE_DIREITA;
import static entidades.Canhao.CANHAO_LIMITE_ESQUERDA;
import static entidades.arrays.MatrizTiroAlien.TAM_ARRAYTIROSALIENFORTE;

/**
 *  AlienForte
 * 
 * O AlienForte é o alien que aparece periodicamente, atraves da classe ArrayAlienForte,
 * e atira periodicamente, com a intenção de acertar o Canhao
 * 
 * Ele atira a cada (int TIROALIENFORTE_FIRERATE) ticks.
 * Para entender como funcionam os tiros, ver no spaceinvaders.entidades.tiro.Tiro
 * 
 * Como é dificil de controlar a velocidade do Alien (ele não pode andar 0.5 pixel a cada tick)
 * O movimento do AlienForte é feito apenas a cada 2 ticks, assim, "ele funciona a 30ticks por segundo"
 * desse modo, ele consegue andar 1 pixel a cada 2 ticks.
 * 
 * Eu fiz isso por que se não, a velocidade dele sempre ficava rápida demais, e ficava injusto
 * para o jogador.
 * 
 * @author Igor
 */
public class AlienForte extends Alien{
    
    public static final int ALIEN_FORTE_WIDTH = 60;
    public static final int ALIEN_FORTE_HEIGHT = 60;
    public static final int TIROALIENFORTE_FIRERATE = 180; 
    public static final int VIDA_ALIENFORTE = 2;
    public static final int ALIENFORTE_SCORE = 300;
    
    private int vida;
    private int contMove = 0;
    private int idAlienForte = 0;
    private int idAtirar = 0;
    private int contAtirar = 0;
    
    public AlienForte(int x, int y, Handler handler) {
        super(x, y, ALIEN_FORTE_WIDTH, ALIEN_FORTE_HEIGHT, handler);
        vida = VIDA_ALIENFORTE;
        vivo = false;
    }
    
    @Override
    public void verificarMorto(){
        if(vida == 0){
            vivo = false;
            handler.getScore().addScore(ALIENFORTE_SCORE);
            vida = -1;
        }
    }
    
    public void moveAlienForte(){
        if(contMove >= 2){
            move();
            contMove = 0;
        }
        else
            contMove++;
    }
    
    @Override
    public void setVivo(boolean value){
        vivo = value;
    }
    
    public void setVidaToDefault(){
        vida = VIDA_ALIENFORTE;
    }
    
    @Override
    public void levarDano(){
        vida -= 1;
    }
    
    public void bateuNaParede(){
        if(getX() <= CANHAO_LIMITE_ESQUERDA || getX() >= CANHAO_LIMITE_DIREITA - ALIEN_FORTE_WIDTH){
            xMove *= -1;
        }
    }
        
    public void setIdAlienForte(int idAlienForte){
        this.idAlienForte = idAlienForte;
    }
    
    public void atirar(){
        if(contAtirar  >= TIROALIENFORTE_FIRERATE - handler.getSpeedInc()*4){
            if(handler.getMatrizTiroAlien().getMatriz()[idAtirar][idAlienForte].isUtil() == false){
                handler.getMatrizTiroAlien().getMatriz()[idAtirar][idAlienForte].setX(getX()+getWidth()/4);
                handler.getMatrizTiroAlien().getMatriz()[idAtirar][idAlienForte].setY(getY()+getHeight());
                handler.getMatrizTiroAlien().getMatriz()[idAtirar][idAlienForte].setUtil(true);
                contAtirar = 0;
            }
            else{
                idAtirar++;
                if(idAtirar == TAM_ARRAYTIROSALIENFORTE)
                    idNum = 0;
            }
        }
        contAtirar++;
    }
    
    @Override
    public void update(){ 
        verificarMorto();
        if(vivo){
            atirar();
            atingiuBarricadas();
            bateuNaParede();
            moveAlienForte();
        }
    }
    
    @Override
    public void render(GraphicsContext gc){
        if(vivo)
            gc.drawImage(handler.getAssets().alienForte, this.getX(), this.getY());
    }
}
