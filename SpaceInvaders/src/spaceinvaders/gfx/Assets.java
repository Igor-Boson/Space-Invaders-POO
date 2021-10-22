/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.gfx;

import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

/**
 *  Assets
 * 
 * Os Assets são todos os recursos do jogo, até o momento esses são imagems e a fonte utilizada.
 * Todos esses recursos são inicializados através da função init(), que é chamada dentro da init()
 * do Game, e assim, eles podem ser usados livremente no programa.
 * 
 * @author Igor
 */
public class Assets {
    
    private static final int width = 32, height = 32;
    public static BufferedImage laranja, azul, vermelho, roxo, branco, preto, verde, amarelo, cinza;
    public static BufferedImage canhao, alien1, alien2, alien3, alien4, alien5, tiro;
    public static Font joystix ;
    public static final float TAM_FONTE_JOYSTIX = 15;
    
    public static void init() throws FontFormatException, IOException{
        //Textures
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));       
        
        laranja = sheet.crop(width * 0, height * 0, width, height);
        azul = sheet.crop(width * 1, height * 0, width, height);
        vermelho = sheet.crop(width * 2, height * 0, width, height);
        roxo = sheet.crop(width * 3, height * 0, width, height);
        branco = sheet.crop(width * 0, height * 1, width, height);
        preto = sheet.crop(width * 1, height * 1, width, height);
        verde = sheet.crop(width * 2, height * 1, width, height);
        amarelo = sheet.crop(width * 3, height * 1, width, height);
        cinza = sheet.crop(width * 0, height * 2, width, height);
        
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet2.png"));       
        
        canhao = sheet2.crop(width * 0, height * 0, width, height);
        alien1 = sheet2.crop(width * 1, height * 0, width, height);
        alien2 = sheet2.crop(width * 2, height * 0, width, height);
        alien3 = sheet2.crop(width * 3, height * 0, width, height);
        alien4 = sheet2.crop(width * 0, height * 1, width, height);
        alien5 = sheet2.crop(width * 1, height * 1, width, height);
        tiro = sheet2.crop(width * 2, height * 1, width, height);
        
        
        //Font
        try {
            joystix = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/joystix.ttf")).deriveFont(TAM_FONTE_JOYSTIX);
            GraphicsEnvironment ge = 
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/joystix.ttf")));
        } catch (IOException|FontFormatException e) {
            e.getMessage();
        }
    }
}
