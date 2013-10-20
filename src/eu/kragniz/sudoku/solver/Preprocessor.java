package eu.kragniz.sudoku.solver;

import eu.kragniz.sudoku.data.Cell;
import eu.kragniz.sudoku.data.Sudoku;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public class Preprocessor extends SolverStrategy {

    public Preprocessor(Sudoku sudoku) {
        super(sudoku);
    }

    public Sudoku run() {
        active = false;

        for (int x = 0; x < 9; x++) {
            active = active || Cell.removeValues(sudoku.getColumn(x), sudoku.getColumnSet(x));
        }

        for (int y = 0; y < 9; y++) {
            active = active || Cell.removeValues(sudoku.getRow(y), sudoku.getRowSet(y));
        }

        for (int n = 0; n < 9; n++) {
            active = active || Cell.removeValues(sudoku.getBox(n), sudoku.getBoxSet(n));
        }
        return sudoku;
    }
}
