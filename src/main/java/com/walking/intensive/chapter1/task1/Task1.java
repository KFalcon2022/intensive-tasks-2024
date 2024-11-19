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
        System.out.println(getAgeString(1));
        System.out.println(getAgeString(2));
        System.out.println(getAgeString(5));
        System.out.println(getAgeString(21));
        System.out.println(getAgeString(-5));
    }

    static String getAgeString(int age) {
        if (age < 0) {
            return "Некорректный ввод";
        }

        int lastDigit = age % 10;
        int lastTwoDigits = age % 100;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            return "Вам " + age + " лет";
        }

        switch (lastDigit) {
            case 1:
                return "Вам " + age + " год";
            case 2:
            case 3:
            case 4:
                return "Вам " + age + " года";
            default:
                return "Вам " + age + " лет";
        }
    }
}
