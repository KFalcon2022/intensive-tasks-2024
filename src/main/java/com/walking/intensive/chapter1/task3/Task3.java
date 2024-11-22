package com.walking.intensive.chapter1.task3;

/**
 * ����������� ���, ��� ����� ��������� ��������� ����� ������ ������. T = 365 ����, 5 �����, 48 �����, 45 ������.
 *
 * <p>�� ����, ���� �� ��������� ����������� �������� � 6 ����� � ���,
 * �� �� �������� ������ ����� ���������� ������������ ������ ����.
 * ��� ������������ ��������� 29 ������� ������ 4 ���.
 *
 * <p>������ 100 ��� �������� ����� �����������, ��������� ��� � �������������� 6 �����, � ����� ��� ������������.
 *
 * <p>������ 400 ��� �������� ����� �����������, ��� ����� ����������.
 *
 * <p><p>���������� ����� isLeap(), ������� ��������� ���������� ��� � �������� �� ������: �������� �� ��� ����������?
 *
 * <p>����� ������� ��� ����������� ���� ����� ������ ������� true, ��� �� ����������� - false.
 *
 * <p>���� ���������� � ����� �������� ����������� - ����� ����� ������ ������� false.
 *
 * <p>P.S. �������� �������� �� ��� ����� ���������, ��� ������������� ��������� ��� ������ ���� � 1582 ����,
 * ���������� ���� �������� ��������� ������������� �������� ��� 1582 ���� � ���������� ���.
 * � �������� ������ ��� ������� ����� ������������.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">���������� � ����������</a>
 */
public class Task3 {
    public static void main(String[] args) {

        int year = 1582;

//        if (isLeap(year)) {
//            System.out.println(year + " - високосный год");
//        } else {
//            System.out.println(year + " - невисокосный год");
//        }
    }

    static boolean isLeap(int year) {

        return year > 0 && year % 400 == 0 || year > 0 && year % 4 == 0 && year % 100 != 0;
    }
}
