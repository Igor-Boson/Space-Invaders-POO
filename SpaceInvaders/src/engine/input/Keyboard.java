/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.input;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import engine.handler.Handler;

/**
 *
 * @author igor_
 */
public class Keyboard {
    
    private Handler handler;
    
    private Scene scene;
    private boolean left;
    private boolean right;
    private boolean shoot;
    private boolean gameStarted = false;

    private boolean[] keys;
    
    public Keyboard(Handler handler){
        this.handler = handler;
        scene = handler.getScene();
        handler.setKeyboard(this);
    }

    public void getInput(){
        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
           switch(e.getCode()) {
                case A:
                    gameStarted = true;
                   left = true;
                   break;
                case D:
                    gameStarted = true;
                    right = true;
                    break;
                case SPACE:
                    gameStarted = true;
                    shoot = true;
                    break;
                default:
                    gameStarted = true;
                    break;
           } 
        });
        scene.addEventHandler(KeyEvent.KEY_RELEASED, e -> {
           switch(e.getCode()) {
                case A:
                   left = false;
                   break;
                case D:
                    right = false;
                    break;
                case SPACE:
                    shoot = false;
                    break;
           } 
        });
    }

    public void update(){
        getInput();
    }
    
    public boolean isLeft() {
        return left;
    }
    
    public boolean isRight() {
        return right;
    }

    public boolean isShoot() {
        return shoot;
    }
    
    public boolean isGameStarted() {
        return gameStarted;
    }

}
