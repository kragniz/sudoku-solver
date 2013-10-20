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
    private HashSet<Integer> possible;

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

    public boolean removePossibleValue(int value) {
        possible.remove(value);
        return updateDigit();
    }

    public boolean removeAllPossibleValues(HashSet values) {
        possible.removeAll(values);
        return updateDigit();
    }

    public boolean setPossibleValue(int value) {
        if (possible.contains(value)) {
            possible.clear();
            possible.add(value);
        }
        return updateDigit();
    }

    public HashSet<Integer> getPossibleValues() {
        return possible;
    }

    public boolean updateDigit() {
        if (possible.size() == 1 && digit == 0) {
            digit = possible.iterator().next();
            return true;
        }
        return false;
    }

    public static HashSet<Integer> cellArrayToIntSet(List<Cell> list) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (Cell cell : list) {
            set.add(cell.getDigit());
        }
        return set;
    }

    public static boolean removeValues(List<Cell> cells, HashSet<Integer> values) {
        boolean updated = false;
        for (int y = 0; y < cells.size(); y++) {
            for (Cell cell : cells) {
                updated = updated || cell.removeAllPossibleValues(values);
            }
        }
        return updated;
    }

    public String toString() {
        return String.valueOf(digit);
    }
}
