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
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(
                "Палиндромом: " +
                        isPalindrome("шалаш"));
    }

    static boolean isPalindrome(String inputString) {

        if (isTrueValue(inputString)) return false;

        StringBuilder cleanedString = new StringBuilder();

        // Итерация по каждому символу строки
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            // Проверяем, является ли символ буквой или цифрой и добавляем в cleanedString в нижнем регистре
            if (Character.isLetterOrDigit(c)) {
                cleanedString.append(Character.toLowerCase(c));
            }
        }

        // Получаем длину очищенной строки
        int length = cleanedString.length();

        // Проверка на палиндром
        for (int i = 0; i < length / 2; i++) {
            if (cleanedString.charAt(i) != cleanedString.charAt(length - 1 - i)) {
                return false;  // Не является палиндромом
            }
        }

        return true;  // Является палиндромом
    }

    private static boolean isTrueValue(String inputString) {
        // Проверка на null или пустую строку, а также с одной буквой
        return inputString == null || inputString.length() <= 1;
    }
}
