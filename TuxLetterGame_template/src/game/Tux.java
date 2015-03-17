/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import env3d.EnvObject;
import org.lwjgl.input.Keyboard;

/**
 *
 * @author stevensm
 */
public class Tux extends EnvObject{

    public Tux(double x, double y, double z) { 
    //Dans le constructeur
    setX(x);
    setY(y);
    setZ(z);
    setScale(2);
    setTexture("models/tux/tux_angry.png");
    setModel("models/tux/tux.obj");
    }
    public void move(int currentKey){
    if (currentKey == Keyboard.KEY_D) {
       this.setRotateY(90);
       this.setX(this.getX() + 2);
        
    }
    if (currentKey == Keyboard.KEY_Q) {
       this.setRotateY(-90);
       this.setX(this.getX() - 2);
        
    }
    if (currentKey == Keyboard.KEY_Z) {
        this.setRotateY(180);
        this.setZ(this.getZ() - 2);
        
    }
    if (currentKey == Keyboard.KEY_S) {
        this.setRotateY(0);
       this.setZ(this.getZ() + 2);
        
    }
    
    }
}




