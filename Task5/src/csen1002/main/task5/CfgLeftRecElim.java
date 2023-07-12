package csen1002.main.task5;
import java.util.*;

/**
 * Write your info here
 * 
 * @name Mariam Wael
 * @id 46-1356
 * @labNumber 21
 */

public class CfgLeftRecElim {

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
	HashMap<String, String> newAddedContextFreeGrammar = new LinkedHashMap<>();

	ArrayList<String> alphas = new ArrayList<String>();
	ArrayList<String> betas = new ArrayList<String>();



	public CfgLeftRecElim(String cfg) {
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
		output+=rules +";";
		Object [] x = (newAddedContextFreeGrammar.keySet()).toArray();
		for (int  i = 0 ; i<(newAddedContextFreeGrammar.keySet()).size(); i++){
			if(i<(((newAddedContextFreeGrammar.keySet()).size())-1)){
				output += x[i] + ";";
			}
			else
				output +=x[i]+"#";
		}
		output+=alphabets+"#";
		Set<String> keysOfNormal = contextFreeGrammar.keySet();
		for (String key : keysOfNormal){
			output+= contextFreeGrammar.get(key)+";";
		}

		output = output.substring(0,output.length()-1) + ";";

		Set<String> keysOfDashed = newAddedContextFreeGrammar.keySet();
		for (String key : keysOfDashed){
			output+= newAddedContextFreeGrammar.get(key)+";";
		}
		reInitialize();
		return output.substring(0,output.length()-1);
	}

	/**
	 * Eliminates Left Recursion from the grammar
	 */
	public void eliminateLeftRecursion() {
		// TODO Auto-generated method stub
		contextFreeGrammar.forEach((key, value) -> {
			int whereIsTheKey = findIndexOfKey(key);
			if(whereIsTheKey > 0){
				String newValue = checkAndPreformProduction(key,value,whereIsTheKey);
				contextFreeGrammar.put(key,newValue);
			}
			checkAndPerformImmediate(key,(contextFreeGrammar.get(key)));
		});
	}

	public void checkAndPerformImmediate(String key, String value){
		String rulesValues = value.split("/")[1];
		String [] rulesValuesAsArray = rulesValues.split(",");

		String normalOutput = "";
		String dashedOutput = "";
		String dashedKey = key + "'";

		for (int i =0; i<rulesValuesAsArray.length; i++){
			String firstCharacterInCurrentRule = rulesValuesAsArray[i].charAt(0)+"";
			if(firstCharacterInCurrentRule.equals(key)){
				String shouldBeAddedToAlphas = (rulesValuesAsArray[i]).substring(1);
				alphas.add(shouldBeAddedToAlphas);
				continue;
			}
			betas.add(rulesValuesAsArray[i]);
		}

		if(!(alphas.isEmpty())){
			dashedOutput += dashedKey + "/";
			for (int j = 0; j<alphas.size(); j++)
				dashedOutput+= alphas.get(j)+dashedKey + ",";
			dashedOutput+="e";
			newAddedContextFreeGrammar.put(dashedKey,dashedOutput);
			normalOutput +=key + "/";
			for (int k = 0; k<betas.size(); k++)
				normalOutput+= betas.get(k) + dashedKey +",";
			normalOutput = normalOutput.substring(0,normalOutput.length()-1);
			contextFreeGrammar.put(key,normalOutput);
		}
		alphas = new ArrayList<String>();
		betas = new ArrayList<String>();
	}

