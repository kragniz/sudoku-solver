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

    private static final int SUDOKU_SIZE = 9;

    public SudokuFile(String filename) {
        this.filename = filename;
        grid = new int[SUDOKU_SIZE][SUDOKU_SIZE];
    }

    public int[][] getArray() {
        return grid;
    }

    public void read() throws IOException {
        int x = 0;
        int y = 0;

        InputStream in = new FileInputStream(filename);
        Reader reader = new InputStreamReader(in, Charset.defaultCharset());
        int code;
        //TODO listen to http://www.youtube.com/watch?v=-uCUgiop1GQ&list=PL1712EC828784E00F
        while (((code = reader.read()) != -1) && x <= 9 && y <= 9) {
            char symbol = (char) code;
            if (symbol == '\n') {
                y = y + 1;
                x = 0;
            } else {
                if (x < 9 && y < 9) {
                    if (symbol == ' ') {
                        grid[x][y] = 0;
                    } else {
                        grid[x][y] = Integer.parseInt(symbol + ""); //TODO convert to int
                    }
                    x = x + 1;
                }
            }
        }
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("\n-------------------------\n");
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            buf.append("| ");
            for (int j = 0; j < SUDOKU_SIZE; j++) {
                buf.append(grid[j][i]);
                buf.append(" ");
                if (((j+1) % 3) == 0) {
                    buf.append("| ");
                }
            }

            if (((i+1) % 3) == 0) {
                buf.append("\n-------------------------\n");
            } else {
            buf.append('\n');
            }
        }
        return buf.toString();
    }
}
