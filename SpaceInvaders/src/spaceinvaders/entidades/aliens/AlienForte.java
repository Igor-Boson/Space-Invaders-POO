/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.entidades.aliens;

import java.awt.Graphics;
import spaceinvaders.Handler;
import static spaceinvaders.entidades.Canhao.CANHAO_LIMITE_DIREITA;
import static spaceinvaders.entidades.Canhao.CANHAO_LIMITE_ESQUERDA;
import static spaceinvaders.entidades.tiro.MatrizTirosAlienForte.TAM_ARRAYTIROSALIENFORTE;
import spaceinvaders.gfx.Assets;

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
public class AlienForte extends Alien {
    
    public static final int TIROALIENFORTE_FIRERATE = 100; 
    public static final int VIDA_ALIENFORTE = 2;
    
    private int direcao = 1;
    private int vida;
    private int contMove = 0;
    private int idAlienForte = 0;
    private int idAtirar = 0;
    private int contAtirar = 0;
    
    public AlienForte(Handler handler, float x, float y) {
        super(handler, x, y);
        vida = VIDA_ALIENFORTE;
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
    public void levarDano(){
        vida -= 1;
    }
    
    @Override
    public void setVivoTrue(){
        vivo = true;
        vida = VIDA_ALIENFORTE;
    }    
    
    @Override
    public void isDead(){
        if(vida == 0)
            vivo = false;
    }
    
    public void bateuNaParede(){
        if(x <= CANHAO_LIMITE_ESQUERDA || x >= CANHAO_LIMITE_DIREITA){
            direcao *= -1;
            xMove *= direcao;
        }
    }
        
    public void setIdAlienForte(int idAlienForte){
        this.idAlienForte = idAlienForte;
    }
    
    public void atirar(){
        if(contAtirar  >= TIROALIENFORTE_FIRERATE){
            if(handler.getMatrizAlienForte()[idAtirar][idAlienForte].getUtil() == false){
                handler.getMatrizAlienForte()[idAtirar][idAlienForte].setX(getX()+getWidth()/4);
                handler.getMatrizAlienForte()[idAtirar][idAlienForte].setY(getY()+getHeight()/4);
                handler.getMatrizAlienForte()[idAtirar][idAlienForte].setUtilTrue();
                contAtirar = 0;
            }
            else{
                idAtirar++;
                if(idAtirar == TAM_ARRAYTIROSALIENFORTE)
                    id = 0;
            }
        }
        contAtirar++;
    }
    
    @Override
    public void tick(){ 
        isDead();
        if(vivo){
            atirar();
            atingiuBarricadas();
            bateuNaParede();
            moveAlienForte();
        }
    }
    
    @Override
    public void render(Graphics g){
        if(vivo){
            g.drawImage(Assets.alien4, (int)x, (int)y, (int)widthAlien, (int)heightAlien, null);
        }
    }
}
