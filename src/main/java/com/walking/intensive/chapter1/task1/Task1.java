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

//        int age = 12023;
        int age = 2313;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
//        Место для вашего кода
        if (age < 0) {
            System.out.println("Некорректный ввод");
            return null;
        }


        int lastCharacter = age;
        String lastTwoCharacters;
        String endWord = "лет";

        if (age < 10) {
            endWord = switch (lastCharacter) {
                case (0) -> "лет";
                case (1) -> "год";
                case (2) -> "года";
                case (3) -> "года";
                case (4) -> "года";
                default -> "лет";
            };
        }


        if (age > 9) {
            lastCharacter = age % 10;
            String str = Integer.toString(age);
            char[] array = str.toCharArray();
            int index = array.length - 2;
            lastTwoCharacters = "" + array[index] + lastCharacter;
//            String[]  exceptions = new String[] {"11","12","13","14","15","16","17","18","19"};
            String exceptions = "11,12,13,14,15,16,17,18,19";


            endWord = switch (lastCharacter) {
                case (0) -> "лет";
                case (1) -> "год";
                case (2) -> "года";
                case (3) -> "года";
                case (4) -> "года";
                default -> "лет";
            };


            if (exceptions.contains(lastTwoCharacters)) {
                endWord = "лет";
            }

        }



        return "Вам " + age + " " + endWord;
    }
}
