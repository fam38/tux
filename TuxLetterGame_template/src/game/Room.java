/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

/**
 *
 * @author stevensm
 */
public class Room {
    private int depth;
    private int height;
    private int width;
    String textureBottom;
    String textureNorth;
    String textureEast;
    String textureWest;
    String textureSouth;
    String textureTop;
    
    public Room(){
    depth = 50;
    height = 50;
    width = 40;
    textureBottom = "textures/mud.png";
    textureNorth = "textures/top.png";
    textureEast = "textures/fire.png";
    textureWest = "textures/explode.png";
    }
    public int getDepth()
    {
        return depth;
    }
    public int getHeight()
    {
        return height;
    }
        public int getWidth()
    {
        return width;
    }
}
