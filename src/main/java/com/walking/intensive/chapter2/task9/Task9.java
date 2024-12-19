package com.walking.intensive.chapter2.task9;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите колчество строк: ");
        int n = in.nextInt();
        in.close();

        System.out.println(getPascalTriangle(n));
    }

    static String getPascalTriangle(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }

        String lastLine = "";
        for (int i = 0; i < n; i++) {
            lastLine += triangle[n - 1][i] + " ";
        }

        int l = lastLine.length();

        for(int i = 0; i < n - 1; i++) {
            String pascal = "";
            for(int j = 0; j <= i; j++) {
                pascal += triangle[i][j] + " ";
            }
            int l2 = pascal.length();

            String line = "";
            while (line.length() < (l - l2) / 2) {
                line += " ";
            }
            System.out.println(line + pascal);
        }

        return lastLine;
    }
}
