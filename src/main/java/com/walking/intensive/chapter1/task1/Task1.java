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

        //проверка корректности переданного значения
        if (age < 0) {
            return "Некорректный ввод";
        }
        int part = age/10;
        int perem = age - (part*10);

        String text = "";
        if (age==11||age==111||age==0) { //0,11,111
            text = "Вам "+age + " лет";
        } else if (age>11&&age<=20) { //12-20
            text = "Вам "+age + " лет";
        } else if (age>111&&age<=120) { //112-120
            text = "Вам "+age + " лет";
        } else if (perem==1) { //x1
            text = "Вам "+age + " год";
        } else if (perem>1&&perem<=4) { //x2-x4
            text = "Вам "+age + " года";
        } else if (perem>4&&perem<=9) { //x5-x9
            text = "Вам "+age + " лет";
        } else if (perem==0) { //x0
            text = "Вам "+age + " лет";
        }
        return text;
    }
}
