/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author yasin.hussein
 */
public class Main {
    public static void main(String[] args) {
        // Call the static setupGame method to create a Game object
        Game game = GameSetup.setupGame();

        // Start the game
        game.start();
    }
    }

