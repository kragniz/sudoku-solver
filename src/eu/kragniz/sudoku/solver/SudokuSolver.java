package eu.kragniz.sudoku.solver;

import eu.kragniz.sudoku.data.Sudoku;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */
public class SudokuSolver {
    public static Sudoku solve(Sudoku sudoku) {
        SolverStrategy[] strategies = new SolverStrategy[]{
                new Preprocessor(sudoku),
                new HiddenSingles(sudoku)
        };

        String lastSudoku = sudoku.toString();
        boolean done = false;
        while (!done) {
            lastSudoku = sudoku.toString();
            for (SolverStrategy strategy : strategies) {
                while (strategy.activatable()) {
                    strategy.run();
                }
                strategy.setActive();
            }
            done = lastSudoku.equals(sudoku.toString());
        }
        return sudoku;
    }
}
