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
//        Место дл||я вашего кода

        int delim = 0;
// Определяем порядок делителя
        String strage =Integer.toString(age);
        if (strage.length() == 2){
            delim = 10;
        }
        if (strage.length() == 3){
            delim = 100;
        }
// 1 год и все что заканчивается на 1
        if (age == 1 || age % delim== 1) {
            return "Вам " + age +" год";
        }
// 2,3,4 года и все что заканчивается на 2,3,4
        if ((age == 2) ||  (age == 3) ||  (age == 4) || (age % delim == 2) ||  (age % delim == 3) ||  (age % delim == 4)){
            return "Вам " + age +" года";
        }
        if ((age == 5) ||  (age == 6) ||  (age == 7) ||  (age == 8) ||  (age == 9) ||  (age == 10)){
            return "Вам " + age +" лет";
        }
        if ((age % delim == 0) || (age % delim == 5) ||(age % delim == 6) ||(age % delim == 7) ||(age % delim == 8) ||(age % delim == 9) ){
            return "Вам " + age +" лет";
        }
        //Исключение из правил
        if ((age == 11) || (age == 12) ||  (age == 13) ||  (age == 14)){
            return "Вам " + age +" лет";
        }
        //Обработка ошибки
        if (age <= 0) {
            return "Некорректный ввод";
        }
        return "true"; // Заглушка. При реализации - удалить
    }
}
