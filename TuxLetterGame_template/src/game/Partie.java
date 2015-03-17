/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author stevensm
 */
public class Partie {

    private String date;
    private String mot;
    private int niveau;
    private int trouve;
    private int temps;

    public Partie(String date, String mot, int level) {
        this.date = date;
        this.mot = mot;
        niveau = level;
    }

    public Partie(Element domPartie) {
        date = domPartie.getAttribute("date");
        mot = domPartie.getChildNodes().item(1).getTextContent();
        niveau = Integer.parseInt(domPartie.getElementsByTagName("word").item(0).getAttributes().toString());

    }
/*
    public Element GetDomElement(Document doc) {
       Element domPartie;
       Element jeu;
       
       
       domPartie = doc.createElement("game");
       domPartie.setAttribute(date, date);
           
       
        
       
        
    }
*/
}
