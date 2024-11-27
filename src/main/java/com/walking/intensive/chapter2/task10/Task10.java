package com.walking.intensive.chapter2.task10;

/**
 * Реализуйте метод isPalindrome(), который проверяет, является ли строка палиндромом.
 *
 * <p>Метод должен игнорировать пунктуацию, пробелы и регистр.
 *
 * <p>P.S. Мой любимый палиндром: Муза! Ранясь шилом опыта, ты помолишься на разум.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task10 {
    public static void main(String[] args) {

    }

    static boolean isPalindrome(String inputString) {

        if (inputString == null || inputString.length() <= 1) {
            return false;
        }

       String ignoreChars = " .,:;!?\"()—-";
       StringBuilder builder = new StringBuilder();

       for (int i=0; i < inputString.length(); i++) {
           if (ignoreChars.indexOf(inputString.charAt(i)) == -1) {
               builder.append(inputString.charAt(i));
           }
       }

        return builder.toString().equalsIgnoreCase(builder.reverse().toString());
    }
}
