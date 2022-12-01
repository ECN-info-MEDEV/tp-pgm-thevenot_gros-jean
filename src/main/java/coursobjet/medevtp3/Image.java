/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursobjet.medevtp3;
import java.io.*;
import java.util.StringTokenizer;


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
    
    /**
     * Constructeur de copie
     * @param im image à copier
     */
    public Image(Image im) {
        this.commentaire = im.commentaire;
        this.largeur = im.largeur;
        this.hauteur = im.hauteur;
        this.pixels = new int[im.largeur][im.hauteur];
        for (int i=0; i<this.largeur; i++ ){
            System.arraycopy(im.pixels[i], 0, this.pixels[i], 0, this.hauteur);
        } 
    }
    
    //TODO méthode de lecture d'une image à partir d'un fichier
    
    public static Image lire(String chemin) { //FIXME IL FAUT FAIRE L'IO SAUVEZ MOI
        
        int l = 0 ; //largeur
        int h = 0; //hauteur
        int compteur = 0;
        int compteurLigne = 0;
        String ligne;
        String com = "";
        try {
            BufferedReader fichier = new BufferedReader(new FileReader(chemin));
            
            ligne = fichier.readLine(); //ligne P2, osef
            ligne = fichier.readLine(); //ligne du commentaire
            com = ligne; //on garde le # par fleme
            ligne = fichier.readLine(); //ligne des tailles
            StringTokenizer st = new StringTokenizer(ligne);
            l = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int[][] pixels = new int[l][h];
               
            ligne = fichier.readLine(); //ligne 255, osef
            ligne = fichier.readLine(); //première ligne des valeurs des pixels
            compteur = 0;
            compteurLigne = 0;
            while (ligne != null) {
                st = new StringTokenizer(ligne);
                while (st.hasMoreTokens()) {
                    pixels[compteurLigne][compteur] = Integer.parseInt(st.nextToken());
                    compteur += 1;
                }
                ligne = fichier.readLine();
                compteurLigne += 1;
            }
            
            fichier.close(); 
        }
        catch(IOException e) {
        e.printStackTrace();
        }
        Image image = new Image(pixels); //FIXME au secours
        image.commentaire = com;
        return image;
    }
    
    //TODO méthode pour écrire un fichier
    
    /**
     * créé une image de taille doublée
     * @param reference image à agrandir
     * @return im une autre image qui correspond à la référence avec une taille doublée
     */
    public static Image agrandir(Image reference) {
        Image im = new Image(reference);
        im.hauteur = reference.hauteur * 2;
        im.largeur = reference.largeur * 2;
        int[][] newpixels = new int[im.largeur][im.hauteur];
        for (int i=0; i<reference.largeur; i++ ){
            for (int j=0; j<reference.hauteur; j++) {
                //on lit 4 fois dans l'array jsp si c'est opti
                newpixels[i][j] = reference.pixels[i][j];
                newpixels[i+1][j] = reference.pixels[i][j];
                newpixels[i][j+1] = reference.pixels[i][j];
                newpixels[i+1][j+1] = reference.pixels[i][j];
                
            }
        } 
        im.pixels = newpixels;
        return im;
    }
}
