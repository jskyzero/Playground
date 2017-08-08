import static org.junit.Assert.*;
import org.junit.Test;

public class UnboundedTest
{
	
	@Test 
	public void testHello()
	{
		assertEquals("Hello World!", "Hello World!");
	}
}
// javac -classpath .:junit-4.9.jar HelloWorldTest.java
// java -classpath .:junit-4.9.jar -ea org.junit.runner.JUnitCore HelloWorldTest
