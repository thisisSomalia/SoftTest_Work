import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;


class JudgeTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/新冠建议判断测试用例.csv",numLinesToSkip = 1)
    void judge(String symptom,String contact,String result) {
        assertEquals(Judge.judge(symptom, contact),result);
    }
}
