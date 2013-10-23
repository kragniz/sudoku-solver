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

    public void run() {
        setInactive();
        for (int x = 0; x < 9; x++) {
            addActive(Cell.removeValues(sudoku.getColumn(x), sudoku.getColumnSet(x)));
        }

        for (int y = 0; y < 9; y++) {
            addActive(Cell.removeValues(sudoku.getRow(y), sudoku.getRowSet(y)));
        }

        for (int n = 0; n < 9; n++) {
            addActive(Cell.removeValues(sudoku.getBox(n), sudoku.getBoxSet(n)));
        }
    }
}
