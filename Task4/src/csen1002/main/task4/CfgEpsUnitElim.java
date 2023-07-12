package csen1002.main.task4;

import java.util.*;

/**
 * Write your info here
 * 
 * @name Mariam Wael
 * @id 46-1356
 * @labNumber 21
 */

public class CfgEpsUnitElim {

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

	public CfgEpsUnitElim(String cfg) {
		// TODO Auto-generated constructor stub

		rules = (cfg.split("#"))[0];
		alphabets = (cfg.split("#"))[1];
		contextFR = (cfg.split("#"))[2];

        fillHashMap();

	}

	/**
	 * @return Returns a formatted string representation of the CFG. The string
	 *         representation follows the one in the task description
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String output = "";
		output+=rules + "#" + alphabets + "#";
		Set<String> keys = contextFreeGrammar.keySet();

		for (String key : keys){
			output+= contextFreeGrammar.get(key)+";";
		}
		reInitialize();
		return output.substring(0,output.length()-1);
	}

	/**
	 * Eliminates Epsilon Rules from the grammar
	 */

	//DONE
	public void eliminateEpsilonRules() {
		// TODO Auto-generated method stub

		HashMap<String, Boolean> addedToItEpsilon = new LinkedHashMap<String,Boolean>();
        ArrayList<String> alreadyHasEpsilon = new ArrayList<>();
		do {
			contextFreeGrammar.forEach((key, value) -> {
				String[] rules = (value.split("/")[1]).split(",");
				// convert it to arrayList
				ArrayList<String> rulesAsArrayList = new ArrayList<String>(Arrays.asList(rules));
				int indexOfEpsilon = containsEpsilon(rulesAsArrayList);
				if (indexOfEpsilon != -1) {
					alreadyHasEpsilon.add(key);
					rulesAsArrayList.remove(indexOfEpsilon);
					addedToItEpsilon.put(key,false);
					contextFreeGrammar.forEach((tempKey, tempValue) -> {
						String[] tempRules = (tempValue.split("/")[1]).split(",");
						ArrayList<String> addToOutput = new ArrayList<>();
						for (int u = 0; u < tempRules.length; u++) {
							addToOutput.add(tempRules[u]);
						}
						// convert it to arrayList
						ArrayList<String> tempRulesAsArrayList = new ArrayList<String>(Arrays.asList(tempRules));
						for (int i = 0; i < tempRulesAsArrayList.size(); i++) {
							if (tempRulesAsArrayList.get(i).contains(key) && tempRulesAsArrayList.get(i).length() == 1) {
								if (!alreadyHasEpsilon(alreadyHasEpsilon, tempKey) &&  (containsEpsilon(tempRulesAsArrayList) ==-1) ) {
									addToOutput.add("e");
									addedToItEpsilon.put(tempKey, true);
								}
							} else if (tempRulesAsArrayList.get(i).contains(key)) {
								ArrayList<String> temp = getPermutation(tempRulesAsArrayList.get(i), key);
								for (int j = 0; j < temp.size(); j++) {
									//if (!alreadyHasEpsilon(alreadyHasEpsilon, temp.get(j))){
									    if(!addToOutput.contains(temp.get(j)))
									        addToOutput.add(temp.get(j));
                                   // }
								}
							}
						}
						Collections.sort(addToOutput);
						String finalOutPut = tempKey+"/";
						for (int y = 0; y < addToOutput.size(); y++) {
						    if(tempKey == key && addToOutput.get(y).equals("e")){
                               continue;
                            }
						    finalOutPut += addToOutput.get(y) + ",";
                        }
						contextFreeGrammar.put(tempKey, finalOutPut.substring(0, finalOutPut.length() - 1));
					});
				}
			});
		}while (addedToItEpsilon.containsValue(true));
	}

