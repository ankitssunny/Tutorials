package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class CountingSheep {

	private Integer index;
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
	
		Integer line= Integer.parseInt(reader.readLine());
		Integer i= 1;
		Integer temp= null, last;
		HashSet<Integer> digits= new HashSet<Integer>();

		
		//line : 1 -> 10
		//line : 0 -> INSOMNIA
		if(line == 0)
			System.out.println("Case #" +count+ ": INSOMNIA");
		else{
			do{
				temp= line * i;	
				last= temp;
				i++;
				while(temp > 0){
					Integer digit= temp %10;
					digits.add(digit);
					temp/=10;
				}
			} while(digits.size() != 10);		
			System.out.println("Case #" +count+ ": " +last);
		}
		count++;
	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		CountingSheep tests= new CountingSheep();
		Long start= System.currentTimeMillis();
		tests.testcases();	
		Long end=  System.currentTimeMillis();
		System.out.println(end-start);
	}
}
