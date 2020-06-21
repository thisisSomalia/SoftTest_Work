package com.ctgu.fy.demo.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;


class TriangleTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/三角形一般边界测试用例.csv", numLinesToSkip = 1)//一般边界值分析
    void triangleTest1(Integer num,Integer a,Integer b,Integer c,String type) throws Exception {
        assertEquals(Triangle.TriangleTest(a,b,c),type);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/三角形健壮性测试用例.csv", numLinesToSkip = 1)//健壮性边界值分析
    void triangleTest2(Integer num,Integer a,Integer b,Integer c,String type) throws Exception {
        assertEquals(Triangle.TriangleTest(a,b,c),type);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/三角形最坏情况测试.csv", numLinesToSkip = 1)//三角形最坏情况测试
    void triangleTest3(Integer num,Integer a,Integer b,Integer c,String type) throws Exception {
        assertEquals(Triangle.TriangleTest(a,b,c),type);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/三角形最坏健壮性测试.csv", numLinesToSkip = 1)//三角形最坏健壮情况测试
    void triangleTest4(Integer num,Integer a,Integer b,Integer c,String type) throws Exception {
        assertEquals(Triangle.TriangleTest(a,b,c),type);
    }


}
