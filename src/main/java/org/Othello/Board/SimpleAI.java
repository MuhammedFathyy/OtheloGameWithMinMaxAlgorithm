/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Othello.Board;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Collections;

public class SimpleAI {
    private GameGrid gameGrid;

    public SimpleAI(GameGrid gameGrid) {
        this.gameGrid = gameGrid;
    }

    public Position chooseMove() {
        Collections.shuffle(this.gameGrid.getAllValidMoves());
        return (Position)this.gameGrid.getAllValidMoves().get(0);
    }
}
