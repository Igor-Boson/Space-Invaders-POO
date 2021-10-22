/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;


/**
 *  SpaceInvaders
 * 
 * CONTROLES: A ou seta p/ esquerda: esquerda
 *            D ou seta p/ direita: direita
 *            barra de espaço(pressionar): atirar
 * 
 * O projeto está dividido em vários sub-packages. Uma breve descrição de cada um:
 * 
 * spaceinvaders: Contém a engine do jogo (Game) e o Handler, que é usado em todo o programa
 * 
 * spaceinvaders.display: Responsável pela janela do jogo
 * 
 * spaceinvaders.entidades: Entidades são os objetos do jogo: O canhao, aliens, barricadas e tiros
 * spaceinvaders.entidades.aliens: São os Aliens do jogo
 * spaceinvaders.entidades.arrays: Os arrays de certas entidades. Por exemplo, a MatrizAlien
 * spaceinvaders.entidades.tiros: São os tiros do jogo, o tiro do Canhao e o Tiro do AlienForte
 * 
 * spaceinvaders.gameevent: Possui os eventos GameOver (voce perdeu) e YouWin (voce ganhou)
 * 
 * spaceinvaders.gfx: Package dedicada para lidar com as variáveis gráficas do jogo
 * 
 * spaceinvaders.hud: Informações mostradas na tela do jogo, como a pontuação e vidas restantes
 * 
 * spaceinvaders.input: Parte de input do jogo, como o teclado
 * 
 * spaceinvaders.state: Cuida dos States do jogo, que são o que está acontecendo no programa
 * 
 * O main é responsável apenas por inicializar o jogo (Game)
 * 
 * 
 * @author Igor
 * 27.10.2020
 */
public class Tutorial2D {
    
        public static final int EIXO_X = 800;
        public static final int EIXO_Y = 600;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Game jogo = new Game("help", EIXO_X, EIXO_Y);
        jogo.start();
    }
    
}
