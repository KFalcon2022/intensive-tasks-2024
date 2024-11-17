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
        for (int i = 0; i < 26; i++) {
            System.out.println(getAgeString(i));
        }
    }

    static String getAgeString(int age) {

        if (age < 0) {
            return "Некорректный ввод";
        }

        int lastNumber = age % 10;
        int last2Numbers = age % 100;
        String end = "лет";

        if (lastNumber == 1 && last2Numbers != 11) {
            end = "год";
        } else if (lastNumber > 1 && lastNumber < 5 && last2Numbers != 12 && last2Numbers != 13 && last2Numbers != 14) {
            end = "года";
        }

        return "Вам " + age + " " + end;
    }
}
