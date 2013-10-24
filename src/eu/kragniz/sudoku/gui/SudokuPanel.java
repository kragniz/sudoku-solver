package eu.kragniz.sudoku.gui;

import eu.kragniz.sudoku.data.Cell;
import eu.kragniz.sudoku.data.Sudoku;

import javax.swing.*;
import java.awt.*;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public class SudokuPanel extends JPanel {
    private Sudoku sudoku;
    private static int SUDOKU_SIZE = 9;

    public SudokuPanel(Sudoku sudoku) {
        this.sudoku = sudoku;
        setVisible(true);
        setSize(500, 500);
    }

    private int cellSize() {
        Dimension spaceSize = getSize();
        return Math.min(spaceSize.height / SUDOKU_SIZE, spaceSize.width / SUDOKU_SIZE);
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int cellSize = cellSize();
        int xoffset = (getSize().width - cellSize * SUDOKU_SIZE) / 2;
        int yoffset = (getSize().height - cellSize * SUDOKU_SIZE) / 2;

        Font smallFont = new Font("monospace", Font.PLAIN, cellSize / 7);

        int largeFontSize = cellSize / 3;
        Font largeFont = new Font("monospace", Font.PLAIN, largeFontSize);

        Cell cell;
        int x;
        int y;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cell = sudoku.cell(i, j);

                x = xoffset + (i * cellSize);
                y = yoffset + (j * cellSize);

                if (cell.isSolved()) {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(x, y, cellSize, cellSize);
                }

                if (cell.getDigit() == 0) {
                    g.setFont(smallFont);
                    g.drawString(cell.possibleValueString(), x + 5, y + cellSize - 2);
                }

                g.setColor(Color.GRAY);
                g.drawRect(x, y, cellSize, cellSize);

                g.setColor(Color.BLACK);
                g.setFont(largeFont);
                g.drawString(cell.toString(), x + (cellSize / 2) - largeFontSize / 3, y + (cellSize / 2) + largeFontSize / 3);
            }
        }
    }
}