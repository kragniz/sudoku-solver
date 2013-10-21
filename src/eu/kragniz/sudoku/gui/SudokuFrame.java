package eu.kragniz.sudoku.gui;

import eu.kragniz.sudoku.data.Sudoku;

import javax.swing.*;
import java.awt.*;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public class SudokuFrame extends JFrame {
    public SudokuFrame(Sudoku sudoku) throws HeadlessException {
        super("Sudoku solver");
        SudokuPanel panel = new SudokuPanel(sudoku);
        setContentPane(panel);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
