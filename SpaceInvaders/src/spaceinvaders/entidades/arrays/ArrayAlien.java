/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.entidades.arrays;

import java.awt.Graphics;
import java.util.ArrayList;
import spaceinvaders.Handler;
import spaceinvaders.entidades.aliens.Alien;

/**
 *  ArrayAlien
 * 
 * O ArrayAlien é uma classe que é feita para armazenar todos os aliens instanciados
 * utilizando um ArrayList
 * 
 * Assim, ao executar o tick() do ArrayAlien, é feito o tick() de todos os aliens armazenados
 * 
 * @author Igor
 */
public class ArrayAlien {
    
    private Handler handler;
    private ArrayList<Alien> arrayAlien;
    
    public ArrayAlien(Handler handler){
        this.handler = handler;
        arrayAlien = new ArrayList<Alien>();
        handler.setArrayAliens(this);
    }
    
    public void addAlien(Alien alien){
        arrayAlien.add(alien);
    }

    public Alien getAlien(int i){
        return arrayAlien.get(i);
    }
    
    public int getSize(){
        return arrayAlien.size();
    }
    
    public void tick(){
        for(int i = 0; i < arrayAlien.size(); i++)
            arrayAlien.get(i).tick();
    }
    
    public void render(Graphics g){
        for(int i = 0; i < arrayAlien.size(); i++)
            arrayAlien.get(i).render(g);
    }
    
}
