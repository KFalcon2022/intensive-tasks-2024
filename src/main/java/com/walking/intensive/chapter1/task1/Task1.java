package com.walking.intensive.chapter1.task1;

import java.util.Scanner;

/**
 * Реализуйте метод getAgeString(), который будет принимать параметром целое число (возраст) и возвращать строку
 * вида: "Вам N лет". Программа должна учитывать правила русского языка.
 *
 * <p>Пример верного исполнения кода: "Вам 5 лет", "Вам 4 года".
 * Пример неверной работы программы: "Вам 14 года".
 *
 * <p>Также необходимо учесть негативные сценарии. Например, попытку передать в метод невалидное значение - например,
 * отрицательное число. В таких случаях ожидается, что метод вернет строку "Некорректный ввод".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение: ");
        System.out.println(getAgeString(scanner.nextInt()));
        scanner.close();
    }

    static String getAgeString(int age) {
        if (age < 0 || age > 110) {
            return "Неверный возраст";
        }
        int remain = age % 10;
        int remain2 = age % 100;
        String words;
        if (remain2 > 10 && remain2 < 15) {
            words = "лет";
        } else {
            switch (remain) {
                case 1 -> words = "год";
                case 2, 3, 4 -> words = "года";
                default -> words = "лет";

            }
        }
        return "Вам " + age + " " + words;

    }
}


