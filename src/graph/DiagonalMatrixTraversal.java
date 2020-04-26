package graph;

import java.util.ArrayList;

public class DiagonalMatrixTraversal {

    static void printDiagonal(char[][] list) {

        // print first half -> row is increasing and row is our leading factor
        int row = 0;
        int col;

        while(row < list.length) {

            int rowTemp = row;
            col = 0;

            while(rowTemp >= 0) {
                System.out.print(list[rowTemp][col]);
                rowTemp--;
                col++;
            }
            System.out.println();
            row++;
        }

        // print second half -> row is reducing and col is our leading factor
        col = 1; // to avoid repeating overlapping elements
        while (col < list.length) {
            int colTemp = col;
            row = list.length-1;

            while(colTemp < list.length) {
                System.out.print(list[row][colTemp]);
                colTemp++;
                row--;
            }
            System.out.println();
            col++;
        }
    }

    static void printDiagonalUsingQueue() {} {

    }

    public static void main(String[] args) {

        char [][] list = {{'a','b','c'},{'e','f','g','h'}, {'i','j','k'}};

        printDiagonal(list);
    }
}
