package calc.calculator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator calc=new Calculator();
		String in=new String("7 + ( 6 * 5 )");
		
		
		CheckStringExp checkString=new CheckStringExp();
		if(checkString.isValidExpression2(in))
		{
		double out=calc.calculate(in);
		System.out.println(out);
		}
		else 
		{
			System.out.println("invalid expression");
		}
		
		
	}

}

