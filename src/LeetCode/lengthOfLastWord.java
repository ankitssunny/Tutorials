package LeetCode;

// Question: https://leetcode.com/problems/length-of-last-word/
public class lengthOfLastWord {
	
	public int lengthOfLastWords(String s) {
		//Lesson here there is a difference between "" and .equals(""). ==  is matching two different objects whereas equals is matching two different instaces of the object.
		if(s == ""  || s == null || s.equals(""))
			return 0;
		
		StringBuilder str = new StringBuilder(s);
		str.reverse();
		
		
		if(str.charAt(0) == ' ')
			return 0;

		int count = 0;
		for(int i = 0; i < s.length(); i++){
			if(str.charAt(i) == ' '){
			System.out.println(count);
				return count;
			}
			else 
				count++;
		}
		System.out.println(s.length());
		return s.length();
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		lengthOfLastWord rv= new lengthOfLastWord();
		rv.lengthOfLastWords("leetcode is a nice website");
		rv.lengthOfLastWords("");
		
		
	}

}
