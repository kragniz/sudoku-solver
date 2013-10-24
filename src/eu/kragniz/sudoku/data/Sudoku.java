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

    private List<Cell>[] rows;
    private List<Cell>[] columns;
    private List<Cell>[] boxes;
    private List<Cell>[] groups;

    public Sudoku() {
        grid = new Cell[9][9];
    }

    public void populateGroups() {
        rows = new List[9];
        for (int y = 0; y < 9; y++) {
            rows[y] = getRow(y, true);
        }

        columns = new List[9];
        for (int x = 0; x < 9; x++) {
            columns[x] = getColumn(x, true);
        }

        boxes = new List[9];
        for (int n = 0; n < 9; n++) {
            boxes[n] = getBox(n, true);
        }

        groups = new List[27];
        int i = 0;
        for (List<Cell> group: rows) {
            groups[i] = group;
            i++;
        }

        for (List<Cell> group: columns) {
            groups[i] = group;
            i++;
        }

        for (List<Cell> group: boxes) {
            groups[i] = group;
            i++;
        }
    }

    public boolean solved() {
        for (Cell[] columns : grid) {
            for (Cell cell : columns) {
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

    public List<Cell> getRow(int y, boolean cached) {
        List<Cell> row = new ArrayList<Cell>();
        for (int i = 0; i < 9; i++) {
            row.add(grid[i][y]);
        }
        return row;
    }

    public List<Cell> getRow(int y) {
        return rows[y];
    }

    public List<Cell> getColumn(int x, boolean cached) {
        List<Cell> column = new ArrayList<Cell>();
        for (int i = 0; i < 9; i++) {
            column.add(grid[x][i]);
        }
        return column;
    }

    public List<Cell> getColumn(int x) {
        return columns[x];
    }

    public List<Cell> getBox(int x, int y, boolean cached) {
        List<Cell> box = new ArrayList<Cell>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                box.add(grid[j + (x * 3)][i + (y * 3)]);
            }
        }
        return box;
    }

    public List<Cell> getBox(int x, int y) {
        return boxes[x+(y*3)];
    }

    public List<Cell> getBox(int n) {
        return getBox(n % 3, n / 3);
    }

    public List<Cell> getBox(int n, boolean cached) {
        return getBox(n % 3, n / 3, cached);
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

    public List[] getGroups() {
        return groups;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                buf.append(grid[j][i].getDigit());
            }
            buf.append('\n');
        }
        return buf.toString();
    }

    public boolean equals(Sudoku other) {
        return this.toString().equals(other.toString());
    }
}
