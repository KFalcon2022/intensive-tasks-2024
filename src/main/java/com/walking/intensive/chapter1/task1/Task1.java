package com.walking.intensive.chapter1.task1;

import java.util.List;

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
//        Для собственных проверок можете делать любые изменения в этом методе
        for (int i = 90; i < 125; i++) {
            System.out.println(getAgeString(i));
        }
    }

    static String getAgeString(int age) {

        int lastDigit = age % 10;
        int lastTwoDigits = age % 100;

        if (age < 0 || age > 127) {
            return "Некорректный ввод";
        }

        if ((lastTwoDigits > 10 && lastTwoDigits < 15) || List.of(5, 6, 7, 8, 9, 0).contains(lastDigit)) {
            return "Вам " + age + " лет";
        }

        if (lastDigit == 1) {
            return "Вам " + age + " год";
        }

        if (lastDigit > 1 && lastDigit < 5) {
            return "Вам " + age + " года";
        }

        return "Вам " + age + " лет";
    }
}
