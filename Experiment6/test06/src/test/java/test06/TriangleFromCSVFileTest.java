package test06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class TriangleFromCSVFileTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/三角形一般边界测试用例.csv",numLinesToSkip=1)
	void testNormalBoundary(Integer num,Integer a,Integer b,Integer c,String type) {
		assertEquals(Triangle.classify(a, b, c), type);
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/三角形最坏情况测试用例.csv",numLinesToSkip=1)
	void testWorstCaseBoundary(Integer num,Integer a,Integer b,Integer c,String type) {
		assertEquals(Triangle.classify(a, b, c), type);
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/三角形健壮测试用例.csv",numLinesToSkip=1)
	void testRobustBoundary(Integer num,Integer a,Integer b,Integer c,String type) {
		assertEquals(Triangle.classify(a, b, c), type);
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/三角形健壮性最坏情况测试用例.csv",numLinesToSkip=1)
	void testRobustWorstCaseBoundary(Integer num,Integer a,Integer b,Integer c,String type) {
		assertEquals(Triangle.classify(a, b, c), type);
	}
}