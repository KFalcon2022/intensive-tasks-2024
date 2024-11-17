package com.walking.intensive.chapter1.task1;

import javax.swing.*;

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
        int age = 8;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {

        String convertAgeToString = String.valueOf(age);
        String AgeSuffix = "";

        if (convertAgeToString.endsWith("1") == true && age != 11) {
            AgeSuffix = "Вам " + age + " год";

        } else if ((convertAgeToString.endsWith("2") == true || convertAgeToString.endsWith("3") == true || convertAgeToString.endsWith("4") == true) && age != 12 && age != 13 && age != 14) {
            AgeSuffix = "Вам " + age + " года";

        } else if (age < 0 || age > 120) {
            AgeSuffix = "Так не бывает!!!";

        } else {
            AgeSuffix = "Вам " + age + " лет";
        }

        return AgeSuffix;
    }
}
