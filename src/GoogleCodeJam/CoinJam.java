package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

//Question: https://code.google.com/codejam/contest/6254486/dashboard#s=p2

public class CoinJam {

	private Integer index;
	BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
	static int count=1;	
	private StringBuilder curr;
	private StringBuilder max;
	private ArrayList<Long> interpretations= new ArrayList<Long>();
	private ArrayList<Integer> nonTrivialDivisors= new ArrayList<Integer>();
	private HashSet<String> coinJam= new HashSet<String>();
	
	
	public void testcases() throws NumberFormatException, IOException{
		index= Integer.parseInt(reader.readLine());
		while(index != 0){
			testcase();
			index--;
		}
	}

	
	public void testcase() throws IOException{
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
		coinJam.add(curr.toString());
		Long maxToInt= (long) Integer.parseInt(max.toString(), 2);
		System.out.println("Case #" +count+ ":");
		while(j != 0){
			if(startsAndEndsWithOne() &&  findInterpretations()){
				findNonTrivialDivisors();
				String nonTrivialDivisorString="";
				for(int i=0; i< nonTrivialDivisors.size(); i++)
					nonTrivialDivisorString += nonTrivialDivisors.get(i).toString() + " ";
				System.out.println(curr.toString()+ " " +nonTrivialDivisorString);
				j--;	
			}	
			
			interpretations= new ArrayList<Long>();
			nonTrivialDivisors= new ArrayList<Integer>();
			Long currToInt=(long) (Integer.parseInt(curr.toString(), 2) + 1);
			curr= toBinary(currToInt);
			while (currToInt < maxToInt && coinJam.contains(curr)){
				currToInt=(long) (Integer.parseInt(curr.toString(), 2) + 1);
				curr= toBinary(currToInt);
				System.out.println("Inside while");
			}
			coinJam.add(curr.toString());
		}
		count++;
	}
	
	
	public StringBuilder toBinary(Long currToInt){
		StringBuilder newcurr= new StringBuilder();
		Long i;
		while(currToInt > 0){
			i= currToInt % 2;
			newcurr.append(i.toString());
			currToInt /= 2; 
		}
		newcurr.reverse();
		return newcurr;
	}
	
	
	public void findNonTrivialDivisors(){
	
		for(int i=0; i<interpretations.size(); i++){
			Long num= interpretations.get(i);
			for(int j=2 ; j <= num/2 ; j++){
				if(num % j == 0){
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
			System.out.println(curr.toString());
			Long number=(long) Integer.parseInt(curr.toString(), baseStart); 
			System.out.println(number);
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
		if(curr.charAt(0) == '1' && curr.charAt(curr.length()-1) == '1')
			return true;		
		else	return false;	
	}
	
	
	public boolean prime(Long number){
		int c=0;
		for (int i= 1; i<= number; i++){
			if( number % i == 0 )
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