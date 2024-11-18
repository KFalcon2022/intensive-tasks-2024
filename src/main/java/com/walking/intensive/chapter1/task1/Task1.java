package com.walking.intensive.chapter1.task1;

/**
 * ���������� ����� getAgeString(), ������� ����� ��������� ���������� ����� ����� (�������) � ���������� ������
 * ����: "��� N ���". ��������� ������ ��������� ������� �������� �����.
 *
 * <p>������ ������� ���������� ����: "��� 5 ���", "��� 4 ����".
 * ������ �������� ������ ���������: "��� 14 ����".
 *
 * <p>����� ���������� ������ ���������� ��������. ��������, ������� �������� � ����� ���������� �������� - ��������,
 * ������������� �����. � ����� ������� ���������, ��� ����� ������ ������ "������������ ����".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">���������� � ����������</a>
 */
public class Task1 {
    public static void main(String[] args) {

        int age = 123;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {

        String textMessage = "��� " + age;

        if (age <= 0) {
            textMessage = "��� ��� � ������!";
        } else if (age % 100 > 10 && age % 100 < 15) {
            textMessage = textMessage + " ���";
        } else if (age % 10 > 1 && age % 10 < 5) {
            textMessage = textMessage + " ����";
        } else if (age % 10 == 1) {
            textMessage = textMessage + " ���";
        } else textMessage = textMessage + " ���";

        return textMessage;
    }
}
