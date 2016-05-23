package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class T9Spelling {
	private Integer index;
	HashMap<Character, List<Integer>> T9Map= new HashMap<Character, List<Integer>>();
	BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
	static int count=1;
	
	public void buildT9(){
		int T9, occurence=1;
		float c= 0;
		for(int i=97; i<=122; i++){
			if(c/3 < 1)
				T9= 2; //012
			else if(1 <= c/3 && c/3 < 2)
				T9= 3;//345
			else if(2 <= c/3 && c/3 < 3)
				T9= 4;//678
			else if(3 <= c/3 && c/3 < 4)
				T9= 5; //91011
			else if(4 <= c/3 && c/3 < 5)
				T9= 6;//121314
			else if(5 <= c/3 && c/3 <= 6)
				T9= 7;//15161718
			else if(6 < c/3 && c/3 <= 7)
				T9= 8;//192021
			else
				T9= 9;			 
		
		T9Map.put((char) i, Arrays.asList(T9, occurence));
		occurence++;
		if(occurence > 3 && T9 != 7 && T9 != 9)
			occurence= 1;
		else if(occurence > 4 && (T9 == 7 || T9 == 9))
			occurence= 1;
		c++;
		}
	}
	
	public void testcases() throws NumberFormatException, IOException{
		buildT9();
		/*for(Entry<Character, List<Integer>> entry: T9Map.entrySet()){
			char c= entry.getKey();
			System.out.println("Key: " +c);
			System.out.println("Value: " +entry.getValue().get(0));
			System.out.println("Occurences: "+entry.getValue().get(1));
		}*/
		index= Integer.parseInt(reader.readLine());
		while(index != 0){
			testcase();
			index--;
		}
	}

	public void testcase() throws IOException{
	
		String line= reader.readLine();
		StringBuilder T9=new StringBuilder();
		//line : hi -> 44 444
		Integer prev= null, curr=null, repeat;
		for(int i=0; i<line.length(); i++){
			Character current= line.charAt(i);
			if(current != ' '){
				curr= T9Map.get(current).get(0);
				repeat= T9Map.get(current).get(1);
			}else{
				curr= 0;
				repeat= 1;
			}
			
			if(curr == prev)
				T9.append(" ");
			for(int j = 1; j <= repeat; j++)
				T9.append(curr);
			prev= curr;
		}
		System.out.println("Case #" +count+ ": " +T9);
		count++;
	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		T9Spelling rw= new T9Spelling();
		Long start= System.currentTimeMillis();
		rw.testcases();	
		Long end=  System.currentTimeMillis();
		System.out.println(end-start);
	}
}