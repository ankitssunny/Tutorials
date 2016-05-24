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
		//line -> --+-+ --> +++++ --> 3 i.e. least number of flips requires to make all plus or happy
		Character first= line.charAt(0);
		while(line.length() > 1){
			if(first == line.charAt(1)){
				line= new StringBuilder(line.substring(1, line.length()));
				first= line.charAt(0);
				//System.out.println("Flips inside if:+ "+ flips);
			}else{
				flips++;
				// --+- -> ++-
				//System.out.println("Flips inside else:+ "+ flips);
				line= new StringBuilder(line.charAt(1) + line.substring(1, line.length()));
				first= line.charAt(0);
			}
			//System.out.println(line.toString());
		}

		if(line.charAt(0) == '-')
			flips++;
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