/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) 
	{
		String new1 = preProcess(str1);
		String new2 = preProcess(str2);
		boolean flag = true;
		if (new1.length() != new2.length())
		{
			flag = false;
			return flag;
		}
		for (int i = 0; i < new1.length(); i++)
		{
			for (int j = 0; j < new2.length(); j++)
			{
				if (new1.charAt(i) == new2.charAt(j)) 
				{
					flag = true;
					new2 = removeCharAt(new2, j);
					break;
				}
				else 
				{
					flag = false;
				}
			}
			if (flag == false) 
			{
				return flag;
			}
		}
		return flag;
	}

	public static String removeCharAt (String s, int i)
	{
		return s.substring(0, i) + s.substring(i + 1);
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) 
	{
		String newStr = "";
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i ++)
		{
			if (Character.isLetter(str.charAt(i))) 
			{
				newStr += str.charAt(i);	
			}
		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) 
	{
		int index;
		String newStr = "";
		while (str.length() != 0) 
		{
			index = (int)(Math.random() * str.length());
			newStr += str.charAt(index);
			str = removeCharAt(str, index);
		}
		return newStr;
	}
}
