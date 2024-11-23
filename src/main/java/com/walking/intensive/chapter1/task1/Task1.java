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

        String ageText;

        if (age <= 0) {
            return "Некорректный ввод";
        } else {
            switch (age % 10) {

                case 1:
                    ageText = " год";
                    if (age % 100 == 11) {
                        ageText = " лет";
                    }
                    break;

                case 2:
                case 3:
                case 4:
                    ageText = " года";
                    if (age % 100 == 12 || age % 100 == 13 || age % 100 == 14) {
                        ageText = " лет";
                    }
                    break;

                default: {
                    ageText = " лет";
                }

            }
            return "Вам " + age + ageText;
        }

    }
}
