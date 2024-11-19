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
        int age = 1;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {

        int ageLength = Integer.toString(age).length();
        int analyzedAge = ageLength > 2 ? age % (int) Math.pow(10, ageLength - 1) : age;

        boolean is11To14Years = analyzedAge >= 11 && analyzedAge <= 14;
        String result = "Вам " + age + " ";

        analyzedAge %= 10;

        if (is11To14Years || analyzedAge == 0) {
            return result + "лет";
        } else if (analyzedAge >= 2 && analyzedAge <= 4) {
            return result + "года";
        } else if (analyzedAge >= 5 && analyzedAge <= 9) {
            return result + "лет";
        } else if (analyzedAge == 1) {
            return result + "год";
        } else {
            return "Некорректный ввод";
        }
    }
}
