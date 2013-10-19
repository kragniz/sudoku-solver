package eu.kragniz.sudoku.data;

import java.util.HashSet;
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

        for (int i=1; i<=9; i++) {
            possible.add(i);
        }
    }

    public Cell() {
        this(0);
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }

    public void removePossibleValue(int value) {
        possible.remove(value);
    }
}
