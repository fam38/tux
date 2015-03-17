/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import env3d.Env;
import game.Room;
import game.Tux;
import java.util.ArrayList;

/**
 *
 * @author stevensm
 */
public class DevineLeMot {

    private Env env;
    private Tux tux;
    private ArrayList<Letter> letters;
    private int nbLettresRestantes;
    private int temps;
    private Room room;
    private Chronometre chrono;

    public DevineLeMot(String mot, Env env, Room room) {
        Letter l;
        this.env = env;
        this.room = room;
        tux = new Tux(12, 5, 12);
        chrono = new Chronometre(60);
        nbLettresRestantes = mot.length();
        letters = new ArrayList<Letter>();
        
        for (int i = 0; i < mot.length(); i++) {
            l = new Letter(mot.charAt(i), (int) (Math.random() * room.getDepth()), (int) (Math.random() * room.getWidth()));
            letters.add(l);
        }

        // Sets up the camera
        env.setCameraXYZ(20, 30, 75);
        env.setCameraPitch(-30);
        // Turn off the default controls
        env.setDefaultControl(false);
    }

    public void checkUserKey() {
        tux.move(env.getKey());
    }

    private double distance(Tux tux, Letter letter) {
        return tux.distance(letter);
    }

    private boolean collision(Tux tux, Letter letter) {
        boolean b = false;
        if (distance(tux, letter) <= 3) {
            b = true;
        }
        return b;
    }

    private boolean tuxMeetsLetter() {
        return (collision(tux, letters.get(0)));
    }

    public void jouer() {
// Insert Tux
        env.addObject(tux);
// Add the letters
        for (int i = 0; i < letters.size(); i++) {
            env.addObject(letters.get(i));
        }
// Start chrono
        long c;
        chrono.start();
// The main game loop

        do {
            // Ask for user input, check if it collides and remove letters if necessary
            checkUserKey();
            if (tuxMeetsLetter()) {
                env.removeObject(letters.get(0));
                System.out.println(letters.get(0).getLetter());
                letters.remove(0);

            }
            // Update display
            c = chrono.getSeconds();
            env.advanceOneFrame();
        } while (!letters.isEmpty() && c <= chrono.getLimite());
        //Post-Process: game is finished
        chrono.stop();

        //we have to keep the data to save our score (chrono, temps, nbLettresRestantes) 
        nbLettresRestantes = letters.size();
        temps = chrono.remainsTime();
    }

}
