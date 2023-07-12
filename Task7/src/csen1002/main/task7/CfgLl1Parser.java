package csen1002.main.task7;

import java.util.*;

/**
 * Write your info here
 * 
 * @name Mariam Wael
 * @id 46-1356
 * @labNumber 21
 */

public class CfgLl1Parser {

	/**
	 * Constructs a Context Free Grammar
	 * 
	 * @param "cfg" A formatted string representation of the CFG, the First sets of
	 *            each right-hand side, and the Follow sets of each variable. The
	 *            string representation follows the one in the task description
	 */

	String rules = "";
	String alphabets = "";
	String contextFR = "";
	String first = "";
	String follow = "";


	HashMap<String, HashMap<String,String>> contextFreeGrammar = new LinkedHashMap<>();
	HashMap<String, String> followHM = new LinkedHashMap<>();

	HashMap<String,HashMap<String,String>> parseTable = new LinkedHashMap<>();

	ArrayList<String> output = new ArrayList<>();
	HashMap<String, Integer> usedHowManyTimes = new LinkedHashMap<>();

	boolean error = false;



	public CfgLl1Parser(String input) {
		// TODO Auto-generated constructor stub

		String [] inputSplit = input.split("#");
		rules = inputSplit[0];
		alphabets = inputSplit[1];
		contextFR = inputSplit[2];
		first = inputSplit[3];
		follow = inputSplit[4];

		fillHashMap();
		InitializeParseTable();
	}

	/**
	 * @param input The string to be parsed by the LL(1) CFG.
	 * 
	 * @return A string encoding a left-most derivation.
	 */
	public String parse(String input) {
		// TODO Auto-generated method stub
		fillParseTable();
		input+="$";
		traceTheString(Arrays.asList(input.split("")));
		fillHowManyTime();
		String output = convertOutputToString();
		if(error)
			return output;
		return output.substring(0,output.length()-1);
	}


	public void InitializeParseTable(){
		List<String> rulesAsArrayList = Arrays.asList(rules.split(";"));
		ArrayList<String> nonTerminals =new ArrayList<>(Arrays.asList(alphabets.split(";")));
		nonTerminals.add("$");
		for (String s : rulesAsArrayList) {
			HashMap<String, String> temp = new LinkedHashMap<>();
			for (String nonTerminal : nonTerminals)
				temp.put(nonTerminal, "");
			parseTable.put(s, temp);
		}
	}

	public void fillParseTable(){
		parseTable.forEach((key,valueRow)->{
			valueRow.forEach((keyTerminal,valueFirst)->{
				int t = fromFirst(key,keyTerminal);
				String ruleThatBringsFirst = "";
				if(t != -1){
					if(t == 1){
						String firstWithMoreThanOneNonTerminal = getFirstContainingThisKey(key,keyTerminal);
						ruleThatBringsFirst = (contextFreeGrammar.get(key)).get(firstWithMoreThanOneNonTerminal);
					}
					else
						ruleThatBringsFirst = (contextFreeGrammar.get(key)).get(keyTerminal);
					valueRow.put(keyTerminal,ruleThatBringsFirst);
				}
			});
			if(firstContainsEpsilon(key)){
				List<String> currentFollow = Arrays.asList(followHM.get(key).split(""));
				for (String eachFollow : currentFollow)
					valueRow.put(eachFollow,"e");
			}
			parseTable.put(key,valueRow);
		});
	}

	public int fromFirst(String key, String nonTerminal){
		HashMap<String,String> temp = contextFreeGrammar.get(key);
		Set<String> keys = temp.keySet();
		for(String oneKey : keys){
			if(oneKey.length()>1){
				List<String> currentKey = Arrays.asList(oneKey.split(""));
				if(currentKey.contains(nonTerminal))
					return 1;
			}
			else
				if(nonTerminal.equals(oneKey))
					return 0;
		}
		return -1;
	}

	public boolean firstContainsEpsilon(String key){
		return (contextFreeGrammar.get(key)).containsKey("e");
	}

	public String getFirstContainingThisKey(String key, String nonTerminal){

		HashMap<String,String> temp = contextFreeGrammar.get(key);
		Set<String> keys = temp.keySet();
		for(String oneKey : keys){
			if(oneKey.length()>1){
				List<String> currentKey = Arrays.asList(oneKey.split(""));
				if(currentKey.contains(nonTerminal))
					return oneKey;
			}
		}
		return "";
	}

