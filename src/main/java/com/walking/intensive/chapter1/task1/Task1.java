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
        int age = 3;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
//        Место для вашего кода
        if (age < 0) {
            return "Некорректный ввод";
        }
        else if (age > 10 && age < 15) {
            return "Вам "+ age +" лет";
        }
        else if (age > 110 && age < 115) {
            return "Вам "+ age +" лет";
        }
        int lastNum = age % 10;
        switch (lastNum) {
            case 0:
                return "Вам "+ age +" лет";
            case 1:
                return "Вам "+ age +" год";
            case 2:
                return "Вам "+ age +" года";
            case 3:
                return "Вам "+ age +" года";
            case 4:
                return "Вам "+ age +" года";
            default:
                return "Вам "+ age +" лет";

        }
    }
}
