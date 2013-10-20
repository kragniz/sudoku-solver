package eu.kragniz.sudoku.solver;

import eu.kragniz.sudoku.data.Cell;
import eu.kragniz.sudoku.data.Sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public class HiddenSingles extends SolverStrategy {

    public HiddenSingles(Sudoku sudoku) {
        super(sudoku);
    }

    private boolean findCandidate(List<Cell> cells) {
        boolean valuesChanged = false;
        for (int i = 0; i < cells.size(); i++) {
            if (cells.get(i).getDigit() == 0) {
                ArrayList<Cell> otherCells = new ArrayList<Cell>(cells);
                otherCells.remove(i);

                HashSet<Integer> boxSet = Cell.cellArrayToIntSet(otherCells);
                HashSet<Integer> cellSet = cells.get(i).getPossibleValues();
                HashSet<Integer> diff = new HashSet<Integer>();

                diff.addAll(boxSet);
                diff.addAll(cellSet);
                diff.removeAll(boxSet);

                if (diff.size() == 1) {
                    cells.get(i).setPossibleValue(diff.iterator().next());
                    valuesChanged = true;
                }
            }
        }
        return valuesChanged;
    }

    public Sudoku run() {
        active = false;

        for (int x = 0; x < 9; x++) {
            List<Cell> column = sudoku.getColumn(x);
            active = active || findCandidate(column);
        }

        for (int y = 0; y < 9; y++) {
            List<Cell> row = sudoku.getRow(y);
            active = active || findCandidate(row);
        }

        for (int n = 0; n < 9; n++) {
            List<Cell> box = sudoku.getBox(n);
            active = active || findCandidate(box);
        }
        return sudoku;
    }
}
