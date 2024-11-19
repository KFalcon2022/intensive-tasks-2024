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
        int age = 113;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
        int lastCharOfAge = age % 10;
        int secondToLastCharOfAge = age % 100;

        if (age < 0) {
            return "Некорректный ввод";
        } else if (secondToLastCharOfAge >= 10 && secondToLastCharOfAge <= 14) {
            return "Вам " + age + " лет";
        } else if (lastCharOfAge >= 2 && lastCharOfAge <= 4) {
            return "Вам " + age + " года";
        } else if (lastCharOfAge == 1) {
            return "Вам " + age + " год";
        } else {
            return "Вам " + age + " лет";
        }
    }
}