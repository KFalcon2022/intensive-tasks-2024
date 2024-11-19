package com.walking.intensive.chapter1.task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите свой возраст: ");
        int age = in.nextInt();

        {
            if (age <= 0) {
                System.out.println("Некорректный ввод");
            }
            else {
                switch (age % 10) {
                    case 0:
                        System.out.println("Вам " + age + " лет");
                        break;
                    case 1:
                        System.out.println("Вам " + age + " год");
                        break;
                    case 2:
                        System.out.println("Вам " + age + " года");
                        break;
                    case 3:
                        System.out.println("Вам " + age + " года");
                        break;
                    case 4:
                        System.out.println("Вам " + age + " года");
                        break;
                    case 5:
                        System.out.println("Вам " + age + " лет");
                        break;
                    case 6:
                        System.out.println("Вам " + age + " лет");
                        break;
                    case 7:
                        System.out.println("Вам " + age + " лет");
                        break;
                    case 8:
                        System.out.println("Вам " + age + " лет");
                        break;
                    case 9:
                        System.out.println("Вам " + age + " лет");
                        break;
                }
            }
        }
        in.close();
    }
}
