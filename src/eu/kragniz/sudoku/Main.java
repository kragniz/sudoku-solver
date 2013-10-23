package eu.kragniz.sudoku;

import eu.kragniz.sudoku.data.Sudoku;
import eu.kragniz.sudoku.data.factory.SudokuFactory;
import eu.kragniz.sudoku.gui.SudokuFrame;
import eu.kragniz.sudoku.io.SudokuFile;
import eu.kragniz.sudoku.solver.HiddenSingles;
import eu.kragniz.sudoku.solver.Preprocessor;
import eu.kragniz.sudoku.solver.SolverStrategy;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SudokuFile file = new SudokuFile("data/book69.sud");
        try {
            file.read();
            Sudoku sudoku = SudokuFactory.getSudoku(file.getArray());

            SolverStrategy[] strategies = new SolverStrategy[] {
                    new Preprocessor(sudoku),
                    new HiddenSingles(sudoku)
            };

            String lastSudoku = sudoku.toString();
            boolean done = false;
            while (!done) {
                lastSudoku = sudoku.toString();
                for (SolverStrategy strategy: strategies) {
                    while (strategy.activatable()) {
                        strategy.run();
                    }
                    strategy.setActive();
                }
                done = lastSudoku.equals(sudoku.toString());
            }

            SudokuFrame frame = new SudokuFrame(sudoku);
            frame.setVisible(true);
        } catch (IOException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
    }
}
