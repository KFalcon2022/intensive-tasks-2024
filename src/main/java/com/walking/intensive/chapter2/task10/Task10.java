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
    }

    static boolean isPalindrome(String inputString) {

        if (isStringValid(inputString)) {

            return false;
        }

        String tempString = inputString.toLowerCase();
        StringBuilder strBuilderTemp = new StringBuilder(tempString);
        StringBuilder strBuilderFinal = new StringBuilder();

        for (int i = 0; i <= (inputString.length() - 1); i++) {
            if (strBuilderTemp.charAt(i) >= 'а' && strBuilderTemp.charAt(i) <= 'я') {
                strBuilderFinal.append(strBuilderTemp.charAt(i));
            }
        }
        String noSpaceLowcaseNomarks = strBuilderFinal.toString();
        int i = 0;
        int j = (noSpaceLowcaseNomarks.length() - 1);
        while (i < j) {
            if (noSpaceLowcaseNomarks.charAt(i) != noSpaceLowcaseNomarks.charAt(j)) {

                return false;
            }
            i++;
            j--;
        }

        return true;
    }


    static boolean isStringValid(String inString) {

        return (inString == null || inString.length() < 2 || inString == "");
    }
}
