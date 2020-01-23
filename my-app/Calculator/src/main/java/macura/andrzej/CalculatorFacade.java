package macura.andrzej;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Logger;

public class CalculatorFacade {
	final static Logger logger = Logger.getLogger("Andrzej");
	private  ICalculator calc;
	public CalculatorFacade()
	{
		calc = Calculator.getInstance();
	}
	public  String calculate(String equesion)
	{
		Double result;
		try {
			logger.info("Calculating Started");
			logger.info("Converting to onp");
			String Onp = Converter.toOnpFromInfix(equesion);
			logger.info("Calculating ");
			result = Converter.calculateFromOnp(Onp,calc);
			logger.info("returning " + result);
		}
		catch (EmptyStackException e)
		{
			logger.warning("zla ilosc argumentow");
			return "zla ilosc argumentow ";
		}


		return result.toString();
	}


}
