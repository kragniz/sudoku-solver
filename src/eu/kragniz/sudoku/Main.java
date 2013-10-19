package eu.kragniz.sudoku;

import eu.kragniz.sudoku.data.factory.SudokuFactory;
import eu.kragniz.sudoku.data.Sudoku;
import eu.kragniz.sudoku.io.SudokuFile;
import eu.kragniz.sudoku.solver.Preprocessor;

import java.io.IOException;

public class Main {
    // TODO build plugin system
    // each solver type in its own class
    // build some sort of regex for sudoku puzzles

    public static void main(String[] args) {
        SudokuFile file = new SudokuFile("data/book55.sud");
        try {
            file.read();
            Sudoku s = SudokuFactory.getSudoku(file.getArray());
            System.out.print(s.toString());
            Preprocessor p = new Preprocessor(s);
            s = p.solve();
        } catch (IOException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
        System.out.println("end of program");
    }
}
