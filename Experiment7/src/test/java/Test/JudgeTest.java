package Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;


class JudgeTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/测试用例.csv",numLinesToSkip = 1)
    void judge(String symptom,String contact,String result) {
        Assertions.assertEquals(Judge.judge(symptom, contact),result);
    }
}