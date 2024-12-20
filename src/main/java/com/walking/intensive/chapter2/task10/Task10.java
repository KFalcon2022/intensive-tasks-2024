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
        String inputString1 = "   Муза,   ранясь !!! )шилом (опыта), ты помолишься на разум!?!   ";
        String inputString2 = "Ежу хуже";
        String inputString = "!!!!гаа12г ";
        System.out.println(isPalindrome(inputString));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() <= 1 || inputString.isEmpty()) {
            return false;
        }

        int leftSym = 0;
        int rightSym = inputString.length() - 1;

        while (leftSym < rightSym) {
            while (leftSym < rightSym && !Character.isLetter(inputString.charAt(leftSym))) {
                leftSym++;
            }

            while (leftSym < rightSym && !Character.isLetter(inputString.charAt(rightSym))) {
                rightSym--;
            }

            if (Character.toLowerCase(inputString.charAt(leftSym))
                    != Character.toLowerCase(inputString.charAt(rightSym))) {
                return false;
            }

            leftSym++;
            rightSym--;
        }

        return true;
    }

    //    Пусть два нижних метода останутся мне на память.
    static boolean isCyrillicLetter(char letter) {
        return (int) letter >= 1072 && (int) letter <= 1105 && (int) letter != 1104;
    }

    static boolean isPalindromeByExceptions(String inputString) {
        /* Метод работает по принципу удаления пробелов и знаков препинания. Недостаток метода - низкая (вроде!)
        скорость; невозможность удалить цифры, латинские буквы, смайлики и это вот всё.
         */

        if (inputString == null) {
            return false;
        }

        inputString = inputString.replace(" ", "");
        inputString = inputString.replace(".", "");
        inputString = inputString.replace("!", "");
        inputString = inputString.replace(",", "");
        inputString = inputString.replace("?", "");
        inputString = inputString.replace("'", "");
        inputString = inputString.replace("(", "");
        inputString = inputString.replace(")", "");
        inputString = inputString.replace("-", "");
        inputString = inputString.replace("_", "");

        inputString = inputString.toLowerCase();

        if (inputString.length() <= 1) {
            return false;
        }

        int halfLength = inputString.length() / 2;
        int odd = inputString.length() % 2 == 0 // Чётность приведённой строки. Чтобы проверить лишь до половины строки.
                ? 1
                : 0;

        for (int i = 0; i <= halfLength; i++) {
            char leftLetter = inputString.charAt(i);
            char rightLetter = inputString.charAt(halfLength * 2 - odd - i);

            if (leftLetter != rightLetter) {
                return false;
            }
        }

        return true;
    }
}
