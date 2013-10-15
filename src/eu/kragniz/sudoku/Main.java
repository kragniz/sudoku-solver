package eu.kragniz.sudoku;

import eu.kragniz.sudoku.data.factory.SudokuFactory;
import eu.kragniz.sudoku.data.Sudoku;
import eu.kragniz.sudoku.io.SudokuFile;

import java.io.IOException;

public class Main {

    /* sextuple-linked list
                   previous column
        previous row [cell] next row
                    next column

                    next cell
                    previous cell
     */

    // TODO build plugin system
    // each solver type in its own class
    // build some sort of regex for sudoku puzzles

    public static void main(String[] args) {
        System.out.println("hello there");
        SudokuFile file = new SudokuFile("data/book55.sud");
        try {
            file.read();
            System.out.print(file.toString());
            Sudoku s = SudokuFactory.getSudoku(file.getArray());
        } catch (IOException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
        System.out.println("end of program");
    }
}
