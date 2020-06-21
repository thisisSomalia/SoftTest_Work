package test06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class COVIDFromCSVFileTest {
	@ParameterizedTest
	@CsvFileSource(resources = "/新冠肺炎自助测试用例.csv",numLinesToSkip=1)
	void testNormalBoundary(Integer num,Boolean a,Boolean b,Boolean c,Boolean d,String value) {
		assertEquals(COVID.detection(a, b, c, d), value);
	}

}
