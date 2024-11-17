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
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
        String yeartext = "-1";
        int ageunit = 1;
        if (age >= 5 && age <= 20) {
            yeartext = "лет";
        } else if (age > 20 && age <= 100) {
            ageunit = (age % 10);
            switch (ageunit) {
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    yeartext = "лет";
                    break;
                case 1:
                    yeartext = "год";
                    break;
                case 2:
                case 3:
                case 4:
                    yeartext = "года";
                    break;

            }
        }
        if (yeartext == "-1") {
            return "Некорректный ввод";
        } else {
            return "Вам " + age + " " + yeartext; // Заглушка. При реализации - удалить
        }
    }
}
