package csen1002.main.task6;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Write your info here
 * 
 * @name Mariam Wael
 * @id 46-1356
 * @labNumber 21
 */

public class CfgFirstFollow {

	/**
	 * Constructs a Context Free Grammar
	 * 
	 * @param cfg A formatted string representation of the CFG. The string
	 *            representation follows the one in the task description
	 */

	String rules = "";
	String alphabets = "";
	String contextFR = "";

	HashMap<String, String> contextFreeGrammar = new LinkedHashMap<>();
	HashMap<String, String> first = new LinkedHashMap<>();
	HashMap<String, Boolean> whichOneChanged = new LinkedHashMap<>();

	HashMap<String, String> follow = new LinkedHashMap<>();


	public CfgFirstFollow(String cfg) {
		// TODO Auto-generated constructor stub

		rules = (cfg.split("#"))[0];
		alphabets = (cfg.split("#"))[1];
		contextFR = (cfg.split("#"))[2];

		fillHashMap();


	}

	/**
	 * Calculates the First Set of each variable in the CFG.
	 * 
	 * @return A string representation of the First of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String first() {
		// TODO Auto-generated method stub
		HashMap<String, Boolean> change = new LinkedHashMap<>();
		String [] rul = rules.split(";");
		StringBuilder out = new StringBuilder();
		String output = "";
		for (String s : rul) change.put(s, true);
		do{
			contextFreeGrammar.forEach((key, value) -> {
				List<String> currentFirstAsList = new ArrayList<>();
				String [] val = (value.split("/")[1]).split(",");
				List<String> valueAsArrayList = Arrays.asList(val);
				StringBuilder currentFirst = new StringBuilder();
				StringBuilder finalFirst = new StringBuilder();
				for (String current : valueAsArrayList) {
//					if (sameAsKey(key, current.charAt(0) + ""))
//						continue;
					if (current.equals("e"))
						currentFirst.append("e");
					else if (isTerminal((current.charAt(0)) + ""))
						currentFirst.append(current.charAt(0));
					else {
						currentFirst.append(firstCharIsNotTerminal(current));
						if (addEpsilonToCurrent(current))
							currentFirst.append("e");
					}
				}
				currentFirst = removeDuplicates(currentFirst);
				currentFirstAsList = Arrays.asList(((currentFirst.toString()).split("")));
				Collections.sort(currentFirstAsList);
				for (String s : currentFirstAsList) {
					finalFirst.append(s);
				}
				if((finalFirst.toString()).equals(first.get(key)))
					whichOneChanged.put(key,false);
				else{
					whichOneChanged.put(key,true);
					first.put(key,(finalFirst.toString()));
				}
			});
		}while (whichOneChanged.containsValue(true));

		first.forEach((key,value)->{
			out.append(key).append("/").append(value).append(";");
		});
		System.out.println(first);
		output = out.toString();
		//reInitialize();
		return (output.substring(0,output.length()-1));
	}

	public boolean isTerminal(String character){
		String [] alp = alphabets.split(";");
		for (String s : alp) {
			if (s.equals(character))
				return true;
		}
		return false;
	}

	public int containEpsilon(String rule){

		for (int i = 0; i<rule.length(); i++){
			if((rule.charAt(i)+"").equals("e"))
				return i;
		}
		return -1;
	}

	public String removeEpsilon(int indexOfEpsilon, String rule){
		String output = "";
		if(indexOfEpsilon == 0)
			return rule.substring(1);
		else if(indexOfEpsilon == (rule.length()-1))
			return rule.substring(0,rule.length()-1);
		else{
			output+= rule.substring(0,indexOfEpsilon);
			output+=rule.substring(indexOfEpsilon+1);
		}
		return output;
	}

	public boolean addEpsilonToCurrent(String currentRule){

		for (int i = 0; i<currentRule.length(); i++){
			String currentCharacter = currentRule.charAt(i)+"";
			if(isTerminal(currentCharacter))
				return false;
			String firstOfCurrentCharacter = first.get(currentCharacter);
			if(containEpsilon(firstOfCurrentCharacter) == -1)
				return false;
		}
		return true;
	}

	public StringBuilder firstCharIsNotTerminal(String currentRule){
		StringBuilder output = new StringBuilder();
		boolean added = false;
		for(int i = 0 ; i<currentRule.length(); i++){
			if(i == 0){
				String currentNonTerminalVar = currentRule.charAt(i)+"";
				String firstOfCurrentNonTerminalVar = first.get(currentNonTerminalVar);
				int epsilonIndex = (containEpsilon(firstOfCurrentNonTerminalVar));

				if(epsilonIndex == -1 && (firstOfCurrentNonTerminalVar.length() != 0)) {
					output.append(firstOfCurrentNonTerminalVar);
					break;
				}
				else if((firstOfCurrentNonTerminalVar.length() != 0))
					output.append(removeEpsilon(epsilonIndex, firstOfCurrentNonTerminalVar));
				else if(output.length() == 0)
					break;
			}
			else{
				added = false;
				String currentVar = currentRule.charAt(i)+"";
				if(isTerminal(currentVar)) {
					output.append(currentVar);
					break;
				}
				else{
					String firstOfCurrentNonTerminalVar = first.get(currentVar);
					int epsilonIndex = (containEpsilon(firstOfCurrentNonTerminalVar));
					if(epsilonIndex == -1 && (firstOfCurrentNonTerminalVar.length() != 0)) {
						output.append(firstOfCurrentNonTerminalVar);
						break;
					}
					else if((firstOfCurrentNonTerminalVar.length() != 0)) {
						output.append(removeEpsilon(epsilonIndex, firstOfCurrentNonTerminalVar));
						added = true;
					}
					if(!added)
						break;
				}
			}
		}
		return output;
	}

	public StringBuilder removeDuplicates(StringBuilder first){
		String output = first.toString();
		String[] strSplit = output.split("");
		ArrayList<String> strList = new ArrayList<String>(
				Arrays.asList(strSplit));
		StringBuilder newOutput = new StringBuilder();
		ArrayList<String> listWithoutDuplicated = new ArrayList<String>();
		for(String st:strList){
			if(!(listWithoutDuplicated.contains(st)))
				listWithoutDuplicated.add(st);
		}
		for(String s: listWithoutDuplicated)
			newOutput.append(s);
//		for (int i = 0; i< output.length(); i++){
//			String currentVar = output.charAt(i)+"";
//			int k = 0;
//			for (int j= 0; j<output.length();j++){
//				String temp = output.charAt(i)+"";
//				if(temp.equals(currentVar) && k==0){
//					newOutput.append(temp);
//					k++;
//				}
//				if(!temp.equals(currentVar))
//					newOutput.append(temp);
//			}
//		}
		return newOutput;
	}

//	public boolean sameAsKey(String key, String rule){
//
//		for (int i =0; i<rule.length();i++){
//			if((rule.charAt(i)+"").equals(key))
//				return true;
//		}
//		return false;
//	}

	/**
	 * Calculates the Follow Set of each variable in the CFG.
	 * 
	 * @return A string representation of the Follow of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String follow() {
		// TODO Auto-generated method stub
		String firstOutput = first();
		first = fillFistHashMap(firstOutput);
		addDollarSign();
		StringBuilder out = new StringBuilder();
		String output = "";
		do{
			contextFreeGrammar.forEach((key,value)->{
				StringBuilder followOfCurrentRule = new StringBuilder();
				List<String> currentFollowAsList = new ArrayList<>();
				if(follow.get(key).length()!=0)
					followOfCurrentRule.append(follow.get(key));
				contextFreeGrammar.forEach((tempKey,tempValue)->{
					List<String> tempValueAsArrayList = Arrays.asList(((tempValue.split("/")[1]).split(",")));
					ArrayList<Integer> indices = ruleContainsTheKey(tempValueAsArrayList,key);
					for (Integer index : indices) {
						String subRuleThatHasKey = tempValueAsArrayList.get(index);
						ArrayList<Integer> indicesOfKeyInSubRule = indexOfKeyInSubRule(subRuleThatHasKey, key);
						followOfCurrentRule.append(getFollowOfKey(indicesOfKeyInSubRule, subRuleThatHasKey, tempKey));
					}
				});
				StringBuilder finalFollow = new StringBuilder();
				String followNoRe = removeDuplicates(followOfCurrentRule).toString();
				currentFollowAsList = Arrays.asList(((followNoRe).split("")));
				Collections.sort(currentFollowAsList);
				for (String s : currentFollowAsList) {
					finalFollow.append(s);
				}
				if((finalFollow.toString()).equals(follow.get(key)))
					whichOneChanged.put(key,false);
				else{
					whichOneChanged.put(key,true);
					follow.put(key,(finalFollow.toString()));
				}
			});
		}while(whichOneChanged.containsValue(true));

		follow.forEach((key,value)->{
			out.append(key).append("/").append(value).append(";");
		});
		output = out.toString();
		reInitialize();
		return (output.substring(0,output.length()-1));

	}

	public ArrayList<Integer> ruleContainsTheKey(List<String> ruleAsArrayList,String key){
		ArrayList<Integer> output = new ArrayList<>();
		for (int i = 0;i<ruleAsArrayList.size();i++) {
			int temp = stringContainsTheKey((ruleAsArrayList.get(i)), key,i);
			if(temp != -1)
				output.add(temp);
		}
		return output;
	}

	public int stringContainsTheKey(String subRule, String key, int index){
		List<String> temp = Arrays.asList(subRule.split(""));
		if(temp.contains(key))
			return index;
		return -1;
	}

	public ArrayList<Integer> indexOfKeyInSubRule(String subRule, String key){
		List<String> subRuleAsArrayList = Arrays.asList(subRule.split(""));
		ArrayList<Integer> indicesOfTheKey = new ArrayList<>();
		for (int i = 0; i<subRuleAsArrayList.size(); i++){
			if(subRuleAsArrayList.get(i).equals(key))
				indicesOfTheKey.add(i);
		}
		return indicesOfTheKey;
	}

	public StringBuilder getFollowOfKey(ArrayList<Integer> indicesOfKeyInSubRule,String subRule,String subKey){
		StringBuilder output = new StringBuilder();
		if(indicesOfKeyInSubRule.size() == 1){
			int indexOfTheKey = indicesOfKeyInSubRule.get(0);
			if(indexOfTheKey == (subRule.length()-1)) {
				String temp = follow.get(subKey);
				if(temp.length() != 0)
					output.append(follow.get(subKey));
			}
			else{
				String theNextChar = subRule.charAt(indexOfTheKey+1)+"";
				if(isTerminal(theNextChar))
					output.append(theNextChar);
				else{
					String firstOfTheNextChar = first.get(theNextChar);
					int indexOfEpsilonInFirst = containEpsilon(firstOfTheNextChar);
					if(indexOfEpsilonInFirst == -1)
						output.append(firstOfTheNextChar);
					// what I edit is here
					else{
						firstOfTheNextChar = removeEpsilon(indexOfEpsilonInFirst,firstOfTheNextChar);
						output.append(firstOfTheNextChar);
						if(subRule.length() > (indexOfTheKey+2))
							output.append(handleEpsilonInFollow(indexOfTheKey,subRule,subKey));
//							for (int i = indexOfTheKey + 2; i < subRule.length(); i++) {
//								String currentNextChar = subRule.charAt(i)+"";
//								if(isTerminal(currentNextChar)) {
//									output.append(currentNextChar);
//									containsEpsilon = false;
//									break;
//								}
//								firstOfTheNextChar = first.get(currentNextChar);
//								int indexOfEpsilonInCurrentFist = containEpsilon(firstOfTheNextChar);
//								if(indexOfEpsilonInCurrentFist == -1) {
//									output.append(firstOfTheNextChar);
//									containsEpsilon = false;
//									break;
//								}
//								else{
//									firstOfTheNextChar = removeEpsilon(indexOfEpsilonInCurrentFist,firstOfTheNextChar);
//									output.append(firstOfTheNextChar);
//									containsEpsilon = true;
//								}
//							}
//							if(containsEpsilon)
//								output.append(follow.get(subKey));

						else if((indexOfTheKey+1) == (subRule.length()-1))
							output.append(follow.get(subKey));
					}
				}

			}
		}
		else{
			for (int currentIndex : indicesOfKeyInSubRule) {
				if (currentIndex == (subRule.length() - 1)) {
					String temp = follow.get(subKey);
					if (temp.length() != 0)
						output.append(follow.get(subKey));
				} else {
					String theNextChar = subRule.charAt(currentIndex + 1) + "";
					if(isTerminal(theNextChar))
						output.append(theNextChar);
					else{
						String firstOfTheNextChar = first.get(theNextChar);
						int indexOfEpsilonInFirst = containEpsilon(firstOfTheNextChar);
						if (indexOfEpsilonInFirst == -1)
							output.append(firstOfTheNextChar);
						else {
							firstOfTheNextChar = removeEpsilon(indexOfEpsilonInFirst, firstOfTheNextChar);
							output.append(firstOfTheNextChar);
							if(subRule.length() > (currentIndex+2))
								output.append(handleEpsilonInFollow(currentIndex,subRule,subKey));
							else if((currentIndex+1) == (subRule.length()-1))
								output.append(follow.get(subKey));

						}
					}
				}
			}
		}
		return output;
	}

	public StringBuilder handleEpsilonInFollow(int indexOfTheKey,String subRule,String subKey) {
		boolean containsEpsilon = false;
		StringBuilder output = new StringBuilder();
		String firstOfTheNextChar = "";
		if (subRule.length() > (indexOfTheKey + 2)) {
			for (int i = indexOfTheKey + 2; i < subRule.length(); i++) {
				String currentNextChar = subRule.charAt(i) + "";
				if (isTerminal(currentNextChar)) {
					output.append(currentNextChar);
					containsEpsilon = false;
					break;
				}
				firstOfTheNextChar = first.get(currentNextChar);
				int indexOfEpsilonInCurrentFist = containEpsilon(firstOfTheNextChar);
				if (indexOfEpsilonInCurrentFist == -1) {
					output.append(firstOfTheNextChar);
					containsEpsilon = false;
					break;
				} else {
					firstOfTheNextChar = removeEpsilon(indexOfEpsilonInCurrentFist, firstOfTheNextChar);
					output.append(firstOfTheNextChar);
					containsEpsilon = true;
				}
			}
			if (containsEpsilon)
				output.append(follow.get(subKey));
		}
		return output;
	}

	public void fillHashMap(){
		String [] arrOfAlpha = rules.split(";");
		String [] arrOfRules = contextFR.split(";");
		for (int i = 0; i<arrOfAlpha.length; i++ ){
			System.out.println(arrOfAlpha[i]);
			contextFreeGrammar.put(arrOfAlpha[i],arrOfRules[i]);
			first.put(arrOfAlpha[i],"");
			whichOneChanged.put(arrOfAlpha[i],true);
		}
		System.out.println(contextFreeGrammar);
	}

	public HashMap<String,String> fillFistHashMap(String first){
		HashMap<String, String> firstHM = new LinkedHashMap<>();
		String[]firstArray = first.split(";");
		List<String> firstAsArrayList = Arrays.asList(firstArray);

		for (String current : firstAsArrayList) {
			String[] currentAsArray = current.split("/");
			firstHM.put(currentAsArray[0], currentAsArray[1]);
			whichOneChanged.put(currentAsArray[0],true);
			follow.put(currentAsArray[0],"");
		}
		return firstHM;
	}

	public void addDollarSign(){
		follow.put((rules.charAt(0)+""),"$");
	}

	public void reInitialize(){
		rules = "";
		alphabets = "";
		contextFR = "";

		contextFreeGrammar = new LinkedHashMap<>();
		first = new LinkedHashMap<>();
		whichOneChanged = new LinkedHashMap<>();
		follow = new LinkedHashMap<>();

	}

	public static void main(String[]args){
		//CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;Z;I;P;B;J;W#b;f;i;m;n;p;s#S/PZb,S,iBbB;Z/II,If,P;I/B,JZPP,SPnJS,SWsI,bBPb,iB;P/JWWfP,S,Ss,e;B/e,pBPBb,sSP;J/BmPZ,Z,iP;W/bZ,mPnWb,pWBfB");
		//CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;W;G;A;D;C;P#f;h;l;o;q;s;t#S/A,DPS,DqDDq,qAlS,qDPPo;W/e,lSD,tCShP;G/C,G,S,sDC,sS;A/fPlDf,o;D/PS,WAPs,e,oW,qD;C/G,PDP,PW,W;P/o,q");
		//CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;A;B;C#a;b;c#S/SAB,SBC,e;A/aAa,e;B/bB,e;C/cC,e");
		CfgFirstFollow cfgFirstFollow= new CfgFirstFollow("S;Z;F;T;D;V#m;p;q;v;y#S/VpDvV,pTvV;Z/D,DD,F,FVVF,pZSTV,vZ;F/D,FmFFy,Z,pVVDV,pZ;T/DZ,FD,FTFqS,S,T,TF,V,e;D/D,SSp,V,VFV,VTVm,e,q;V/qFqV,v");
		cfgFirstFollow.first();
//		System.out.println(cfgFirstFollow.fillFistHashMap(temp));
//		String x = "abc";
//		System.out.println((Arrays.toString((x.split("")))));


		//System.out.println(cfgFirstFollow.follow);
		///System.out.println(cfgFirstFollow.follow());
	}
}
