/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

import asrs.MainFrame;
import javax.swing.JFrame;
import bpp.BPPSimulatorGUI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
/**
 *
 * @author Marjolein
 */
public class BPP {
//   private ArrayList<Product> producten;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                MySQLbpp bpp = new MySQLbpp(); 
                bpp.DeleteProductsAndBoxes();
                bpp.newProducts(3, 10);

                int idorder = 10;

                System.out.println("test");
                
                BPPSimulatorGUI GUI = new BPPSimulatorGUI();
                System.out.println("test1");
                
                GUI.setVisible(true);
                System.out.println("test2");
                
                
                
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                

            }
        });

    }
}