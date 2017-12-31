import static org.junit.Assert.*;
import org.junit.Test;

public class HelloWorldTest
{
	public HelloWorld HW = new HelloWorld();
	
	@Test 
	public void testHello()
	{
		HW.hello();
		assertEquals("Hello World!", HW.getStr());
	}
}
// javac -classpath .:junit-4.9.jar HelloWorldTest.java
// java -classpath .:junit-4.9.jar -ea org.junit.runner.JUnitCore HelloWorldTest
