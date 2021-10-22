/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.arrays;

import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;
import static entidades.arrays.ArrayAlienForte.TAM_ARRAYALIENFORTE;
import entidades.tiro.TiroAlien;

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
public class MatrizTiroAlien {
    private Handler handler;
    
    public static final int TAM_ARRAYTIROSALIENFORTE = 15;
    
    //matriz 
    public static TiroAlien[][] tiros;
    
    public MatrizTiroAlien(Handler handler){
        this.handler = handler;     
        tiros = new TiroAlien[TAM_ARRAYTIROSALIENFORTE][TAM_ARRAYALIENFORTE];
        handler.setMatrizTiroAlien(this);
        for(int i = 0; i < TAM_ARRAYTIROSALIENFORTE; i++)
            for(int j = 0; j < TAM_ARRAYALIENFORTE; j ++)
                tiros[i][j] = new TiroAlien( 0, 0, handler);
        
    }
    
    public TiroAlien[][] getMatriz(){
        return tiros;
    }
    
    public TiroAlien[][] getMatrizTirosAlienForte(){
        return tiros;
    }
    
    public void update(){
        for(int i = 0; i < TAM_ARRAYTIROSALIENFORTE; i++)
            for(int j = 0; j < TAM_ARRAYALIENFORTE; j ++)
                if(tiros[i][j].isUtil())
                    tiros[i][j].update();
    }
    
    public void render(GraphicsContext gc){
        for(int i = 0; i < TAM_ARRAYTIROSALIENFORTE; i++)
            for(int j = 0; j < TAM_ARRAYALIENFORTE; j ++)
                if(tiros[i][j].isUtil())
                    tiros[i][j].render(gc); 
    }
}
