/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import management.LectureClavier;
import env3d.Env;
import management.DevineLeMot;
import management.Dico;

/**
 *
 * @author stevensm
 */
public class Jeu {

    private Tux tux;
    private Env env;
    private int level;
    private Dico dico;
    private boolean finished;
    private Room room;

    public Jeu() {
        // Create the new environment.  Must be done in the same
        // method as the game loop

        level = 0;
        dico = new Dico();

        dico.addWordToDico(1, "chien");
        dico.addWordToDico(2, "manger");
        dico.addWordToDico(3, "canette");
        dico.addWordToDico(1, "patte");
        dico.addWordToDico(2, "thon");
        dico.addWordToDico(5, "micro onde");
        dico.addWordToDico(5, "velociraptor");
        dico.addWordToDico(4, "hiene");

//initialize
        finished = false;
    }

    public void jouer() {
        finished = true;
        String mot;
        String c;
        do {

            level = LectureClavier.lireEntier("entrez un level : ");
            if (env == null) {
                env = new Env();
            } else {
                env.restart();
            }
            // Instanciate a room 
            room = new Room();
            env.setRoom(room);

            mot = dico.getWordFromListLevel(level);
            DevineLeMot partie;
            partie = new DevineLeMot(mot, env, room);
            partie.jouer();
            do {
                c = LectureClavier.lireChaine("Voulez vous rejouer (y ou n) :");
            } while (!"y".equals(c) && !"n".equals(c));
            finished = !"y".equals(c);

        } while (!finished);
        // Update display
        env.advanceOneFrame();

        // Just a little clean up
        env.exit();
    }

}
