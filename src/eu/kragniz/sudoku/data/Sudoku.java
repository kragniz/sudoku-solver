package eu.kragniz.sudoku.data;

import eu.kragniz.sudoku.data.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

//TODO return a set for each row, column and section
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

    // TODO the same for columns
    public List<Cell> getRow(int y) {
        List<Cell> row = new ArrayList<Cell>();
        for (int i = 0; i < 9; i++) {
            row.add(grid[i][y]);
        }
        return row;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("\n-------------------------\n");
        for (int i = 0; i < 9; i++) {
            buf.append("| ");
            for (int j = 0; j < 9; j++) {
                buf.append(grid[j][i].getDigit());
                buf.append(" ");
                if (((j+1) % 3) == 0) {
                    buf.append("| ");
                }
            }

            if (((i+1) % 3) == 0) {
                buf.append("\n-------------------------\n");
            } else {
            buf.append('\n');
            }
        }
        return buf.toString();
    }
}
