/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hugo
 */
public class BPPSimulatorGUI extends javax.swing.JFrame {

    private Depository depository;
    private BoxDepository boxd;
    private ArrayList<Product> producten;
    private ArrayList<Box> arrayBox;
    private String StringBox;
    private Box bBox;
    private int sizet;
    private int boxnr;
    private int bnr;
    private int idorder = 10;
    private String algorithm;
    private SimpleGreedy1 sg = new SimpleGreedy1();
//    private NewSimpleGreedy nsg = new NewSimpleGreedy();
    private CompleteEnumeration cE = new CompleteEnumeration(idorder);
    private BestFit BF = new BestFit();
    private boolean ceB, sgB, bfB;
//    private int sizet;
    private Object dateFormat;
    private String sql;
    MySQLbpp bpp = new MySQLbpp();

    /**
     * Creates new form BPPSimulatorGUI
     */
    public BPPSimulatorGUI() {
        initComponents();

    }

    public void setBoxDepository(BoxDepository b) {
        boxd = b;
        arrayBox = boxd.getList();
        int a = arrayBox.size();
        if (a > 2) {
            System.out.println("Let op er zijn te veel dozen!!");
        }

    }

    public void setDepository(Depository b) {
        this.depository = b;
        producten = depository.getList();
    }

    public Depository getDepository() {
        return this.depository;
    }

    public void setProducten(ArrayList<Product> p) {
        this.producten = p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    /**
     * This method is called from within the constructor to initialize the form.WARNING: Do NOT modify this code. The content of this method is always
 regenerated by the Form Editor.
     * @param g
     */
    public void paintComponent(Graphics g) {
        

    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bPPSimulatorBoxPanel2 = new bpp.BPPSimulatorBoxPanel();
        jLabel2 = new javax.swing.JLabel();
        algorithmLabel = new javax.swing.JLabel();
        algorithmPicker = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        progressLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        packingData = new javax.swing.JTextArea();
        stopButton = new javax.swing.JButton();
        Boxa = new javax.swing.JPanel();
        Boxb = new javax.swing.JPanel();
        Boxc = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        BoxTable = new javax.swing.JTable();
        startButton = new javax.swing.JButton();

        javax.swing.GroupLayout bPPSimulatorBoxPanel2Layout = new javax.swing.GroupLayout(bPPSimulatorBoxPanel2);
        bPPSimulatorBoxPanel2.setLayout(bPPSimulatorBoxPanel2Layout);
        bPPSimulatorBoxPanel2Layout.setHorizontalGroup(
            bPPSimulatorBoxPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );
        bPPSimulatorBoxPanel2Layout.setVerticalGroup(
            bPPSimulatorBoxPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jLabel2.setText("Box A");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BPP-simulator");
        setResizable(false);

        algorithmLabel.setText("Algorithms");

        algorithmPicker.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Complete Enumeration", "Simple Greedy", "Best Fit" }));
        algorithmPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                algorithmPickerActionPerformed(evt);
            }
        });

        productTable.setAutoCreateRowSorter(true);
        productTable.setFont(new java.awt.Font("Calibri", 0, 12));
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Nr.", "Size", "Check", "Box"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productTable);

        progressLabel.setText("Progress");

        packingData.setEditable(false);
        packingData.setColumns(20);
        packingData.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        packingData.setRows(5);
        packingData.setText("Packing width:\nPacking height:\nArea covered:");
        jScrollPane2.setViewportView(packingData);

        stopButton.setBackground(new java.awt.Color(204, 0, 0));
        stopButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        stopButton.setForeground(new java.awt.Color(255, 255, 255));
        stopButton.setText("STOP");

