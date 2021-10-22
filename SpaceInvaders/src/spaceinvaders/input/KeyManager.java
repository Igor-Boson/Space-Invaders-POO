/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Igor
 */
package spaceinvaders.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener{

    private boolean[] keys;
    public boolean left, right, up, down, shoot;
    
    public KeyManager(){
        keys = new boolean[256];
    }
    
    public void tick(){
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W] ;
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        shoot = keys[KeyEvent.VK_SPACE];
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    
    
}
