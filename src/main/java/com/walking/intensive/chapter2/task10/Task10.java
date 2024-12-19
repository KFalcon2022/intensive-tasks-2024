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
        String check = "Муза! Ранясь шилом опыта, ты помолишься на разум.";
        System.out.println(isPalindrome(check));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() < 2 || inputString.isEmpty()){
            return false;
        }

        StringBuilder builder = new StringBuilder(removePunctuation(inputString));

        return removePunctuation(inputString).equals(builder.reverse().toString());
    }

    static String removePunctuation (String string){
        String withoutPunctuation = "";

        for (int i = 0; i < string.length(); i++) {
            String checkSymbol = string.toLowerCase().substring(i, i + 1);
            if (!checkSymbol.equals("!") && !checkSymbol.equals("?") && !checkSymbol.equals(".")
                    && !checkSymbol.equals(",") && !checkSymbol.equals(":") && !checkSymbol.equals("-")
                    && !checkSymbol.equals(" ") && !checkSymbol.equals(";")){
                withoutPunctuation += checkSymbol;
            }
        }

        return withoutPunctuation;
    }
}
