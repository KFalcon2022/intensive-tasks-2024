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
        int age = 0;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
//        Место для вашего кода
        String ageInString = Integer.toString(age);
        int length = ageInString.length();
        char lastChar = ageInString.charAt(length-1);
        int lastInt = Character.getNumericValue(lastChar);

        if (age < 0) {
            return("Vveden nekorektniy vozrast");
        }
        else if (lastInt == 1) {
            return("Vam " + age + " god");
        }

        else if ((lastInt > 1) && (lastInt < 5)) {
            return("Vam " + age + " goda");
        }

        else if ((lastInt > 4) || (lastInt == 0)) {
            return("Vam " + age + " let");
        }

        return null; // Заглушка. При реализации - удалить
    }
}
