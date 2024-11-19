package com.walking.intensive.chapter1.task1;

import com.sun.source.util.SourcePositions;

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
        int age = 99;
        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
        String result = "";
        int ageDiv = age % 10;
        if (age < 0) {
            result = "Некорректный ввод";
        }
        else if (age > 4 & age < 21) {
            result = "Вам " + age + " лет";
        }
        else if (ageDiv == 0 | ageDiv == 5 | ageDiv == 6 | ageDiv == 7 | ageDiv == 8 | ageDiv == 9) {
            result = "Вам " + age + " лет";
        }

        else if (ageDiv == 1) {
            result = "Вам " + age + " год";
        }
        else if (ageDiv == 2 | ageDiv == 3 | ageDiv == 4) {
            result = "Вам " + age + " года";
        }
        return result; // Заглушка. При реализации - удалить
    }
}
