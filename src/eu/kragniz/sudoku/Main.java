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
        SudokuFile file = new SudokuFile("data/book55.sud");
        try {
            file.read();
            Sudoku s = SudokuFactory.getSudoku(file.getArray());
            System.out.print(s.toString());
        } catch (IOException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
        System.out.println("end of program");
    }
}
