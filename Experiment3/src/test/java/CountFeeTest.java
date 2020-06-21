import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CountFeeTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/电话费等价类测试用例.csv", numLinesToSkip = 1)
    void countFee(String startime,String endtime,String result) throws Exception {
        assertEquals(CountFee.count(startime, endtime),result);
    }
}