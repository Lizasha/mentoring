package UnitTesting.UnitTestsTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.epam.tat.module4.Calculator;

public class BaseTest {

	static Calculator calculator;

	@BeforeClass
	public static void setUp() {
		calculator = new Calculator();
	}

	@AfterClass
	public static void tearDown() {
		calculator = null;
	}
}
