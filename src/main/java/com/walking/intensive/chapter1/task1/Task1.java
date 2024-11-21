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

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Укажите ваш возраст: ");
        int age = in.nextInt();

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {

        if (age % 10 == 1) {
            return "Вам " + age + " год";

        }else if (age % 10 == 2 || age % 10 == 3 || age % 10 == 4) {
            return "Вам " + age + " года";

        }else if (age >= 0){
                    return "Вам " + age + " лет";
            }

        return "Некорректный ввод";
    }
}
