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
        int age = 0;

        System.out.println(getAgeString(0));
        System.out.println(getAgeString(1));
        System.out.println(getAgeString(2));
        System.out.println(getAgeString(3));
        System.out.println(getAgeString(4));
        System.out.println(getAgeString(5));
        System.out.println(getAgeString(10));
        System.out.println(getAgeString(52));
        System.out.println(getAgeString(50000));
    }

    static String getAgeString(int age) {
//        Место для вашего кода
        if (age == 1) {
            return "Вам 1 год";
        } else if (age >= 2 && age < 5) {
            return "Вам " + age + " года";
        } else {
            return "Вам " + age + " лет";
        }
    }
}
