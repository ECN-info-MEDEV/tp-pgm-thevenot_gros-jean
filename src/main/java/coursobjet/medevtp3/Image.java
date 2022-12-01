/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursobjet.medevtp3;
import java.io.*;


/**
 * Structure de donnée pour les images pgm
 * @author vince
 */
public class Image {
    
    /**
     * Commentaire dans le fichier PGM
     */
    public String commentaire;
    
    /**
     * largeur de l'immage (en pixels)
     */
    public int largeur;
    
    /**
     * hauteur de l'immage (en pixels)
     */
    public int hauteur;
    
    /**
     * valeur des pixels sous forme de tableau 2D
     */
    public int[][] pixels;

    /**
     * constructeur par défaut d'une image
     */
    public Image() {
        this.commentaire = new String();
        this.largeur = 0;
        this.hauteur = 0;
        this.pixels = new int[this.largeur][this.hauteur];
    }

    /**
     * constructeur ou on donne une matrice
     * @param pixels 
     */
    public Image(int[][] pixels) {
        this.commentaire = "";
        this.largeur = pixels.length;
        this.hauteur = pixels[0].length;
        this.pixels = new int[this.largeur][this.hauteur];
        for (int i=0; i<this.largeur; i++ ){
            System.arraycopy(pixels[i], 0, this.pixels[i], 0, this.hauteur);
        }  
    }
    
    //TODO méthode de lecture d'une image à partir d'un fichier
    
    public static Image lire(String chemin) { //FIXME IL FAUT FAIRE L'IO SAUVEZ MOI
        
        try
      {
      // Le fichier d'entrée
      File file = new File(chemin);    
      java.util.Scanner lecteur;
      lecteur = new java.util.Scanner(file);
      
      while (lecteur.hasNextInt()) System.out.println(lecteur.nextInt());
	 
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
        
        int[][] pixels = new int[1][1]; //TODO lire largeur et hauteur pour construire ici
        
        //TODO construire la matrice
        
        Image image = new Image(pixels);
        return image;
    }
    
    //TODO méthode pour écrire un fichier
}