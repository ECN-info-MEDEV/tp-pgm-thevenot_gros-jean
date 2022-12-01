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
    
    public static Image lire(String chemin) {
        
        try
      {
      // Le fichier d'entrée
      File file = new File(chemin);    
      // Créer l'objet File Reader
      FileReader fr = new FileReader(file);  
      // Créer l'objet BufferedReader        
      BufferedReader br = new BufferedReader(fr);  
      StringBuffer sb = new StringBuffer();    
      String line;
      while((line = br.readLine()) != null)
      {
        // ajoute la ligne au buffer
        sb.append(line);      
        sb.append("\n");     
      }
      fr.close();    
      System.out.println(sb.toString());  
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
