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
        double a = 2;
        double b = -5;
        double c = 3;

        System.out.println(solveQuadraticEquation(a, b, c));
    }

    static String solveQuadraticEquation(double a, double b, double c) {

        String textMessage = "���������� �������: ";
        double discriminantValue = b * b - 4 * a * c;

        if (a == 0 && b == 0 && c == 0) {
            return "����������� ���������� �������";
        } else if (a == 0 && b == 0 && c != 0) {
            return "������� ���";
        } else if (a == 0 && b != 0) {
            return "x = -c/b";
        }

        if (discriminantValue > 0) {
            double firstValue = (-b - Math.sqrt(discriminantValue)) / (2 * a);
            double secondValue = (-b + Math.sqrt(discriminantValue)) / (2 * a);
            textMessage = textMessage + "2. �����: " + firstValue + "; " + secondValue;
        } else if (discriminantValue == 0) {
            double firstValue = (-b - Math.sqrt(discriminantValue)) / (2 * a);
            textMessage = textMessage + "1. ������: " + firstValue;
        } else {
            textMessage = textMessage + "0.";
        }

        return textMessage;
    }
}