// 36. Valid Sudoku
// Leetcode: Medium
// Neetcode: Medium

// You are given a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:
// 1. Each row must contain the digits 1-9 without duplicates.
// 2. Each column must contain the digits 1-9 without duplicates.
// 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.

// Return true if the Sudoku board is valid, otherwise return false

// NOTE: A board does not need to be full or be solvable to be valid.

// Input: board =                                Output: true
// [["1","2",".",".","3",".",".",".","."],
// ["4",".",".","5",".",".",".",".","."],
// [".","9","8",".",".",".",".",".","3"],
// ["5",".",".",".","6",".",".",".","4"],
// [".",".",".","8",".","3",".",".","5"],
// ["7",".",".",".","2",".",".",".","6"],
// [".",".",".",".",".",".","2",".","."],
// [".",".",".","4","1","9",".",".","8"],
// [".",".",".",".","8",".",".","7","9"]]

// Input: board =                                Output: false
// [["1","2",".",".","3",".",".",".","."],
// ["4",".",".","5",".",".",".",".","."],
// [".","9","1",".",".",".",".",".","3"],
// ["5",".",".",".","6",".",".",".","4"],
// [".",".",".","8",".","3",".",".","5"],
// ["7",".",".",".","2",".",".",".","6"],
// [".",".",".",".",".",".","2",".","."],
// [".",".",".","4","1","9",".",".","8"],
// [".",".",".",".","8",".",".","7","9"]]

// Constraints:
// board.length == 9
// board[i].length == 9
// board[i][j] is a digit 1-9 or '.'.

// Time Complexity: 0(9 * 9) since it is a fixed array, meaning O(1)
// Space Complexity: O(1) since again we are using a fixed array

import java.util.*;

public class ValidSudoku {

    record Point(int row, int column) {}
    record IndexManipulation(int row, int column) {}

    // since the Sudoku table is fixed, all the indexes of squares' centers are fixed
    private static final Point[] squareCenterIndex = new Point[] {
            new Point(1,1),
            new Point(1,4),
            new Point(1,7),
            new Point(4,1),
            new Point(4,4),
            new Point(4,7),
            new Point(7,1),
            new Point(7,4),
            new Point(7,7),
    };

    // from each center we have to check all elements around it
    // this array holds the index calc we have to do to reach an element
    private static final IndexManipulation[] indexCalcFromCenter = new IndexManipulation[] {
            // top left of center
            new IndexManipulation(-1,-1),
            // up from center
            new IndexManipulation(-1,0),
            // top right of center
            new IndexManipulation(-1,1),
            // left of center
            new IndexManipulation(0,-1),
            // right of center
            new IndexManipulation(0,1),
            // down left of center
            new IndexManipulation(1,-1),
            // down of center
            new IndexManipulation(1,0),
            // down right of center
            new IndexManipulation(1,1),
    };

    private static final char[][] invalidBoard = {
            {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
            {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
            {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
            {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
            {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    private static final char[][] invalidBoard2 = {
            {'5', '3', '5', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    private static final char[][] validBoard = {
            {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
            {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
            {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
            {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    private static final char[][] validBoard2 = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    public static void main(String[] args) {
        System.out.println(validSudoku(invalidBoard));
        System.out.println(validSudoku(invalidBoard2));
        System.out.println(validSudoku(validBoard));
        System.out.println(validSudoku(validBoard2));
    }

    private static boolean validSudoku(char[][] board) {

        // checks for duplicated characters at each row
        Set<Character>[] allBoardRows = new HashSet[9];
        for(int i = 0; i < 9; i++) {
            allBoardRows[i] = new HashSet<>();
        }

        // checks for duplicated characters at each column
        Set<Character>[] allBoardColumns = new HashSet[9];
        for(int i = 0; i < 9; i++) {
            allBoardColumns[i] = new HashSet<>();
        }

        // in the board there are nine 9 squares
        // the loop goes around all squares' center
        for(Point squareCenterLoc : squareCenterIndex ) {

            // checks for symbols that were found in the square
            Set<Character> charsMetInSquare = new HashSet<>();
            char charAtCenter = board[squareCenterLoc.row][squareCenterLoc.column];

            // add the center's symbol to the square, row and column sets
            if(charAtCenter != '.') {
                charsMetInSquare.add(charAtCenter);
                allBoardRows[squareCenterLoc.row].add(charAtCenter);
                allBoardColumns[squareCenterLoc.column].add(charAtCenter);
            }

            // goes throughout all the adjacent elements around the square's center
            for(IndexManipulation adjacentElementIndex : indexCalcFromCenter) {
                Point adjacentElement = new Point(
                        squareCenterLoc.row + adjacentElementIndex.row(),
                        squareCenterLoc.column + adjacentElementIndex.column());

                char currentChar = board[adjacentElement.row][adjacentElement.column];

                // if the add operation was not successful to the square, row or column set
                // aka if there is a duplicate, it means that the Sudoku board is not valid
                if(currentChar != '.') {
                    if (!charsMetInSquare.add(currentChar) ||
                            !allBoardRows[adjacentElement.row].add(currentChar) ||
                            !allBoardColumns[adjacentElement.column].add(currentChar)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
