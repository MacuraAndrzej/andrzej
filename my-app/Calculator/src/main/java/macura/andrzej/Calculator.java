package macura.andrzej;

import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class Calculator implements ICalculator 
{
	final static Logger logger = Logger.getLogger("Calculator.class");
	private static Calculator calc;
	private Calculator()
	{

	}
	public static Calculator getInstance()
	{
		if (calc ==null )
		{
			calc = new Calculator();
			return calc;
		}
		else
		{
			return calc;
		}
	}


	public double sum(double x, double y) {
		return x+y;
	}
	public double subtraction(double x, double y) {
		return y - x;
	}
	public double multiply(double x, double y) {
		return x*y;
	}
	public double divide(double x, double y) {
		return y/x;
	}
	public double power(double x , double y)
	{
		return Math.pow(y,x);
	}
	public double sqrt(double x)
	{
		return Math.sqrt(x);
	}

}
