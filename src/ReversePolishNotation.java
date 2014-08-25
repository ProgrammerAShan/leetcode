import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//你波兰式求解
//Evaluate the value of an arithmetic expression in Reverse Polish Notation.

//Valid operators are +, -, *, /. Each operand may be an integer or another expression.

//Some examples:

// ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
// ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

public class ReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings={"0","3","/"};
		int result=evalRPN(strings);
		System.out.println(Integer.toString(result));

	}
	
    public static int evalRPN(String[] tokens) {
    	int result=0;
    	List<Integer> list=new ArrayList<>();
    	list.add(Integer.parseInt(tokens[0]));
    	result=list.get(0);
    	for(int i=1;i<tokens.length;i++)
    	{
    		String string=tokens[i];
    		int a=0;
    		int b=0;
    		switch (string) {
			case "+":
				result=0;
				a=0;
				b=0;
				b=(list.remove(list.size()-1));
				a=(list.remove(list.size()-1));
				result=a+b;
				list.add(result);
				break;
			case "-":
				result=0;
				a=0;
				b=0;
				b=(list.remove(list.size()-1));
				a=(list.remove(list.size()-1));
				result=a-b;
				list.add(result);
				break;
			case "*":
				result=0;
				a=0;
				b=0;
				b=(list.remove(list.size()-1));
				a=(list.remove(list.size()-1));
				result=a*b;
				list.add(result);
				break;
			case "/":
				result=0;
				a=0;
				b=0;
				b=(list.remove(list.size()-1));
				a=(list.remove(list.size()-1));
				if(b==0)
					return Integer.MAX_VALUE;
				result=a/b;
				list.add(result);
				break;

			default:
				list.add(Integer.parseInt(string));
				break;
			}
    	}
    	return result;
        
    }

}
