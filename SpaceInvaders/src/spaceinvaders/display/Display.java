/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Igor
 */
package spaceinvaders.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *  Display
 * 
 * O Display é responsável por inicializar o JFrame, que é a janela do jogo, e o Canvas
 * que é onde os objetos do jogo são renderizados
 * 
 * 
 * @author Igor
 */
public class Display {
    private JFrame frame;                                            //o jframe é pra conseguir mostrar o canvas
    private Canvas canvas;                                           //o canvas é aonde vão ficar as coisas 
    
    private String title;
    private int width, height;
    
    //construtor do display
    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        
        //func para criar o jframe tudo certinho
        createDisplay();
    }
    
    //criador do JFrame e o canvas 
    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);        //faz o programa fechar direito qnd vc aperta o x
        frame.setResizable(false);                                  //impede o usuario de mexer no tamanho do display
        frame.setLocationRelativeTo(null);                          //faz a tela aparecer no centro, pra ficar bonitinho
        frame.setVisible(true);                                     //faz o display ser visivel
        
        canvas = new Canvas();                                          
        canvas.setPreferredSize(new Dimension(width, height));      //esse tanto de função é pra garantir que o
        canvas.setMaximumSize(new Dimension(width, height));        //canvas tá com o tamanho certo
        canvas.setMinimumSize(new Dimension(width, height));        // 
        canvas.setFocusable(false);
        
        frame.add(canvas);                                          //linka o canvas ao frame   
        frame.pack();                                               //garante que o frame e o canvas sao do msm tamanho
    }
    
    public Canvas getCanvas(){
        return canvas;
    }
    
    public JFrame getFrame(){
        return frame;
    }
    
}