        Boxa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Boxa.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Boxa(evt);
            }
        });

        javax.swing.GroupLayout BoxaLayout = new javax.swing.GroupLayout(Boxa);
        Boxa.setLayout(BoxaLayout);
        BoxaLayout.setHorizontalGroup(
            BoxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        BoxaLayout.setVerticalGroup(
            BoxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Boxb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Boxb.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Boxb(evt);
            }
        });

        javax.swing.GroupLayout BoxbLayout = new javax.swing.GroupLayout(Boxb);
        Boxb.setLayout(BoxbLayout);
        BoxbLayout.setHorizontalGroup(
            BoxbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        BoxbLayout.setVerticalGroup(
            BoxbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Boxc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Boxc.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BoxC(evt);
            }
        });

        javax.swing.GroupLayout BoxcLayout = new javax.swing.GroupLayout(Boxc);
        Boxc.setLayout(BoxcLayout);
        BoxcLayout.setHorizontalGroup(
            BoxcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        BoxcLayout.setVerticalGroup(
            BoxcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("Box A");

        jLabel3.setText("Box B");

        jLabel4.setText("Box C");

        BoxTable.setAutoCreateRowSorter(true);
        BoxTable.setFont(new java.awt.Font("Calibri", 0, 12));
        BoxTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Nr.", "Size"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(BoxTable);

        startButton.setBackground(new java.awt.Color(0, 204, 0));
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(algorithmLabel)
                            .addComponent(algorithmPicker, 0, 239, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(progressLabel)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(0, 10, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(Boxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(Boxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(Boxc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel1)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel3)
                        .addGap(112, 112, 112)
                        .addComponent(jLabel4)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(algorithmLabel)
                    .addComponent(progressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(algorithmPicker))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Boxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boxc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void algorithmPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_algorithmPickerActionPerformed
        // kiezen alogrimte 
        ceB = true;
        JComboBox ap = (JComboBox) evt.getSource();
        System.out.println(ap.getSelectedItem());
        if (ap.getSelectedItem() == "Complete Enumeration") {
            ceB = true;
            sgB = false;
            bfB = false;
        } else if (ap.getSelectedItem() == "Simple Greedy") {
            sgB = true;
            ceB = false;
            bfB = false;
        } else if (ap.getSelectedItem() == "Best Fit") {
            bfB = true;
            ceB = false;
            sgB = false;

        }


    }//GEN-LAST:event_algorithmPickerActionPerformed

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved

    }//GEN-LAST:event_jPanel2MouseMoved

    private void jPanel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseMoved

    }//GEN-LAST:event_jPanel3MouseMoved

    private void jPanel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseMoved

    }//GEN-LAST:event_jPanel7MouseMoved

    private void Boxa(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Boxa
        try {
            bBox = arrayBox.get(0);
            StringBox = bBox.toString();
            packingData.setText(StringBox);

        } catch (Exception e) {
            packingData.setText("Box is empty");
        }
        try {
            bBox = arrayBox.get(0);
            // tabel invullen
            bnr = bBox.getIdBox();
            SetTableBox(bnr);
        } catch (Exception e) {
            packingData.setText("Box is empty");
        }
    }//GEN-LAST:event_Boxa

    private void Boxb(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Boxb
        try {
            bBox = arrayBox.get(1);
            StringBox = bBox.toString();
            packingData.setText(StringBox);

        } catch (Exception e) {
            packingData.setText("Box is empty");
        }
        try {
            bBox = arrayBox.get(1);
            // tabel invullen
            bnr = bBox.getIdBox();
            SetTableBox(bnr);
        } catch (Exception e) {
            packingData.setText("Box is empty");
        }
    }//GEN-LAST:event_Boxb

    private void BoxC(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoxC
        try {
            bBox = arrayBox.get(2);
            StringBox = bBox.toString();
            packingData.setText(StringBox);

        } catch (Exception e) {
            packingData.setText("Box is empty");
        }
        try {
            bBox = arrayBox.get(2);
            // tabel invullen
            bnr = bBox.getIdBox();
            SetTableBox(bnr);
        } catch (Exception e) {
            packingData.setText("Box is empty");
        }
    }//GEN-LAST:event_BoxC

    private void BoxaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoxaMouseClicked

    }//GEN-LAST:event_BoxaMouseClicked

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        if (evt.getSource() == startButton) {

            String algoritme = "";
            System.out.println(ceB);
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date_start;
            Date date_stop;
            Long time;

            Depository d = new Depository();
            BoxDepository b = new BoxDepository();

            if(ceB){
            algoritme = "Complete Enumeration";


            d = new Depository();
            b = new BoxDepository();
            setBoxDepository(b);
            setDepository(d);
            bpp.Box(b);
            bpp.Products(d);

            System.out.println(algoritme);
            cE.setDepository(d);
            
            cE.setBoxDepository(b);
            date_start = new Date();
            cE.setBoxes(idorder);
            cE.runCe(idorder);
            date_stop = new Date();
            time = date_stop.getTime() - date_start.getTime();
//                System.out.println(dateFormat.format(date_stop)); // 15:59:48
            time = date_stop.getTime() - date_start.getTime();
            bpp.updateResult(time, b.GetSizeArraylist(), d.GetSizeArraylist(), d.GetTotalSizeOrder(), b.GettotalSize(), algoritme);

            SetTable();
            }
            
            if (sgB){
            algoritme = "Simple Greedy";


//                 bpp.SetNewProductsDB(sql);
            d = new Depository();
            b = new BoxDepository();
            setBoxDepository(b);
            setDepository(d);
            bpp.Box(b);
            bpp.Products(d);

            System.out.println(algoritme);
            sg.setBoxDepository(b);
            sg.setDepository(d);
//                sg.setBoxes(10);
            date_start = new Date();
            sg.runSg(10);
            date_stop = new Date();
            time = date_stop.getTime() - date_start.getTime();
            bpp.updateResult(time, b.GetSizeArraylist(), d.GetSizeArraylist(), d.GetTotalSizeOrder(), b.GettotalSize(), algoritme);
            SetTable();
            }
            if(bfB){
            algoritme = "Best Fit";


            d = new Depository();
            b = new BoxDepository();
            setBoxDepository(b);
            setDepository(d);
            bpp.Box(b);
            bpp.Products(d);

            System.out.println(algoritme);
            BF.setBoxDepository(b);
            BF.setDepository(d);
            date_start = new Date();
            BF.BF(10);
            date_stop = new Date();
            time = date_stop.getTime() - date_start.getTime();
//                System.out.println(dateFormat.format(date_stop)); // 15:59:48
            time = date_stop.getTime() - date_start.getTime();
            bpp.updateResult(time, b.GetSizeArraylist(), d.GetSizeArraylist(), d.GetTotalSizeOrder(), b.GettotalSize(), algoritme);

            SetTable();
            }

                // resultaat opslaan 
//                bpp.updateResult(time, boxd.GetSizeArraylist(), depository.GetSizeArraylist(), depository.GetTotalSizeOrder(), boxd.GettotalSize(), algoritme);
//                System.out.println("tijd :"+ time);
//                System.out.println("aantal producten "+ d.GetSizeArraylist()+ " totale groote " + d.GetSizeOrder());
//                System.out.println("aantal boxen " + b.GetSizeArraylist() + " totale volume boxen " + b.GettotalSize());
//            SetTable();
        }
    }//GEN-LAST:event_startButtonActionPerformed

    // de tabel tonen met de producten die op de band liggen.
    public void SetTable() {
        sizet = producten.size();

        for (int i = 0; sizet > i; i++) {

//            if (this.producten.get(i).){
            String data1 = this.producten.get(i).Getname();
            int data2 = this.producten.get(i).GetidProduct();
            int data3 = this.producten.get(i).Getsize();
            boolean data4 = this.producten.get(i).Getcheck();
            int data5 = this.producten.get(i).GetBox();

            DefaultTableModel model = new DefaultTableModel();
            model.addRow(new Object[]{data1, data2, data3, data4, data5});
//            }
        }
    }

    // de tabel tonen met de producten die in een box zitten. 
    public void SetTableBox(int box) {
        sizet = producten.size();

        DefaultTableModel model = (DefaultTableModel) BoxTable.getModel();
        model.setRowCount(0);

        for (int i = 0; sizet > i; i++) {
            boxnr = this.producten.get(i).GetBox();

            if (boxnr == box) {

                String data1 = this.producten.get(i).Getname();
                int data2 = this.producten.get(i).GetidProduct();
                int data3 = this.producten.get(i).Getsize();

                model.addRow(new Object[]{data1, data2, data3});
            }
        }
    }

    public String getAlgorith() {
        return algorithm;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BoxTable;
    private javax.swing.JPanel Boxa;
    private javax.swing.JPanel Boxb;
    private javax.swing.JPanel Boxc;
    private javax.swing.JLabel algorithmLabel;
    private javax.swing.JComboBox algorithmPicker;
    private bpp.BPPSimulatorBoxPanel bPPSimulatorBoxPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea packingData;
    private javax.swing.JTable productTable;
    private javax.swing.JLabel progressLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}
