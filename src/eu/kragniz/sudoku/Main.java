package eu.kragniz.sudoku;

import eu.kragniz.sudoku.io.SudokuFile;

public class Main {

    /* sextuple-linked list
                   previous column
        previous row [cell] next row
                    next column

                    next cell
                    previous cell
     */

    public static void main(String[] args) {
        System.out.println("hello there");
        SudokuFile file = new SudokuFile("data/book55.sud");
    }
}
