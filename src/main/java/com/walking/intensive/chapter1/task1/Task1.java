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
        int age = -1;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
        //Ранняя проверка
        if (age<0){
            return "Некорректный ввод";
        }

        String result;
        int lastDigitAge = age % 10;// последняя цифра возраста
        boolean isSecondDecade = age % 100 - lastDigitAge == 10;//второе десятилетие, от 10 до 19 лет.

        if (lastDigitAge == 1 & !isSecondDecade) {
            result = "Вам " + age + " год";
        } else if ((2 <= lastDigitAge & lastDigitAge <= 4) & !isSecondDecade) {
            result = "Вам " + age + " года";
        } else {
            result = "Вам " + age + " лет";
        }
        return result;
    }
}
