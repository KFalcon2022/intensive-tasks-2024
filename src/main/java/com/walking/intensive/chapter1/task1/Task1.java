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
        for (int i = 0; i < 10_000_000; i++) {
            System.out.println(getAgeString(i));
        }
    }

    static String getAgeString(int age) {
        if (age < 0) {
            return "Некорректный ввод";
        }

        if (isNumbers(age)) {
            return String.format("Вам %d лет", age);
        }

        return switch (age % 10) {
            case 1 -> String.format("Вам %d год", age);
            case 2, 3, 4 -> String.format("Вам %d года", age);
            default -> String.format("Вам %d лет", age);
        };
    }

    private static boolean isNumbers(int age) {
        int temp = 0;

        for (int i = 0; i < 2; i++) {
            temp += age % 10;
            temp *= 10;
            age /= 10;
        }

        temp /= 10;

        return temp == 11 || temp == 21 || temp == 31 || temp == 41;
    }
}
