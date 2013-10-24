package eu.kragniz.sudoku;

import eu.kragniz.sudoku.data.Sudoku;
import eu.kragniz.sudoku.data.factory.SudokuFactory;
import eu.kragniz.sudoku.gui.SudokuFrame;
import eu.kragniz.sudoku.io.SudokuFile;
import eu.kragniz.sudoku.solver.SudokuSolver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SudokuFile file = new SudokuFile("data/book56.sud");
        try {
            file.read();
            Sudoku sudoku = SudokuFactory.getSudoku(file.getArray());

            SudokuSolver.solve(sudoku);

            SudokuFrame frame = new SudokuFrame(sudoku);
            frame.setVisible(true);

        } catch (IOException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
    }
}
