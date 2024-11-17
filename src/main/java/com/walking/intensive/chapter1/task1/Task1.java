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

        int age = 0;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {
        if (age%10==1 && age%100!=11){
            return "Вам " + age + " " + "год";
        }
        else if (age%10>=2 && age%10<=4 && (age%100<12 || age%100>14)){
            return "Вам " + age + " " + "года";
        }
        else if(age>=5 || age<=20 || age%10>5){
            return "Вам " + age + " " + "лет";
        }
        else {
            return "Не корректный ввод";
        }

    }
}
