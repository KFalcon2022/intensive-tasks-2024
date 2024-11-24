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
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task1 {
    public static void main(String[] args) {
        int age = 0;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
        int remainder = age % 10;
        int decimalRemainder = age % 100;

        if (age < 0) {
            return ("Некорректный ввод");
        }

        if (decimalRemainder >= 11 && decimalRemainder <= 15) {
            return ("Вам " + age + " лет");
        }

        return switch (remainder) {
            case 2, 3, 4 -> ("Вам " + age + " года");
            case 0, 5, 6, 7, 8, 9 -> ("Вам " + age + " лет");
            default -> ("Вам " + age + " год");
        };
    }
}
