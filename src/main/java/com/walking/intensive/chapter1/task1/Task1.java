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

        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        System.out.println(getAgeString(age));

    }

    static String getAgeString(int age) {

        if (age >= 0 && age <= 127) {
            int ageunit;
            if (age >= 100) {
                ageunit = ((age - 100) % 10);
            } else {
                ageunit = (age % 10);
            }

            String yeartext;
            if ((age >= 5 && age <= 20) || (age >= 105 && age <= 120) || (ageunit == 0 || (ageunit >= 5 && ageunit <= 9))) {
                yeartext = "лет";
            } else if (ageunit == 1) {
                yeartext = "год";
            } else {
                yeartext = "года";
            }
            return "Вам " + age + " " + yeartext;
        } else {
            return "Некорректный ввод";
        }
    }
}
