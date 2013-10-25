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
            if (!cells.get(i).hasValue()) {
                ArrayList<Cell> otherCells = new ArrayList<Cell>(cells);
                otherCells.remove(i);

                HashSet<Integer> arraySet = Cell.sumCellArrayPossibleValues(otherCells);
                HashSet<Integer> cellSet = cells.get(i).getPossibleValues();
                HashSet<Integer> diff = new HashSet<Integer>();

                diff.addAll(cellSet);
                diff.removeAll(arraySet);

                if (diff.size() == 1) {
                    if (!cells.get(i).hasValue()) {
                        cells.get(i).setPossibleValue(diff.iterator().next());
                        valuesChanged = true;
                    }
                }
            }
        }
        return valuesChanged;
    }

    public void run() {
        setInactive();
        for (int x = 0; x < 9; x++) {
            List<Cell> column = sudoku.getColumn(x);
            addActive(findCandidate(column));
        }

        for (int y = 0; y < 9; y++) {
            List<Cell> row = sudoku.getRow(y);
            addActive(findCandidate(row));
        }

        for (int n = 0; n < 9; n++) {
            List<Cell> box = sudoku.getBox(n);
            addActive(findCandidate(box));
        }
    }
}
