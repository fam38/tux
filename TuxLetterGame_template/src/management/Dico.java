package management;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Classe SIMPLIFIEE permettant de lire un dictionnaire de Tuxamots Cette classe
 * est un handler permettant le parse SAX
 *
 * @author Johan
 */
public class Dico extends DefaultHandler {

    // ce qui permet de lire et stocké le contenu xml
    private StringBuffer buffer;
    private int currentWordLevel;
    private ArrayList<String> listLevel1;
    private ArrayList<String> listLevel2;
    private ArrayList<String> listLevel3;
    private ArrayList<String> listLevel4;
    private ArrayList<String> listLevel5;

    private String pathToDicoFile;
    
    
    public String getWordFromListLevel(int level) {
       int randomNum;
        
        String World;
        switch (level) {
            case 1:
                randomNum = 0 + (int) (Math.random() * listLevel1.size());
                World = listLevel1.get(randomNum);
                break;
            case 2:
                randomNum = 0 + (int) (Math.random() * listLevel2.size());
                World = listLevel2.get(randomNum);
                break;
            case 3:
                randomNum = 0 + (int) (Math.random() * listLevel3.size());
                World = listLevel3.get(randomNum);
                break;
            case 4:
                randomNum = 0 + (int) (Math.random() * listLevel4.size());
                World = listLevel4.get(randomNum);
                break;
            case 5:
                randomNum = 0 + (int) (Math.random() * listLevel5.size());
                World = listLevel5.get(randomNum);
                break;
            default:
                World = " ";
                break;
                }
        return World;
    }

    public Dico() {
        super();
        this.pathToDicoFile = pathToDicoFile;
        listLevel1 = new ArrayList<String>();
        listLevel2 = new ArrayList<String>();
        listLevel3 = new ArrayList<String>();
        listLevel4 = new ArrayList<String>();
        listLevel5 = new ArrayList<String>();
    }

    public void readDictionnary(String link) {
        pathToDicoFile = link;

        try {
            // création d'une fabrique de parseurs SAX
            SAXParserFactory fabrique = SAXParserFactory.newInstance();

            // création d'un parseur SAX
            SAXParser parseur = fabrique.newSAXParser();

            // lecture d'un fichier XML avec un DefaultHandler
            File fichier = new File(pathToDicoFile);
            parseur.parse(fichier, this);

        } catch (ParserConfigurationException pce) {
            System.out.println("Erreur de configuration du parseur");
            System.out.println("Lors de l'appel à newSAXParser()");
        } catch (SAXException se) {
            System.out.println("Erreur de parsing");
            System.out.println("Lors de l'appel à parse()");
        } catch (IOException ioe) {
            System.out.println("Erreur d'entrée/sortie");
            System.out.println("Lors de l'appel à parse()");
        }
    }

    public boolean addWordToDico(int level, String word) {
        switch (level) {
            case 1:
                listLevel1.add(word);
                break;
            case 2:
                listLevel2.add(word);
                break;
            case 3:
                listLevel3.add(word);
                break;
            case 4:
                listLevel4.add(word);
                break;
            case 5:
                listLevel5.add(word);
                break;
            default:
                return false;
        }
        return true;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equals("dico")) {
            //rien à faire
        } else if (qName.equals("mot")) {
	    //crée un buffer
            buffer = new StringBuffer();

	    //Récupération d'un attribut
            int index = attributes.getIndex("1");
            //check l'attribut
            if (index != -1) {
		//Transforme le String en int. (Google est mon ami)
                currentWordLevel = Integer.parseInt(attributes.getValue(index));
            } else {
                //pas de level -> erreur XML
                System.out.println("Erreur dans le XML; le mot est rejeté !");
            }
        } else {
            //erreur, on peut lever une exception
            throw new SAXException("Balise " + qName + " inconnue.");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        if (qName.equals("dico")) {
            //rien à faire
        } else if (qName.equals("mot")) {
	    //on ajoute le mot au dico.
            addWordToDico(currentWordLevel, buffer.toString());
            //on  nettoie le buffer
            buffer = null;
        } else {
            //erreur, on peut lever une exception
            throw new SAXException("Balise " + qName + " inconnue.");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

	//on récupère le résultat du parse de la méthode characters si celui-ci n'est pas null.
        String lecture = new String(ch, start, length);
        if (buffer != null) {
            buffer.append(lecture);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Début du parsing");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin du parsing");
    }
    
    
    //getters and setters
    public String getPathToDicoFile() {
        return this.pathToDicoFile;
    }

    public ArrayList<String> getListLevel1() {
        return listLevel1;
    }

    public ArrayList<String> getListLevel2() {
        return listLevel2;
    }

    public ArrayList<String> getListLevel3() {
        return listLevel3;
    }

    public ArrayList<String> getListLevel4() {
        return listLevel4;
    }

    public ArrayList<String> getListLevel5() {
        return listLevel5;
    }
}
