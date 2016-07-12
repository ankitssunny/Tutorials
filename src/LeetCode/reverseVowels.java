package LeetCode;

//Question: https://leetcode.com/problems/reverse-vowels-of-a-string/

import java.util.ArrayList;

public class reverseVowels {

	public String reverse(String s) {
		int len= s.length();
		char[] chars= s.toCharArray();
		ArrayList<Character> vowels= new ArrayList<Character>();
		StringBuilder word = new StringBuilder();

		for(int i = 0; i < len; i++){
			switch(chars[i]){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
				vowels.add(chars[i]);
				break;
			}
		}

		int k= vowels.size() -1;
		for(int i = 0; i < len; i++){
			switch(chars[i]){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
				word.append(vowels.get(k));
				k--;
				break;
			default:
				word.append(chars[i]);
			}   
		}
		System.out.println(word.toString());
		return word.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		reverseVowels rv= new reverseVowels();
		rv.reverse("leetcode");
	}

}
