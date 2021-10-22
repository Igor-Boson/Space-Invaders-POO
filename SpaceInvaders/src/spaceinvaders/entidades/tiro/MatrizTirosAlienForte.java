/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.entidades.tiro;

import java.awt.Graphics;
import spaceinvaders.Handler;
import static spaceinvaders.entidades.arrays.ArrayAlienForte.TAM_ARRAYALIENFORTE;
import spaceinvaders.entidades.tiro.TiroAlienForte;

/**
 *  MatrizTirosAlienForte
 * 
 * A MatrizTirosAlienForte inicializa um array de TiroAlienForte de tamanhao TAM_ARRAYTIROSALIENFORTE
 * para cada AlienForte criado no ArrayAlienForte.
 * 
 * Assim, cada AlienForte possui o seu próprio array de TiroAlienForte, dessa forma fica mais organizado
 * 
 * A MatrizTirosAlienForte também é responsável por tickar e renderizar todos os TiroAlienForte.
 * 
 * @author Igor
 */
public class MatrizTirosAlienForte {
    
    private Handler handler;
    
    public static final int TAM_ARRAYTIROSALIENFORTE = 15;
    
    //matriz 
    public static TiroAlienForte[][] tiros;
    
    public MatrizTirosAlienForte(Handler handler){
        this.handler = handler;     
        tiros = new TiroAlienForte[TAM_ARRAYTIROSALIENFORTE][TAM_ARRAYALIENFORTE];
        handler.setMatrizTiroAlienForte(tiros);
        for(int i = 0; i < TAM_ARRAYTIROSALIENFORTE; i++)
            for(int j = 0; j < TAM_ARRAYALIENFORTE; j ++)
                tiros[i][j] = new TiroAlienForte(handler, 0, 0);
        
    }
    
    public TiroAlienForte[][] getMatrizTirosAlienForte(){
        return tiros;
    }
    
    public void tick(){
        for(int i = 0; i < TAM_ARRAYTIROSALIENFORTE; i++)
            for(int j = 0; j < TAM_ARRAYALIENFORTE; j ++)
                if(tiros[i][j].getUtil())
                    tiros[i][j].tick();
    }
    
    public void render(Graphics g){
        for(int i = 0; i < TAM_ARRAYTIROSALIENFORTE; i++)
            for(int j = 0; j < TAM_ARRAYALIENFORTE; j ++)
                if(tiros[i][j].getUtil())
                    tiros[i][j].render(g); 
    }
}