	public void traceTheString(List<String> inputAsArrayList){
		Stack<String> scratch_pad = new Stack<>();
		scratch_pad.push("$");
		scratch_pad.push("S");
		int i = 0;
		while(!(error)){
			String currentLetter = inputAsArrayList.get(i);
			String temp = "";
			if(scratch_pad.peek().equals(currentLetter) && currentLetter.equals("$"))
				break;
//			else if(scratch_pad.peek().equals("$") && i<inputAsArrayList.size()-1)
//				error = true;
			else if(scratch_pad.peek().equals("$") && !(currentLetter.equals("$")))
				error = true;
			else if(currentLetter.equals("$") && !(scratch_pad.peek().equals("$"))) {
				error = true;
			}
			else if(scratch_pad.peek().equals("$") && !(currentLetter.equals("$"))){
				error = true;
			}
			else if(isNonTerminal(scratch_pad.peek()) && !(scratch_pad.peek().equals(currentLetter)))
				error = true;
			else if(scratch_pad.peek().equals(currentLetter)){
				scratch_pad.pop();
				i++;
				if(i>=inputAsArrayList.size())
					error = true;
			}
			else{
				String tempRule = parseTable.get((scratch_pad.peek())).get(currentLetter);
				if(tempRule == null || tempRule.length() == 0)
					error = true;
				else if(tempRule.equals("e")) {
					temp += scratch_pad.peek() +"/" + "e";
					scratch_pad.pop();
					output.add(temp);
					continue;
				}
				else{
					temp += (scratch_pad.peek()) +"/" ;
					scratch_pad.pop();
					List<String> ruleAsArrayList = Arrays.asList(tempRule.split(""));
					int k = 0;
					for (int j = ruleAsArrayList.size()-1; j>=0; j--){
						scratch_pad.push(ruleAsArrayList.get(j));
						temp += ruleAsArrayList.get(k);
						k++;
					}
					output.add(temp);
				}
			}
		}
	}

	public void fillHashMap(){
		List<String> rulesAsArrayList = Arrays.asList(rules.split(";"));
		List<String> firstAsArrayList = Arrays.asList(first.split(";"));
		List<String> contextFrAsArrayList = Arrays.asList(contextFR.split(";"));
		List<String> followAsArrayList = Arrays.asList(follow.split(";"));

		for (int i = 0; i<rulesAsArrayList.size();i++){
			HashMap<String,String> temp = new LinkedHashMap<>();
			List<String> firstOfCurrentRule =Arrays.asList(((firstAsArrayList.get(i)).split("/")[1]).split(","));
			List<String> currentRule = Arrays.asList(((contextFrAsArrayList.get(i)).split("/")[1]).split(","));
			for(int j = 0; j<firstOfCurrentRule.size(); j++){
				temp.put(firstOfCurrentRule.get(j),currentRule.get(j));
			}
			followHM.put(rulesAsArrayList.get(i),((followAsArrayList.get(i)).split("/"))[1]);
			contextFreeGrammar.put(rulesAsArrayList.get(i),temp);
		}
	}

	public String convertOutputToString(){

		String out = getStartState()+";";
		boolean alreadyPassed = false;
		for (int i = 0; i<output.size();i++){
			String [] current = (output.get(i)).split("/");
			if(i == 0 && !(alreadyPassed)){
				out+=current[1]+";";
				output.remove(getStartState()+"/"+current[1]);
				i--;
				alreadyPassed = true;
			}
			else{
				String pre = getPrevious(out);
				int indexOfFirstTerminal = getIndexOfFirstTerminal(pre);
				out+=replace(pre,indexOfFirstTerminal)+";";
				i--;
			}
		}
		if(error)
			out+="ERROR";

		return out;
	}

	public String getPrevious(String input){
		String [] inputAsList = input.split(";");
		return inputAsList[(inputAsList.length)-1];
	}

	public void fillHowManyTime(){
		List<String> rulesAsArrayList = Arrays.asList(rules.split(";"));
		for (int i =0 ; i<rulesAsArrayList.size();i++){
			usedHowManyTimes.put(rulesAsArrayList.get(i),0);
		}

	}

	public int getIndexOfFirstTerminal(String previous){
		List<String> preAsArrayList = Arrays.asList(previous.split(""));
		List<String> rulesAsArrayList = Arrays.asList(rules.split(";"));
		for (int i = 0; i<preAsArrayList.size();i++){
			if(rulesAsArrayList.contains(preAsArrayList.get(i)))
				return i;
		}
		return -1;
	}

	public String replace(String previous, int indexOfFirstTerminal){
		String firstTerminal = (previous.split(""))[indexOfFirstTerminal];
		ArrayList<String> temp =new ArrayList<>(Arrays.asList(previous.split("")));
		String out= "";
		for (String s : output) {
			List<String> current = Arrays.asList(s.split("/"));
			if (current.get(0).equals(firstTerminal)) {
				if(!(current.get(1).equals("e"))) {
					temp.set(indexOfFirstTerminal, current.get(1));
					output.remove(s);
					break;
				}
				else{
					temp.set(indexOfFirstTerminal, "");
					output.remove(s);
					break;
				}
			}
		}
		for (String s:temp)
			out+=s;
		return out;
	}

	public boolean isNonTerminal(String character){
		List<String> temp = Arrays.asList(alphabets.split(";"));
		return temp.contains(character);
	}

	public String getStartState(){
		return (rules.charAt(0)+"");
	}

	public static void main(String [] args){

		CfgLl1Parser cfgLl1Parser= new CfgLl1Parser("S;F;G;T;X#g;l;o;p;u;y;z#S/FFTz,yS;F/lG,gF;G/yX,uS,e;T/oXTz,g,pSpG,e;X/pSlS,zS#S/gl,y;F/l,g;G/y,u,e;T/o,g,p,e;X/p,z#S/$glopz;F/gl;G/glz;T/z;X/glopz");
		cfgLl1Parser.fillParseTable();
		System.out.println(cfgLl1Parser.parse("yyllzozl"));

	}

}
