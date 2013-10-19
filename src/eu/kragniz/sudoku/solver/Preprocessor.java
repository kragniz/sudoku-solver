package eu.kragniz.sudoku.solver;

import eu.kragniz.sudoku.data.Cell;
import eu.kragniz.sudoku.data.Sudoku;

import java.util.HashSet;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public class Preprocessor extends Solver {

    public Preprocessor(Sudoku sudoku) {
        super(sudoku);
    }

    boolean activatable() {
        return true;
    }

    public Sudoku solve() {
        for (int y = 0; y < 9; y++) {
            HashSet<Integer> values = sudoku.getRowSet(y);
            for (Cell cell : sudoku.getRow(y)) {
                cell.removeAllPossibleValues(values);
            }
        }

        for (int x = 0; x < 9; x++) {
            HashSet<Integer> values = sudoku.getColumnSet(x);
            for (Cell cell : sudoku.getColumn(x)) {
                cell.removeAllPossibleValues(values);
            }
        }
        return sudoku;
    }
}
