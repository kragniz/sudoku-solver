package eu.kragniz.sudoku.solver;

import eu.kragniz.sudoku.data.Sudoku;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public class NakedPairs extends SolverStrategy {

    public NakedPairs(Sudoku sudoku) {
        super(sudoku);
    }

    public void run() {
        setInactive();
    }

}
