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
//        Для собственных проверок можете делать любые изменения в этом методе
//        System.out.print(">> ");
//        Scanner in = new Scanner(System.in);
//        int age = in.nextInt();
//        in.close();
        int age = 15;
        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
        if (age < 0) {
            System.out.print("Некорректный ввод");
        } else if (age >= 5 && age <= 20) {
            System.out.print("Вам " + age + " лет");
        } else if (age % 10 == 1) {
            System.out.print("Вам " + age + " год");
        } else if (age % 10 >= 2 && age % 10 <= 4) {
            System.out.print("Вам " + age + " года");
        } else {
            System.out.print("Вам " + age + " лет");
        }
        return "";
    }
}