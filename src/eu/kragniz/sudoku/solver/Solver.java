package eu.kragniz.sudoku.solver;

import eu.kragniz.sudoku.data.Sudoku;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public abstract class Solver {
    Sudoku sudoku;

    abstract boolean activatable();
    abstract Sudoku solve();

    public Solver(Sudoku sudoku) {
        this.sudoku = sudoku;
    }
}
