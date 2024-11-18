package com.walking.intensive.chapter1.task2;

/**
 * ���������� ����� getFlatLocation(), ������� ����� ��������� ����������� ��������� ������:
 * <ul>
 * <li> ���������� ������ � ����;
 * <li> ���������� ���������;
 * <li> ����� ������ ��������.
 * </ul>
 *
 * <p>���������� ���������� �������, ���� � ������������ ������ �������� ������������ �����,
 * �������������� ���������� ���������:
 * <ul>
 * <li> �� ����� 4 ��������;
 * <li> ��������� ������� ���������� �� ������� �������.
 * </ul>
 *
 * <p>������� ������, ������������ �� ������:
 * <ul>
 * <li> 1 �� � 1 �������, 1 ����, ����� �� �����, �����
 * <li> 2 �� � 1 �������, 1 ����, ����� �� �����, ������
 * <li> 3 �� � 1 �������, 1 ����, ������ �� �����, �����
 * <li> 4 �� � 1 �������, 1 ����, ������ �� �����, ������
 * </ul>
 *
 * <p>���� ��� ���� � ��������� ���������� � ����������� ��������� �������� � �������� ������� �� ����������,
 * ����� ������ ������� ������ "����� �������� �� ����������".
 *
 * <p>���� ���� �� ���� �� ��������� ���������� ������������ - ��������, ������������� ����� ��� 0,
 * ����� ������ ������� ������ "������������ ������� ������".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">���������� � ����������</a>
 */
public class Task2 {
    public static void main(String[] args) {

        int floorAmount = 9;
        int entranceAmount = 4;
        int flatNumber = 220;

        System.out.println(getFlatLocation(floorAmount, entranceAmount, flatNumber));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        String textMessage = flatNumber + " �� - ";

        if (flatNumber < 1 || floorAmount < 1 || entranceAmount < 1) {
            textMessage = "������������ ������� ������";
            return textMessage;
        } else if (flatNumber > floorAmount * entranceAmount * 4) {
            textMessage = "����� �������� �� ����������";
            return textMessage;
        }

        int flatEntrance = (flatNumber + floorAmount * 4 - 1) / (floorAmount * 4);
        int flatFloor = (flatNumber + 3) / 4 - ((flatEntrance - 1) * floorAmount);
        int flatCorner = flatNumber % 4;

        textMessage = textMessage + flatEntrance + " �������, " + flatFloor + " ����, ";

        switch (flatCorner) {
            case (1):
                textMessage = textMessage + "����� �� �����, �����";
                break;
            case (2):
                textMessage = textMessage + "����� �� �����, ������";
                break;
            case (3):
                textMessage = textMessage + "������ �� �����, �����";
                break;
            case (0):
                textMessage = textMessage + "������ �� �����, ������";
                break;
        }

        return textMessage;
    }
}