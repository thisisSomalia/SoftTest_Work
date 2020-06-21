package com.ctgu.fy.demo.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;


class CommissionTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/commission边界值测试用例.csv", numLinesToSkip = 1)//一般边界值分析
    void commissionTest1(Integer num,Integer a,Integer b,Integer c,String type) throws Exception {
        assertEquals(Commission.comTest(a,b,c),type);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/commission健壮性测试用例.csv", numLinesToSkip = 1)//健壮性边界值分析
    void commissionTest2(Integer num,Integer a,Integer b,Integer c,String type) throws Exception {
        assertEquals(Commission.comTest(a,b,c),type);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/commission最坏情况测试用例.csv", numLinesToSkip = 1)//三角形最坏情况测试
    void commissionTest3(Integer num,Integer a,Integer b,Integer c,String type) throws Exception {
        assertEquals(Commission.comTest(a,b,c),type);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/commission最坏健壮性测试用例.csv", numLinesToSkip = 1)//三角形最坏健壮情况测试
    void commissionTest4(Integer num,Integer a,Integer b,Integer c,String type) throws Exception {
        assertEquals(Commission.comTest(a,b,c),type);
    }
}
