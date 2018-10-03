package javatutorials.datatypes;

import org.testng.annotations.Test;

public class DefaultVariableValues {
	
	byte byteVariable;
	short shortVariable;
	int integerVariable;
	long longVariable;
	float floatVariable;
	double doubleVariable;
	boolean booleanVariable;
	char charVariable;

	@Test
	public void getDefaultVariableValues() {
		System.out.println("Byte Value: " + byteVariable);
		System.out.println("Short Value: " + shortVariable);
		System.out.println("Int Value: " + integerVariable);
		System.out.println("Long Value: " + longVariable);
		System.out.println("Float Value: " + floatVariable);
		System.out.println("Double Value: " + doubleVariable);
		System.out.println("Boolean Value: " + booleanVariable);
		System.out.println("Char Value: " + charVariable);
	}
	@Test
	public void oneMoreMethod() {
		System.out.println("Int Value: " + integerVariable);
	}
}