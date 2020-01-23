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
			result = calculateFromOnp(Onp);
			logger.info("returning " + result);
		}
		catch (EmptyStackException e)
		{
			logger.warning("zla ilosc argumentow");
			return "zla ilosc argumentow ";
		}


		return result.toString();
	}
	private  Double calculateFromOnp(String OnpEquesion)
	{

		Double result = Double.valueOf(0);
		Scanner input = new Scanner(OnpEquesion);
		Stack<Double> stos = new Stack<Double>();
		while(input.hasNext())
		{
			String operator = input.next();
			try {
				Double num = Double.parseDouble(operator);
				stos.push(num);
			}
			catch (NumberFormatException e) {

				switch (operator){
					case "+":
						result =calc.sum(stos.pop(),stos.pop());
						stos.push(result);
						break;
					case "-":
						result =calc.subtraction(stos.pop(),stos.pop());
						stos.push(result);
						break;
					case "*":
						result =calc.multiply(stos.pop(),stos.pop());
						stos.push(result);
						break;
					case "/":
						result =calc.divide(stos.pop(),stos.pop());
						stos.push(result);
						break;
					case "pow":
						result =calc.power(stos.pop(),stos.pop());
						stos.push(result);
						break;
					case "sqrt":
						result =calc.sqrt(stos.pop());
						stos.push(result);
						break;




				}
			}
		}
		return result;

		}

}
