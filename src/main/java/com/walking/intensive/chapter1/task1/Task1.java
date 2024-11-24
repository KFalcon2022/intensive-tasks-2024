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

        final int AGE = 1;
        System.out.println(getAgeString(AGE));
    }

    static String getAgeString(final int AGE) {
        if (AGE >= 0) {
            int divideAge = AGE;
            boolean isException = (AGE % 100 < 10) || (AGE % 100 > 14);

            if (isException) {
                divideAge = AGE % 10;
            }

            if (divideAge == 1) {
                return "Вам " + AGE + " год";
            } else if (divideAge > 1 && divideAge < 5) {
                return "Вам " + AGE + " года";
            }
            return "Вам " + AGE + " лет";
        }
        return "Некорректный ввод";
    }
}
