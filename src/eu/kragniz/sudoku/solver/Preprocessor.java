package eu.kragniz.sudoku.solver;

import eu.kragniz.sudoku.data.Sudoku;

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

    Sudoku solve() {

    }
}
