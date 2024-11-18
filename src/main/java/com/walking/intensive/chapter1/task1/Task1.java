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
        int age = 14;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
        if (age < 0 || age > 127) {
            return "Некорректный ввод";
        }

        if (age == 11 || age == 12 || age == 13 || age == 14 ||
                age == 111 || age == 112 || age == 113 || age == 114) {
            return String.format("Вам %d лет", age);
        }

        return switch (age % 10) {
            case 1 -> String.format("Вам %d год", age);
            case 2, 3, 4 -> String.format("Вам %d года", age);
            default -> String.format("Вам %d лет", age);
        };
    }
}
