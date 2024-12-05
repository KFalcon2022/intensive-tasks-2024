package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

import static java.lang.Math.*;

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
        //Test getAreaByHeron
        System.out.println("Test method: getAreaByHeron");
        System.out.println("Expected: " + 30.0 + "   Recive: " + getAreaByHeron(12, 13, 5));
        System.out.println("Expected: " + 6.0 + "   Recive: " + getAreaByHeron(3, 4, 5));
        System.out.println("Expected: " + 120.0 + "   Recive: " + getAreaByHeron(17, 17, 16));
        System.out.println("Expected: " + 72.30793524918272 + "   Recive: " + getAreaByHeron(12, 13, 14));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(12, 1, 4));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(17, 1, 1));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(17, 1, 1));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(0, 10, 20));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(20, 0, 10));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(10, 20, 0));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(-1, 10, 10));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(10, -1, 10));
        System.out.println("Expected: " + -1.0 + "   Recive: " + getAreaByHeron(10, 10, -1));
        System.out.println();

        //Test getHeights
        System.out.println("Test method: getHeights");
        double[] result;
        result = getHeights(12.0, 13.0, 5.0);
        System.out.printf("%1$s%2$d \n%3$s %4$.15f \n%5$s %6$.1f \n%7$s %8$.1f \n",
                "Expected: length = 3 \t Recive: length = ", result.length,
                4.615384615384615 + "\t\t", result[0],
                5.0 + "\t\t\t\t\t\t", result[1],
                12.0 + "\t\t\t\t\t", result[2]);
        result = getHeights(3.0, 4.0, 5.0);
        System.out.printf("%1$s%2$d \n%3$s %4$.1f \n%5$s %6$.1f \n%7$s %8$.1f \n",
                "Expected: length = 3 \t Recive: length = ", result.length,
                2.4 + "\t\t\t\t\t\t", result[0],
                3.0 + "\t\t\t\t\t\t", result[1],
                4.0 + "\t\t\t\t\t\t", result[2]);
        result = getHeights(17.0, 1.0, 1.0);
        System.out.println("Expected: length = 0 \t Recive: length = " + result.length);
        result = getHeights(0.0, 10.0, 12.0);
        System.out.println("Expected: length = 0 \t Recive: length = " + result.length);
        result = getHeights(20.0, -10.0, 10.0);
        System.out.println("Expected: length = 0 \t Recive: length = " + result.length);
        System.out.println();

        //Test getMedians
        System.out.println("Test method: getMedians");
        result = getMedians(12.0, 13.0, 5.0);
        System.out.printf("%1$s%2$d \n%3$s %4$.1f \n%5$s %6$.15f \n%7$s %8$.15f \n",
                "Expected: length = 3 \t Recive: length = ", result.length,
                6.5 + "\t\t\t\t\t\t", result[0],
                7.810249675906654 + "\t\t", result[1],
                12.257650672131263 + "\t\t", result[2]);
        result = getMedians(3.0, 4.0, 5.0);
        System.out.printf("%1$s%2$d \n%3$s %4$.1f \n%5$s %6$.15f \n%7$s %8$.15f \n",
                "Expected: length = 3 \t Recive: length = ", result.length,
                2.5 + "\t\t\t\t\t\t", result[0],
                3.605551275463989 + "\t\t", result[1],
                4.272001872658765 + "\t\t", result[2]);
        result = getMedians(17.0, 1.0, 1.0);
        System.out.println("Expected: length = 0 \t Recive: length = " + result.length);
        result = getMedians(0.0, 10.0, 12.0);
        System.out.println("Expected: length = 0 \t Recive: length = " + result.length);
        result = getMedians(20.0, -10.0, 10.0);
        System.out.println("Expected: length = 0 \t Recive: length = " + result.length);
        System.out.println();

        //Test getBisectors
        System.out.println("Test method: getBisectors");
        result = getBisectors(12.0, 13.0, 5.0);
        System.out.printf("%1$s%2$d \n%3$s %4$.15f \n%5$s %6$.15f \n%7$s %8$.15f \n",
                "Expected: length = 3 \t Recive: length = ", result.length,
                4.991341984846218 + "\t\t", result[0],
                6.009252125773315 + "\t\t", result[1],
                12.237646832622683 + "\t\t", result[2]);
        result = getBisectors(3.0, 4.0, 5.0);
        System.out.printf("%1$s%2$d \n%3$s %4$.15f \n%5$s %6$.15f \n%7$s %8$.15f \n",
                "Expected: length = 3 \t Recive: length = ", result.length,
                2.4243661069253055 + "\t\t", result[0],
                3.3541019662496847 + "\t\t", result[1],
                4.216370213557839 + "\t\t", result[2]);
        result = getBisectors(17.0, 1.0, 1.0);
        System.out.println("Expected: length = 0 \t Recive: length = " + result.length);
        result = getBisectors(0.0, 18.0, 15.0);
        System.out.println("Expected: length = 0 \t Recive: length = " + result.length);
        result = getBisectors(10.0, -11.0, 8.0);
        System.out.println("Expected: length = 0 \t Recive: length = " + result.length);
        System.out.println();

        //Test getAnglesTest
        System.out.println("Test method: getAngles");
        result = getAngles(12.0, 13.0, 5.0);
        System.out.printf("%1$s%2$d \n%3$s %4$.15f \n%5$s %6$.15f \n%7$s %8$.1f \n",
                "Expected: length = 3 \t Recive: length = ", result.length,
                22.61986494804042 + "\t\t", result[0],
                67.38013505195957 + "\t\t", result[1],
                90.0 + "\t\t\t\t\t", result[2]);
        result = getAngles(3.0, 4.0, 5.0);
        System.out.printf("%1$s%2$d \n%3$s %4$.15f \n%5$s %6$.15f \n%7$s %8$.1f \n",
                "Expected: length = 3 \t Recive: length = ", result.length,
                36.86989764584401 + "\t\t", result[0],
                53.13010235415599 + "\t\t", result[1],
                90.0 + "\t\t\t\t\t", result[2]);
        result = getAngles(17.0, 1.0, 1.0);
        System.out.println("Expected: length = 0 \t Recive: length = " + result.length);
        result = getAngles(11.0, 0.0, 18.0);
        System.out.println("Expected: length = 0 \t Recive: length = " + result.length);
        result = getAngles(5.0, 8.0, -9.0);
        System.out.println("Expected: length = 0 \t Recive: length = " + result.length);
        System.out.println();

        //Test getInscribedCircleRadius
        System.out.println("Test method: InscribedCircleRadius");
        double radius;
        radius = getInscribedCircleRadius(12.0, 13.0, 5.0);
        System.out.println("Expected: radius = 2.0 \t Recive: radius = " + radius);
        radius = getInscribedCircleRadius(3.0, 4.0, 5.0);
        System.out.println("Expected: radius = 1.0 \t Recive: radius = " + radius);
        radius = getInscribedCircleRadius(17.0, 1.0, 1.0);
        System.out.println("Expected: radius = -1.0  Recive: radius = " + radius);
        radius = getInscribedCircleRadius(5.0, 0.0, 9.0);
        System.out.println("Expected: radius = -1.0  Recive: radius = " + radius);
        radius = getInscribedCircleRadius(8.0, 7.0, -13.0);
        System.out.println("Expected: radius = -1.0  Recive: radius = " + radius);
        System.out.println();

        //Test Circumradius
        System.out.println("Test method: Circumradius");
        radius = getCircumradius(12.0, 13.0, 5.0);
        System.out.println("Expected: radius = 6.5 \t Recive: radius = " + radius);
        radius = getCircumradius(3.0, 4.0, 5.0);
        System.out.println("Expected: radius = 2.5 \t Recive: radius = " + radius);
        radius = getCircumradius(17.0, 1.0, 1.0);
        System.out.println("Expected: radius = -1.0  Recive: radius = " + radius);
        radius = getCircumradius(7.0, 0.0, 19.0);
        System.out.println("Expected: radius = -1.0  Recive: radius = " + radius);
        radius = getCircumradius(-6.0, 8.0, 5.0);
        System.out.println("Expected: radius = -1.0  Recive: radius = " + radius);
        System.out.println();

        //Test getAreaAdvanced
        System.out.println("Test method: getAreaAdvanced");
        double area;
        area = getAreaAdvanced(12.0, 13.0, 5.0);
        System.out.println("Expected: area = 30.0 \t Recive: area = " + area);
        area = getAreaAdvanced(3.0, 4.0, 5.0);
        System.out.println("Expected: area = 6.0 \t Recive: area = " + area);
        area = getAreaAdvanced(17.0, 1.0, 1.0);
        System.out.println("Expected: area = -1.0 \t Recive: area = " + area);
        area = getAreaAdvanced(7.0, -9.0, 10.0);
        System.out.println("Expected: area = -1.0 \t Recive: area = " + area);
        area = getAreaAdvanced(0.0, 8.0, 16.0);
        System.out.println("Expected: area = -1.0 \t Recive: area = " + area);
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
        if (checkArguments(a, b, c)) {
            return -1;
        }

        double p = 0.5 * (a + b + c);
        return sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (checkArguments(a, b, c)) {
            return new double[]{};
        }

        double p = (a + b + c) / 2;
        double rootOfSemiPerimeter = sqrt(p * (p - a) * (p - b) * (p - c));
        double hA = 2 / a * rootOfSemiPerimeter;
        double hB = 2 / b * rootOfSemiPerimeter;
        double hC = 2 / c * rootOfSemiPerimeter;
        double[] heights = {hA, hB, hC};
        Arrays.sort(heights);
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
        if (checkArguments(a, b, c)) {
            return new double[]{};
        }

        double mA = 1.0 / 2 * sqrt(2 * c * c + 2 * b * b - a * a);
        double mB = 1.0 / 2 * sqrt(2 * c * c + 2 * a * a - b * b);
        double mC = 1.0 / 2 * sqrt(2 * a * a + 2 * b * b - c * c);
        double[] medians = {mA, mB, mC};
        Arrays.sort(medians);
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
        if (checkArguments(a, b, c)) {
            return new double[]{};
        }

        double bA = sqrt(b * c * (b * b + 2 * b * c + c * c - a * a)) / (b + c);
        double bB = sqrt(a * c * (a * a + 2 * a * c + c * c - b * b)) / (a + c);
        double bC = sqrt(b * a * (b * b + 2 * b * a + a * a - c * c)) / (b + a);
        double[] bisectors = {bA, bB, bC};
        Arrays.sort(bisectors);
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
        if (checkArguments(a, b, c)) {
            return new double[]{};
        }

        double anglesAlfa = acos((b * b + c * c - a * a) / (2 * b * c)) * 180 / PI;
        double anglesBeta = acos((a * a + c * c - b * b) / (2 * a * c)) * 180 / PI;
        double anglesGamma = acos((a * a + b * b - c * c) / (2 * b * a)) * 180 / PI;
        double[] angles = {anglesAlfa, anglesBeta, anglesGamma};
        Arrays.sort(angles);
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
        if (checkArguments(a, b, c)) {
            return -1;
        }

        double semiPerimeter = (a + b + c) / 2;
        return getAreaByHeron(a, b, c) / semiPerimeter;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (checkArguments(a, b, c)) {
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
        if (checkArguments(a, b, c)) {
            return -1;
        }

        double cosAlfa = (b * b + c * c - a * a) / (2 * b * c);
        double sinAlfa = sqrt(1 - cosAlfa * cosAlfa); //S = 1/2 * b * c * sinAlfa - угол между b и с, напротив a
        return 0.5 * b * c * sinAlfa;
    }

    static boolean checkArguments(double a, double b, double c) {
        return a <= 0.0 || b <= 0.0 || c <= 0.0 || (a + b) <= c || (a + c) <= b || (b + c) <= a;
    }
}
