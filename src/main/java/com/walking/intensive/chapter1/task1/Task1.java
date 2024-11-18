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

        int age = 1;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
        int modResult10 = age % 10;
        int modResult100 = age % 100;

        if (age < 0) {
            return "Не корректный ввод";
        } else if (modResult10 == 1 && modResult100 != 11) {
            return "Вам " + age + " " + "год";
        } else if (modResult10 >= 2 && modResult10 <= 4 && (modResult100 < 12 || modResult100 > 14)) {
            return "Вам " + age + " " + "года";
        } else if (age >= 5 || age <= 20 || modResult10 > 5 || modResult100<20) {
            return "Вам " + age + " " + "лет";
        }else {
            return "лет";
        }

    }
}
