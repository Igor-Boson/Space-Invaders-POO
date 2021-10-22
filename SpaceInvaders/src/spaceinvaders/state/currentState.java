/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.state;

/**
 *
 * @author Igor
 */
public class currentState {
    private static State currentState = null;
    
    public static void setState(State state){
        currentState = state;
    }
    
    public static State getState(){
        return currentState;
    }
}
