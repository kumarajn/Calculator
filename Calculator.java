import java.util.Stack;

public class Calculator {

	
	
public double calculate(String in)
{
	
	char[] charArray = in.toCharArray();
	
	Stack<Integer> values = new Stack<Integer>(); 
	  
  
    Stack<Character> operators = new Stack<Character>(); 
	
    for (int i = 0; i < charArray.length; i++) 
    { 
       /* 
        if (charArray[i] == ' ') 
            continue; */

       
        if (charArray[i] >='0' && charArray[i] <='9') 
        { 
            StringBuffer strinbuff = new StringBuffer(); 
        
            while (i < charArray.length && charArray[i] >='0' && charArray[i] <='9') 
            	strinbuff.append(charArray[i++]); 
            values.push(Integer.parseInt(strinbuff.toString())); 
        } 
        else if (charArray[i] =='(') 
        	operators.push(charArray[i]); 

      
        else if (charArray[i] ==')') 
        { 
            while (operators.peek() !='(') 
              values.push(calc(operators.pop(), values.pop(), values.pop())); 
            operators.pop(); 
        } 
        else if (charArray[i] =='+' || charArray[i] =='-' || 
                charArray[i] =='*' || charArray[i] =='/') 
       { 
           
           while (!operators.empty() && hasPrecedence(charArray[i], operators.peek())) 
             values.push(calc(operators.pop(), values.pop(), values.pop()));  
           operators.push(charArray[i]); 
       } 
    }
        while (!operators.empty()) 
            values.push(calc(operators.pop(), values.pop(), values.pop())); 
  
    
        return values.pop();
    

}
public static boolean hasPrecedence(char ops1, char ops2) 
{ 
    if (ops2 =='(' || ops2 ==')') 
        return false; 
    if ((ops1 =='*' || ops1 =='/') && (ops2 =='+' || ops2 =='-')) 
        return false; 
    else
        return true; 
} 
public static int calc(char ops, int x, int y) 
{ 
    switch (ops) 
    { 
    case '+': 
        return x + y; 
    case '-': 
        return x - y; 
    case '*': 
        return x * y; 
    case '/': 
        if (y == 0) 
            throw new
            UnsupportedOperationException("Cannot divide by zero"); 
        return x / y; 
    } 
    return 0; 
}
}
