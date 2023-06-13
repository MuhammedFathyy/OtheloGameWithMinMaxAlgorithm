package org.Othello.Board;

import java.awt.FlowLayout;

public class OthelloGame extends javax.swing.JFrame {

    private GamePanel gamePanel;

    public OthelloGame(String mode,String difficulty) {
        initComponents();
        gamePanel = new GamePanel(mode,difficulty);
        setLayout(new FlowLayout());
        add(gamePanel);
        pack();
        setVisible(true);



    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

}