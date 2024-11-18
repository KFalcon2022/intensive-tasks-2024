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

        int age = 36;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {

        String output;

        if (age % 10 == 1 && age != 11) {
            output = "Вам " + age + " год";
        } else if (age > 21 && age % 10 > 1 && age % 10 < 5 || age > 1 && age < 5) {
            output = "Вам " + age + " года";
        } else if (age % 10 == 0 || age > 21 && age % 10 > 4 && age % 10 <= 9 || age > 10 && age < 20) {
            output = "Вам " + age + " лет";
        } else {
            output = "Некорректный ввод";
        }

        return output;
    }
}
