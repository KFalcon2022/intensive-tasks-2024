package com.walking.intensive.chapter1.task1;

import java.util.Scanner;

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
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
        int testAge = age % 100;
        if (age < 0) {
            return "Некорректный ввод";
        }
        else if (Integer.toString(testAge).endsWith("1") && !Integer.toString(testAge).endsWith("11")){
            return "Вам " + age + " год";
        }
        else if (testAge >= 5 && testAge <= 20 || testAge % 10 >= 5 || testAge % 10 == 0) {
            return "Вам " + age + " лет";
        }
        else if (testAge % 10 >= 2 && testAge % 10 <= 4) {
            return "Вам " + age + " года";
        }
        return "Некорректный ввод";
    }
}
