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
        SudokuFile file = new SudokuFile("data/book55.sud");
        try {
            file.read();
            Sudoku s = SudokuFactory.getSudoku(file.getArray());

            SolverStrategy[] strategies = new SolverStrategy[] {
                    new Preprocessor(s),
                    new HiddenSingles(s)
            };

            while (!s.solved()) {
                for (SolverStrategy strategy: strategies) {
                    while (strategy.activatable()) {
                        strategy.run();
                    }
                    strategy.setActive();
                }
            }

            SudokuFrame frame = new SudokuFrame(s);
            frame.setVisible(true);
        } catch (IOException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
        System.out.println("end of program");
    }
}
