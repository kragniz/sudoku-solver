package eu.kragniz.sudoku.data;

import eu.kragniz.sudoku.data.Cell;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public class Sudoku {
    private Cell[][] grid;

    public Sudoku() {
        grid = new Cell[9][9];
    }

    public Cell cell(int x, int y) {
        return grid[x][y];
    }

    public void setCell(int x, int y, Cell cell) {
        grid[x][y] = cell;
    }
}
