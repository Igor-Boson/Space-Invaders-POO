/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.arrays;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import engine.handler.Handler;
import entidades.alien.Alien;

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
        handler.setArrayAlien(this);
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
    
    public void update(){
        for(int i = 0; i < arrayAlien.size(); i++)
            arrayAlien.get(i).update();
    }
    
    public void render(GraphicsContext gc){
        for(int i = 0; i < arrayAlien.size(); i++)
            arrayAlien.get(i).render(gc);
    }
    
}
