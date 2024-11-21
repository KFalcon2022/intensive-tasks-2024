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
public class Task1 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        int age = 121;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
        String let = "лет";
        String god = "год";
        String goda = "года";
        String result = "Некорректный ввод";

        int res = age % 10;

        if (age < 0) {
            System.out.println(result);
        }

        if ((age >= 11 && age < 15) || (age % 100 >= 11 && age % 100 <= 15)) {
            result = let;

        } else if (res == 0 || (res >= 5 && res <= 9)) {
            result = let;

        } else if (res >= 2 && res <= 4) {
            result = goda;

        } else if (age >= 1)
            result = god;


        System.out.println("Вам " + age + " " + result);

    }
}
