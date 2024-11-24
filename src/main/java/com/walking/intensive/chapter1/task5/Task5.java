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
        double a = 12;
        double b = 13;
        double c = 5;
        System.out.println(getInscribedCircleRadius(a, b, c));
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
    static boolean getCheckData(final double a, final double b, final double c) {
        return a > 0 && b > 0 && c > 0;
    }

    static double getAreaByHeron(double a, double b, double c) {
        if (getCheckData(a, b, c)) {
            final double squareP = 0.5 * (a + b + c);
            return squareP > a && squareP > b && squareP > c ?
                    Math.sqrt(squareP * (squareP - a) * (squareP - b) * (squareP - c)) : -1.0;
        }
        return -1.0;
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (getCheckData(a, b, c)) {
            final double heightP = 0.5 * (a + b + c);
            boolean isMoreThan = heightP > a && heightP > b && heightP > c;
            if (!isMoreThan) {
                return new double[0];
            }
            double[] heightH = {(2 * Math.sqrt(heightP * (heightP - a) * (heightP - b) * (heightP - c))) / a,
                    (2 * Math.sqrt(heightP * (heightP - a) * (heightP - b) * (heightP - c))) / b,
                    (2 * Math.sqrt(heightP * (heightP - a) * (heightP - b) * (heightP - c))) / c};
            Arrays.sort(heightH);
            return heightH;
        }

        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (getCheckData(a, b, c)) {
            final double medianMA = 0.5 * Math.sqrt(2 * Math.pow(b, 2) + 2 * Math.pow(c, 2) - Math.pow(a, 2));
            final double medianMB = 0.5 * Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(c, 2) - Math.pow(b, 2));
            final double medianMC = 0.5 * Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(b, 2) - Math.pow(c, 2));

            boolean isMedians = medianMA > 0 && medianMB > 0 && medianMC > 0;
            if (!isMedians) {
                return new double[0];
            }
            double[] medianM = {medianMA, medianMB, medianMC};
            Arrays.sort(medianM);
            return medianM;
        }
        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (getCheckData(a, b, c)) {
            final double bisectorLA = Math.sqrt((a * b) * (a + b + c) * (a + b - c)) / (a + b);
            final double bisectorLB = Math.sqrt((a * c) * (a + b + c) * (a + c - b)) / (a + c);
            final double bisectorLC = Math.sqrt((c * b) * (a + b + c) * (b + c - a)) / (b + c);

            boolean isBisectorsL = bisectorLA > 0 && bisectorLB > 0 && bisectorLC > 0;
            if (!isBisectorsL) {
                return new double[0];
            }
            double[] bisectorL = {bisectorLA, bisectorLB, bisectorLC};
            Arrays.sort(bisectorL);
            return bisectorL;
        }
        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (getCheckData(a, b, c)) {
            final double angleA = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c)) * 180/Math.PI;
            final double angleC = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * c * b)) * 180/Math.PI;
            final double angleB = 180 - angleA - angleC;

            boolean isAnglesABG = angleA > 0 && angleB > 0 && angleC > 0;
            if (!isAnglesABG) {
                return new double[0];
            }
            double[] angleABG = {angleA, angleB, angleC};
            Arrays.sort(angleABG);
            return angleABG;
        }

        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (getCheckData(a, b, c)) {
            final double radP = 0.5 * (a + b + c);
            boolean isRadP = radP > a && radP > b && radP > c;
            return  isRadP ? Math.sqrt((radP - a) * (radP - b) * (radP - c) / radP) : -1;
        }
        return -1.0;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (getCheckData(a, b, c)) {
            final double radP = 0.5 * (a + b + c);
            final double payS = Math.sqrt(radP * (radP - a) * (radP - b) * (radP - c));
            return radP > a && radP > b && radP > c ? (a * b * c) / (4 * payS) : -1.0;
        }
        return -1.0;
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
        if (getCheckData(a, b, c)) {

            return 0.5 * Math.pow(a, 2) * ((Math.sin(getAngles(a, b, c)[1]) * Math.sin(getAngles(a, b, c)[2])) / Math.sin(getAngles(a, b, c)[0]));
        }
        return -1.0; // Заглушка. При реализации - удалить
    }
}
