package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

//Question: https://code.google.com/codejam/contest/6254486/dashboard#s=p1

public class RevengeOfThePancakes {
	private Integer index;
	HashMap<Character, List<Integer>> T9Map= new HashMap<Character, List<Integer>>();
	BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
	static int count=1;
	
	
	
	public void testcases() throws NumberFormatException, IOException{
		index= Integer.parseInt(reader.readLine());
		while(index != 0){
			testcase();
			index--;
		}
	}

	public void testcase() throws IOException{
	
		StringBuilder line= new StringBuilder(reader.readLine());
		Integer flips= 0;
		//line -> --+-+ --> +++++
		for(int i=0; i<line.length(); i++){
			
			
		}
		
		
	
		System.out.println("Case #" +count+ ": " +flips);
		count++;
	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		RevengeOfThePancakes tests= new RevengeOfThePancakes();
		Long start= System.currentTimeMillis();
		tests.testcases();	
		Long end=  System.currentTimeMillis();
		System.out.println(end-start);
	}
}