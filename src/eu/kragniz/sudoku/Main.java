package eu.kragniz.sudoku;

import eu.kragniz.sudoku.data.Sudoku;
import eu.kragniz.sudoku.data.factory.SudokuFactory;
import eu.kragniz.sudoku.gui.SudokuFrame;
import eu.kragniz.sudoku.io.SudokuFile;
import eu.kragniz.sudoku.solver.HiddenSingles;
import eu.kragniz.sudoku.solver.Preprocessor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SudokuFile file = new SudokuFile("data/book55.sud");
        try {
            file.read();
            Sudoku s = SudokuFactory.getSudoku(file.getArray());
            System.out.print(s.toString());

            Preprocessor p = new Preprocessor(s);
            while (p.activatable()) {
                p.run();
            }

            HiddenSingles h = new HiddenSingles(s);
            while (h.activatable()) {
                h.run();
            }

            SudokuFrame frame = new SudokuFrame(s);
            frame.setVisible(true);

            System.out.print(s.toString());
        } catch (IOException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
        System.out.println("end of program");
    }
}
