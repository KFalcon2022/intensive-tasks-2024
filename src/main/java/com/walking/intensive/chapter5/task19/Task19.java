package com.walking.intensive.chapter5.task19;

import java.util.Random;

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
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Point a = getRandomPoint();
        Point b = getRandomPoint();
        Point c = getRandomPoint();
        int r = RANDOM.nextInt(1, 10);

        Parallelepiped parallelepiped = new Parallelepiped(a, b);
        Sphere sphere = new Sphere(c, r);

        System.out.println("Параллелепипед:");
        System.out.println("A = " + a);
        System.out.println("B = " + b);
        System.out.println("Сфера:");
        System.out.println("Центр = " + c);
        System.out.println("Радиус = " + r);
        System.out.println("Пересекаются? " + isIntersected(sphere, parallelepiped));
    }

    public static boolean isIntersected(Sphere sphere, Parallelepiped parallelepiped) {
        Point nearestToSphereCenterPointOnParallelepiped = parallelepiped.getNearestPointTo(sphere.getCenter());

        double minDistanceBetweenSphereCenterAndParallelepiped = sphere.getCenter()
                .getDistanceTo(nearestToSphereCenterPointOnParallelepiped);

        Point farthestFromSphereCenterPointOnParallelepiped = parallelepiped.getFarthestPointTo(sphere.getCenter());

        double maxDistanceBetweenSphereCenterAndParallelepiped = sphere.getCenter()
                .getDistanceTo(farthestFromSphereCenterPointOnParallelepiped);

        return minDistanceBetweenSphereCenterAndParallelepiped <= sphere.getRadius()
                && maxDistanceBetweenSphereCenterAndParallelepiped >= sphere.getRadius();
    }

    private static Point getRandomPoint() {
        return new Point(getRandomInt(), getRandomInt(), getRandomInt());
    }

    private static int getRandomInt() {
        return RANDOM.nextInt(-9, 10);
    }
}
