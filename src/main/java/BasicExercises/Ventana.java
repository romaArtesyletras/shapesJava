package BasicExercises;

import java.awt.Color;

import javax.swing.JFrame;

/**
 *
 * @author PC1-17
 */
public class Ventana {
    public static void main(String[] args){
        JFrame ventana = new JFrame("Lineas - Circulares - Mariquita");
        Panel codigo = new Panel();

        ventana.add(codigo);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setBackground(Color.white);
        ventana.setSize(400, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setResizable(false);
    } 
}
