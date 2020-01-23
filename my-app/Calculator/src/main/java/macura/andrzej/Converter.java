package macura.andrzej;
import java.util.Scanner;
import java.util.Stack;

public abstract class Converter {
	public static String toOnpFromInfix(String equesion)
	{
		
		Scanner input = new Scanner(equesion);
		Stack<String> stos = new Stack<String>(); 
		String result = "";
		while(input.hasNext())
		{
			String operator = input.next();
			try {
	            Integer num = Integer.parseInt(operator);
	            result = result +' '+ num;
			}
			catch (NumberFormatException e) {
				if(isFunction(operator))
				{
					stos.push(operator);
					continue;
				}
				else if(isBracket(operator))
				{
					if(isLeftBracket(operator))
					{
						stos.push(operator);
					}
					else
					{
						while(!isBracket(stos.peek()))
						{
							result=result + " "+ stos.pop();
						}
						stos.pop();
						if(!stos.empty()&&isFunction(stos.peek()))
						{
							result=result + " "+ stos.pop();
						}
						
					}
				}
				else {
					if(stos.isEmpty())
					{ 
						stos.push(operator);
						continue;
					}
				
					int weight = getWeight(operator);
					while(!stos.isEmpty()&&getWeight(stos.peek())>=weight)
					{
						result=result + " "+ stos.pop();
					}
						//result=result + stos.pop();
						stos.push(operator);

				}
			}
	            		
			
		}
		while(!stos.isEmpty())
		{
			result=result + " "+ stos.pop();
		}
		return result;
		
	}
	public static String toInfixFromOnp(String equesion)
	{
		return "x";
	}
	private static boolean isFunction(String s)
	{
		return s.length()>1;
	}
	private static int getWeight(String operator)
	{
		
		if(isFunction(operator))
		{
			return 4;
		}
		char c = operator.charAt(0);
		switch (c){
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		case '(':
			return 0;
		case ')':
			return 4;

		}
		return 0;
	}
	private static boolean isBracket(String operator)
	{
		return operator.compareTo("(")==0 || operator.compareTo(")")==0;
	}
	private static boolean isLeftBracket(String operator)
	{
		return operator.compareTo("(")==0;
	}
	public static  Double calculateFromOnp(String OnpEquesion,ICalculator calc)
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
