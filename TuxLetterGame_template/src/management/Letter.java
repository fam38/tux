/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import env3d.EnvObject;

/**
 *
 * @author stevensm
 */
public class Letter extends EnvObject {

    private char letter;

    public Letter(char l, double x, double z) {
        letter = l;
        if (x < 3) {
            x = 3;
        }
        if (x > 37) {
            x = 37;
        }
        if (z > 47) {
            z = 47;
        }
        if (z < 3) {
            z = 3;
        }

        setX(x);
        setY(5);
        setZ(z);
        setScale(2);
        if (l == 32) {
            setTexture("models/letter/cube.png");
        } else {
            setTexture("models/letter/" + l + ".png");
        }

    }

    public char getLetter() {
        return letter;
    }

}
