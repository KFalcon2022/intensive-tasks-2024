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
        System.out.println("True:");
        System.out.println("::".repeat(5));
        System.out.println(isPalindrome("Муза! Ранясь шилом опыта, ты помолишься на разум."));
        System.out.println(isPalindrome("Удавы рвали лавры в аду"));
        System.out.println(isPalindrome("Мадам"));
        System.out.println(isPalindrome("No lemon, no melon"));

        System.out.println();

        System.out.println("False:");
        System.out.println("::".repeat(5));
        System.out.println(isPalindrome("A"));
        System.out.println(isPalindrome("Кабан упал и лапу набок"));
        System.out.println(isPalindrome("Муза, ранясь шилом опыта, ты помолишься на разумы"));
        System.out.println(isPalindrome(null));
        System.out.println(isPalindrome(""));
    }


    static boolean isPalindrome(String inputString) {

        if (inputString == null || inputString.length() < 3) {
            return false;
        }

        String cleanedString = inputString.replaceAll("[\\p{Punct}\\s]", "").toLowerCase();

        String reversedString = new StringBuilder(cleanedString).reverse().toString();
        return cleanedString.equals(reversedString);
    }
}
