/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx.assets;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import engine.handler.Handler;
import static entidades.Barricada.BARRICADA_WIDTH;
import static entidades.Canhao.CANHAO_HEIGHT;
import static entidades.Canhao.CANHAO_WIDTH;
import static entidades.alien.AlienForte.ALIEN_FORTE_HEIGHT;
import static entidades.alien.AlienForte.ALIEN_FORTE_WIDTH;
import static entidades.alien.AlienNormal.ALIEN_NORMAL_HEIGHT;
import static entidades.alien.AlienNormal.ALIEN_NORMAL_WIDTH;
import static entidades.tiro.TiroAlien.TIROALIEN_HEIGHT;
import static entidades.tiro.TiroAlien.TIROALIEN_WIDTH;
import static entidades.tiro.TiroCanhao.TIROCANHAO_HEIGHT;
import static entidades.tiro.TiroCanhao.TIROCANHAO_WIDTH;

/**
 *
 * @author igor_
 */
public class Assets {
    
    public Image teste;
    public Image background;
    public Image titleScreen;
    public Image spaceship;
    public Image alien1, alien2, alien3, alienForte;
    public Image barricada4, barricada3, barricada2, barricada1;
    public Image tiroAlien, tiroCanhao;
    public AudioClip gerudoValley;
    public Font joystix;
    
    public Assets(Handler handler){
        handler.setAssets(this);
        
        teste = new Image("/res/teste.png", 64, 64, false, false);
        background = new Image("/res/background.png", 1200, 675, false, false);
        titleScreen = new Image("/res/titleScreen.png", 1200, 675, false, false);
        spaceship = new Image("/res/spaceship.png", CANHAO_WIDTH, CANHAO_HEIGHT, false, false);
        alien1 = new Image("/res/alien1.png", ALIEN_NORMAL_WIDTH, ALIEN_NORMAL_HEIGHT, false, false);
        alien2 = new Image("/res/alien2.png", ALIEN_NORMAL_WIDTH, ALIEN_NORMAL_HEIGHT, false, false);
        alien3 = new Image("/res/alien3.png", ALIEN_NORMAL_WIDTH, ALIEN_NORMAL_HEIGHT, false, false);
        alienForte = new Image("/res/alienForte.png", ALIEN_FORTE_WIDTH, ALIEN_FORTE_HEIGHT, false, false);
        barricada4 = new Image("/res/barricada4.png", BARRICADA_WIDTH, BARRICADA_WIDTH, false, false);
        barricada3 = new Image("/res/barricada3.png", BARRICADA_WIDTH, BARRICADA_WIDTH, false, false);
        barricada2 = new Image("/res/barricada2.png", BARRICADA_WIDTH, BARRICADA_WIDTH, false, false);
        barricada1 = new Image("/res/barricada1.png", BARRICADA_WIDTH, BARRICADA_WIDTH, false, false);
        tiroAlien = new Image("/res/tiroAlien.png", TIROALIEN_WIDTH, TIROALIEN_HEIGHT, false, false);
        tiroCanhao = new Image("/res/tiroCanhao.png", TIROCANHAO_WIDTH, TIROCANHAO_HEIGHT, false, false);
        joystix = new Font("/res/joystix.ttf", 40);
        
        gerudoValley = new AudioClip(this.getClass().getResource("gerudoValley.mp3").toExternalForm());
        gerudoValley.play();
        handler.setGerudoValley(gerudoValley);
    }
    
}
