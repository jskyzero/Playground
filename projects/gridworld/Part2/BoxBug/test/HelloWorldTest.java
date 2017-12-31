import static org.junit.Assert.*;
import org.junit.Test;

public class HelloWorldTest
{
	
	@Test 
	public void testHello()
	{
		assertEquals("Hello World!", "Hello World!");
	}
}


// in shell you can use 
// javac -classpath .:junit-4.9.jar HelloWorldTest.java
// java -classpath .:junit-4.9.jar -ea org.junit.runner.JUnitCore HelloWorldTest
