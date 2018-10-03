package javatutorials.datatypes;

import org.testng.annotations.Test;

public class StringDemo {

	@Test
	public void StringDemo() {
		// String Literal - String Constant Pool
		String str1 = "Hello";
		
		String str3 = "Hello";
		
		// String Object - Heap
		String str2 = new String("Welcome");
		
		String str4 = new String("Welcome");
		
		// Strings
		
		str1 = "More Hello";
		
		String stradd = str1 + str2;
	}

}
