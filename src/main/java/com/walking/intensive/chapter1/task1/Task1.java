package com.walking.intensive.chapter1.task1;

import java.util.ArrayList;
import java.util.Arrays;

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
        int age = 112;
        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
//        Место для вашего кода
        int remainder = age % 10;
        int remainder2 = age % 100;
        if (remainder == 1 && age != 11) {
            return ("Вам " + age + " год");
        } else if ((remainder == 2 || remainder == 3 || remainder == 4) && !(age > 11 && age < 15) && !(remainder2 > 11 && remainder2 < 15)) {
            return ("Вам " + age + " года");
        }
        else {
            return ("Вам " + age + " лет");
        }
    }
}
