package com.walking.intensive.chapter1.task1;

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
        System.out.println(getAgeString(-1));
        System.out.println(getAgeString(0));
        System.out.println(getAgeString(1));
        System.out.println(getAgeString(2));
        System.out.println(getAgeString(5));
        System.out.println(getAgeString(11));
        System.out.println(getAgeString(21));
        System.out.println(getAgeString(22));
        System.out.println(getAgeString(25));
        System.out.println(getAgeString(127));
        System.out.println(getAgeString(128));
    }

    static String getAgeString(int age) {
        if (age < 0 || age > 127) {
            return ("Некорректный ввод");
        }

        int lastDigit = age % 10;
        int lastTwoDigits = age % 100;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14 || lastDigit >= 5 || lastDigit == 0) {
            return ("Вам " + age + " лет");
        }

        return switch (lastDigit) {
            case 1 -> ("Вам " + age + " год");
            case 2, 3, 4 -> ("Вам " + age + " года");
            default -> "";
        };

    }
}
