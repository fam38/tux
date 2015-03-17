/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author stevensm
 */
public class Profile {

    private String nom;
    private String dateNaissance;
    private int avatar;
    private ArrayList<Partie> parties;

    public Profile(String nom, String dateNaissance, int avatar) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.avatar = avatar;
    }

    public Profile(String filename) {

        try {
            // analyse du document
            parties = new ArrayList<Partie>();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder p = dbFactory.newDocumentBuilder();
            // récupération de la structure objet du document
            Document doc = p.parse(filename);

            this.nom = doc.getElementsByTagName("name").item(0).getTextContent();
            this.dateNaissance = doc.getElementsByTagName("birthday").item(0).getTextContent();

            NodeList game = doc.getElementsByTagName("games").item(0).getChildNodes();

            for (int i = 0; i < game.getLength(); i++) {
                parties.add(new Partie((Element) game.item(i)));
            }

        } catch (Exception e) {
        }

    }

}
