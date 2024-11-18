package com.walking.intensive.chapter1.task5;

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
        System.out.println();
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
        if (isInvalidTriangle(a, b, c)) {
            return -1;
        }

        double p = calculateSemiperimeter(a, b, c);

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (isInvalidTriangle(a, b, c)) {
            return new double[0];
        }

        double area = getAreaByHeron(a, b, c);
        double hA = (2 * area) / a;
        double hB = (2 * area) / b;
        double hC = (2 * area) / c;

        double[] heights = {hA, hB, hC};

        insertionSort(heights);

        return heights;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (isInvalidTriangle(a, b, c)) {
            return new double[0];
        }

        double mA = calculateMedian(a, b, c);
        double mB = calculateMedian(b, a, c);
        double mC = calculateMedian(c, a, b);

        double[] medians = {mA, mB, mC};

        insertionSort(medians);

        return medians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (isInvalidTriangle(a, b, c)) {
            return new double[0];
        }

        double lA = calculateBisector(a, b, c);
        double lB = calculateBisector(b, a, c);
        double lC = calculateBisector(c, a, b);

        double[] bisectors = {lA, lB, lC};

        insertionSort(bisectors);

        return bisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (isInvalidTriangle(a, b, c)) {
            return new double[0];
        }

        double angleA = calculateAngle(b, c, a);
        double angleB = calculateAngle(a, c, b);
        double angleC = calculateAngle(a, b, c);

        double angleADegrees = Math.toDegrees(angleA);
        double angleBDegrees = Math.toDegrees(angleB);
        double angleCDegrees = Math.toDegrees(angleC);

        double[] angles = {angleADegrees, angleBDegrees, angleCDegrees};

        insertionSort(angles);

        return angles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (isInvalidTriangle(a, b, c)) {
            return -1;
        }

        return getAreaByHeron(a, b, c) / calculateSemiperimeter(a, b, c);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (isInvalidTriangle(a, b, c)) {
            return -1;
        }

        return (a * b * c) / (4 * getAreaByHeron(a, b, c));
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
        if (isInvalidTriangle(a, b, c)) {
            return -1;
        }

        double cosC = (a * a + b * b - c * c) / (2 * a * b);
        double sinC = Math.sqrt(1 - cosC * cosC);

        return 0.5 * a * b * sinC;
    }

    private static boolean isInvalidTriangle(double a, double b, double c) {
        return a <= 0 || b <= 0 || c <= 0 || (a + b <= c) || (a + c <= b) || (b + c <= a);
    }

    private static void insertionSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

    private static double calculateMedian(double a, double b, double c) {
        return 0.5 * Math.sqrt(2 * b * b + 2 * c * c - a * a);
    }

    private static double calculateBisector(double a, double b, double c) {
        return Math.sqrt(b * c * (1 - (a * a) / Math.pow(b + c, 2)));
    }

    private static double calculateAngle(double b, double c, double a) {
        return Math.acos((b * b + c * c - a * a) / (2 * b * c));
    }

    private static double calculateSemiperimeter(double a, double b, double c) {
        return (a + b + c) / 2.0;
    }
}
