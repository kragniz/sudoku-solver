package eu.kragniz.sudoku.solver;

import eu.kragniz.sudoku.data.Sudoku;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public abstract class SolverStrategy {
    Sudoku sudoku;
    boolean active;

    public abstract void update();

    public void run() {
        sudoku.resetUpdates();
        update();
        active = sudoku.isUpdated();
    };

    public boolean activatable() {
        return active;
    }

    public void setActive() {
        active = true;
    }

    public SolverStrategy(Sudoku sudoku) {
        this.sudoku = sudoku;
        this.active = true;
    }
}
