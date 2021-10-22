/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.handler;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import gfx.assets.Assets;
import entidades.Canhao;
import entidades.arrays.ArrayAlien;
import entidades.arrays.ArrayAlienForte;
import entidades.arrays.ArrayBarricadas;
import entidades.arrays.MatrizAlienNormal;
import entidades.arrays.MatrizTiroAlien;
import engine.gameeevent.GameOver;
import engine.gameeevent.YouWin;
import gfx.hud.DisplayVidas;
import gfx.hud.Musica;
import gfx.hud.Score;
import gfx.hud.TitleScreen;
import engine.input.Keyboard;

/**
 *  Handler
 * 
 * O handler é uma classe dedicada para passar informações para classe
 * Por exemplo, quando um Alien é morto, a Classe TiroCanhao passa, utilizando o handler,
 * para a classe Score que a pontuação deve ser aumentada em tanto
 * 
 * Por isso, a classe handler é composta praticamente apenas de setters e getters
 * 
 * @author Igor
 */
public class Handler {
    
    private StackPane root;
    private GraphicsContext gc;
    private Scene scene;
    
    private Assets assets;
    private Keyboard keyboard;
    private GameOver gameOver;
    private YouWin youWin;
    private DisplayVidas displayVidas;
    private Score score;
    private TitleScreen titleScreen;

    private Musica musica;

    private AudioClip gerudoValley;

    private int speedInc = 0;

    private Canhao canhao;
    private ArrayBarricadas arrayBarricadas;
    private MatrizAlienNormal matrizAlienNormal;
    private ArrayAlien arrayAlien;
    private ArrayAlienForte arrayAlienForte;
    private MatrizTiroAlien matrizTiroAlien;

    public Handler(StackPane root, GraphicsContext gc, Scene scene){
        this.scene = scene;
        this.root = root;
        this.gc = gc;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    public StackPane getRoot() {
        return root;
    }

    public void setRoot(StackPane root) {
        this.root = root;
    }
    
    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }
    
    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Canhao getCanhao() {
        return canhao;
    }

    public void setCanhao(Canhao canhao) {
        this.canhao = canhao;
    }
    
    public ArrayBarricadas getArrayBarricadas() {
        return arrayBarricadas;
    }

    public void setArrayBarricadas(ArrayBarricadas arrayBarricadas) {
        this.arrayBarricadas = arrayBarricadas;
    }

    public MatrizAlienNormal getMatrizAlienNormal() {
        return matrizAlienNormal;
    }

    public void setMatrizAlienNormal(MatrizAlienNormal matrizAlienNormal) {
        this.matrizAlienNormal = matrizAlienNormal;
    }

    public ArrayAlien getArrayAlien() {
        return arrayAlien;
    }

    public void setArrayAlien(ArrayAlien arrayAlien) {
        this.arrayAlien = arrayAlien;
    }
    
    public ArrayAlienForte getArrayAlienForte() {
        return arrayAlienForte;
    }

    public void setArrayAlienForte(ArrayAlienForte arrayAlienForte) {
        this.arrayAlienForte = arrayAlienForte;
    }
    
    public MatrizTiroAlien getMatrizTiroAlien() {
        return matrizTiroAlien;
    }

    public void setMatrizTiroAlien(MatrizTiroAlien matrizTiroAlien) {
        this.matrizTiroAlien = matrizTiroAlien;
    }

    public GameOver getGameOver() {
        return gameOver;
    }

    public void setGameOver(GameOver gameOver) {
        this.gameOver = gameOver;
    }
    
    public YouWin getYouWin() {
        return youWin;
    }

    public void setYouWin(YouWin youWin) {
        this.youWin = youWin;
    }
    
    public int getSpeedInc() {
        return speedInc;
    }

    public void setSpeedInc(int speedInc) {
        this.speedInc = speedInc;
    }
    
    public DisplayVidas getDisplayVidas() {
        return displayVidas;
    }

    public void setDisplayVidas(DisplayVidas displayVidas) {
        this.displayVidas = displayVidas;
    }
    
    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
    
    public AudioClip getGerudoValley() {
        return gerudoValley;
    }

    public void setGerudoValley(AudioClip gerudoValley) {
        this.gerudoValley = gerudoValley;
    }
    
    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }
    
    public TitleScreen getTitleScreen() {
        return titleScreen;
    }

    public void setTitleScreen(TitleScreen titleScreen) {
        this.titleScreen = titleScreen;
    }
}
