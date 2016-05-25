package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Question: https://code.google.com/codejam/contest/6254486/dashboard#s=p2
import java.util.List;

public class CoinJam {

	private Integer index;
	BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
	static int count=1;	
	private StringBuilder curr;
	private StringBuilder max;
	private List<Integer> interpretations, nonTrivialDivisors;
	
	
	public void testcases() throws NumberFormatException, IOException{
		index= Integer.parseInt(reader.readLine());
		while(index != 0){
			testcase();
			index--;
		}
	}

	
	public void testcase() throws IOException{
		System.out.println("Case #" +count+ ":");
		String line= reader.readLine();
		// 6 3 => 100011 5 13 147 31 43 1121 73 77 629
		String[] nums= line.split(" ");
 		int n= Integer.parseInt(nums[0]);
		int j= Integer.parseInt(nums[1]);
		curr= new StringBuilder("1"); 
		max= new StringBuilder("1");
		for(int i=1; i<n; i++){
			curr.append("0");
			max.append("1");
		}
		
		while(j != 0){
			
			if(startsAndEndsWithOne() &&  findInterpretations()){
				/// Print the jamcoin 
				findNonTrivialDivisors();
				for(int i=0; i< nonTrivialDivisors.size(); i++)
					System.out.print(nonTrivialDivisors.get(0) + " ");
				j--;	
			}	
			
			// Find interpretations of next number
			interpretations= null;
			nonTrivialDivisors= null;
			// have to figure out a way to increment curr and check if it is less than max.
		}		
		count++;
	}
	
	
	public void findNonTrivialDivisors(){
	
		for(int i=0; i<interpretations.size(); i++){
			int num= interpretations.get(i);
			for(int j=1 ; j <= num/2 ; j++){
				if(j % num == 0){
					nonTrivialDivisors.add(j);
					break;
				}
			}
		}
	}
	
	
	public boolean findInterpretations(){
		int baseStart= 2;
		int baseEnd= 10;
		while(baseStart <= baseEnd){
			int number=Integer.parseInt(curr.toString(), baseStart); 
			if(prime(number))
				return false;
			else{
				interpretations.add(number);
				baseStart++;
			}
		}
		return true;
	}

	
	public boolean startsAndEndsWithOne(){
		// first check that the string ends and starts with 1
		if(curr.charAt(0) == '1' && curr.charAt(curr.length()-1) == 1)
			return true;		
		else return false;	
	}
	
	
	public boolean prime(Integer num){
		int c=0;
		for (int i= 1; i<= num; i++){
			if( num % i == 0 )
				c++;
		}
		if( c > 2) return false;
		else return true;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		CoinJam tests= new CoinJam();
		Long start= System.currentTimeMillis();
		tests.testcases();	
		Long end=  System.currentTimeMillis();
		System.out.println(end-start);
	}
}