	public String checkAndPreformProduction(String key, String value, int whereIsTheKey){
		Object [] x = (contextFreeGrammar.keySet()).toArray();
		String rulesValues = value.split("/")[1];
		String [] rulesValuesAsArray = rulesValues.split(",");

		List<String> rulesValuesAsArrayList = Arrays.asList(rulesValuesAsArray);



		boolean performProductionAgain = false;


		ArrayList<String> tempOutput = new ArrayList<String>(rulesValuesAsArrayList);

		do{
			if(performProductionAgain) {
				performProductionAgain = false;
				rulesValuesAsArrayList = new ArrayList<>();
				String [] tem;
				for (String item : tempOutput) {
					if (item.contains(",")) {
						tem = item.split(",");
						List<String> temp = Arrays.asList(tem);
						rulesValuesAsArrayList.addAll(temp);
						continue;
					}
					rulesValuesAsArrayList.add(item);
				}
				tempOutput = new ArrayList<String>(rulesValuesAsArrayList);
			}
			for (int i = 0; i<whereIsTheKey;i++){
				String currentKey = (String) x[i];
				for(int j = 0; j<rulesValuesAsArrayList.size();j++){
					String firstCharacterInCurrentRule = (rulesValuesAsArrayList.get(j)).charAt(0)+"";
					if(firstCharacterInCurrentRule.equals(currentKey)){
						String valueShouldReplacedWith = (contextFreeGrammar.get(currentKey));
						String temp = replaceFirstCharacters((rulesValuesAsArrayList.get(j)),valueShouldReplacedWith);
						tempOutput.set(j,temp);
						if(fistLetterIsFromRules(temp,whereIsTheKey))
							performProductionAgain = true;
					}
				}
			}
		}while (performProductionAgain);


		String output = key + "/";

		for (int l = 0 ; l<tempOutput.size(); l++)
			output+=tempOutput.get(l) + ",";
		return output.substring(0,output.length()-1);

	}

	public boolean fistLetterIsFromRules(String newRule, int whereIsTheKey){
		String [] rulesAsList = rules.split(";");
		for(int i = 0; i<whereIsTheKey; i++){
			if(!(newRule.contains(","))) {
				if ((newRule.charAt(0) + "").equals(rulesAsList[i]))
					return true;
			}
			else{
				String [] temp = newRule.split(",");
				for(int j = 0; j<temp.length; j++){
					if ((temp[j].charAt(0) + "").equals(rulesAsList[i]))
						return true;
				}
			}
		}
		return false;
	}

	public String replaceFirstCharacters(String ruleThatShouldBeChanged,String rulesThatShouldBeReplacedWith){
		String rulesShouldBeReplaced = rulesThatShouldBeReplacedWith.split("/")[1];
		String [] rulesShouldBeReplacedAsArray = rulesShouldBeReplaced.split(",");
		String output = "";
		for(int i = 0; i<rulesShouldBeReplacedAsArray.length; i++) {
			output += ruleThatShouldBeChanged.replaceFirst((ruleThatShouldBeChanged.charAt(0) + ""), rulesShouldBeReplacedAsArray[i]) + ",";
		}
		return output.substring(0,output.length()-1);
	}

	public int findIndexOfKey(String Key){
		Object [] x = (contextFreeGrammar.keySet()).toArray();
		for(int i = 0; i<(contextFreeGrammar.keySet()).size();i++){
			if(x[i].equals(Key))
				return i;
		}
		return -1;
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
		newAddedContextFreeGrammar = new LinkedHashMap<>();
		alphas = new ArrayList<String>();
		betas = new ArrayList<String>();
	}


//	public static void main(String[]args){
//		//CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;Z;J;O;X#b;k;q;t;z#S/SXbX,z;Z/XJXO,XOz,XzJbO,bOzZ,bZq,q;J/JSkZ,Jb,Oz,XkZb,bZSO,zXZJO;O/OZkJk,SJJ,SJtO,qJJJO,tOzXt;X/OkS,SJXkZ,StZO,XJ,XzJq,kXtXZ");
//		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;G;V;D;A#k;v;w#S/SVD,SkDkV,VGwAw;G/VSVD,vGVG,wGGGv;V/AS,AwDwD,vAwD;D/ASS,GwSA,SkS,vVVw;A/AASSD,ASvAV,DvSSS,VvGS,vVVA,w");
//
//		cfgLeftRecElim.eliminateLeftRecursion();
//		System.out.println(cfgLeftRecElim.toString());
//	}
}
