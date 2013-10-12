package eu.kragniz.sudoku.io;

import java.io.File;
import java.util.Scanner;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public class SudokuFile {
    private int[][] grid;
    private String filename;

    public SudokuFile(String filename) {
        this.filename = filename;
    }

    public int[][] getArray() {
        return null;
    }

    public void read() {
        int x = 0;
        int y = 0;

        File file = new File(filename);
        if (file.exists()) {
            Scanner s;
            s = new Scanner(filename);
        }
    }
}
