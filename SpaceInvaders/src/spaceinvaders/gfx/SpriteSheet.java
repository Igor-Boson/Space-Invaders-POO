/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  SpriteSheet
 * 
 * A classe SpriteSheet serve para criar a função crop.
 * Para otimizar o processo de carregar os recursos gráficos, invés de abrir uma imagem para
 * cada asset, carrega-se uma única imagem, o SpriteSheet (uma imagem com várias outras), e a
 * partir dessa, se recorta todas as outras do jogo.
 * 
 * @author Igor
 */
package spaceinvaders.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage sheet;
    
    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }
    
    public BufferedImage crop(int x, int y, int width, int height){
        return sheet.getSubimage(x, y, width, height);                      //cropa a imagem 
    }
}
