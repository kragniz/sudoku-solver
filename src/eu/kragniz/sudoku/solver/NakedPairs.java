package eu.kragniz.sudoku.solver;

import eu.kragniz.sudoku.data.Cell;
import eu.kragniz.sudoku.data.Sudoku;

import java.util.List;

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
        for (List<Cell> group : sudoku.getGroups()) {
            for (Cell cell : group) {
                if (cell.getPossibleValues().size() == 2) {
                    for (Cell searchCell : group) {
                        if (searchCell.getPossibleValues().size() == 2 && cell != searchCell) {
                            if (searchCell.getPossibleValues().equals(cell.getPossibleValues())) {
                                for (Cell removeCell : group) {
                                    if (removeCell != cell && removeCell != searchCell) {
                                        addActive(removeCell.removeAllPossibleValues(cell.getPossibleValues()));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
