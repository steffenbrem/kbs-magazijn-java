package bpp;

import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

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
    private String algorithm;
    private static SimpleGreedy sg = new SimpleGreedy();
    private static CompleteEnumeration cE = new CompleteEnumeration();
    private static BestFit BF = new BestFit();
    private boolean ceB, sgB, bfB;
    private MySQLbpp bpp = new MySQLbpp();
    private int idorder;
    DefaultTableModel model;

//    private int sizet;
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
            System.out.println("WARNING: There are too many boxes");
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
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bPPSimulatorBoxPanel2 = new bpp.BPPSimulatorBoxPanel();
        jLabel2 = new javax.swing.JLabel();
        algorithmLabel = new javax.swing.JLabel();
        algorithmPicker = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        packingData = new javax.swing.JTextArea();
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

        algorithmPicker.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select algorithm", "Complete Enumeration", "Simple Greedy", "Best Fit" }));
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
                "Name", "Nr.", "Size", "Box"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productTable);

        packingData.setEditable(false);
        packingData.setColumns(20);
        packingData.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        packingData.setRows(5);
        packingData.setText("Packing width:\nPacking height:\nArea covered:");
        jScrollPane2.setViewportView(packingData);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 22, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
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
                .addComponent(algorithmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(algorithmPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        
        if (ap.getSelectedItem() == "Select algorithm") {
            System.out.println("Please select an algorithm");
            ceB = false;
            sgB = false;
            bfB = false;
        }
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
            if(ceB || sgB || bfB) {
            bpp.DeleteBox();
            bpp.DeleteProducts();
            bpp.newProducts(3, 10);

            idorder = 10;

            bpp.Products(depository);
            }
            tableReset();
            SetTable();
            if (ceB) {
                System.out.println("\nComplete Enumeration\n");
                cE.setBoxDepository(boxd);
                cE.setDepository(depository);
                cE.setBoxes(10);
                cE.runCe(10);
            } else if (sgB) {
                System.out.println("\nSimple Greedy\n");
                sg.setBoxDepository(boxd);
                sg.setDepository(depository);
                sg.runSg(10);
            } else if (bfB) {
                System.out.println("\nBest Fit\n");
                BF.setBoxDepository(boxd);
                BF.setDepository(depository);
                BF.BF(10);
            }

            tableReset();
            bpp.DeleteProducts();
            bpp.newProducts(3, 10);
            bpp.Products(depository);
            SetTable();
        }
    }//GEN-LAST:event_startButtonActionPerformed

    // de tabel tonen met de producten die op de band liggen.
    public void SetTable() {
        model = (DefaultTableModel) productTable.getModel();
        sizet = producten.size();
        model.setRowCount(0);

        for (int i = 0; sizet > i; i++) {

            String data1 = this.producten.get(i).Getname();
            int data2 = this.producten.get(i).GetidProduct();
            int data3 = this.producten.get(i).Getsize();
            int data4 = this.producten.get(i).GetBox();

            if (data4 == 0) {

                model.addRow(new Object[]{data1, data2, data3, data4});
            }

        }
    }

    public void tableReset() {
        model.setRowCount(0);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BoxTable;
    private javax.swing.JPanel Boxa;
    private javax.swing.JPanel Boxb;
    private javax.swing.JPanel Boxc;
    private javax.swing.JLabel algorithmLabel;
    public javax.swing.JComboBox algorithmPicker;
    private bpp.BPPSimulatorBoxPanel bPPSimulatorBoxPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea packingData;
    private javax.swing.JTable productTable;
    public javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
        MySQLbpp bpp = new MySQLbpp();
        Depository d = new Depository();
        BoxDepository b = new BoxDepository();
        BPPSimulatorGUI GUI = new BPPSimulatorGUI();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Long time;

        GUI.setBoxDepository(b);
        GUI.setDepository(d);
        bpp.Box(b);
        bpp.Products(d);
        GUI.SetTable();

        GUI.setVisible(true);

        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
