package tsp;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GDrawGrid extends JPanel {
	
	  private int columnCount;
      private int rowCount;
      private List<Rectangle> cells;
      private Point selectedCell;
      
      public void reDraw(int columnCount, int rowCount){
    	  this.columnCount = columnCount;
    	  this.rowCount = rowCount;
          cells = new ArrayList<>(columnCount * rowCount);
          MouseAdapter mouseHandler;
          mouseHandler = new MouseAdapter() {
              @Override
              public void mouseMoved(MouseEvent e) {
                  Point point = e.getPoint();

                  int width = getWidth();
                  int height = getHeight();

                  int cellWidth = width / columnCount;
                  int cellHeight = height / rowCount;

                  int column = e.getX() / cellWidth;
                  int row = e.getY() / cellHeight;

                  selectedCell = new Point(column, row);
                  repaint();

              }
          };
          
          addMouseMotionListener(mouseHandler);
      }

      public GDrawGrid(int columnCount, int rowCount) {
    	  this.columnCount = columnCount;
    	  this.rowCount = rowCount;
          cells = new ArrayList<>(columnCount * rowCount);
          MouseAdapter mouseHandler;
          mouseHandler = new MouseAdapter() {
              @Override
              public void mouseMoved(MouseEvent e) {
                  Point point = e.getPoint();

                  int width = getWidth();
                  int height = getHeight();

                  int cellWidth = width / columnCount;
                  int cellHeight = height / rowCount;

                  int column = e.getX() / cellWidth;
                  int row = e.getY() / cellHeight;

                  selectedCell = new Point(column, row);
                  repaint();

              }
          };
          addMouseMotionListener(mouseHandler);
      }

      @Override
      public Dimension getPreferredSize() {
          return new Dimension(520, 520);
      }

      @Override
      public void invalidate() {
          cells.clear();
          selectedCell = null;
          super.invalidate();
      }

      @Override
      protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          Graphics2D g2d = (Graphics2D) g.create();

          int width = getWidth();
          int height = getHeight();

          int cellWidth = width / columnCount;
          int cellHeight = height / rowCount;

          int xOffset = (width - (columnCount * cellWidth)) / 2;
          int yOffset = (height - (rowCount * cellHeight)) / 2;

          if (cells.isEmpty()) {
              for (int row = 0; row < rowCount; row++) {
                  for (int col = 0; col < columnCount; col++) {
                      Rectangle cell = new Rectangle(
                              xOffset + (col * cellWidth),
                              yOffset + (row * cellHeight),
                              cellWidth,
                              cellHeight);
                      cells.add(cell);
                  }
              }
          }

          if (selectedCell != null) {

              int index = selectedCell.x + (selectedCell.y * columnCount);
              try {
            	  Rectangle cell = cells.get(index);
            	  g2d.setColor(Color.BLUE);
                  g2d.fill(cell);
              } catch (IndexOutOfBoundsException ex) {
              }
              
              

          }

          g2d.setColor(Color.GRAY);
          for (Rectangle cell : cells) {
              g2d.draw(cell);
          }

          g2d.dispose();
      }
  }
