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
 * * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */

public class Task1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);//использовал модуль "Scanner" чтобы вводить данные из консоли
        System.out.print("Введите возраст: ");
        int age = in.nextInt();

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
        if (age < 0 || age > 127) { // отсекаем отрицательные значения
            return ("Некорректный ввод");
        }

        int lastDigit = age % 10;//получаем последний символ
        int lastTwoDigits = age % 100;//получаем последние 2 символа

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            return ("Вам " + age + " лет");
        }

        return switch (lastDigit) {
            case 1 -> ("Вам " + age + " год");
            case 2, 3, 4 -> ("Вам " + age + " года");
            default -> "Вам " + age + " лет";
        };

    }
}
