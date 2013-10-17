package eu.kragniz.sudoku.data.factory;

import eu.kragniz.sudoku.data.Sudoku;
import eu.kragniz.sudoku.data.Cell;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public class SudokuFactory {
    public static Sudoku getSudoku(int[][] sudokuFile) {
        Sudoku sudoku = new Sudoku();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                Cell cell = new Cell(sudokuFile[x][y]);
                sudoku.setCell(x, y, cell);
            }
        }
        return sudoku;
    }
}