	public ArrayList<String> getPermutation(String rule, String key){
		ArrayList<String> allPermutations = new ArrayList<>();
		String u = "";
		String v = "";
		String temp = "";

		boolean thereIsAChange = false;

		int lengthOfPer = 0;

		boolean firstTime = true;
		do{
		    if(firstTime){
                for(int i =0; i<rule.length();i++){
                    if((rule.charAt(i)+"").equals(key)){
                        if(i == 0)
                            v = rule.substring(i+1,rule.length());
                        else if(i == rule.length()-1)
                            u = rule.substring(0,i);
                        else{
                            u = rule.substring(0,i);
                            v = rule.substring(i+1,rule.length());
                        }
                        temp = u+v;
						if(temp.equals(""))
							temp = "e";
                        if(!allPermutations.contains(temp)) {
							allPermutations.add(temp);
						}
                        u = "";
                        v = "";
                    }
                }
                if(lengthOfPer != allPermutations.size()){
                    thereIsAChange = true;
                    lengthOfPer = allPermutations.size();
                    firstTime = false;
                }
                else
                    thereIsAChange = false;
            }
		    else{
		        int sizeFixed = allPermutations.size();
		        for(int i =0; i<sizeFixed;i++){
                    rule = allPermutations.get(i);
                    for(int j =0; j<rule.length();j++){
                        if((rule.charAt(j)+"").equals(key)){
                            if(j == 0)
                                v = rule.substring(j+1,rule.length());
                            else if(j == rule.length()-1)
                                u = rule.substring(0,j);
                            else{
                                u = rule.substring(0,j);
                                v = rule.substring(j+1,rule.length());
                            }
                            temp = u+v;
                            if(temp.equals(""))
                            	temp = "e";
                            if(!allPermutations.contains(temp)) {
								allPermutations.add(temp);
							}
                            u = "";
                            v = "";
                        }
                    }
                }
                if(lengthOfPer != allPermutations.size()){
                    thereIsAChange = true;
                    lengthOfPer = allPermutations.size();
                }
                else
                    thereIsAChange = false;
            }
        }while(thereIsAChange);

		if(getOccurrence(rule,key)>1){
			temp = removeAllOccurrenceOfKey(rule,key);
			allPermutations.add(temp);
		}
		return allPermutations;
	}

	public int getOccurrence(String rule, String key){
		int k = 0;
		for (int i = 0; i<rule.length();i++){
			if((rule.charAt(i)+"").equals(key))
				k++;
		}
		return k;
	}

	public String removeAllOccurrenceOfKey(String rule, String key){
	    String output = "";
		for (int i = 0 ; i<rule.length(); i++){
			if(!(rule.charAt(i)+"").equals(key))
			    output+=rule.charAt(i);
		}
		return output;
	}

	public int containsEpsilon(ArrayList<String> rule){
		for (int i =0; i<rule.size(); i++){
			if(rule.get(i).contains("e") && (rule.get(i).length() ==1))
				return i;
		}
		return -1;
	}

	public boolean alreadyHasEpsilon(ArrayList<String> alreadyExist, String key){
		for (int i =0; i<alreadyExist.size(); i++){
			if(alreadyExist.get(i).equals(key))
				return true;
		}
		return false;
	}


