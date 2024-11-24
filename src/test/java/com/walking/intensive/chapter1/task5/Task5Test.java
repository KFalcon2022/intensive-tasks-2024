package com.walking.intensive.chapter1.task5;

import org.junit.jupiter.api.Test;

import static com.walking.intensive.chapter1.task5.Task5.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task5Test {

    @Test
    void getAreaByHeronTest() {
        assertEquals(30.0, getAreaByHeron(12, 13, 5), 1e-10);
        assertEquals(6.0, getAreaByHeron(3, 4, 5), 1e-10);
        assertEquals(120.0, getAreaByHeron(17, 17, 16), 1e-10);
        assertEquals(72.30793524918272, getAreaByHeron(12, 13, 14), 1e-10);
        assertEquals(-1.0, getAreaByHeron(12, 1, 4));
        assertEquals(-1.0, getAreaByHeron(17, 1, 1));
        assertEquals(-1.0, getAreaByHeron(17, 1, 1));
        assertEquals(-1.0, getAreaByHeron(0, 10, 20));
        assertEquals(-1.0, getAreaByHeron(20, 0, 10));
        assertEquals(-1.0, getAreaByHeron(10, 20, 0));
        assertEquals(-1.0, getAreaByHeron(-1, 10, 10));
        assertEquals(-1.0, getAreaByHeron(10, -1, 10));
        assertEquals(-1.0, getAreaByHeron(10, 10, -1));
    }

    @Test
    void getHeightsTest() {
        assertArrayEquals(new double[]{4.615384615384615, 5.0, 12.0}, getHeights(12, 13, 5), 1e-10);
        assertArrayEquals(new double[]{2.4, 3.0, 4.0}, getHeights(3, 4, 5), 1e-10);
        assertArrayEquals(new double[]{}, getHeights(17, 1, 1));
        assertArrayEquals(new double[]{}, getHeights(0, 10, 12));
        assertArrayEquals(new double[]{}, getHeights(20, -10, 10));

    }

    @Test
    void getMediansTest() {
        assertArrayEquals(new double[]{6.5, 7.810249675906654, 12.257650672131263}, getMedians(12, 13, 5), 1e-10);
        assertArrayEquals(new double[]{2.5, 3.605551275463989, 4.272001872658765}, getMedians(3, 4, 5), 1e-10);
        assertArrayEquals(new double[]{}, getMedians(17, 1, 1));
        assertArrayEquals(new double[]{}, getMedians(17, 0, 20));
        assertArrayEquals(new double[]{}, getMedians(-8, 7, 6));
    }

    @Test
    void getBisectorsTest() {
        assertArrayEquals(new double[]{4.991341984846218, 6.009252125773315, 12.237646832622683},
                getBisectors(12, 13, 5), 1e-10);
        assertArrayEquals(new double[]{2.4243661069253055, 3.3541019662496847, 4.216370213557839},
                getBisectors(3, 4, 5), 1e-10);
        assertArrayEquals(new double[]{}, getBisectors(17, 1, 1));
        assertArrayEquals(new double[]{}, getBisectors(0, 18, 15));
        assertArrayEquals(new double[]{}, getBisectors(10, -11, 8));
    }

    @Test
    void getAnglesTest() {
        assertArrayEquals(new double[]{22.61986494804042, 67.38013505195957, 90.0}, getAngles(12, 13, 5), 1e-10);
        assertArrayEquals(new double[]{36.86989764584401, 53.13010235415599, 90.0}, getAngles(3, 4, 5), 1e-10);
        assertArrayEquals(new double[]{}, getAngles(17, 1, 1));
        assertArrayEquals(new double[]{}, getAngles(11, 0, 18));
        assertArrayEquals(new double[]{}, getAngles(5, 8, -9));
    }

    @Test
    void getInscribedCircleRadiusTest() {
        assertEquals(2.0, getInscribedCircleRadius(12, 13, 5), 1e-10);
        assertEquals(1.0, getInscribedCircleRadius(3, 4, 5), 1e-10);
        assertEquals(-1.0, getInscribedCircleRadius(17, 1, 1));
        assertEquals(-1.0, getInscribedCircleRadius(5, 0, 9));
        assertEquals(-1.0, getInscribedCircleRadius(8, 7, -13));
    }

    @Test
    void getCircumradiusTest() {
        assertEquals(6.5, getCircumradius(12, 13, 5), 1e-10);
        assertEquals(2.5, getCircumradius(3, 4, 5), 1e-10);
        assertEquals(-1.0, getCircumradius(17, 1, 1));
        assertEquals(-1.0, getCircumradius(7, 0, 19));
        assertEquals(-1.0, getCircumradius(-6, 8, 5));
    }

    @Test
    void getAreaAdvancedTest() {
        assertEquals(30.0, getAreaAdvanced(12, 13, 5), 1e-10);
        assertEquals(6.0, getAreaAdvanced(3, 4, 5), 1e-10);
        assertEquals(-1.0, getAreaAdvanced(17, 1, 1));
        assertEquals(-1.0, getAreaAdvanced(7, -9, 10));
        assertEquals(-1.0, getAreaAdvanced(0, 8, 16));
    }
}
