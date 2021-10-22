/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.hud;

import java.awt.Graphics;
import spaceinvaders.Handler;
import spaceinvaders.gfx.Assets;
import static spaceinvaders.Tutorial2D.EIXO_X;
import static spaceinvaders.Tutorial2D.EIXO_Y;
import static spaceinvaders.entidades.Canhao.CANHAO_LIMITE_DIREITA;
import static spaceinvaders.entidades.Canhao.CANHAO_LIMITE_ESQUERDA;
import static spaceinvaders.entidades.arrays.ArrayBarricadas.POS_Y_INICIAL_BARRICADA;
/**
 *  Background
 * 
 * O background é simplesmente a tela preta, com a parte cinza, que fica no fundo do jogo
 * Para ela ficar no fundo, essa classe é renderizada antes de tudo, e o resto é renderizado
 * por cima dela.
 * 
 * @author Igor
 */
public class Background {
    
    public static final int WITDH_QUADRADO_BACKGROUND = 32;
    public static final int HEIGHT_QUADRADO_BACKGROUND = 32;

    public static final int POS_X_PARTEINFERIOR = CANHAO_LIMITE_ESQUERDA;
    public static final int POS_Y_PARTEINFERIOR = (int)POS_Y_INICIAL_BARRICADA - 10;
    
    private final int numQuadrados_x = (int) EIXO_X / WITDH_QUADRADO_BACKGROUND;
    private final int numQuadrados_y = (int) EIXO_Y / HEIGHT_QUADRADO_BACKGROUND;
    private final int numQuadrados_parteInferior_x = (int) EIXO_X / WITDH_QUADRADO_BACKGROUND;
    private final int numQuadrados_parteInferior_y = (int) POS_Y_INICIAL_BARRICADA/WITDH_QUADRADO_BACKGROUND;
    
    private Handler handler;
    
    public Background(Handler handler){
        this.handler = handler;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        //tela toda
        for(int i = 0; i<numQuadrados_x ; i++)
            for(int j = 0; j <= numQuadrados_y; j++)
                g.drawImage(Assets.preto, 0 + WITDH_QUADRADO_BACKGROUND*i, 0 + HEIGHT_QUADRADO_BACKGROUND*j, null);
        
        //parte inferior
        for(int i = 0; i <= numQuadrados_parteInferior_x + 5; i++)
            for(int j = 0; j <= numQuadrados_parteInferior_y; j++)
                g.drawImage(Assets.cinza, POS_X_PARTEINFERIOR + WITDH_QUADRADO_BACKGROUND*i, POS_Y_PARTEINFERIOR + HEIGHT_QUADRADO_BACKGROUND*j, null);
        
        //ajeitando a parte inferior
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                g.drawImage(Assets.preto, CANHAO_LIMITE_DIREITA + WITDH_QUADRADO_BACKGROUND*i + 32, POS_Y_PARTEINFERIOR + HEIGHT_QUADRADO_BACKGROUND*j, null);
    }
}
