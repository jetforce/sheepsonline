
package gui;

import java.util.ArrayList;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;
import model.Sheep;

public class GUI extends javax.swing.JFrame {
    
    public GUI() {
        initComponents();
        
        columns = 30;
        rows = 30;
        grid = new JLabel[rows][columns];
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                //grid[i][j] = new JLabel("x");
                grid[i][j] = new JLabel();
                grid[i][j].setHorizontalAlignment(CENTER);
                grid[i][j].setVerticalAlignment(CENTER);
                panelMain.add(grid[i][j]);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sheeps");
        setBounds(new java.awt.Rectangle(0, 0, 600, 500));

        panelMain.setLayout(new java.awt.GridLayout(30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void update(ArrayList<Sheep> sheeps){
        
        for(int i = 0; i < rows * columns; i++){
            grid[i/rows][i%columns].setText("");
        }
        
        for(Sheep sheep : sheeps){
            grid[sheep.getX()][sheep.getY()].setText(String.valueOf(sheep.getId()));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelMain;
    // End of variables declaration//GEN-END:variables
    private JLabel grid[][];
    private int columns;
    private int rows;
    private ArrayList<Sheep> currentSheeps;

    public javax.swing.JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(javax.swing.JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public JLabel[][] getGrid() {
        return grid;
    }

    public void setGrid(JLabel[][] grid) {
        this.grid = grid;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
