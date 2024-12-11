package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {
        getInscribedCircleRadius(13, 12, 5);
        getHeights(13, 12, 5);
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {
        if (a + b < c || b + c < a || c + a < b) {
            return -1;
        }

        if (isInorrectValue(a, b, c)) {
            return -1;
        }

        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        double[] triangleHeights = new double[3];

        if (a + b <= c || a + c <= b || c + b <= a) {
            return new double[0];
        }

        triangleHeights[0] = getHeight(a, b, c);
        triangleHeights[1] = getHeight(b, c, a);
        triangleHeights[2] = getHeight(c, a, b);
        Arrays.sort(triangleHeights);

        return triangleHeights;
    }

    private static double getHeight(double a, double b, double c) {
        double halfPerimeter = (a + b + c) / 2;
        double area = Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
        return 2 * area / c;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        double[] triangleMedians = new double[3];

        if (a + b <= c || a + c <= b || c + b <= a) {
            return new double[0];
        }

        triangleMedians[0] = Math.sqrt((2 * b * b + 2 * c * c - a * a) / 4);
        triangleMedians[1] = Math.sqrt((2 * a * a + 2 * c * c - b * b) / 4);
        triangleMedians[2] = Math.sqrt((2 * a * a + 2 * b * b - c * c) / 4);

        Arrays.sort(triangleMedians);

        return triangleMedians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        double[] triangleBisectors = new double[3];

        if (a + b <= c || a + c <= b || c + b <= a) {
            return new double[0];
        }

        triangleBisectors[0] = Math.sqrt(b * c * (1 - Math.pow(a, 2) / Math.pow(b + c, 2)));
        triangleBisectors[1] = Math.sqrt(a * c * (1 - Math.pow(b, 2) / Math.pow(a + c, 2)));
        triangleBisectors[2] = Math.sqrt(a * b * (1 - Math.pow(c, 2) / Math.pow(a + b, 2)));

        Arrays.sort(triangleBisectors);

        return triangleBisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        double[] triangleAngles = new double[3];

        if (a + b <= c || a + c <= b || c + b <= a) {
            return new double[0];
        }

        double cosA = (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c);
        double cosB = (Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c);
        double cosC = (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b);

        triangleAngles[0] = Math.acos(cosA) * 180 / Math.PI;
        triangleAngles[1] = Math.acos(cosB) * 180 / Math.PI;
        triangleAngles[2] = Math.acos(cosC) * 180 / Math.PI;

        Arrays.sort(triangleAngles);

        return triangleAngles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (isInorrectValue(a, b, c)) {
            return -1;
        }

        double halfPerimeter = (a + b + c) / 2;
        double area = Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));

        return area / halfPerimeter;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (isInorrectValue(a, b, c)) {
            return -1;
        }

        double halfPerimeter = (a + b + c) / 2;
        return (a * b * c) /
                (4 * Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c)));
    }

    private static boolean isInorrectValue(double a, double b, double c) {
        return (a + b <= c || a + c <= b || c + b <= a);
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        //        Место для вашего кода

        return 0; // Заглушка. При реализации - удалить
    }
}
