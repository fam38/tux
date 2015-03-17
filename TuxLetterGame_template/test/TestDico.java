
import management.Dico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stevensm
 */
public class TestDico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Dico dico;
       dico = new Dico();
       
       dico.addWordToDico(1,"chien");
       dico.addWordToDico(2,"manger");
       dico.addWordToDico(3,"canette");
       dico.addWordToDico(1,"patte");
       dico.addWordToDico(2,"thon");
       dico.addWordToDico(5,"micro onde");
       dico.addWordToDico(5,"velociraptor");
       dico.addWordToDico(4,"hiene");
       
       System.out.println(dico.getWordFromListLevel(1));
       System.out.println(dico.getWordFromListLevel(1));
       System.out.println(dico.getWordFromListLevel(5));
       System.out.println(dico.getWordFromListLevel(2));
       System.out.println(dico.getWordFromListLevel(4));
       
    }
    
}
