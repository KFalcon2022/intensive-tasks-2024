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
        double Area;
        if (a < 1 | b < 1 | c < 1) {
            return -1;
        } else if (a > (b + c) | b > (a + c) | c > (a + b)) {
            return -1;
        }
        double Perimetr = a + b + c;
        double HalfPerimetr = Perimetr / 2;
        Area = Math.sqrt(HalfPerimetr * (HalfPerimetr - a) * (HalfPerimetr - b) * (HalfPerimetr - c));
        return Area;
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        double[] emptyArr = new double[0];
        double[] arr = new double[3];
        double Area = getAreaByHeron(a, b, c);
        double tmp;

        if (a < 1 | b < 1 | c < 1) {
            return emptyArr;
        } else if (a > (b + c) | b > (a + c) | c > (a + b)) {
            return emptyArr;
        }

        arr[0] = (2 * Area) / a;
        arr[1] = (2 * Area) / b;
        arr[2] = (2 * Area) / c;

        if (arr[0] > arr[1]) {
            tmp = arr[0];
            arr[0] = arr[1];
            arr[1] = tmp;
        }
        if (arr[0] > arr[2]) {
            tmp = arr[0];
            arr[0] = arr[2];
            arr[2] = tmp;
        }
        if (arr[1] > arr[2]) {
            tmp = arr[1];
            arr[1] = arr[2];
            arr[2] = tmp;
        }
        return arr;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        double[] emptyArr = new double[0];
        double[] arr = new double[3];
        double tmp;


        if (a < 1 | b < 1 | c < 1) {
            return emptyArr;
        } else if (a > (b + c) | b > (a + c) | c > (a + b)) {
            return emptyArr;
        }

        arr[0] = Math.sqrt(2 * a * a + 2 * b * b - c * c) / 2;
        arr[1] = Math.sqrt(2 * a * a + 2 * c * c - b * b) / 2;
        arr[2] = Math.sqrt(2 * c * c + 2 * b * b - a * a) / 2;

        if (arr[0] > arr[1]) {
            tmp = arr[0];
            arr[0] = arr[1];
            arr[1] = tmp;
        }
        if (arr[0] > arr[2]) {
            tmp = arr[0];
            arr[0] = arr[2];
            arr[2] = tmp;
        }
        if (arr[1] > arr[2]) {
            tmp = arr[1];
            arr[1] = arr[2];
            arr[2] = tmp;
        }

        return arr;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        double[] emptyArr = new double[0];
        double[] arr = new double[3];
        double tmp;
        double Perimetr = a + b + c;
        double HalfPerimetr = Perimetr / 2;

        if (a < 1 | b < 1 | c < 1) {
            return emptyArr;
        } else if (a > (b + c) | b > (a + c) | c > (a + b)) {
            return emptyArr;
        }

        arr[0] = (2 * Math.sqrt(a * b * HalfPerimetr * (HalfPerimetr - c))) / (a + b);
        arr[1] = (2 * Math.sqrt(a * c * HalfPerimetr * (HalfPerimetr - b))) / (a + c);
        arr[2] = (2 * Math.sqrt(c * b * HalfPerimetr * (HalfPerimetr - a))) / (c + b);

        if (arr[0] > arr[1]) {
            tmp = arr[0];
            arr[0] = arr[1];
            arr[1] = tmp;
        }
        if (arr[0] > arr[2]) {
            tmp = arr[0];
            arr[0] = arr[2];
            arr[2] = tmp;
        }
        if (arr[1] > arr[2]) {
            tmp = arr[1];
            arr[1] = arr[2];
            arr[2] = tmp;
        }
        return arr;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        double[] emptyArr = new double[0];
        double[] arr = new double[3];
        double tmp;


        if (a < 1 | b < 1 | c < 1) {
            return emptyArr;
        } else if (a > (b + c) | b > (a + c) | c > (a + b)) {
            return emptyArr;
        }

        arr[0] = Math.toDegrees(Math.acos(((b * b) + (c * c) - (a * a)) / (2 * b * c)));
        arr[1] = Math.toDegrees(Math.acos(((a * a) + (c * c) - (b * b)) / (2 * a * c)));
        arr[2] = Math.toDegrees(Math.acos(((b * b) + (a * a) - (c * c)) / (2 * b * a)));

        if (arr[0] > arr[1]) {
            tmp = arr[0];
            arr[0] = arr[1];
            arr[1] = tmp;
        }
        if (arr[0] > arr[2]) {
            tmp = arr[0];
            arr[0] = arr[2];
            arr[2] = tmp;
        }
        if (arr[1] > arr[2]) {
            tmp = arr[1];
            arr[1] = arr[2];
            arr[2] = tmp;
        }
        return arr;

    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        double Perimetr = a + b + c;
        double HalfPerimetr = Perimetr / 2;

        if (a < 1 | b < 1 | c < 1) {
            return -1;
        } else if (a > (b + c) | b > (a + c) | c > (a + b)) {
            return -1;
        }

        return Math.sqrt(((HalfPerimetr - a) * (HalfPerimetr - b) * (HalfPerimetr - c)) / HalfPerimetr);

    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        double Perimetr = a + b + c;
        double HalfPerimetr = Perimetr / 2;

        if (a < 1 | b < 1 | c < 1) {
            return -1;
        } else if (a > (b + c) | b > (a + c) | c > (a + b)) {
            return -1;
        }

        return (a * b * c) / (4 * Math.sqrt(HalfPerimetr * (HalfPerimetr - a) * (HalfPerimetr - b) * (HalfPerimetr - c)));

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
