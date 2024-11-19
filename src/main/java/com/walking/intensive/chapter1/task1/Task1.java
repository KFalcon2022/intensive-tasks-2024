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

// ввод возраста
        Scanner in = new Scanner(System.in);
        System.out.print("Введите возраст: ");
        int age = in.nextInt();
        {
            switch (age){
                case 0:
                    System.out.println("Вам " + age + " лет");
                    break;
                case 1:
                    System.out.println("Вам " + age + " год");
                    break;
                case 2:
                    System.out.println("Вам " + age + " года");
                    break;
            }
        }
        in.close();
    }
}
