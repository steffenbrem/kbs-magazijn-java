package bpp;

import java.util.ArrayList;

public class SimpleGreedy extends MySQLbpp {

    private Depository depository;
    private BoxDepository boxd;
    private ArrayList<Product> products;
    private ArrayList<Box> arrayBox;
    private MySQLbpp bpp = new MySQLbpp();

    public SimpleGreedy() {
    }

    public void setBoxDepository(BoxDepository b) {
        boxd = b;
        arrayBox = boxd.getList();
        int a = arrayBox.size();
        if (a > 2) {
            System.out.println("There are too many boxes");
        }

    }

    public void setDepository(Depository b) {
        this.depository = b;
        products = depository.getList();
    }

    public Depository getDepository() {
        return this.depository;
    }

    public void runSg(int idorder) {
        int i = 0;
        int boxnr;
        Box b;
        boxnr = bpp.NewBox(20, idorder);

        Box box = new Box(boxnr, 20, 0, idorder, "busy");
        //int idBox, int size, int covered, int idorder, String status
        arrayBox.add(box);

        //Alle producten bij langsgaan
        while (i < products.size()) {
            int j = 0;
            Product product = products.get(i);
            if (product.GetBox() == 0) {

                String ready = "no";

                while ("no".equals(ready)) {
                    b = arrayBox.get(j);
                    int covered = b.getCovered();

                    if (((20 - covered) >= (product.Getsize())) && (b.getStatus() == "busy")) {
                        System.out.println("The product fits in box " + b.getIdBox());

                        updateBox(b.getCovered() + product.Getsize(), false, b.getIdBox());
                        SetBox(b.getIdBox(), products.get(i).GetidProduct());

                        products.get(i).SetBox(b.getIdBox());
                        b.setCovered(b.getCovered() + product.Getsize());

                        System.out.println("Product " + product.Getname() + " added to box " + b.getIdBox() + ".");

                        ready = "Yes";
                    } else {
                        if (covered == 20) {
                            b = arrayBox.get(j);
                            boxnr = b.getIdBox();
                            bpp.closeBox(boxnr);
                            b.setStatus("ready");
                        }
                        if (j + 1 < arrayBox.size()) {
                            j = j + 1;
                        } else {
                            System.out.println("A new box was created");
                            boxnr = bpp.NewBox(20, idorder);
                            b = new Box(boxnr, 20, 0, idorder, "busy");
                            arrayBox.add(b);
                            System.out.println("The product fits in " + b.getIdBox());

                            updateBox(b.getCovered() + product.Getsize(), false, b.getIdBox());
                            SetBox(b.getIdBox(), products.get(i).GetidProduct());

                            products.get(i).SetBox(b.getIdBox());
                            b.setCovered(b.getCovered() + product.Getsize());

                            System.out.println("Product " + product.Getname() + " added to box " + b.getIdBox() + ".");
                            ready = "Yes";
                        }
                    }
                }
            }
            i++;
        }

        int h = 0;
        while (arrayBox.size() > h) {
            b = arrayBox.get(h);
            boxnr = b.getIdBox();
            bpp.closeBox(boxnr);
            h++;
        }

    }
}
