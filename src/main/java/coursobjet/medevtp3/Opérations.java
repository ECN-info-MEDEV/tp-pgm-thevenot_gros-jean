/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursobjet.medevtp3;

/**
 * Classe de méthodes statiques effectuant les opérations demandées
 * 
 * @author Nicol
 */
public class Opérations {
    /**
     * créé une image de taille doublée
     * @param reference image à agrandir
     * @param facteur facteur
     * @return
     */
    public static Image agrandir(Image reference, float facteur) {
        Image im = new Image(reference);
        im.hauteur = (int) (reference.hauteur * facteur);
        im.largeur = (int) (reference.largeur * facteur);
        int[][] newpixels = new int[im.largeur][im.hauteur];
        for (int i=0; i<im.largeur; i++ ){
            for (int j=0; j<im.hauteur; j++) {
                int iRef = (int) (i/facteur);
                int jRef = (int) (j/facteur);
                
                newpixels[i][j] = reference.pixels[iRef][jRef];
                
            }
        } 
        im.pixels = newpixels;
        return im;
    }
    
    
    
    /**
     * Seuille l'image
     * Ma valeur indiquée définit le seuil entre noir et blanc
     * @param reference image à seuiller
     * @param valeurSeuil Valeur seuil
     * @return
     */
    public static Image seuil(Image reference, int valeurSeuil) {
        Image im = new Image(reference);
        
        if (valeurSeuil > 255 || valeurSeuil < 0){
            System.out.println("LA valeur seuil n'est pas bonne");
            return im;
        }
        
        int[][] newpixels = new int[im.largeur][im.hauteur];
        for (int i=0; i<reference.largeur; i++ ){
            for (int j=0; j<reference.hauteur; j++) {
                int valeurPixel = reference.pixels[i][j];
                
                if (valeurPixel > valeurSeuil){
                    newpixels[i][j] = 255;
                } else {
                    newpixels[i][j] = 0;
                }
            }
        } 
        im.pixels = newpixels;
        return im;
    }
    
    
    /**
     * Opération de diff entre deux images
     * @param reference image à diff
     * @param imageDiff image àa diff
     * @return
     */
    public static Image diff(Image reference, Image imageDiff) {
        Image im = new Image(reference);
        
        int[][] newpixels = new int[im.largeur][im.hauteur];
        for (int i=0; i<reference.largeur; i++ ){
            for (int j=0; j<reference.hauteur; j++) {
                int valeurPixel = reference.pixels[i][j];
                int valeurPixel2 = imageDiff.pixels[i][j];
                
                newpixels[i][j] = valeurPixel2 - valeurPixel;
            }
        } 
        im.pixels = newpixels;
        return im;
    }
}
