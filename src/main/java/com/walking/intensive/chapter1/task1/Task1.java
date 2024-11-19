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

    }

    static String getAgeString(int age) {
        if (age <= 0) {
            return "Вы ввели Некорректную дату";
        }
        if (age == 1 | (age > 20 && age % 10 == 1)) {
            return "Вам " + age + " год";
        }
        if (age < 5 | (age > 20 & age % 10 == 2 | age % 10 == 3 | age % 10 == 4)) {
            return "Вам " + age + " года";
        } else {
            return "Вам " + age + " лет";
        }
    }
}

