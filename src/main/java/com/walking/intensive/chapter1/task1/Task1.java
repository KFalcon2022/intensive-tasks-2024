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

        int age = -111;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {

        String baseString = "Вам " + age;

        return switch (getAgeParam(age)) {
            case 1:
                yield baseString + " год";
            case 2, 3, 4:
                yield baseString + " года";
            case 5, 6, 7, 8, 9, 0:
                yield baseString + " лет";
            default:
                yield "Некорректный ввод";
        };

    }

    static int getAgeParam(int age) {

        if (age >= 0) {

            int ageParam = (age - (age / 100) * 100);

            if (ageParam >= 11 & ageParam <= 14) {
                ageParam = 0;
            } else {
                ageParam = age - (age / 10) * 10;
            }
            return ageParam;
        }
        return age;
    }
}