package eu.kragniz.sudoku.data;

import eu.kragniz.sudoku.data.factory.SudokuFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

/**
 * Copyright 2013 Louis Taylor <kragniz@gmail.com>
 * Licensed under GPLv3 or later
 */
public class SudokuTest {
    Sudoku sudoku;

    @Before
    public void setUp() throws Exception {
        sudoku = SudokuFactory.getSudoku(new int[][]{
                {2, 6, 0, 0, 0, 0, 0, 8, 4},
                {0, 8, 9, 7, 0, 4, 2, 6, 0},
                {0, 0, 4, 0, 0, 0, 7, 0, 0},
                {0, 0, 0, 4, 9, 2, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 5},
                {0, 0, 0, 1, 5, 8, 0, 0, 0},
                {0, 0, 6, 0, 0, 0, 5, 0, 0},
                {0, 3, 2, 5, 0, 1, 6, 9, 0},
                {9, 5, 0, 0, 0, 0, 0, 3, 1}
        });
    }

    @Test
    public void testPopulateGroups() throws Exception {
    }

    @Test
    public void testSolved({

    }) throws Exception

    @Test
    public void testCell() throws Exception {
        Cell cell = sudoku.cell(0, 0);
        Assert.assertEquals(2, cell.getDigit());
    }

    @Test
    public void testGetRow() throws Exception {
        List<Cell> row = sudoku.getRow(0);
        Assert.assertEquals(2, row.get(0).getDigit());
        Assert.assertEquals(9, row.get(8).getDigit());
    }

    @Test
    public void testGetColumn() throws Exception {
        List<Cell> column = sudoku.getColumn(8);
        Assert.assertEquals(9, column.get(0).getDigit());
        Assert.assertEquals(1, column.get(8).getDigit());
    }

    @Test
    public void testGetBox() throws Exception {
        List<Cell> box = sudoku.getBox(1);
        Assert.assertEquals(0, box.get(0).getDigit());
        Assert.assertEquals(4, box.get(1).getDigit());
    }

    @Test
    public void testGetRowSet() throws Exception {
        HashSet<Cell> rowSet = sudoku.getRowSet(1);
        Assert.assertEquals(true, rowSet.contains(6));
        Assert.assertEquals(true, rowSet.contains(0));
        Assert.assertEquals(true, rowSet.contains(8));
        Assert.assertEquals(true, rowSet.contains(3));
        Assert.assertEquals(true, rowSet.contains(5));
    }

    @Test
    public void testGetColumnSet() throws Exception {
        HashSet<Cell> columnSet = sudoku.getColumnSet(2);
        Assert.assertEquals(true, columnSet.contains(4));
        Assert.assertEquals(true, columnSet.contains(0));
        Assert.assertEquals(true, columnSet.contains(7));
    }

    @Test
    public void testEquals() throws Exception {
        Sudoku sudokuOne = SudokuFactory.getSudoku(new int[][]{
                {2, 6, 0, 0, 0, 0, 0, 8, 4},
                {0, 8, 9, 7, 0, 4, 2, 6, 0},
                {0, 0, 4, 0, 0, 0, 7, 0, 0},
                {0, 0, 0, 4, 9, 2, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 5},
                {0, 0, 0, 1, 5, 8, 0, 0, 0},
                {0, 0, 6, 0, 0, 0, 5, 0, 0},
                {0, 3, 2, 5, 0, 1, 6, 9, 0},
                {9, 5, 0, 0, 0, 0, 0, 3, 1}
        });
        Assert.assertEquals(true, sudoku.toString().equals(sudokuOne.toString()));
    }
}
