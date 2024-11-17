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

        int age = 22;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
        int toModuloDivideByTen = age % 10;
        int toModuloDivideByOneHundred = age % 100;

        if (toModuloDivideByTen == 1 && toModuloDivideByOneHundred != 11) {
            return "Вам " + age + " " + "год";
        } else if (toModuloDivideByTen >= 2 && toModuloDivideByTen <= 4 && (toModuloDivideByOneHundred < 12 || toModuloDivideByOneHundred > 14)) {
            return "Вам " + age + " " + "года";
        } else if (age >= 5 || age <= 20 || toModuloDivideByTen > 5) {
            return "Вам " + age + " " + "лет";
        } else {
            return "Не корректный ввод";
        }

    }
}
