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
                
                String algoritme = "Complete Enumeration";
                MySQLbpp bpp = new MySQLbpp();                
                Depository d = new Depository();
                BoxDepository b = new BoxDepository();
                
                
                
                BPPSimulatorGUI GUI = new BPPSimulatorGUI();
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Long time;
                int idorder = 10;
                bpp.DeleteProductsAndBoxes();
                bpp.SetNewProductsDB(5,idorder);
                
                GUI.setBoxDepository(b);
                GUI.setDepository(d);
                GUI.setVisible(true);
                GUI.SetTable();
                
                bpp.Box(b);
                bpp.Products(d);
                
                Date date_start = new Date();
                System.out.println(dateFormat.format(date_start)); // 15:59:48
                
                if (algoritme == "Simple Greedy"){

                System.out.println("SimpleGreedy");
                SimpleGreedy sg = new SimpleGreedy();
                sg.setBoxDepository(b);
                sg.setDepository(d);
//                sg.setBoxes();
                sg.runSg(idorder);
                }
                else if(algoritme == "Best Fit"){
                System.out.println("Best Fit");
                
                BestFit BF = new BestFit();
                BF.setBoxDepository(b);
                BF.setDepository(d);
                BF.BF(10);
                }
                else if(algoritme == "Complete Enumeration"){
                
                System.out.println("Complete Enumeration");
                CompleteEnumeration cE = new CompleteEnumeration(idorder);
                cE.setBoxDepository(b);
                cE.setDepository(d);
                cE.setBoxes();
                cE.runCe();
                }
                
                Date date_stop = new Date();
                System.out.println(dateFormat.format(date_stop)); // 15:59:48
                time = date_stop.getTime() - date_start.getTime();
                time = time/1000;
                
                
                GUI.SetTable();
                

                // resultaat opslaan 
                
                bpp.updateResult(time, b.GetSizeArraylist(), d.GetSizeArraylist(), d.GetTotalSizeOrder(), b.GettotalSize(), algoritme);
//                System.out.println("tijd :"+ time);
//                System.out.println("aantal producten "+ d.GetSizeArraylist()+ " totale groote " + d.GetSizeOrder());
//                System.out.println("aantal boxen " + b.GetSizeArraylist() + " totale volume boxen " + b.GettotalSize());
//                GUI.setVisible(true);
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                

            }
        });

    }
}