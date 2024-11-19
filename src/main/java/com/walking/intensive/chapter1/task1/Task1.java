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
        int age = 110;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {

        if (age < 0) {
            return "Некорректный ввод";
        }

        int remBy10 = age % 10;
        int remBy100 = age % 100;

        if (remBy10 == 1 && remBy100 != 11) {
            return "Вам " + age + " год";
        }

        if (remBy10 >= 2 && remBy10 <= 4 && (remBy100 < 12 || remBy100 > 14)) {
            return "Вам " + age + " года";
        }

        return "Вам " + age + " лет";
    }
}
