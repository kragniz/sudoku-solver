package eu.kragniz.sudoku.gui;

import eu.kragniz.sudoku.data.Sudoku;

import javax.swing.*;
import java.awt.*;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public class SudokuPanel extends JPanel {
    public static final int WIDTH = 500;
    public static final int HIGHT = 500;

    private Sudoku sudoku;

    public SudokuPanel(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    public void paint(Graphics g) {
        super.paint(g);
    }
}
