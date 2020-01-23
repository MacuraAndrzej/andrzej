package macura.andrzej;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.BeforeClass;

import static junit.framework.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class CalculatorTest
{
    static Calculator calculator;
    @BeforeClass
    public static void initialize()
    {
        calculator= Calculator.getInstance();
    }


    @org.junit.Test
    public void testSum()
    {
        assertTrue( calculator.sum(2.,2.)==4 );
    }
    @org.junit.Test
    public void testSub()
    {
        assertTrue( calculator.subtraction(2.,2.)==0  );
    }
    @org.junit.Test
    public void testMult() {
        assertTrue(calculator.multiply(2., 3.) == 6);
    }
    @org.junit.Test
    public void testDiv()
    {
        assertTrue( calculator.divide(3., 6.) == 2 );
    }
    @org.junit.Test
    public void testPow()
    {
        assertTrue( calculator.power(3., 3.) == 27 );
    }
    @org.junit.Test
    public void testSqrt()
    {
        assertTrue(calculator.sqrt(4.)==2);   }
}
