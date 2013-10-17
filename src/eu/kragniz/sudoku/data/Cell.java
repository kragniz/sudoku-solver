package eu.kragniz.sudoku.data;

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
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }

    public void addPossibleValue(int value) {
        possible.add(value);
    }
}
