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
//        Для собственных проверок можете делать любые изменения в этом методе

        System.out.println();
        System.out.println(getAreaByHeron(2,3,4));
        System.out.println();
        double[] arrayForHeights = getHeights(2,2,3);
        for (int i = 0; i < 3; i++) {
            System.out.println(arrayForHeights[i]);
        }
        System.out.println();
        double[] arrayForMedians = getMedians(2,3,4);
        for (int i = 0; i < 3; i++) {
            System.out.println(arrayForMedians[i]);
        }
        System.out.println();
        double[] arrayForBisectors = getBisectors(2,3,4);
        for (int i = 0; i < 3; i++) {
            System.out.println(arrayForBisectors[i]);
        }
        System.out.println();
        double[] arrayForAngles = getAngles(2,3,4);
        for (int i = 0; i < 3; i++) {
            System.out.println(arrayForAngles[i]);
        }
        System.out.println();
        System.out.println(getInscribedCircleRadius(2,3,4));
        System.out.println();
        System.out.println(getCircumradius(2,3,4));
        System.out.println();
        System.out.println(getAreaAdvanced(2,3,4));
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
        //        Место для вашего кода
        if ((a <= 0) || (b <= 0) || (c <= 0) || (a + b <= c) || (a + c <= b) || (b + c <= a)) {
            return -1;
        }
        else {
            double s = (a + b + c) / 2;
            return(Math.sqrt(s * (s - a) * (s - b) * (s - c)));
        }

        // return 0; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        //        Место для вашего кода
        if ((a <= 0) || (b <= 0) || (c <= 0) || (a + b <= c) || (a + c <= b) || (b + c <= a)) {
            //double [] emptyArray = new double[0];
            double [] emptyArray = new double[0];
            return emptyArray;
        }
        else {
            double s = (a + b + c) / 2;
            double heightToA = (2 * (Math.sqrt(s * (s - a) * (s - b) * (s - c)))) / a;
            double heightToB = (2 * (Math.sqrt(s * (s - a) * (s - b) * (s - c)))) / b;
            double heightToC = (2 * (Math.sqrt(s * (s - a) * (s - b) * (s - c)))) / c;

            double maxHeight = Math.max(Math.max(heightToA,heightToB),heightToC);
            double minHeight = Math.min(Math.min(heightToA,heightToB),heightToC);
            double averageHeight = 0;

            if (((minHeight == heightToA) && (maxHeight == heightToB)) || ((minHeight == heightToB) && (maxHeight == heightToA))) {
                averageHeight = heightToC;
            }
            else if (((minHeight == heightToA) && (maxHeight == heightToC)) || ((minHeight == heightToC) && (maxHeight == heightToA))) {
                averageHeight = heightToB;
            }
            else if (((minHeight == heightToB) && (maxHeight == heightToC)) || ((minHeight == heightToC) && (maxHeight == heightToB))) {
                averageHeight = heightToA;
            }

            double[] array = {minHeight,averageHeight,maxHeight};
            return(array);
        }
        // return null; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        //        Место для вашего кода
        if ((a <= 0) || (b <= 0) || (c <= 0) || (a + b <= c) || (a + c <= b) || (b + c <= a)) {
            //double [] emptyArray = new double[0];
            double [] emptyArray = new double[0];
            return emptyArray;
        }
        else {
            double medianToA = Math.sqrt(2 * b * b + 2 * c * c - a * a) / 2;
            double medianToB = Math.sqrt(2 * a * a + 2 * c * c - b * b) / 2;
            double medianToC = Math.sqrt(2 * a * a + 2 * b * b - c * c) / 2;

            double maxMedian = Math.max(Math.max(medianToA,medianToB),medianToC);
            double minMedian = Math.min(Math.min(medianToA,medianToB),medianToC);
            double averageMedian = 0;

            if (((minMedian == medianToA) && (maxMedian == medianToB)) || ((minMedian == medianToB) && (maxMedian == medianToA))) {
                averageMedian = medianToC;
            }
            else if (((minMedian == medianToA) && (maxMedian == medianToC)) || ((minMedian == medianToC) && (maxMedian == medianToA))) {
                averageMedian = medianToB;
            }
            else if (((minMedian == medianToB) && (maxMedian == medianToC)) || ((minMedian == medianToC) && (maxMedian == medianToB))) {
                averageMedian = medianToA;
            }

            double[] array = {minMedian,averageMedian,maxMedian};
            return(array);
        }
        // return null; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        //        Место для вашего кода
        if ((a <= 0) || (b <= 0) || (c <= 0) || (a + b <= c) || (a + c <= b) || (b + c <= a)) {
            //double [] emptyArray = new double[0];
            double [] emptyArray = new double[0];
            return emptyArray;
        }
        else {
            double bisectorToA = (Math.sqrt(b * c * (a + b + c) * (b + c - a))) / (b + c);
            double bisectorToB = (Math.sqrt(a * c * (a + b + c) * (a + c - b))) / (a + c);
            double bisectorToC = (Math.sqrt(a * b * (a + b + c) * (a + b - c))) / (a + b);

            double maxBisector = Math.max(Math.max(bisectorToA,bisectorToB),bisectorToC);
            double minBisector = Math.min(Math.min(bisectorToA,bisectorToB),bisectorToC);
            double averageBisector = 0;

            if (((minBisector == bisectorToA) && (maxBisector == bisectorToB)) || ((minBisector == bisectorToB) && (maxBisector == bisectorToA))) {
                averageBisector = bisectorToC;
            }
            else if (((minBisector == bisectorToA) && (maxBisector == bisectorToC)) || ((minBisector == bisectorToC) && (maxBisector == bisectorToA))) {
                averageBisector = bisectorToB;
            }
            else if (((minBisector == bisectorToB) && (maxBisector == bisectorToC)) || ((minBisector == bisectorToC) && (maxBisector == bisectorToB))) {
                averageBisector = bisectorToA;
            }

            double[] array = {minBisector,averageBisector,maxBisector};
            return(array);
        }
        // return null; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        //        Место для вашего кода
        if ((a <= 0) || (b <= 0) || (c <= 0) || (a + b <= c) || (a + c <= b) || (b + c <= a)) {
            //double [] emptyArray = new double[0];
            double [] emptyArray = new double[0];
            return emptyArray;
        }
        else {
            double cosAngleAC = (a * a + c * c - b * b) / (2 * a * c);
            double angleAC = (Math.acos(cosAngleAC))*180/Math.PI;
            double cosAngleAB = (a * a + b * b - c * c) / (2 * a * b);
            double angleAB = (Math.acos(cosAngleAB))*180/Math.PI;
            double cosAngleBC = (b * b + c * c - a * a) / (2 * b * c);
            double angleBC = (Math.acos(cosAngleBC))*180/Math.PI;

            double maxAngle = Math.max(Math.max(angleAC,angleAB),angleBC);
            double minAngle = Math.min(Math.min(angleAC,angleAB),angleBC);
            double averageAngle = 0;

            if (((minAngle == angleAC) && (maxAngle == angleAB)) || ((minAngle == angleAB) && (maxAngle == angleAC))) {
                averageAngle = angleBC;
            }
            else if (((minAngle == angleAC) && (maxAngle == angleBC)) || ((minAngle == angleBC) && (maxAngle == angleAC))) {
                averageAngle = angleAB;
            }
            else if (((minAngle == angleAB) && (maxAngle == angleBC)) || ((minAngle == angleBC) && (maxAngle == angleAB))) {
                averageAngle = angleAC;
            }

            double[] array = {minAngle,averageAngle,maxAngle};
            return(array);
        }

        // return null; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        //        Место для вашего кода

        if ((a <= 0) || (b <= 0) || (c <= 0) || (a + b <= c) || (a + c <= b) || (b + c <= a)) {
            return -1;
        }
        else {
            double s = (a + b + c) / 2;
            return(Math.sqrt((s - a) * (s - b) * (s - c) / s));
        }

        // return 0; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        //        Место для вашего кода
        if ((a <= 0) || (b <= 0) || (c <= 0) || (a + b <= c) || (a + c <= b) || (b + c <= a)) {
            return -1;
        }
        else {
            double s = (a + b + c) / 2;
            return((a * b * c) / (4 * Math.sqrt(s * (s - a) * (s - b) * (s - c))));
        }

        // return 0; // Заглушка. При реализации - удалить
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
        if ((a <= 0) || (b <= 0) || (c <= 0) || (a + b <= c) || (a + c <= b) || (b + c <= a)) {
            return -1;
        }
        else {
            double cosAngleBC = (b * b + c * c - a * a) / (2 * b * c);
            double sinAngleBC = Math.sqrt(1 - cosAngleBC);
            return((b * c * sinAngleBC) / 2);
        }

        // return 0; // Заглушка. При реализации - удалить
    }
}
