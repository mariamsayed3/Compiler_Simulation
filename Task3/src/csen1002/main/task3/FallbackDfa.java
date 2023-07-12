package csen1002.main.task3;

import java.util.Stack;

/**
 * Write your info here
 * 
 * @name Mariam Wael
 * @id 46-1356
 * @labNumber 21
 */

public class FallbackDfa {

	/**
	 * Constructs a Fallback DFA
	 * 
	 * @param fdfa A formatted string representation of the Fallback DFA. The string
	 *             representation follows the one in the task description
	 */
	String startState = "";
	String acceptState = "";
	String transitions = "";


	int l = 0;
	int r = 0;

	Stack<Integer> states = new Stack<>();

	public FallbackDfa(String fdfa) {
		// TODO Auto-generated constructor stub

		transitions = (fdfa.split("#"))[2];
		startState = (fdfa.split("#"))[3];
		acceptState = (fdfa.split("#"))[4];
	}

	/**
	 * @param input The string to simulate by the FDFA.
	 * 
	 * @return Returns a formatted string representation of the list of tokens. The
	 *         string representation follows the one in the task description
	 */
	public String run(String input) {
		// TODO Auto-generated method stub

		String output = "";

		// convert input to array
		String [] inputAsArray = splitString(input);

		while (l>=r) {

			// reading string
			readingString(inputAsArray);

			boolean foundAcceptState = false;
			int topOfStack = states.peek();
			l--;
			while (l >= r) {
				int peekOfStack = states.peek();
				if (isAcceptState(peekOfStack)) {
					output += returnStringFromTo(inputAsArray) + "," + peekOfStack + ";";
					foundAcceptState = true;
					l++;
					r = l;
					break;
				} else {
					l--;
					states.pop();
				}
			}
			if (!foundAcceptState) {
				l = inputAsArray.length - 1;
				if(returnStringFromTo(inputAsArray).length() !=0)
					output += returnStringFromTo(inputAsArray) + "," + topOfStack;
				else
					output = output.substring(0,output.length()-1);
				///if(l == r)
					break;
			}
			else if(foundAcceptState){
				foundAcceptState = false;
			}
		}
		reInitializing();
		return output;
	}


	public void reInitializing(){
		startState = "";
		acceptState = "";
		transitions = "";
		l = 0;
		r = 0;
		states = new Stack<>();
	}

	public boolean isAcceptState(int peekOfStack){

		String[] splitAcceptStates = acceptState.split(";");
		for (int i =0;i<splitAcceptStates.length;i++){
			if(peekOfStack == Integer.parseInt(splitAcceptStates[i]))
				return true;
		}
		return false;
	}

	public void readingString(String [] inputAsArray){
		states = new Stack<>();
		states.push(Integer.parseInt(startState));
		l++;
		for (int i = r ; i<inputAsArray.length;i++){
				String by = inputAsArray[l-1];
				int to = Integer.parseInt(goingTo(states.peek(),by));
				states.push(to);
			if(l!=inputAsArray.length)
				l++;
		}
	}

	public String returnStringFromTo(String [] input){
		String output = "";
		for (int  i = r; i<l+1; i++)
			output+=input[i];
		return output;
	}

	// going from --> state by --> alphabet
	public String goingTo(int goingFrom, String by){
		String [] trans = transitions.split(";");
		for (int i = 0; i<trans.length; i++){
			String [] temp = (trans[i]).split(",");

			if(Integer.parseInt(temp[0]) == goingFrom && (temp[1]).equals(by))
				return temp[2];
		}
		return "";
	}

	public String [] splitString(String input){
		String []  splitInput = new String[input.length()];

		for (int i = 0 ; i<input.length(); i++){
			splitInput[i] = input.charAt(i)+"";
		}
		return splitInput;
	}

//	public static void main(String[]args){
//		FallbackDfa fallbackDfa = new FallbackDfa("0;1;2;3#a;b#0,a,0;0,b,1;1,a,2;1,b,1;2,a,0;2,b,3;3,a,3;3,b,3#0#1;2");
//		System.out.println(fallbackDfa.run("baababb"));
//
////		FallbackDfa fallbackDfa= new FallbackDfa("0;1;2;3;4;5;6;7;8;9;10;11;12#h;k;r;x#0,h,12;0,k,0;0,r,4;0,x,5;1,h,12;1,k,6;1,r,2;1,x,8;2,h,5;2,k,5;2,r,1;2,x,8;3,h,10;3,k,0;3,r,7;3,x,9;4,h,1;4,k,7;4,r,5;4,x,4;5,h,2;5,k,8;5,r,2;5,x,12;6,h,4;6,k,8;6,r,3;6,x,4;7,h,8;7,k,12;7,r,5;7,x,10;8,h,12;8,k,12;8,r,1;8,x,6;9,h,9;9,k,0;9,r,2;9,x,10;10,h,7;10,k,12;10,r,10;10,x,10;11,h,0;11,k,11;11,r,10;11,x,1;12,h,10;12,k,8;12,r,11;12,x,4#5#0;2;6;10;11");
////		String [] splitInput = fallbackDfa.splitString("hhxxxkrhhkrhxxrkrhkhk");
////		String x = fallbackDfa.goingTo(0,"h");
////		System.out.println(x);
////
////		fallbackDfa.readingString(splitInput);
////
////		System.out.println(fallbackDfa.run("hhxxxkrhhkrhxxrkrhkhk"));
////
////		int stackSize = fallbackDfa.states.size();
////
////		System.out.println(fallbackDfa.run("hhxxxkrhhkrhxxrkrhkhk"));
////		for(int i = 0 ;i<stackSize;i++){
////			System.out.print(fallbackDfa.states.peek() + " ");
////			fallbackDfa.states.pop();
////		}
//
//
//		//System.out.println(output);
//	}

}

