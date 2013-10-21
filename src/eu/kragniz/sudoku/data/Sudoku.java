package eu.kragniz.sudoku.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public class Sudoku {
    private Cell[][] grid;

    public Sudoku() {
        grid = new Cell[9][9];
    }

    public boolean solved() {
        for(Cell[] columns: grid) {
            for (Cell cell: columns) {
                if (cell.getDigit() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public Cell cell(int x, int y) {
        return grid[x][y];
    }

    public void setCell(int x, int y, Cell cell) {
        grid[x][y] = cell;
    }

    public List<Cell> getRow(int y) {
        List<Cell> row = new ArrayList<Cell>();
        for (int i = 0; i < 9; i++) {
            row.add(grid[i][y]);
        }
        return row;
    }

    public List<Cell> getColumn(int x) {
        List<Cell> column = new ArrayList<Cell>();
        for (int i = 0; i < 9; i++) {
            column.add(grid[x][i]);
        }
        return column;
    }

    public List<Cell> getBox(int x, int y) {
        List<Cell> box = new ArrayList<Cell>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                box.add(grid[j + (x * 3)][i + (y * 3)]);
            }
        }
        return box;
    }

    public List<Cell> getBox(int n) {
        return getBox(n % 3, n / 3);
    }

    public HashSet getRowSet(int y) {
        return Cell.cellArrayToIntSet(getRow(y));
    }

    public HashSet getColumnSet(int x) {
        return Cell.cellArrayToIntSet(getColumn(x));
    }

    public HashSet getBoxSet(int x, int y) {
        return Cell.cellArrayToIntSet(getBox(x, y));
    }

    public HashSet getBoxSet(int n) {
        return getBoxSet(n % 3, n / 3);
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("\n-------------------------\n");
        for (int i = 0; i < 9; i++) {
            buf.append("| ");
            for (int j = 0; j < 9; j++) {
                buf.append(grid[j][i].getDigit());
                buf.append(" ");
                if (((j + 1) % 3) == 0) {
                    buf.append("| ");
                }
            }

            if (((i + 1) % 3) == 0) {
                buf.append("\n-------------------------\n");
            } else {
                buf.append('\n');
            }
        }
        return buf.toString();
    }
}