	/**
	 * Eliminates Unit Rules from the grammar
	 */
	//DONE
	public void eliminateUnitRules() {
		// TODO Auto-generated method stub

		// loop over hashmap
		contextFreeGrammar.forEach((key, value)
						-> {
			ArrayList<String> alreadyRemoved = new ArrayList<>();
			String [] rules = (value.split("/")[1]).split(",");
			// convert it to arrayList
			ArrayList<String> rulesAsArrayList = new ArrayList<String>(Arrays.asList(rules));
			for (int i =0; i<rulesAsArrayList.size();i++){
				String ithRule = rulesAsArrayList.get(i);
				// if the rule is unit rule
				if(ithRule.length() == 1){
					// if the string is same as the rule
					if(ithRule.equals(key)) {
						rulesAsArrayList.remove(i);
						i--;
					}
					else{
						//get the rules of this unit variable and replace it with its rule
						String rulesOfDesiredRule =  contextFreeGrammar.get(ithRule);
						if(rulesOfDesiredRule == null)
							continue;
						rulesOfDesiredRule = rulesOfDesiredRule.split("/")[1];
						String [] newRule = rulesOfDesiredRule.split(",");
						alreadyRemoved.add(rulesAsArrayList.get(i));
						rulesAsArrayList.remove(i);
						i--;
						for (int j =0; j<newRule.length;j++) {
							// infinite loops
							if(alreadyRemoved(alreadyRemoved,newRule[j]))
								continue;
							// repeated rules
							if(rulesAsArrayList.contains(newRule[j]))
								continue;
							rulesAsArrayList.add(newRule[j]);
						}
					}
				}
			}
			Collections.sort(rulesAsArrayList);
			String newRule = key + "/";
			newRule += convertListToString(rulesAsArrayList);
			contextFreeGrammar.put(key,newRule);
		});
	}
	public boolean alreadyRemoved(ArrayList<String> arr,String check){
		for(int i =0 ; i<arr.size();i++)
			if(arr.get(i).equals(check))
				return true;
		return false;
	}
	public String convertListToString(List<String> arr){
		String out = "";
		for (int i = 0; i<arr.size(); i++)
			out+=arr.get(i) + ",";
		return out.substring(0,out.length()-1);
	}
	public void fillHashMap(){
		String [] arrOfAlpha = rules.split(";");
		String [] arrOfRules = contextFR.split(";");
		for (int i = 0; i<arrOfAlpha.length; i++ ){
			System.out.println(arrOfAlpha[i]);
			contextFreeGrammar.put(arrOfAlpha[i],arrOfRules[i]);
		}
		System.out.println(contextFreeGrammar);
	}
	public void reInitialize(){
		rules = "";
		alphabets = "";
		contextFR = "";
		contextFreeGrammar = new LinkedHashMap<>();
	}


//	public static void main(String[]args){
//		//CfgEpsUnitElim cfgEpsUnitElim = new CfgEpsUnitElim("S;V;Y;R;P;N#g;p;q;x;z#S/NRS,S,pSzR,xV;V/P,PYg,VYSx;Y/NNqNY,P,VVYYx,qRxS,qVx;R/P,PPNY,gRN,z;P/NVp,PzVN,RNVp,Y;N/NSp,Y");
//		//CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;D;M;T;H;J;Z#f;l;z#S/H,HDlH,J,fMlMl,zZzHZ;D/D,JzSzZ,M,MzTlM;M/D,H,TfH;T/DlZS,M;H/MHz,zDHS,zDJZz;J/D,H,SHTD,TfDzZ;Z/SlJSH,lSfS");
////        CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;J;W;L;Q;G;D#l;o;u;x#S/D,x,xWl;J/J,JWG,L,SoLSQ,WxDo,e;W/J,SLJ,e,lD,x,xGJ;L/G,GxQQ,S,o;Q/GDQo,Lo,S,lQWGu;G/L,lQ,o,xSJQG;D/WJJQ,oG,xG");
//        //CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;O;T;A;K;V#c;g;h;s;t#S/gAVA,tOKh;O/A,SsOAO,T,V,e,tVVO;T/A,KTVK,e;A/AThO,K,OSc,S,SOKt,TtTOs;K/A,AgTSs,V,e,gOOO;V/KVKK,cTA");
//        //CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;R;X;A;C#d;l;n;o#S/Xo,nRXlX,nSoS;R/A,CX,X,e,lCS,lXXXo;X/A,AdRX,dCR,e;A/X,XR,e,nCd;C/CoAo,n,nR");
//		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;F;C;N;L;A;K#a;j;k;p;s#S/AAL,SLSKS,a,kL;F/A,C,CAAC,FjA,L,jFAj;C/LC,N,e,jCjNS,s;N/K,KLp,LNa,S,kNK;L/F,KCa,LCF,e,sK;A/CpFpF,aKsNK,j;K/AsSaF,FF");
//		System.out.println(cfgEpsUnitElim.contextFreeGrammar);
//        cfgEpsUnitElim.eliminateEpsilonRules();
//		//cfgEpsUnitElim.eliminateUnitRules();
//        System.out.println("final");
//		System.out.println(cfgEpsUnitElim.contextFreeGrammar);
//		//System.out.println(cfgEpsUnitElim.toString());
//	}
}
