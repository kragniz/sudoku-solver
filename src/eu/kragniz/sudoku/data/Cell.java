package eu.kragniz.sudoku.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public class Cell {
    private int digit;
    private Set<Integer> possible;

    public Cell(int initialValue) {
        digit = initialValue;
        possible = new HashSet<Integer>();

        for (int i = 1; i <= 9; i++) {
            possible.add(i);
        }
    }

    public Cell() {
        this(0);
    }

    public int getDigit() {
        return digit;
    }

    public void removePossibleValue(int value) {
        possible.remove(value);
        updateDigit();
    }

    public void removeAllPossibleValues(HashSet values) {
        possible.removeAll(values);
        updateDigit();
    }

    public void updateDigit() {
        if (possible.size() == 1 && digit == 0) {
            digit = possible.iterator().next();
        }
    }

    public static HashSet cellArrayToIntSet(List<Cell> list) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (Cell cell : list) {
            set.add(cell.getDigit());
        }
        return set;
    }

    public static void removeValues(List<Cell> cells, HashSet<Integer> values) {
        for (int y = 0; y < cells.size(); y++) {
            for (Cell cell : cells) {
                cell.removeAllPossibleValues(values);
            }
        }
    }

    public String toString() {
        return String.valueOf(digit);
    }
}
