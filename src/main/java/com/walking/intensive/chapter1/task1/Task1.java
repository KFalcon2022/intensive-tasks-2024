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

        if (age >= 1 && age < 130) {

            switch (age) {
                case 1:
                case 21:
                case 31:
                case 41:
                case 51:
                case 61:
                case 71:
                case 81:
                case 91:
                case 101:
                case 121:
                    return "Вам " + age + " год.";

                case 2:
                case 3:
                case 4:
                case 22:
                case 23:
                case 24:
                case 32:
                case 33:
                case 34:
                case 42:
                case 43:
                case 44:
                case 52:
                case 53:
                case 54:
                case 62:
                case 63:
                case 64:
                case 72:
                case 73:
                case 74:
                case 82:
                case 83:
                case 84:
                case 92:
                case 93:
                case 94:
                case 102:
                case 103:
                case 104:
                case 122:
                case 123:
                case 124:
                    return "Вам " + age + " года.";

                default:
                    return "Вам " + age + " лет.";
            }

        }else{
                return "Некорректный ввод.";
            }

    }
}
