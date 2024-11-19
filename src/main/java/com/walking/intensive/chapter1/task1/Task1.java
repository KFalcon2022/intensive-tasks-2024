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

        int age = 0;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {

        int ageRemainder10 = age % 10;
        int ageRemainder100 = age % 100;

        if (ageRemainder10 == 1 && ageRemainder100 != 11) {
            return "Вам " + age + " год";
        } else if (age == 0 || (age >= 10 && age <= 20) || (ageRemainder100 >= 10 && ageRemainder100 <= 20)) {
            return "Вам " + age + " лет";
        } else if (ageRemainder10 > 1 && ageRemainder10 < 5) {
            return "Вам " + age + " года";
        } else if (age > 4) {
            return "Вам " + age + " лет";
        } else {
            return "Некорректный ввод";
        }

    }
}
