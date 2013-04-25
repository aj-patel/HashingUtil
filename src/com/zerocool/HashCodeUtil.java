package com.zerocool;

public class HashCodeUtil {
	
	//This array variable holds randomly generated integer for each character.
	static private int asciiValues[] = new int[122];
	
	static private int multiplier = 0;
	
	static private int divident = 0 ;
	
	//This block is a called for initializing the required parameters on class loading.
	static{
		init();
	}
	

	/***
	 * This method is used for initialization.
	 */
	static private final void init(){
		Random random = new Random();
		for(int i=0;i<asciiValues.length;i++){
			asciiValues[i]=random.nextInt(20000000);
		}
		multiplier = random.nextInt(1000);
		divident = random.nextInt(100);
		
	}
	
	/***
	 * 
	 * @param string
	 * @return int
	 * Internal Method having the logic for calculating the hashcode
	 */
	static private int getHashCodeInternal(String string){
		char[] stringToChar = string.toCharArray();
		int hashCode= 0;
		for (int i =0;i<stringToChar.length;i++) {
			hashCode = hashCode + asciiValues[stringToChar[i]]+stringToChar[i]*i;
		}
			hashCode = (hashCode*multiplier)/divident;
		return Math.abs(hashCode+stringToChar.length);
	}
	
	
	/***
	 * 
	 * @param string
	 * @return hashCode of the string passed as parameter
	 * This API is used for getting the hashcode of String passed as parameter.
	 */
	static public int getHashCode(String string){
		
		return getHashCodeInternal(string);
	}
	
	

}
