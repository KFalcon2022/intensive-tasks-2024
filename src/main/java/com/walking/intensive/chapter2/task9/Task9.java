package com.walking.intensive.chapter2.task9;

import java.util.Arrays;

public class Task9 {
    public static void main(String[] args) {

        int n = 21;
        System.out.println(getPascalTriangle(n));
    }

    static String getPascalTriangle(int n) {

        if (n < 1) {
            return "";
        }

        int[][] cellsOfTriangle = new int[n][n];
        String[] rawText = new String[n];

        for (int i = 0; i < n; i++) {
            cellsOfTriangle[i][0] = 1;
            cellsOfTriangle[0][i] = 1;
            rawText[i] = "1";
        }

        for (int i = 1; i < n; i++) {

            for (int j = 1; j <= (n - i); j++) {
                cellsOfTriangle[i][j] = cellsOfTriangle[i][j - 1] + cellsOfTriangle[i - 1][j];
            }

            for (int j = 1; j <= i; j++) {
                rawText[i] += " " + cellsOfTriangle[i - j][j];
            }
        }

        int rawLength;
        String result = "";

        for (int i = 0; i < n; i++) {
            rawLength = (rawText[n - 1].length() - rawText[i].length()) / 2;

            for (int j = 0; j < rawLength; j++) {
                result += " ";
            }

            result += rawText[i] + "\n";
        }

        return result;
    }
}
