/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursobjet.medevtp3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nicol
 */
public class ImageTest {
    
    private double[][] floatImage;

    private int height;
    private int width;
    
    public ImageTest(){
        
    }
    
    public void readImage(double[][] arrImage, int largeur, int hauteur){
        this.height = hauteur;
        this.width = largeur;
        
        floatImage = new double[width][height];
        
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                floatImage[i][j] = (float) (((float) arrImage[i][j])/255.0);
            }
        }
    }
    
    public void printImage(){
        final BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D)img.getGraphics();
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                float c = (float) floatImage[i][j];
                g.setColor(new Color(c, c, c));
                g.fillRect(i, j, 1, 1);
            }
        }

        JFrame frame = new JFrame("Image test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.clearRect(0, 0, getWidth(), getHeight());
                g2d.setRenderingHint(
                        RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                        // Or _BICUBIC
                g2d.scale(2, 2);
                g2d.drawImage(img, 0, 0, this);
            }
        };
        panel.setPreferredSize(new Dimension(width*2, height*2));
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        int width = 100;
        int height = 100;
        
        double[][] imgTemp = new double[width][height];
        Random r = new Random();
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                imgTemp[i][j] = r.nextDouble()*255;
            }
        }
        
        ImageTest objIm = new ImageTest();
        
        objIm.readImage(imgTemp, width, height);
        
        objIm.printImage();
        
    }
}
