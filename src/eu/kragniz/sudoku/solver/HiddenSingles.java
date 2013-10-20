package eu.kragniz.sudoku.solver;

import eu.kragniz.sudoku.data.Cell;
import eu.kragniz.sudoku.data.Sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public class HiddenSingles extends SolverStrategy {

    public HiddenSingles(Sudoku sudoku) {
        super(sudoku);
    }

    public Sudoku run() {
        active = false;
        for (int n = 0; n < 9; n++) {
            List<Cell> box = sudoku.getBox(n);
            for (int boxNum = 0; boxNum < box.size(); boxNum++) {
                if (box.get(boxNum).getDigit() == 0) {
                    ArrayList<Cell> otherCells = new ArrayList<Cell>(box);
                    otherCells.remove(boxNum);

                    HashSet<Integer> boxSet = Cell.cellArrayToIntSet(otherCells);
                    HashSet<Integer> cellSet = box.get(boxNum).getPossibleValues();
                    HashSet<Integer> diff = new HashSet<Integer>();

                    diff.addAll(boxSet);
                    diff.addAll(cellSet);
                    diff.removeAll(boxSet);

                    if (diff.size() == 1) {
                        box.get(boxNum).setPossibleValue(diff.iterator().next());
                        System.out.println("set a value!");
                        System.out.println(box.get(boxNum));
                    }
                }
            }
        }
        return sudoku;
    }
}
