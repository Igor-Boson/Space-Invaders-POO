/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders;

import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.display.Display;
import spaceinvaders.gfx.Assets;
import spaceinvaders.input.KeyManager;
import spaceinvaders.state.GameState;
import spaceinvaders.state.MenuState;
import spaceinvaders.state.State;
import spaceinvaders.state.currentState;

/** Game
 * 
 * O Game é responsável pela engine do jogo
 * A parte mais importante aqui é o run();, que faz com que as funções tick() e render() 
 * rodem em no maximo 60 ticks (frames) por segundo
 * 
 * o tick() é responsável por rodar o tick() de todas as instancias das classes no jogo
 * o tick() dessas instancias é responsável por varias coisas, como o movimento do canhao
 * o render() das instancias é responsável por fazer elas aparecerem na tela
 *
 * @author Igor
 */

public class Game implements Runnable{
    //a interface runnable faz com que o game possa ser feito numa thread separada
    
    private Display display;
    private int width, height;
    private String title;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //States
    private State gameState;
    private State menuState;
    
    //input
    private KeyManager keyManager;
    
    //handler
    private Handler handler;
    
    private boolean rodando = false;
    private Thread thread;
    
    public Game(String title, int width, int height){
        this.width = width;                                         //passa os parametros
        this.height = height;                                       //pra poder usar livremente
        this.title = title;
        keyManager = new KeyManager();
    }
    
    //init() inicializa tudo p/ o game
    public void init() throws FontFormatException, IOException{
        display = new Display(title, width, height);                //inicializa o display 
        display.getFrame().addKeyListener(keyManager);
        Assets.init();                                              //inicializa todos os assets
        handler = new Handler(this);
        
        
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        currentState.setState(gameState);
    }
    
    // serve para dar update nas entidades do jogo
    public void tick(){
        keyManager.tick();
        
        if(currentState.getState() != null)
            currentState.getState().tick();
    }
    
    //serve para renderizar as entidades do jogo
    public void render(){
        bs = display.getCanvas().getBufferStrategy();               //pega o bs do canvas 
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);            //cria 3 buffers, qnd começa o programa
            return;
        }
        g = bs.getDrawGraphics();                                   //o graphics vai desenhar nos buffers
        //limpa a tela
        
        g.clearRect(0, 0, width, height);                           //limpa tudo dentro desse retangulo
            
        //Toda a parte de desenho vai aqui
        
        if(currentState.getState() != null)
            currentState.getState().render(g);
        
        //acaba os desenhos
        bs.show();                                                  //faz a magica pra aparecer na tela
        g.dispose();                                                //fecha o graphics direitinho
    }
    
    //é aqui que ocorre o game loop
    public void run(){
        
        try {
            init();
        } catch (FontFormatException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int fps = 60;                                               //queremos que o jogo rode a 60fps
        double timePerTick = 1000000000/fps;                        //a duração maxima de um tick deve ser
        double delta = 0;                                           // 1/60 segundos, para assim ter 60fps
        long now;                                                   // no total (1s = 100000000 nanosegundos)
        long lastTime = System.nanoTime();                          // pega o tempo em ns                                                            
        
        
        while(rodando){
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;                  //queremos que o jogo só atualize apos
            lastTime = now;                                         //rodar 1/60 segundos desde o ultimo tick,
                                                                    //assim dá pra qnd atualiza e o
                                                                    //sistema consegue operar a 60fps
            if(delta >= 1){                                         
                tick();
                render();
                delta--;
            }

        }
    }
    
    public KeyManager getKeyManager(){
        return keyManager;
    }
        
    //thread que é inicializada quando o jogo começa
    public synchronized void start(){
        if(rodando)                                                 //só pra garantir que n vai dar algum
            return;                                                 //erro sem querer
        
        rodando = true;                                             //rodando = true --> o jogo tá rodando
        thread = new Thread(this);                                  //passa o game como paramentro p thread
        thread.start();                                             //começa a thread e chama o run()
    }
    
    //para a thread quando o jogo para
    public synchronized void stop(){
        if(!rodando)                                                //só pra garantir que n vai dar algum
            return;                                                 //erro sem querer
        
        rodando = false;                                            //rodando = true --> o jogo n tá rodando
        try{
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
}
