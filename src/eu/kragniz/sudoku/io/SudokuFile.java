package eu.kragniz.sudoku.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */

public class SudokuFile {
    private int[][] grid;
    private String filename;

    public SudokuFile(String filename) {
        this.filename = filename;
        grid = new int[9][9];
    }

    public int[][] getArray() {
        return null;
    }

    public void read() throws IOException {
        int x = 0;
        int y = 0;

        InputStream in = new FileInputStream(filename);
        Reader reader = new InputStreamReader(in, Charset.defaultCharset());
        int code;
        while (((code = reader.read()) != -1) && x <= 9 && y <= 9) {
            char symbol = (char) code;
            System.out.println(symbol);
            if (symbol == '\n') {
                System.out.println("newline");
                y = y + 1;
                x = 0;
            } else {
                if (x < 9 && y < 9) {
                    grid[x][y] = symbol;
                    x = x + 1;
                }
            }
        }
    }
}
