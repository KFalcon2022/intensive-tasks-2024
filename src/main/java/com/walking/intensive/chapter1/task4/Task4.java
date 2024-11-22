package com.walking.intensive.chapter1.task4;

/**
 * ���� ���������:
 *
 * <p>ax? + bx + c = 0
 *
 * <p>���������� ����� solveEquation(), ������� ����������� ���������
 * ������������ - ������������ ����� a, b � c.
 *
 * <p>����� ������ ���������� � ���� ������ ���������� �������, � ����� ���� ������� � ��������� ���� �������:
 * <ul>
 * <li> "���������� �������: 2. �����: -4;4"
 * <li> "���������� �������: 1. ������: 0"
 * <li> "���������� �������: 0."
 * <li> "����������� ��������� �������."
 * </ul>
 *
 * <p>�������� ��������, ��� ���� ������ ��������� ��� - ��� ������ ������������� �� �����������.
 *
 * <p>P.S. ���������� ��������� �������� ���� ����� ������� �����, ���� ����� ������������.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">���������� � ����������</a>
 */
public class Task4 {
    public static void main(String[] args) {
        double a = 0;
        double b = -2;
        double c = 2;

        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {

        String textMessage = "Количество решений: ";

        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечное множество решений.";
        }

        if (a == 0 && b == 0 && c != 0) {
            return textMessage + "0.";
        }

        if (a==0){
            return textMessage+"1. "+(-c)/b;
        }

        double discriminant = b * b - 4 * a * c; //Находим дискриминант

        if (discriminant > 0) {
            double firstValue = (-b - Math.sqrt(discriminant)) / (2 * a); //Находим значение меньшего по значению корня
            double secondValue = (-b + Math.sqrt(discriminant)) / (2 * a); // ... второго корня
            textMessage = textMessage + "2. Корни: " + firstValue + "; " + secondValue;
        } else if (discriminant == 0) {
            double firstValue = (-b - Math.sqrt(discriminant)) / (2 * a); //Значение корня при Д=0
            textMessage = textMessage + "1. Корень: " + firstValue;
        } else {
            textMessage = textMessage + "0.";
        }

        return textMessage;
    }
}