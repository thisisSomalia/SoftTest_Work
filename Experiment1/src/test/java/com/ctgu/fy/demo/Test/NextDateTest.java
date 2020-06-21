package com.ctgu.fy.demo.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;


class NextDateTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/nextDate边界值测试用例.csv", numLinesToSkip = 1)//一般边界值分析
    void nextDateTest1(Integer num,Integer a,Integer b,Integer c,String type) throws Exception {
        assertEquals(NextDate.nextDate(a,b,c),type);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/nextDate健壮性测试用例.csv", numLinesToSkip = 1)//健壮性边界值分析
    void nextDateTest2(Integer num,Integer a,Integer b,Integer c,String type) throws Exception {
        assertEquals(NextDate.nextDate(a,b,c),type);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/nextDate最坏情况测试用例.csv", numLinesToSkip = 1)//三角形最坏情况测试
    void nextDateTest3(Integer num,Integer a,Integer b,Integer c,String type) throws Exception {
        assertEquals(NextDate.nextDate(a,b,c),type);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/nextDate最坏健壮性测试用例.csv", numLinesToSkip = 1)//三角形最坏健壮情况测试
    void nextDateTest4(Integer num,Integer a,Integer b,Integer c,String type) throws Exception {
        assertEquals(NextDate.nextDate(a,b,c),type);
    }
}
