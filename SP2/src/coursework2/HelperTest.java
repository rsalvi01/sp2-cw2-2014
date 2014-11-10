package coursework2;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelperTest {

	@Test
	public void isOperator()
	{
		assertTrue(Helper.isOperator("/"));
	}	
	
	@Test
	public void isModifier()
	{
		assertTrue(Helper.isModifier("Neg"));
	}
	
	@Test
	public void isFraction()
	{
		assertTrue(Helper.isFraction("1/0"));
	}
	
}
