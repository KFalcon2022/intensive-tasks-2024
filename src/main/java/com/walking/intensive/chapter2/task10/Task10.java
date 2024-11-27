package com.walking.intensive.chapter2.task10;

import java.lang.reflect.Array;

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

        System.out.println(isPalindrome("Палиндромина - ни морд, ни лап"));
    }

    static boolean isPalindrome(String inputString) {

        if (inputString == null || inputString.length() <2){

            return false;
        }

        inputString = inputString.toUpperCase();
        inputString = inputString.replaceAll("[^\\p{L}]", "");
        char[] cleanCharacters = inputString.toCharArray();
        String outputString = "";

        for (int i = cleanCharacters.length - 1; i >=0 ; i--) {
            outputString += cleanCharacters[i];
        }

        return outputString.equals(inputString);
    }
}
