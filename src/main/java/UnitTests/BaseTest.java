package UnitTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.epam.tat.module4.Calculator;

public class BaseTest {

	static Calculator calculator = new Calculator();

	@BeforeClass
	public static void setUp() {
		calculator = new Calculator();
	}

	@AfterClass
	public static void tearDown() {
		calculator = null;
	}
}
