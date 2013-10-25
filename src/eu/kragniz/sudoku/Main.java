package eu.kragniz.sudoku;

import eu.kragniz.sudoku.data.Sudoku;
import eu.kragniz.sudoku.data.factory.SudokuFactory;
import eu.kragniz.sudoku.gui.SudokuFrame;
import eu.kragniz.sudoku.io.SudokuFile;
import eu.kragniz.sudoku.solver.SudokuSolver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] filenames = new String[]{
            "data/book55.sud",
            "data/book56.sud",
            "data/book57.sud",
            "data/book58.sud",
            "data/book62.sud",
            "data/book63.sud",
            "data/book64.sud",
            "data/book65.sud",
            "data/book67.sud",
            "data/book68.sud",
            "data/book69.sud",
            "data/book70.sud",
            "data/guardian.sud",
            "data/newone.sud",
            "data/prize352.sud",
            "data/simple349.sud",
            "data/simple351.sud",
            "data/web.sud"
        };
        int solved = 0;
        for (String filename : filenames) {
            SudokuFile file = new SudokuFile(filename);
            try {
                file.read();
                Sudoku sudoku = SudokuFactory.getSudoku(file.getArray());
                sudoku.setName(filename);

                System.out.print(filename);
                if (SudokuSolver.solve(sudoku)) {
                    System.out.print(" - solved\n");
                    solved++;
                } else {
                    System.out.print(" - failed\n");
                }

                SudokuFrame frame = new SudokuFrame(sudoku);
                frame.setVisible(true);

            } catch (IOException e) {
                System.out.println("file not found");
                e.printStackTrace();
            }
        }
        System.out.print("Solved - ");
        System.out.print(solved);
        System.out.print(" : ");
        System.out.print(((float) solved / (float) filenames.length) * 100);
        System.out.print("%\n");
    }
}
