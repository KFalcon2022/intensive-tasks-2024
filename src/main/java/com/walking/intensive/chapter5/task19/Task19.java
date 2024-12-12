package com.walking.intensive.chapter5.task19;

import static java.lang.Math.*;

/**
 * Создайте классы фигур: класс сфера и параллелепипед.
 * Объект «Сфера» должен задаваться по координате точки центра
 * (x;y;z), где каждая координата задается полем класса,
 * а так же радиусом R.
 *
 * <p>Объект «Параллелепипед» должен задаваться по координате точек
 * A (x1;y1;z1) и B (x2;y2;z2), где каждая координата задается полем класса.
 * AB - главная диагональ прямоугольного параллелепипеда, а ребра параллельны базису.
 *
 * <p>Создайте в main() несколько объектов сфер и параллелепипедов и напишите метод,
 * который отвечает на вопрос: пересекается (или касается) ли объект сфера с объектом параллелепипед?
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task19 {
    public static void main(String[] args) {
        Sphere s = new Sphere(-5, -5, -5, 5 );
        Parallelepiped p = new Parallelepiped(0, 0, 0, 10, 10, 10);

        System.out.println(isIntersected(s, p));
    }

    static boolean isIntersected(Sphere s, Parallelepiped p) {

        // Если центр сферы внутри параллелепипеда
        if (s.getX() >= p.getX1() && s.getX() <= p.getX2() &&
                s.getY() > p.getY1() && s.getY() < p.getY2() &&
                s.getZ() > p.getZ1() && s.getZ() < p.getZ2()) {

            return true;
        }

        // Если центр сферы внутри внешнего сектора в направлении луча из центра параллелепипеда в угол
        if ((s.getX() <= p.getX1() || s.getX() >= p.getX2()) &&
                (s.getY() <= p.getY1() || s.getY() >= p.getY2()) &&
                (s.getZ() <= p.getZ1() || s.getZ() >= p.getZ2())) {
            {
                return s.getR() >= getDistanceSphereCenterNearestCorner(s, p);
            }
        }

        // Если центр сферы внутри внешнего сектора в направлении луча из центра параллелепипеда в ребро в плоскости YZ

        if ((s.getX() <= p.getX1() || s.getX() >= p.getX2()) &&
                (s.getY() <= p.getY1() || s.getY() >= p.getY2()) &&
                (s.getZ() > p.getZ1() && s.getZ() < p.getZ2())) {

            double minDistance = Double.MAX_VALUE;
            double[] distanceEdge = new double[4];
            distanceEdge[0] = getDistanceTwoPoints2D(s.getY(), s.getZ(), p.getY1(), p.getZ1());
            distanceEdge[1] = getDistanceTwoPoints2D(s.getY(), s.getZ(), p.getY1(), p.getZ2());
            distanceEdge[2] = getDistanceTwoPoints2D(s.getY(), s.getZ(), p.getY2(), p.getZ1());
            distanceEdge[3] = getDistanceTwoPoints2D(s.getY(), s.getZ(), p.getY2(), p.getZ2());

            for (int i = 0; i < 4; i++) {
                minDistance = min(minDistance, distanceEdge[i]);
            }

            return s.getR() >= minDistance;
        }

        // Если центр сферы внутри внешнего сектора в направлении луча из центра параллелепипеда в ребро в плоскости XY

        if ((s.getZ() <= p.getZ1() || s.getZ() >= p.getZ2()) &&
                (s.getY() <= p.getY1() || s.getY() >= p.getY2()) &&
                (s.getX() > p.getX1() && s.getX() < p.getX2())) {

            double minDistance = Double.MAX_VALUE;
            double[] distanceEdge = new double[4];
            distanceEdge[0] = getDistanceTwoPoints2D(s.getY(), s.getX(), p.getY1(), p.getX1());
            distanceEdge[1] = getDistanceTwoPoints2D(s.getY(), s.getX(), p.getY1(), p.getX2());
            distanceEdge[2] = getDistanceTwoPoints2D(s.getY(), s.getX(), p.getY2(), p.getX1());
            distanceEdge[3] = getDistanceTwoPoints2D(s.getY(), s.getX(), p.getY2(), p.getX2());

            for (int i = 0; i < 4; i++) {
                minDistance = min(minDistance, distanceEdge[i]);
            }

            return s.getR() >= minDistance;
        }

        // Центр сферы вне параллепипеда - Проверяем каждую сторону параллелепипеда

        int minDistanceToFlat;

        if (s.getX() <= p.getX1()) {
            minDistanceToFlat = p.getX1() - s.getX();
        } else if (s.getX() >= p.getX2()) {
            minDistanceToFlat = s.getX() - p.getX2();
        } else if (s.getY() <= p.getY1()) {
            minDistanceToFlat = p.getY1() - s.getY();
        } else if (s.getY() >= p.getY2()) {
            minDistanceToFlat = s.getY() - p.getY2();
        } else if (s.getZ() <= p.getZ1()) {
            minDistanceToFlat = p.getZ1() - s.getZ();
        } else {
            minDistanceToFlat = s.getZ() - p.getZ2();
        }

        return s.getR() >= minDistanceToFlat;
    }

    static double getDistanceSphereCenterNearestCorner (Sphere s, Parallelepiped p) {

        double minDistance = Double.MAX_VALUE;
        int[][] corners = p.getCornersCoordinates();
        int[] sphereCenter = new int[] {s.getX(), s.getY(), s.getZ()};

        for (int[] corner : corners) {
            minDistance = min(minDistance, getDistanceTwoPoints3D(sphereCenter, corner));
        }

        return minDistance;
    }

    static double getDistanceTwoPoints3D(int[] coordinate1, int[] coordinate2) {

        return sqrt(pow(coordinate1[0] - coordinate2[0], 2) + pow(coordinate1[1] - coordinate2[1], 2) +
                pow(coordinate1[2] - coordinate2[2], 2));
    }

    static double getDistanceTwoPoints2D(int x1, int y1, int x2, int y2) {

        return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
    }
}
