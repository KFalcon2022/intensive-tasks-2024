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
//        Для собственных проверок можете делать любые изменения в этом методе

        // Пример для формулы Герона
        double triangleArea = getAreaByHeron(3, 4, 5);

        if (triangleArea != -1) {
            System.out.println("Площадь треугольника: " + triangleArea);
        } else {
            System.out.println("Некорректные данные для сторон треугольника.");
        }

        // Пример для нахождения высот треугольника
        double[] heights = getHeights(3, 4, 5);
        if (heights.length > 0) {
            System.out.println("Высоты треугольника по возрастанию: " + Arrays.toString(heights));
        } else {
            System.out.println("Некорректные данные для сторон треугольника.");
        }

        // Пример нахождения медиан треугольника
        double[] medians = getMedians(3, 4, 5);
        if (medians.length > 0) {
            System.out.println("Медианы треугольника по возрастанию: " + Arrays.toString(medians));
        } else {
            System.out.println("Некорректные данные для сторон треугольника.");
        }

        // Пример нахождения биссектрис треугольника
        double[] bisectors = getBisectors(3, 4, 5);
        if (bisectors.length > 0) {
            System.out.println("Биссектрисы треугольника по возрастанию: " + Arrays.toString(bisectors));
        } else {
            System.out.println("Некорректные данные для сторон треугольника.");
        }

        // Пример нахождения углов треугольника
        double[] angles = getAngles(3, 4, 5);
        if (angles.length > 0) {
            System.out.println("Углы треугольника по возрастанию: " + Arrays.toString(angles));
        } else {
            System.out.println("Некорректные данные для сторон треугольника.");
        }

        // Пример нахождения радиуса вписанной окружности
        double inscribedRadius = getInscribedCircleRadius(3, 4, 5);
        if (inscribedRadius != -1) {
            System.out.println("Радиус вписанной окружности: " + inscribedRadius);
        } else {
            System.out.println("Некорректные данные для сторон треугольника.");
        }

        // Пример нахождения радиуса описанной окружности
        double circumscribedRadius = getInscribedCircleRadius(3, 4, 5);
        if (circumscribedRadius != -1) {
            System.out.println("Радиус описанной окружности: " + circumscribedRadius);
        } else {
            System.out.println("Некорректные данные для сторон треугольника.");
        }

        // Пример нахождения площади треугольника (дополнительно)
        double triangleAreaAdvanced = getAreaAdvanced(3, 4, 5);
        if (triangleAreaAdvanced != -1) {
            System.out.println("Площадь треугольника: " + triangleAreaAdvanced);
        } else {
            System.out.println("Некорректные данные для сторон треугольника.");
        }
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

        // Проверка корректности входных данных
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            return -1; // Некорректные данные
        }

        // Полу периметр
        double semiPerimeterValue = (a + b + c) / 2;

        // Площадь по формуле Герона
        return Math.sqrt(semiPerimeterValue * (semiPerimeterValue - a) *
                (semiPerimeterValue - b) * (semiPerimeterValue - c));
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

        // Проверка корректности входных данных
        if (a <= 0 || b <= 0 || c <= 0 ||
                a + b <= c || a + c <= b || b + c <= a) {
            return new double[0]; // Некорректные данные
        }

        // Вычисление площади по формуле Герона
        double s = (a + b + c) / 2;
        double triangleArea = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        // Вычисление высот
        double triangleHeightSideA = (2 * triangleArea) / a;
        double triangleHeightSideB = (2 * triangleArea) / b;
        double triangleHeightSideC = (2 * triangleArea) / c;

        // Создание массива высот
        double[] arrayHeights = {triangleHeightSideA, triangleHeightSideB, triangleHeightSideC};

        // Сортировка высот по возрастанию
        Arrays.sort(arrayHeights);

        return arrayHeights;

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

        // Проверка корректности входных данных
        if (a <= 0 || b <= 0 || c <= 0 ||
                a + b <= c || a + c <= b || b + c <= a) {
            return new double[0]; // Некорректные данные
        }

        // Вычисление медиан
        double medianSideA = 0.5 * Math.sqrt(2 * Math.pow(b, 2) + 2 * Math.pow(c, 2) - Math.pow(a, 2));
        double medianSideB = 0.5 * Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(c, 2) - Math.pow(b, 2));
        double medianSideC = 0.5 * Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(b, 2) - Math.pow(c, 2));

        // Создание массива медиан
        double[] arrayMedians = {medianSideA, medianSideB, medianSideC};

        // Сортировка медиан по возрастанию
        Arrays.sort(arrayMedians);

        return arrayMedians;
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

        // Проверка корректности входных данных
        if (a <= 0 || b <= 0 || c <= 0 ||
                a + b <= c || a + c <= b || b + c <= a) {
            return new double[0]; // Некорректные данные
        }

        // Вычисление косинусов углов
        double cosAngleA = (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c);
        double cosAngleB = (Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c);
        double cosAngleC = (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b);

        // Проверка на допустимость значения косинуса
        if (cosAngleA < -1 || cosAngleA > 1 || cosAngleB < -1
                || cosAngleB > 1 || cosAngleC < -1 || cosAngleC > 1) {
            return new double[0]; // Некорректные данные
        }

        // Вычисление углов
        double angleA = Math.acos(cosAngleA);
        double angleB = Math.acos(cosAngleB);
        double angleC = Math.acos(cosAngleC);

        // Вычисление биссектрис
        double bisectorSideA = (2 * b * c / (b + c)) * Math.cos(angleA / 2);
        double bisectorSideB = (2 * a * c / (a + c)) * Math.cos(angleB / 2);
        double bisectorSideC = (2 * a * b / (a + b)) * Math.cos(angleC / 2);

        // Создание массива биссектрис
        double[] arrayBisectors = {bisectorSideA, bisectorSideB, bisectorSideC};

        // Сортировка биссектрис по возрастанию
        Arrays.sort(arrayBisectors);

        return arrayBisectors;
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

        // Проверка корректности входных данных
        if (a <= 0 || b <= 0 || c <= 0 ||
                a + b <= c || a + c <= b || b + c <= a) {
            return new double[0]; // Некорректные данные
        }

        // Вычисление углов в радианах
        double radianA = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c));
        double radianB = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c));
        double radianC = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));

        // Преобразование углов в градусы
        double angleA = Math.toDegrees(radianA);
        double angleB = Math.toDegrees(radianB);
        double angleC = Math.toDegrees(radianC);

        // Создание массива углов
        double[] angles = {angleA, angleB, angleC};

        // Сортировка углов по возрастанию
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
        //        Место для вашего кода

        // Проверка корректности входных данных
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            return -1; // Некорректные данные
        }

        // Вычисление полу периметра
        double semiPerimeterValue = (a + b + c) / 2;

        // Вычисление площади по формуле Герона
        double triangleArea = Math.sqrt(semiPerimeterValue * (semiPerimeterValue - a)
                * (semiPerimeterValue - b) * (semiPerimeterValue - c));

        // Вычисление радиуса вписанной окружности
        return triangleArea / semiPerimeterValue;
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

        // Проверка корректности входных данных
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            return -1; // Некорректные данные
        }

        // Вычисление полу периметра
        double semiPerimeterValue = (a + b + c) / 2;

        // Вычисление площади по формуле Герона
        double triangleArea = Math.sqrt(semiPerimeterValue * (semiPerimeterValue - a)
                * (semiPerimeterValue - b) * (semiPerimeterValue - c));

        // Вычисление радиуса описанной окружности
        return (a * b * c) / (4 * triangleArea);
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

        // Проверка корректности входных данных
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            return -1; // Некорректные данные
        }

        // Вычисление косинуса угла C
        double cosAngleC = (Math.pow(a,2) + Math.pow(b,2) - Math.pow(c,2)) / (2 * a * b);

        // Проверка, чтобы косинус был в пределах [-1, 1]
        if (cosAngleC < -1 || cosAngleC > 1) {
            return -1; // Некорректные данные
        }

        // Вычисление синуса угла C через основное тождество
        double sinAngleC = Math.sqrt(1 - cosAngleC * cosAngleC);

        // Вычисление площади треугольника
        return 0.5 * a * b * sinAngleC;
    }
}
