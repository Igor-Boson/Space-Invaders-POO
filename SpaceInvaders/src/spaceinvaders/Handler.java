/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import spaceinvaders.hud.Score;
import spaceinvaders.entidades.Barricada;
import spaceinvaders.entidades.Canhao;
import spaceinvaders.entidades.aliens.AlienForte;
import spaceinvaders.entidades.arrays.ArrayAlien;
import spaceinvaders.entidades.arrays.MatrizAlien;
import spaceinvaders.entidades.tiro.TiroAlienForte;
import spaceinvaders.gameevent.GameOver;
import spaceinvaders.gameevent.YouWin;
import spaceinvaders.hud.DisplayVidas;

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
    
    private Game game;
    private Score score;
    
    private Canhao canhao;
    private Barricada[] arrayBarricadas;
    private ArrayAlien arrayAliens;
    private MatrizAlien matrizAlien;
    private AlienForte[] arrayAlienForte;
    private TiroAlienForte[][] matrizTiroAlienForte;
    
    private GameOver gameOver;
    private YouWin youWin;
    private DisplayVidas displayVidas;

    public Handler(Game game){
        this.game = game;
    }
    
    public void setScore(Score score){
        this.score = score;
    }
    
    public void setCanhao(Canhao canhao){
        this.canhao = canhao;
    }
    
    public void setArrayBarricadas(Barricada[] arrayBarricadas){
        this.arrayBarricadas = arrayBarricadas;
    }
    
    public void setArrayAliens(ArrayAlien arrayAliens){
        this.arrayAliens = arrayAliens;
    }
    
    public void setMatrizAlien(MatrizAlien matrizAlien){
        this.matrizAlien = matrizAlien;
    }
    
    public void setGameOver(GameOver gameOver) {
        this.gameOver = gameOver;
    }
    
    public void setYouWin(YouWin youWin) {
        this.youWin = youWin;
    }
    
    public Game getGame(){
        return game;
    }
    
    public Score getScore(){
        return score;
    }
    
    public Canhao getCanhao(){
        return canhao;
    }
    
    public Barricada[] getArrayBarricadas(){
        return arrayBarricadas;
    }
    
    public ArrayAlien getArrayAliens(){
        return arrayAliens;
    }
    
    public MatrizAlien getMatrizAlien(){
        return matrizAlien;
    }
    
    public GameOver getGameOver() {
        return gameOver;
    }

        public YouWin getYouWin() {
        return youWin;
    }

    public AlienForte[] getArrayAlienForte() {
        return arrayAlienForte;
    }

    public void setArrayAlienForte(AlienForte[] arrayAlienForte) {
        this.arrayAlienForte = arrayAlienForte;
    }
    
    public TiroAlienForte[][] getMatrizAlienForte() {
        return matrizTiroAlienForte;
    }

    public void setMatrizTiroAlienForte(TiroAlienForte[][] matrizTiroAlienForte) {
        this.matrizTiroAlienForte = matrizTiroAlienForte;
    }
    
    public void setDisplayVidas(DisplayVidas displayVidas){
        this.displayVidas = displayVidas;
    }
    
    public DisplayVidas getDisplayVidas(){
        return displayVidas;
    }
}
